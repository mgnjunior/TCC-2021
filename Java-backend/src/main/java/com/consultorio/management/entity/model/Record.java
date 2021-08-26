package com.consultorio.management.entity.model;

import lombok.*;
import org.hibernate.engine.internal.Cascade;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "record")
public class Record {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medic_id", referencedColumnName = "id")
    private Medic medic;

    @Column(name = "age")
    private int age;

    @Column(name = "height")
    private Long height;

    @Column(name = "weight")
    private Long weight;

    //Pathologies
    @Column(name = "hypertension")
    private Boolean hypertension;

    @Column(name = "diabetes")
    private Boolean diabetes;

    @Column(name = "hypothyroidism")
    private Boolean hypothyroidism;

    @Column(name = "hyperthyroidism")
    private Boolean hyperthyroidism;

    @Column(name = "renal")
    private Boolean renal;

    @Column(name = "cardiac")
    private Boolean cardiac;

    @Column(name = "cancer")
    private Boolean cancer;

    @Column(name = "osteoporosis")
    private Boolean osteoporosis;

    @Column(name = "gastritis")
    private Boolean gastritis;

    @Column(name = "asthma")
    private Boolean asthma;

    @Column(name = "bronchitis")
    private Boolean bronchitis;

    @Column(name = "rhinitis")
    private Boolean rhinitis;

    @Column(name = "circulatory")
    private Boolean circulatory;

    //mental ilnesess

    @Column(name = "anxiety")
    private Boolean anxiety;

    @Column(name = "depression")
    private Boolean depression;

    @Column(name = "irritability")
    private Boolean irritability;

    //Medications
    @Column(name = "periodic_Medications")
    private String periodic_Medications;

    @Column(name = "controlledDrugs")
    private Boolean controlledDrugs;

    @Column(name = "controlledDrugsDescription")
    private String controlledDrugsDescription;


    //Allergy

    @Column(name = "allergyDrugs")
    private Boolean allergyDrugs;

    @Column(name = "allergyDrugsDescription")
    private String allergyDrugsDescription;

    @Column(name = "allergyIntolerance")
    private Boolean allergyIntolerance;

    @Column(name = "allergyIntoleranceDescription")
    private String allergyIntoleranceDescription;

    //Drugs

    @Column(name = "alcohol")
    private Boolean alcohol;

    @Column(name = "smoking")
    private Boolean smoking;

    //physical activity

    @Column(name = "physicalActivity")
    private Boolean physicalActivity;

    @Column(name = "medicalReport")
    private String medicalReport;

}

