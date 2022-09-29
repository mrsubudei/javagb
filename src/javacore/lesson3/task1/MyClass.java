package javacore.lesson3.task1;

public class MyClass<T>
{
    private T[] args;

    public MyClass(T... args) {
        this.args = args;
    }

    public void changeElements() {
        T tmp = args[1];
        args[1] = args[0];
        args[0] = tmp;
    }

    public int checkArrLength() {
        return args.length;
    }

    public T getElement(int n) {
        return args[n];
    }
}
