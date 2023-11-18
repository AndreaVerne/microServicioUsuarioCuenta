


	import ps.model.Cuenta;
	import ps.model.dto.CuentaDto;
	import ps.repository.CuentaRepository;
	import ps.servicios.CuentaService;
	import org.junit.jupiter.api.Test;

	import static org.mockito.Mockito.when;
	import static org.springframework.test.util.AssertionErrors.assertTrue;

	import java.net.http.HttpHeaders;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;


	
	public class TestUnidad {


		@Mock // Clase simulada
		private CuentaRepository cuentaRepository;

		@InjectMocks // Clase donde se inyectara el mock
		private CuentaService cuentaService;

		
		// Inicializa todo
		public TestUnidad() {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		public void testGuardarCuenta() {
		
			 
			CuentaDto cuentaDto = new CuentaDto(345.5 ,214, 01-11-2023);
			when(cuentaRepository.save(Mockito.any(Cuenta.class)))
					.thenReturn(new Cuenta(345.5 ,214, 01-11-2023));

			// Llamar al método del servicio y verificar el resultado
			Cuenta cuentaGuardado = cuentaService.guardarCuenta(cuentaDto);
			
			
			 assertEquals(345.5, cuentaGuardado.getSaldo());
		        assertEquals(214, cuentaGuardado.getId());
		        assertEquals("01/11/2023", cuentaGuardado.getFecha_creacion());
		}
	}

