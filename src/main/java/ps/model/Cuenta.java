package ps.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cuenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String mercado_pago;
	private Date fecha_creacion;
	private double saldo;
	private boolean habilitada;
	private String motivo; // motivo por la que la deshabilitarion
	
	
	public Cuenta() {
		
	}


	public Cuenta(long id, String mercado_pago, Date fecha_creacion, double saldo, boolean habilitada, String motivo) {
		super();
		this.id = id;
		this.mercado_pago = mercado_pago;
		this.fecha_creacion = fecha_creacion;
		this.saldo = saldo;
		this.habilitada = habilitada;
		this.motivo = motivo;
	}


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
	
	
	
	
}
