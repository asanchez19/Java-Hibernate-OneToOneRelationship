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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author alejandrosanchez
 */
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = IDENTITY)
    int id;
    @Column
    String name;
    @JoinColumn(name = "passport_detail_id")
    @OneToOne
    private Passport_detail passport_detail_id; //reference to Department

    public Person(int id, String name, Passport_detail passport_detail_id) {
        this.id = id;
        this.name = name;
        this.passport_detail_id = passport_detail_id;
    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport_detail getPassport_detail_id() {
        return passport_detail_id;
    }

    public void setPassport_detail_id(Passport_detail passport_detail_id) {
        this.passport_detail_id = passport_detail_id;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", passport_detail_id=" + passport_detail_id + '}';
    }

  

    
}
