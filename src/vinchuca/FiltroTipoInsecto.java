package vinchuca;

public class FiltroTipoInsecto extends BusquedaDeMuestras{

	@Override
	public boolean esMuestraFiltrable(String tipoFiltro, Muestra muestra) {
		// TODO Auto-generated method stub
		return (tipoFiltro.contentEquals(muestra.resultadoActual()));
	}

}
