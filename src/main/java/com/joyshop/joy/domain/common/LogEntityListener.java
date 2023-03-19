package com.joyshop.joy.domain.common;

import jakarta.persistence.*;
import org.springframework.data.domain.Auditable;

import java.time.LocalDateTime;
import java.util.Optional;

public class LogEntityListener {

    @PrePersist
    public void prePersist(Object entity) {
        System.out.println("[" + entity.getClass().getSimpleName() + "] is about to be persisted...");
    }

    @PostPersist
    public void postPersist(Object entity) {
        if(entity instanceof BaseEntity){
            BaseEntity baseEntity = (BaseEntity) entity;
            LocalDateTime createdAt = baseEntity.getCreatedAt();
            LocalDateTime updatedAt = baseEntity.getUpdatedAt();
            System.out.println("created at : "+ createdAt);
            System.out.println("updated at : " + updatedAt);

        }
        System.out.println("[" + entity.getClass().getSimpleName() + "] has been persisted.");
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        System.out.println("[" + entity.getClass().getSimpleName() + "] is about to be updated...");
    }

    @PostUpdate
    public void postUpdate(Object entity) {
        System.out.println("[" + entity.getClass().getSimpleName() + "] has been updated.");
    }

    @PreRemove
    public void preRemove(Object entity) {
        System.out.println("[" + entity.getClass().getSimpleName() + "] is about to be removed...");
    }

    @PostRemove
    public void postRemove(Object entity) {
        System.out.println("[" + entity.getClass().getSimpleName() + "] has been removed.");
    }
}

