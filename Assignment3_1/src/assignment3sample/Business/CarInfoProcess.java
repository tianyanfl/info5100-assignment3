/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3sample.Business;

import java.util.*;

/**
 *
 * @author tusiyu
 */
public class CarInfoProcess {

    public static final int QUES_1 = 1;
    public static final int QUES_2 = 2;
    public static final int QUES_3 = 3;
    public static final int QUES_4 = 4;
    public static final int QUES_5 = 5;
    public static final int QUES_6 = 6;
    public static final int QUES_7 = 7;
    public static final int QUES_8 = 8;
    public static final int QUES_9 = 9;
    public static final int QUES_10 = 10;
    public static final int QUES_11 = 11;

    private static List<Car> carList;
    private static long lastUpdateTime = System.currentTimeMillis();

    static {
        carList = new ArrayList<>();

        Car car1 = new Car(false, "Ferrari", 2019, 1, 2, 1, "Red One", "Boston", true);
        Car car2 = new Car(true, "BMW", 2019, 1, 4, 2, "X1", "New York", true);
        Car car3 = new Car(true, "Toyota", 2018, 1, 4, 3, "T1", "Boston", false);
        Car car4 = new Car(false, "GM", 2018, 1, 4, 4, "G1", "New York", true);
        Car car5 = new Car(true, "Toyota", 2017, 1, 4, 5, "T2", "Chicago", true);
        Car car6 = new Car(true, "GM", 2017, 1, 4, 6, "G2", "Chicago", false);
        Car car7 = new Car(false, "Ferrari", 2016, 1, 4, 7, "", "Seattle", true);
        Car car8 = new Car(true, "BMW", 2016, 1, 4, 8, "X2", "Seattle", true);
        Car car9 = new Car(false, "Toyota", 2019, 1, 4, 9, "T3", "Austin", false);
        Car car10 = new Car(true, "GM", 2019, 1, 4, 10, "G3", "Austin", true);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
        carList.add(car6);
        carList.add(car7);
        carList.add(car8);
        carList.add(car9);
        carList.add(car10);
    }

    public static List<Car> getCarList() {
        return Collections.unmodifiableList(carList);
    }

    public static void addNewCar(Car car, int index) {
        carList.add(index, car);
        lastUpdateTime = System.currentTimeMillis();
    }

    public static void addNewCar(Car car) {
        carList.add(car);
        lastUpdateTime = System.currentTimeMillis();
    }

    public static int removeCarBySerialNum(int previewSerialNum) {
        Map<Integer, Car> map = getSerialNumMap();
        Car car = map.get(previewSerialNum);
        int index = carList.indexOf(car);
        if (car != null) {
            carList.remove(car);
        }
        lastUpdateTime = System.currentTimeMillis();
        return index;
    }

    public static Map<Integer, Car> getSerialNumMap() {
        Map<Integer, Car> carMap = new LinkedHashMap<>();
        for (Car car : carList) {
            carMap.put(car.getSerial_num(), car);
        }
        return carMap;
    }

    public static Object filter(int quesNum, Object... args) {
        Object object = null;
        switch (quesNum) {
            case QUES_1:
                object = quest1(getSerialNumMap());
                break;
            case QUES_2:
                object = quest2(getSerialNumMap());
                break;
            case QUES_3:
                object = quest3(getSerialNumMap(), (String) args[0]);
                break;
            case QUES_4:
                object = quest4(getSerialNumMap(), (String) args[0]);
                break;
            case QUES_5:
                object = quest5(getSerialNumMap(), (Integer) args[0], (Integer) args[1]);
                break;
            case QUES_6:
                object = quest6(getSerialNumMap(), (Integer) args[0]);
                break;
            case QUES_7:
                object = quest7(getSerialNumMap(), (String) args[0]);
                break;
            case QUES_8:
                object = quest8(getSerialNumMap());
                break;
            case QUES_9:
                object = quest9(getSerialNumMap());
                break;
                case QUES_10:
                object = quest10(getSerialNumMap(),(String) args[0]);
                break;
            case QUES_11:
                object = quest11(getSerialNumMap());
                break;
            default:
                break;
        }

        return object;
    }

    private static Object quest11(Map<Integer, Car> serialNumMap) {
        List<Car> cars = new ArrayList<>();
        for (Car car : serialNumMap.values()) {
            if (!car.isMaintenance_certificate()) {
                cars.add(car);
            }
        }
        return cars;
    }

    private static Object quest10(Map<Integer, Car> serialNumMap, String city) {
        List<Car> cars = new ArrayList<>();
        city = city == null ? "" : city.trim();
        if (city.length() == 0) {
            return cars;
        }
        for (Car car : serialNumMap.values()) {
            if (city.equalsIgnoreCase(car.getAvailable_city())) {
                cars.add(car);
            }
        }
        return cars;
    }

    private static Long quest9(Map<Integer, Car> serialNumMap) {
        return lastUpdateTime;
    }

    private static Set<String> quest8(Map<Integer, Car> serialNumMap) {
        Set<String> cars = new LinkedHashSet<>();
        for (Car car : serialNumMap.values()) {
            cars.add(car.getBrand());
        }
        return cars;
    }

    private static List<Car> quest7(Map<Integer, Car> serialNumMap, String modelNum) {
        List<Car> cars = new ArrayList<>();
        modelNum = modelNum == null ? "" : modelNum.trim();
        if (modelNum.length() == 0) {
            return cars;
        }
        for (Car car : serialNumMap.values()) {
            if (modelNum.equalsIgnoreCase(car.getModel_num() + "")) {
                cars.add(car);
            }
        }
        return cars;
    }

    private static Car quest5(Map<Integer, Car> serialNumMap, int minNum, int maxNum) {
        for (Car car : serialNumMap.values()) {
            if (car.getMin_seats() == minNum && car.getMax_seats() == maxNum) {
                return car;
            }
        }
        return null;
    }

    private static List<Car> quest4(Map<Integer, Car> serialNumMap, String year) {
        List<Car> cars = new ArrayList<>();
        year = year == null ? "" : year.trim();
        if (year.length() == 0) {
            return cars;
        }
        for (Car car : serialNumMap.values()) {
            if (year.equalsIgnoreCase(car.getManufactured_year() + "")) {
                cars.add(car);
            }
        }
        return cars;
    }

    private static List<Car> quest3(Map<Integer, Car> serialNumMap, String brand) {
        List<Car> cars = new ArrayList<>();
        brand = brand == null ? "" : brand.trim();
        if (brand.length() == 0) {
            return cars;
        }
        for (Car car : serialNumMap.values()) {
            if (brand.equalsIgnoreCase(car.getBrand())) {
                cars.add(car);
            }
        }
        return cars;
    }

    private static Car quest1(Map<Integer, Car> serialNumMap) {
        for (Car car : serialNumMap.values()) {
            if (car.isAvailable()) {
                return car;
            }
        }
        return null;
    }

    private static int quest2(Map<Integer, Car> serialNumMap) {
        int count = 0;
        for (Car car : serialNumMap.values()) {
            if (car.isAvailable()) {
                count++;
            }
        }
        return count;
    }


    private static Car quest6(Map<Integer, Car> serialNumMap, int serialNum) {
        return serialNumMap.get(serialNum);
    }

}
