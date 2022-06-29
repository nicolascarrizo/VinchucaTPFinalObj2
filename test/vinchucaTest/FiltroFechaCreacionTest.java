package vinchucaTest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import vinchuca.FiltroFechaCreacion;
import vinchuca.Foto;
import vinchuca.Muestra;
import vinchuca.Ubicacion;
import vinchuca.Usuario;
import vinchuca.Zonas;

public class FiltroFechaCreacionTest {
	
	FiltroFechaCreacion recoleccion;
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
		recoleccion = new FiltroFechaCreacion();
		
	}
	
	@Test
	public void muestrasPorFechaDeCracionTest() {
		
		
		Usuario usuarioC = new Usuario("Pepe", false);
		Usuario usuarioD = new Usuario("Lucas", false);
		
		usuarioC.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		usuarioD.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		
		assertEquals(recoleccion.filtrarMuestras(LocalDate.now().toString()).size(), 0);
		
	}

}
