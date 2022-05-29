package vinchucaTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

import vinchuca.BusquedaDeMuestras;
import vinchuca.Foto;
import vinchuca.Muestra;
import vinchuca.Ubicacion;
import vinchuca.Usuario;
import vinchuca.UsuarioBasico;
import vinchuca.UsuarioExperto;
import vinchuca.ZonaDeCobertura;
import vinchuca.Zonas;

public class UsuarioTest {
	
	Usuario usuario1;
	Usuario usuario2;
	Foto foto;
	Ubicacion ubicacion;
	BusquedaDeMuestras recoleccion;
	Zonas zonas;
	ZonaDeCobertura zonaDeCobertura;
	Muestra muestra;
	
	@Before
	public void setUp() {
		usuario1 = new Usuario("Matias", false);
		usuario2 = new Usuario("Micaela", true);
		
		zonas = mock(Zonas.class);
		zonaDeCobertura = mock(ZonaDeCobertura.class);
		foto = mock(Foto.class);
		ubicacion = mock(Ubicacion.class);
		recoleccion = mock(BusquedaDeMuestras.class);
		
	}
	
	@Test
	public void constructorUsuario1Test() {
		assertEquals(usuario1.getNombre(), "Matias");
		assertEquals(usuario1.getTipoDeRango().getRango(), new UsuarioBasico().getRango());
		assertFalse(usuario1.esEspecialista());
		assertTrue(usuario1.getOpiniones().isEmpty());
		assertTrue(usuario1.getMuestrasCreadas().isEmpty());
		
	}
	
	@Test
	public void constructorUsuario2Test() {
		assertEquals(usuario2.getTipoDeRango().getRango(), new UsuarioExperto().getRango());
		assertTrue(usuario2.esEspecialista());
		assertTrue(usuario2.getTipoDeRango().esExperto());
	}
	
	@Test
	public void crearMuestraTest() {
		usuario1.crearMuestra("Vinchuca", foto, ubicacion, recoleccion, zonas);
		assertEquals(usuario1.getMuestrasCreadas().size(), 1);
	}
	
	@Test
	public void crearOpinionTest() {
		
		Usuario usuarioA = new Usuario("Fernando", false);
		Usuario usuarioB = new Usuario("Julian", false);
		Usuario usuarioC = new Usuario("Julieta", true);
		
		muestra = new Muestra("Vinchuca", usuario1, foto, ubicacion, recoleccion, zonas);
		
		muestra.getZonas().add(zonaDeCobertura);
		int cantidadOpiniones = 1;
		
		usuarioA.opinarMuestra(muestra, "Chinche");
		cantidadOpiniones++;
		assertEquals(muestra.getOpiniones().get(1).getUsuario(), usuarioA);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		//opina experto

		usuario2.opinarMuestra(muestra, "Vinchuca");
		cantidadOpiniones++;
		assertEquals(muestra.getOpiniones().get(2).getUsuario(), usuario2);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		//aca va a opinar alguien que no es experto, asi que no va a usar en el contador 
		//de cantidad de opiniones, porque ya no puede opinar.
		
		usuarioB.opinarMuestra(muestra, "Mosquito");
		assertEquals(muestra.getOpiniones().get(1).getUsuario(), usuarioA);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		//va a volver a opinar de nuevo el mismo usuario, y un usuario no puede opinar dos veces
		//la lista de opiniones va a seguir igual
		
		usuario2.opinarMuestra(muestra, "Vinchuca");
		assertEquals(muestra.getOpiniones().get(2).getUsuario(), usuario2);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		//va a opinar otro experto, asi que en este momento si el contador va a sumar. 
		
		usuarioC.opinarMuestra(muestra, "Vinchuca");
		cantidadOpiniones++;
		assertEquals(muestra.getOpiniones().get(3).getUsuario(), usuarioC);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		// va a volver a opinar el usuarioA y no va a poder
		usuarioA.opinarMuestra(muestra, "Chinche");
		assertEquals(muestra.getOpiniones().get(1).getUsuario(), usuarioA);
		assertEquals(muestra.getOpiniones().size(), cantidadOpiniones);
		
		
		
	}
	
	

}
