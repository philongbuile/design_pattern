package lect9;
class binaryTree{
    binaryTree left = null;
    binaryTree right= null;
    String name;
    public binaryTree(String name){
        this.name = name;
    }
    public void addNode(binaryTree node){
       if(left == null){
           left = node;
       }
       else if(right == null){
           right = node;
       }
       else{
           left.addNode(node);
       }
    }
    public void printTree(){
        System.out.println(name);
        if(left != null){
            left.printTree();
        }
        if(right != null){
            right.printTree();
        }
    }

}
//things going on here
class StudentArchive {
    String[] studentsList = {"Nam","Hanh","Viet","Dung"};
    binaryTree studentTree = new binaryTree(studentsList[0]);   
    public StudentArchive() {
        for(int i =1; i < studentsList.length; i++){
            studentTree.addNode(new binaryTree(studentsList[i]));
        }
    }
    public void printL2R(){
        System.out.println("Left to Right:");
        for(int i = 0; i < studentsList.length; i++){
            System.out.println(studentsList[i]);
        }
    }
    public void printR2L(){
        System.out.println("Right to Left:");
        for(int i = 0; i< studentsList.length; i++){
            System.out.println(studentsList[studentsList.length - i - 1]);
        }
    }
    public void printTree(){
        System.out.println("Print Tree: ");
        
        studentTree.printTree();
    }
    public void printFirstStudent(){
        System.out.println("First Student: " + studentsList[0]);
    }
    public void printLastStudent(){
        System.out.println("Last Student: " + studentsList[studentsList.length - 1]);
    }
    public void printInOddOrder(){

        System.out.println("Print In Odd Order: ");
        int i = 1;
        while(i<studentsList.length){
            System.out.println(studentsList[i]);
            i = i + 2;
        }
    }
}
class Client_naive{
    public static void main(String[] args){
        StudentArchive studentArchive = new StudentArchive();
        studentArchive.printL2R();
        studentArchive.printR2L();
        studentArchive.printTree();
        studentArchive.printFirstStudent();
        studentArchive.printLastStudent();
        studentArchive.printInOddOrder();
    }
}