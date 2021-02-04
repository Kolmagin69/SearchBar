package product.repository;

import product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("SELECT p FROM Product p WHERE CONCAT(p.name, ' ', p.brand, ' ', p.madeIn, ' ', p.price) LIKE %?1%")
    List<Product> search(String keyword);

}
