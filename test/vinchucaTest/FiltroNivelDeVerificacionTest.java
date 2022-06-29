package vinchucaTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import vinchuca.FiltroNivelDeVerificacion;
import vinchuca.Foto;
import vinchuca.Muestra;
import vinchuca.Ubicacion;
import vinchuca.Usuario;
import vinchuca.Zonas;

public class FiltroNivelDeVerificacionTest {

	FiltroNivelDeVerificacion recoleccion;
	Muestra muestraA;
	Muestra muestraB;
	Muestra muestraC;
	Usuario usuario1;
	Usuario usuario2;
	Foto foto;
	Ubicacion ubicacion;
	Zonas zonas;
	LocalDate fecha;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	
	@Before
	public void setup() {
		
		usuario1 = new Usuario("Lucas", false);
		foto = mock(Foto.class);
		ubicacion = mock(Ubicacion.class);
		zonas = mock(Zonas.class);
		recoleccion = new FiltroNivelDeVerificacion();
		
	}
	
	
	@Test
	public void muestrasPorNivelDeVerificacionTest() {
		
		assertTrue(recoleccion.filtrarMuestras("Verificada").isEmpty());
		muestraA = new Muestra("Araña", usuario1, foto, ubicacion, recoleccion, zonas);
		assertEquals(recoleccion.filtrarMuestras("En Votacion").size(), 1);
	
		Usuario usuarioA = new Usuario("Jorge", true);
		Usuario usuarioB = new Usuario("Sofia", true);
		
		usuarioA.opinarMuestra(muestraA, "Vinchuca");
		usuarioB.opinarMuestra(muestraA, "Vinchuca");
		
		assertEquals(recoleccion.filtrarMuestras("En Votacion").size(), 0);
		assertEquals(recoleccion.filtrarMuestras("Verificada").size(), 1);
		
		Usuario usuarioC = new Usuario("Pepe", false);
		Usuario usuarioD = new Usuario("Lucas", false);
		
		usuarioC.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		usuarioD.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		
		assertEquals(recoleccion.filtrarMuestras("En Votacion").size(), 2);
	}
	

}
