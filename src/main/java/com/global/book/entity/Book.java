package com.global.book.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.Base.BaseEntity;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NamedEntityGraph(name = "loadAuther", attributeNodes = @NamedAttributeNode("auther"))
@Entity
@Table(name = "books")
public class Book extends BaseEntity<Long> {

    @NotNull(message="Should be enter book name")
    private String name;

//    @Min(value = 5)
//    @Max(value = 500)
    private double price;

    @Transient
    private double discounted;

    @Formula("(select count(*) from books)")
    private long bookCount;

    @NotNull
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auther_id")
    private Auther auther;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Auther getAuther() {
        return auther;
    }

    public void setAuther(Auther auther) {
        this.auther = auther;
    }

    public double getDiscounted() {
        return price * .25;
    }

    public void setDiscounted(double discounted) {
        this.discounted = discounted;
    }

    @PostLoad
    private void calcDiscount() {

        this.setDiscounted(price * .25);
    }

    public long getBookCount() {
        return bookCount;
    }

    public void setBookCount(long bookCount) {
        this.bookCount = bookCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                " [id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
