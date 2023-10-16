package zlatopolsky;

import zlatopolsky.support.City;

public class Task_33 {
    public static void main(String[] args) {
        City saintPetersburg = new City(5600044, 1439);
        System.out.println("Плотность населения = " + getDensity(saintPetersburg) + " чел.");
    }

    private static int getDensity(City city) {
        return (int) (city.getCitizens() / city.getS());
    }
}
