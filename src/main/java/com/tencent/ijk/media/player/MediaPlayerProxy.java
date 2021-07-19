/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.view.Surface
 *  android.view.SurfaceHolder
 */
package com.tencent.ijk.media.player;

import android.content.Context;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.IMediaPlayer;
import com.tencent.ijk.media.player.IMediaPlayer$OnBufferingUpdateListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnCompletionListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHLSKeyErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnHevcVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnInfoListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnPreparedListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnSeekCompleteListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnTimedTextListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoDecoderErrorListener;
import com.tencent.ijk.media.player.IMediaPlayer$OnVideoSizeChangedListener;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.MediaPlayerProxy$1;
import com.tencent.ijk.media.player.MediaPlayerProxy$10;
import com.tencent.ijk.media.player.MediaPlayerProxy$11;
import com.tencent.ijk.media.player.MediaPlayerProxy$2;
import com.tencent.ijk.media.player.MediaPlayerProxy$3;
import com.tencent.ijk.media.player.MediaPlayerProxy$4;
import com.tencent.ijk.media.player.MediaPlayerProxy$5;
import com.tencent.ijk.media.player.MediaPlayerProxy$6;
import com.tencent.ijk.media.player.MediaPlayerProxy$7;
import com.tencent.ijk.media.player.MediaPlayerProxy$8;
import com.tencent.ijk.media.player.MediaPlayerProxy$9;
import com.tencent.ijk.media.player.misc.IMediaDataSource;
import com.tencent.ijk.media.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;

