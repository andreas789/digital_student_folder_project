package gr.aueb.mscis.educore.persistence;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.core.CoreEntity;

import java.util.List;

public interface GenericDao<T extends CoreEntity> {
    void setClazz(Class< T > clazzToSet);

    T findOne(final long id);

    List<T> findAll();

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

    List<T> search(SearchParameters parameters);
}
