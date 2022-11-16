package tpe;

import java.util.Iterator;

public class MiIterador <T> implements Iterator <T>{
    private Nodo <T> cursor; 

    public MiIterador(Nodo <T> cursor) {
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        //pregunta si hay un siguiente, ya que en next() pasamos al mismo;
        return cursor != null;
    }

    @Override
    public T next() {
        //Guardo el primer valor;
        T valor = (T) cursor.getValor();
        //Paso al segundo;
        cursor = cursor.getSiguiente();
        //Retorno el primero;
        return valor;
    }
}
