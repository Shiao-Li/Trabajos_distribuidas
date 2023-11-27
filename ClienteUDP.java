import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class ClienteUDP {
    public static void main(String[] args) {

        try {
            int puerto = 5000; // Número de puerto

            // Crear un socket UDP
            DatagramSocket socket = new DatagramSocket();
            System.out.println("Cliente esperando al servidor");

            // Direccion IP del servidor
            InetAddress direccionIP_servidor = InetAddress.getByName("172.31.118.79");

            // Usar Scanner para leer el mensaje desde la entrada estándar (teclado)
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Ingrese el mensaje: ");
                String mensaje = scanner.nextLine();

                // Convertir el mensaje a bytes
                byte[] bufferSalida = mensaje.getBytes();

                // Crear paquete para enviar datos
                DatagramPacket paquete_enviar = new DatagramPacket(bufferSalida, bufferSalida.length,
                        direccionIP_servidor, puerto);

                // Enviar paquete
                socket.send(paquete_enviar);

                // Arreglos de bytes para recibir los datos
                byte[] bufferEntrada = new byte[1024];

                // Crear paquete para recibir datos
                DatagramPacket paquete_recibir = new DatagramPacket(bufferEntrada, bufferEntrada.length);

                // Recibir paquete
                socket.receive(paquete_recibir);

                // Extraer la información del paquete recibido
                String mensajeRecibido = new String(paquete_recibir.getData(), 0, paquete_recibir.getLength());
                System.out.println("Mensaje recibido: " + mensajeRecibido);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
