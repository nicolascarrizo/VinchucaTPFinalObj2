package vinchucaTest;

import vinchuca.EstadoVerificada;
import vinchuca.Muestra;
import vinchuca.Opinion;
import vinchuca.Usuario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

public class EstadoVerificadaTest {
	
	
	EstadoVerificada estadoVerificada;
	Opinion opinionA;
	Opinion opinionB;
	Opinion opinionC;
	Usuario usuario;
	Muestra muestra;
	
	@Before
	public void setUp() {
		
		estadoVerificada = new EstadoVerificada();
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		opinionA = new Opinion("Chinche", usuario, muestra);
		opinionB = new Opinion("Vinchuca", usuario, muestra);
		opinionC = new Opinion("Vinchuca", usuario, muestra);
		
	}
	
	
	@Test
	public void getEspecieOpinadaTest() {
		
		List<Opinion> opinionesList = new ArrayList<Opinion>();
		opinionesList.add(opinionA);
		opinionesList.add(opinionB);
		opinionesList.add(opinionC);
		
		assertEquals(estadoVerificada.getEspecie(opinionesList), "Vinchuca");
	}

}
