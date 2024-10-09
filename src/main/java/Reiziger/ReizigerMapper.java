package Reiziger;

import java.sql.Date;
import java.util.List;

public interface ReizigerMapper {

    boolean save(Reiziger reiziger);

    boolean update(Reiziger reiziger);

    boolean delete(Reiziger reiziger);

    Reiziger findById(int id);

    List<Reiziger> findByGbdatum(Date date);

    List<Reiziger> findAll();
}
