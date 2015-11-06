package com.stekodyne.domain;

import com.google.gson.Gson;

public class Message {
    private String stats;
	private int sum;
	
    public Message(Integer sum, String stats) {
		this.sum = sum;
		this.stats = stats;
	}

	public String getStats() {
		return stats;
	}

	public void setStats(String stats) {
		this.stats = stats;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
