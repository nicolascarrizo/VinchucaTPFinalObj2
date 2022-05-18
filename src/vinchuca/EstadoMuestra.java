package vinchuca;

import java.util.List;

public interface EstadoMuestra {
	
	public String getEstado(); //Strings "En Votacion" o "Verificada"
	public String getEspecie(List<Opinion> opiniones); //Devuelve especie ya sea verificada o no.
	public boolean estaVerificada();

}
