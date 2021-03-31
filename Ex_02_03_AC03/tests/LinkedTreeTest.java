package tests;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import source.LinkedTree;
import source.TreeNode;
import source.TreePosition;
import tad_lista_de_nodos.NodePositionList;
import tad_lista_de_nodos.Position;
import tad_lista_de_nodos.PositionList;


/*
   Integrantes: 							 R.A: 
 * Giovanni Assis Lopes					|	 1903604
 * Kaique Mantoanelli Silva				|	 1903168
 * Pedro Henrique Oliveira Dantas Lopes	|	 1904007
 * Rafael Serino Kiss					|	 1903107
*/


class LinkedTreeTest {
	@Test
	void testSlide() { //Teste id�ntico ao do slide que tem todas as fun��es do exercicio 3
		TreePosition<String> raiz;
		Position<Position<String>> p, s;
		PositionList<Position<String>> filhos;
		LinkedTree<String> T = criarArvoreT();
		System.out.println(T.parentheticRepresentation(T, T.root()));
		System.out.println(T.toStringPostorder(T, T.root()));
	
		assertFalse(T.isEmpty());
		assertEquals(4, T.height1(T), "Altura da �rvore T");
		assertEquals(4, T.height2(T, T.root()), "Altura da �rvore T");
		assertEquals("[Eletronics R'Us, P&D, Vendas, Internacional, Canad�, Am�rica do Sul, "
					+ "Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pr�-ordem da �rvore T ");
		
		
		raiz = T.root();
		filhos = raiz.getChildren();
		p = filhos.first();
		assertEquals("P&D", p.element().element(), "P&D");
		assertTrue(T.isExternal(p.element()));
		assertEquals(raiz, T.parent(p.element()), "Deve ser a raiz");
	
		s = filhos.next(p);
		assertEquals("Vendas", s.element().element(), "Vendas");
		assertTrue(T.isInternal(s.element()));
		assertEquals(1, T.depth(T, s.element()), "");
	
		T.replace(p.element(), "Pesquisa e Desenvolvimento");
		assertEquals("[Eletronics R'Us, Pesquisa e Desenvolvimento, Vendas, Internacional, Canad�, Am�rica do Sul, "
					+ "Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pr�-ordem da �rvore T ");
		assertTrue(T.isRoot(raiz));
	
		T.swapElements(p.element(), s.element());
		assertEquals("[Eletronics R'Us, Vendas, Pesquisa e Desenvolvimento, Internacional, Canad�, Am�rica do Sul, "
					+"Ultramar, �frica, Europa, �sia, Austr�lia, Nacional, Compras, Manufatura, TV, CD, Tuner]",
		T.toString(), "Pr�-ordem da �rvore T ");
	}

	private TreeNode<String> criarFilho(TreeNode<String> p, String n) {
		PositionList<Position<String>> filhos;
		TreeNode<String> aux;
		
		// Obt�m os Filhos de p
		filhos = p.getChildren();
		// Cria um novo filho
		aux = new TreeNode<String>();
		aux.setElement(n);
		aux.setParent(p);
		aux.setChildren(new NodePositionList<Position<String>>());
		filhos.addLast(aux);
		return aux;
	}

	public LinkedTree<String> criarArvoreT() {
		LinkedTree<String> T = new LinkedTree<String>();
		TreeNode<String> raiz, v, m, i, u;
		
		T.addRoot("Eletronics R'Us");
		raiz = (TreeNode<String>) T.root();
		raiz.setChildren(new NodePositionList<Position<String>>());
		
		// Filhos da raiz: Eletronic R'Us
		criarFilho(raiz, "P&D");
		v = criarFilho(raiz, "Vendas");
		criarFilho(raiz, "Compras");
		m = criarFilho(raiz, "Manufatura");
		// Filhos de Vendas
		i = criarFilho(v, "Internacional");
		criarFilho(v, "Nacional");
		// Filhos de Internacional
		criarFilho(i, "Canad�");
		criarFilho(i, "Am�rica do Sul");
		u = criarFilho(i, "Ultramar");
		// Filhos de Ultramar
		criarFilho(u, "�frica");
		criarFilho(u, "Europa");
		criarFilho(u, "�sia");
		criarFilho(u, "Austr�lia");
		// Filhos de Manufatura
		criarFilho(m, "TV");
		criarFilho(m, "CD");
		criarFilho(m, "Tuner");
		return T;
	}	
}

