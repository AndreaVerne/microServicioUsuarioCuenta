package test;

	import static mockito.Mockito.when;
	import static org.springframework.test.util.AssertionErrors.assertTrue;

	import java.net.http.HttpHeaders;
	import java.util.Date;
	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import ps.model.dto.CuentaDto;
	import ps.model.Cuenta;
	import ps.repository.CuentaRepository;
	import ps.servicios.CuentaService;

	
	
	public class testService {
		
	@SpringBootTest (webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT);


	  @Autowired
	  private CuentaService cuentaService;

	  @MockBean
	  private CuentaRepository cuentaRepository;

	  @Test
	  public void testRetrieveParadaWithMockRepository() throws Exception {

	    Optional<CuentaDto> optCuenta = Optional.of(crearCuenta(345.5 ,214, "cuenta"));

	  }

	    private CuentaDto crearCuenta(double saldo, int i, String string) {
			  CuentaDto cuentaDto = new CuentaDto(345.5 ,214, "cuenta");
		    return cuentaDto;
		  }

	}

