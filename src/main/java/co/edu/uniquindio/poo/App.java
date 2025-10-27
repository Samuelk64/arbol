package co.edu.uniquindio.poo;

/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.addValue(10);
        tree.addValue(5);
        tree.addValue(15);
        tree.addValue(3);
        tree.addValue(7);
        tree.addValue(12);
        tree.addValue(18);

        
    
        tree.deleteNode(5);
        
        tree.exportGraphviz("arbol3");
        


    

        

        

        
       

    
        
        


    }
}
