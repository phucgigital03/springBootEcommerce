package com.example.eCommerceUdemy.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

//product_id BIGINT
//description VARCHAR(255)
//discount DOUBLE
//image VARCHAR(255)
//price DOUBLE
//product_name VARCHAR(255)
//quantity INT
//special_price DOUBLE
//category_id BIGINT
//seller_id BIGINT

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String description;
    private String image;
    private String productName;
    private double discount;
    private double price;
    private double specialPrice;
    private int quantity;

    @Column(name = "deleted")
    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    private User seller;

    @OneToMany(mappedBy = "product",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
//                    CascadeType.REMOVE
            },
            fetch = FetchType.EAGER
    )
    @ToString.Exclude
    private List<CartItem> products = new ArrayList<>();
}
