package coffeemachine.entity.container;

import coffeemachine.entity.drink.Drink;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;

public class CoffeContainer extends Container {
    public CoffeContainer(int capacity) {
        super(capacity);
        this.name = "контейнер для кофе";
    }

    public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
        if (this.capacity < drink.getCoffee()) {
            throw new ContainerIsEmptyException(this.name);
        }
        this.capacity = this.capacity - drink.getCoffee();
    }

    @Override
    public void reset() {
        this.capacity = 10;
    }
}
