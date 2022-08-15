package com.example.product.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product implements Serializable {

    private static final long serialUIDVersion = 1L;

    private Long id;
    private String code;
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdOne;
    private boolean status;

    public Product() {}

    public Product(Long id, String code, String name, String description, BigDecimal price, LocalDateTime createdOne, boolean status) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.price = price;
        this.createdOne = createdOne;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public LocalDateTime getCreatedOne() {
        return createdOne;
    }

    public boolean isStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCreatedOne(LocalDateTime createdOne) {
        this.createdOne = createdOne;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return isStatus() == product.isStatus() && Objects.equals(getId(), product.getId()) && Objects.equals(getCode(), product.getCode()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && Objects.equals(getCreatedOne(), product.getCreatedOne());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCode(), getName(), getDescription(), getPrice(), getCreatedOne(), isStatus());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", createdOne=" + createdOne +
                ", status=" + status +
                '}';
    }
}
