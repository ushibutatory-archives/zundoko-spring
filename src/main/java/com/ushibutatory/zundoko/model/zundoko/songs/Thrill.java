package com.ushibutatory.zundoko.model.zundoko.songs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Thrill / 布袋寅泰
 */
public class Thrill extends AbstractSong {

    @Override
    public String getName() {
        return "Thrill";
    }

    @Override
    protected List<String> _createUsingPhrases() {
        return new ArrayList<>(Arrays.asList("ベビ", "ベイビ", "ベイベー"));
    }

    @Override
    protected List<Integer> _createCompletePhraseIndexes() {
        return new ArrayList<>(Arrays.asList(0, 0, 1, 1, 1, 1, 2));
    }

    @Override
    protected String _createShoutPhrase() {
        return "俺のすべては　おまえのものさ";
    }
}
