/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.os.Looper;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.util.Clock;
import java.util.List;

public interface ExoPlayer
extends Player {
    public static final long DEFAULT_RELEASE_TIMEOUT_MS = 500L;

    public void addMediaSource(int var1, MediaSource var2);

    public void addMediaSource(MediaSource var1);

    public void addMediaSources(int var1, List var2);

    public void addMediaSources(List var1);

    public PlayerMessage createMessage(PlayerMessage$Target var1);

    public boolean experimentalIsSleepingForOffload();

    public void experimentalSetOffloadSchedulingEnabled(boolean var1);

    public Clock getClock();

    public boolean getPauseAtEndOfMediaItems();

    public Looper getPlaybackLooper();

    public SeekParameters getSeekParameters();

    public TrackSelector getTrackSelector();

    public void prepare(MediaSource var1);

    public void prepare(MediaSource var1, boolean var2, boolean var3);

    public void retry();

    public void setForegroundMode(boolean var1);

    public void setMediaSource(MediaSource var1);

    public void setMediaSource(MediaSource var1, long var2);

    public void setMediaSource(MediaSource var1, boolean var2);

    public void setMediaSources(List var1);

    public void setMediaSources(List var1, int var2, long var3);

    public void setMediaSources(List var1, boolean var2);

    public void setPauseAtEndOfMediaItems(boolean var1);

    public void setSeekParameters(SeekParameters var1);

    public void setShuffleOrder(ShuffleOrder var1);
}

