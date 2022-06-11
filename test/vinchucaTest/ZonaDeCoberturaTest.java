package vinchucaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import vinchuca.Ubicacion;
import vinchuca.Zonas;
import vinchuca.BusquedaDeMuestras;
import vinchuca.Organizacion;
import vinchuca.Muestra;
import vinchuca.ZonaDeCobertura;

public class ZonaDeCoberturaTest {

	Ubicacion epicentro1;
	Ubicacion epicentro2;
	Ubicacion epicentro3;
	Zonas zonasDummy;
	Zonas zonas;
	BusquedaDeMuestras recoleccion;
	Organizacion organizacion1;
	Organizacion organizacion2;
	Muestra muestra;
	List<Organizacion> organizaciones;
	
	ZonaDeCobertura zona1;
	ZonaDeCobertura zona2;
	ZonaDeCobertura zona3;

	@Before
	public void setUp() throws Exception {
		
		zonasDummy = mock(Zonas.class);
		recoleccion = mock(BusquedaDeMuestras.class);
		organizacion1 = mock(Organizacion.class);
		organizacion2 = mock(Organizacion.class);
		muestra = mock(Muestra.class);
		organizaciones = new ArrayList<Organizacion>();
		epicentro1 = new Ubicacion(1, 1);
		
		zona1 = new ZonaDeCobertura("" , epicentro1, 5, zonasDummy, recoleccion);
	}
	
	@Test
	public void testConstructor() {
		
		assertEquals(zona1.getNombre(), "");
		assertEquals(zona1.getUbicacion(), epicentro1);
		assertEquals(zona1.getRadio(), 5, 0.001);
		verify(zonasDummy, times(1)).agregarZona(zona1);
	}
	
	@Test
	public void testRegistrarA() {
		
		assertTrue(zona1.getOrganizaciones().isEmpty());
		
		zona1.registrarA(organizacion1);
		assertEquals(zona1.getOrganizaciones().size(), 1);
		zona1.registrarA(organizacion1);
		assertEquals(zona1.getOrganizaciones().size(), 1);
		zona1.registrarA(organizacion2);
		assertEquals(zona1.getOrganizaciones().size(), 2);
	}	
	
	@Test
	public void testNotificaciones() {
		
		zona1.registrarA(organizacion1);
		
		zona1.notificarCreacionDeMuestra(muestra);
		verify(organizacion1, times(1)).notificarCreacion(zona1, muestra);
		
		zona1.notificarVerificacionDeMuestra(muestra);
		verify(organizacion1, times(1)).notificarVerificacion(zona1, muestra);
	}
	
	@Test
	public void testZonasSolapadas() {
		
		zonas = new Zonas();
		epicentro2 = new Ubicacion(5, 1);
		epicentro3 = new Ubicacion(30, 30);
		zona2 = new ZonaDeCobertura("" , epicentro2, 2, zonas, recoleccion);
		assertEquals(zona1.zonasSolapadas(zonas).size(), 1);
		
		zona3 = new ZonaDeCobertura("" , epicentro3, 3, zonas, recoleccion);
		assertEquals(zona1.zonasSolapadas(zonas).size(), 1);
	}
	

}

