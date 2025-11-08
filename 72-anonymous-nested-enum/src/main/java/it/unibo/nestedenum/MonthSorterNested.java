package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Comparator;
//import java.util.Locale;
//import java.util.Objects;
import java.util.List;
//import java.util.stream.Collectors;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {
    public static final int TRENT = 30;
    public static final int TRENTUNO = 31;
    public static final int VENTOTTO = 28;
    public enum Month {
        JANUARY(31), 
        FEBRUARY(28), 
        MARCH(31), 
        APRIL(30),
        MAY(31), 
        JUNE(30), 
        JULY(31), 
        AUGUST(31),
        SEPTEMBER(30), 
        OCTOBER(31), 
        NOVEMBER(30), 
        DECEMBER(31);
        
        private final int days;

        private Month(final int days){
            if(days != TRENT && days != TRENTUNO && days != VENTOTTO){
                throw new IllegalArgumentException("The number is not valid");
            }
            this.days = days;
        }
        public int getDays(){
            return this.days;
        }
        
        public static Month fromString(String input){
            if (input == null) {
                throw new NullPointerException();
            }
            List<Month> listMonth = new ArrayList<>();
            String monthLower = input.trim().toLowerCase();
            

            for (Month m : Month.values()) {
                if(m.toString().toLowerCase().startsWith(monthLower)){
                    listMonth.add(m);
                }
            }
            if (listMonth.size()==1){
                return listMonth.get(0);
            }
            throw new IllegalArgumentException("Argument not valid");
        }
    }
    static class SortByDate implements Comparator<String>{
        public int compare(final String m1, final String m2){
            return Integer.compare(Month.fromString(m1).getDays(), Month.fromString(m2).getDays());
        } 
    }
    
    static class SortByMonthOrder implements Comparator<String>{
        public int compare(final String m1, final String m2){
            return Month.fromString(m1).compareTo(Month.fromString(m2));
        } 
    }
    /*
    * comparatore che ordina delle stringhe
    * (interpretandole come mesi) in base al loro ordine nell'anno
    */    
    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }
    /*
    * comparatore che le ordina invece in base al numero
    * di giorni che il mese ha.
    */
    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
}
}

