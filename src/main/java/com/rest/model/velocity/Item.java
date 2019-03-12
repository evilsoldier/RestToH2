package com.rest.model.velocity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.HashSet;

@Entity
public class Item implements Serializable {

    @Id
    private Long itemId;
    private HashSet<Efc> efcs;

    public Item() {
        super();
    }

    public Item(Long itemId, HashSet<Efc> efcs) {
        super();
        this.itemId = itemId;
        this.efcs = efcs;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public HashSet<Efc> getEfcs() {
        return efcs;
    }

    public void setEfcs(HashSet<Efc> efcs) {
        this.efcs = efcs;
    }
}
