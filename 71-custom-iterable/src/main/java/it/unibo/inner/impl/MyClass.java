package it.unibo.inner.impl;

import java.util.Iterator;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class MyClass<T> implements IterableWithPolicy<T>{
    private T[] elements; 
    public MyClass(T[] elements) {
        this.elements = elements;
    }
    public void setIterationPolicy(Predicate<T> filter){
        
    }
    
}
