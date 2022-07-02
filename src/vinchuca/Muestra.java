package vinchuca;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Muestra {
	
	
	private List<Opinion> opiniones = new ArrayList<Opinion>();
	private Set<ZonaDeCobertura> zonas = new HashSet<ZonaDeCobertura>();
	private Foto foto;
	private EstadoMuestra estadoMuestra;
	private Ubicacion ubicacion;
	

	public Muestra(String especie, Usuario usuario, Foto foto, Ubicacion ubicacion, BusquedaDeMuestras recoleccionDeMuestras, Zonas zonas) {
		super();
		
		//El constructor de opinion nos agrega dicha opinion a la lista opiniones, 
		//por lo que siempre la posicion 0 sera la opinion del creador.
		new Opinion(especie, usuario, this);
		
		this.foto = foto;
		this.ubicacion = ubicacion;
		
		EstadoMuestra estado = new EstadoEnVotacion();
		this.setEstadoMuestra(estado);
		
		recoleccionDeMuestras.nuevaMuestra(this);
		
		//me fijo a que zona va a pertener la muestra. DATO: Se creo la clase Zonas
		// para yo saber a que zona va a pertenecer la muestra. Por eso cada vez que se crea una nueva ZonaDeCobertura
		// la agrego a mi lista de Zonas en donde tengo las zonas totales. 
		
		for(ZonaDeCobertura zona: zonas.getZonas()) {
			this.agregarZonaSiPertenece(zona);
		}
		
		this.notificarAZonaDeCracionNuevaMuestra();
		
		
	}
	
	private void notificarAZonaDeCracionNuevaMuestra() {
		for(ZonaDeCobertura zonaDeCobertura : this.getZonas()) {
			zonaDeCobertura.notificarCreacionDeMuestra(this);
		}
		
	}

	private void agregarZonaSiPertenece(ZonaDeCobertura zona) {
		if(this.muestraPerteneceAZona(zona)) {
			this.getZonas().add(zona);
		}
		
	}

	public boolean muestraPerteneceAZona(ZonaDeCobertura zona) {
		//si es menor o igual al radio, significa que esa ubicacion se encuentra dentro del radio
		// de zona de cobertura
		return this.getUbicacion().distanciaEntre(zona.getUbicacion()) <= zona.getRadio();
	}

	public void agregarOpinion(Opinion opinion) {
		//Al agregar una opinion, antes de agregarla chequeo que esta opinion vaya a cambiar el estado o no.
		this.chequearEstadoDeMuestra(opinion);
		this.getOpiniones().add(opinion);

	}
	
	private void chequearEstadoDeMuestra(Opinion opinion) {
		//Si la opinion es de un experto y la especie que decidio ya existia en la lista previamente
		if(opinion.getRangoUsuario().verificaMuestra(this.getOpiniones(), opinion.getEspecie())) {
			EstadoMuestra estadoMuestra = new EstadoVerificada();
			this.setEstadoMuestra(estadoMuestra);
			this.notificarAZonaDeCreacionVerificacion();
		}
		
	}
	
	private void notificarAZonaDeCreacionVerificacion() {
		for(ZonaDeCobertura zonas: this.getZonas()) {
			zonas.notificarVerificacionDeMuestra(this);
		}
		
	}

	public void recibirOpinion(Usuario usuario, String especie) {
		if(!this.estaVerificada() && !this.usuariosQueOpinaron().contains(usuario)) {
			usuario.getTipoDeRango().opinar(this, usuario, especie);
		}
	}
	

	
	public List<Usuario> usuariosQueOpinaron() {
		//La funcion mapea la lista de opiniones, a los participantes de las mismas, esta queda en el mismo orden que las opiniones.
		List<Usuario> usuarios = new	ArrayList<Usuario>();
		for (Opinion opinion: this.getOpiniones()){
			usuarios.add(opinion.getUsuario());
		}
		return usuarios;
	}
	
	
	public boolean opinoExperto() {
		// TODO Auto-generated method stub
		return this.tipoDeParticipantes().contains("Experto");
	}


	private List<String> tipoDeParticipantes() {
		//La funcion mapea la lista de opiniones, a los tipos de los participantes, la misma queda en el mismo orden que las opiniones.
		List<String> tiposList = new ArrayList<String>();
		for(Opinion opinion: this.getOpiniones()) {
			tiposList.add(opinion.getRangoUsuario().getRango());
		}
		
		return tiposList;
	}
	
	
	public String resultadoActual() {
		//Retorna especie hasta el momento mas votada o verificada. En todo momento se puede pedir a la muestra
		// su resultado actual
		return estadoMuestra.getEspecie(this.getOpiniones());
	}
	
	public boolean estaVerificada() {
		//Retorna si la muestra esta o no verificada
		return estadoMuestra.estaVerificada();
	}
	

	public List<Opinion> getOpiniones() {
		return opiniones;
	}
	
	public String estado() {
		//String "En Votacion" o "Verificada".
		return estadoMuestra.getEstado();
	}

	public EstadoMuestra getEstadoMuestra() {
		return estadoMuestra;
	}
	
	public Set<ZonaDeCobertura> getZonas() {
		return zonas;
	}
	

	public Foto getFoto() {
		return foto;
	}

	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setEstadoMuestra(EstadoMuestra estadoMuestra) {
		this.estadoMuestra = estadoMuestra;
	}
	public List<Opinion> opinionesDeMuestra() {
        return this.getOpiniones();
    }

	public Set<ZonaDeCobertura> zonasDeMuestra(){
        return this.getZonas();
	}
	
	
	
	
	

}
