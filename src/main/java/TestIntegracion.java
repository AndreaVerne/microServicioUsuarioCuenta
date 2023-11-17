
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
        CuentaDto cuentalDTO = new CuentaDTO("ClubTest", "EstadioTest", "UbicacionTest");

        // Llamar al método del servicio que interactúa con la base de datos
        Cuenta cuentaGuardado = CuentaService.guardarCuenta(CuentaDto);

        // Verificar que el club se ha guardado correctamente en la base de datos
        assertNotNull(cuentaGuardado.getId());
        
        assertEquals("ClubTest", cuentaGuardado.getNombre());
        assertEquals("EstadioTest", cuentaGuardado.getEstadio());
        assertEquals("UbicacionTest", cuentaGuardado.getUbicacion());

        // Verificar que el club se puede recuperar correctamente de la base de datos
        Cuenta cuentaRecuperado = CuentaRepository.findById(clubGuardado.getId()).orElse(null);
        assertNotNull(cuentaRecuperado);
        assertEquals("ClubTest", cuentaRecuperado.getNombre());
        assertEquals("EstadioTest", cuentaRecuperado.getEstadio());
        assertEquals("UbicacionTest", cuentaRecuperado.getUbicacion());
    }
}
