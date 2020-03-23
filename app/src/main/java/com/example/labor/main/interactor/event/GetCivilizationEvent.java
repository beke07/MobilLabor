package com.example.labor.main.interactor.event;

import com.example.labor.main.model.Civilization;

import java.util.List;

public class GetCivilizationEvent {
    private int code;
    private List<Civilization> civilizations;
    private Throwable throwable;

    public GetCivilizationEvent() {
    }

    public GetCivilizationEvent(int code, List<Civilization> civilizations, Throwable throwable) {
        this.code = code;
        this.civilizations = civilizations;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public List<Civilization> getCivilizations() {
        return civilizations;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCivilizations(List<Civilization> civilizations) {
        this.civilizations = civilizations;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
