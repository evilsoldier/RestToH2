package com.rest.repository;

import com.rest.model.velocity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("itemRepository")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
