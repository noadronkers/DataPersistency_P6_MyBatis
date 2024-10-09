package OVChipkaart;

import Reiziger.Reiziger;
import Reiziger.ReizigerMapper;

import java.util.List;

public interface OVChipkaartMapper {
    boolean save(OVChipkaart ovChipkaart);

    boolean update(OVChipkaart ovChipkaart);

    boolean delete(OVChipkaart ovChipkaart);

    OVChipkaart findById(int id);

    List<OVChipkaart> findByReiziger(Reiziger reiziger);

    List<OVChipkaart> findAll();

    void setReizigerDAO(ReizigerMapper rdao);
}
