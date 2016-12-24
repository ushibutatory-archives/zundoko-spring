package com.ushibutatory.zundoko.model.zundoko.songs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ソーラン節
 */
public class SoranBushi extends AbstractSong {

    @Override
    public String getName() {
        return "ソーラン節";
    }

    @Override
    protected List<String> _createUsingPhrases() {
        return new ArrayList<>(Arrays.asList("ヤーレン", "ソーラン"));
    }

    @Override
    protected List<Integer> _createCompletePhraseIndexes() {
        return new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1, 1));
    }

    @Override
    protected String _createShoutPhrase() {
        return "＼ハイ！　ハイ！／";
    }
}
