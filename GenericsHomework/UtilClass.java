package GenericsHomework;

import java.util.ArrayList;
import java.util.List;

/**
 * Сделайте методы типизированными (Используйте generics)
 */
public class UtilClass {
    /**
     * Возвращает true, если список равен null или если список пуст
     *
     * @param list список.
     * @return true, если список равен null или если список пуст
     */
    public static <T>  boolean isBlank(List<T> list) {
        boolean ans = (list == null);
        if (!ans) {
            ans = (list.size() == 0);
        }
        return ans;
    }

    /**
     * Получает последний элемент в коллекции
     * Если список равен null, то выбрасывается исключение IllegalArgumentException
     *
     * @param list список
     * @return последний элемент в коллекции
     */
    public static <T> T getLastElem(List<T> list) throws IllegalArgumentException {
        if (list == null) {
            throw new IllegalArgumentException();
        } else {
            return list.get(list.size() - 1);
        }
    }

    /**
     * Получает элемент из списка.
     * Если в аргументах список или элемент равен null, то выбрасывается исключение IllegalArgumentException
     * Если элемент не найден, то возвращаем null
     *
     * @param list список, в котором ищем элемент
     * @param elem элемент, который ищется в списке.
     * @return элемент из списка.
     */
    public static <T> T findElem(List<T> list, T elem) throws IllegalArgumentException {
        if (list == null | elem == null) {
            throw new IllegalArgumentException();
        } else {
            T ans = null;
            for (T i : list) {
                if (i == elem) {
                    ans = i;
                }
            }
            return ans;
        }
    }

    /**
     * Объединяет два списка.
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return возвращает объединенный список.
     */
    public static <T> List<T> union(List<T> list1, List<T> list2) throws IllegalArgumentException {
        if (list1 == null | list2 == null) {
            throw new IllegalArgumentException();
        } else {
            List<T> newList = new ArrayList<T>(list1);
            newList.addAll(list2);
            return newList;
        }
    }

    /**
     * Удаляет все элементы из списка list1, которые встречаются в списке list2
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return возвращает список, который содержит элементы из списка list1, в котором удалены все элементы из
     * списка list2.
     */
    public static <T> List<T> removeAll(List<T> list1, List<T> list2) throws IllegalArgumentException {
        if (list1 == null | list2 == null) {
            throw new IllegalArgumentException();
        } else {
            List<T> newList = new ArrayList<T>(list1);
            for (T i : list2) {
                newList.remove(i);
            }
            return newList;
        }
    }

    /**
     * Складывает числа из обоих списков и возвращает сумму.
     * Если хотя-бы один из аргументов равен null, то выбрасываем исключение IllegalArgumentException
     * Аргументы метода не меняются
     * Подсказка:
     * 1) Помните, что все объекты чисел (Integer, Double, Float и т.д) наследуются от общего предка Number.
     * 2) Используйте ограничения для типизации, чтобы списки могли содержать любые числа (Integer, Double, Float и т.д)
     * 3) Для приведения Number к double воспользуйтесь num.doubleValue();
     *
     * @param list1 первый список
     * @param list2 второй список
     * @return сумма чисел.
     */
    public static <T> double sum(List<? extends Number> list1, List<? extends Number> list2) throws IllegalArgumentException {
        if (list1 == null | list2 == null) {
            throw new IllegalArgumentException();
        } else {
            double summa = 0;
            for (Number num : list1) {
                summa += num.doubleValue();
            }
            for (Number num : list2) {
                summa += num.doubleValue();
            }
            return summa;
        }
    }
}
