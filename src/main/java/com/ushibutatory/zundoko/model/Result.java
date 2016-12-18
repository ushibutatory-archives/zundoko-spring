package com.ushibutatory.zundoko.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 結果クラス
 */
@Data
public class Result {

    private int count;

    private List<String> results;

    public Result() {
        this.results = new ArrayList<>();
    }

    public void addPhrase(String phrase) {
        this.results.add(phrase);
    }

    public String phrases() {
        return String.join("", this.results);
    }

}
