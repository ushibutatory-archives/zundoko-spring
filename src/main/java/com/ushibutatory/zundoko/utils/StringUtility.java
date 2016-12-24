package com.ushibutatory.zundoko.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 文字列操作ユーティリティ
 */
public final class StringUtility {

    /**
     * 文字列を分割する方向
     */
    public enum SplitDirection {
        /**
         * 文字列の先頭から数える
         */
        Forward,
        /**
         * 文字列の後ろから数える
         */
        Back,
    }

    /**
     * 文字列を指定した長さで分割します。
     *
     * @param text   分割する文字列
     * @param length 分割する長さ
     * @return 分割した文字列リスト
     */
    public static List<String> splitByLength(String text, int length) {
        return splitByLength(text, length, SplitDirection.Forward);
    }

    /**
     * 文字列を指定した長さで分割します。
     *
     * @param text      分割する文字列
     * @param length    分割する長さ
     * @param direction 分割する方向
     * @return 分割した文字列リスト
     */
    public static List<String> splitByLength(String text, int length, SplitDirection direction) {
        List<String> result = new ArrayList<>();

        StringBuilder block = new StringBuilder();

        switch (direction) {
            case Forward:
                // 前から数える
                for (int i = 0; i < text.length(); i++) {
                    block.append(text.charAt(i));
                    if (block.length() >= length) {
                        result.add(block.toString());
                        block.delete(0, block.length());
                    }
                }
                if (block.length() > 0) {
                    // 残りがあれば最後に追加
                    result.add(block.toString());
                }
                break;
            case Back:
                // 後ろから数える
                for (int i = text.length() - 1; i >= 0; i--) {
                    block.insert(0, text.charAt(i));
                    if (block.length() >= length) {
                        result.add(0, block.toString());
                        block.delete(0, block.length());
                    }
                }
                if (block.length() > 0) {
                    // 残りを先頭に追加
                    result.add(0, block.toString());
                }
                break;
        }
        return result;
    }

}
