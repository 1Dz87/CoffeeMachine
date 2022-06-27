package coffeemachine.entity.container;

import coffeemachine.entity.drink.Drink;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;

public abstract class Container {
    int capacity;
    String name;

    public Container(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return capacity==0;
    }

    public abstract void changeCapacity(Drink drink)
            throws ContainerIsEmptyException, ContainerIsFullException;

    public abstract void reset();
}
