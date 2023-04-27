package storage;

public interface IReadAndWrite<E> {
    void writeFile(E file);
    E readFile();
}