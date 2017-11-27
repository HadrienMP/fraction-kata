package fr.hadrienmp.katas.fraction;

public interface Addable<T> {
    T plus(T other);
    T minus(T other);
}
