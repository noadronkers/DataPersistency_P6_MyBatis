package Reiziger;

import Adres.Adres;
import OVChipkaart.OVChipkaart;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reiziger {
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    private Adres adres;
    private List<OVChipkaart> ovChipkaarten;

    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum, Adres adres) {
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.adres = null;
        this.ovChipkaarten = new ArrayList<>();
    }

    public Reiziger() {
        this.ovChipkaarten = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<OVChipkaart> getOvChipkaarten() {
        return ovChipkaarten;
    }

    public void setOvChipkaarten(List<OVChipkaart> ovChipkaarten) {
        this.ovChipkaarten = ovChipkaarten;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("  ID: ").append(id).append("\n")
                .append("  Voorletters: ").append(voorletters).append("\n")
                .append("  Tussenvoegsel: ").append(tussenvoegsel).append("\n")
                .append("  Achternaam: ").append(achternaam).append("\n")
                .append("  Geboortedatum: ").append(geboortedatum).append("\n");

        if (adres != null) {
            stringBuilder.append("  Adres: ID: ").append(adres.getId()).append("\n")
                    .append("    Straat: ").append(adres.getStraat()).append("\n")
                    .append("    Huisnummer: ").append(adres.getHuisnummer()).append("\n")
                    .append("    Postcode: ").append(adres.getPostCode()).append("\n")
                    .append("    Woonplaats: ").append(adres.getWoonplaats()).append("\n");
        } else {
            stringBuilder.append("  Adres: Geen adres\n");
        }

        stringBuilder.append("  OV-chipkaarten:").append("\n");

        if (!ovChipkaarten.isEmpty()) {
            for (OVChipkaart ovChipkaart : ovChipkaarten) {
                stringBuilder.append("    Kaartnummer: ").append(ovChipkaart.getKaartNummer()).append("\n")
                        .append("    Geldig tot: ").append(ovChipkaart.getGeldigTot()).append("\n")
                        .append("    Klasse: ").append(ovChipkaart.getKlasse()).append("\n")
                        .append("    Saldo: ").append(ovChipkaart.getSaldo()).append("\n");
            }
        } else {
            stringBuilder.append("    Geen OV-chipkaarten\n");
        }

        return stringBuilder.toString();
    }


}
