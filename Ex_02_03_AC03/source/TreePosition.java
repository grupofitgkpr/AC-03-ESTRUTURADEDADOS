package source;
import tad_lista_de_nodos.Position;
import tad_lista_de_nodos.PositionList;

// Interface para um nodo de uma �rvore. O nodo da �rvore
// mant�m um elemento, um nodo pai, um nodo para a filhos
// como um TAD Lista de Nodos.
public interface TreePosition<E> extends Position<E> {
	// Define o elemento a ser armazenado nesta posi��o
	public void setElement(E o);
	// Retorna o elemento armazenado nesta posi��o
	public E getElement();
	// Retorna os filhos desta posi��o
	public PositionList<Position<E>> getChildren();
	// Define os filhos desta posi��o
	public void setChildren(PositionList<Position<E>> c);
	// Retorna o pai desta posi��o
	public TreePosition<E> getParent();
	// Define o pai desta posi��o
	public void setParent(TreePosition<E> v);
}