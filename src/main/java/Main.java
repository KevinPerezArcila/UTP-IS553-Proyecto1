
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        
        
        Integer opcion;
        Scanner dato = new Scanner(System.in);
        
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
               
                break;
                
            case 2:
                
                break;

            case 3:
                
                break;
                
            case 4:
                
                break;
                
            case 5: 
               
                break;
                
            case 6:
 
                break;

            case 7:
                
                break;
                
            case 8:
                
                break;
                
            case 9:
                
                break;
                
            default:
                System.out.println("Ingreso un dato erroneo o se salio del programa.");
                break; 
                   
        }
        
            
      }while(opcion!=0);
    }
    
}
