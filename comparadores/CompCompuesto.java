package tpe.comparadores;

import java.util.Comparator;

import tpe.composite.Alumno;

public abstract class CompCompuesto implements Comparator <Alumno>{
    private CompCompuesto next;

    public CompCompuesto(){}
    public CompCompuesto(CompCompuesto next){
        this.next = next;
    }

    public abstract int comparar(Alumno o1, Alumno o2);

    @Override
    public int compare(Alumno o1, Alumno o2) {
        int aux = this.comparar(o1, o2);
        if (aux == 0 && next != null) {
            return next.compare(o1, o2);
        }
        return aux;
    }
    
}
