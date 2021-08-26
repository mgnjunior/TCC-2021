package com.consultorio.management.entity.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class RecordsRequest implements Records {

    private Long medicId;
    private Long patientId;

    private int age;
    private Long height;
    private Long weight;

    //Pathologies

    private Boolean hypertension;
    private Boolean diabetes;
    private Boolean hypothyroidism;
    private Boolean hyperthyroidism;
    private Boolean renal;
    private Boolean cardiac;
    private Boolean cancer;
    private Boolean osteoporosis;
    private Boolean gastritis;
    private Boolean asthma;
    private Boolean bronchitis;
    private Boolean rhinitis;
    private Boolean circulatory;

    //mental ilnesess

    private Boolean anxiety;
    private Boolean depression;
    private Boolean irritability;

    //Medications
    private String periodic_Medications;
    private Boolean controlledDrugs;
    private String controlledDrugsDescription;


    //Allergy
    private Boolean allergyDrugs;
    private String allergyDrugsDescription;
    private Boolean allergyIntolerance;
    private String allergyIntoleranceDescription;

    //Drugs
    private Boolean alcohol;
    private Boolean smoking;

    //physical activity
    private Boolean physicalActivity;
    private String medicalReport;
}
