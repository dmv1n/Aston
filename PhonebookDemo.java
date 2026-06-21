public class PhonebookDemo {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();

        phonebook.add("Иванов", "+7 999 999-99-99");
        phonebook.add("Иванов", "+7 888 888-88-88");
        phonebook.add("Петров", "+7 777 777-77-77");
        phonebook.add("Сидоров", "+7 666 666-66-66");

        System.out.println("Телефоны Иванова: " + phonebook.get("Иванов"));
        System.out.println("Телефоны Петрова: " + phonebook.get("Петров"));
        System.out.println("Телефоны Сидорова: " + phonebook.get("Сидоров"));
        // Фамилия, которой нет – пустой список
        System.out.println("Телефоны Козлова: " + phonebook.get("Козлов"));
    }
}