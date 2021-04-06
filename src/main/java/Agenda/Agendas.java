
package Agenda;

import Contacto.Contactos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Agendas {
    
    Scanner dato = new Scanner(System.in);
    File archivo = new File("Agenda.txt");
    private Contactos[] contacto; 
    
    public Agendas(int tamaño){
        this.contacto = new Contactos[tamaño];
    }
    
    public void archivoExiste() throws IOException{
        
        try {
            if(archivo.exists()){
                
            }
            else{
                archivo.createNewFile();
                
            }
        }catch(Exception op){
            System.out.println(op.getMessage());
        }
    }
    
    public boolean validarTelefono(String telefono, boolean encontrado){
        try {
            BufferedReader leer = new BufferedReader(new FileReader("Agenda.txt"));
            String x="";
            encontrado = false;
            while((x=leer.readLine()) != null){
                if(x.indexOf(telefono)!= -1){
                    encontrado = true;
                    break;
                }
            }
        }catch(Exception op){
            System.out.println(op.getMessage());
        }
        return encontrado;
    }
    
    
    
    
  
    
    
}
