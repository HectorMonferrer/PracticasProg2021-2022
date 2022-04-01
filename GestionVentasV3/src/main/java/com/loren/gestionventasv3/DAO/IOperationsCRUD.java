package com.loren.gestionventasv3.DAO;

import java.util.List;

public interface IOperationsCRUD<T> {
    public List<T> getAll();
    public T findById(T object);
    public int add(T object);
    public int update(T object);
    public int delete(T object);
}
