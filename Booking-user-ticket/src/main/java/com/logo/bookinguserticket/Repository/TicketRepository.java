package com.logo.bookinguserticket.Repository;

import com.logo.bookinguserticket.Model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("select t from Ticket t where t.userId=:userId")
    public List<Ticket> findByUserid(@Param("userId") String userId);

//    @Query("select f.totalfare from Ticket f")
//    public List<Integer> findFlightFares();

}
