package vinchucaTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import vinchuca.BusquedaDeMuestras;
import vinchuca.Foto;
import vinchuca.Muestra;
import vinchuca.Ubicacion;
import vinchuca.Usuario;
import vinchuca.Zonas;

public class UbicacionTest {
	
	Muestra muestra;
	Foto foto;
	Usuario usuario;
	BusquedaDeMuestras recoleccion;
	Zonas zonas;
	
	double latitud1;
	double longitud1;
	double latitud2;
	double longitud2;
	double latitud3;
	double longitud3;
	
	Ubicacion ubicacion1;
	Ubicacion ubicacion2;
	Ubicacion ubicacion3;
	
	
	@Before
	public void setUp() {
		
		latitud1 = 24;
		longitud1 = 32;
		latitud2 = 16;
		longitud2 = 25;
		latitud3 = 40;
		longitud3 = 50;
		
		ubicacion1 = new Ubicacion(latitud1, longitud1);
		ubicacion2 = new Ubicacion(latitud2, longitud2);
		ubicacion3 = new Ubicacion(latitud3, longitud3);
		
	}
	
	@Test
	public void constructorTest() {
		assertEquals(ubicacion1.getLatitud(), latitud1, 0.001);
		assertEquals(ubicacion1.getLongitud(), longitud1, 0.001);
		assertEquals(ubicacion2.getLatitud(), latitud2, 0.001);
		assertEquals(ubicacion2.getLongitud(), longitud2, 0.001);
		assertEquals(ubicacion3.getLatitud(), latitud3, 0.001);
		assertEquals(ubicacion3.getLongitud(), longitud3, 0.001);
		
	}
	
	@Test
	public void distanciaEntreTest() {
		
		assertEquals(ubicacion1.distanciaEntre(ubicacion2), 10.630, 0.001);
	}
	
	@Test
	public void ubicacionesCercanasTest() {
		
		List<Ubicacion> ubicaciones = new ArrayList<Ubicacion>();
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 5).size() , 0);
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 11).size() , 1);
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 11).get(0) , ubicacion2);
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 25).size() , 2);
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 25).get(0) , ubicacion2);
		assertEquals(ubicacion1.ubicacionesCercanas(ubicaciones, 25).get(1) , ubicacion3);
		
	}
	
	@Test
	public void muestrasCercanasTest() {
		foto = mock(Foto.class);
		usuario = new Usuario("Pedro", false);
		recoleccion = mock(BusquedaDeMuestras.class);
		zonas = mock(Zonas.class);
		
		muestra = new Muestra("Vinchuca", usuario, foto, ubicacion2, recoleccion, zonas);
		
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		muestrasCercanas.add(muestra);
		
		assertEquals(ubicacion1.muestrasCercanas(muestrasCercanas, 5).size(), 0);
		assertEquals(ubicacion1.muestrasCercanas(muestrasCercanas, 11).size(), 1);
		assertEquals(ubicacion1.muestrasCercanas(muestrasCercanas, 11).get(0) , muestra);
	}

}
