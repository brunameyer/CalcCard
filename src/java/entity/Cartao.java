/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author brunameyer
 */
@Entity
public class Cartao implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    
    private Integer idCartao;
    private Float taxaDebito;
    private Float taxaCredito;
    //private Bandeira bandeira;

    //public Bandeira getBandeira() {
     ///   return bandeira;
   // }

    //public void setBandeira(Bandeira bandeira) {
    //    this.bandeira = bandeira;
    //}

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public float getTaxaDebito() {
        return taxaDebito;
    }

    public void setTaxaDebito(float taxaDebito) {
        this.taxaDebito = taxaDebito;
    }

    public float getTaxaCredito() {
        return taxaCredito;
    }

    public void setTaxaCredito(float taxaCredito) {
        this.taxaCredito = taxaCredito;
    }
    
    
}
