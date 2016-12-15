package com.ushibutatory.zundoko.model.songs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ultra soul / B'z
 */
public class Ultrasoul extends AbstractSong {

    @Override
    public String getName() {
        return "ultra soul";
    }

    @Override
    protected List<String> _createUsingPhrases() {
        return new ArrayList<>(Arrays.asList("ウ", "ル", "ト", "ラ", "ソ"));
    }

    @Override
    protected List<Integer> _createCompletePhraseIndexes() {
        return new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 0, 1));
    }

    @Override
    protected String _createShoutPhrase() {
        return "＼ハァイ！／";
    }
}
