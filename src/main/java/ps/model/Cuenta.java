package ps.model;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "Cuenta")
public class Cuenta {
	private long id;
	private String mercado_pago;
	private Date fecha_creacion;
	private double saldo;
	private boolean habilitada;
	private String motivo; // motivo por la que la deshabilitarion
	
}
