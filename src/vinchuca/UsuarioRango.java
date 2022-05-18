package vinchuca;

import java.util.List;


public interface UsuarioRango {
	
	public Boolean verificaMuestra(List<Opinion> opinones, String especie);
	public void opinar(Muestra muestra, Usuario usuario, String especie);
	
	public String getRango();
	public Boolean esExperto();
	

}
