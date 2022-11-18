package tpe;

import java.util.Comparator;

import tpe.comparadores.CompGrupo;
import tpe.composite.*;

public class Main_tres {
    public static void main(String[] args) {

        Comparator <GruposAlum> compGrupo = new CompGrupo();

        //Estructura unicen
        Alumno a1 = new Alumno("flora", "rivas", 20, 34555111);
        a1.addPc("historia");
        a1.addPc("antiguo");

        Alumno a2 = new Alumno("martin", "gomez", 21, 34111222);
        a2.addPc("romanos");
        a2.addPc("egipcios");
        a2.addPc("griegos");


        Alumno a3 = new Alumno("roman", "bazan", 23, 32555111);
        a3.addPc("argentina");

        GruposAlum grupo1 = new GruposAlum("historia");
        grupo1.addElem(a1);
        grupo1.addElem(a2);
        grupo1.addElem(a3);

        Alumno a4 = new Alumno("mora", "diaz", 19, 37124425);
        a4.addPc("psicologia");
        a4.addPc("freud");

        GruposAlum grupo2 = new GruposAlum("humanas");
        grupo2.addElem(a4);
        grupo2.addElem(grupo2);

        Alumno a5 = new Alumno("federico", "lopez", 23, 35999888);
        a5.addPc("redes");
        a5.addPc("php");
        a5.addPc("java");
        a5.addPc("python");

        Alumno a6 = new Alumno("juana", "garcia", 23, 27123455);
        a6.addPc("programacion");
        a6.addPc("php");
        a6.addPc("java");

        GruposAlum grupo3 = new GruposAlum("exactas");
        grupo3.addElem(a5);
        grupo3.addElem(a6);


        Alumno a7 = new Alumno("john", "doe", 30, 1200000);
        a7.addPc("intercambio");

        GruposAlum grupo4 = new GruposAlum("Unicen");
        grupo4.addElem(grupo2);
        grupo4.addElem(grupo3);
        grupo4.addElem(a7);

        //Estructura olimpiadas
        Alumno a8 = new Alumno("Bernardino", "Rivas", 20, 30987654);
        a8.addPc("matematicas");

        Alumno a9 = new Alumno("Jose", "Paso", 21, 33322112);
        a9.addPc("problemas");

        Alumno a10 = new Alumno("Isaac", "Newton", 18, 12343565);
        a10.addPc("sucesiones");
        
        GruposAlum grupo5 = new GruposAlum("losFibo");
        grupo5.addElem(a8);
        grupo5.addElem(a9);
        grupo5.addElem(a10);

        Alumno a11 = new Alumno("Juan", "Suarez", 25, 33222444);
        a11.addPc("Suceciones");
        a11.addPc("Algebra");

        Alumno a12 = new Alumno("Julio", "Cesar", 22, 33222111);
        a12.addPc("Suceciones");
        a12.addPc("Algebra");

        GruposAlum grupo6 = new GruposAlum("mateA2");
        grupo6.addElem(a11);
        grupo6.addElem(a12);


        GruposAlum grupo7 = new GruposAlum("Olimpiadas Matematicas");
        grupo7.addElem(grupo5);
        grupo7.addElem(grupo6);

        //Lista
        Lista <GruposAlum> list = new Lista<>(compGrupo);
        list.addOrdenado(grupo7);
        list.addOrdenado(grupo4);

        for (GruposAlum grup : list) {
            System.out.println(grup);
        }


    }
}
