package tpe;

import tpe.comparadores.*;
import tpe.composite.Alumno;

public class Main {
    public static void main(String[] args) {
        CompAlumEdad c = new CompAlumEdad();
        // CompDni com = new CompDni();

        Lista <Alumno> list = new Lista<>(c);

        Alumno p1 = new Alumno<>(5, 10);
        Alumno p2 = new Alumno<>(10,5);
        Alumno p3 = new Alumno<>(7,1);
        Alumno p4 = new Alumno<>(15, 11);

        list.addOrd(p1);
        list.addOrd(p3);
        list.addOrd(p2);
        list.addOrd(p4);

        //ForEach
        for (Alumno a : list) {
            System.out.println(a);
        }

        // System.out.println("");
        // list.showNodo();

        System.out.println("");
        
        //Anda
        // list.setC(new CompInverso<>(c));

        list.eliminarOcurrencia(p1);


        for (Alumno a : list) {
            System.out.println(a);
        }

    }
}
