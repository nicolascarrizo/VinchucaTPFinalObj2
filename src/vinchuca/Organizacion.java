package vinchuca;

public class Organizacion {
	
		
		private Ubicacion ubicacion;
		private String tipoOrganizacion;
		private int cantidadTrabajadores;
		
		
		
		private FuncionalidadExterna funcionalidadCreacion;
		private FuncionalidadExterna funcionalidadVerificacion;
		
		
		public Organizacion(Ubicacion ubicacion, String tipoOrganizacion, int cantidadTrabajadores) {
			super();
			this.ubicacion = ubicacion;
			this.tipoOrganizacion = tipoOrganizacion;
			this.cantidadTrabajadores = cantidadTrabajadores;
		}
		
		
		public void registrarseAZona(ZonaDeCobertura zonaDeCobertura) {
			zonaDeCobertura.registrarA(this);
		}
		
		
		public void notificarCreacion(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
			this.getFuncionalidadCreacion().nuevoEvento(this, zonaDeCobertura, muestra);
		}
		
		public void notificarVerificacion(ZonaDeCobertura zonaDeCobertura, Muestra muestra) {
			this.getFuncionalidadVerificacion().nuevoEvento(this, zonaDeCobertura, muestra);
		}


		public FuncionalidadExterna getFuncionalidadCreacion() {
			return funcionalidadCreacion;
		}


		public FuncionalidadExterna getFuncionalidadVerificacion() {
			return funcionalidadVerificacion;
		}


		public Ubicacion getUbicacion() {
			return ubicacion;
		}


		public String getTipoOrganizacion() {
			return tipoOrganizacion;
		}


		public int getCantidadTrabajadores() {
			return cantidadTrabajadores;
		}
		
		
		
		
		
		
		
		

	}
