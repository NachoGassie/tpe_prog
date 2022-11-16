package tpe.comparadores;

import tpe.composite.Alumno;

public class CompAlumEdad extends CompCompuesto{

    @Override
    public int comparar(Alumno o1, Alumno o2) {
        return o1.getEdad() - o2.getEdad();
    }
    
}
