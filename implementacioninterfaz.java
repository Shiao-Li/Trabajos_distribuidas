import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implementacioninterfaz extends UnicastRemoteObject implements interfaz {

    public implementacioninterfaz() throws RemoteException {
        super();
    }

    public String mensaje() throws RemoteException {
        return "Hola desde el servidor";
    }

    public double suma(double a, double b) throws RemoteException {
        return a + b;
    }

    public double resta(double a, double b) throws RemoteException {
        return a - b;
    }

    public double multiplicacion(double a, double b) throws RemoteException {
        return a * b;
    }

    public double division(double a, double b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("No se puede dividir por cero");
        }
        return a / b;
    }
}
