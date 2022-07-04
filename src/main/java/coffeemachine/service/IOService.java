package coffeemachine.service;

import coffeemachine.entity.enums.Button;

public interface IOService {
    Button read();
    void write(String message);

}
