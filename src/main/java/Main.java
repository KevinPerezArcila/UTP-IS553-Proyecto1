
import Agenda.Agendas;
import Contacto.Contactos;
import java.io.IOException;
import static java.lang.System.console;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
           
        String nombre;
        String telefono;
        String telefonoAuxiliar;
        String correo;
        String dirrecion;
        String alias;
        String dondeLoConoce;
        String validacion;
        
        Integer opcion;
        Scanner dato = new Scanner(System.in);
        Scanner datoAuxiliar = new Scanner(System.in);
        Agendas agendaTelefonica = new Agendas(100);
        agendaTelefonica.leerArchivo();
        agendaTelefonica.archivoExiste();
        Contactos informacion;
        
        
        do{
        System.out.println("1) Añadir contacto ");
        System.out.println("2) Buscar por lugar de donde lo conocio ");
        System.out.println("3) Buscar por nombre ");
        System.out.println("4) Buscar por telefono ");
        System.out.println("5) Buscar por correo ");
        System.out.println("6) Buscar por dirrecion ");
        System.out.println("7) Buscar por alias ");
        System.out.println("8) Editar un contacto ");
        System.out.println("9) Importar ");
        System.out.println("10) Eliminar un contacto ");
        System.out.println("PRESIONA 0 PARA SALIR.");
        System.out.println("Que opcion quiere ejecutar: ");
        opcion = dato.nextInt();
        
        
        switch(opcion){
 
            case 1: 
                
                
                nombre = dato.nextLine();
                while(nombre.isBlank()){
                    System.out.println("Ingrese el nombre (Obligatorio) ");
                    nombre = dato.nextLine(); 
                }
                
              
              
                   
               
                System.out.println("Ingrese el telefono (Obligatorio) ");  
                telefono = dato.nextLine();
                while(telefono.isBlank()){
                    System.out.println("Ingrese el telefono (Obligatorio) ");
                    telefono = dato.nextLine(); 
                 }
                
                System.out.println("¿Desea agregar mas numeros? si/no"); 
                validacion = datoAuxiliar.nextLine();
                
                if(validacion.equalsIgnoreCase("si")==true){
                     do{
                         
                         System.out.println("Ingrese el telefono (Obligatorio) ");  
                         telefonoAuxiliar = dato.nextLine();
                         while(telefonoAuxiliar.isBlank()){
                         System.out.println("Ingrese el telefono (Obligatorio) ");
                         telefonoAuxiliar = dato.nextLine(); 
                         }
                         telefono+= ";"+telefonoAuxiliar; 
                         System.out.println("¿Desea agregar mas numeros? si/no"); 
                         validacion = datoAuxiliar.nextLine();
                    
                     }while(validacion.equalsIgnoreCase("si")==true);
                }
                
                
                
                
                
                
                System.out.println("Ingrese el correo electronico (Opcional) ");
                correo = dato.nextLine();
                
                System.out.println("Ingrese la dirrecion (Opcional) ");
                dirrecion = dato.nextLine();
                
                System.out.println("Ingrese el alias (Opcional) ");
                alias = dato.nextLine();
                
                System.out.println("en donde conocio esta persona (Obligatorio) ");
                dondeLoConoce = dato.nextLine();
                while(dondeLoConoce.isBlank()){
                    System.out.println("en donde conocio esta persona (Obligatorio) ");
                    dondeLoConoce = dato.nextLine();
                }
                
                informacion = new Contactos(nombre, telefono, correo, dirrecion, alias, dondeLoConoce);
                agendaTelefonica.agregarContactoNuevo(informacion);
               
                
                
                    
                
                break;
                
            case 2:
                System.out.println("Ingrese la ciuda que quiere buscar: ");
                dondeLoConoce = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorCiudad(dondeLoConoce);
                break;

            case 3:
                
                System.out.println("Ingrese el nombre que quiere buscar: ");
                nombre = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorNombre(nombre);
                
                break;
                
            case 4:
                System.out.println("Escriba el telefono que quiere buscar: ");
                telefono = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorTelefono(telefono);
                break;
                
            case 5: 
                System.out.println("Escriba el correo que quiere buscar: ");
                correo = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorCorreo(correo);
               
                break;
                
            case 6:
                System.out.println("Escriba la direccion que quiere buscar: ");
                dirrecion = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorDireccion(dirrecion);
 
                break;

            case 7:
                System.out.println("Escriba el alias que quiere buscar: ");
                alias = datoAuxiliar.nextLine();
                agendaTelefonica.buscarPorAlias(alias);
                
                break;
                
            case 8:
                System.out.println("Escriba el numero de telefono del contacto a editar: ");
                telefono = datoAuxiliar.nextLine();
                informacion = new Contactos("", telefono ,"","","","");
                agendaTelefonica.editarContacto(informacion);
                
                break;
                
            case 9:
                agendaTelefonica.importar();
                break;
            case 10:
               
                telefono = dato.nextLine();
                while(telefono.isBlank()){
                    System.out.println("Ingrese el telefono (Obligatorio) ");
                    telefono = dato.nextLine(); 
                 }
                informacion = new Contactos("",telefono,"","","","");
                agendaTelefonica.eliminarUnContacto(informacion);
                
                break;
            default:
                
                System.out.println("Ingreso un dato erroneo o se salio del programa.");
                break; 
                   
        }
        
            
      }while(opcion!=0);
    }
    
}
