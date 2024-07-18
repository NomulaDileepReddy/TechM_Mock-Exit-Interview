package com.app.Repository;

import com.app.Entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer> {
    Optional<Shipment> findByTrackNo(String trackNo);
}
