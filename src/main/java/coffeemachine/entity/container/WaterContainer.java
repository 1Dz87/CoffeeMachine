package coffeemachine.entity.container;

import coffeemachine.entity.drink.Drink;
import coffeemachine.exception.ContainerIsEmptyException;

public class WaterContainer extends Container {
    public WaterContainer(int capacity) {
        super(capacity);
        this.name = "контейнер для воды";
    }

    public void changeCapacity(Drink drink) throws ContainerIsEmptyException {
        if (this.capacity < drink.getWater()){
            throw new ContainerIsEmptyException(this.name);
        }
        this.capacity = this.capacity - drink.getWater();
    }

    @Override
    public void reset() {
        this.capacity = 6;
    }
}
