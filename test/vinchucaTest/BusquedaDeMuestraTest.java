package vinchucaTest;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class BusquedaDeMuestraTest {
	
	Usuario usuario1;
	Usuario usuario2;
	Foto foto;
	Ubicacion ubicacion;
	Zonas zonas;
	Muestra muestraA;
	Muestra muestraB;
	Muestra muestraC;
	BusquedaDeMuestras recoleccion;
	LocalDate fecha;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	
	@Before
	public void setup() {
		usuario1 = new Usuario("Lucas", false);
		foto = mock(Foto.class);
		ubicacion = mock(Ubicacion.class);
		zonas = mock(Zonas.class);
		recoleccion = new BusquedaDeMuestras();
	}
	
	@Test
	public void constructorTest() {
		assertTrue(recoleccion.getMuestras().isEmpty());
		
		muestraA = new Muestra("Vinchuca", usuario1, foto, ubicacion, recoleccion, zonas);
		assertFalse(recoleccion.getMuestras().isEmpty());
		assertEquals(recoleccion.getMuestras().get(0), muestraA);
	}
	
	@Test
	public void muestrasPorTipoDeInsectoDetectadoTest() {
		assertTrue(recoleccion.muestrasPorTipoDeInsectoDetectado("Vinchuca").isEmpty());
		
		muestraA = new Muestra("Vinchuca", usuario1, foto, ubicacion, recoleccion, zonas);
		assertEquals(recoleccion.muestrasPorTipoDeInsectoDetectado("Vinchuca").size(), 1);
		
		
		muestraB = new Muestra("Chince Foliada", usuario1, foto, ubicacion, recoleccion, zonas);
		muestraC = new Muestra("Chince Foliada", usuario1, foto, ubicacion, recoleccion, zonas);
		
		assertEquals(recoleccion.muestrasPorTipoDeInsectoDetectado("Chince Foliada").size(), 2);

	}
	
	@Test
	public void muestrasPorNivelDeVerificacionTest() {
		
		assertTrue(recoleccion.muestrasPorNivelDeVerificacion("Verificada").isEmpty());
		muestraA = new Muestra("Araña", usuario1, foto, ubicacion, recoleccion, zonas);
		assertEquals(recoleccion.muestrasPorNivelDeVerificacion("En Votacion").size(), 1);
	
		Usuario usuarioA = new Usuario("Jorge", true);
		Usuario usuarioB = new Usuario("Sofia", true);
		
		usuarioA.opinarMuestra(muestraA, "Vinchuca");
		usuarioB.opinarMuestra(muestraA, "Vinchuca");
		
		assertEquals(recoleccion.muestrasPorNivelDeVerificacion("En Votacion").size(), 0);
		assertEquals(recoleccion.muestrasPorNivelDeVerificacion("Verificada").size(), 1);
		
		Usuario usuarioC = new Usuario("Pepe", false);
		Usuario usuarioD = new Usuario("Lucas", false);
		
		usuarioC.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		usuarioD.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		
		assertEquals(recoleccion.muestrasPorNivelDeVerificacion("En Votacion").size(), 2);
	}
	
	@Test
	public void muestrasPorFechaDeCracionTest() {
		
		Usuario usuarioC = new Usuario("Pepe", false);
		Usuario usuarioD = new Usuario("Lucas", false);
		
		usuarioC.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		usuarioD.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		
		
		
		assertEquals(recoleccion.muestrasPorFechaDeCreacion(LocalDate.now().toString()).size(), 0);
	}
	
	@Test
	public void muestrasPorFechaDeUltimaVotacionTest() {
		
		Usuario usuarioC = new Usuario("Pepe", false);
		Usuario usuarioD = new Usuario("Lucas", false);
		
		usuarioC.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		usuarioD.crearMuestra("Chince Foliada", foto, ubicacion, recoleccion, zonas);
		
		
		
		assertEquals(recoleccion.muestrasPorFechaDeUltimaVotacion(LocalDate.now().toString()).size(), 0);
	}
	
	
	@Test
	public void ANDtest() {
		
		muestraA = mock(Muestra.class);
		muestraB = mock(Muestra.class);
		muestraC = mock(Muestra.class);
		
		List<Muestra> lista1 = new ArrayList<Muestra>();
		lista1.add(muestraA);
		lista1.add(muestraB);
		
		List<Muestra> lista2 = new ArrayList<Muestra>();
		lista2.add(muestraB);
		lista2.add(muestraC);
		
		List<Muestra> lista3 = new ArrayList<Muestra>();
		lista3.add(muestraB);
		
		assertEquals(recoleccion.AND(lista1, lista2), lista3);
		
	}
	
	@Test
	public void ORtest() {
		
		muestraA = mock(Muestra.class);
		muestraB = mock(Muestra.class);
		muestraC = mock(Muestra.class);
		
		List<Muestra> lista1 = new ArrayList<Muestra>();
		lista1.add(muestraA);
		lista1.add(muestraB);
		
		List<Muestra> lista2 = new ArrayList<Muestra>();
		lista2.add(muestraB);
		lista2.add(muestraC);
		
		List<Muestra> lista3 = new ArrayList<Muestra>();
		lista3.add(muestraA);
		lista3.add(muestraB);
		lista3.add(muestraC);
		
		assertEquals(recoleccion.OR(lista1, lista2), lista3);
		
	}
	

}
