package ps.model.dto;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import ps.model.Usuario;

public class CuentaDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private long id;
	private String mercado_pago;
	private Date fecha_creacion;
	private double saldo;
	private boolean habilitada;
	private String motivo; // motivo por la que la deshabilitarion
	private Usuario idPropietario;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMercado_pago() {
		return mercado_pago;
	}
	public void setMercado_pago(String mercado_pago) {
		this.mercado_pago = mercado_pago;
	}
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public boolean isHabilitada() {
		return habilitada;
	}
	public void setHabilitada(boolean habilitada) {
		this.habilitada = habilitada;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public Usuario getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Usuario idPropietario) {
		this.idPropietario = idPropietario;
	}
	
}
