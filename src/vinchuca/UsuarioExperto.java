package vinchuca;

import java.util.ArrayList;
import java.util.List;


public class UsuarioExperto implements UsuarioRango{

	@Override
	public Boolean verificaMuestra(List<Opinion> opiniones, String especie) {
		return this.especiesOpinadas(opiniones).contains(especie);
		
	}

	private List<String> especiesOpinadas(List<Opinion> opiniones) {
		List<String> especies = new ArrayList<String>();
		for (Opinion opinion: opiniones){
			if(opinion.getRangoUsuario().esExperto()) {
				especies.add(opinion.getEspecie());
			}
		}
		return especies;
	}

	@Override
	public void opinar(Muestra muestra, Usuario usuario, String especie) {
		
		//creo una nueva opinon y la agrego a las opiniones del usuario
		
		usuario.verificarRango();
		Opinion opinion = new Opinion(especie, usuario, muestra);
		usuario.getOpiniones().add(opinion);
		
	}

	@Override
	public String getRango() {
		return "Experto";
	}

	@Override
	public Boolean esExperto() {
		// TODO Auto-generated method stub
		return true;
	}

}
