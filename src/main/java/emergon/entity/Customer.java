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

public class Customer implements Serializable {
    
    private Integer ccode;
    private String cname;

    public Customer() {
    }

    public Customer(Integer ccode) {
        this.ccode = ccode;
    }

    public Customer(Integer ccode, String cname) {
        this.ccode = ccode;
        this.cname = cname;
    }

    public Integer getCcode() {
        return ccode;
    }

    public void setCcode(Integer ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ccode != null ? ccode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.ccode == null && other.ccode != null) || (this.ccode != null && !this.ccode.equals(other.ccode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "emergon.entity.Customer[ ccode=" + ccode + " ]";
    }
    
}
