import Adres.Adres;
import Adres.AdresMapper;
import OVChipkaart.OVChipkaart;
import OVChipkaart.OVChipkaartMapper;
import Product.Product;
import Product.ProductMapper;
import Reiziger.Reiziger;
import Reiziger.ReizigerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.Date;
import java.util.List;

public class Main {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        try {
            // Load MyBatis configuration
            System.out.println("Loading MyBatis configuration...");
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println("MyBatis configuration loaded successfully.");

            // Open a session
            try (SqlSession session = sqlSessionFactory.openSession()) {
                // Get mappers
                ReizigerMapper reizigerMapper = session.getMapper(ReizigerMapper.class);
                AdresMapper adresMapper = session.getMapper(AdresMapper.class);
                OVChipkaartMapper ovChipkaartMapper = session.getMapper(OVChipkaartMapper.class);
                ProductMapper productMapper = session.getMapper(ProductMapper.class);

                // Test saving a new Reiziger
                System.out.println("Testing for saving a new reiziger...");
                Reiziger newReiziger = new Reiziger(100, "A", "van", "Dijk", Date.valueOf("1990-01-01"), null);
                boolean saveReizigerResult = reizigerMapper.save(newReiziger);
                session.commit();
                System.out.println("Save operation result (Reiziger): " + saveReizigerResult);
                System.out.println("Saved reiziger: \n" + newReiziger);

                // Test saving a new Adres for Reiziger
                System.out.println("Testing for saving a new adres for reiziger...");
                Adres newAdres = new Adres(200, "Main", "1", "1234AB", "Amsterdam", newReiziger);
                boolean saveAdresResult = adresMapper.save(newAdres);
                session.commit();
                System.out.println("Save operation result (Adres): " + saveAdresResult);
                System.out.println("Saved adres: \n" + newAdres);

                // Test saving a new OVChipkaart for Reiziger
                System.out.println("Testing for saving a new OVChipkaart for reiziger...");
                OVChipkaart newOVChipkaart = new OVChipkaart(300, Date.valueOf("2025-01-01"), 1, 50.0f, newReiziger);
                boolean saveOVChipkaartResult = ovChipkaartMapper.save(newOVChipkaart);
                session.commit();
                System.out.println("Save operation result (OVChipkaart): " + saveOVChipkaartResult);
                System.out.println("Saved OVChipkaart: \n" + newOVChipkaart);

                // Test saving a new Product
                System.out.println("Testing for saving a new product...");
                Product newProduct = new Product(400, "Product A", "Description for Product A", 29.99f);
                boolean saveProductResult = productMapper.save(newProduct);
                session.commit();
                System.out.println("Save operation result (Product): " + saveProductResult);
                System.out.println("Saved product: \n" + newProduct);

                // Test updating a Reiziger
                System.out.println("Testing for updating a reiziger...");
                newReiziger.setAchternaam("Vermeer");
                boolean updateReizigerResult = reizigerMapper.update(newReiziger);
                session.commit();
                System.out.println("Update operation result (Reiziger): " + updateReizigerResult);
                System.out.println("Updated reiziger: \n" + newReiziger);

                // Test updating the Adres for Reiziger
                System.out.println("Testing for updating the adres for reiziger...");
                newAdres.setStraat("Updated Street");
                boolean updateAdresResult = adresMapper.update(newAdres);
                session.commit();
                System.out.println("Update operation result (Adres): " + updateAdresResult);
                System.out.println("Updated adres: \n" + newAdres);

                // Test updating the OVChipkaart for Reiziger
                System.out.println("Testing for updating the OVChipkaart for reiziger...");
                newOVChipkaart.setSaldo(75.0f);
                boolean updateOVChipkaartResult = ovChipkaartMapper.update(newOVChipkaart);
                session.commit();
                System.out.println("Update operation result (OVChipkaart): " + updateOVChipkaartResult);
                System.out.println("Updated OVChipkaart: \n" + newOVChipkaart);

                // Test updating the Product
                System.out.println("Testing for updating the product...");
                newProduct.setPrijs(34.99f);
                boolean updateProductResult = productMapper.update(newProduct);
                session.commit();
                System.out.println("Update operation result (Product): " + updateProductResult);
                System.out.println("Updated product: \n" + newProduct);

                // Test finding a Reiziger by ID
                System.out.println("Testing for finding a reiziger by id...");
                Reiziger reiziger = reizigerMapper.findById(100);
                if (reiziger != null) {
                    System.out.println("Reiziger found: \n" + reiziger);
                } else {
                    System.out.println("No reiziger found with ID: 100");
                }

                // Test finding the Adres of a Reiziger
                System.out.println("Testing for finding the adres of a reiziger...");
                List<Adres> foundAdressen = adresMapper.findByReiziger(newReiziger);
                if (!foundAdressen.isEmpty()) {
                    System.out.println("Adressen found for reiziger: \n" + foundAdressen);
                } else {
                    System.out.println("No adres found for reiziger with ID: " + newReiziger.getId());
                }

                // Test finding the OVChipkaart of a Reiziger
                System.out.println("Testing for finding OVChipkaarten for a reiziger...");
                List<OVChipkaart> foundOVChipkaarten = ovChipkaartMapper.findByReiziger(newReiziger);
                if (!foundOVChipkaarten.isEmpty()) {
                    System.out.println("OVChipkaarten found for reiziger: \n" + foundOVChipkaarten);
                } else {
                    System.out.println("No OVChipkaart found for reiziger with ID: " + newReiziger.getId());
                }

                // Test finding all Products
                System.out.println("Testing for finding all products...");
                List<Product> products = productMapper.findAll();
                System.out.println("Number of products found: " + products.size());
                for (Product p : products) {
                    System.out.println(p);
                }

                // Test finding all Reizigers
                System.out.println("Testing for finding all reizigers...");
                List<Reiziger> reizigers = reizigerMapper.findAll();
                System.out.println("Number of reizigers found: " + reizigers.size());
                for (Reiziger r : reizigers) {
                    System.out.println(r);
                }

                // Test finding all Adressen
                System.out.println("Testing for finding all adressen...");
                List<Adres> adressen = adresMapper.findAll();
                System.out.println("Number of adressen found: " + adressen.size());
                for (Adres a : adressen) {
                    System.out.println(a);
                }

                // Test finding all OVChipkaarten
                System.out.println("Testing for finding all OVChipkaarten...");
                List<OVChipkaart> ovChipkaarten = ovChipkaartMapper.findAll();
                System.out.println("Number of OVChipkaarten found: " + ovChipkaarten.size());
                for (OVChipkaart o : ovChipkaarten) {
                    System.out.println(o);
                }

                // Test deleting the Adres
                System.out.println("Testing for deleting the adres...");
                boolean deleteAdresResult = adresMapper.delete(newAdres);
                session.commit();
                System.out.println("Delete operation result (Adres): " + deleteAdresResult);
                System.out.println("Adres with ID " + newAdres.getId() + " deleted successfully.");

                // Test deleting the OVChipkaart
                System.out.println("Testing for deleting the OVChipkaart...");
                boolean deleteOVChipkaartResult = ovChipkaartMapper.delete(newOVChipkaart);
                session.commit();
                System.out.println("Delete operation result (OVChipkaart): " + deleteOVChipkaartResult);
                System.out.println("OVChipkaart with ID " + newOVChipkaart.getKaartNummer() + " deleted successfully.");

                // Test deleting the Product
                System.out.println("Testing for deleting the product...");
                boolean deleteProductResult = productMapper.delete(newProduct);
                session.commit();
                System.out.println("Delete operation result (Product): " + deleteProductResult);
                System.out.println("Product with ID " + newProduct.getProduct_nummer() + " deleted successfully.");

                // Test deleting the Reiziger
                System.out.println("Testing for deleting the reiziger...");
                boolean deleteReizigerResult = reizigerMapper.delete(newReiziger);
                session.commit();
                System.out.println("Delete operation result (Reiziger): " + deleteReizigerResult);
                System.out.println("Reiziger with ID " + newReiziger.getId() + " deleted successfully.");
            }
        } catch (Exception e) {
            System.err.println("An error occurred during the execution:");
            e.printStackTrace();
        }
    }
}