public class MediaPlayerProxy
implements IMediaPlayer {
    public final IMediaPlayer mBackEndMediaPlayer;

    public MediaPlayerProxy(IMediaPlayer iMediaPlayer) {
        this.mBackEndMediaPlayer = iMediaPlayer;
    }

    public int getAudioSessionId() {
        return this.mBackEndMediaPlayer.getAudioSessionId();
    }

    public int getBitrateIndex() {
        return this.mBackEndMediaPlayer.getBitrateIndex();
    }

    public long getCurrentPosition() {
        return this.mBackEndMediaPlayer.getCurrentPosition();
    }

    public String getDataSource() {
        return this.mBackEndMediaPlayer.getDataSource();
    }

    public long getDuration() {
        return this.mBackEndMediaPlayer.getDuration();
    }

    public IMediaPlayer getInternalMediaPlayer() {
        return this.mBackEndMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        return this.mBackEndMediaPlayer.getMediaInfo();
    }

    public float getRate() {
        return this.mBackEndMediaPlayer.getRate();
    }

    public ArrayList getSupportedBitrates() {
        return this.mBackEndMediaPlayer.getSupportedBitrates();
    }

    public Surface getSurface() {
        return this.mBackEndMediaPlayer.getSurface();
    }

    public ITrackInfo[] getTrackInfo() {
        return this.mBackEndMediaPlayer.getTrackInfo();
    }

    public int getVideoHeight() {
        return this.mBackEndMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return this.mBackEndMediaPlayer.getVideoSarDen();
    }

    public int getVideoSarNum() {
        return this.mBackEndMediaPlayer.getVideoSarNum();
    }

    public int getVideoWidth() {
        return this.mBackEndMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mBackEndMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return false;
    }

    public boolean isPlaying() {
        return this.mBackEndMediaPlayer.isPlaying();
    }

    public void pause() {
        this.mBackEndMediaPlayer.pause();
    }

    public void prepareAsync() {
        this.mBackEndMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mBackEndMediaPlayer.release();
    }

    public void reset() {
        this.mBackEndMediaPlayer.reset();
    }

    public void seekTo(long l10) {
        this.mBackEndMediaPlayer.seekTo(l10);
    }

    public void setAudioStreamType(int n10) {
        this.mBackEndMediaPlayer.setAudioStreamType(n10);
    }

    public void setAudioVolume(int n10) {
        this.mBackEndMediaPlayer.setAudioVolume(n10);
    }

    public void setBitrateIndex(int n10) {
        this.mBackEndMediaPlayer.setBitrateIndex(n10);
    }

    public void setDataSource(Context context, Uri uri) {
        this.mBackEndMediaPlayer.setDataSource(context, uri);
    }

    public void setDataSource(Context context, Uri uri, Map map) {
        this.mBackEndMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.mBackEndMediaPlayer.setDataSource(iMediaDataSource);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mBackEndMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String string2) {
        this.mBackEndMediaPlayer.setDataSource(string2);
    }

    public void setDisplay(SurfaceHolder surfaceHolder) {
        this.mBackEndMediaPlayer.setDisplay(surfaceHolder);
    }

    public void setKeepInBackground(boolean bl2) {
        this.mBackEndMediaPlayer.setKeepInBackground(bl2);
    }

    public void setLogEnabled(boolean bl2) {
    }

    public void setLooping(boolean bl2) {
        this.mBackEndMediaPlayer.setLooping(bl2);
    }

    public void setOnBufferingUpdateListener(IMediaPlayer$OnBufferingUpdateListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$3 mediaPlayerProxy$3 = new MediaPlayerProxy$3(this, (IMediaPlayer$OnBufferingUpdateListener)object);
            iMediaPlayer.setOnBufferingUpdateListener(mediaPlayerProxy$3);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnBufferingUpdateListener(null);
        }
    }

    public void setOnCompletionListener(IMediaPlayer$OnCompletionListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$2 mediaPlayerProxy$2 = new MediaPlayerProxy$2(this, (IMediaPlayer$OnCompletionListener)object);
            iMediaPlayer.setOnCompletionListener(mediaPlayerProxy$2);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnCompletionListener(null);
        }
    }

    public void setOnErrorListener(IMediaPlayer$OnErrorListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$6 mediaPlayerProxy$6 = new MediaPlayerProxy$6(this, (IMediaPlayer$OnErrorListener)object);
            iMediaPlayer.setOnErrorListener(mediaPlayerProxy$6);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnErrorListener(null);
        }
    }

    public void setOnHLSKeyErrorListener(IMediaPlayer$OnHLSKeyErrorListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$9 mediaPlayerProxy$9 = new MediaPlayerProxy$9(this, (IMediaPlayer$OnHLSKeyErrorListener)object);
            iMediaPlayer.setOnHLSKeyErrorListener(mediaPlayerProxy$9);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnHLSKeyErrorListener(null);
        }
    }

    public void setOnHevcVideoDecoderErrorListener(IMediaPlayer$OnHevcVideoDecoderErrorListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$10 mediaPlayerProxy$10 = new MediaPlayerProxy$10(this, (IMediaPlayer$OnHevcVideoDecoderErrorListener)object);
            iMediaPlayer.setOnHevcVideoDecoderErrorListener(mediaPlayerProxy$10);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnHevcVideoDecoderErrorListener(null);
        }
    }

    public void setOnInfoListener(IMediaPlayer$OnInfoListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$7 mediaPlayerProxy$7 = new MediaPlayerProxy$7(this, (IMediaPlayer$OnInfoListener)object);
            iMediaPlayer.setOnInfoListener(mediaPlayerProxy$7);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnInfoListener(null);
        }
    }

    public void setOnPreparedListener(IMediaPlayer$OnPreparedListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$1 mediaPlayerProxy$1 = new MediaPlayerProxy$1(this, (IMediaPlayer$OnPreparedListener)object);
            iMediaPlayer.setOnPreparedListener(mediaPlayerProxy$1);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnPreparedListener(null);
        }
    }

    public void setOnSeekCompleteListener(IMediaPlayer$OnSeekCompleteListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$4 mediaPlayerProxy$4 = new MediaPlayerProxy$4(this, (IMediaPlayer$OnSeekCompleteListener)object);
            iMediaPlayer.setOnSeekCompleteListener(mediaPlayerProxy$4);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnSeekCompleteListener(null);
        }
    }

    public void setOnTimedTextListener(IMediaPlayer$OnTimedTextListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$8 mediaPlayerProxy$8 = new MediaPlayerProxy$8(this, (IMediaPlayer$OnTimedTextListener)object);
            iMediaPlayer.setOnTimedTextListener(mediaPlayerProxy$8);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnTimedTextListener(null);
        }
    }

    public void setOnVideoDecoderErrorListener(IMediaPlayer$OnVideoDecoderErrorListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$11 mediaPlayerProxy$11 = new MediaPlayerProxy$11(this, (IMediaPlayer$OnVideoDecoderErrorListener)object);
            iMediaPlayer.setOnVideoDecoderErrorListener(mediaPlayerProxy$11);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnVideoDecoderErrorListener(null);
        }
    }

    public void setOnVideoSizeChangedListener(IMediaPlayer$OnVideoSizeChangedListener object) {
        if (object != null) {
            IMediaPlayer iMediaPlayer = this.mBackEndMediaPlayer;
            MediaPlayerProxy$5 mediaPlayerProxy$5 = new MediaPlayerProxy$5(this, (IMediaPlayer$OnVideoSizeChangedListener)object);
            iMediaPlayer.setOnVideoSizeChangedListener(mediaPlayerProxy$5);
        } else {
            object = this.mBackEndMediaPlayer;
            Object var2_3 = null;
            object.setOnVideoSizeChangedListener(null);
        }
    }

    public void setRate(float f10) {
        this.mBackEndMediaPlayer.setRate(f10);
    }

    public void setScreenOnWhilePlaying(boolean bl2) {
        this.mBackEndMediaPlayer.setScreenOnWhilePlaying(bl2);
    }

    public void setSurface(Surface surface) {
        this.mBackEndMediaPlayer.setSurface(surface);
    }

    public void setVolume(float f10, float f11) {
        this.mBackEndMediaPlayer.setVolume(f10, f11);
    }

    public void setWakeMode(Context context, int n10) {
        this.mBackEndMediaPlayer.setWakeMode(context, n10);
    }

    public void start() {
        this.mBackEndMediaPlayer.start();
    }

    public void stop() {
        this.mBackEndMediaPlayer.stop();
    }
}

