package app.dao;

import java.util.List;

public interface DAO<A> {
    A get(int id);
    List<A> getAll();
}
