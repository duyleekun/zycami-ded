/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnBufferingUpdateListener
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnSeekCompleteListener
 *  android.media.MediaPlayer$OnTimedTextListener
 *  android.media.MediaPlayer$OnVideoSizeChangedListener
 *  android.media.TimedText
 */
package com.tencent.ijk.media.player;

import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.TimedText;
import com.tencent.ijk.media.player.AbstractMediaPlayer;
import com.tencent.ijk.media.player.AndroidMediaPlayer;
import com.tencent.ijk.media.player.IjkTimedText;
import java.lang.ref.WeakReference;

public class AndroidMediaPlayer$AndroidMediaPlayerListenerHolder
implements MediaPlayer.OnBufferingUpdateListener,
MediaPlayer.OnCompletionListener,
MediaPlayer.OnErrorListener,
MediaPlayer.OnInfoListener,
MediaPlayer.OnPreparedListener,
MediaPlayer.OnSeekCompleteListener,
MediaPlayer.OnTimedTextListener,
MediaPlayer.OnVideoSizeChangedListener {
    public final WeakReference mWeakMediaPlayer;
    public final /* synthetic */ AndroidMediaPlayer this$0;

    public AndroidMediaPlayer$AndroidMediaPlayerListenerHolder(AndroidMediaPlayer weakReference, AndroidMediaPlayer androidMediaPlayer) {
        this.this$0 = weakReference;
        this.mWeakMediaPlayer = weakReference = new WeakReference<AndroidMediaPlayer>(androidMediaPlayer);
    }

    public void onBufferingUpdate(MediaPlayer object, int n10) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        this.this$0.notifyOnBufferingUpdate(n10);
    }

    public void onCompletion(MediaPlayer object) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        this.this$0.notifyOnCompletion();
    }

    public boolean onError(MediaPlayer object, int n10, int n11) {
        boolean bl2;
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object != null && (bl2 = ((AbstractMediaPlayer)(object = this.this$0)).notifyOnError(n10, n11))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean onInfo(MediaPlayer object, int n10, int n11) {
        boolean bl2;
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object != null && (bl2 = ((AbstractMediaPlayer)(object = this.this$0)).notifyOnInfo(n10, n11))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void onPrepared(MediaPlayer object) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        this.this$0.notifyOnPrepared();
    }

    public void onSeekComplete(MediaPlayer object) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        this.this$0.notifyOnSeekComplete();
    }

    public void onTimedText(MediaPlayer object, TimedText object2) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        object = null;
        if (object2 != null) {
            Rect rect = object2.getBounds();
            object2 = object2.getText();
            object = new IjkTimedText(rect, (String)object2);
        }
        this.this$0.notifyOnTimedText((IjkTimedText)object);
    }

    public void onVideoSizeChanged(MediaPlayer object, int n10, int n11) {
        object = (AndroidMediaPlayer)this.mWeakMediaPlayer.get();
        if (object == null) {
            return;
        }
        object = this.this$0;
        int n12 = 1;
        ((AbstractMediaPlayer)object).notifyOnVideoSizeChanged(n10, n11, n12, n12);
    }
}

