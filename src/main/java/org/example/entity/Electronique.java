package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder

public class Electronique extends Article{

    @Column(name = "Durée_Batterie")
    private int dureeBaterie;

}
