package com.example.eCommerceUdemy.repository;

import com.example.eCommerceUdemy.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p from Product p where p.category.categoryId = ?1")
    Page<Product> findProductsByCategoryId(Long categoryId, Pageable pageable);

    @Query("select p from Product p where LOWER(p.productName) like LOWER(concat('%', :keyword, '%'))")
    Page<Product> findProductsByLikeProductName(@Param("keyword") String keyword, Pageable pageable);
}
