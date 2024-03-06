package org.shah.springapp.ems.Repository;

import org.shah.springapp.ems.Domains.Demand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandRepository extends JpaRepository<Demand,Long> {
//    List<Demand> filterDemands();
}
