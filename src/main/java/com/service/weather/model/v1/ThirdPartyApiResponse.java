package com.service.weather.model.v1;

import java.util.List;

public class ThirdPartyApiResponse {
    private ThirdPartyAPICoord coord;
    private List<ThirdPartyApiWeather> weather;
    private String base;
    private ThirdPartyApiMain main;
    private int visibility;
    private ThirdPartyApiWind wind;
    private ThirdPartyApiClouds clouds;
    private int dt;
    private ThirdPartyApiSys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public ThirdPartyApiResponse() {
        super();
    }

    public ThirdPartyAPICoord getCoord() {
        return coord;
    }

    public void setCoord(ThirdPartyAPICoord coord) {
        this.coord = coord;
    }

    public List<ThirdPartyApiWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<ThirdPartyApiWeather> weather) {
        this.weather = weather;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public ThirdPartyApiMain getMain() {
        return main;
    }

    public void setMain(ThirdPartyApiMain main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public ThirdPartyApiWind getWind() {
        return wind;
    }

    public void setWind(ThirdPartyApiWind wind) {
        this.wind = wind;
    }

    public ThirdPartyApiClouds getClouds() {
        return clouds;
    }

    public void setClouds(ThirdPartyApiClouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public ThirdPartyApiSys getSys() {
        return sys;
    }

    public void setSys(ThirdPartyApiSys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
