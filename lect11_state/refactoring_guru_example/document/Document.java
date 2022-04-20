package lect11_state.document;
interface State {
    public void publish(Document context);
}
class DraftState implements State{
    public void publish(Document context){
        context.setState(new ModerationState());
    }
}
class ModerationState implements State{
    public void publish(Document context){
        if(context.getAuth().equals("admin"))
            context.setState(new PublishedState());
        else
            context.setState(new DraftState());
    }
}
class PublishedState implements State{
    public void publish(Document context){
        System.out.println("Already published");    
    }
}

class Document {
    private State state= new DraftState();
    private String auth ="admin";
    public void publish(){
        this.state.publish(this);
    }
    public void setState(State state){
        this.state = state;
    }
    public String getAuth(){
        return this.auth;
    }

}
class DocClient{
    public static void main(String[] args){
        Document doc_client = new Document();
        doc_client.publish();
        doc_client.publish();
        doc_client.publish();
        doc_client.publish();
    }
}
