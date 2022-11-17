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

    public void eliminarOcur(T obj){
       Nodo <T> cursor = raiz;
       Nodo <T> siguiente = cursor.getSiguiente();
       Nodo <T> ant = null;

        if (this.isVacia()) {
            return;
        }

        while (siguiente != null){

            while (raiz.getValor().equals(obj)){
                raiz = raiz.getSiguiente();
                cursor = raiz;
                siguiente = cursor.getSiguiente();
            }

            while (cursor.getSiguiente().equals(obj)){
                cursor.setSiguiente(siguiente.getSiguiente());
            }

            cursor = siguiente;
            siguiente = cursor.getSiguiente();
        }    
        
    }
    
    // public void eliminarOcurrencia(T obj){
    //     Nodo <T> cursor = raiz;
    //     Nodo <T> siguiente = cursor.getSiguiente();
    //     Nodo <T> ant = null;

    //     while (siguiente != null /*&& !siguiente.getValor().equals(obj)*/) {

    //         if (raiz.getValor().equals(obj)) {
    //             raiz = cursor.getSiguiente();
    //             cursor = raiz; 
    //         }
    //         else{
    //             ant = cursor;
            
    //             while(siguiente != null && siguiente.getValor().equals(obj)){
    //                 cursor = siguiente;
    //                 siguiente = siguiente.getSiguiente();
    //             }
                
    //             if (siguiente != null) {
    //                 cursor = siguiente;
    //                 siguiente = siguiente.getSiguiente();
    //             }

    
    //             if (ant != null) 
    //                 ant.setSiguiente(siguiente);
    //         }
    //     }
    // }



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

