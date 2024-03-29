package test;
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

	@Autowired
    private CuentaService cuentaService;


    @Test
    public void testCuentaIntegration() {
    	
    	// Configuración manual sin usar @Autowired
    	CuentaService cuentaService = new CuentaService(cuentaRepository);
        
        // Crear un objeto DTO con datos de prueba
        CuentaDto cuentaDTO = new CuentaDto (345.5 ,214, "cuenta");

        // Llamar al método del servicio que interactúa con la base de datos
        Cuenta cuentaGuardado = cuentaService.guardarCuenta(cuentaDTO);

        // Verificar que el club se ha guardado correctamente en la base de datos
        assertNotNull(cuentaGuardado.getId());
        assertEquals(345.5, cuentaGuardado.getSaldo());
        assertEquals(214, cuentaGuardado.getId());
        assertEquals("cuenta", cuentaGuardado.getMercado_pago());
        
        // Verificar que el club se puede recuperar correctamente de la base de datos
        Cuenta cuentaRecuperado = cuentaRepository.findById(cuentaGuardado.getId()).orElse(null);
        assertNotNull(cuentaRecuperado);
        assertEquals(345.5, cuentaRecuperado.getSaldo());
        assertEquals(214, cuentaRecuperado.getId());
        assertEquals( "cuenta", cuentaRecuperado.getMercado_pago());
    }
}
