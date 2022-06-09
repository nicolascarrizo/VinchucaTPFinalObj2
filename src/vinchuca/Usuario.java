package vinchuca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	
	private String nombre;
	private Boolean esEspecialista;
	private UsuarioRango tipoDeRango;
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	private List<Muestra> muestrasCreadas = new ArrayList<Muestra>();
	
	
	public Usuario(String nombre, Boolean esEspecialista) {
		this.nombre = nombre;
		this.esEspecialista = esEspecialista;
		if(esEspecialista) {
			this.tipoDeRango = new UsuarioExperto();
		} else {
			this.tipoDeRango = new UsuarioBasico();
		}
	}
	
	public void crearMuestra(String especie, Foto foto, Ubicacion ubicacion, BusquedaDeMuestras recoleccionDeMuestras, Zonas zonas) {
		this.verificarRango();
		Muestra muestra = new Muestra(especie, this, foto, ubicacion, recoleccionDeMuestras, zonas); 
		this.getMuestrasCreadas().add(muestra);
	}
	
	public void opinarMuestra(Muestra muestra, String especie) {
		//De esta forma opino las muestras de otros usuarios
		muestra.recibirOpinion(this, especie);
	}
	
	public void verificarRango() {
		//Chequeo que el usuario no sea especialista y ejecuto verificarRangoSi()
		if (!this.esEspecialista()) {
			this.verificarRangoSi();
		}
	}

	
	private void verificarRangoSi() {
		//Setea tipo en Experto si cumple tieneQueAcender(), Basico si no cumple.
		if (this.esUsuarioAAscender()) {
			this.tipoDeRango = new UsuarioExperto();
		} else {
			this.tipoDeRango = new UsuarioBasico();
		}
	}
	
	
	private boolean esUsuarioAAscender() {
		//Retorna true si cumple las condiciones para ser Experto. Para ser experto durante los 
		// ultimos 30 dias han realizado mas de 10 envios y más de 20 opiniones
		
		return ((this.muestrasUltimoMes().size() > 10) && (this.opinionesUltimoMes().size() > 20));
	}

	private List<Opinion> opinionesUltimoMes() {
		List<Opinion> opinionesUltimoMes = new ArrayList<Opinion>();
		for(Opinion opinion : this.getOpiniones()) {
			if(!opinion.esOpinionAntigua()) {
				opinionesUltimoMes.add(opinion);
			}
			
		}
		return opinionesUltimoMes;
	}

	private List<Muestra> muestrasUltimoMes() {
		//Devuelve una lista con las muestras generadas en el ultimo mes. Se agarra la primera opinion
		// de la lista en el if, porque la que se encuentra en la posicion 0 siempre sera la opinion del creador.
		List<Muestra> muestrasUltimoMes = new ArrayList<Muestra>();
		for(Muestra muestra : this.getMuestrasCreadas()) {
			if(muestra.getOpiniones().get(0).esOpinionAntigua()) {
				muestrasUltimoMes.add(muestra);
			}
			
		}
		
		return muestrasUltimoMes;
		
	}

	public Boolean esEspecialista() {
		return esEspecialista;
	}

	public List<Muestra> getMuestrasCreadas() {
		return muestrasCreadas;
	}

	public UsuarioRango getTipoDeRango() {
		return tipoDeRango;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
