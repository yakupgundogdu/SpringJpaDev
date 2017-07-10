package com.yg.apps.springjpa.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by yakup on 08.07.2017.
 */
@Entity
@Table(name = "tb_id_card")
public class IdCard implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "serial_number", unique = true, nullable = false, length = 16)
    private String serialNumber;

    /** USED
     * Unidirectional Relationship for Employee (O)-(O) IdCard
     * Employee.java => @JoinColumn(name = "id_card_id")
     *                  BECAUSE id_card_id in this table
     * IdCard.java => --------
     **/
    /** UNUSED
     * Bidirectional Relationship for [Employee (O)-(O) IdCard]
     * Employee.java => private IdCard idCard;
     * IdCard.java => @OneToOne(optional = false, cascade = CascadeType.ALL,
                          mappedBy = "idCard", targetEntity = Employee.class)
                     private Employee employee;
    **/

    public IdCard() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
