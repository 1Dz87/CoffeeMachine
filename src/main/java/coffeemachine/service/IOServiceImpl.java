package coffeemachine.service;

import coffeemachine.entity.enums.Button;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOServiceImpl implements IOService {
    private BufferedReader bufferedReader;

    public IOServiceImpl() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Button read() {
        try {
            String s = bufferedReader.readLine();
            return Button.values()[Integer.parseInt(s)];
        } catch (IOException | ArrayIndexOutOfBoundsException e) {
            write("Произошла Ошибка. Повторите ввод");
            return read();
        }
    }

    public void write(String message) {
        System.out.println(message);
    }
}
