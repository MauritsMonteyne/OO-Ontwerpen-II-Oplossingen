package testen;

import java.util.Arrays;
import java.util.stream.Stream;

import static domein.InitTeerling.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import domein.Teerling;

class TeerlingTest {

	
	private Teerling teerling;
	
	
	// Test Constructor correct
	private static Stream<Integer> addFixture() {
		return Stream.of(DEFAULT, MIN_GRENS, 10, 20, 30, 50, 100, 1000, MAX_GRENS);
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = { DEFAULT, MIN_GRENS, 10, 20, 30, 50, 100, 1000, MAX_GRENS})
	public void correcteTeerlingMaken(int grootte) {
		before(grootte);
		Assertions.assertEquals(grootte, teerling.getAantalVlakken());
	}
	
	// OF MethodSource
	
	/*
	@ParameterizedTest
	@MethodSource("addFixture")
	public void correcteTeerlingMaken(int grootte) {
		before(grootte);
		Assertions.assertEquals(grootte, teerling.getAantalVlakken());
	} 
	*/
	
	private void before(int grootte) {
		if (grootte == DEFAULT)
			teerling = new Teerling();
		else
			teerling = new Teerling(grootte);
	}
	
	
	// Test Constructor fout
	@ParameterizedTest
	@ValueSource(ints = { Integer.MIN_VALUE, -100, -4, -1, MIN_GRENS - 1, 0, MAX_GRENS + 1, Integer.MAX_VALUE})
	public void foutieveTeerling(int grootte) {
		Assertions.assertThrows(IllegalArgumentException.class, () -> new Teerling(grootte));
	}
	
	
	// Test gooien, elke waarde min 1 keer
	private final int AANTAL = 100;
	
	@ParameterizedTest
	@MethodSource("addFixture")
	public void teerlingGooiBinnenGrenzen(int grootte) {
		before(grootte);
		
		int[] resultaat = new int[teerling.getAantalVlakken()];
		
		for (int i = 0; i < teerling.getAantalVlakken() * AANTAL; i++) {
			int worp = teerling.gooi();
			Assertions.assertTrue(worp >= 1 && worp <= teerling.getAantalVlakken());
			resultaat[worp -1]++;
		}
		
		Arrays.stream(resultaat).forEach((e -> Assertions.assertTrue(e > 0)));
		
		
	}
	
	
}
