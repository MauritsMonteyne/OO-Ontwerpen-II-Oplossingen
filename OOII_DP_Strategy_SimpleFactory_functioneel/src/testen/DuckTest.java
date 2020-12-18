package testen;

import static domein.DuckSpecies.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import domein.Duck;
import domein.DuckFactory;
import domein.DuckSpecies;
import domein.FlyRocketPowered;

class DuckTest {

	private final static String FLY_NO_WAY = "Ik kan niet vliegen";
	private final static String FLY_WITH_WINGS = "Ik vlieg!!";
	private final static String QUACK = "Ik kwaak";
	private final static String SQUEAK = "Piep";
	private final static String MUTE_QUACK = "<<Stilte>>";
	private final String flyRocketPowered = "Ik vlieg met raketaandrijving";

	private DuckFactory duckFactory;

	@BeforeEach
	public void before() {
		duckFactory = new DuckFactory();	
	}

	private static Stream<Arguments> duckProvider() {
		return Stream.of(Arguments.of(MALLARD, "Ik ben een echte wilde eend", QUACK, FLY_WITH_WINGS),
				Arguments.of(RUBBER, "Ik ben een badeend", SQUEAK, FLY_NO_WAY),
				Arguments.of(REDHEAD, "Ik lijk op een roodkuifeend", QUACK, FLY_WITH_WINGS),
				Arguments.of(DECOY, "Ik ben een lokeend", MUTE_QUACK, FLY_NO_WAY));
	}

	@ParameterizedTest
	@MethodSource("duckProvider")
	public void testDuck(DuckSpecies kind, String expectedDisplay, String expectedQuack, String expectedFly) {
		Duck duck = duckFactory.createDuck(kind);
		Assertions.assertEquals(expectedDisplay, duck.display());
		Assertions.assertEquals(expectedQuack, duck.performQuack());
		Assertions.assertEquals(expectedFly, duck.performFly());
	}

	@ParameterizedTest
	@MethodSource("duckProvider")
	public void wijzigAtRuntime(DuckSpecies kind, String expectedDisplay, String expectedQuack, String expectedFly) {
		Duck duck = duckFactory.createDuck(kind);
		duck.setFlyBehavior(new FlyRocketPowered());
		Assertions.assertEquals(flyRocketPowered, duck.performFly());
	}

}
