package com.ushibutatory.zundoko.model.songs;

import com.ushibutatory.zundoko.model.ISong;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 基底歌クラス
 */
public abstract class AbstractSong implements ISong {

    private List<String> _usingPhrases;
    private List<String> _completePhrases;
    private String _shout;

    /**
     * クラス名を取得します。
     * @return クラス名
     */
    @Override
    public String getClassName() {
        return this.getClass().getSimpleName();
    }

    /**
     * 歌の名前を取得します。
     *
     * @return 歌名
     */
    public abstract String getName();

    /**
     * 使用フレーズリストを取得します。
     *
     * @return 使用フレーズリスト
     */
    @Override
    public List<String> getUsingPhrases() {
        if (this._usingPhrases == null) {
            // 初回生成
            this._usingPhrases = this._createUsingPhrases();
        }
        return this._usingPhrases;
    }

    /**
     * 完成フレーズリストを取得します。
     *
     * @return 完成フレーズリスト
     */
    @Override
    public List<String> getCompletePhrases() {
        if (this._completePhrases == null) {
            this._completePhrases = this._createCompletePhraseIndexes()
                    .stream()
                    .map(i -> this.getUsingPhrases().get(i))
                    .collect(Collectors.toList());
        }
        return this._completePhrases;
    }

    /**
     * 完成フレーズ数を取得します。
     *
     * @return 完成フレーズ数
     */
    @Override
    public Integer getCompletePhraseCount() {
        return this._completePhrases.size();
    }

    /**
     * 決め台詞を取得します。
     *
     * @return 決め台詞
     */
    @Override
    public String getShoutPhrase() {
        if (this._shout == null) {
            this._shout = this._createShoutPhrase();
        }
        return this._shout;
    }

    /**
     * フレーズが完成しているかどうかを取得します。
     *
     * @param phrases フレーズリスト
     * @return 完成しているかどうか
     */
    @Override
    public Boolean isCompleted(List<String> phrases) {
        // 区切り文字
        String separator = System.lineSeparator();

        // 直近のフレーズを抽出
        List<String> lastPhrases;
        if (phrases.size() <= this.getCompletePhrases().size()) {
            lastPhrases = phrases;
        } else {
            lastPhrases = phrases.subList(phrases.size() - this.getCompletePhrases().size(), phrases.size());
        }

        // 結合して一致するかどうかを返す
        String input = String.join(separator, lastPhrases);
        String answer = String.join(separator, this.getCompletePhrases());
        return input.equals(answer);
    }

    /**
     * 使用フレーズリストを生成します。
     *
     * @return 使用フレーズリスト
     */
    protected abstract List<String> _createUsingPhrases();

    /**
     * 完成フレーズのインデックスリストを生成します。
     *
     * @return 完成フレーズのインデックスリスト
     */
    protected abstract List<Integer> _createCompletePhraseIndexes();

    /**
     * 決め台詞を生成します。
     *
     * @return 決め台詞
     */
    protected abstract String _createShoutPhrase();
}
