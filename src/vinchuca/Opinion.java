package vinchuca;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Opinion {
	
	private String especie;
	private Usuario usuario;
	private UsuarioRango rangoUsuario;
	private LocalDate diaDeCreacion;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
	

	
	public Opinion(String especie, Usuario usuario, Muestra muestra) {
		this.especie = especie;
		this.usuario = usuario;
		this.rangoUsuario = usuario.getTipoDeRango();
		this.diaDeCreacion = LocalDate.now();
		
		//De esta manera nos aseguramos que siempre que se crea una nueva opinion esta termine dentro de una muestra.
		muestra.agregarOpinion(this);
	}

	public boolean esOpinionAntigua() {
	//True si la opinion tiene mas de 30 dias de antiguedad.
		LocalDate fechaDeHoy = LocalDate.now();
		
		long diferenciaEnDias = ChronoUnit.DAYS.between(this.diaDeCreacion, fechaDeHoy);
				
		return (diferenciaEnDias > 30);
	
	}
	
	
	public String getDiaDeCreacion() {
		return formatter.format(this.diaDeCreacion).toString();
	}
	public void setDiaDeCreacion(LocalDate diaDeCreacion) {	
		this.diaDeCreacion = diaDeCreacion;
	}


	public String getEspecie() {
		return especie;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public UsuarioRango getRangoUsuario() {
		return rangoUsuario;
	}

	
	
	
	
	

}
