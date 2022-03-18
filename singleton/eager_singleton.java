class EagerSingleton{
  private EagerSingleton ES_instance = new EagerSingleton();
  private static EagerSingleton(){}
  
  public static getInstance(){
    return this.ES_instance;
   }
}
