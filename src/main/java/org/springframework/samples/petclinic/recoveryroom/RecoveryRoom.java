package org.springframework.samples.petclinic.recoveryroom;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class RecoveryRoom {

    @Id
    Integer id;

    @Size(min = 3, max = 550)
    String name;

    @PositiveOrZero
    double size;

    boolean secure;
    
    @Transient
    RecoveryRoomType roomType;
}
