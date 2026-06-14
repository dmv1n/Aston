public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = Math.max(food, 0);
    }

    public int getFood() {
        return food;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            food += amount;
            System.out.println("Добавлено " + amount + " еды. В миске теперь " + food);
        }
    }

    public void decreaseFood(int amount) {
        if (amount <= food) {
            food -= amount;
        }
    }
}