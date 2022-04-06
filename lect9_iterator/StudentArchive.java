package lect9;

import java.util.ArrayList;

interface Iterator{
    public boolean hasNext();
    public Object next();
    // public void checkMate(Object object);
}
interface Container{
    public Iterator getIterator();
    // public void checkMate(String name);
}
class NameRepository implements Container{
    public String[] names = {"Nam","Hanh","Viet","Dung","An"};
    public Iterator getIterator(){
        return new NameIterator();
    }
    public Iterator getLexicalIterator(){
        LexicalIterator lexicalIterator = new LexicalIterator();
        lexicalIterator.sort();
        return lexicalIterator;
    }
    // public void checkMate(String name)
    // {
    //     for(int i = 0; i < names.length; i++){
    //         if(names[i].equals(name)){
    //             System.out.println("Exists");
    //             return;
    //         }
    //     }
    //     System.out.println("Not exist");
    // }
    
    private class LexicalIterator implements Iterator{
        int index;
        private String[] private_name_list = names;
        public void sort(){
            for(int i = 0; i < private_name_list.length; i++){
                for(int j = i + 1; j < private_name_list.length; j++){
                    if(private_name_list[i].compareTo(private_name_list[j]) > 0){
                        String temp = private_name_list[i];
                        private_name_list[i] = private_name_list[j];
                        private_name_list[j] = temp;
                    }
                }
            }
        }
        public boolean hasNext(){
            if(index < private_name_list.length){
                return true;
            }
            return false;
        }
        public Object next(){
            if(this.hasNext()){
                return private_name_list[index++];
            }
            return null;
        }
    }
    private class NameIterator implements Iterator{
        int index;
        public boolean hasNext(){
            if(index < names.length){
                return true;
            }
            return false;
        }
        public Object next(){
            if(this.hasNext()){
                return names[index++];
            }
            return null;
        }
        // public void checkMate(Object object){
        //     while(this.hasNext()){
        //         if(this.next().equals(object)){
        //             System.out.println("Exists");
        //             return;
        //         }
        //     }
        //         System.out.println("Not exist");
        //         return;
        // }
        
    }
    
}


class Client{
    public static void main(String[] args){
        NameRepository nameRepository = new NameRepository();
        Iterator iterator = nameRepository.getIterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next()+ " ");
        }
        System.out.println();
        //checkMate("Dung", nameRepository.getIterator());
        // lexicalPrint(nameRepository.getIterator());
        Iterator lexI = nameRepository.getLexicalIterator();
        if(lexI.hasNext()){
            System.out.println("Lexical Iterator: "+ lexI.next());
        }

    }
    public static void checkMate(Object object, Iterator iterator){
        while(iterator.hasNext()){
            if(iterator.next().equals(object)){
                System.out.println("Exists");
                return;
            }
        }
        System.out.println("Not exist");
        return;
    }
    public static void lexicalPrint(Iterator iterator){
        ArrayList<Object> list = new ArrayList<Object>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
        for(int i = 0 ; i < list.size()-1; i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i).toString().compareTo(list.get(j).toString()) > 0){
                    Object temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        System.out.print("Lexical order: ");
        for(int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
        
    }
    
}
