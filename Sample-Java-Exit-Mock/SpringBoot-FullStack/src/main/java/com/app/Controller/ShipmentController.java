package com.app.Controller;

import com.app.Entity.Shipment;
import com.app.Service.ShipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipment")
public class ShipmentController {

    @Autowired
    private ShipmentService shipmentService;

    @GetMapping("/{trackNo}")
    public ResponseEntity<Shipment> getShipmentByTrackNo(@PathVariable String trackNo) {
        Optional<Shipment> shipment = shipmentService.getShipmentByTrackNo(trackNo);
        return shipment.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.status(404).build());
    }
    
    @PostMapping("/create")
    public ResponseEntity<Shipment> createShipment(@RequestBody Shipment shipment) {
        Shipment createdShipment = shipmentService.createShipment(shipment);
        return ResponseEntity.status(201).body(createdShipment);
    }

    @DeleteMapping("/{shipId}")
    public ResponseEntity<String> deleteShipmentById(@PathVariable Integer shipId) {
        boolean isDeleted = shipmentService.deleteShipmentById(shipId);
        if (isDeleted) {
            return ResponseEntity.ok("The requested shipId-" + shipId + " got deleted");
        } else {
            return ResponseEntity.status(404).body("Shipment with shipId-" + shipId + " not found");
        }
    }
}
