package com.yg.apps.springjpa.service.idcard.impl;

import com.yg.apps.springjpa.dao.idcard.IIdCardDao;
import com.yg.apps.springjpa.entity.IdCard;
import com.yg.apps.springjpa.service.idcard.IIdCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IdCardService implements IIdCardService{

    @Autowired
    private IIdCardDao idCardDao;

    @Override
    public List<IdCard> getAllIdCards() {
        return idCardDao.getAllIdCards();
    }

    @Override
    public IdCard getIdCardWithId(long id) {
        return idCardDao.getIdCardWithId(id);
    }

    @Override
    public void addIdCard(IdCard idCard) {
        idCardDao.addIdCard(idCard);
    }

    @Override
    public void updateIdCard(IdCard idCard) {
        idCardDao.updateIdCard(idCard);
    }
}
