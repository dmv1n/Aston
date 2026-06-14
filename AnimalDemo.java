public class AnimalDemo {
    public static void main(String[] args) {
        Dog bobik = new Dog("Бобик");
        Dog sharik = new Dog("Шарик");
        Cat murka = new Cat("Мурка");
        Cat barsik = new Cat("Барсик");

        bobik.run(400);
        bobik.swim(8);
        murka.run(150);
        murka.swim(5);

        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());

        Bowl bowl = new Bowl(30);
        Cat[] cats = {murka, barsik, new Cat("Снежок")};

        System.out.println("\nКоты едят:");
        for (Cat cat : cats) {
            cat.eat(bowl, 15);
        }

        System.out.println("\nДобавляем еду в миску:");
        bowl.addFood(20);

        System.out.println("\nКоты едят ещё раз:");
        for (Cat cat : cats) {
            if (!cat.isFull()) {
                cat.eat(bowl, 15);
            }
        }

        System.out.println("\nСытость котов:");
        for (Cat cat : cats) {
            System.out.println(cat + " сыт? " + (cat.isFull() ? "да" : "нет"));
        }
    }
}