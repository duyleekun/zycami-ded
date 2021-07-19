/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;

public class DefaultControlDispatcher
implements ControlDispatcher {
    public static final int DEFAULT_FAST_FORWARD_MS = 15000;
    public static final int DEFAULT_REWIND_MS = 5000;
    private static final int MAX_POSITION_FOR_SEEK_TO_PREVIOUS = 3000;
    private long fastForwardIncrementMs;
    private long rewindIncrementMs;
    private final Timeline$Window window;

    public DefaultControlDispatcher() {
        this(15000L, 5000L);
    }

    public DefaultControlDispatcher(long l10, long l11) {
        Timeline$Window timeline$Window;
        this.fastForwardIncrementMs = l10;
        this.rewindIncrementMs = l11;
        this.window = timeline$Window = new Timeline$Window();
    }

    private static void seekToOffset(Player player, long l10) {
        long l11;
        long l12 = player.getCurrentPosition() + l10;
        l10 = player.getDuration();
        long l13 = l10 - (l11 = -9223372036854775807L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false) {
            l12 = Math.min(l12, l10);
        }
        l10 = Math.max(l12, 0L);
        int n10 = player.getCurrentWindowIndex();
        player.seekTo(n10, l10);
    }

    public boolean dispatchFastForward(Player player) {
        boolean bl2 = this.isFastForwardEnabled();
        if (bl2 && (bl2 = player.isCurrentWindowSeekable())) {
            long l10 = this.fastForwardIncrementMs;
            DefaultControlDispatcher.seekToOffset(player, l10);
        }
        return true;
    }

    public boolean dispatchNext(Player player) {
        boolean bl2;
        Object object = player.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        boolean bl3 = true;
        if (!n10 && !(bl2 = player.isPlayingAd())) {
            int n11 = player.getCurrentWindowIndex();
            Timeline$Window timeline$Window = this.window;
            ((Timeline)object).getWindow(n11, timeline$Window);
            int n12 = player.getNextWindowIndex();
            int n13 = -1;
            long l10 = -9223372036854775807L;
            if (n12 != n13) {
                player.seekTo(n12, l10);
            } else {
                object = this.window;
                n12 = (int)(((Timeline$Window)object).isLive() ? 1 : 0);
                if (n12 != 0) {
                    object = this.window;
                    n12 = (int)(((Timeline$Window)object).isDynamic ? 1 : 0);
                    if (n12 != 0) {
                        player.seekTo(n11, l10);
                    }
                }
            }
        }
        return bl3;
    }

    public boolean dispatchPrepare(Player player) {
        player.prepare();
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public boolean dispatchPrevious(Player var1_1) {
        block5: {
            var2_2 = var1_1.getCurrentTimeline();
            var3_3 = var2_2.isEmpty();
            var4_4 = true;
            if (var3_3 != 0 || (var3_3 = var1_1.isPlayingAd()) != 0) break block5;
            var3_3 = var1_1.getCurrentWindowIndex();
            var5_5 = this.window;
            var2_2.getWindow(var3_3, var5_5);
            var6_6 = var1_1.getPreviousWindowIndex();
            var5_5 = this.window;
            var7_7 = var5_5.isLive();
            if (!var7_7) ** GOTO lbl-1000
            var5_5 = this.window;
            var7_7 = var5_5.isSeekable;
            if (!var7_7) {
                var7_7 = var4_4;
            } else lbl-1000:
            // 2 sources

            {
                var7_7 = false;
                var5_5 = null;
            }
            var8_8 = -1;
            if (var6_6 != var8_8 && ((var8_8 = (int)((cfr_temp_0 = (var9_9 = var1_1.getCurrentPosition()) - (var11_10 = 3000L)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) <= 0 || var7_7)) {
                var13_11 = -9223372036854775807L;
                var1_1.seekTo(var6_6, var13_11);
            } else if (!var7_7) {
                var13_12 = 0L;
                var1_1.seekTo(var3_3, var13_12);
            }
        }
        return var4_4;
    }

    public boolean dispatchRewind(Player player) {
        boolean bl2 = this.isRewindEnabled();
        if (bl2 && (bl2 = player.isCurrentWindowSeekable())) {
            long l10 = -this.rewindIncrementMs;
            DefaultControlDispatcher.seekToOffset(player, l10);
        }
        return true;
    }

    public boolean dispatchSeekTo(Player player, int n10, long l10) {
        player.seekTo(n10, l10);
        return true;
    }

    public boolean dispatchSetPlayWhenReady(Player player, boolean bl2) {
        player.setPlayWhenReady(bl2);
        return true;
    }

    public boolean dispatchSetPlaybackParameters(Player player, PlaybackParameters playbackParameters) {
        player.setPlaybackParameters(playbackParameters);
        return true;
    }

    public boolean dispatchSetRepeatMode(Player player, int n10) {
        player.setRepeatMode(n10);
        return true;
    }

    public boolean dispatchSetShuffleModeEnabled(Player player, boolean bl2) {
        player.setShuffleModeEnabled(bl2);
        return true;
    }

    public boolean dispatchStop(Player player, boolean bl2) {
        player.stop(bl2);
        return true;
    }

    public long getFastForwardIncrementMs() {
        return this.fastForwardIncrementMs;
    }

    public long getRewindIncrementMs() {
        return this.rewindIncrementMs;
    }

    public boolean isFastForwardEnabled() {
        long l10 = this.fastForwardIncrementMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public boolean isRewindEnabled() {
        long l10 = this.rewindIncrementMs;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void setFastForwardIncrementMs(long l10) {
        this.fastForwardIncrementMs = l10;
    }

    public void setRewindIncrementMs(long l10) {
        this.rewindIncrementMs = l10;
    }
}

