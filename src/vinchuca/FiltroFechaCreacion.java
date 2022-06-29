package vinchuca;

public class FiltroFechaCreacion extends BusquedaDeMuestras{

	@Override
	public boolean esMuestraFiltrable(String tipoFiltro, Muestra muestra) {
		// TODO Auto-generated method stub
		return tipoFiltro.equals(muestra.getOpiniones().get(0).getDiaDeCreacion());
	}
	
	

}
