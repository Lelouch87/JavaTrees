public class SplayTreeDriver {
    public static void main(String[] args) {
        SplayTree<Integer> splayTree1 = new SplayTree<>();
        SplayTree<Integer> splayTree2 = new SplayTree<>();
        SplayTree<Integer> splayTree3 = new SplayTree<>();
        SplayTree<Integer> splayTree4 = new SplayTree<>();

        System.out.println("Tests for a case 1: ");
        splayTree1.add(3);
        splayTree1.add(2);
        splayTree1.add(1);

        System.out.println(splayTree1.toString());

        System.out.println("Tests for a case 2: ");
        splayTree2.add(1);
        System.out.println(splayTree2.toString());
        splayTree2.add(2);
        System.out.println(splayTree2.toString());
        splayTree2.add(3);
        System.out.println(splayTree2.toString());
        splayTree2.add(4);

        System.out.println(splayTree2.toString());

        System.out.println("Tests for a case 3: ");

        splayTree3.add(8);
        splayTree3.add(2);
        splayTree3.add(9);
        splayTree3.add(3);
        splayTree3.add(5);
        System.out.println(splayTree3.toString());

        System.out.println("Tests for a case 4: ");

    }
}
