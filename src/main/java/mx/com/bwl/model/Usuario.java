package mx.com.bwl.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String nombre;
	private String apellidos;
	private String pwd;
	private int status;
	private String email;
	private String role;
	private Date fechacreacion;
	private Date fechaactualizacion;
	
	
	
	public Usuario() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechacreacion() {
		return fechacreacion;
	}


	public void setFechacreacion(Date fechacreacion) {
		this.fechacreacion = fechacreacion;
	}


	public Date getFechaactualizacion() {
		return fechaactualizacion;
	}


	public void setFechaactualizacion(Date fechaactualizacion) {
		this.fechaactualizacion = fechaactualizacion;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	@Override
	public String toString() {
		return "Usuario [id=" + id + ", username=" + username + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", pwd=" + pwd + ", status=" + status + ", email=" + email + ", role=" + role + ", fechacreacion="
				+ fechacreacion + ", fechaactualizacion=" + fechaactualizacion + "]";
	}

	
	
}
