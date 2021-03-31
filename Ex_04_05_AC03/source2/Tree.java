package source2;

import java.util.Iterator;

import exceptions2.BoundaryViolationException;
import exceptions2.EmptyTreeException;
import exceptions2.InvalidPositionException;
import tad_lista_de_nodos2.Position;

public interface Tree<E> extends Iterable<E> {

    public int size();

    public boolean isEmpty();

    public Iterator<E> iterator();

    public Iterable<Position<E>> positions();

    public E replace(Position<E> v, E e) throws InvalidPositionException;

    public Position<E> root() throws EmptyTreeException;

    public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException;

    public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException;

    public boolean isInternal(Position<E> v) throws InvalidPositionException;

    public boolean isExternal(Position<E> v) throws InvalidPositionException;

    public boolean isRoot(Position<E> v) throws InvalidPositionException;
}
