package com.stekodyne.domain;

import com.google.gson.Gson;

public class Message {

    private String stats;
    private long solution;

    public Message(long solution, String stats) {
        this.solution = solution;
        this.stats = stats;
    }

    public String getStats() {
        return stats;
    }

    public void setStats(String stats) {
        this.stats = stats;
    }

    public long getSolution() {
        return solution;
    }

    public void setSolution(int sum) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
