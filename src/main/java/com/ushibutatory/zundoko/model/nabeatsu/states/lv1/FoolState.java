package com.ushibutatory.zundoko.model.nabeatsu.states.lv1;

import com.ushibutatory.zundoko.model.nabeatsu.states.BaseState;
import com.ushibutatory.zundoko.model.nabeatsu.states.IState;
import com.ushibutatory.zundoko.utils.StringUtility;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

/**
 * アホ状態クラス
 */
public class FoolState extends BaseState {

    /**
     * 単位の区切り種別
     */
    private enum DigitPartType {
        Unknown,
        One,
        Ten,
        Hundred,
        Thousand,
    }

    /**
     * 単位の段階種別
     */
    private enum DigitScaleType {
        Unknown,
        一,
        万,
        億,
        兆,
        京,
        垓,
        抒,
        穣,
        溝,
        澗,
        正,
        載,
        極,
        恒河沙,
        阿僧祇,
        那由他,
        不可思議,
        無量大数,
    }

    @Override
    public boolean enabled() {
        return true;
    }

    @Override
    public boolean isApplied(BigInteger value) {
        return (value.mod(BigInteger.valueOf(3)).equals(BigInteger.valueOf(0))) || (value.toString().contains("3"));
    }

    @Override
    public String convert(BigInteger value) {
        StringBuilder text = new StringBuilder();

        // 全体で何桁か
        int digit = value.toString().length();

        // 小さい桁から4桁ごとに分割する
        for (String block : StringUtility.splitByLength(value.toString(), 4, StringUtility.SplitDirection.Back)) {
            if (Integer.parseInt(block) == 0) {
                // ブロックが0のみの場合は、何も出力しない
                digit -= block.length();
            } else {
                // 1文字ずつ変換
                for (Character c : block.toCharArray()) {
                    // 1桁分の数字を取得
                    int n = Integer.parseInt(c.toString());

                    // 数を変換
                    text.append(this.toFoolNumber(n, digit));

                    // 桁を変換
                    text.append(this.toFoolDigit(n, digit));

                    digit--;
                }
            }
        }

        return text.toString();
    }

    @Override
    protected List<IState> _createSubStateList() {
        return Arrays.asList();
    }

    /**
     * 数値をアホにします。
     *
     * @param number 元の数値
     * @param digit  桁数
     * @return アホな数値
     */
    private String toFoolNumber(int number, int digit) {
        String result = "";
        switch (digit) {
            case 1:
                // 1の位
                switch (number) {
                    case 0:
                        result = "";
                        break;
                    case 1:
                        result = "いち";
                        break;
                    case 2:
                        result = "にぃ";
                        break;
                    case 3:
                        result = "さぁん";
                        break;
                    case 4:
                        result = "よぉん";
                        break;
                    case 5:
                        result = "ごぉ";
                        break;
                    case 6:
                        result = "ろぉく";
                        break;
                    case 7:
                        result = "ななぁ";
                        break;
                    case 8:
                        result = "はぁち";
                        break;
                    case 9:
                        result = "きゅう";
                        break;
                }
            default:
                switch (number) {
                    case 0:
                        result = "";
                        break;
                    case 1:
                        switch (this.getDigitPart(digit)) {
                            case One:
                                switch (this.getDigitScale(digit)) {
                                    case 兆:
                                    case 京:
                                    case 澗:
                                    case 正:
                                    case 載:
                                        result = "いっ";
                                        break;
                                    default:
                                        result = "いち";
                                        break;
                                }
                                break;
                            default:
                                result = "";
                                break;
                        }
                        break;
                    case 2:
                        result = "に";
                        break;
                    case 3:
                        result = "さん";
                        break;
                    case 4:
                        result = "よん";
                        break;
                    case 5:
                        result = "ご";
                        break;
                    case 6:
                        switch (this.getDigitPart(digit)) {
                            case Hundred:
                                result = "ろっ";
                                break;
                            default:
                                result = "ろく";
                                break;
                        }
                        break;
                    case 7:
                        result = "なな";
                        break;
                    case 8:
                        switch (this.getDigitPart(digit)) {
                            case Hundred:
                            case Thousand:
                                result = "はっ";
                                break;
                            default:
                                result = "はち";
                                break;
                        }
                        break;
                    case 9:
                        result = "きゅう";
                        break;
                }
        }
        return result;
    }

