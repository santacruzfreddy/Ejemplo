package com.rmm.services.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rmm.services.enumeration.TypeDevice;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "list_price")
public class ListPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long listPriceId;

    Double price;

    @Enumerated(EnumType.STRING)
    TypeDevice type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "service_id")
    @JsonIgnore
    private ServiceEntity service;

    public ListPrice() {
    }

    public ListPrice(Long listPriceId, Double price, TypeDevice type) {
        this.listPriceId = listPriceId;
        this.price = price;
        this.type = type;
    }

    public Long getListPriceId() {
        return listPriceId;
    }

    public void setListPriceId(Long listPriceId) {
        this.listPriceId = listPriceId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public TypeDevice getType() {
        return type;
    }

    public void setType(TypeDevice type) {
        this.type = type;
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }
}
