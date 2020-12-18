package testen;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
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

import domein.Aangifte;
import domein.Boekhouding;
import domein.FactuurMap;

import static domein.InitBoekHouding.*;

@ExtendWith(MockitoExtension.class)
class BoekhoudingTest {


	@Mock
	private FactuurMap factuurMapDummy;
	
	@InjectMocks
	private Boekhouding boekhouding;

	
	private static Stream<Arguments> geldigeWaarden() {
		return Stream.of(
				Arguments.of(new double[] {0.0, 0.0, 0.0}, BELASTINGSCHAAL_0),
				Arguments.of(new double[] {20.0, 50.0, 30.0}, BELASTINGSCHAAL_0),
				Arguments.of(new double[] {20.0, 150.0, 29.99}, BELASTINGSCHAAL_0),
				Arguments.of(new double[] {150.0, 50.0, 0.0}, BELASTINGSCHAAL_1),
				Arguments.of(new double[] {100.0, 100.0, 36.0}, BELASTINGSCHAAL_1)
				);
	}
	
	
	@ParameterizedTest
	@MethodSource("geldigeWaarden")
	public void genereerAangifte_Correct(double[] bedragen, double belastingsschaal) {
		
		String ondernemingsNr = "BE0123456789";
		
		// Mock trainen
		Mockito.when(factuurMapDummy.geefBedragen(ondernemingsNr))
			.thenReturn(bedragen);
		
		// Controles uitvoeren (Assertions).
		Aangifte aangifte = boekhouding.genereerAangifte(ondernemingsNr);
		
		Assertions.assertEquals(belastingsschaal, aangifte.getBelastingSchaal());
		Assertions.assertArrayEquals(bedragen, aangifte.getBedragen());
		
		// Na test verifiëren of mock goed opgeroepen werd
		Mockito.verify(factuurMapDummy).geefBedragen(ondernemingsNr);
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"    ", "NL0123456789", "BE01234567", "be012345678", "be012345678", "BE012345678910"})
	public void genereerAangifte_FoutOndernemingsNr(String ondernemingsNr) {
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			boekhouding.genereerAangifte(ondernemingsNr);
		});
	}
}
