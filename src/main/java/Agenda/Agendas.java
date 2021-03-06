
package Agenda;

import Contacto.Contactos;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Agendas {
    
    Scanner dato = new Scanner(System.in);
     Scanner dato2 = new Scanner(System.in);
    File archivo = new File("agenda.txt");
    private Contactos[] contacto; 
    
    public Agendas(int tamaño){
        this.contacto = new Contactos[tamaño];
    } //1
    
    public void archivoExiste() {
        
        try {
            if(archivo.exists()){
                System.out.println("");
            }
            else{
                archivo.createNewFile();
                
            }
        }catch(Exception op){
            System.out.println(op.getMessage());
        }
    } //2
    
    public boolean validarTelefono(String telefono, boolean verificar){
        try {
            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));
            String x="";
            verificar = false;
            while((x=leer.readLine()) != null){
                if(x.indexOf(telefono)!= -1){
                    verificar = true;
                    break;
                }
            }
        }catch(Exception op){
            System.out.println(op.getMessage());
        }
        return verificar;
    } //3
    
    public void agregarContactoNuevo(Contactos nuevo){
        boolean verificar = false;
        boolean auxiliar = true;
        for(int i = 0; i< contacto.length && !verificar; i++){
            if(contacto[i] != null && contacto[i].getTelefonos().equals(nuevo.getTelefonos())){
                System.out.println("Ya existe un registro con este numero. ");
                auxiliar = false;
            }
        }
        if(auxiliar){
            for(int i = 0; i<contacto.length && !verificar; i++){
                if(contacto[i]==null){
                    contacto[i]=nuevo;
                    añadirAlArchivo(nuevo);
                    verificar = true;
                }
            }
            if(verificar){
                System.out.println("Agregado ");
            }
            else{
                System.out.println("No se pudo agregar ");
                
            }
        }
        else{
            System.out.println("No se pudo agregar ");
        }
    } //4 
    
    public void buscarPorNombre(String nombre){
        boolean verificar = false;
        for(int i = 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getNombre().equals(nombre)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda. ");
        }
    } //5
    
    public void eliminarUnContacto(Contactos eliminar){
        boolean verificar = false;
        for(int i = 0; i<contacto.length && !verificar; i++){
            if(contacto[i] != null && contacto[i].equals(eliminar)) {
                contacto[i]=null;
                System.out.println("El contacto a sido eliminado. ");
                eliminarArchivo();
                llenarArchivo(eliminar);
                verificar=true;
            }
        }
        
        if(!verificar){
            System.out.println("No se encontro contacto a eliminar. ");
        }
        
        
    } 
    
    
    public void buscarPorTelefono(String telefono){
        boolean verificar = false;
        for(int i = 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getTelefonos().equals(telefono)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                 System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda ");
        }
    } //6
    
    public void buscarPorCorreo(String correo){
        boolean verificar = false;
        for(int i= 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getCorreo().equals(correo)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                 System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda. ");
        }
    } //7
    
    public void buscarPorDireccion(String direccion){
        boolean verificar = false;
        for(int i = 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getDireccion().equals(direccion)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                 System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda. ");
        }
    } //8
    public void buscarPorCiudad(String ciudad){
        boolean verificar = false;
        for(int i = 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getDondeLoConoce().equals(ciudad)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                 System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda. ");
        }
    } 
    
    public void buscarPorAlias(String alias){
        boolean verificar = false;
        for(int i = 0; i<contacto.length; i++){
            if(contacto[i] != null && contacto[i].getAlias().equals(alias)){
                System.out.println("Su nombre es: " + contacto[i].getNombre());
                System.out.println("Su telefono es: " + contacto[i].getTelefonos());
                System.out.println("Su correo es: " + contacto[i].getCorreo());
                System.out.println("Su direccion es: " + contacto[i].getDireccion());
                System.out.println("Su alias es: " + contacto[i].getAlias());
                 System.out.println("Lo conocio en: " + contacto[i].getDondeLoConoce());
            }
        }
        verificar = true;
        if(!verificar){
            System.out.println("El contacto no esta en la agenda. ");
        }
    } //9
    
    public void eliminarContacto(Contactos nuevo){
        boolean verificar = false;
        for(int i = 0; i<contacto.length && !verificar; i++){
            if(contacto[i] != null && contacto[i].equals(nuevo)) {
                contacto[i]=null;
                System.out.println("El contacto a sido eliminado. ");
                eliminarArchivo();
                llenarArchivo(nuevo);
                verificar=true;
            }
        }
        
        if(!verificar){
            System.out.println("No se encontro contacto a eliminar. ");
        }
        
        
        
    } //10
    
    public void añadirEditado(Contactos editado){
        boolean verificar = false;
        boolean auxiliar = true;
        
        for(int i=0; i<contacto.length && !verificar; i++){
            if(contacto[i] != null && contacto[i].getTelefonos().equals(editado.getTelefonos())){
                System.out.println("Ya existe un contacto con este numero, no se puede modificar. ");
                auxiliar=false;
            }
        }
        
        
        if(auxiliar){
            for(int i = 0; i<contacto.length && !verificar; i++){
                if(contacto[i]==null){
                    contacto[i]=editado;
                    añadirAlArchivo(editado);
                    verificar=true;
                }
            }
            
            if(verificar){
                System.out.println("Se edito correctamente. ");
                
            }
            else{
                System.out.println("No existe. ");
            }
        }
        else{
            System.out.println("No se puede agregar los nuevos cambios. ");
        }
    } //11
    
    public void eliminarAux(Contactos eliminar){
        boolean verificar = false;
          
        for (int i = 0; i < contacto.length && !verificar; i++) {
            if (contacto[i] != null && contacto[i].equals(eliminar)) {
                contacto[i] = null;

                verificar = true;
            }
        }

        if (!verificar) {
            System.out.println("No se encontro registro a eliminar. ");
           
        }
    } //12
    
    
    
    public void editarContacto(Contactos nuevo){
        boolean verificar = false;
        String auxiliarNombre;
        String auxiliarTelefonos;
        String auxiliarCorreo;
        String auxiliarDireccion;
        String auxiliarAlias;
        String auxiliarDondeLoConoce;
        
        
       
   
        
        for(int i= 0; i<contacto.length; i++){
            
            if(contacto[i] != null && contacto[i].getTelefonos().equals(nuevo.getTelefonos())){
              
                System.out.println("Ingrese el nombre (Obligatorio) ");
                auxiliarNombre = dato.nextLine();
                while(auxiliarNombre.isBlank()){
                    System.out.println("Ingrese el nombre (Obligatorio) ");
                    auxiliarNombre = dato.nextLine();
                  }  
              
               
                    
                System.out.println("Ingrese el telefono (Obligatorio) ");
                auxiliarTelefonos = dato.nextLine();
                while(auxiliarTelefonos.isBlank()){
                    System.out.println("Ingrese el telefono (Obligatorio) ");
                    auxiliarTelefonos = dato.nextLine();
                    }
               
                
                System.out.println("Ingrese el correo electronico (Opcional) ");
                auxiliarCorreo = dato.nextLine();
                
                System.out.println("Ingrese la dirrecion (Opcional) ");
                auxiliarDireccion = dato.nextLine();
                
                System.out.println("Ingrese el alias (Opcional) ");
                auxiliarAlias = dato.nextLine();
                
                System.out.println("en donde conocio esta persona (Obligatorio) ");
                auxiliarDondeLoConoce = dato.nextLine();
                while(auxiliarDondeLoConoce.isBlank()){
                    System.out.println("en donde conocio esta persona (Obligatorio) ");
                    auxiliarDondeLoConoce = dato.nextLine();
                }
                
                 
                
            
                
                   
                 
                
                eliminarAux(nuevo);
                
                nuevo = new Contactos (auxiliarNombre, auxiliarTelefonos, auxiliarCorreo, auxiliarDireccion, auxiliarAlias,auxiliarDondeLoConoce);
                
                añadirEditado(nuevo);
                eliminarArchivo();
                llenarArchivo(nuevo);
                break;
                
            }
        }
        verificar=true;
        if(!verificar){
            System.out.println("No se encontro contacto. ");
        }
    } //13
    
    
    public void leerArchivo() throws FileNotFoundException{ //14
        try{
            BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, true)));
            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));
            String x="";
            while((x=leer.readLine()) != null ){
                String[] Contacto = x.split(";");
                Contactos op = new Contactos(Contacto[0],Contacto[1],Contacto[2],Contacto[3],Contacto[4],Contacto[5]);
                añadirContactoAux(op);
                
            }
        }catch(Exception op2){
            System.out.println(op2.getMessage());
        }
    } //14
    
    public void eliminarArchivo(){ //17
             try {
            BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo, false)));
            escribir.write("");
            escribir.close();

        } catch (Exception op) {

            System.out.println(op);

        }
    }//17
    
    public void añadirAlArchivo(Contactos nuevo){ //15
        try{
            BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(archivo,true)));
            BufferedReader leer = new BufferedReader(new FileReader("agenda.txt"));
            if(nuevo != null){
                if(validarTelefono(nuevo.getTelefonos(), false)){
                    
                }
                else{
                    escribir.write(nuevo.getNombre()+";"+nuevo.getTelefonos()+";"+nuevo.getCorreo()+";"+nuevo.getDireccion()+";"+nuevo.getAlias()+";"+nuevo.getDondeLoConoce());
                    escribir.write("\n");
                }
            }
            escribir.close();
        }catch(Exception op){
            System.out.println(op.getMessage());
        }
    }//15
    
    public void llenarArchivo(Contactos llenar){ //18
         for (int i = 0; i < contacto.length; i++) {

            if (contacto[i] != null) {

                llenar = contacto[i];
               añadirAlArchivo(llenar);

            }
        }
    } //18
    
    public void añadirContactoAux(Contactos nuevo){ //16
        boolean verificar = false;
        boolean auxiliar = true;

       

        for (int i = 0; i < contacto.length && !verificar; i++) {
            if (contacto[i] != null && contacto[i].getTelefonos().equals(nuevo.getTelefonos())) {

                auxiliar = false;
            }
        }

        if (auxiliar) {

            for (int i = 0; i < contacto.length && !verificar; i++) {

                if (contacto[i] == null) {

                    contacto[i] = nuevo;

                    verificar = true;
                }
            }

        }
    } 
    
    public void importar(){
        
        String archivo2 = "importararchivo.txt";
        
        
        
       

        try {

            BufferedReader leer = new BufferedReader(new FileReader(archivo2));

            String x = "";
            while ((x = leer.readLine()) != null) {
                String telefonos = "";
                String[] contactoNuevo = x.split(";");
               
                for(int i=1; i<(contactoNuevo.length-4); i++ ){
                    
                    if(i<contactoNuevo.length-5){
                        telefonos += contactoNuevo[i]+";" ; 
                    }
                    else{
                        telefonos += contactoNuevo[i] ; 
                    }
                }
                for(int i=0; i<contactoNuevo.length; i++){
                    System.out.println("dato "+i+ " "+ contactoNuevo[i]);
                }
                Contactos op = new Contactos(contactoNuevo[0], telefonos ,contactoNuevo[contactoNuevo.length-4] , contactoNuevo[contactoNuevo.length-3], contactoNuevo[contactoNuevo.length-2], contactoNuevo[contactoNuevo.length-1]);
                if (validarTelefono(telefonos, false) == false) {
                    if (contactoNuevo[0].equals("") || contactoNuevo[contactoNuevo.length-1].equals("") ) {
                        System.out.println("Falta uno o mas campos obligatorios. ");
                    }
                    else{
                        añadirContactoAux(op);
                        añadirAlArchivo(op);
                        System.out.println("Los contactos fueron importados. ");
                    }
                    
                } else {
                   System.out.println("El contacto no se importo, numero de telefono repetido"); 
                }

            }
            System.out.println("");
        } catch (Exception op2) {
     
            System.out.println("Faltan datos obligatorios. ");
        }

    } 
  
  
    
    
}
