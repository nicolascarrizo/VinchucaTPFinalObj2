package vinchuca;

import java.util.ArrayList;
import java.util.List;

public class BusquedaDeMuestras {
	
	private List<Muestra> muestras= new ArrayList<Muestra>();
		
	
	public List<Muestra> AND(List<Muestra> muestrasA, List<Muestra> muestrasB) {
		List<Muestra> resultado = new ArrayList<Muestra>();
		for (Muestra muestra: muestrasA) {
			if(muestrasB.contains(muestra)) {
				resultado.add(muestra);
			}
		}
		return resultado;
	}
		
	public List<Muestra> OR(List<Muestra> muetrasA, List<Muestra> muestrasB) {
		List<Muestra> resultado = muetrasA;
		for (Muestra muestra: muestrasB) {
			if(!resultado.contains(muestra)) {
				resultado.add(muestra);
			}
		}
		return resultado;
	}
	
	public List<Muestra> muestrasPorFechaDeCreacion(String fecha){
		List<Muestra> muestrasPorFechaDeCreacion = new ArrayList<Muestra>();
		for(Muestra muestra: this.getMuestras()) {
			// como sabemos se agarra de la lista de opiniones la que se encuentra en la posicion 0,
			// porque es quien fue 
			if(fecha.equals(muestra.getOpiniones().get(0).getDiaDeCreacion())) {
				muestrasPorFechaDeCreacion.add(muestra);
			}
		}
		
		return muestrasPorFechaDeCreacion;
	}
	
	public List<Muestra> muestrasPorFechaDeUltimaVotacion(String fecha){
		List<Muestra> muestrasPorFechaDeUltimaVotacion = new ArrayList<Muestra>();
		for(Muestra muestra: this.getMuestras()) {
			if(fecha.equals(muestra.getOpiniones().get(muestra.getOpiniones().size() - 1).getDiaDeCreacion())){
				muestrasPorFechaDeUltimaVotacion.add(muestra);
			}
		}
			
		return muestrasPorFechaDeUltimaVotacion;
	}
	
	public List<Muestra> muestrasPorTipoDeInsectoDetectado(String insecto){
		List<Muestra> muestrasPorTipoDeInsectoDetectado = new ArrayList<Muestra>();
		for(Muestra muestra: this.getMuestras()) {
			if(insecto.contentEquals(muestra.resultadoActual())) {
				muestrasPorTipoDeInsectoDetectado.add(muestra);
			}
		}
		
		return muestrasPorTipoDeInsectoDetectado;
	}
	
	
	public List<Muestra> muestrasPorNivelDeVerificacion(String estado){
		List<Muestra> muestrasPorNivelDeVerificacion = new ArrayList<Muestra>();
		for(Muestra muestra: this.getMuestras()) {
			if(estado.contentEquals(muestra.estado())) {
				muestrasPorNivelDeVerificacion.add(muestra);
			}
		}
		
		return muestrasPorNivelDeVerificacion;
		
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public void nuevaMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}


}
