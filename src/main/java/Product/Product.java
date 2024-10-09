package Product;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private float prijs;
    private List<Integer> ovChipkaarten;

    public Product(int product_nummer, String naam, String beschrijving, float prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        this.ovChipkaarten = new ArrayList<>();
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public float getPrijs() {
        return prijs;
    }

    public void setPrijs(float prijs) {
        this.prijs = prijs;
    }

    public List<Integer> getOvChipkaarten() {
        return new ArrayList<>(ovChipkaarten);
    }

    public void addOVChipkaart(int kaartNummer) {
        if (!ovChipkaarten.contains(kaartNummer)) {
            ovChipkaarten.add(kaartNummer);
        }
    }

    public void removeOVChipkaart(int kaartNummer) {
        ovChipkaarten.remove(Integer.valueOf(kaartNummer));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Product Details:\n")
                .append("  Product Nummer: ").append(product_nummer).append("\n")
                .append("  Naam: ").append(naam).append("\n")
                .append("  Beschrijving: ").append(beschrijving).append("\n")
                .append("  Prijs: €").append(String.format("%.2f", prijs)).append("\n")
                .append("  OV Chipkaarten: ").append(ovChipkaarten.isEmpty() ? "Geen" : ovChipkaarten.toString()).append("\n");
        return stringBuilder.toString();
    }
}
