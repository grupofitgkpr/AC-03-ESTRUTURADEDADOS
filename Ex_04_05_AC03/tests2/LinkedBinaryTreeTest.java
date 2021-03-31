package tests2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source2.LinkedBinaryTree;
import source2.BTNode;
import tad_lista_de_nodos2.Position;

/*
Integrantes: 							   	 RA: 
* Giovanni Assis Lopes					|	 1903604
* Kaique Mantoanelli Silva				|	 1903168
* Pedro Henrique Oliveira Dantas Lopes	|	 1904007
* Rafael Serino Kiss					|	 1903107
*/

class LinkedBinaryTreeTest {
	@Test
	void TesteAC3() {
		// Arvore Z criada a partir da �rvore do slide 30
		LinkedBinaryTree<String> Z = criarArvoreZ();
		Position<String> raiz = Z.root();
		
		assertEquals("-/*+313+-952+*3-746", Z.binaryPreorder(Z, raiz));
		assertEquals("31+3*95-2+/374-*6+-", Z.binaryPostorder(Z, raiz));
		
		assertEquals(4, Z.countLeft(Z), "A arvore Z tem 4 nodos esquerdos e externos");
		assertEquals(6, Z.countRight(Z), "A arvore Z tem 6 nodos direitos e externos");
		
		Z.printExpression(Z, raiz);
		System.out.println("<- Express�o gerada");
		System.out.println("((((3+1)*3)/((9-5)+2))-((3*(7-4))+6))<- Express�o do slide");
	}
	
	public LinkedBinaryTree<String> criarArvoreZ() {
		LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
		BTNode<String> raiz, v, m, k, f, b, c, d, e;
		
		T.addRoot("-");
		raiz = (BTNode<String>) T.root();
		
		//Lado Esquerdo da raiz
		v = (BTNode<String>) T.insertLeft(raiz, "/");
		
		m = (BTNode<String>) T.insertLeft(v, "*");
		T.insertRight(m, "3");
		
		f = (BTNode<String>) T.insertRight(v, "+");
		T.insertRight(f, "2");
		
		b = (BTNode<String>) T.insertLeft(f, "-");
		T.insertLeft(b, "9");
		T.insertRight(b, "5");
		
		k = (BTNode<String>) T.insertLeft(m, "+");
		T.insertLeft(k, "3");
		T.insertRight(k, "1");
		
		//Lado direito da raiz
		c = (BTNode<String>) T.insertRight(raiz, "+");
		T.insertRight(c, "6");
		
		d = (BTNode<String>) T.insertLeft(c, "*");
		T.insertLeft(d, "3");
		
		e = (BTNode<String>) T.insertRight(d, "-");
		T.insertLeft(e, "7");
		T.insertRight(e, "4");
		
		return T;
	}	
	
	@Test
	void test() {
		LinkedBinaryTree<String> T = criarArvoreT();
		Position<String> raiz = T.root();
		
		assertEquals("Voc� � estressado?", T.root().element());
		assertEquals(true ,T.hasLeft(raiz));
		assertEquals(true ,T.hasRight(raiz));
		
		assertEquals("Conta Poupan�a", T.left(raiz).element());
		assertEquals("Voc� vai precisar de dinheiro nos pr�ximos 5 anos?", T.right(raiz).element());
		
		Position<String> nao = T.right(raiz);
		
		assertEquals(true ,T.hasLeft(nao));
		assertEquals(true ,T.hasRight(nao));
		
		assertEquals("Fundo de Aplica��o", T.left(nao).element());
		assertEquals("Voc� aceita correr riscos na transa��o em troca de ganhos maiores?", T.right(nao).element());
		
		Position<String> nao2 = T.right(nao);
		
		assertEquals(true ,T.hasLeft(nao2));
		assertEquals(true ,T.hasRight(nao2));
		
		assertEquals("Carteira de a��es", T.left(nao2).element());
		assertEquals("Carteira diversificada com a��es, t�tulos e aplica��es de curto prazo", T.right(nao2).element());
		
		assertEquals(3, T.countLeft(T));
		assertEquals(1, T.countRight(T));
		
	}
	
	public LinkedBinaryTree<String> criarArvoreT() {
		LinkedBinaryTree<String> T = new LinkedBinaryTree<String>();
		BTNode<String> raiz, v, m;
		
		T.addRoot("Voc� � estressado?");
		raiz = (BTNode<String>) T.root();
		
		T.insertLeft(raiz, "Conta Poupan�a");
		v = (BTNode<String>) T.insertRight(raiz, "Voc� vai precisar de dinheiro nos pr�ximos 5 anos?");
		
		T.insertLeft(v, "Fundo de Aplica��o");
		m = (BTNode<String>) T.insertRight(v, "Voc� aceita correr riscos na transa��o em troca de ganhos maiores?");
		
		T.insertLeft(m, "Carteira de a��es");
		T.insertRight(m, "Carteira diversificada com a��es, t�tulos e aplica��es de curto prazo");
		
		return T;
	}	
}
