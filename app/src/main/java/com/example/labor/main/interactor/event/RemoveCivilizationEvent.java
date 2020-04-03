package com.example.labor.main.interactor.event;

import com.example.labor.main.model.Civilization;

import java.util.List;

public class RemoveCivilizationEvent {
    private int code;
    private int position;
    private Throwable throwable;

    public RemoveCivilizationEvent() {
    }

    public RemoveCivilizationEvent(int code, int position, Throwable throwable) {
        this.code = code;
        this.position = position;
        this.throwable = throwable;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public int getPosition() {
        return position;
    }

    public Throwable getThrowable() {
        return throwable;
    }
}
