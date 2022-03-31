package lect5_adapter;

class MicroUSB {
    public void useMicroUSB(){
        System.out.println("I'm using MicroUSB");
    }
    public void charge(){}
}
class  Lightning {
    public void charge(){};
    public void useLightning() {
        System.out.println("I'm using Lightning");
    }

} 
class Android{
    MicroUSB microUSB = new MicroUSB();
    public void useMicroUSB(){
        microUSB.useMicroUSB();
    }
    public void charge(){};
}
class Iphone{
    Lightning lightning = new Lightning();

    public void useLighting() {
        lightning.useLightning();
    }
    public void charge(){};
}



class USBAdapter extends Android {
    Iphone iphone;
    public USBAdapter(Iphone iphone){
        this.iphone=iphone;
    }
    public void useMicroUSB() {
        iphone.useLighting();
    }
}
// class PhoneFactory{

//     public PhoneFactory() {}
//     public Lightning getLightningPhone(String type){
//         if(type.equalsIgnoreCase("iphone"))
//             return new Iphone();
//         else
//             return new Huawei();
//     }
//     public Android getAndroidPhone(String type){
//         return new Android();
//     }

// }
class Client{
    public static void main(String[] args){
        // PhoneFactory factory = new PhoneFactory();
        Iphone iphone = new Iphone();
        USBAdapter adapter = new USBAdapter(iphone);
        adapter.useMicroUSB();
    }
}
