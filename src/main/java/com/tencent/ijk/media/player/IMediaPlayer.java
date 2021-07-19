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
import com.tencent.ijk.media.player.misc.IMediaDataSource;
import com.tencent.ijk.media.player.misc.ITrackInfo;
import java.io.FileDescriptor;
import java.util.ArrayList;
import java.util.Map;

public interface IMediaPlayer {
    public static final int MEDIA_ERROR_IO = 64532;
    public static final int MEDIA_ERROR_MALFORMED = 64529;
    public static final int MEDIA_ERROR_NOT_VALID_FOR_PROGRESSIVE_PLAYBACK = 200;
    public static final int MEDIA_ERROR_SERVER_DIED = 100;
    public static final int MEDIA_ERROR_TIMED_OUT = 146;
    public static final int MEDIA_ERROR_UNKNOWN = 1;
    public static final int MEDIA_ERROR_UNSUPPORTED = 64526;
    public static final int MEDIA_INFO_AUDIO_RENDERING_START = 10002;
    public static final int MEDIA_INFO_BAD_INTERLEAVING = 800;
    public static final int MEDIA_INFO_BUFFERING_END = 702;
    public static final int MEDIA_INFO_BUFFERING_START = 701;
    public static final int MEDIA_INFO_FIRST_VIDEO_PACKET = 10011;
    public static final int MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE = 10100;
    public static final int MEDIA_INFO_METADATA_UPDATE = 802;
    public static final int MEDIA_INFO_NETWORK_BANDWIDTH = 703;
    public static final int MEDIA_INFO_NOT_SEEKABLE = 801;
    public static final int MEDIA_INFO_STARTED_AS_NEXT = 2;
    public static final int MEDIA_INFO_SUBTITLE_TIMED_OUT = 902;
    public static final int MEDIA_INFO_TIMED_TEXT_ERROR = 900;
    public static final int MEDIA_INFO_UNKNOWN = 1;
    public static final int MEDIA_INFO_UNSUPPORTED_SUBTITLE = 901;
    public static final int MEDIA_INFO_VIDEO_RENDERING_START = 3;
    public static final int MEDIA_INFO_VIDEO_ROTATION_CHANGED = 10001;
    public static final int MEDIA_INFO_VIDEO_TRACK_LAGGING = 700;

    public int getAudioSessionId();

    public int getBitrateIndex();

    public long getCurrentPosition();

    public String getDataSource();

    public long getDuration();

    public MediaInfo getMediaInfo();

    public float getRate();

    public ArrayList getSupportedBitrates();

    public Surface getSurface();

    public ITrackInfo[] getTrackInfo();

    public int getVideoHeight();

    public int getVideoSarDen();

    public int getVideoSarNum();

    public int getVideoWidth();

    public boolean isLooping();

    public boolean isPlayable();

    public boolean isPlaying();

    public void pause();

    public void prepareAsync();

    public void release();

    public void reset();

    public void seekTo(long var1);

    public void setAudioStreamType(int var1);

    public void setAudioVolume(int var1);

    public void setBitrateIndex(int var1);

    public void setDataSource(Context var1, Uri var2);

    public void setDataSource(Context var1, Uri var2, Map var3);

    public void setDataSource(IMediaDataSource var1);

    public void setDataSource(FileDescriptor var1);

    public void setDataSource(String var1);

    public void setDisplay(SurfaceHolder var1);

    public void setKeepInBackground(boolean var1);

    public void setLogEnabled(boolean var1);

    public void setLooping(boolean var1);

    public void setOnBufferingUpdateListener(IMediaPlayer$OnBufferingUpdateListener var1);

    public void setOnCompletionListener(IMediaPlayer$OnCompletionListener var1);

    public void setOnErrorListener(IMediaPlayer$OnErrorListener var1);

    public void setOnHLSKeyErrorListener(IMediaPlayer$OnHLSKeyErrorListener var1);

    public void setOnHevcVideoDecoderErrorListener(IMediaPlayer$OnHevcVideoDecoderErrorListener var1);

    public void setOnInfoListener(IMediaPlayer$OnInfoListener var1);

    public void setOnPreparedListener(IMediaPlayer$OnPreparedListener var1);

    public void setOnSeekCompleteListener(IMediaPlayer$OnSeekCompleteListener var1);

    public void setOnTimedTextListener(IMediaPlayer$OnTimedTextListener var1);

    public void setOnVideoDecoderErrorListener(IMediaPlayer$OnVideoDecoderErrorListener var1);

    public void setOnVideoSizeChangedListener(IMediaPlayer$OnVideoSizeChangedListener var1);

    public void setRate(float var1);

    public void setScreenOnWhilePlaying(boolean var1);

    public void setSurface(Surface var1);

    public void setVolume(float var1, float var2);

    public void setWakeMode(Context var1, int var2);

    public void start();

    public void stop();
}

