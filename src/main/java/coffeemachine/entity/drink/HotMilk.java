package coffeemachine.entity.drink;

import coffeemachine.entity.enums.Container;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.processmanager.CoffeeMachine;

public class HotMilk extends Drink {
    public HotMilk() {
        super(0, 3, 0);
    }

    @Override
    public void make(CoffeeMachine coffeeMachine)
            throws ContainerIsEmptyException, ContainerIsFullException {
        Container.MILK.changeCapacity(this);
    }
}
