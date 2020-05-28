package modelos;

import java.sql.Date;

import org.yaml.snakeyaml.events.Event.ID;

public class Partido {

	private String idLocal;
	private String idVisitante;
	private Date timestamp;
	public String getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}
	public String getIdVisitante() {
		return idVisitante;
	}
	public void setIdVisitante(String idVisitante) {
		this.idVisitante = idVisitante;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	
	
}
