// Запускается компилятор
// Компилятор создаёт байт-код
// Передача байт-кода в JVM
// Начало работы ClassRoaders
// Подгрузка классов JvmComprehension и других системных классов
// Запросы в Application ClassLoader (<- JvmComprehension.class) --> Platform ClassLoader --> Bootstrap ClassLoader
// Загрузка классов в систему загрузчиков классов
// Связывание (Linking)
// Проверка, что код валиден (Verify)
// Подготовка примитивов в статических полях (Prepare)
// Связывание ссылок на другие классы (Resolve)
// Инициализация (Initialization)
// Конец работы ClassRoaders
// Начало работы Runtime Data Area
// Загрузка системных классов в Metaspace
// Загрузка класса JvmComprehension в Metaspace
// создание фрейма main() в стеке (Stack Memory)

public class JvmComprehension {

    public static void main(String[] args) {
        int i = 1;                      // 1 добавление значения i в стек
        Object o = new Object();        // 2 создание объекта в куче (heap), добавление ссылки на объект в стек
        Integer ii = 2;                 // 3 добавление значения ii в пул констант в куче
        printAll(o, i, ii);             // 4 создание фрейма printAll() в стеке, добавление ссылок на о, i и ii в стек
        System.out.println("finished"); // 7 создание фрейма println() в стеке, добавление строки в пул констант в куче, добавление ссылки на строку в стек
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 добавление значения uselessVar в пул констант в куче, добавление ссылки в стек
        System.out.println(o.toString() + i + ii);  // 6 создание фрейма println() в стеке, добавление ссылок на o, i и ii
        // создание фрейма toString() в стеке, добавление ссылки на o, добавление нового значения в пул констант (o.toString), добавление ссылки в стек
        // добавление нового значения в пул констант (o.toString + i), добавление ссылки в стек
        // добавление нового значения в пул констант (o.toString + i + ii), добавление ссылки в стек
    }
}

// Метод toString() возвращает строку
// Метод println() в методе printAll() выводит строку на консоль
// Метод println() в методе main() выводит строку на консоль
// Метод main() завершает работу
// Сборщик мусора удаляет uselessVar, строки, созданные при конкатенации в методе printAll, строку "finished"