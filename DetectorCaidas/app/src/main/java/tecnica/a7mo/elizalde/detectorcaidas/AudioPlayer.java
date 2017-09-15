package tecnica.a7mo.elizalde.detectorcaidas;

import android.content.Context;
import android.media.MediaPlayer;

/**
 * Created by rodri on 19/10/2016.
 */
public class AudioPlayer {

    private static MediaPlayer mMediaPlayer;

    public static void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public static void play(Context c, int rid) {
        AudioPlayer.stop();

        mMediaPlayer = MediaPlayer.create(c, rid);
        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                stop();
            }
        });

        mMediaPlayer.start();
    }

}