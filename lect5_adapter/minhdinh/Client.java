package lect5_adapter.minhdinh;

public class Client {
    public static void main(String[] args)
    {
        iPhone i = new iPhone();
        Adapter a = new Adapter();
        a.MicroUSBToLightning(i);

        a.useMicroUSB();
        a.recharge();
    }
}
