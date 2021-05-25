package com.learn.reactivespring.flux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class FluxAndManoTest {

    @Test
    public void fluxTest(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring");

        stringFlux.subscribe(System.out::println);
    }
}
