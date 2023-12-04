import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class servidor {
    public static void main(String[] args) {
        try {
            //Crear una instancia de la imolementacion de ka unterfaz
            interfaz objetoRemoto = new implementacioninterfaz();

            //Crear y obtener registro RMI en el puerto especifico
            Registry resgitro = LocateRegistry.createRegistry(1234);

            //vincular la implementacion remota al registro con un nombre especifico
            resgitro.rebind("ClienteRemoto", objetoRemoto);

            System.out.println("Servidor remoto iniciado.....");

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
