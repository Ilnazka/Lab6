package com.example.lab6;

public class State {

    private String name; // название

    private int flagResource; // ресурс флага

    public State(String name, String capital, int flag){

        this.name=name;

        this.flagResource=flag;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}
