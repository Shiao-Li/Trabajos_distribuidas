import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class cliente {
    public static void main(String[] args) {
        try {
            Registry registro = LocateRegistry.getRegistry("localhost", 1234);
            interfaz objetoRemoto = (interfaz) registro.lookup("ClienteRemoto");

            Scanner scanner = new Scanner(System.in);

            String mensaje = objetoRemoto.mensaje();
            System.out.println(mensaje);

            System.out.println("Seleccione la operación:");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicación");
            System.out.println("4. División");
            int opcion = scanner.nextInt();

            System.out.println("Ingrese el primer número:");
            double num1 = scanner.nextDouble();
            System.out.println("Ingrese el segundo número:");
            double num2 = scanner.nextDouble();

            double respuesta;
            switch (opcion) {
                case 1:
                    respuesta = objetoRemoto.suma(num1, num2);
                    System.out.println("La suma es: " + respuesta);
                    break;
                case 2:
                    respuesta = objetoRemoto.resta(num1, num2);
                    System.out.println("La resta es: " + respuesta);
                    break;
                case 3:
                    respuesta = objetoRemoto.multiplicacion(num1, num2);
                    System.out.println("La multiplicación es: " + respuesta);
                    break;
                case 4:
                    respuesta = objetoRemoto.division(num1, num2);
                    System.out.println("La división es: " + respuesta);
                    break;
                default:
                    System.out.println("Opción inválida");
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
