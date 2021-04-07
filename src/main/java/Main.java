
import Agenda.Agendas;
import Contacto.Contactos;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
           
        String nombre;
        String telefono;
        String correo;
        String dirrecion;
        String alias;
        
        
        Integer opcion;
        Scanner dato = new Scanner(System.in);
        
        Agendas agendaTelefonica = new Agendas(100);
        agendaTelefonica.leerArchivo();
        agendaTelefonica.archivoExiste();
        Contactos informacion;
        
        
        do{
        System.out.println("1) Añadir contacto ");
        System.out.println("2) Borrar contacto ");
        System.out.println("3) Buscar por nombre ");
        System.out.println("4) Buscar por telefono ");
        System.out.println("5) Buscar por correo ");
        System.out.println("6) Buscar por dirrecion ");
        System.out.println("7) Buscar por alias ");
        System.out.println("8) Editar un contacto ");
        System.out.println("9) Importar ");
        System.out.println("PRESIONA 0 PARA SALIR.");
        System.out.println("Que opcion quiere ejecutar: ");
        opcion = dato.nextInt();
        
        
        switch(opcion){
 
            case 1: 
                
                nombre = dato.nextLine();
                while(nombre.equals("")){
                    System.out.println("Ingrese el nombre (Obligatorio) ");
                    nombre = dato.nextLine(); 
                }
                
                telefono = dato.nextLine();
                while(telefono.equals("")){
                    System.out.println("Ingrese el telefono (Obligatorio) ");
                    telefono = dato.nextLine(); 
                }
                
                System.out.println("Ingrese el correo electronico (Opcional) ");
                correo = dato.nextLine();
                
                System.out.println("Ingrese la dirrecion (Opcional) ");
                dirrecion = dato.nextLine();
                
                System.out.println("Ingrese el alias (Opcional) ");
                alias = dato.nextLine();
                
                informacion = new Contactos(nombre, telefono, correo, dirrecion, alias);
                agendaTelefonica.agregarContactoNuevo(informacion);
               
                
                
                    
                
                break;
                
            case 2:
                System.out.println("Ingrese el nombre del contacto que quiere eliminar: ");
                nombre = dato.nextLine();
                informacion = new Contactos(nombre, "","","","");
                agendaTelefonica.eliminarContacto(informacion);
                break;

            case 3:
                System.out.println("Ingrese el nombre que quiere buscar: ");
                nombre = dato.nextLine();
                agendaTelefonica.buscarPorNombre(nombre);
                
                break;
                
            case 4:
                System.out.println("Escriba el telefono que quiere buscar: ");
                telefono = dato.nextLine();
                agendaTelefonica.buscarPorTelefono(telefono);
                break;
                
            case 5: 
                System.out.println("Escriba el correo que quiere buscar: ");
                correo = dato.nextLine();
                agendaTelefonica.buscarPorCorreo(correo);
               
                break;
                
            case 6:
                System.out.println("Escriba la direccion que quiere buscar: ");
                dirrecion = dato.nextLine();
                agendaTelefonica.buscarPorDireccion(dirrecion);
 
                break;

            case 7:
                System.out.println("Escriba el alias que quiere buscar: ");
                alias = dato.nextLine();
                agendaTelefonica.buscarPorAlias(alias);
                
                break;
                
            case 8:
                System.out.println("Escriba el nombre a editar: ");
                nombre = dato.nextLine();
                informacion = new Contactos(nombre, "","","","");
                agendaTelefonica.editarContacto(informacion);
                
                break;
                
            case 9:
                agendaTelefonica.importar();
                break;
                
            default:
                System.out.println("Ingreso un dato erroneo o se salio del programa.");
                break; 
                   
        }
        
            
      }while(opcion!=0);
    }
    
}
