package com.stekodyne.domain;

import com.google.gson.Gson;

public class Message {
    private String stats;
	private int solution;
	
    public Message(Integer solution, String stats) {
		this.solution = solution;
		this.stats = stats;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public int getSolution() {
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
