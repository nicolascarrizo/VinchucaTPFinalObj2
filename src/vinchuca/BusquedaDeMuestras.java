package vinchuca;

import java.util.ArrayList;
import java.util.List;

public abstract class BusquedaDeMuestras {
	
	private List<Muestra> muestras= new ArrayList<Muestra>();
	


	public List<Muestra> filtrarMuestras(String tipoFiltro){
		
		List<Muestra> muestrasFiltradas = new ArrayList<Muestra>();
		for(Muestra muestra: this.getMuestras()) {
			if(this.esMuestraFiltrable(tipoFiltro, muestra)) {
				muestrasFiltradas.add(muestra);
			}
		}
		
		return muestrasFiltradas;
		
	}
		
	
	public abstract boolean esMuestraFiltrable(String tipoFiltro, Muestra muestra);
	
	
	
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
	
	
	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public void nuevaMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	}


}
