package tpe.composite;

import java.util.ArrayList;
// import tpe.Lista;

public class Alumno <T> extends Elem<T>{
    private String nombre;
    private String apellido;
    private int edad;
    private long dni;
    // private Lista <String> palabrasClave;
    private ArrayList <String> palabrasClave;

    public Alumno(String nombre, String apellido, int edad, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
    }

    public Alumno(int edad, int dni) {
        this.edad = edad;
        this.dni = dni;
    }

    public int getCantAlum(){
        return 1;
    }


    public void addPc(String p){
        if (!palabrasClave.contains(p)) {
            palabrasClave.add(p);
        }
    }
    public ArrayList <String> getPc(){
        return new ArrayList<>(palabrasClave);
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public int getEdad() {
        return edad;
    }
    public long getDni() {
        return dni;
    }

    // public boolean equals(Object o1){
    //     try {
    //         Alumno <T> otro = (Alumno (o1));
    //         return this.edad == otro.getEdad();
    //     } catch (Exception e) {
    //         return false;
    //     }
    // }



    @Override
    public String toString() {
        return "Alumno [edad=" + edad + ", dni=" + dni + "]";
    }
}
