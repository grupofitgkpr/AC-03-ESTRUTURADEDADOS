package source2;

import exceptions2.BoundaryViolationException;
import exceptions2.InvalidPositionException;
import tad_lista_de_nodos2.Position;

public interface BinaryTree<E> extends Tree<E> {

    public Position<E> left(Position<E> v) throws InvalidPositionException, BoundaryViolationException;

    public Position<E> right(Position<E> v) throws InvalidPositionException, BoundaryViolationException;

    public boolean hasLeft(Position<E> v) throws InvalidPositionException;

    public boolean hasRight(Position<E> v) throws InvalidPositionException;
}
