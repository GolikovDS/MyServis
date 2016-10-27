package ru.gds.AppTest.SerialPortApi.SerialPortWrapper;

import jssc.SerialPort;
import jssc.SerialPortException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 19.10.2016.
 */
public class SerialPortWrapper extends SerialPort {
    SerialPort serialPort;

    public SerialPortWrapper(SerialPort serialPort) {
        super(serialPort.getPortName());
        this.serialPort = serialPort;
    }

    public List<String> getPortNames() throws SerialPortException {
        StringBuilder name = new StringBuilder();
        List<String> stringPorts = new ArrayList<>();
        for (Integer i = 1; i < 40; i++) {
            name = new StringBuilder();
            name.append("COM").append(i.toString());
            serialPort = new SerialPort(name.toString());
            try {
                serialPort.openPort();
                stringPorts.add(name.toString());
            } catch (SerialPortException ignored) {
            } finally {
                if (serialPort.isOpened())
                    serialPort.closePort();
            }
        }
        return stringPorts;
    }
}
