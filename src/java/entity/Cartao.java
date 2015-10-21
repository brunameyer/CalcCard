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

    public Integer getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(Integer idCartao) {
        this.idCartao = idCartao;
    }

    public Float getTaxaDebito() {
        return taxaDebito;
    }

    public void setTaxaDebito(Float taxaDebito) {
        this.taxaDebito = taxaDebito;
    }

    public Float getTaxaCredito() {
        return taxaCredito;
    }

    public void setTaxaCredito(Float taxaCredito) {
        this.taxaCredito = taxaCredito;
    }
 
    
}
