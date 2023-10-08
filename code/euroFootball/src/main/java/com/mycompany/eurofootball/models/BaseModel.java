/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;

import java.util.Objects;

/**
 *
 * @author calmin
 * @param <T>
 */
public abstract class BaseModel<T extends BaseModel<T>> {
    private Long universalIdentifier;

    public Long getUniversalIdentifier() {
        return universalIdentifier;
    }

    public void setUniversalIdentifier(Long uid) {
        this.universalIdentifier = uid;
    }
    
    public abstract T deepClone();

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BaseModel<?> other = (BaseModel<?>) obj;
        return Objects.equals(this.universalIdentifier, other.universalIdentifier);
    }
    
    
}
