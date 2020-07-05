package com.example.demo.builders;

public interface BaseBuilder<S,T, E> {
    S build(T t, E e);
}
