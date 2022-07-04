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
        switch (operation) {
            case EXIT:
                break;
            case BLACK_COFFE:
                createCoffee();
                break;
            case CAPUCHINO:
                createCapuchino();
                break;
            case HOT_MILK:
                createHotMilk();
                break;
            default:
                ioService.write("Неизвестная операция");
                run();
        }
    }

    private  void createHotMilk(){
        Drink hotMilk = new HotMilk();
        try {
            hotMilk.make(this);
            ioService.write(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            ioService.write(e.getMessage());
        }

        run();
    }

    private void createCapuchino() {
        Drink capuchino = new Capuchino();
        try {
            capuchino.make(this);
            ioService.write(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            ioService.write(e.getMessage());
        }
        run();
    }

    private void createCoffee() {
        Drink coffee = new BlackCoffee();
        try {
            coffee.make(this);
            ioService.write(DRINK_READY_MESSAGE);
        } catch (ContainerIsEmptyException | ContainerIsFullException e) {
            ioService.write(e.getMessage());
        }

        run();
    }

    private void welcomeMessage() {
        ioService.write("Выберите напиток");
        ioService.write("1 для кофе");
        ioService.write("2 для капучино");
        ioService.write("3 для горячего молока");
        ioService.write("0 для выхода");
    }

}
