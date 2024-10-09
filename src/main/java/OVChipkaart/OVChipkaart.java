package OVChipkaart;

import Product.Product;
import Reiziger.Reiziger;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OVChipkaart {
    private int kaartNummer;
    private Date geldigTot;
    private int klasse;
    private float saldo;
    private Reiziger reiziger;
    private List<Product> producten;

    public OVChipkaart(int kaartNummer, Date geldigTot, int klasse, float saldo, Reiziger reiziger) {
        this.kaartNummer = kaartNummer;
        this.geldigTot = geldigTot;
        this.klasse = klasse;
        this.saldo = saldo;
        setReiziger(reiziger);
        this.producten = new ArrayList<>();
    }

    public OVChipkaart() {
        this.producten = new ArrayList<>();
    }

    public int getKaartNummer() {
        return kaartNummer;
    }

    public void setKaartNummer(int kaartNummer) {
        this.kaartNummer = kaartNummer;
    }

    public Date getGeldigTot() {
        return geldigTot;
    }

    public void setGeldigTot(Date geldigTot) {
        this.geldigTot = geldigTot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }

    public List<Product> getProducten() {
        return producten;
    }

    public void setProducten(List<Product> producten) {
        this.producten = producten;
    }

    public void addProduct(Product product) {
        if (!producten.contains(product)) {
            producten.add(product);
            product.addOVChipkaart(kaartNummer);
        }
    }

    public void removeProduct(Product product) {
        if (producten.remove(product)) {
            product.removeOVChipkaart(kaartNummer);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = geldigTot != null ? dateFormat.format(geldigTot) : "onbekend";

        stringBuilder.append("  Kaartnummer: ").append(kaartNummer).append("\n")
                .append("  Geldig tot: ").append(formattedDate).append("\n")
                .append("  Klasse: ").append(klasse).append("\n")
                .append("  Saldo: €").append(String.format("%.2f", saldo)).append("\n")
                .append("  Producten:").append("\n");

        if (producten.isEmpty()) {
            stringBuilder.append("    Geen producten\n");
        } else {
            for (Product product : producten) {
                stringBuilder.append("      Product Nummer: ").append(product.getProduct_nummer()).append("\n")
                        .append("      Naam: ").append(product.getNaam()).append("\n")
                        .append("      Beschrijving: ").append(product.getBeschrijving()).append("\n")
                        .append("      Prijs: €").append(String.format("%.2f", product.getPrijs())).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
