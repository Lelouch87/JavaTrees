public class AVLTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {
    private boolean increase;

    public boolean add(E item) {
        increase = false;
        root = add((AVLNode<E>) root, item);
        return addReturn;
    }

    private AVLNode<E> add(AVLNode<E> localRoot, E item) {
        //Steps 1-2
        //1) If the root is null
        if (localRoot == null) {
            //2) Create a new tree with the item at the root and return true
            addReturn = true;
            increase = true;
            return new AVLNode<E>(item);
        //else if the item is equal to the localRoot.data
        } else if (item.compareTo(localRoot.data) == 0) {
            //item is already in the tree, return false
            increase = false;
            addReturn = false;
            return localRoot;
        //else if the item is less than root.data
        } else if (item.compareTo(localRoot.data) < 0) {
            //Recursively insert the item in the left subtree
            localRoot.left = add((AVLNode<E>) localRoot.left, item);
            //if increase is true (the height of the left subtree has increased)
            if (increase) {
                //then decrement balance
                decrementBalance(localRoot);
                //if balance is less than -1,
                if (localRoot.balance < AVLNode.LEFT_HEAVY) {
                    //reset increase to false
                    increase = false;
                    //perform a rebalanceLeft
                    return rebalanceLeft(localRoot);
                }
            }
            return localRoot;
        //else if the item is greater than the root.data
        } else {
            //Recursively insert the item in the right subtree
            localRoot.right = add((AVLNode<E>) localRoot.right, item);
            //if increase is true (the height of the right subtree has increased)
            if (increase) {
                //then increment balance
                incrementBalance(localRoot);
                //if balance is greater than 1,
                if (localRoot.balance > AVLNode.RIGHT_HEAVY) {
                    //reset increase to false
                    increase = false;
                    //perform a rebalanceRight
                    return rebalanceRight(localRoot);
                }
            }
            return localRoot;
        }

    }

    private AVLNode<E> rebalanceLeft(AVLNode<E> localRoot) {
        AVLNode<E> leftChild = (AVLNode<E>) localRoot.left;
        //See whether left-right Heavy
        if (leftChild.balance > AVLNode.BALANCED) {
            AVLNode<E> leftRightChild = (AVLNode<E>) leftChild.right;
            //Left-right-left case
            if (leftRightChild.balance < AVLNode.BALANCED) {
                leftChild.balance = AVLNode.BALANCED;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.RIGHT_HEAVY;
                //left-right-right case
            } else if (leftRightChild.balance > AVLNode.BALANCED) {
                leftChild.balance = AVLNode.LEFT_HEAVY;
                leftRightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
                //left-right balanced case
            } else {
                leftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.left = rotateLeft(leftChild);
        } else { //Left-left case
            leftChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        return (AVLNode<E>) rotateRight(localRoot);
    }

    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot) {
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;

        //See whether right-left heavy
        if (rightChild.balance < AVLNode.BALANCED) {
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;
            //right-left-right case
            if (rightLeftChild.balance > AVLNode.BALANCED) {
                rightChild.balance = AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
                //right-left-left case
            } else if (rightLeftChild.balance < AVLNode.BALANCED) {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
                //right-left balanced case
            } else {
                rightChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }
            localRoot.right = rotateRight(rightChild);
        } else { //right-right case
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }
        return (AVLNode<E>) rotateLeft(localRoot);
    }

    private void decrementBalance(AVLNode<E> node) {
        node.balance--;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }

    private void incrementBalance(AVLNode<E> node) {
        node.balance++;
        if (node.balance == AVLNode.BALANCED) {
            increase = false;
        }
    }


    public E delete(E target) {
        root = delete((AVLNode<E>) root, target);
        return deleteReturn;
    }

    private AVLNode<E> delete(AVLNode<E> localRoot, E target) {
        //Stubbed out
        return null;
    }

    private static class AVLNode<E> extends Node<E> {
        public static final int LEFT_HEAVY = -1;
        public static final int BALANCED = 0;
        public static final int RIGHT_HEAVY = 1;
        private int balance;

        public AVLNode(E item) {
            super(item);
            balance = BALANCED;
        }

        @Override
        public String toString() {
            return balance + ": " + super.toString();
        }
    }
}
