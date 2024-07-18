package com.app.Service;

import com.app.Entity.Shipment;
import com.app.Repository.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShipmentService {

    @Autowired
    private ShipmentRepository shipmentRepository;

    public Optional<Shipment> getShipmentByTrackNo(String trackNo) {
        return shipmentRepository.findByTrackNo(trackNo);
    }
    
    public Shipment createShipment(Shipment shipment) {
        return shipmentRepository.save(shipment);
    }

    public boolean deleteShipmentById(Integer shipId) {
        if (shipmentRepository.existsById(shipId)) {
            shipmentRepository.deleteById(shipId);
            return true;
        }
        return false;
    }
}
