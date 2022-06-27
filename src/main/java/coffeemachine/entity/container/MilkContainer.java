package coffeemachine.entity.container;

import coffeemachine.entity.drink.Drink;
import coffeemachine.exception.ContainerIsEmptyException;

public class MilkContainer extends Container {
    public MilkContainer(int capacity) {
        super(capacity);
        this.name = "контейнер для молока";
    }

    public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
        if (this.capacity < drink.getMilk()) {
            throw new ContainerIsEmptyException(this.name);
        }
        this.capacity = this.capacity - drink.getMilk();
    }

    @Override
    public void reset() {
        this.capacity = 3;
    }
}
