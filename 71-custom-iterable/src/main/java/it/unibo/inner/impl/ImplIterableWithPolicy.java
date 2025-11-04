package it.unibo.inner.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import it.unibo.inner.api.IterableWithPolicy;
import it.unibo.inner.api.Predicate;

public class ImplIterableWithPolicy<T> implements IterableWithPolicy<T>{
    private List<T> elements = new ArrayList<>(); 
        
    public ImplIterableWithPolicy(T[] elements) {
            this.elements = List.of(elements);
    }

    public void setIterationPolicy(Predicate<T> filter){
        //empty for now 
    }
    //inner class: classe innestata -> T lo eredita dal tipo per cui è stata definita la classe outer
    public class ImplIterator implements Iterator<T>{ 
        private int curr;
        
        public ImplIterator(){
            this.curr = 0;
        }

        public boolean hasNext() {
            if(elements.size()> this.curr){
                return true;
            }
            return false;
        }

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