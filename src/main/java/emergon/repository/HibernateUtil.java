/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.repository;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alkinoos
 */
public class HibernateUtil<E> {

    @Autowired
    private SessionFactory sessionFactory;
    private Session session;

    protected Session getSession() {
        session = sessionFactory.getCurrentSession();
        return session;
    }

    //Methods for CRUD operations
    protected List<E> findAll(String query) {
        session = getSession();
        Query myQuery = session.createNamedQuery(query);  //NAMED QUERY APO TO ENTITY edo mesa
        List<E> list = myQuery.getResultList();
        return list;
    }

    protected E save(E entity) {
        session = getSession();
        session.saveOrUpdate(entity);
        return entity;
    }

    protected E find(Class<E> type, int id) {
        session = getSession();
        E e = session.find(type, id);
        return e;
    }

    public void delete(Class<E> type, int id) {
        session = getSession();
        E e = session.find(type, id);
        session.remove(e);
    }
    
//    TODO generic findByFk
//    protected List<E> findByFk(String query,int id){
//        session = getSession();
//        Query myquery = session.createNamedQuery(query);
//        myquery.setParameter("scode", id);
//        List<E> list = myquery.getResultList();
//        return list;
//    }
}
