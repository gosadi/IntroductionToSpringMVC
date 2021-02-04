/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.entity;

import java.io.Serializable;


/**
 *
 * @author alkinoos
 */

public class Product implements Serializable {

    
    private Integer pcode;
    private String pdescr;
    private double pprice;

    public Product() {
    }

    public Product(Integer pcode) {
        this.pcode = pcode;
    }

    public Product(Integer pcode, String pdescr) {
        this.pcode = pcode;
        this.pdescr = pdescr;
    }
    
    public Product(Integer pcode, String pdescr, double pprice){
        this.pcode = pcode;
        this.pdescr = pdescr;
        this.pprice = pprice;
    }

    public Integer getPcode() {
        return pcode;
    }

    public void setPcode(Integer pcode) {
        this.pcode = pcode;
    }

    public String getPdescr() {
        return pdescr;
    }

    public void setPdescr(String pdescr) {
        this.pdescr = pdescr;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pcode != null ? pcode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.pcode == null && other.pcode != null) || (this.pcode != null && !this.pcode.equals(other.pcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Product[ pcode=" + pcode + " ]";
    }
    
}
