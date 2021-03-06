import javax.naming.Context;
import javax.naming.InitialContext;

public class SomeNormalClient {
    public static void main(String[] argv) throws Exception {
        String name = "any";
        String sth = "hello world";
        /*
         * 保持一般性，使用JNDI，用JVM参数传递env
         */
        Context ctx = new InitialContext();
        SomeInterface some = (SomeInterface) ctx.lookup(name);
        String resp = some.Echo(new Message(sth));
        System.out.println(resp);
    }
}