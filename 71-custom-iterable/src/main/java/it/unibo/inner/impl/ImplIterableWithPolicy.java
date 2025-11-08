package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class ImplIterableWithPolicy<T> implements IterableWithPolicy<T>{
    private List<T> elements = new ArrayList<>(); 
    private Predicate<T> filter;
    /* Parte 1
    public ImplIterableWithPolicy(T[] elements) {
            this.elements = List.of(elements);
    }
    */
    public ImplIterableWithPolicy(final T[] elements){
        this(elements, new Predicate<T>() {
            public boolean test(T elem){
                return true;
            }
        });
    }
    /*
     * Implement the `setIterationPolicy` method so that it sets the `Predicate<T>` 
     * that will be used to filter the elements during the iteration.
     */
    public void setIterationPolicy(final Predicate<T> filter){
        this.filter = filter;
    }
    /*
     * Add a new constructor to the newly created class that takes two arguments: an array of `T` 
     * elements and a `Predicate<T>` that will be used to filter the elements during the iteration.
     */
    public ImplIterableWithPolicy(final T[] elements, final Predicate<T> filter) {
        this.elements = List.of(elements);
        this.filter = filter;
    }
    //inner class: classe innestata -> T lo eredita dal tipo per cui è stata definita la classe outer
    public class ImplIterator implements Iterator<T>{ 
        private int curr;
        
        public ImplIterator(){
            this.curr = 0;
        }

        @Override
        public boolean hasNext() {
            while(elements.size() > this.curr){
                if(filter.test(elements.get(curr))){
                    return true;
                }
                curr++;
            }
            return false;
        }

        @Override
        public T next() {
            if(hasNext()){
                return elements.get(curr++);
            }else{
                throw new NoSuchElementException();
            }
        }
    }

    public Iterator<T> iterator(){
        return new ImplIterator();
    }    
}