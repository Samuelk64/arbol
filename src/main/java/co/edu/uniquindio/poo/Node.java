package co.edu.uniquindio.poo;

public class Node<T extends Comparable<T>>{
    private T value;
    private Node<T> rightChild;
    private Node<T> leftChild;

    
     public Node(T value){
        this.value = value;
        this.rightChild = null;
        this.leftChild = null;
     }
    

    public Node<T> getRight(){
        return rightChild;
    }

    public Node<T> getLeft(){
        return leftChild;
    }

    public T getValue(){
        return value;
    }


    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }


    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }


    public void setValue(T value) {
        this.value = value;
    }


    
}
