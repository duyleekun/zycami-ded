/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;

public interface ControlDispatcher {
    public boolean dispatchFastForward(Player var1);

    public boolean dispatchNext(Player var1);

    public boolean dispatchPrepare(Player var1);

    public boolean dispatchPrevious(Player var1);

    public boolean dispatchRewind(Player var1);

    public boolean dispatchSeekTo(Player var1, int var2, long var3);

    public boolean dispatchSetPlayWhenReady(Player var1, boolean var2);

    public boolean dispatchSetPlaybackParameters(Player var1, PlaybackParameters var2);

    public boolean dispatchSetRepeatMode(Player var1, int var2);

    public boolean dispatchSetShuffleModeEnabled(Player var1, boolean var2);

    public boolean dispatchStop(Player var1, boolean var2);

    public boolean isFastForwardEnabled();

    public boolean isRewindEnabled();
}

