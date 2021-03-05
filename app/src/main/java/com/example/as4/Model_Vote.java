package com.example.as4;

public class Model_Vote {
    private int voter;
    private String candidate;
    private String Voter_name;

    public Model_Vote(int voter, String candidate, String voter_name) {
        this.voter = voter;
        this.candidate = candidate;
        Voter_name = voter_name;
    }

    public int getVoter() {
        return voter;
    }

    public void setVoter(int voter) {
        this.voter = voter;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public String getVoter_name() {
        return Voter_name;
    }

    public void setVoter_name(String voter_name) {
        Voter_name = voter_name;
    }
}
