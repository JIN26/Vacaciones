package Datos;

import java.io.*;

/**
 *
 * @author XJINX
 */

public final class Usuarios extends Archivo {
    private String Nombre;
    private int Puntos;
    private int Time;
    private int cantidad;
    
    public  Usuarios(String arc){
        super(arc);
        this.Nombre=" ";
        this.Puntos=0;
        this.Time=0;
        cantidad=ultimo();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int Puntos) {
        this.Puntos = Puntos;
    }

    public int getTime() {
        return Time;
    }

    public void setTime(int Time) {
        this.Time = Time;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public int ultimo(){ 
       return super.ultimo();
    }
   
    /**
     *
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Override
    public String[] leer() throws FileNotFoundException, IOException {
        String [] datos = new String [ultimo()];
        datos = super.leer();
        
        String[] parts = datos[this.cantidad].split(" ");
        this.Nombre=parts[0];
        this.Puntos=Integer.parseInt(parts[1]);
        this.Time=Integer.parseInt(parts[2]);
        return datos;
    }
    
    @Override
    public void escribir(String cuenta) throws IOException{
        super.escribir(cuenta);
    }
    
    public void mostrar(){
        System.out.println("---Usuarios---");
        System.out.println("Nombre: "+Nombre);
        System.out.println("Puntos: "+Puntos);
        System.out.println("Time: "+Time);
    }
}
