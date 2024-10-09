package Adres;

import Reiziger.Reiziger;

import java.util.List;

public interface AdresMapper {
    boolean save(Adres adres);
    boolean update(Adres adres);
    boolean delete(Adres adres);
    List<Adres> findByReiziger(Reiziger reiziger);
    Adres findById(int id);
    List<Adres> findAll();
}