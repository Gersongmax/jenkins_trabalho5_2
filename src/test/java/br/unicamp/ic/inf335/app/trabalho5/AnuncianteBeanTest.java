package br.unicamp.ic.inf335.app.trabalho5;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class AnuncianteBeanTest {

	@Test
	void anuncianteBeanTest() throws MalformedURLException {
		var produto = new ProdutoBean("Prodcod", "Prodnome","ProdDesc",100.0, "Bom");
		var produto2 = new ProdutoBean("Prodcod1", "Prodnome2","ProdDesc",50.0, "pessimo");
		var urls = new ArrayList<>(
				List.of(new URL("http://tesyte.com/imagem1.png"),
						new URL("http://tesyte.com/imagem2.png"))
				);
		var anuncio =new AnuncioBean();
		anuncio.setProduto(produto);
		anuncio.setFotosUrl(urls);
		anuncio.setDesconto(0.1);
		
		var anuncio2 =new AnuncioBean();
		anuncio2.setProduto(produto2);
		anuncio2.setFotosUrl(urls);
		anuncio2.setDesconto(0.5);
		
		var anunciante = new AnuncianteBean();
		anunciante.setNome("jose");
		anunciante.setCPF("272727818-74");
		anunciante.setAnuncios(new ArrayList<>(List.of(anuncio, anuncio2)));
		
		assertEquals("jose", anunciante.getNome());
		assertEquals("272727818-74", anunciante.getCPF());
		assertIterableEquals(List.of(anuncio,anuncio2), anunciante.getAnuncios());
		
		var anuncio3 = new AnuncioBean();
		anuncio3.setProduto(produto2);
		anuncio3.setFotosUrl(urls);
		anuncio3.setDesconto(0.5);
		
		//teste com 2 produtos (100*10% + 50*50% divido por 2 ) = (90+25)/2 = 57.5
		assertEquals(57.5, anunciante.valorMedioAnuncios());
		
		anunciante.addAnuncio(anuncio3);
		assertIterableEquals(List.of(anuncio, anuncio2,anuncio3),anunciante.getAnuncios());
		
		// teste com 3 produtos (100*10% +50*50% +50*50%)= (90+25+25)/3 = 46,6
		assertEquals(46.666666666666664, anunciante.valorMedioAnuncios());
		
		anunciante.removeAnuncio(0);
		assertIterableEquals(List.of(anuncio2, anuncio3),anunciante.getAnuncios());
		
		//Com dois produtos (25+25)/2 produto anuncio 2 e anuncio3
		
		assertEquals((25+25) /2 , anunciante.valorMedioAnuncios());
		
		var anunciante2 = new AnuncianteBean ("Maria", "121212454-66", new ArrayList<>());
		assertEquals(0, anunciante2.getAnuncios().size());
		
		
		
		
	}

}
