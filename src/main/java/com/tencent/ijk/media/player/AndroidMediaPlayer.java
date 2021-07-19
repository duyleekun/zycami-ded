/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.media.MediaDataSource
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnBufferingUpdateListener
 *  android.media.MediaPlayer$OnCompletionListener
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.media.MediaPlayer$OnSeekCompleteListener
 *  android.media.MediaPlayer$OnTimedTextListener
 *  android.media.MediaPlayer$OnVideoSizeChangedListener
 *  android.media.PlaybackParams
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.Surface
 *  android.view.SurfaceHolder
 */
package com.tencent.ijk.media.player;

import android.content.Context;
import android.media.MediaDataSource;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.ijk.media.player.AbstractMediaPlayer;
import com.tencent.ijk.media.player.AndroidMediaPlayer$AndroidMediaPlayerListenerHolder;
import com.tencent.ijk.media.player.AndroidMediaPlayer$MediaDataSourceProxy;
import com.tencent.ijk.media.player.MediaInfo;
import com.tencent.ijk.media.player.misc.AndroidTrackInfo;
import com.tencent.ijk.media.player.misc.IMediaDataSource;
import com.tencent.ijk.media.player.misc.ITrackInfo;
import com.tencent.ijk.media.player.pragma.DebugLog;
import com.tencent.liteav.basic.log.TXCLog;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class AndroidMediaPlayer
extends AbstractMediaPlayer {
    private static final String TAG = "AndroidMediaPlayer";
    private static MediaInfo sMediaInfo;
    private String mDataSource;
    private final Object mInitLock;
    private final AndroidMediaPlayer$AndroidMediaPlayerListenerHolder mInternalListenerAdapter;
    private final MediaPlayer mInternalMediaPlayer;
    private boolean mIsReleased;
    private MediaDataSource mMediaDataSource;
    private Surface mSurface;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public AndroidMediaPlayer() {
        MediaPlayer mediaPlayer;
        Object object;
        this.mInitLock = object = new Object();
        synchronized (object) {
            this.mInternalMediaPlayer = mediaPlayer = new MediaPlayer();
        }
        mediaPlayer.setAudioStreamType(3);
        this.mInternalListenerAdapter = object = new AndroidMediaPlayer$AndroidMediaPlayerListenerHolder(this, this);
        this.attachInternalListeners();
    }

    private void attachInternalListeners() {
        MediaPlayer mediaPlayer = this.mInternalMediaPlayer;
        AndroidMediaPlayer$AndroidMediaPlayerListenerHolder androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnPreparedListener((MediaPlayer.OnPreparedListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnSeekCompleteListener((MediaPlayer.OnSeekCompleteListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnVideoSizeChangedListener((MediaPlayer.OnVideoSizeChangedListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnErrorListener((MediaPlayer.OnErrorListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnInfoListener((MediaPlayer.OnInfoListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
        mediaPlayer = this.mInternalMediaPlayer;
        androidMediaPlayer$AndroidMediaPlayerListenerHolder = this.mInternalListenerAdapter;
        mediaPlayer.setOnTimedTextListener((MediaPlayer.OnTimedTextListener)androidMediaPlayer$AndroidMediaPlayerListenerHolder);
    }

    private void releaseMediaDataSource() {
        MediaDataSource mediaDataSource = this.mMediaDataSource;
        if (mediaDataSource != null) {
            try {
                mediaDataSource.close();
            }
            catch (IOException iOException) {
                String string2 = TAG;
                String string3 = "close media data source failed.";
                TXCLog.e(string2, string3, iOException);
            }
            mediaDataSource = null;
            this.mMediaDataSource = null;
        }
    }

    public int getAudioSessionId() {
        return this.mInternalMediaPlayer.getAudioSessionId();
    }

    public int getBitrateIndex() {
        return 0;
    }

    public long getCurrentPosition() {
        MediaPlayer mediaPlayer;
        try {
            mediaPlayer = this.mInternalMediaPlayer;
        }
        catch (IllegalStateException illegalStateException) {
            DebugLog.printStackTrace(illegalStateException);
            return 0L;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public String getDataSource() {
        return this.mDataSource;
    }

    public long getDuration() {
        MediaPlayer mediaPlayer;
        try {
            mediaPlayer = this.mInternalMediaPlayer;
        }
        catch (IllegalStateException illegalStateException) {
            DebugLog.printStackTrace(illegalStateException);
            return 0L;
        }
        return mediaPlayer.getDuration();
    }

    public MediaPlayer getInternalMediaPlayer() {
        return this.mInternalMediaPlayer;
    }

    public MediaInfo getMediaInfo() {
        MediaInfo mediaInfo = sMediaInfo;
        if (mediaInfo == null) {
            String string2;
            String string3;
            mediaInfo = new MediaInfo();
            mediaInfo.mVideoDecoder = string3 = "android";
            mediaInfo.mVideoDecoderImpl = string2 = "HW";
            mediaInfo.mAudioDecoder = string3;
            mediaInfo.mAudioDecoderImpl = string2;
            sMediaInfo = mediaInfo;
        }
        return sMediaInfo;
    }

    public float getRate() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return this.mInternalMediaPlayer.getPlaybackParams().getSpeed();
        }
        return 1.0f;
    }

    public ArrayList getSupportedBitrates() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public Surface getSurface() {
        return this.mSurface;
    }

    public ITrackInfo[] getTrackInfo() {
        return AndroidTrackInfo.fromMediaPlayer(this.mInternalMediaPlayer);
    }

    public int getVideoHeight() {
        return this.mInternalMediaPlayer.getVideoHeight();
    }

    public int getVideoSarDen() {
        return 1;
    }

    public int getVideoSarNum() {
        return 1;
    }

    public int getVideoWidth() {
        return this.mInternalMediaPlayer.getVideoWidth();
    }

    public boolean isLooping() {
        return this.mInternalMediaPlayer.isLooping();
    }

    public boolean isPlayable() {
        return true;
    }

    public boolean isPlaying() {
        MediaPlayer mediaPlayer;
        try {
            mediaPlayer = this.mInternalMediaPlayer;
        }
        catch (IllegalStateException illegalStateException) {
            DebugLog.printStackTrace(illegalStateException);
            return false;
        }
        return mediaPlayer.isPlaying();
    }

    public void pause() {
        this.mInternalMediaPlayer.pause();
    }

    public void prepareAsync() {
        this.mInternalMediaPlayer.prepareAsync();
    }

    public void release() {
        this.mIsReleased = true;
        this.mInternalMediaPlayer.release();
        this.releaseMediaDataSource();
        this.resetListeners();
        this.attachInternalListeners();
    }

    public void reset() {
        MediaPlayer mediaPlayer = this.mInternalMediaPlayer;
        try {
            mediaPlayer.reset();
        }
        catch (IllegalStateException illegalStateException) {
            DebugLog.printStackTrace(illegalStateException);
        }
        this.releaseMediaDataSource();
        this.resetListeners();
        this.attachInternalListeners();
    }

    public void seekTo(long l10) {
        MediaPlayer mediaPlayer = this.mInternalMediaPlayer;
        int n10 = (int)l10;
        mediaPlayer.seekTo(n10);
    }

    public void setAudioStreamType(int n10) {
        this.mInternalMediaPlayer.setAudioStreamType(n10);
    }

    public void setAudioVolume(int n10) {
    }

    public void setBitrateIndex(int n10) {
    }

    public void setDataSource(Context context, Uri uri) {
        this.mInternalMediaPlayer.setDataSource(context, uri);
    }

    public void setDataSource(Context context, Uri uri, Map map) {
        this.mInternalMediaPlayer.setDataSource(context, uri, map);
    }

    public void setDataSource(IMediaDataSource iMediaDataSource) {
        this.releaseMediaDataSource();
        AndroidMediaPlayer$MediaDataSourceProxy androidMediaPlayer$MediaDataSourceProxy = new AndroidMediaPlayer$MediaDataSourceProxy(iMediaDataSource);
        this.mMediaDataSource = androidMediaPlayer$MediaDataSourceProxy;
        this.mInternalMediaPlayer.setDataSource((MediaDataSource)androidMediaPlayer$MediaDataSourceProxy);
    }

    public void setDataSource(FileDescriptor fileDescriptor) {
        this.mInternalMediaPlayer.setDataSource(fileDescriptor);
    }

    public void setDataSource(String string2) {
        String string3;
        boolean bl2;
        this.mDataSource = string2;
        Object object = Uri.parse((String)string2);
        String string4 = object.getScheme();
        boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl3 && (bl2 = string4.equalsIgnoreCase(string3 = "file"))) {
            string2 = this.mInternalMediaPlayer;
            object = object.getPath();
            string2.setDataSource((String)object);
        } else {
            object = this.mInternalMediaPlayer;
            object.setDataSource(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDisplay(SurfaceHolder surfaceHolder) {
        Object object = this.mInitLock;
        synchronized (object) {
            boolean bl2 = this.mIsReleased;
            if (!bl2) {
                MediaPlayer mediaPlayer = this.mInternalMediaPlayer;
                mediaPlayer.setDisplay(surfaceHolder);
            }
            return;
        }
    }

    public void setKeepInBackground(boolean bl2) {
    }

    public void setLogEnabled(boolean bl2) {
    }

    public void setLooping(boolean bl2) {
        this.mInternalMediaPlayer.setLooping(bl2);
    }

    public void setRate(float f10) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            PlaybackParams playbackParams = new PlaybackParams();
            playbackParams.setPitch(f10);
            playbackParams.setSpeed(f10);
            MediaPlayer mediaPlayer = this.mInternalMediaPlayer;
            mediaPlayer.setPlaybackParams(playbackParams);
        }
    }

    public void setScreenOnWhilePlaying(boolean bl2) {
        this.mInternalMediaPlayer.setScreenOnWhilePlaying(bl2);
    }

    public void setSurface(Surface surface) {
        this.mInternalMediaPlayer.setSurface(surface);
        this.mSurface = surface;
    }

    public void setVolume(float f10, float f11) {
        this.mInternalMediaPlayer.setVolume(f10, f11);
    }

    public void setWakeMode(Context context, int n10) {
        this.mInternalMediaPlayer.setWakeMode(context, n10);
    }

    public void start() {
        this.mInternalMediaPlayer.start();
    }

    public void stop() {
        this.mInternalMediaPlayer.stop();
    }
}

