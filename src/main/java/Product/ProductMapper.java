package Product;

import OVChipkaart.OVChipkaart;

import java.util.List;

public interface ProductMapper {
    boolean save(Product product);
    boolean update(Product product);
    boolean delete(Product product);
    List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);
    List<Product> findAll();
}
