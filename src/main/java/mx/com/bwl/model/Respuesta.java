package mx.com.bwl.model;

public class Respuesta {
	private String status;
	private Integer code;

	public Respuesta() {
		super();
	}

	public Respuesta(String status, Integer code) {
		super();
		this.status = status;
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
