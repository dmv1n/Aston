public class Park {
    public static class Attraction {
        private String name;
        private String workingHours;
        private int price;

        public Attraction(String name, String workingHours, int price) {
            this.name = name;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void display() {
            System.out.println("Аттракцион: " + name + ", время работы: " + workingHours + ", цена: " + price);
        }
    }
}
