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
    
    public void addOrd(T obj){
        Nodo <T> puntero;
        Nodo <T> siguiente;
        Nodo <T> nuevo = new Nodo<T>(obj);

        if (isVacia()){
            raiz = nuevo;
            nuevo.setSiguiente(null);
            size++;
        }
        else{
            // MiIterador<T> it = new MiIterador<>(raiz);
            puntero = raiz;
            while (puntero != null) {
                int cont = 0;
                siguiente = puntero.getSiguiente();

                //Si la raiz es menor o igual que el nuevo nodo, dicho nodo se vuelve la raíz;
                if (c.compare(nuevo.getValor(), puntero.getValor()) <= 0) {
                    nuevo.setSiguiente(raiz);
                    raiz = nuevo;
                    nuevo.setPos(0);
                    size++;
                    break;
                }
                //Si el nodo es mayor, va al final;
                else if(c.compare(nuevo.getValor(), puntero.getValor()) > 0 && (siguiente == null)){
                    puntero.setSiguiente(nuevo);
                    nuevo.setSiguiente(null);
                    nuevo.setPos(size);
                    size++;
                    break;
                }
                //Si el nodo va entre medio de dos nodos;
                else if(c.compare(nuevo.getValor(), puntero.getValor()) > 0 && 
                        c.compare(nuevo.getValor(), siguiente.getValor()) <= 0 ){
                    nuevo.setSiguiente(siguiente);  
                    nuevo.setPos(cont);
                    size++;
                    break; 
                }
                //Sigo iterando;
                else{
                    puntero = puntero.getSiguiente();
                    cont++;
                }
            }
        }
    }
    //Ordenar por otro parametro
    private void reOrdenar(){
        Nodo <T> aux = raiz;
        raiz = null;
        while (aux != null) {
            addOrd(aux.getValor());
            aux = aux.getSiguiente();
        }
    }

    //Delete por objeto;
    public void delete(T obj){
        if (!isVacia()) {
            Nodo <T> cursor = raiz;
            Nodo <T> sig = cursor.getSiguiente();

            while (sig != null) {
                if (sig.getValor().equals(obj)) {
                    sig.setSiguiente(sig.getSiguiente());
                }
            }
        }
    }
    public void eliminarOcurrencia(T obj){
        Nodo <T> cursor = raiz;
        Nodo <T> siguiente = cursor.getSiguiente();
        Nodo <T> ant = null;

        while (siguiente != null && !siguiente.getValor().equals(obj)) {

            if (raiz.getValor().equals(obj)) 
                raiz = cursor;
            else
                ant = cursor;
            
            while(siguiente != null && siguiente.getValor().equals(obj)){
                cursor = siguiente;
                siguiente = siguiente.getSiguiente();
            }

            cursor = siguiente;
            siguiente = siguiente.getSiguiente();
        }

        ant.setSiguiente(siguiente);

    }




    //Mostrar, Innecesario por la implementación de iterable.
    // public void show(){
    //     Nodo <T> i = raiz;
    //     while (i != null) {
    //         System.out.println(i.getValor());
    //         i = i.getSiguiente();
    //     }
    // }
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

