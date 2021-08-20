package com.learn.reactivespring.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndManoFactoryTest {

    List<String> names = Arrays.asList("hi", "hello","bye","tata");

    @Test
    public void fluxUsingIterable(){
        Flux<String> nameFlux = Flux.fromIterable(names)
                .log();

        StepVerifier.create(nameFlux)
                .expectNext("hi", "hello","bye","tata")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray(){
        String[] names = new String[]{"hi", "hello","bye","tata"};

        Flux<String> nameFlux = Flux.fromArray(names);

        StepVerifier.create(nameFlux)
                .expectNext("hi", "hello","bye","tata")
                .verifyComplete();
    }

    @Test
    public void fluxUsingStream(){

        Flux<String> namesFlux = Flux.fromStream(names.stream());

        StepVerifier.create(namesFlux)
                .expectNext("hi", "hello","bye","tata")
                .verifyComplete();
    }

    @Test
    public void monoUsingJustOrEmpty(){

        Mono<String> mono = Mono.justOrEmpty(null);//Mono.Empty();

        StepVerifier.create(mono.log())
                .verifyComplete();
    }

    @Test
    public void monoUsingSupplier(){
        Supplier<String> stringSupplier = () -> "Hi";
        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);
        System.out.println(stringSupplier.get());
        StepVerifier.create(stringMono.log())
                .expectNext("Hi")
                .verifyComplete();
    }

    @Test
    public void fluxUsingRange(){
        Flux<Integer> integerFlux = Flux.range(1,5).log();

        StepVerifier.create(integerFlux)
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }
}
