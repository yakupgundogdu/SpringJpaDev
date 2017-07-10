package com.yg.apps.springjpa.dao.phone.impl;

import com.yg.apps.springjpa.dao.phone.IPhoneDao;
import com.yg.apps.springjpa.entity.Phone;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Repository
public class PhoneDao implements IPhoneDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Phone> getAllPhones() {
        List<Phone> phones = entityManager.createQuery("Select a From Phone a", Phone.class).getResultList();
        return phones;
    }

    @Override
    public Phone getPhoneWithId(long id) {
        return entityManager.find(Phone.class, id);
    }

    @Override
    public void addPhone(Phone phone) {
        entityManager.persist(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        entityManager.merge(phone);
    }
}
