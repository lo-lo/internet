package com.javable.lec_11;
/**
 * если у нас есть список сотрудников, то нам может потребоваться порядок по фамилиям и порядок по табельным номерам.
 *В этом случае вместо интерфейса Comparable следует использовать интерфейс Comparator:
 * можем сравнивать объекты класса при помощи одного или другого компаратора
 * Пример: построить TreeSet, упорядоченый по ФИО служащего.
 * TreeSet reestr = new TreeSet(Employer.getNameComparator());
 * Далее мы можем добавлять в reestr объекты класса Employer. Они будут автоматически упорядочиваться по ФИО
 */

import java.util.*;

public class Employer {    // служащий
    int tabnom;        // табельный номер
    String name;      // ФИО

    //созданы объекты статических вложенных классов NameComparator и TabComparator
    static NameComparator nameComparator = new  NameComparator();
    static TabComparator tabComparator = new  TabComparator();

    //для получения конкретного компаратора методы
    public static Comparator getNameComparator() {
        return nameComparator;
    }

    public static Comparator getTabComparator() {
        return tabComparator;
    }

    //заданы два статических вложенных класса NameComparator и TabComparator
    //- вспомогательные классы, используемые для сравнения объектов в различных вариантах порядка
    //на одном и том же множестве
    static class NameComparator implements Comparator {

        public int compare(Object o1, Object o2) {
            return ((Employer)o1).name.compareTo(((Employer)o2).name);
        }
// метод equals() реализовывать не обязательно
    }

    static class TabComparator  implements Comparator {
        public int compare(Object o1, Object o2) {
            return (((Employer)o1).tabnom - ((Employer)o2).tabnom);
        }
    }

}

