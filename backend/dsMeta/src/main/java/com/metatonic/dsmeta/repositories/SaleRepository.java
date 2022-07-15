package com.metatonic.dsmeta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metatonic.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
