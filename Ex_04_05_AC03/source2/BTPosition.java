package source2;

import tad_lista_de_nodos2.Position;

public interface BTPosition<E> extends Position<E> {

    public E element();

    public void setElement(E o);

    public BTPosition<E> getLeft();

    public void setLeft(BTPosition<E> v);

    public BTPosition<E> getRight();

    public void setRight(BTPosition<E> v);

    public BTPosition<E> getParent();

    public void setParent(BTPosition<E> v);
}
