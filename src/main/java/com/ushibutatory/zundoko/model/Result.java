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

    private List<String> resultPhraseList;

    public Result() {
        this.resultPhraseList = new ArrayList<>();
    }

    public void addPhrase(String phrase) {
        this.resultPhraseList.add(phrase);
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String phrases() {
        return String.join("", this.resultPhraseList);
    }

}
