package org.example;
// <T extends IPrototype<T>> asegura que el tipo devuelto sea exactamente la clase que implementa la interfaz
public interface IPrototype<T extends IPrototype> extends Cloneable {

    // Clonacion simple / Simple clone
    public T clone();

    // Clonacion profunda / Deep clone
    public T deepClone();
}