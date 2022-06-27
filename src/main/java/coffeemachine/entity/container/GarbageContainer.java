package coffeemachine.entity.container;

import coffeemachine.entity.drink.Drink;
import coffeemachine.exception.ContainerIsFullException;

public class GarbageContainer extends Container {
    private int currentState;

    public GarbageContainer(int capacity) {
        super(capacity);
        this.name = "контейнер для мусора";
        this.currentState = 0;
    }

    @Override
    public boolean isEmpty() {
        return currentState < capacity;
    }

    public void changeCapacity(Drink drink) throws ContainerIsFullException {
        if (this.currentState == this.capacity) {
            throw new ContainerIsFullException();
        }
        this.currentState = this.currentState + 1;
    }

    @Override
    public void reset() {
        this.currentState = this.capacity;
    }
}
