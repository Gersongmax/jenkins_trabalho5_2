package br.unicamp.ic.inf335.app.trabalho5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProdutoBeanTest {

	@Test
	void test() {
		
		var produtoMenorValor = new ProdutoBean();
		produtoMenorValor.setDescricao("Descricao do item");
		produtoMenorValor.setNome("Blabla");
		produtoMenorValor.setCodigo("XYZ");		
		produtoMenorValor.setEstado("Bom");
		produtoMenorValor.setValor(50.0);
		
		
	assertEquals("Descricao do item", produtoMenorValor.getDescricao());
	assertEquals("Blabla", produtoMenorValor.getNome());
	assertEquals("XYZ", produtoMenorValor.getCodigo());
	assertEquals("Bom", produtoMenorValor.getEstado());
	assertEquals(50.0 , produtoMenorValor.getValor());
	
	var produtoMaiorValor = new ProdutoBean();
	produtoMaiorValor.setDescricao("Descricao do item");
	produtoMaiorValor.setNome("prod caro");
	produtoMaiorValor.setCodigo("ABC");		
	produtoMaiorValor.setEstado("Otimo");
	produtoMaiorValor.setValor(100.0);
	
	
assertEquals("Descricao do item", produtoMaiorValor.getDescricao());
assertEquals("prod caro", produtoMaiorValor.getNome());
assertEquals("ABC", produtoMaiorValor.getCodigo());
assertEquals("Otimo", produtoMaiorValor.getEstado());
assertEquals(100.0 , produtoMaiorValor.getValor());

assertEquals (0,produtoMenorValor.compareTo(produtoMaiorValor));
assertEquals (1,produtoMaiorValor.compareTo(produtoMenorValor));

	
	
		
		
		
	}


 



	
		
		

}