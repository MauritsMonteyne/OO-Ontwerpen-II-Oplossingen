package testen;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import domein.ContinentService;
import persistentie.PersistentieController;

@ExtendWith(MockitoExtension.class)
public class ContinentServiceTest {

	
	@Mock
	private PersistentieController persistentieControllerDummy;

	@InjectMocks
	private ContinentService continentService;
	
	private static final String CODE = "CODE";
	
	
	private void dummyTrainen(long aantalBewoners, long geboorteCijfer, long sterfteCijfer) {
		
		Mockito.lenient().when(persistentieControllerDummy.findAantalBewoners(CODE))	// lenient() in geval thenReturn() niet uitgevoerd
			.thenReturn(aantalBewoners);												// wordt door een exception.

		Mockito.lenient().when(persistentieControllerDummy.findGeboortecijfers(CODE))
			.thenReturn(geboorteCijfer);
		
		Mockito.lenient().when(persistentieControllerDummy.findSterfteCijfer(CODE))
			.thenReturn(sterfteCijfer);
		
	}
	
	private void controleGeboorteOverschot(double verwachteResultaat, double afwijking) {
		
		Assertions.assertEquals(verwachteResultaat, continentService.geefGeboorteOverschot(CODE), afwijking);
		
		Mockito.verify(persistentieControllerDummy).findAantalBewoners(CODE);
		Mockito.verify(persistentieControllerDummy).findGeboortecijfers(CODE);
		Mockito.verify(persistentieControllerDummy).findSterfteCijfer(CODE);
	}
	
	
	@Test
	public void testGeboorteOverschot() {
		
		dummyTrainen(16405399L, 184634L, 135136L);
		controleGeboorteOverschot(3.01, 0.009);
	}

	@Test
	public void testSterfteOverschot() {
		
		dummyTrainen(18506500L, 277597L, 333117L);
		controleGeboorteOverschot(-3, 0.01);
	}
	
	
	// TODO: string test, inwoners >= 0, geboorten/sterften > 0 (3 method source)
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"   "})
	public void lege_spaties_nullContinent(String continent) {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			continentService.geefGeboorteOverschot(continent);
		});
	}
	
	
	/* Ongeldigwaarden */
	private static Stream<Arguments> ongeldigeWaarden() {
		return Stream.of(
				Arguments.of(0L, 184634L, 135136L),
				Arguments.of(-1L, 184634L, 135136L),
				Arguments.of(20000000L, -1, 135136L),
				Arguments.of(20000000L, 184634L, -1L));
	}
	
	@ParameterizedTest
	@MethodSource("ongeldigeWaarden")
	public void ongeldigeWaardenTest(long inwoners, long geboorten, long sterftes) {
		
		dummyTrainen(inwoners, geboorten, sterftes);
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {			// leniet() toevoegen
			continentService.geefGeboorteOverschot(CODE);
		});
	}

	
	/* RandWaarden */
	private static Stream<Arguments> randWaarden() {
		return Stream.of(
				Arguments.of(1L, 15L, 14L, 1000.0, 0),
				Arguments.of(30000L, 0L, 15020L, -500.6, 0.09),
				Arguments.of(30000L, 15020L, 0L, 500.6, 0.09),
				Arguments.of(1L, 0L, 0L, 0, 0));
	}
	
	@ParameterizedTest
	@MethodSource("randWaarden")
	public void randWaardenTest(long inwoners, long geboorten, long sterftes, double verwachteResultaat, double afwijking) {
		
		dummyTrainen(inwoners, geboorten, sterftes);
		
		controleGeboorteOverschot(verwachteResultaat, afwijking);
	}

}
