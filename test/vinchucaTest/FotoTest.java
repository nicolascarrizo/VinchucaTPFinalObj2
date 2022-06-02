package vinchucaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


import vinchuca.Foto;

public class FotoTest {
	
	private String link;
	private Foto foto;
	
	@Before
	public void setUp() {
		
		link = "link de imagen";
		foto = new Foto();
	}
	
	@Test
	public void testFoto() {
		foto.setLink(link);
		assertEquals(foto.getLink(), link);
	}
	

}
