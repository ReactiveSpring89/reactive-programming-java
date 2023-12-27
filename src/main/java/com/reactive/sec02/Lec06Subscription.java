package com.reactive.sec02;

import com.reactive.utils.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {
    public static void main(String[] args) {
        AtomicReference<Subscription> subscriptionAtomicReference = new AtomicReference<>();
        Flux.range(1, 20)
                .log()
                .subscribeWith(new MySubscriber(subscriptionAtomicReference));

        Util.sleepSeconds(3);
        subscriptionAtomicReference.get().request(3);
        Util.sleepSeconds(5);
        subscriptionAtomicReference.get().request(3);
        Util.sleepSeconds(5);
        System.out.println("Going to cancel");
        subscriptionAtomicReference.get().cancel();
        Util.sleepSeconds(3);
        subscriptionAtomicReference.get().request(4);
    }

    static class MySubscriber implements Subscriber<Integer> {
        private AtomicReference<Subscription> subscriptionAtomicReference;
        public MySubscriber(AtomicReference<Subscription> subscriptionAtomicReference) {
            this.subscriptionAtomicReference = subscriptionAtomicReference;
        }

        @Override
        public void onSubscribe(Subscription subscription) {
            System.out.println("Received subscription : " + subscription);
            subscriptionAtomicReference.set(subscription);
        }

        @Override
        public void onNext(Integer integer) {
            System.out.println("On Next was Invoked : " + integer);
        }

        @Override
        public void onError(Throwable throwable) {
            System.out.println("onError : " + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            System.out.println("onComplete ");
        }
    }
}
