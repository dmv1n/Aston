package com.example;

public class TriangleArea {
    public static double area(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) throw new IllegalArgumentException("Стороны > 0");
        if (a + b <= c || a + c <= b || b + c <= a) throw new IllegalArgumentException("Не треугольник");
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}