package tpe.composite;

public abstract class Elem{
    protected String nombre;

    public Elem(String nombre) {
        this.nombre = nombre;
    }

    public abstract int getCantAlum();

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
