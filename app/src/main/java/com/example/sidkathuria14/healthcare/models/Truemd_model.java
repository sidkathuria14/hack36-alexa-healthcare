package com.example.sidkathuria14.healthcare.models;

import java.util.ArrayList;

/**
 * Created by sidkathuria14 on 5/2/18.
 */

public class Truemd_model {
    String application;
    ArrayList<Suggestion> suggestions;

    public String getApplication() {
        return application;
    }

    public ArrayList<Suggestion> getSuggestions() {
        return suggestions;
    }

    public Truemd_model(String application, ArrayList<Suggestion> suggestions) {
        this.application = application;
        this.suggestions = suggestions;
    }

}
