package modelos;

import java.sql.Date;

public class Suceso {

	private String idParticipante;
	private Date timestamp;
	
	
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
	
	
}
