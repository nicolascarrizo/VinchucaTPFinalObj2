package vinchuca;


public class FiltroFechaUltimaVotacion extends BusquedaDeMuestras{

	@Override
	public boolean esMuestraFiltrable(String tipoFiltro, Muestra muestra) {
		// TODO Auto-generated method stub
		return (tipoFiltro.equals(muestra.getOpiniones().get(muestra.getOpiniones().size() - 1).getDiaDeCreacion()));
	}

	
}
