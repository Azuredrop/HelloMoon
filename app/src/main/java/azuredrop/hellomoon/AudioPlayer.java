package azuredrop.hellomoon;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by Administrator on 2017/3/21.
 */

public class AudioPlayer {
    private MediaPlayer mPayer;

    public void play(Context c) {
        if (mPayer != null) {
            mPayer.start();
            return;
        }

        mPayer = MediaPlayer.create(c, R.raw.myfav);
        mPayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });

        mPayer.start();
    }

    public void pause() {
        if (mPayer != null) {
            mPayer.pause();
        }
    }

    public void stop() {
        if (mPayer != null) {
            mPayer.release();
            mPayer = null;
        }
    }
}
