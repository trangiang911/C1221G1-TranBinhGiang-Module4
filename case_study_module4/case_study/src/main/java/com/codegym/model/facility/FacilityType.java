package com.codegym.model.facility;

import javax.persistence.*;

@Entity
@Table(name = "facility_type")
public class FacilityType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
}
