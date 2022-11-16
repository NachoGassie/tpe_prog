package tpe.comparadores;

import java.util.Comparator;

import tpe.composite.Alumno;

public class CompAlumEdad implements Comparator <Alumno>{

    @Override
    public int compare(Alumno o1, Alumno o2) {
        return o1.getEdad() - o2.getEdad();
    }
    
}
