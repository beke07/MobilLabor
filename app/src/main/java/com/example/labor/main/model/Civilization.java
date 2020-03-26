package com.example.labor.main.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Civilization {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("expansion")
    @Expose
    private String expansion;

    @SerializedName("army_type")
    @Expose
    private String army_type;

    @SerializedName("unique_unit")
    @Expose
    private List<String> unique_unit = new ArrayList<String>();

    @SerializedName("unique_tech")
    @Expose
    private List<String> unique_tech = new ArrayList<String>();

    @SerializedName("team_bonus")
    @Expose
    private String team_bonus;

    @SerializedName("civilization_bonus")
    @Expose
    private List<String> civilization_bonus = new ArrayList<String>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpansion() {
        return expansion;
    }

    public String getArmy_type() {
        return army_type;
    }

    public List<String> getUnique_unit() {
        return unique_unit;
    }

    public List<String> getUnique_tech() {
        return unique_tech;
    }

    public String getTeam_bonus() {
        return team_bonus;
    }

    public List<String> getCivilization_bonus() {
        return civilization_bonus;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpansion(String expansion) {
        this.expansion = expansion;
    }

    public void setArmy_type(String army_type) {
        this.army_type = army_type;
    }

    public void setUnique_unit(List<String> unique_unit) {
        this.unique_unit = unique_unit;
    }

    public void setUnique_tech(List<String> unique_tech) {
        this.unique_tech = unique_tech;
    }

    public void setTeam_bonus(String team_bonus) {
        this.team_bonus = team_bonus;
    }

    public void setCivilization_bonus(List<String> civilization_bonus) {
        this.civilization_bonus = civilization_bonus;
    }
}