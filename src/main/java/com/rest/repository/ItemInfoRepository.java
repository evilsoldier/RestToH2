package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.velocity.ItemInfo;

@Repository("itemInfoRepository")
public interface ItemInfoRepository extends JpaRepository<ItemInfo, Long>{

}
