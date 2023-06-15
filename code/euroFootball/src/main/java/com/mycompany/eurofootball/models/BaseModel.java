/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eurofootball.models;

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
}
