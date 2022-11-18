package tpe.composite;

import java.util.ArrayList;

public class GruposAlum extends Elem{
    private ArrayList<Elem> elems;


    public GruposAlum(String nombre) {
        super(nombre);
        elems = new ArrayList<>();
    }

    public void addElem(Elem e){
        elems.add(e);
    }

    @Override
    public int getCantAlum(){
        int suma = 0;
        for (Elem e : elems) {
            suma += e.getCantAlum();
        }
        return suma;
    }
    
    @Override
    public String toString() {
        return "Grupo [nombre=" + nombre + "]";
    }
}
