0
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import ps.repository.CuentaRepository;
import ps.servicios.CuentaService;
import ps.model.Cuenta;
import ps.model.dto.CuentaDto;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest //configura la prueba para utilizar una configuración específica de JPA y proporciona una base de datos en memoria para las pruebas
@AutoConfigureMockMvc //se usa para configurar automáticamente el entorno de la aplicación
public class TestIntegracion {

	@Autowired
    private CuentaRepository cuentaRepository;

    @Test
    public void testCuentaIntegration() {
    	
    	// Configuración manual sin usar @Autowired
    	CuentaService cuentaService = new CuentaService(cuentaRepository);
        
        // Crear un objeto DTO con datos de prueba
        CuentaDto cuentalDTO = new CuentaDto ("saldo", "214", "01/11/2023");

        // Llamar al método del servicio que interactúa con la base de datos
        Cuenta cuentaGuardado = CuentaService.guardarCuenta(CuentaDto);

        // Verificar que el club se ha guardado correctamente en la base de datos
        assertNotNull(cuentaGuardado.getId());
        assertEquals("saldo", cuentaRecuperado.getSaldo());
        assertEquals("214", cuentaRecuperado.getId());
        assertEquals("1/11/2023", cuentaRecuperado.getFecha_creacion());
        
        // Verificar que el club se puede recuperar correctamente de la base de datos
        Cuenta cuentaRecuperado = CuentaRepository.findById(cuentaGuardado.getId()).orElse(null);
        assertNotNull(cuentaRecuperado);
        assertEquals("saldo", cuentaRecuperado.getSaldo());
        assertEquals("214", cuentaRecuperado.getId());
        assertEquals("1/11/2023", cuentaRecuperado.getFecha_creacion());
    }
}
