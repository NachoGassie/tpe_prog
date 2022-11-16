package tpe.comparadores;

import java.util.Comparator;

import tpe.composite.Alumno;

public class CompDni implements Comparator <Alumno>{

    @Override
    public int compare(Alumno o1, Alumno o2) {
        return (int) (o1.getDni() - o2.getDni());
    }
    
}
