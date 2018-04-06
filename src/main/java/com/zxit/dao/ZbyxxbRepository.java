package com.zxit.dao;

import com.zxit.model.Zbyxxb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZbyxxbRepository extends JpaRepository<Zbyxxb,String> {
    Zbyxxb findZbyxxbByIdAndMm(String id, String mm);
}