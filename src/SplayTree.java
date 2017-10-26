public class SplayTree<E extends Comparable<E>> extends BinarySearchTreeWithRotate<E> {

    @Override
    public boolean add(E item) {

        root = add(root, item);

        //Accounts for a base case
        if (root.data != null && root.data != item) {
            if (root.right != null && root.right.data == item) {
                root = rotateLeft(root);
            } else {
                root = rotateRight(root);
            }
        }
        return addReturn;
    }

    private Node<E> splayRotate(Node<E> grandparent, E item) {
        Node<E> comparatorNode = new Node<E>(item);

        if(grandparent.left == null && grandparent.right != null && grandparent.right.right != null
                && grandparent.right.right.data == comparatorNode.data) {
            Node<E> parent = grandparent.right;
            Node<E> child = parent.right;

            rotateLeft(grandparent);
            rotateLeft(parent);

            return child;
        }
        //case 4
        if (grandparent.left == null && grandparent.right != null && grandparent.right.left != null
                && grandparent.right.left.data == comparatorNode.data) {
            Node<E> parent = grandparent.right;
            Node<E> child = parent.left;

            rotateRight(parent);
            rotateLeft(grandparent);

            return child;
        }
        //case 1
        if (grandparent.right == null && grandparent.left != null && grandparent.left.left != null
                && grandparent.left.left.data == comparatorNode.data) {
            Node<E> parent = grandparent.left;
            Node<E> child = parent.left;
            rotateRight(grandparent);
            rotateRight(parent);

            return child;
        }
        //case 3
        if (grandparent.right == null && grandparent.left != null && grandparent.left.right != null
                && grandparent.left.right == comparatorNode.data) {
            Node<E> parent = grandparent.left;
            Node<E> child = parent.right;
            rotateLeft(parent);
            rotateRight(grandparent);

            return child;
        }
        return grandparent;
    }

    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<E>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return splayRotate(localRoot, item);
        } else {
            localRoot.right = add(localRoot.right, item);
            return splayRotate(localRoot, item);
        }
    }
}
