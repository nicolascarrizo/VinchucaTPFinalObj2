package vinchuca;

import java.util.List;

public class EstadoVerificada implements EstadoMuestra{

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return "Verificada";
	}

	@Override
	public String getEspecie(List<Opinion> opiniones) {
		return opiniones.get( opiniones.size()-1 ).getEspecie();
	}

	@Override
	public boolean estaVerificada() {
		// TODO Auto-generated method stub
		return true;
	}

}
