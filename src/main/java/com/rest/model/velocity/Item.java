package com.rest.model.velocity;

import java.io.Serializable;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item implements Serializable {

    @Id
    private String itemId;
    private HashSet<Efc> efcs;

    public Item() {
        super();
    }

    public Item(String itemId, HashSet<Efc> efcs) {
        super();
        this.itemId = itemId;
        this.efcs = efcs;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public HashSet<Efc> getEfcs() {
        return efcs;
    }

    public void setEfcs(HashSet<Efc> efcs) {
        this.efcs = efcs;
    }
}
