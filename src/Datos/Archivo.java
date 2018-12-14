/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XJINX
 */
public abstract  class Archivo {
    private String arc;

    public Archivo(String arc) {
        this.arc = arc;
    }
    public int ultimo(){
        int i=0;
        
        try {
            Scanner entrada = new Scanner(new File(arc));
            while(entrada.hasNextLine()){
                entrada.nextLine();
                i++;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }
   
    public String[] leer() throws FileNotFoundException, IOException{
        int i=0;
        String [] datos = new String [ultimo()];
        Scanner entrada;
        try{
                entrada= new Scanner(new File(arc));
                    
                while(entrada.hasNextLine()){
                    
                    datos[i++] = entrada.nextLine();
                }
                entrada.close();          
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }  
        return datos;
    }
    
    public void escribir(String cuenta) throws IOException{
        File archivo=new File(arc);
        try (PrintWriter pw = new PrintWriter( new BufferedWriter( new FileWriter(archivo.getAbsolutePath(), true)))) {
              pw.println(cuenta);
        }
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            for (int i = 0; i < ultimo(); i++) {          
                System.out.println(br.readLine());
            }
        }
    }
}
