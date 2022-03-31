package lect5_adapter.minhdinh;

public class Adapter implements MicroUSB{
    private Lightning lightningPhone = null;
    public void MicroUSBToLightning(Lightning lightningPhone)
    {
        //passing lightning phone to create connection
        this.lightningPhone = lightningPhone;
    }
    //Override all methods in the parent class
    public void useMicroUSB()
    {
        lightningPhone.useLightning();
    }
    public void recharge()
    {
        lightningPhone.recharge();
    }
}
