package adaptor;

public class AC implements Electronic220V{


    @Override
    public void powerOn() {
        System.out.println("AC 220V on");
    }
}
