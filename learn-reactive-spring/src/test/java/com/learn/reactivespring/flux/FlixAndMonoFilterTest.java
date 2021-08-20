package com.learn.reactivespring.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

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
                .expectNext("hello","tata")
                .verifyComplete();
    }
}
