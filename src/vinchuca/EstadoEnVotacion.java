package vinchuca;

import java.util.ArrayList;
import java.util.List;

public class EstadoEnVotacion implements EstadoMuestra{

	@Override
	public String getEstado() {
		// TODO Auto-generated method stub
		return "En Votacion";
	}

	@Override
	public boolean estaVerificada() {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public String getEspecie(List<Opinion> opiniones) {
		// TODO Auto-generated method stub
		return this.getEspecieMasOpinada(opiniones);
	}

	private String getEspecieMasOpinada(List<Opinion> opiniones) {
		//Este caso es cuando la muestra NO ESTA VERIFICADA, la funcion devuelve la especie mas votada
		// en ese momento, o si hay empate "En Votacion"
		
		List<String> especiesOpinadas = this.especiesOpinadas(opiniones);
		
		String especieMasOpinada = especiesOpinadas.get(0);
		Integer apariciones = cantidadDeApariciones(especiesOpinadas, especieMasOpinada);
		boolean hayEmpate = false;
		
		
		especiesOpinadas = sinApariciones(especieMasOpinada, especiesOpinadas);
		
		for(String especie: especiesOpinadas) {
			if( cantidadDeApariciones(especiesOpinadas, especie) < apariciones ){
				
				//Este es el caso en el que la especie mas opinada sea la primera que agarre de la lista de 
				//opiniones
				
				especiesOpinadas = sinApariciones(especie, especiesOpinadas);
				
			}else if ( (cantidadDeApariciones(especiesOpinadas, especie) > apariciones) ) {
				
				//Este es el caso en el que la primera especie no sea la mas votada, sino que alguna del resto
				//de la lista de opiniones
				
				especieMasOpinada = especie;
				apariciones = cantidadDeApariciones(especiesOpinadas, especie);
				hayEmpate = false;
				especiesOpinadas = sinApariciones(especie, especiesOpinadas);
				
			}else {
				
				//Este es en el caso de que no entran en ningun momento en alguno de los ifs, entonces
				// quiere decir que hay un empate.
				
				especiesOpinadas = sinApariciones(especie, especiesOpinadas);
				hayEmpate = true;
				
			}
			
			
		}
		
		
		return resultadoDeVotacion(especieMasOpinada, hayEmpate);
	}
	
	private String resultadoDeVotacion(String especie, boolean hayEmpate) {
		String especieMasVotada = especie;
		if(hayEmpate) {
			especieMasVotada = this.getEstado();
		}
		return especieMasVotada;
	}

	private Integer cantidadDeApariciones(List<String> especies, String especie) {
		Integer cantidadApariciones = 0;
		for (String i: especies) {
			if(i.equals(especie)) {
				cantidadApariciones++;
			}
		}
		return cantidadApariciones;
	}

	private List<String> especiesOpinadas(List<Opinion> opiniones){
		//La funcion mapea la lista de opiniones, a las especies de las mismas, 
		//	esta queda en el mismo orden que las opiniones.
		List<String> especies = new ArrayList<String>();
		for (Opinion opinion: opiniones){
			especies.add(opinion.getEspecie());
		}
		return especies;
	}
	
	private List<String> sinApariciones(String especie, List<String> listaEspecies) {
		
		//busco todas las especies, sacando las apariciones de la especie buscada
		List<String> sinApariciones = new ArrayList<String>();
		for(String elem: listaEspecies) {
			if( !especie.equals(elem) ) {
				sinApariciones.add(elem);
			}
		}
		return sinApariciones;
	}


}
