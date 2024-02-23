package com.example.demo.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "domicilios")
public class DomiciliosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long iddomicilio;

    @Column(name = "calle")
    private String calle;

    @Column(name = "numero")
    private String numero;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "estado")
    private String estado;

    @Column(name = "municipio")
    private String municipio;

    @Column(name = "ciudadano")
    private String ciudadano;
}
