package com.example.abhik.part1_abhiksarkar;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by abhik on 07/02/18.
 */

public class Main2 {
    public ArrayList<Country> getWorldpopulation() {
        return worldpopulation;
    }

    public void setWorldpopulation(ArrayList<Country> worldpopulation) {
        this.worldpopulation = worldpopulation;
    }

    @SerializedName("worldpopulation")
    private ArrayList<Country>  worldpopulation = new ArrayList<>();

    public class Country {
        @SerializedName("rank")
        private int rank;

        @SerializedName("country")
        private  String country;

        @SerializedName("population")
        private String population;

        @SerializedName("flag")
        private String flag;

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getPopulation() {
            return population;
        }

        public void setPopulation(String population) {
            this.population = population;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }
    }
}
