/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player$AudioComponent;
import com.google.android.exoplayer2.Player$DeviceComponent;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$MetadataComponent;
import com.google.android.exoplayer2.Player$TextComponent;
import com.google.android.exoplayer2.Player$VideoComponent;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.util.List;

public interface Player {
    public static final int DISCONTINUITY_REASON_AD_INSERTION = 3;
    public static final int DISCONTINUITY_REASON_INTERNAL = 4;
    public static final int DISCONTINUITY_REASON_PERIOD_TRANSITION = 0;
    public static final int DISCONTINUITY_REASON_SEEK = 1;
    public static final int DISCONTINUITY_REASON_SEEK_ADJUSTMENT = 2;
    public static final int EVENT_IS_LOADING_CHANGED = 4;
    public static final int EVENT_IS_PLAYING_CHANGED = 8;
    public static final int EVENT_MEDIA_ITEM_TRANSITION = 1;
    public static final int EVENT_PLAYBACK_PARAMETERS_CHANGED = 13;
    public static final int EVENT_PLAYBACK_STATE_CHANGED = 5;
    public static final int EVENT_PLAYBACK_SUPPRESSION_REASON_CHANGED = 7;
    public static final int EVENT_PLAYER_ERROR = 11;
    public static final int EVENT_PLAY_WHEN_READY_CHANGED = 6;
    public static final int EVENT_POSITION_DISCONTINUITY = 12;
    public static final int EVENT_REPEAT_MODE_CHANGED = 9;
    public static final int EVENT_SHUFFLE_MODE_ENABLED_CHANGED = 10;
    public static final int EVENT_STATIC_METADATA_CHANGED = 3;
    public static final int EVENT_TIMELINE_CHANGED = 0;
    public static final int EVENT_TRACKS_CHANGED = 2;
    public static final int MEDIA_ITEM_TRANSITION_REASON_AUTO = 1;
    public static final int MEDIA_ITEM_TRANSITION_REASON_PLAYLIST_CHANGED = 3;
    public static final int MEDIA_ITEM_TRANSITION_REASON_REPEAT = 0;
    public static final int MEDIA_ITEM_TRANSITION_REASON_SEEK = 2;
    public static final int PLAYBACK_SUPPRESSION_REASON_NONE = 0;
    public static final int PLAYBACK_SUPPRESSION_REASON_TRANSIENT_AUDIO_FOCUS_LOSS = 1;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_BECOMING_NOISY = 3;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_AUDIO_FOCUS_LOSS = 2;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_END_OF_MEDIA_ITEM = 5;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_REMOTE = 4;
    public static final int PLAY_WHEN_READY_CHANGE_REASON_USER_REQUEST = 1;
    public static final int REPEAT_MODE_ALL = 2;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_ONE = 1;
    public static final int STATE_BUFFERING = 2;
    public static final int STATE_ENDED = 4;
    public static final int STATE_IDLE = 1;
    public static final int STATE_READY = 3;
    public static final int TIMELINE_CHANGE_REASON_PLAYLIST_CHANGED = 0;
    public static final int TIMELINE_CHANGE_REASON_SOURCE_UPDATE = 1;

    public void addListener(Player$EventListener var1);

    public void addMediaItem(int var1, MediaItem var2);

    public void addMediaItem(MediaItem var1);

    public void addMediaItems(int var1, List var2);

    public void addMediaItems(List var1);

    public void clearMediaItems();

    public Looper getApplicationLooper();

    public Player$AudioComponent getAudioComponent();

    public int getBufferedPercentage();

    public long getBufferedPosition();

    public long getContentBufferedPosition();

    public long getContentDuration();

    public long getContentPosition();

    public int getCurrentAdGroupIndex();

    public int getCurrentAdIndexInAdGroup();

    public long getCurrentLiveOffset();

    public Object getCurrentManifest();

    public MediaItem getCurrentMediaItem();

    public int getCurrentPeriodIndex();

    public long getCurrentPosition();

    public List getCurrentStaticMetadata();

    public Object getCurrentTag();

    public Timeline getCurrentTimeline();

    public TrackGroupArray getCurrentTrackGroups();

    public TrackSelectionArray getCurrentTrackSelections();

    public int getCurrentWindowIndex();

    public Player$DeviceComponent getDeviceComponent();

    public long getDuration();

    public MediaItem getMediaItemAt(int var1);

    public int getMediaItemCount();

    public Player$MetadataComponent getMetadataComponent();

    public int getNextWindowIndex();

    public boolean getPlayWhenReady();

    public ExoPlaybackException getPlaybackError();

    public PlaybackParameters getPlaybackParameters();

    public int getPlaybackState();

    public int getPlaybackSuppressionReason();

    public ExoPlaybackException getPlayerError();

    public int getPreviousWindowIndex();

    public int getRendererCount();

    public int getRendererType(int var1);

    public int getRepeatMode();

    public boolean getShuffleModeEnabled();

    public Player$TextComponent getTextComponent();

    public long getTotalBufferedDuration();

    public Player$VideoComponent getVideoComponent();

    public boolean hasNext();

    public boolean hasPrevious();

    public boolean isCurrentWindowDynamic();

    public boolean isCurrentWindowLive();

    public boolean isCurrentWindowSeekable();

    public boolean isLoading();

    public boolean isPlaying();

    public boolean isPlayingAd();

    public void moveMediaItem(int var1, int var2);

    public void moveMediaItems(int var1, int var2, int var3);

    public void next();

    public void pause();

    public void play();

    public void prepare();

    public void previous();

    public void release();

    public void removeListener(Player$EventListener var1);

    public void removeMediaItem(int var1);

    public void removeMediaItems(int var1, int var2);

    public void seekTo(int var1, long var2);

    public void seekTo(long var1);

    public void seekToDefaultPosition();

    public void seekToDefaultPosition(int var1);

    public void setMediaItem(MediaItem var1);

    public void setMediaItem(MediaItem var1, long var2);

    public void setMediaItem(MediaItem var1, boolean var2);

    public void setMediaItems(List var1);

    public void setMediaItems(List var1, int var2, long var3);

    public void setMediaItems(List var1, boolean var2);

    public void setPlayWhenReady(boolean var1);

    public void setPlaybackParameters(PlaybackParameters var1);

    public void setRepeatMode(int var1);

    public void setShuffleModeEnabled(boolean var1);

    public void stop();

    public void stop(boolean var1);
}

