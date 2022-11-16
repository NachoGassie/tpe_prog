package tpe.comparadores;

import java.util.Comparator;

public class CompInverso <T> implements Comparator <T>{
    private Comparator <T> comp;

    public CompInverso(Comparator<T> comp) {
        this.comp = comp;
    }

    @Override
    public int compare(T o1, T o2) {
        return comp.compare(o1, o2)*-1;
    }
    
}
