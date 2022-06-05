package vinchucaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import vinchuca.BusquedaDeMuestras;
import vinchuca.FuncionalidadExterna;
import vinchuca.Muestra;
import vinchuca.Organizacion;
import vinchuca.Ubicacion;
import vinchuca.ZonaDeCobertura;

public class OrganizacionTest {
	
	Organizacion organizacion;
	ZonaDeCobertura zonaDeCobertura;
	BusquedaDeMuestras recoleccion;
	FuncionalidadExterna funcionalidadExterna;
	Muestra muestra;
	Ubicacion ubicacion;
	
	@Before
	public void setUp() {
		muestra = mock(Muestra.class);
		recoleccion = mock(BusquedaDeMuestras.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		ubicacion = mock(Ubicacion.class);
		funcionalidadExterna = mock(FuncionalidadExterna.class);
		
		
		organizacion = new Organizacion(ubicacion, "Educativa", 20);
		
	}
	
	@Test
	public void constructorTest() {
		assertEquals(organizacion.getUbicacion(), ubicacion);
		assertEquals(organizacion.getTipoOrganizacion(), "Educativa");
		assertEquals(organizacion.getCantidadTrabajadores(), 20);
	}
	
	@Test
	public void registrarseAZonaDeCoberturaTest() {
		organizacion.registrarseAZona(zonaDeCobertura);
		verify(zonaDeCobertura).registrarA(organizacion);
	}


}
