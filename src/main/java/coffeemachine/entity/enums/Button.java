package coffeemachine.entity.enums;

import coffeemachine.entity.drink.BlackCoffee;
import coffeemachine.entity.drink.Capuchino;
import coffeemachine.entity.drink.Drink;
import coffeemachine.entity.drink.HotMilk;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.processmanager.CoffeeMachine;

public enum Button {

    EXIT {
        @Override
        public void create(CoffeeMachine coffeeMachine) {
            return;
        }
    },
    BLACK_COFFE{
        @Override
        public void create(CoffeeMachine coffeeMachine) {
            Drink coffee = new BlackCoffee();
            try {
                coffee.make(coffeeMachine);
            } catch (ContainerIsEmptyException | ContainerIsFullException e) {
                e.printStackTrace();
            }
        }
    },
    CAPUCHINO{
        @Override
        public void create(CoffeeMachine coffeeMachine) {
            Drink coffee = new Capuchino();
            try {
                coffee.make(coffeeMachine);
            } catch (ContainerIsEmptyException | ContainerIsFullException e) {
                e.printStackTrace();
            }
        }
    },
    HOT_MILK{
        @Override
        public void create(CoffeeMachine coffeeMachine) {
            Drink coffee = new HotMilk();
            try {
                coffee.make(coffeeMachine);
            } catch (ContainerIsEmptyException | ContainerIsFullException e) {
                e.printStackTrace();
            }
        }
    };

    public abstract void create(CoffeeMachine coffeeMachine);
}
