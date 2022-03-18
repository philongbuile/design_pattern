interface Printer{
  String getName();
  void print();
}
class Printer1 implements Printer{
  public String getName(){
    return "Printer 1";
    }
  
  public void print(){
    System.out.println("From printer 1");
  }
}
class Printer2 implements Printer{
  public String getName(){
    return "Printer 2";
    }
  
  public void print(){
    System.out.println("From printer 2");
  }
}
class PrinterFactory{
  public Printer getPrinter(String PrinterName){
   if(PrinterName =="Printer1")
      return new Printer1();
    else if(PrinterName =="Printer2")
      return new Printer2();
    else
    {
      throw new IllegalArgumentException("This printer is not available");
    }
  }
  
  //client's side
  class Client{
    public static void main(String[] args){
        Printer printer = PrinterFactory.getPrinter(PrinterType.Printer2);
        printer.print();

    }
}
  
}
