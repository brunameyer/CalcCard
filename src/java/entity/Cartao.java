/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author brunameyer
 */
public class Cartao {
    
    private Integer idCartao;
    private float taxaDebito;
    private float taxaCredito;
    private Bandeira bandeira;

    public Bandeira getBandeira() {
        return bandeira;
    }

    public void setBandeira(Bandeira bandeira) {
        this.bandeira = bandeira;
    }

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
