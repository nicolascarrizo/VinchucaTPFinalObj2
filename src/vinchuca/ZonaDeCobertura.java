package vinchuca;

import java.util.HashSet;
import java.util.Set;

public class ZonaDeCobertura {
	
	private String nombre;
	private Ubicacion ubicacion; //epicentro
	private double radio;
	
	//Es un set para evitar tener organizaciones repetidas
	private Set<Organizacion> organizaciones = new HashSet<Organizacion>(); 
	

	public ZonaDeCobertura(String nombre, Ubicacion ubicacion, double radio, Zonas zonas, BusquedaDeMuestras muestrasRecolectadas) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.radio = radio;
		
		//agrego la zona a la busqueda de zonas
		zonas.agregarZona(this);
		
		//agrego la zona si tiene muestras que pertenezcan a la zona
		for(Muestra muestra : muestrasRecolectadas.getMuestras()) {
			if(muestra.muestraPerteneceAZona(this)) {
				muestra.getZonas().add(this);
			}
		}
		
	}

	public void registrarA(Organizacion organizacion) {
		this.getOrganizaciones().add(organizacion);
		
	}
	
	public void notificarCreacionDeMuestra(Muestra muestra) {
		for(Organizacion organizacion: this.getOrganizaciones()) {
			organizacion.notificarCreacion(this, muestra);
		}
	}
	
	public void notificarVerificacionDeMuestra(Muestra muestra) {
		for(Organizacion organizacion : this.getOrganizaciones()) {
			organizacion.notificarVerificacion(this, muestra);
		}
	}

	public Set<Organizacion> getOrganizaciones() {
		return organizaciones;
	}

	public String getNombre() {
		return nombre;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public double getRadio() {
		return radio;
	}
	
	
	
	
	
	

}
