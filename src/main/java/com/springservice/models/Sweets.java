package com.springservice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "sweets")
public class Sweets {

    //ToDo: проверить соединение таблиц
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="sweets_type", referencedColumnName = "id")
    @Column(nullable = false)
    private Long sweets_types_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private Integer weight;

    //@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="manufacturers", referencedColumnName = "id")
    @Column(nullable = false)
    private Integer manufacturer_id;

    private Boolean with_sugar;

    private Boolean requires_freezing;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate production_date;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate expiration_date;

    public Sweets(){
    }

    public Sweets(long id, long sweets_types_id, String name, int cost, int weight,
                  int manufacturer_id, boolean with_sugar, boolean requires_freezing,
                  LocalDate production_date, LocalDate expiration_date){
        this.id = id;
        this.sweets_types_id = sweets_types_id;
        this.name = name;
        this.cost = cost;
        this.weight = weight;
        this.manufacturer_id= manufacturer_id;
        this.with_sugar = with_sugar;
        this.requires_freezing = requires_freezing;
        this.production_date = production_date;
        this.expiration_date = expiration_date;
    }

}

