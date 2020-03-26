package com.example.labor.main.interactor.event;

import com.example.labor.main.model.Civilization;

import java.util.List;

public class CreateCivilizationEvent {
    private int code;
    private Civilization civilization;
    private Throwable throwable;

    public CreateCivilizationEvent() {
    }

    public CreateCivilizationEvent(int code, Civilization civilization, Throwable throwable) {
        this.code = code;
        this.civilization = civilization;
        this.throwable = throwable;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCivilization(Civilization civilization) {
        this.civilization = civilization;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public Civilization getCivilization() {
        return civilization;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
