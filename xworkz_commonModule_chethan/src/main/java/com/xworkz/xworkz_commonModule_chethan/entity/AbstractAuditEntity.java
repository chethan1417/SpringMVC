package com.xworkz.xworkz_commonModule_chethan.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
@NoArgsConstructor
public class AbstractAuditEntity implements Serializable {

    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdDate=LocalDateTime.now();
    private LocalDateTime updatedDate=LocalDateTime.now();

}
