package gr.aueb.mscis.educore.persistence;

import gr.aueb.mscis.educore.core.util.SearchParameters;
import gr.aueb.mscis.educore.model.core.CoreEntity;
import gr.aueb.mscis.educore.persistence.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class AbstractDao<T extends CoreEntity> implements GenericDao<T>{
    private Class<T> clazz;

    @PersistenceContext
    protected EntityManager entityManager;

    public AbstractDao(){
        clazz = (Class<T>) ((ParameterizedType)getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];

        entityManager = JpaUtil.getCurrentEntityManager();
    }

    public final void setClazz(final Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findOne(final long id) {
        return entityManager.find(clazz, id);
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public T saveOrUpdate(final T entity){
        if(Objects.isNull(entity.getId())){
            return this.create(entity);
        }
        else{
            return this.update(entity);
        }
    }

    public T create(final T entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.persist(entity);
        tx.commit();
        return entity;
    }

    public T update(final T entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        T updatedEntity = entityManager.merge(entity);
        tx.commit();
        return updatedEntity;
    }

    public void delete(final T entity) {
        EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        entityManager.remove(entity);
        tx.commit();
    }

    public void deleteById(final long entityId) {
        final T entity = findOne(entityId);
        delete(entity);
    }

    @Override
    public List<T> search(SearchParameters parameters) {
        String query = "from " + clazz.getName();

        if(Objects.nonNull(parameters) && !parameters.getParameters().keySet().isEmpty()) {
            query = query + " where " +
                    parameters
                            .getParameters()
                            .entrySet()
                            .stream()
                            .map(AbstractDao::getWhereString)
                            .collect(Collectors.joining(" and "));
        }

        return entityManager.createQuery(query).getResultList();
    }

    private static String getWhereString(Map.Entry<String, Object> entry) {
        if ("id".equals(entry.getKey())) {
            return entry.getKey() + " = " + entry.getValue();
        }
        else {
            return entry.getKey() + " like '%" + entry.getValue() + "%'";
        }
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
}
