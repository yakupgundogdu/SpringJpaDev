package com.yg.apps.springjpa.dao.phone;

import com.yg.apps.springjpa.entity.Phone;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
public interface IPhoneDao {

    List<Phone> getAllPhones();

    Phone getPhoneWithId(long id);

    void addPhone(Phone phone);

    void updatePhone(Phone phone);
}
