package com.consultorio.management.entity.model;

import com.consultorio.management.entity.dto.MedicUpdateRequest;
import com.sun.istack.NotNull;
import lombok.*;
import org.apache.coyote.Request;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "medic")
public class Medic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "crm")
    private Long crm;

    public void refreshValues (MedicUpdateRequest request) {
        this.crm = request.getCrm();
        this.firstName = request.getFirstName();
        this.secondName = request.getSecondName();
        this.email = request.getEmail();
    }


}
