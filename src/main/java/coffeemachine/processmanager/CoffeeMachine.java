package coffeemachine.processmanager;

import coffeemachine.entity.drink.BlackCoffee;
import coffeemachine.entity.drink.Capuchino;
import coffeemachine.entity.drink.Drink;
import coffeemachine.entity.drink.HotMilk;
import coffeemachine.entity.enums.Button;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.service.IOService;
import coffeemachine.service.IOServiceImpl;

public class CoffeeMachine {
    private IOService ioService;
    private static final String DRINK_READY_MESSAGE = "Ваш напиток готов";


    public CoffeeMachine() {
        this.ioService = new IOServiceImpl();
    }

    public void run() {
        welcomeMessage();
        chooseOperation();
    }

    private void chooseOperation() {
        Button operation = ioService.read();
        operation.create(this);

    }

    private void welcomeMessage() {
        ioService.write("Выберите напиток");
        ioService.write("1 для кофе");
        ioService.write("2 для капучино");
        ioService.write("3 для горячего молока");
        ioService.write("0 для выхода");
    }

}
