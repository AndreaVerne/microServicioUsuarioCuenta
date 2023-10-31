package dto.response;

import java.util.List;

import ps.model.Cuenta;

public class CuentaResponse {
	

		private List<Cuenta> cuentas;

		public CuentaResponse(List<Cuenta> cuentas) {
			this.cuentas = cuentas;
		}

		public List<Cuenta> getCuentas() {
			return cuentas;
		}

		public void setCuentas(List<Cuenta> cuentas) {
			this.cuentas = cuentas;
		}
}
