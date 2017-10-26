public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree<String> AVLTree = new AVLTree<>();


        AVLTree.add("The");
        AVLTree.add("quick");
        AVLTree.add("brown");
        AVLTree.add("fox");
        AVLTree.add("jumps");
        AVLTree.add("over");
        AVLTree.add("the");
        AVLTree.add("lazy");
        AVLTree.add("dog");

        AVLTree.add("apple");
        AVLTree.add("cat");
        AVLTree.add("hat");

        System.out.println(AVLTree.toString());


        BinarySearchTree<Integer> BST = new BinarySearchTree<>();
        AVLTree<Integer> integerAVLTree = new AVLTree<>();

        int temp;
        for (int i = 0; i < 10; i++) {
            temp = (int) (100 * Math.random());
            integerAVLTree.add(temp);
            BST.add(temp);
        }
        System.out.println("Preorder Traversals");
        System.out.println(integerAVLTree.toString());
        System.out.println();
        System.out.println(BST.toString());



        System.out.println("Inorder Traversals");
        System.out.println(integerAVLTree.inOrderTraversal());
        System.out.println();
        System.out.println(BST.inOrderTraversal());
        System.out.println();
        System.out.println("Generally, the standard BinarySearchTree is has a much greater height than the AVL Tree");
    }
}
