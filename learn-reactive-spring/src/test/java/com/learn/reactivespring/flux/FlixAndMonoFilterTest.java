package com.learn.reactivespring.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static reactor.core.scheduler.Schedulers.parallel;

public class FlixAndMonoFilterTest {

    List<String> names = Arrays.asList("hi", "hello","bye","tata");

    @Test
    public void filterTest(){
        Flux<String> namesFlux = Flux.fromIterable(names)
                .filter(s -> s.startsWith("h"))
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("hi","hello")
                .verifyComplete();
    }

    @Test
    public void filterLengthTest(){
        Flux<String> namesFlux = Flux.fromIterable(names)
                .filter(s -> s.length() > 3)
                .log();

        StepVerifier.create(namesFlux)
                .expectNext("hello","tata"
                )
                .verifyComplete();
    }

    @Test
    public void transformUsingMap(){
        Flux<String> nameFlux = Flux.fromIterable(names)
                .map(s -> s.toUpperCase())
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("HI","HELLO","BYE","TATA")
                .verifyComplete();
    }

    @Test
    public void transformUsingMap_Length(){
        Flux<Integer> nameFlux = Flux.fromIterable(names)
                .map(s -> s.length())
                .log();

        StepVerifier.create(nameFlux)
                .expectNext(2,5,3,4)
                .verifyComplete();
    }

    @Test
    public void transformUsingMap_Length_Repeat(){
        Flux<Integer> nameFlux = Flux.fromIterable(names)
                .map(s -> s.length())
                .repeat(1)
                .log();

        StepVerifier.create(nameFlux)
                .expectNext(2,5,3,4,2,5,3,4)
                .verifyComplete();
    }

    @Test
    public void transformUsingMap_Filter(){
        Flux<String> nameFlux = Flux.fromIterable(names)
                .filter(s -> s.length() > 4)
                .map(s -> s.toUpperCase())
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("HELLO")
                .verifyComplete();
    }

    @Test
    public void transformUsingFlatMap(){
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F"))
                .flatMap(s -> {
                    return Flux.fromIterable(convertToList(s));
                })
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();
    }

    private List<String> convertToList(String s) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList(s,"newValue");
    }

    @Test
    public void transformUsingFlatMap_Parallel(){
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F"))
                .window(2)
                .flatMap((s) ->
                        s.map(this::convertToList).subscribeOn(parallel()))
                .flatMap(s -> Flux.fromIterable(s))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    public void transformUsingFlatMap_Parallel_MaintainOrder(){
        Flux<String> stringFlux = Flux.fromIterable(Arrays.asList("A","B","C","D","E","F"))
                .window(2)
                /*.concatMap((s) ->
                        s.map(this::convertToList).subscribeOn(parallel()))*/
                .flatMapSequential((s) ->
                        s.map(this::convertToList).subscribeOn(parallel()))
                .flatMap(s -> Flux.fromIterable(s))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(12)
                .verifyComplete();
    }

}
