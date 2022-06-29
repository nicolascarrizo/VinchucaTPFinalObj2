package vinchucaTest;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.junit.Assert.*;
import org.junit.Test;


import static org.mockito.Mockito.*;

import org.junit.Before;

import vinchuca.FiltroTipoInsecto;
import vinchuca.Foto;
import vinchuca.Muestra;
import vinchuca.Ubicacion;
import vinchuca.Usuario;
import vinchuca.Zonas;

public class FiltroTipoInsectoTest {
	
	FiltroTipoInsecto recoleccion;
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
		recoleccion = new FiltroTipoInsecto();
		
	}
	

	@Test
	public void muestrasPorTipoDeInsectoDetectadoTest() {
		
		assertTrue(recoleccion.filtrarMuestras("Vinchuca").isEmpty());
		
		muestraA = new Muestra("Vinchuca", usuario1, foto, ubicacion, recoleccion, zonas);
		assertEquals(recoleccion.filtrarMuestras("Vinchuca").size(), 1);
	
		
		muestraB = new Muestra("Chince Foliada", usuario1, foto, ubicacion, recoleccion, zonas);
		muestraC = new Muestra("Chince Foliada", usuario1, foto, ubicacion, recoleccion, zonas);
		
		assertEquals(recoleccion.filtrarMuestras("Chince Foliada").size(), 2);

	}
	

}
