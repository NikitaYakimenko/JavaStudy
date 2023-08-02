package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayList {
    /*
    ArrayList can only contain Objects
    ArrayList does not have a fixed size (a default Array has one)
    при объявлении ArrayList выделяется 10 ячеек, то есть создается массив типа Object с capacity = 10; size = 0
    при добавлении 11-го элемента создается новый массив из 10 ячеек (значения копируются), в конец которого добавляются еще 10 новых пустых ячеек

    capacity можно указывать при инициализации, что сократит время добавления элементов

    ArrayList реализует очень быстрый доступ к элементам
     */
    public static void main(String[] args) {

        ArrayList<String> carNames = new ArrayList<>(Arrays.asList("Toyota Yaris", "Toyota Vios", "Nissan Almera"));

        System.out.println("get third element: " + carNames.get(2)); // get element of index 2
        System.out.println("get length: " + carNames.size()); // get length

        carNames.add("Toyota Yaris Ativ"); // add an element to the end
        System.out.println("get new element: " + carNames.get(3));

        carNames.set(3, null); // replace an element (can not add a new one)
        System.out.println("get changed element: " + carNames.get(3));

        System.out.println("full ArrayList: " + carNames);
        carNames.remove(1); // remove element by index (next elements move left)
        System.out.println("removed Vios: " + carNames);
        carNames.remove(null); // remove element by itself (last equal one if several, none if none) (next elements move left)
        System.out.println("removed null: " + carNames);

        /*
        когда вызывается .remove(Object o), объект удаляется только тогда, когда находится в ArrayList (сравнение методом .equals)
        если нужно передавать другой (не содержащийся) объект и удалять такой же в ArrayList, то
        нужно сравнивать объекты не по ссылке, а по равенству полей, для чего нужно переопределить метод .equals в классе объекта
         */

        ArrayList<Integer> carIds = new ArrayList<>(200); // создается массив размером сразу 200
        carIds.add(1);
        carIds.add(2);
        carIds.add(3);

        ArrayList<String> cars = new ArrayList<>(carNames); // создается копия ArrayList (false(cars == carNames), true(cars.equals(carNames)))
        ArrayList carsAny = new ArrayList<>(carNames);// создается массив Object любого типа
        carsAny.add(12345); // добавляет любой объект
        carsAny.add(new Car());
        System.out.println("ArrayList of different Objects: " + carsAny);

        carNames.add(1, "Ford Raptor"); // добавляет элемент на указанный индекс, сдвигая последующие элементы
        System.out.println("add Ford to 2nd place: " + carNames);

        ArrayList newCarIds = new ArrayList<>(carIds);
        System.out.println("первоначальный newCarIds: " + newCarIds);
        newCarIds.addAll(carNames); // в newCarIds добавлены все элементы carNames (в конец)
        System.out.println("в newCarIds добавлены все элементы carNames: " + newCarIds);
        newCarIds.addAll(2, carNames); // в newCarIds добавлены все элементы carNames (на указанный индекс со сдвигом последующих)
        System.out.println("в newCarIds (начиная с 3 места) добавлены все элементы carNames: " + newCarIds);

        newCarIds.indexOf("Nissan Almera"); // возвращает индекс (для сравнения по полям можно переопределить метод .equals)
        newCarIds.lastIndexOf("Nissan Almera"); // возвращает индекс последнего совпадения (если есть сравнение по полям)

        newCarIds.clear(); // очищает ArrayList
        System.out.println("очищенный newCarIds: " + newCarIds);

        newCarIds.isEmpty(); // проверяет пустой/не пустой
        newCarIds.contains(""); // проверяет, содержит ли ArrayList переданный объект (для сравнения по полям можно переопределить метод .equals)
    }
}

class Car {}