package com.ushibutatory.zundoko.service;

import com.ushibutatory.zundoko.model.zundoko.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * ズンドコサービス
 */
@Service
public class ZundokoService extends BaseService {

    public Result execute(String title, Optional<Integer> count) {
        try {
            // 歌手を生成
            Singer singer = new Singer();

            // 観客を生成
            Audience audience = new Audience();

            // 会場を生成
            House house = new House(singer, audience);
            house.setLimitCount(count.orElse(0));

            // 歌を取得
            Optional<ISong> song = Album.getInstance().find(title);
            if (!song.isPresent()) {
                Result result = new Result();
                result.addPhrase("Not found song.");
                return result;
            } else {
                // 実行結果を返す
                return house.play(song.get());
            }
        } catch (Exception ex) {
            Result result = new Result();
            result.addPhrase(ex.getMessage());
            return result;
        }
    }
}
