package com.example.labor.main.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "civilizations")
public class Civilization {

    @SerializedName("id")
    @Expose
    @PrimaryKey(autoGenerate = true)
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

    @SerializedName("team_bonus")
    @Expose
    private String team_bonus;

    @SerializedName("civilization_bonus")
    @Expose
    private ArrayList<String> civilization_bonus = new ArrayList<String>();

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

    public String getTeam_bonus() {
        return team_bonus;
    }

    public ArrayList<String> getCivilization_bonus() {
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

    public void setTeam_bonus(String team_bonus) {
        this.team_bonus = team_bonus;
    }

    public void setCivilization_bonus(ArrayList<String> civilization_bonus) {
        this.civilization_bonus = civilization_bonus;
    }
}