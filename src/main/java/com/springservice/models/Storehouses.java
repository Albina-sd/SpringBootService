package com.springservice.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="storehouses")
@Getter
@Setter
public class Storehouses {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String country;

    public Storehouses(){
    }

    public Storehouses(Long id, String name, String address, String city, String country){
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }

}
