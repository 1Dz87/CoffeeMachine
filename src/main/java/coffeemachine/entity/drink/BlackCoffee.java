package coffeemachine.entity.drink;

import coffeemachine.entity.enums.Container;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.processmanager.CoffeeMachine;

public class BlackCoffee extends Drink {
    public BlackCoffee() {
        super(2, 0, 1);

    }

    @Override
    public void make(CoffeeMachine coffeeMachine)
            throws ContainerIsEmptyException, ContainerIsFullException {
        for (int i = 0; i < Container.values().length; i++) {
            if (Container.values()[i] != Container.MILK) {
                Container.values()[i].changeCapacity(this);
            }
        }
    }
}
