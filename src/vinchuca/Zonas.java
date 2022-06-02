package vinchuca;

import java.util.ArrayList;
import java.util.List;

public class Zonas {
	
	//Este objeto fue creado con la finalidad de que al momento de crear una muestra este sepa donde
	// buscar a que zona pertenece y asi poder agregarlo a la lista para luego notificar su creacion
	// o verificación
	
	private List<ZonaDeCobertura> zonas = new ArrayList<ZonaDeCobertura>();

	public List<ZonaDeCobertura> getZonas() {
		return zonas;
	}

	public void agregarZona(ZonaDeCobertura zona) {
		this.getZonas().add(zona);
	}

}
