package modelos;

import java.sql.Date;

public class Tarjeta {

	private String idParticipante;
	private Date timestamp;
	private String tipoTarjeta;
	
	
	public String getIdParticipante() {
		return idParticipante;
	}
	public void setIdParticipante(String idParticipante) {
		this.idParticipante = idParticipante;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	
	
}
