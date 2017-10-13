package tests;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void testPays() {
		assertEquals("Luxembourg", Normalisation.Pays("letzebuerg"));
		assertEquals("Belgique", Normalisation.Pays("belgium"));
		assertEquals("Suisse", Normalisation.Pays("Switzerland"));
		assertEquals("Suisse", Normalisation.Pays("Schweiz"));
	}
	
	@Test
	public void testVille() {
		assertEquals("Metz", Normalisation.Ville("metz"));
		assertEquals("Maizi�res-l�s-Metz", Normalisation.Ville("maizi�res l�s metz"));
		assertEquals("Saint-Julien-l�s-Metz", Normalisation.Ville("saint julien l�s metz"));
	}
	
	@Test
	public void testCodePostal() {
		assertEquals("57280", Normalisation.CodePostal("F-57280"));
		assertEquals("03943", Normalisation.CodePostal("3943"));
		assertEquals("00004", Normalisation.CodePostal("4"));
		assertEquals("8200", Normalisation.CodePostal("F-8200"));
	}
	
	@Test
	public void testNoVoie() {
		assertEquals("3, rue des alouettes", Normalisation.no_voie("3 rue des alouettes"));
		assertEquals("34, rue des alouettes", Normalisation.no_voie("34 rue des alouettes"));
		
	}
	
}
