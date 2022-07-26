package singleton;

public class Test {

    public static void main(String[] args){

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("Are they the same?");
        System.out.println(aClient.equals(bClient));

/*Only one instance can be created. Use when you want to make it possible for instances from other class
to share the data. It also minimize the memory usage*/





    }
}
