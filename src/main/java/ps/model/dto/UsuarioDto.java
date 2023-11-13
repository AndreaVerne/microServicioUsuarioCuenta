package ps.model.dto;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ps.model.Cuenta;

public class UsuarioDto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuario;
	 
	 private String nombre;
	 
	 private String apellido;
	 
	 private String correo;
	 
	 private String contraseña;
	 
	 private int celular;
	 
	 private Cuenta id_cuenta;
	 
	 private char rol;

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public int getCelular() {
		return celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public Cuenta getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Cuenta id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public char getRol() {
		return rol;
	}

	public void setRol(char rol) {
		this.rol = rol;
	}

	 	
}
