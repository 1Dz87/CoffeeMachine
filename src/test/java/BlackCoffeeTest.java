import coffeemachine.entity.drink.BlackCoffee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BlackCoffeeTest {

    @Test
    void blackCoffee_ok() {
        BlackCoffee blackCoffee = new BlackCoffee();
        Assertions.assertNotNull(blackCoffee);
        Assertions.assertEquals(2, blackCoffee.getCoffee());
        Assertions.assertEquals(0, blackCoffee.getMilk());
        Assertions.assertEquals(1, blackCoffee.getWater());
    }
}
