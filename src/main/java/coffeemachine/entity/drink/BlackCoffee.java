package coffeemachine.entity.drink;

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
        coffeeMachine.getCoffeContainer().changeCapacity(this);
        coffeeMachine.getWaterContainer().changeCapacity(this);
        coffeeMachine.getGarbageContainer().changeCapacity(this);
    }
}
