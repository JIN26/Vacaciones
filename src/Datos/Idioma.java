package Datos;

import java.io.*;

/**
 *
 * @author XJINX
 */

public class Idioma extends Archivo {
    private String Nombre;
    private int cantidad;
    
    public  Idioma(String arc){
        super(arc);
        Nombre=" ";
        cantidad=ultimo();
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
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
        this.Nombre= datos[this.cantidad];
        return datos;
    }
    
    @Override
    public void escribir(String cuenta) throws IOException{
        super.escribir(cuenta);
    }
    
    public void mostrar(){
        System.out.println("---Palabra---");
        System.out.println("Nombre: "+Nombre);
    }
}
