package coffeemachine.entity.drink;

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
        coffeeMachine.getCoffeContainer().changeCapacity(this);
        coffeeMachine.getMilkContainer().changeCapacity(this);
        coffeeMachine.getWaterContainer().changeCapacity(this);
        coffeeMachine.getGarbageContainer().changeCapacity(this);
    }
}
