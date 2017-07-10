package com.yg.apps.springjpa.dao.idcard.impl;

import com.yg.apps.springjpa.dao.idcard.IIdCardDao;
import com.yg.apps.springjpa.entity.IdCard;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Repository
public class IdCardDao implements IIdCardDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<IdCard> getAllIdCards() {
        List<IdCard> idCards = entityManager.createQuery("Select a From IdCard a", IdCard.class).getResultList();
        return idCards;
    }

    @Override
    public IdCard getIdCardWithId(long id) {
        return entityManager.find(IdCard.class, id);
    }

    @Override
    public void addIdCard(IdCard idCard) {
        entityManager.persist(idCard);
    }

    @Override
    public void updateIdCard(IdCard idCard) {
        entityManager.merge(idCard);
    }
}
