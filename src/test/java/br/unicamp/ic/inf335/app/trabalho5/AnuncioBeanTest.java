package br.unicamp.ic.inf335.app.trabalho5;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AnuncioBeanTest {
	@Test
	void anuncioBeanTest() throws MalformedURLException {
		assertEquals(1L,AnuncioBean.getSerialversionuid());
		var produto = new ProdutoBean("Prodcod", "Prodnome","ProdDesc",100.0, "Bom");
		var urls = new ArrayList<>(
				List.of(new URL("http://tesyte.com/imagem1.png"),
						new URL("http://tesyte.com/imagem2.png"))
				);
		var anuncio =new AnuncioBean();
		anuncio.setProduto(produto);
		anuncio.setFotosUrl(urls);
		anuncio.setDesconto(0.1);
		
		assertEquals(produto,anuncio.getProduto());
		assertEquals (urls,anuncio.getFotosUrl());
		assertEquals(0.1, anuncio.getDesconto());
		assertEquals(90.0, anuncio.getValor());
		
		var anuncio2 = new AnuncioBean(produto,urls,0.0);
		assertEquals(100.0,anuncio2.getValor());
		
	}



}
