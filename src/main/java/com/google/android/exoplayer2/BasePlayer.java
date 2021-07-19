/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class BasePlayer
implements Player {
    public final Timeline$Window window;

    public BasePlayer() {
        Timeline$Window timeline$Window;
        this.window = timeline$Window = new Timeline$Window();
    }

    private int getRepeatModeForNavigation() {
        int n10;
        int n11 = this.getRepeatMode();
        if (n11 == (n10 = 1)) {
            n11 = 0;
        }
        return n11;
    }

    public void addMediaItem(int n10, MediaItem object) {
        object = Collections.singletonList(object);
        this.addMediaItems(n10, (List)object);
    }

    public void addMediaItem(MediaItem object) {
        object = Collections.singletonList(object);
        this.addMediaItems((List)object);
    }

    public final int getBufferedPercentage() {
        Object object;
        long l10 = this.getBufferedPosition();
        long l11 = this.getDuration();
        long l12 = -9223372036854775807L;
        long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        int n10 = 100;
        if (l13 != false && (object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) != false) {
            l12 = 0L;
            long l14 = l11 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                l12 = 100;
                l10 = l10 * l12 / l11;
                int n11 = (int)l10;
                n10 = Util.constrainValue(n11, 0, n10);
            }
        } else {
            n10 = 0;
        }
        return n10;
    }

    public final long getContentDuration() {
        long l10;
        Object object = this.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        if (n10) {
            l10 = -9223372036854775807L;
        } else {
            int n11 = this.getCurrentWindowIndex();
            Timeline$Window timeline$Window = this.window;
            object = ((Timeline)object).getWindow(n11, timeline$Window);
            l10 = ((Timeline$Window)object).getDurationMs();
        }
        return l10;
    }

    public final long getCurrentLiveOffset() {
        Object object = this.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        long l10 = -9223372036854775807L;
        if (n10) {
            return l10;
        }
        int n11 = this.getCurrentWindowIndex();
        Timeline$Window timeline$Window = this.window;
        object = ((Timeline)object).getWindow(n11, timeline$Window);
        long l11 = ((Timeline$Window)object).windowStartTimeMs;
        long l12 = l11 - l10;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            return l10;
        }
        l11 = this.window.getCurrentUnixTimeMs();
        l10 = this.window.windowStartTimeMs;
        l11 -= l10;
        l10 = this.getContentPosition();
        return l11 - l10;
    }

    public final Object getCurrentManifest() {
        Object object = this.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        if (n10) {
            object = null;
        } else {
            int n11 = this.getCurrentWindowIndex();
            Timeline$Window timeline$Window = this.window;
            object = object.getWindow((int)n11, (Timeline$Window)timeline$Window).manifest;
        }
        return object;
    }

    public final MediaItem getCurrentMediaItem() {
        Object object = this.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        if (n10) {
            object = null;
        } else {
            int n11 = this.getCurrentWindowIndex();
            Timeline$Window timeline$Window = this.window;
            object = object.getWindow((int)n11, (Timeline$Window)timeline$Window).mediaItem;
        }
        return object;
    }

    public final Object getCurrentTag() {
        Object object = this.getCurrentTimeline();
        boolean n10 = ((Timeline)object).isEmpty();
        Object object2 = null;
        if (n10) {
            return null;
        }
        int n11 = this.getCurrentWindowIndex();
        Timeline$Window timeline$Window = this.window;
        object = object.getWindow((int)n11, (Timeline$Window)timeline$Window).mediaItem.playbackProperties;
        if (object != null) {
            object2 = ((MediaItem$PlaybackProperties)object).tag;
        }
        return object2;
    }

    public MediaItem getMediaItemAt(int n10) {
        Timeline timeline = this.getCurrentTimeline();
        Timeline$Window timeline$Window = this.window;
        return timeline.getWindow((int)n10, (Timeline$Window)timeline$Window).mediaItem;
    }

    public int getMediaItemCount() {
        return this.getCurrentTimeline().getWindowCount();
    }

    public final int getNextWindowIndex() {
        int n10;
        Timeline timeline = this.getCurrentTimeline();
        int n11 = timeline.isEmpty();
        if (n11 != 0) {
            n10 = -1;
        } else {
            n11 = this.getCurrentWindowIndex();
            int n12 = this.getRepeatModeForNavigation();
            boolean bl2 = this.getShuffleModeEnabled();
            n10 = timeline.getNextWindowIndex(n11, n12, bl2);
        }
        return n10;
    }

    public final int getPreviousWindowIndex() {
        int n10;
        Timeline timeline = this.getCurrentTimeline();
        int n11 = timeline.isEmpty();
        if (n11 != 0) {
            n10 = -1;
        } else {
            n11 = this.getCurrentWindowIndex();
            int n12 = this.getRepeatModeForNavigation();
            boolean bl2 = this.getShuffleModeEnabled();
            n10 = timeline.getPreviousWindowIndex(n11, n12, bl2);
        }
        return n10;
    }

    public final boolean hasNext() {
        int n10;
        int n11 = this.getNextWindowIndex();
        n11 = n11 != (n10 = -1) ? 1 : 0;
        return n11 != 0;
    }

    public final boolean hasPrevious() {
        int n10;
        int n11 = this.getPreviousWindowIndex();
        n11 = n11 != (n10 = -1) ? 1 : 0;
        return n11 != 0;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isCurrentWindowDynamic() {
        Object object = this.getCurrentTimeline();
        int n10 = ((Timeline)object).isEmpty();
        if (n10 != 0) return false;
        n10 = this.getCurrentWindowIndex();
        Timeline$Window timeline$Window = this.window;
        object = ((Timeline)object).getWindow(n10, timeline$Window);
        boolean bl2 = ((Timeline$Window)object).isDynamic;
        if (!bl2) return false;
        return true;
    }

    public final boolean isCurrentWindowLive() {
        Timeline$Window timeline$Window;
        int n10;
        boolean bl2;
        Object object = this.getCurrentTimeline();
        boolean n102 = ((Timeline)object).isEmpty();
        if (!n102 && (bl2 = ((Timeline$Window)(object = ((Timeline)object).getWindow(n10 = this.getCurrentWindowIndex(), timeline$Window = this.window))).isLive())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isCurrentWindowSeekable() {
        Object object = this.getCurrentTimeline();
        int n10 = ((Timeline)object).isEmpty();
        if (n10 != 0) return false;
        n10 = this.getCurrentWindowIndex();
        Timeline$Window timeline$Window = this.window;
        object = ((Timeline)object).getWindow(n10, timeline$Window);
        boolean bl2 = ((Timeline$Window)object).isSeekable;
        if (!bl2) return false;
        return true;
    }

    public final boolean isPlaying() {
        int n10;
        int n11 = this.getPlaybackState();
        n11 = n11 == (n10 = 3) && (n11 = (int)(this.getPlayWhenReady() ? 1 : 0)) != 0 && (n11 = this.getPlaybackSuppressionReason()) == 0 ? 1 : 0;
        return n11 != 0;
    }

    public void moveMediaItem(int n10, int n11) {
        if (n10 != n11) {
            int n12 = n10 + 1;
            this.moveMediaItems(n10, n12, n11);
        }
    }

    public final void next() {
        int n10;
        int n11 = this.getNextWindowIndex();
        if (n11 != (n10 = -1)) {
            this.seekToDefaultPosition(n11);
        }
    }

    public final void pause() {
        this.setPlayWhenReady(false);
    }

    public final void play() {
        this.setPlayWhenReady(true);
    }

    public final void previous() {
        int n10;
        int n11 = this.getPreviousWindowIndex();
        if (n11 != (n10 = -1)) {
            this.seekToDefaultPosition(n11);
        }
    }

    public void removeMediaItem(int n10) {
        int n11 = n10 + 1;
        this.removeMediaItems(n10, n11);
    }

    public final void seekTo(long l10) {
        int n10 = this.getCurrentWindowIndex();
        this.seekTo(n10, l10);
    }

    public final void seekToDefaultPosition() {
        int n10 = this.getCurrentWindowIndex();
        this.seekToDefaultPosition(n10);
    }

    public final void seekToDefaultPosition(int n10) {
        this.seekTo(n10, -9223372036854775807L);
    }

    public void setMediaItem(MediaItem object) {
        object = Collections.singletonList(object);
        this.setMediaItems((List)object);
    }

    public void setMediaItem(MediaItem object, long l10) {
        object = Collections.singletonList(object);
        this.setMediaItems((List)object, 0, l10);
    }

    public void setMediaItem(MediaItem object, boolean bl2) {
        object = Collections.singletonList(object);
        this.setMediaItems((List)object, bl2);
    }

    public void setMediaItems(List list) {
        this.setMediaItems(list, true);
    }

    public final void stop() {
        this.stop(false);
    }
}

