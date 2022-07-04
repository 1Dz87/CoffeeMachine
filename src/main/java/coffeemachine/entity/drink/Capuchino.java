package coffeemachine.entity.drink;

import coffeemachine.entity.enums.Container;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.processmanager.CoffeeMachine;

public class Capuchino extends Drink {
    public Capuchino() {
        super(2, 1, 1);
    }

    @Override
    public void make(CoffeeMachine coffeeMachine)
            throws ContainerIsEmptyException, ContainerIsFullException {
        for (int i = 0; i < Container.values().length; i++) {
            Container.values()[i].changeCapacity(this);
        }
    }
}
