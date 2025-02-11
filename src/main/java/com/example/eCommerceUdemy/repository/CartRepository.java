package com.example.eCommerceUdemy.repository;

import com.example.eCommerceUdemy.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    @Query("select c from Cart c where c.user.email = ?1")
    Cart findCartByEmail(String email);
}
