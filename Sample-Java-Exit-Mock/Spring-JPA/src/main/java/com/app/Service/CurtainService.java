package com.app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Entity.Curtain;
import com.app.Repository.CurtainRepository;

import java.util.List;

@Service
public class CurtainService {

    @Autowired
    private CurtainRepository curtainRepository;

    public List<Curtain> getCurtainsByPrice(int price) {
        return curtainRepository.findByPriceGreaterThan(price);
    }

    public List<Curtain> getCurtainsByBrand(String brand) {
        return curtainRepository.findByBrand(brand);
    }
}