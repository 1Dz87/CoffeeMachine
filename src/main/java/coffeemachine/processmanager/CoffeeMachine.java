package coffeemachine.processmanager;

import coffeemachine.entity.container.CoffeContainer;
import coffeemachine.entity.container.GarbageContainer;
import coffeemachine.entity.container.MilkContainer;
import coffeemachine.entity.container.WaterContainer;
import coffeemachine.entity.drink.BlackCoffee;
import coffeemachine.entity.drink.Capuchino;
import coffeemachine.entity.drink.Drink;
import coffeemachine.entity.drink.HotMilk;
import coffeemachine.exception.ContainerIsEmptyException;
import coffeemachine.exception.ContainerIsFullException;
import coffeemachine.service.IOService;
import coffeemachine.service.IOServiceImpl;

public class CoffeeMachine {
    private CoffeContainer coffeContainer;
    private GarbageContainer garbageContainer;
    private MilkContainer milkContainer;
    private WaterContainer waterContainer;
    private IOService ioService;
    private static final String DRINK_READY_MESSAGE = "Ваш напиток готов";


    public CoffeeMachine() {
        this.coffeContainer = new CoffeContainer(10);
        this.garbageContainer = new GarbageContainer(5);
        this.milkContainer = new MilkContainer(3);
        this.waterContainer = new WaterContainer(6);
        this.ioService = new IOServiceImpl();
    }

    public void run() {
        welcomeMessage();
        chooseOperation();
    }

    private void chooseOperation() {
        int operation = ioService.read();
        switch (operation) {
            case 0:
                break;
            case 1:
                createCoffee();
                break;
            case 2:
                createCapuchino();
                break;
            case 3:
                createHotMilk();
                break;
            default:
                ioService.write("Неизвестная операция");
                run();
        }
    }

    public CoffeContainer getCoffeContainer() {
        return coffeContainer;
    }

    public GarbageContainer getGarbageContainer() {
        return garbageContainer;
    }

    public MilkContainer getMilkContainer() {
        return milkContainer;
    }

    public WaterContainer getWaterContainer() {
        return waterContainer;
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
