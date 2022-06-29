package vinchuca;

public class FiltroNivelDeVerificacion extends BusquedaDeMuestras{

	@Override
	public boolean esMuestraFiltrable(String tipoFiltro, Muestra muestra) {
		// TODO Auto-generated method stub
		return (tipoFiltro.contentEquals(muestra.estado()));
	}

}
