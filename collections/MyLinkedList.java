package collections;

import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList {
    /*
    LinkedList представляет собой набор ссылок на элементы, каждый из которых имеет ссылку на следующий и предыдущий
    Head - первый элемент
    Tail - последний элемент
    LinkedList поддерживает те же методы, что и ArrayList (тк они оба наследуют класс List)

    Doubly (default), Singly
    LinkedList реализует очень быстрое добавление и удаление объектов
     */
    public static void main(String[] args) {
        LinkedList<String> carNames = new LinkedList<>(Arrays.asList("Toyota Yaris", "Toyota Vios", "Nissan Almera"));
        System.out.println(carNames.get(2)); // операция долгая, тк поиск начинается с Head
        // сдвига при этом не происходит, тк достаточно скорректировать ссылки следующего и предыдущего элементов
    }
}
