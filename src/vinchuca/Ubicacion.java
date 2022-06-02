package vinchuca;

import java.util.ArrayList;
import java.util.List;

public class Ubicacion {
	
	//Atributos
		private double latitud, longitud;

	public Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
		
		
	public double distanciaEntre(Ubicacion ubicacion) {
		
		//MATH.POW() se utiliza para calcular un numero elevado a la potencia de algun otro numero
		//MATH.SQRT() se utiliza para hacer una raiz cuadrada
		//https://www.youtube.com/watch?v=NKVBGcfh1Jg&ab_channel=Profe.Casi
		
		double dist =  Math.sqrt(Math.pow(this.getLatitud() - ubicacion.getLatitud(),2) + Math.pow(this.getLongitud() - ubicacion.getLongitud(),2));
		return dist;
	}
	
	
	public List<Ubicacion> ubicacionesCercanas(List<Ubicacion> ubicaciones, int metros){
		//filtro las ubicaciones cercanas
		List<Ubicacion> ubicacionesCercanas = new ArrayList<Ubicacion>();
		for(Ubicacion ubicacion: ubicaciones) {
			if(!this.equals(ubicacion) && this.distanciaEntre(ubicacion) <= metros) {
				ubicacionesCercanas.add(ubicacion);
			}
		}
		
		return ubicacionesCercanas;
	}
	
	public List<Muestra> muestrasCercanas(List<Muestra> muestras, int metros){
		// filtro las muestras cercanas
		List<Muestra> muestrasCercanas = new ArrayList<Muestra>();
		for (Muestra muestra: muestras) {
			if(this.distanciaEntre(muestra.getUbicacion()) <= metros) {
				muestrasCercanas.add(muestra);
			}
		}
		return muestrasCercanas;
	}


	public double getLatitud() {
		return latitud;
	}


	public double getLongitud() {
		return longitud;
	}
	
	

}
