package com.yg.apps.springjpa.dao.idcard;

import com.yg.apps.springjpa.entity.IdCard;

import java.util.List;

/**
 * Created by yakup on 10.07.2017.
 */
public interface IIdCardDao {

    List<IdCard> getAllIdCards();

    IdCard getIdCardWithId(long id);

    void addIdCard(IdCard idCard);

    void updateIdCard(IdCard idCard);
}
