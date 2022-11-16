package tpe.composite;

import java.util.ArrayList;

public class GruposAlum extends Elem{
    private ArrayList<Elem> elems;


    public GruposAlum() {
        elems = new ArrayList<>();
    }

    public void addAlum(Elem e){
        elems.add(e);
    }

    public int getCantAlum(){
        int suma = 0;
        for (Elem e : elems) {
            suma += e.getCantAlum();
        }
        return suma;
    }
}
