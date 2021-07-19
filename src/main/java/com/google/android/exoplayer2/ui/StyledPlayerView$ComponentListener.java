/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.TextureView
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.widget.FrameLayout
 */
package com.google.android.exoplayer2.ui;

import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$VisibilityListener;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.spherical.SingleTapListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.video.VideoListener;
import java.util.List;

public final class StyledPlayerView$ComponentListener
implements Player$EventListener,
TextOutput,
VideoListener,
View.OnLayoutChangeListener,
SingleTapListener,
StyledPlayerControlView$VisibilityListener {
    private Object lastPeriodUidWithTracks;
    private final Timeline$Period period;
    public final /* synthetic */ StyledPlayerView this$0;

    public StyledPlayerView$ComponentListener(StyledPlayerView object) {
        this.this$0 = object;
        this.period = object = new Timeline$Period();
    }

    public void onCues(List list) {
        SubtitleView subtitleView = StyledPlayerView.access$000(this.this$0);
        if (subtitleView != null) {
            subtitleView = StyledPlayerView.access$000(this.this$0);
            subtitleView.onCues(list);
        }
    }

    public void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        view = (TextureView)view;
        n10 = StyledPlayerView.access$200(this.this$0);
        StyledPlayerView.access$300((TextureView)view, n10);
    }

    public void onPlayWhenReadyChanged(boolean bl2, int n10) {
        StyledPlayerView.access$800(this.this$0);
        StyledPlayerView.access$1000(this.this$0);
    }

    public void onPlaybackStateChanged(int n10) {
        StyledPlayerView.access$800(this.this$0);
        StyledPlayerView.access$900(this.this$0);
        StyledPlayerView.access$1000(this.this$0);
    }

    public void onPositionDiscontinuity(int n10) {
        StyledPlayerView styledPlayerView = this.this$0;
        n10 = (int)(StyledPlayerView.access$1100(styledPlayerView) ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(StyledPlayerView.access$1200(styledPlayerView = this.this$0) ? 1 : 0)) != 0) {
            styledPlayerView = this.this$0;
            styledPlayerView.hideController();
        }
    }

    public void onRenderedFirstFrame() {
        View view = StyledPlayerView.access$500(this.this$0);
        if (view != null) {
            view = StyledPlayerView.access$500(this.this$0);
            int n10 = 4;
            view.setVisibility(n10);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return StyledPlayerView.access$1300(this.this$0);
    }

    public void onTracksChanged(TrackGroupArray object, TrackSelectionArray object2) {
        object = (Player)Assertions.checkNotNull(StyledPlayerView.access$600(this.this$0));
        object2 = object.getCurrentTimeline();
        boolean n10 = ((Timeline)object2).isEmpty();
        boolean bl2 = false;
        if (n10) {
            this.lastPeriodUidWithTracks = null;
        } else {
            Object object3 = object.getCurrentTrackGroups();
            boolean bl3 = ((TrackGroupArray)object3).isEmpty();
            if (!bl3) {
                int n11 = object.getCurrentPeriodIndex();
                object3 = this.period;
                bl2 = true;
                this.lastPeriodUidWithTracks = object = object2.getPeriod((int)n11, (Timeline$Period)object3, (boolean)bl2).uid;
            } else {
                object3 = this.lastPeriodUidWithTracks;
                if (object3 != null) {
                    int n12;
                    int n13 = ((Timeline)object2).getIndexOfPeriod(object3);
                    if (n13 != (n12 = -1)) {
                        Timeline$Period timeline$Period = this.period;
                        object2 = ((Timeline)object2).getPeriod(n13, timeline$Period);
                        int n14 = ((Timeline$Period)object2).windowIndex;
                        int n15 = object.getCurrentWindowIndex();
                        if (n15 == n14) {
                            return;
                        }
                    }
                    this.lastPeriodUidWithTracks = null;
                }
            }
        }
        StyledPlayerView.access$700(this.this$0, false);
    }

    public void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
        FrameLayout frameLayout;
        Object object;
        float f11;
        block7: {
            block9: {
                float f12;
                block8: {
                    float f13;
                    int n13 = 1065353216;
                    f12 = 1.0f;
                    if (n11 != 0 && n10 != 0) {
                        f11 = (float)n10 * f10;
                        f13 = n11;
                        f11 /= f13;
                    } else {
                        n10 = n13;
                        f11 = f12;
                    }
                    object = StyledPlayerView.access$100(this.this$0);
                    n11 = object instanceof TextureView;
                    if (n11 == 0) break block7;
                    n11 = 90;
                    f13 = 1.26E-43f;
                    if (n12 == n11) break block8;
                    n11 = 270;
                    f13 = 3.78E-43f;
                    if (n12 != n11) break block9;
                }
                f12 /= f11;
                f11 = f12;
            }
            if ((n11 = StyledPlayerView.access$200((StyledPlayerView)(object = this.this$0))) != 0) {
                object = StyledPlayerView.access$100(this.this$0);
                object.removeOnLayoutChangeListener((View.OnLayoutChangeListener)this);
            }
            StyledPlayerView.access$202(this.this$0, n12);
            object = this.this$0;
            n11 = StyledPlayerView.access$200((StyledPlayerView)object);
            if (n11 != 0) {
                object = StyledPlayerView.access$100(this.this$0);
                object.addOnLayoutChangeListener((View.OnLayoutChangeListener)this);
            }
            object = (TextureView)StyledPlayerView.access$100(this.this$0);
            frameLayout = this.this$0;
            n12 = StyledPlayerView.access$200((StyledPlayerView)frameLayout);
            StyledPlayerView.access$300((TextureView)object, n12);
        }
        object = this.this$0;
        frameLayout = StyledPlayerView.access$400((StyledPlayerView)object);
        View view = StyledPlayerView.access$100(this.this$0);
        ((StyledPlayerView)object).onContentAspectRatioChanged(f11, (AspectRatioFrameLayout)frameLayout, view);
    }

    public void onVisibilityChange(int n10) {
        StyledPlayerView.access$1400(this.this$0);
    }
}

