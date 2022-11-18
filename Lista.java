package tpe;

import java.util.Comparator;
import java.util.Iterator;

public class Lista <T> implements Iterable <T>{
    private Nodo <T> raiz;
    private Comparator <T> c;
    private int size;

    public Lista(Comparator <T> c){
        this.c = c;
    }
    
    //Add Ordenado
    public void addOrdenado(T obj){

        Nodo <T> n = new Nodo<T>(obj);
        if(this.isVacia()){
            this.raiz = n;
        }
        else{
            Nodo<T> anterior = null;
            Nodo<T> cursor = this.raiz;

            while(cursor != null && c.compare(cursor.getValor(), obj) < 0) {
                anterior = cursor;
                cursor = cursor.getSiguiente();
            }
            if(cursor == null && anterior != null){
                anterior.setSiguiente(n);
            }
            else{
                n.setSiguiente(cursor);
                if(cursor == this.raiz){
                    this.raiz = n;
                }
                else{
                    anterior.setSiguiente(n);
                }
            }
        }
        this.size++;
    }
    //Ordenar por otro parametro
    private void reOrdenar(){
        Nodo <T> cursor = raiz;
        raiz = null;
        while (cursor != null) {
            addOrdenado(cursor.getValor());
            cursor = cursor.getSiguiente();
        }
    }
    //Delete por pos;
    public void eliminarPos(int pos){
        if (this.isVacia() || (pos< 0  || pos >= getSize())) {
            return;
        }
        else if (pos == 0) {
            raiz = raiz.getSiguiente();
            return;
        } 
        else{
            int contador = 0;
            Nodo <T> temporal = raiz;
            while (contador < pos-1){
                temporal = temporal.getSiguiente();
                contador++;
            }
            temporal.setSiguiente(temporal.getSiguiente().getSiguiente());
        }
        size--;
    }
    //Delete por obj;
    public void eliminarOcurrencia(T data) {
        if(this.isVacia()) {
            return;
        }
        Nodo <T> actual = raiz;
        while (actual.getSiguiente() != null){
            if (actual.getValor().equals(data)){ // si el primero es una ocurrencia
                // hago el puente
                raiz = raiz.getSiguiente();
                actual = raiz;

            }else if(actual.getSiguiente().getValor().equals(data)){
                // me fijo en el siguiente y si es true, hago el puente
                Nodo<T> aEliminar = actual.getSiguiente();
                actual.setSiguiente(aEliminar.getSiguiente());
            }else{
                // si no se cumple, sigo recorriendo
                actual = actual.getSiguiente();
            }
        }

        // si la lista tiene sólo un elemento, borro ese elemento (lo hago null)
        if (raiz.equals(data)){
            raiz = null;
        }
    }

    //Obtener Posicion
    public int obtenerPos(T obj){
        int pos = 0;
        if (!isVacia()) {
            
            Nodo <T> nodo = raiz;
            while(nodo.getSiguiente() != null && ! nodo.getValor().equals(obj)){
                nodo = nodo.getSiguiente();
                pos++;
            }

            if (nodo.getValor().equals(obj)) 
                return pos;
        }
        return -1;
    }

    //isVacia
    private boolean isVacia(){
        return raiz == null;
    }
    //Getters y Setters
    public Comparator<T> getC() {
        return c;
    }
    public void setC(Comparator<T> c) {
        this.c = c;
        reOrdenar();
    }
    public int getSize() {
        return size;
    }


    //Iterator Methods.
    @Override
    public Iterator<T> iterator() {
        MiIterador <T> cursor = new MiIterador<>(raiz);
        return cursor;
    }

}

