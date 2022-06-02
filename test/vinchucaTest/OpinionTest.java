package vinchucaTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import vinchuca.Muestra;
import vinchuca.Opinion;
import vinchuca.Usuario;

public class OpinionTest {
	
	Muestra muestra;
	Opinion opinion;
	Usuario usuario;
	
	private LocalDate fecha;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	
	@Before
	public void setUp() {
		muestra = mock(Muestra.class);
		usuario = mock(Usuario.class);
		opinion = new Opinion("Vinchuca", usuario, muestra);
		
	}
	
	@Test
	public void constructorTest() {
		fecha = LocalDate.now();
		
		assertEquals(opinion.getEspecie(), "Vinchuca");
		assertEquals(opinion.getUsuario(), usuario);
		assertEquals(opinion.getDiaDeCreacion(), formatter.format(fecha));
		verify(muestra).agregarOpinion(opinion);
	}
	
	@Test
	public void esOpinionAntigua() {
		assertFalse(opinion.esOpinionAntigua());
		fecha = LocalDate.of(2004, 01, 10);
		opinion.setDiaDeCreacion(fecha);
		assertTrue(opinion.esOpinionAntigua());
		
		
	}
	

}
