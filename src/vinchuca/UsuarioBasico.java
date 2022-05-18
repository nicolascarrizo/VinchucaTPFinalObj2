package vinchuca;

import java.util.List;

public class UsuarioBasico implements UsuarioRango{

	@Override
	public Boolean verificaMuestra(List<Opinion> opinones, String especie) {
		return false;
		
	}

	@Override
	public void opinar(Muestra muestra, Usuario usuario, String especie) {
		if(!muestra.opinoExperto()) {
			usuario.verificarRango();
			Opinion opinion = new Opinion(especie, usuario, muestra);
			usuario.getOpiniones().add(opinion);
		}
		
	}

	@Override
	public String getRango() {
		return "Basico";
	}

	@Override
	public Boolean esExperto() {
		return false;
	}

}
