package com.pc.config;

public class Configurer {

	private TipoAplicacion tipoAplicacion;
  
	public static enum TipoAplicacion  {

		WS_SOAP,  WS_REST,  WEB,  BATCH;

        private TipoAplicacion() {}
	}
  
	private boolean hasToken = false;
  
	public TipoAplicacion getTipoAplicacion() {
		return this.tipoAplicacion;
	}
  
	public void setTipoAplicacion(TipoAplicacion tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}
  
	public boolean hasToken() {
		return this.hasToken;
	}

	public void setHasToken(boolean hasToken) {
		this.hasToken = hasToken;
	}

}
