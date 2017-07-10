package com.yg.apps.springjpa.service.phone.impl;

import com.yg.apps.springjpa.dao.phone.IPhoneDao;
import com.yg.apps.springjpa.entity.Phone;
import com.yg.apps.springjpa.service.phone.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneDao phoneDao;

    @Override
    public List<Phone> getAllPhones() {
        return phoneDao.getAllPhones();
    }

    @Override
    public Phone getPhoneWithId(long id) {
        return phoneDao.getPhoneWithId(id);
    }

    @Override
    public void addPhone(Phone phone) {
        phoneDao.addPhone(phone);
    }

    @Override
    public void updatePhone(Phone phone) {
        phoneDao.updatePhone(phone);
    }
}
