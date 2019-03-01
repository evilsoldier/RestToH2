package com.rest.repository;

import com.rest.model.velocity.ItemInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemInfoRepository")
public interface ItemInfoRepository extends JpaRepository<ItemInfo, Long> {
}
