/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package una.ac.cr.oneToOne.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author alejandrosanchez
 */
@Entity
@Table(name = "passport_detail") //If name is not supplied hibernate will use class name as table name
public class Passport_detail {
    @Id
    @Column //If name is not supplied hibernate will use field name as column name
    @GeneratedValue(strategy = IDENTITY)
    int id;
    @Column
    String passportno;

    public Passport_detail(int id, String passportno) {
        this.id = id;
        this.passportno = passportno;
    }

    public Passport_detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportno() {
        return passportno;
    }

    public void setPassportno(String passportno) {
        this.passportno = passportno;
    }

    @Override
    public String toString() {
        return "Passport_detail{" + "id=" + id + ", passportno=" + passportno + '}';
    }
    
}
