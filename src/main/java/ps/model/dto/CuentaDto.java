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
	private double saldo;
	private String mercado_pago;
	
	
	
	public CuentaDto(double saldo,long id,String mercado_pago) {
		this.id = id;
		this.mercado_pago= mercado_pago;
		this.saldo = saldo;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getMercado_pago() {
		return mercado_pago;
	}
	public void setMercado_pago(String mercado_pago) {
		this.mercado_pago = mercado_pago;
	}

}
