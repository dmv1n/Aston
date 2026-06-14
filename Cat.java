public class Cat extends Animal {
    private static int catCount = 0;
    private boolean isFull;

    public Cat(String name) {
        super(name, 200, 0);
        isFull = false;
        catCount++;
    }

    public void eat(Bowl bowl, int amount) {
        if (!isFull && bowl.getFood() >= amount) {
            bowl.decreaseFood(amount);
            isFull = true;
            System.out.println(name + " поел(а), теперь сыт(а).");
        } else if (isFull) {
            System.out.println(name + " уже сыт(а).");
        } else {
            System.out.println(name + " не хватило еды в миске.");
        }
    }

    public boolean isFull() {
        return isFull;
    }

    public static int getCatCount() {
        return catCount;
    }
}