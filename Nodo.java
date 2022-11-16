package tpe;

public class Nodo <T> {
    private T valor;
    private int pos;
    private Nodo <T> siguiente;

    public Nodo(T valor){
        this.valor = valor;
    }


    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public Nodo <T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo <T> siguiente) {
        this.siguiente = siguiente;
    }

    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }


    @Override
    public String toString() {
        return "Nodo [pos=" + pos + "]";
    }

    

}