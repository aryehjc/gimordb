package com.database.spring.datajpa.model;

import javax.persistence.*;

@Entity
@Table(name = "glycans")
public class Glycan {

		
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "databaseid")
    private String databaseid; 
    @Column(name = "oxford")
    private String oxford;
    @Column(name = "neutralmass")
    private String neutralmass;
    @Column(name = "subdir")
    private String subdir;
    @Column(name = "experimentdetails")
    private String experimentdetails;

    public Glycan() {

    }

    public Glycan(String databaseid, String oxford, String neutralmass, String subdir, String experimentdetails) {
        this.databaseid = databaseid;
        this.oxford = oxford;
        this.neutralmass = neutralmass;
        this.subdir = subdir;
        this.experimentdetails = experimentdetails;
    }

/**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the databaseID
     */

    
    public String getDatabaseid() {
        return databaseid;
    }

    /**
     * @param databaseid the databaseID to set
     */
    public void setDatabaseid(String d) {
        this.databaseid = d;
    }

    /**
     * @return the oxford
     */
    public String getOxford() {
        return oxford;
    }

    /**
     * @param oxford the oxford to set
     */
    public void setOxford(String oxford) {
        this.oxford = oxford;
    }

    /**
     * @return the neutralmass
     */
    public String getNeutralmass() {
        return neutralmass;
    }

    /**
     * @param neutralmass the neutralmass to set
     */
    public void setNeutralmass(String neutralmass) {
        this.neutralmass = neutralmass;
    }

    /**
     * @return the subdir
     */
    public String getSubdir() {
        return subdir;
    }

    /**
     * @param subdir the observedmz to set
     */
    public void setSubdir(String s) {
        this.subdir = s;
    }

    /**
     * @return the experimentdetails
     */
    public String getExperimentdetails() {
        return this.experimentdetails; 
    }

    
    /**
     * @param ccs1 the experimentdetails to set
     */
    public void setExperimentdetails(String e) {
        this.experimentdetails = e;
    }


    @Override
    public String toString() {
        return "Glycan [id=" + id + ", databaseid=" + databaseid + ", oxford=" + oxford + ", neutralMass=" + neutralmass + ", subdir=" + subdir + ", experimentdetails=" + experimentdetails + "]";
    }

}
