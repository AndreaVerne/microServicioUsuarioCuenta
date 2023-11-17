
public class TestUnidad {

	import ar.edu.cresta.dto.ClubFutbolDTO;
	import ar.edu.cresta.model.ClubFutbol;
	import ar.edu.cresta.repository.ClubFutbolRepository;
	import ar.edu.cresta.service.ClubFutbolService;
	import org.junit.jupiter.api.Test;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.Mockito;
	import org.mockito.MockitoAnnotations;

	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.mockito.Mockito.when;

	/* 
	 	Prueba Unitaria:
		Una prueba unitaria verifica el comportamiento de una unidad aislada de código, 
		como un método o una función, sin depender de otras partes del sistema.
		Se utiliza Mockito para simular el comportamiento de las dependencias y 
		se enfoca en probar la lógica interna de la unidad bajo prueba.

		Prueba de Integración:
		Una prueba de integración evalúa la interacción entre múltiples componentes del sistema.
		Se utiliza un entorno más realista, como una base de datos en memoria, 
		para verificar que los componentes interactúen correctamente. 
		En este contexto, Spring Boot y la anotación @DataJpaTest se utilizan para 
		configurar un entorno de prueba de integración con una base de datos real. 
		La prueba garantiza que el sistema funcione de manera cohesiva en conjunto. 
	*/

	public class ClubFutbolServiceUnidadTest {

		/* NO SE GRABA EN BD */

		@Mock // Clase simulada
		private ClubFutbolRepository clubFutbolRepository;

		@InjectMocks // Clase donde se inyectara el mock
		private ClubFutbolService clubFutbolService;

		// Inicializa todo
		public ClubFutbolServiceUnidadTest() {
			MockitoAnnotations.openMocks(this);
		}

		@Test
		public void testGuardarClub() {
		
			 
			ClubFutbolDTO clubDTO = new ClubFutbolDTO("ClubTest", "EstadioTest", "UbicacionTest");
			when(clubFutbolRepository.save(Mockito.any(ClubFutbol.class)))
					.thenReturn(new ClubFutbol("ClubTest", "EstadioTest", "UbicacionTest"));

			// Llamar al método del servicio y verificar el resultado
			ClubFutbol clubGuardado = clubFutbolService.guardarClub(clubDTO);

			// Verificar que el método del repositorio se llamó una vez y con los parámetros
			// correctos
			// Mockito.verify(clubFutbolRepository,
			// Mockito.times(1)).save(Mockito.any(ClubFutbol.class));

			// Verificar que los datos del club guardado coinciden con los datos
			// proporcionados en el DTO
			assertEquals("ClubTest", clubGuardado.getNombre());
			assertEquals("EstadioTest", clubGuardado.getEstadio());
			assertEquals("UbicacionTest", clubGuardado.getUbicacion());
		}
	}

