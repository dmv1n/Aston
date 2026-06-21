public class ArrayDemo {
    public static void main(String[] args) {
        // Правильный массив 4x4
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        // Массив с некорректным размером (3x4) – раскомментируйте, чтобы проверить ошибку размера
        // String[][] wrongSizeArray = {
        //     {"1", "2", "3", "4"},
        //     {"5", "6", "7", "8"},
        //     {"9", "10", "11", "12"}
        // };

        // Массив с некорректными данными (в ячейке [1][2] текст) – раскомментируйте, чтобы проверить ошибку данных
        // String[][] wrongDataArray = {
        //     {"1", "2", "3", "4"},
        //     {"5", "6", "abc", "8"},
        //     {"9", "10", "11", "12"},
        //     {"13", "14", "15", "16"}
        // };

        try {
            int sum = processArray(correctArray);
            System.out.println("Сумма элементов: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Пример обработки ArrayIndexOutOfBoundsException
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // индекс 5 не существует
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }

    public static int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        // Проверка размера: должно быть 4 строки
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен иметь 4 строки, а имеет " + array.length);
        }
        // Проверка, что каждая строка имеет 4 элемента
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " должна содержать 4 элемента, а содержит " + array[i].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]: '" + array[i][j] + "' не является числом.");
                }
            }
        }
        return sum;
    }
}