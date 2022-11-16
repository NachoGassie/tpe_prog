package tpe.comparadores;

import java.util.Comparator;
import tpe.composite.*;

public class CompGrupo implements Comparator <GruposAlum>{

    @Override
    public int compare(GruposAlum o1, GruposAlum o2) {
        return o1.getCantAlum() - o2.getCantAlum();
    }
    
}
