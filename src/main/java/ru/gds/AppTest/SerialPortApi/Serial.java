package ru.gds.AppTest.SerialPortApi;

import jssc.SerialPort;
import jssc.SerialPortException;
import ru.gds.AppTest.SerialPortApi.SerialPortWrapper.SerialPortWrapper;

/**
 * Created by User on 18.10.2016.
 */
public class Serial {

    public static void main(String[] args) {
        SerialPortWrapper serialPort = new SerialPortWrapper(new SerialPort("COM1"));
        try {
            System.out.println(serialPort.getPortNames());
            serialPort.openPort();
            serialPort.writeByte((byte) 0xFA);
            serialPort.closePort();
        } catch (SerialPortException e) {
            e.printStackTrace();
        }


//        try {
//            serialPort.openPort();
//            serialPort.setParams(9600, 8, 1, 0);
//            serialPort.writeString("Get data");
//        } catch (SerialPortException e) {
//            e.printStackTrace();
//            System.out.println("Exception");
//        } finally {
//            serialPort.closePort();
//        }
    }

//    public String[] getPortNames() throws SerialPortException {
//        StringBuilder name = new StringBuilder();
//        List<String> stringPorts = new ArrayList<>();
//        for (Integer i = 1; i < 40; i++) {
//            name = new StringBuilder();
//            name.append("COM" + i.toString());
//            serialPort = new SerialPort(name.toString());
//            try {
//                serialPort.openPort();
//                stringPorts.add(name.toString());
//            } catch (SerialPortException e) {
//            } finally {
//                if (serialPort.isOpened())
//                    serialPort.closePort();
//            }
//        }
//        return stringPorts.toArray(new String[stringPorts.size()]);
//    }
}
