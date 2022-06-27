package vinchuca;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Sistema {
	
	List<Usuario> usuariosSistema = new ArrayList<Usuario>();


	public Sistema() {
		super();
	}

	public void agregarUsuarioNuevo(Usuario usuario) {
		usuariosSistema.add(usuario);
	}
	
	public void agregarZonasSistema(Zonas zonas, ZonaDeCobertura zonaDeCobertura) {
		zonas.agregarZona(zonaDeCobertura);
	}
	
	public void agregarMuestraALaBusqueda(Muestra muestra, BusquedaDeMuestras busquedaDeMuestras) {
		busquedaDeMuestras.nuevaMuestra(muestra);
	}
	
	
	public String especieMasVotada(Muestra muestra) {
		return muestra.resultadoActual();
	}
	
	public void registrarOrganizacionAZona(ZonaDeCobertura zonaDeCobertura, Organizacion organizacion) {
		 zonaDeCobertura.registrarA(organizacion);
	}
	
	public Set<ZonaDeCobertura> zonasSolapantesDeZona(ZonaDeCobertura zonaDeCobertura, Zonas zonas){
		return zonaDeCobertura.zonasSolapadas(zonas);
	}
	
	public List<Opinion> opinionesDeMuestra(Muestra muestra){
		return muestra.opinionesDeMuestra();
	}
	
	public Set<ZonaDeCobertura> zonasDeMuestra(Muestra muestra){
		return muestra.zonasDeMuestra();
	}
	
	public EstadoMuestra estadoDeMuestraActual(Muestra muestra) {
		return muestra.getEstadoMuestra();
	}
	
	public boolean esUsuarioEspecialista(Usuario usuario) {
		return usuario.esEspecialista();
	}

	public List<Usuario> getUsuariosSistema() {
		return usuariosSistema;
	}
	
	
	
	

}
