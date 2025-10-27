package co.edu.uniquindio.poo;

import java.io.FileWriter;
import java.io.IOException;

public class Tree<T extends Comparable<T>>{
    private Node<T> root;

    public Tree(){
        this.root = null;
    }

    public Node<T> getRoot(){
        return root;
    }

    public void addValue(T value) {
        root = insertRec(root, value);  
    }

    private Node<T> insertRec(Node<T> current, T value) {

        if (current == null) {
            return new Node<>(value);
        }

        //cmp compara el valor ingresado con el valor actual del nodo

        int cmp = value.compareTo(current.getValue());

        if (cmp == 0) {
            throw new IllegalArgumentException("Error: The value already exists in the tree");
        } 
            
        else if (cmp < 0) {
            current.setLeftChild(insertRec(current.getLeft(), value));
        } 
            
        else {
            current.setRightChild(insertRec(current.getRight(), value));
        }

        return current;
    }

    public void inOrder(){
        this.inOrder(root);
    }


    private void inOrder(Node<T> root){
	    if(root == null){
		    return;
        }

        inOrder(root.getLeft());
        System.out.println(root.getValue());
        inOrder(root.getRight());
    }

    public void preOrder(){
        this.preOrder(root);
    }


    private void preOrder(Node<T> root){
	    if(root == null){
		    return;
        }

        System.out.println(root.getValue());
        inOrder(root.getLeft());
        inOrder(root.getRight());
    }

    public void postOrder(){
        this.postOrder(root);
    }


    private void postOrder(Node<T> root){
	    if(root == null){
		    return;
        }

        System.out.println(root.getValue());
        postOrder(root.getLeft());
        postOrder(root.getRight());
    }

    public T findMin(){
        return findMin(root).getValue();
    }

    private Node<T> findMin(Node<T> root){

        if(root == null){
            return null;
        }

        if(root.getLeft() == null){
            return root;
        }

        return findMin(root.getLeft());

    }

    public T findMax(){
        return findMax(root).getValue();
    }

    private Node<T> findMax(Node<T> root){

        if(root == null){
            return null;
        }

        if(root.getRight() == null){
            return root;
        }

        return findMax(root.getRight());

    }

    public T findMaxFather(){
        return findMaxFather(root).getValue();
    }

    private Node<T> findMaxFather(Node<T> root){
         if(root == null){
            return null;
        }

        if(root.getLeft() == null && root.getRight() == null){
            return null;
        }

        if(root.getRight().getValue() == findMax(root).getValue()){
            return root;
        }

        return findMaxFather(root.getRight());

    }

    public void deleteNode(T value){
        Node<T> newRoot = findNode(value);
        this.deleteNode(newRoot);
    }

    private void deleteNode(Node<T> node){
        var nod = findMax(node.getLeft());
        var father = findMaxFather(node.getLeft());
        
        

        if(node.getRight() == null && node.getLeft() == null){
            node.setValue(null);
            //father.setValue(null);
        }

        if(node.getRight() == null && node.getLeft() != null){

            father.setValue(node.getLeft().getValue());
            nod.setValue(null);
        }

        if(node.getRight() != null && node.getLeft() == null){
            father.setValue(node.getRight().getValue());
            nod.setValue(null);
        }

        if(node.getRight() != null && node.getLeft() != null){
            node.setValue(nod.getValue());
            nod.setValue(null);
        }
    
    }

    public Node<T> findNode(T value) {
        return findNode(root, value);
    }

    private Node<T> findNode(Node<T> root, T value) {
        if (root == null) {
            return null;
        }

        int cmp = root.getValue().compareTo(value);

        if (cmp == 0) {
            return root;
        } else if (cmp > 0) {
            return findNode(root.getLeft(), value);
        } else {
            return findNode(root.getRight(), value);
        }
    }

    public void exportGraphviz(String archiveName) {

        archiveName = archiveName + ".dot";

    try (FileWriter writer = new FileWriter(archiveName)) {
        writer.write("digraph G {\n");
        writer.write("    node [shape=circle, style=filled, color=lightblue];\n");
        if (root != null) {
            exportRec(root, writer);
        }

        writer.write("}\n");
        System.out.println("DOT archive generated: " + archiveName);
    } 
    
    catch (IOException e) {
        e.printStackTrace();
    }

    }

    private void exportRec(Node<T> node, FileWriter writer) throws IOException {

    if (node == null) return;

    if (node.getLeft() != null) {
        writer.write("    \"" + node.getValue() + "\" -> \"" + node.getLeft().getValue() + "\";\n");
        exportRec(node.getLeft(), writer);
    }

    if (node.getRight() != null) {
        writer.write("    \"" + node.getValue() + "\" -> \"" + node.getRight().getValue() + "\";\n");
        exportRec(node.getRight(), writer);
    }
}
    
}



