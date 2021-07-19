/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.zyplayer;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.PlayerView;
import com.zhiyun.zyplayer.ExoVideoView;
import com.zhiyun.zyplayer.ExoVideoView$d;
import d.v.j0.d$c;

public class ExoVideoView$b
implements Player$EventListener {
    private boolean a;
    public final /* synthetic */ ExoVideoView b;

    public ExoVideoView$b(ExoVideoView exoVideoView) {
        this.b = exoVideoView;
    }

    private boolean a(ExoPlaybackException throwable) {
        int n10 = throwable.type;
        if (n10 != 0) {
            return false;
        }
        for (throwable = throwable.getSourceException(); throwable != null; throwable = throwable.getCause()) {
            n10 = throwable instanceof BehindLiveWindowException;
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public void onIsLoadingChanged(boolean bl2) {
    }

    public void onPlayWhenReadyChanged(boolean bl2, int n10) {
        this.a = bl2;
        ExoVideoView$d exoVideoView$d = ExoVideoView.s(this.b);
        if (exoVideoView$d != null) {
            exoVideoView$d = ExoVideoView.s(this.b);
            exoVideoView$d.a(bl2);
        }
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    public void onPlaybackStateChanged(int n10) {
        int n11 = 0;
        ExoVideoView exoVideoView = null;
        int n12 = 2;
        if (n10 != n12) {
            int n13 = 3;
            if (n10 != n13) {
                n11 = 4;
                if (n10 == n11) {
                    Object object = this.b;
                    n11 = 5;
                    ExoVideoView.h((ExoVideoView)object, n11);
                    ExoVideoView.o(this.b, n11);
                    object = ExoVideoView.p(this.b);
                    if (object != null) {
                        object = ExoVideoView.p(this.b);
                        exoVideoView = this.b;
                        object.a(exoVideoView);
                    }
                }
            } else {
                n10 = (int)(this.a ? 1 : 0);
                if (n10 != 0) {
                    ExoVideoView.h(this.b, n12);
                    Object object = ExoVideoView.e(this.b);
                    if (object != null) {
                        object = ExoVideoView.e(this.b);
                        ExoVideoView exoVideoView2 = this.b;
                        n13 = 702;
                        object.a(exoVideoView2, n13, 0);
                    }
                    if ((object = ExoVideoView.q(this.b)) != null) {
                        object = ExoVideoView.q(this.b);
                        exoVideoView = this.b;
                        object.a(exoVideoView);
                        object = ExoVideoView.r(this.b);
                        ((PlayerView)object).showController();
                    }
                }
            }
        } else {
            d$c d$c = ExoVideoView.e(this.b);
            if (d$c != null) {
                d$c = ExoVideoView.e(this.b);
                ExoVideoView exoVideoView3 = this.b;
                int n14 = 701;
                d$c.a(exoVideoView3, n14, 0);
            }
        }
    }

    public void onPlayerError(ExoPlaybackException object) {
        int n10 = ((ExoPlaybackException)object).type;
        int n11 = 1;
        if (n10 != n11) {
            // empty if block
        }
        n10 = -1004;
        ExoVideoView exoVideoView = this.b;
        int n12 = -1;
        ExoVideoView.h(exoVideoView, n12);
        exoVideoView = this.b;
        ExoVideoView.o(exoVideoView, n12);
        boolean bl2 = this.a((ExoPlaybackException)object);
        if (bl2) {
            ExoVideoView.t(this.b);
            object = this.b;
            ExoVideoView.u((ExoVideoView)object);
        } else {
            object = this.b;
            ExoVideoView.v((ExoVideoView)object);
        }
        object = this.b;
        bl2 = ExoVideoView.g((ExoVideoView)object);
        exoVideoView = null;
        if (bl2 && (object = ExoVideoView.i(this.b)) != null) {
            object = ExoVideoView.i(this.b);
            ((SimpleExoPlayer)object).setPlayWhenReady(false);
        }
        this.b.F(false);
        object = ExoVideoView.j(this.b);
        if (object == null || (bl2 = (object = ExoVideoView.j(this.b)).a(exoVideoView = this.b, n11, n10))) {
            // empty if block
        }
    }

    public void onPositionDiscontinuity(int n10) {
        int n11;
        Object object = this.b;
        n10 = ExoVideoView.f((ExoVideoView)object);
        if (n10 == (n11 = -1)) {
            object = this.b;
            ExoVideoView.v((ExoVideoView)object);
        }
        if ((n10 = (int)(ExoVideoView.k((ExoVideoView)(object = this.b)) ? 1 : 0)) == 0 && (object = ExoVideoView.l(this.b)) != null) {
            object = ExoVideoView.l(this.b);
            object.a();
        }
    }

    public void onRepeatModeChanged(int n10) {
    }

    public void onShuffleModeEnabledChanged(boolean bl2) {
    }

    public void onTimelineChanged(Timeline timeline, int n10) {
    }

    public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }
}

