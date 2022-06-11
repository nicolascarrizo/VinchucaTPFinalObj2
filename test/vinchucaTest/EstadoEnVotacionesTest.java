package vinchucaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import vinchuca.EstadoEnVotacion;
import vinchuca.Muestra;
import vinchuca.Opinion;
import vinchuca.Usuario;

public class EstadoEnVotacionesTest {
	
	EstadoEnVotacion estadoEnVotacion;
	Opinion opinionA;
	Opinion opinionB;
	Opinion opinionC;
	Usuario usuario;
	Muestra muestra;
	
	@Before
	public void setUp() {
		
		estadoEnVotacion = new EstadoEnVotacion();
		usuario = mock(Usuario.class);
		muestra = mock(Muestra.class);
		opinionA = new Opinion("Chinche", usuario, muestra);
		opinionB = new Opinion("Vinchuca", usuario, muestra);
		opinionC = new Opinion("Vinchuca", usuario, muestra);
		
	}
	
	@Test
	public void especieMasOpiniadaEnVotacionTest() {
		
		List<Opinion> opinionesList = new ArrayList<Opinion>();
		opinionesList.add(opinionA);
		opinionesList.add(opinionB);
		opinionesList.add(opinionC);
		
		assertEquals(estadoEnVotacion.getEspecie(opinionesList), "Vinchuca");
		
	}
	
	@Test
	public void especieMasOpiniadaEmpateTest() {
		
		Opinion opinion1 = new Opinion("Chinche", usuario, muestra);
		Opinion opinion2 = new Opinion("Vinchuca", usuario, muestra);
		Opinion opinion3 = new Opinion("Vinchuca", usuario, muestra);
		Opinion opinion4 = new Opinion("Chinche", usuario, muestra);
		
		List<Opinion> opinionesList = new ArrayList<Opinion>();
		opinionesList.add(opinion1);
		opinionesList.add(opinion2);
		opinionesList.add(opinion3);
		opinionesList.add(opinion4);
		
		assertEquals(estadoEnVotacion.getEspecie(opinionesList), "En Votacion");
		
	}


}
