package Homework_9.Interfaces;

@FunctionalInterface
public interface IAddition<T extends Number> {
    T add(T a, T b);
}
