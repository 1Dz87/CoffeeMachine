import coffeemachine.entity.drink.BlackCoffee;
import coffeemachine.entity.drink.Capuchino;
import coffeemachine.entity.enums.Container;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static coffeemachine.entity.enums.Container.GARBAGE;
import static coffeemachine.entity.enums.Container.WATER;

public class ContainersTest {

    @ParameterizedTest
    @EnumSource(Container.class)
    void container_shouldThrowErr(Container container) {
        container.setCapacity(0);
        if (container == GARBAGE) {
            Assertions.assertThrows(ContainerIsFullException.class,
                    () -> container.changeCapacity(new Capuchino()));
        } else {
            Assertions.assertThrows(ContainerIsEmptyException.class,
                    () -> container.changeCapacity(new Capuchino()));
        }
    }

    @Test
    void water_ok() throws ContainerIsEmptyException, ContainerIsFullException {
        WATER.changeCapacity(new BlackCoffee());
        Assertions.assertEquals(5, WATER.getCapacity());
    }
}
