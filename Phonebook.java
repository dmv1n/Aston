import java.util.*;

public class Phonebook {
    private Map<String, List<String>> map = new HashMap<>();

    // Добавить запись (фамилия, телефон)
    public void add(String surname, String phone) {
        // Если фамилия уже есть, добавить номер в существующий список
        map.computeIfAbsent(surname, k -> new ArrayList<>()).add(phone);
    }

    // Получить все телефоны по фамилии
    public List<String> get(String surname) {
        return map.getOrDefault(surname, Collections.emptyList());
    }
}