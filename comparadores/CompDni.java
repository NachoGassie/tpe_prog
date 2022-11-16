package tpe.comparadores;

import tpe.composite.Alumno;

public class CompDni extends CompCompuesto{

    @Override
    public int comparar(Alumno o1, Alumno o2) {
        return (o1.getDni() - o2.getDni());
    }
    
}
