public class FiguresDemo {
    public static void main(String[] args) {
        Shape circle = new Circle(5, "Жёлтый", "Красный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Зелёный");
        Shape triangle = new Triangle(3, 4, 5, "Оранжевый", "Чёрный");

        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();
    }
}