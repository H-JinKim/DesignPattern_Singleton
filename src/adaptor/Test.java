package adaptor;



public class Test {

    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }


    public static void main(String[] args){
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        AC ac = new AC();
//        connect(ac);    doesn't work cuz it implements 220V
//        need an daptor to connect 220 to 110

        Electronic110V adaptor = new SocketAdaptor(ac);
        connect(adaptor);
    }

}
