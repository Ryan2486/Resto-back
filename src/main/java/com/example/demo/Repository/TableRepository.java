package com.example.demo.Repository;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.TableModel;

@Repository
public interface TableRepository extends JpaRepository<TableModel, String> {

  @Query("SELECT m.idtable FROM TableModel m WHERE m.idtable NOT IN (SELECT r.table.idtable FROM ReserverModel r WHERE DATE(r.dateReserve) = DATE(:date) AND ((r.timeFin <= :time AND r.timeFin > :time) OR (r.time >= :time AND r.time < :timefin)))")
  List<String> findAvailableTablesByDateAndTime(@Param("date") Date date,
      @Param("time") Time time,
      @Param("timefin") Time timefin);

}
