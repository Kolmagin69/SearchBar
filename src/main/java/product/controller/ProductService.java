package product.controller;

import product.model.Product;
import product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> listAll(String keyword) {
        if (keyword != null) {
            return repository.search(keyword);
        }
        return repository.findAll();
    }

    public void save(final Product product) {
        repository.save(product);
    }

    public Product get(final int id) {
        return repository.findById(id).get();
    }

    public void delete(final int id) {
        repository.deleteById(id);
    }


}
