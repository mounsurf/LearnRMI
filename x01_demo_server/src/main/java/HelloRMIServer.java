import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloRMIServer {
    public static void main(String[] argv) throws Exception {
        int port = 1099;
        String name1 = "HelloRMIInterfaceTest001";
        String name2 = "HelloRMIInterfaceTest002";
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/rmi/registry/LocateRegistry.html
         *
         * port默认使用1099/TCP，addr默认使用"0.0.0.0"
         */
        Registry r = LocateRegistry.createRegistry(port);
        HelloRMIInterface hello1 = new HelloRMIInterfaceImpl();
        HelloRMIInterface hello2 = new HelloRMIInterfaceImpl();
        /*
         * https://docs.oracle.com/javase/8/docs/api/java/rmi/registry/Registry.html
         *
         * 第一形参内容任意，起唯一标识作用
         */
        r.rebind(name1, hello1);
        r.rebind(name2, hello2);
        System.out.println("已启动");
    }
}