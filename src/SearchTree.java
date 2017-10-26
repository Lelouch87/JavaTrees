interface SearchTree<E> {
    boolean add(E obj);
    boolean contains(E obj);
    E find(E target);
    E delete(E target);
    E remove(E target);
}
