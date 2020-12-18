import domain.Pizza;
import domain.PizzaFactory;
import domain.PizzaStore;

public class PizzaTestDrive {

    public static void main(String... args) {
        PizzaFactory factory = new PizzaFactory();
        PizzaStore store = new PizzaStore(factory);

        Pizza pizza = store.orderPizza("cheese");
        System.out.printf("\nWe ordered a %s\n\n", pizza.getName());

        pizza = store.orderPizza("veggie");
        System.out.printf("\nWe ordered a %s\n\n", pizza.getName());
    }
}
