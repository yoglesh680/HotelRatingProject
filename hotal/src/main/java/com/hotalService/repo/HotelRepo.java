package com.hotalService.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotalService.entity.Hotel;

@Repository
public interface HotelRepo  extends JpaRepository<Hotel,String>{

}