    /**
     * 桁をアホにします。
     *
     * @param number 元の数値
     * @param digit  桁数
     * @return アホな桁
     */
    private String toFoolDigit(int number, int digit) {
        String result = "";
        switch (this.getDigitPart(digit)) {
            case One:
                switch (this.getDigitScale(digit)) {
                    case 万:
                        result = "まん";
                        break;
                    case 億:
                        result = "おく";
                        break;
                    case 兆:
                        result = "ちょー";
                        break;
                    case 京:
                        result = "けぇー";
                        break;
                    case 垓:
                        result = "がぃ";
                        break;
                    case 抒:
                        result = "じょぉ";
                        break;
                    case 穣:
                        result = "じょぅ";
                        break;
                    case 溝:
                        result = "こお";
                        break;
                    case 澗:
                        result = "かんん";
                        break;
                    case 正:
                        result = "せーぃ";
                        break;
                    case 載:
                        result = "さぁい";
                        break;
                    case 極:
                        result = "ごく";
                        break;
                    case 恒河沙:
                        result = "ごーがしゃー";
                        break;
                    case 阿僧祇:
                        result = "あそーぎぃ";
                        break;
                    case 那由他:
                        result = "なゆたぁ";
                        break;
                    case 不可思議:
                        result = "ふかしぎぃー";
                        break;
                    case 無量大数:
                        result = "むりょーたいすー";
                        break;
                    default:
                        break;
                }
                break;
            case Ten:
                switch (number) {
                    case 0:
                        break;
                    default:
                        switch (this.getDigitScale(digit)) {
                            case 兆:
                            case 京:
                            case 溝:
                            case 澗:
                            case 正:
                            case 載:
                                result = "じゅっ";
                                break;
                            default:
                                result = "じゅう";
                                break;
                        }
                        break;
                }
                break;
            case Hundred:
                switch (number) {
                    case 0:
                        break;
                    case 3:
                        result = "びゃく";
                        break;
                    case 6:
                    case 8:
                        result = "ぴゃく";
                        break;
                    default:
                        result = "ひゃく";
                        break;
                }
                break;
            case Thousand:
                switch (number) {
                    case 0:
                        break;
                    case 3:
                        result = "ぜん";
                        break;
                    default:
                        result = "せん";
                        break;
                }
                break;
            case Unknown:
                break;
        }
        return result;
    }

    /**
     * 単位の区切り種別を取得します。
     *
     * @param digit 単位
     * @return 単位区切り種別
     */
    private DigitPartType getDigitPart(int digit) {
        DigitPartType value;
        switch (digit % 4) {
            case 1:
                value = DigitPartType.One;
                break;
            case 2:
                value = DigitPartType.Ten;
                break;
            case 3:
                value = DigitPartType.Hundred;
                break;
            case 0:
                value = DigitPartType.Thousand;
                break;
            default:
                value = DigitPartType.Unknown;
                break;
        }
        return value;
    }

    /**
     * 単位の段階種別を取得します。
     *
     * @param digit 単位
     * @return 単位の段階種別
     */
    private DigitScaleType getDigitScale(int digit) {
        DigitScaleType value;
        switch (digit / 4) {
            case 0:
                value = DigitScaleType.一;
                break;
            case 1:
                value = DigitScaleType.万;
                break;
            case 2:
                value = DigitScaleType.億;
                break;
            case 3:
                value = DigitScaleType.兆;
                break;
            case 4:
                value = DigitScaleType.京;
                break;
            case 5:
                value = DigitScaleType.垓;
                break;
            case 6:
                value = DigitScaleType.抒;
                break;
            case 7:
                value = DigitScaleType.穣;
                break;
            case 8:
                value = DigitScaleType.溝;
                break;
            case 9:
                value = DigitScaleType.澗;
                break;
            case 10:
                value = DigitScaleType.正;
                break;
            case 11:
                value = DigitScaleType.載;
                break;
            case 12:
                value = DigitScaleType.極;
                break;
            case 13:
                value = DigitScaleType.恒河沙;
                break;
            case 14:
                value = DigitScaleType.阿僧祇;
                break;
            case 15:
                value = DigitScaleType.那由他;
                break;
            case 16:
                value = DigitScaleType.不可思議;
                break;
            case 17:
                value = DigitScaleType.無量大数;
                break;
            default:
                value = DigitScaleType.Unknown;
                break;
        }
        return value;
    }
}
