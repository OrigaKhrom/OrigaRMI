import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain {
    public static final String UNIQUE_BINDING_NAME = "server.calculator1.0";

    public static void main(String[] args) throws RemoteException, NotBoundException {

        final Registry registry = LocateRegistry.getRegistry(2733);

        Calculator calculator = (Calculator) registry.lookup(UNIQUE_BINDING_NAME);  //работа RMI основана на использовании прокси, поэтому удаленный вызов доступен только для методов интерфейсов, а не классов.

        int multiplyResult = calculator.multiply(20, 50);

        System.out.println(multiplyResult);
    }
}


//В примере выполняются четыре основных действия:
//
//определение удаленного интерфейса с объявлениями методов, которые клиент может вызвать у удаленного объекта;
//определение реализации удаленного объекта для удаленного интерфейса;
//определение клиентского приложения, которое использует удаленную ссылку, чтобы взаимодействовать с реализацией интерфейса;
//компиляция и выполнение удаленного объекта и клиента.