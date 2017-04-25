package com.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.velocity.Item;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long>{

}
