/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 *  android.os.Looper
 *  android.os.SystemClock
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.PlayerControlView$ComponentListener;
import com.google.android.exoplayer2.ui.PlayerControlView$ProgressUpdateListener;
import com.google.android.exoplayer2.ui.PlayerControlView$VisibilityListener;
import com.google.android.exoplayer2.ui.R$drawable;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.R$integer;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.R$styleable;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.ui.TimeBar$OnScrubListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.p0.d;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class PlayerControlView
extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private long[] adGroupTimesMs;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final PlayerControlView$ComponentListener componentListener;
    private ControlDispatcher controlDispatcher;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private final Runnable hideAction;
    private long hideAtMs;
    private boolean isAttachedToWindow;
    private boolean multiWindowTimeBar;
    private final View nextButton;
    private final View pauseButton;
    private final Timeline$Period period;
    private final View playButton;
    private PlaybackPreparer playbackPreparer;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final View previousButton;
    private PlayerControlView$ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private final View rewindButton;
    private boolean scrubbing;
    private boolean showFastForwardButton;
    private boolean showMultiWindowTimeBar;
    private boolean showNextButton;
    private boolean showPreviousButton;
    private boolean showRewindButton;
    private boolean showShuffleButton;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList visibilityListeners;
    private final View vrButton;
    private final Timeline$Window window;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public PlayerControlView(Context context) {
        this(context, null);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerControlView(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, attributeSet);
    }

    public PlayerControlView(Context object, AttributeSet object2, int n10, AttributeSet attributeSet) {
        super(object, (AttributeSet)object2, n10);
        int n11;
        Object object3;
        Object object4;
        int n12;
        long l10;
        int n13 = R$layout.exo_player_control_view;
        n10 = 5000;
        float f10 = 7.006E-42f;
        this.showTimeoutMs = n10;
        this.repeatToggleModes = 0;
        this.timeBarMinUpdateIntervalMs = 200;
        this.hideAtMs = l10 = -9223372036854775807L;
        this.showRewindButton = n12 = 1;
        this.showFastForwardButton = n12;
        this.showPreviousButton = n12;
        this.showNextButton = n12;
        this.showShuffleButton = false;
        n12 = 15000;
        if (attributeSet != null) {
            object4 = object.getTheme();
            object3 = R$styleable.PlayerControlView;
            object4 = object4.obtainStyledAttributes(attributeSet, object3, 0, 0);
            try {
                n11 = R$styleable.PlayerControlView_rewind_increment;
                n10 = object4.getInt(n11, n10);
                n11 = R$styleable.PlayerControlView_fastforward_increment;
                n12 = object4.getInt(n11, n12);
                n11 = R$styleable.PlayerControlView_show_timeout;
                int n14 = this.showTimeoutMs;
                this.showTimeoutMs = n11 = object4.getInt(n11, n14);
                n11 = R$styleable.PlayerControlView_controller_layout_id;
                n13 = object4.getResourceId(n11, n13);
                n11 = this.repeatToggleModes;
                this.repeatToggleModes = n11 = PlayerControlView.getRepeatToggleModes((TypedArray)object4, n11);
                n11 = R$styleable.PlayerControlView_show_rewind_button;
                n14 = (int)(this.showRewindButton ? 1 : 0);
                n11 = (int)(object4.getBoolean(n11, n14 != 0) ? 1 : 0);
                this.showRewindButton = n11;
                n11 = R$styleable.PlayerControlView_show_fastforward_button;
                n14 = this.showFastForwardButton;
                n11 = (int)(object4.getBoolean(n11, n14 != 0) ? 1 : 0);
                this.showFastForwardButton = n11;
                n11 = R$styleable.PlayerControlView_show_previous_button;
                n14 = this.showPreviousButton;
                n11 = (int)(object4.getBoolean(n11, n14 != 0) ? 1 : 0);
                this.showPreviousButton = n11;
                n11 = R$styleable.PlayerControlView_show_next_button;
                n14 = this.showNextButton;
                n11 = (int)(object4.getBoolean(n11, n14 != 0) ? 1 : 0);
                this.showNextButton = n11;
                n11 = R$styleable.PlayerControlView_show_shuffle_button;
                n14 = this.showShuffleButton;
                n11 = (int)(object4.getBoolean(n11, n14 != 0) ? 1 : 0);
                this.showShuffleButton = n11;
                n11 = R$styleable.PlayerControlView_time_bar_min_update_interval;
                n14 = this.timeBarMinUpdateIntervalMs;
                n11 = object4.getInt(n11, n14);
                this.setTimeBarMinUpdateInterval(n11);
            }
            finally {
                object4.recycle();
            }
        }
        object4 = new CopyOnWriteArrayList();
        this.visibilityListeners = object4;
        this.period = object4 = new Timeline$Period();
        this.window = object4 = new Timeline$Window();
        this.formatBuilder = object4 = new StringBuilder();
        object3 = new Formatter;
        Object object5 = Locale.getDefault();
        super((Appendable)object4, (Locale)object5);
        this.formatter = object3;
        object4 = new long[0];
        this.adGroupTimesMs = (long[])object4;
        object4 = new boolean[0];
        this.playedAdGroups = (boolean[])object4;
        object4 = new long[0];
        this.extraAdGroupTimesMs = (long[])object4;
        object4 = new boolean[0];
        this.extraPlayedAdGroups = (boolean[])object4;
        n11 = 0;
        object3 = null;
        this.componentListener = object4 = new PlayerControlView$ComponentListener(this, null);
        long l11 = n12;
        long l12 = n10;
        this.controlDispatcher = object5 = new DefaultControlDispatcher(l11, l12);
        Object object6 = new d(this);
        this.updateProgressAction = object6;
        super(this);
        this.hideAction = object6;
        LayoutInflater.from((Context)object).inflate(n13, (ViewGroup)this);
        float f11 = 3.67342E-40f;
        this.setDescendantFocusability(262144);
        n13 = R$id.exo_progress;
        object6 = (TimeBar)this.findViewById(n13);
        n12 = R$id.exo_progress_placeholder;
        View view = this.findViewById(n12);
        if (object6 != null) {
            this.timeBar = object6;
        } else if (view != null) {
            object6 = new DefaultTimeBar((Context)object, null, 0, attributeSet);
            object6.setId(n13);
            object2 = view.getLayoutParams();
            object6.setLayoutParams((ViewGroup.LayoutParams)object2);
            object2 = (ViewGroup)view.getParent();
            int n15 = object2.indexOfChild(view);
            object2.removeView(view);
            object2.addView((View)object6, n15);
            this.timeBar = object6;
        } else {
            this.timeBar = null;
        }
        n13 = R$id.exo_duration;
        object2 = (TextView)this.findViewById(n13);
        this.durationView = object2;
        n13 = R$id.exo_position;
        object2 = (TextView)this.findViewById(n13);
        this.positionView = object2;
        object2 = this.timeBar;
        if (object2 != null) {
            object2.addListener((TimeBar$OnScrubListener)object4);
        }
        n13 = R$id.exo_play;
        object2 = this.findViewById(n13);
        this.playButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_pause;
        object2 = this.findViewById(n13);
        this.pauseButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_prev;
        object2 = this.findViewById(n13);
        this.previousButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_next;
        object2 = this.findViewById(n13);
        this.nextButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_rew;
        object2 = this.findViewById(n13);
        this.rewindButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_ffwd;
        object2 = this.findViewById(n13);
        this.fastForwardButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_repeat_toggle;
        object2 = (ImageView)this.findViewById(n13);
        this.repeatToggleButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_shuffle;
        object2 = (ImageView)this.findViewById(n13);
        this.shuffleButton = object2;
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)object4);
        }
        n13 = R$id.exo_vr;
        object2 = this.findViewById(n13);
        this.vrButton = object2;
        this.setShowVrButton(false);
        this.updateButton(false, false, (View)object2);
        object = object.getResources();
        n13 = R$integer.exo_media_button_opacity_percentage_enabled;
        f11 = object.getInteger(n13);
        f10 = 100.0f;
        this.buttonAlphaEnabled = f11 /= f10;
        n13 = R$integer.exo_media_button_opacity_percentage_disabled;
        this.buttonAlphaDisabled = f11 = (float)object.getInteger(n13) / f10;
        n13 = R$drawable.exo_controls_repeat_off;
        object2 = object.getDrawable(n13);
        this.repeatOffButtonDrawable = object2;
        n13 = R$drawable.exo_controls_repeat_one;
        object2 = object.getDrawable(n13);
        this.repeatOneButtonDrawable = object2;
        n13 = R$drawable.exo_controls_repeat_all;
        object2 = object.getDrawable(n13);
        this.repeatAllButtonDrawable = object2;
        n13 = R$drawable.exo_controls_shuffle_on;
        object2 = object.getDrawable(n13);
        this.shuffleOnButtonDrawable = object2;
        n13 = R$drawable.exo_controls_shuffle_off;
        object2 = object.getDrawable(n13);
        this.shuffleOffButtonDrawable = object2;
        n13 = R$string.exo_controls_repeat_off_description;
        this.repeatOffButtonContentDescription = object2 = object.getString(n13);
        n13 = R$string.exo_controls_repeat_one_description;
        this.repeatOneButtonContentDescription = object2 = object.getString(n13);
        n13 = R$string.exo_controls_repeat_all_description;
        this.repeatAllButtonContentDescription = object2 = object.getString(n13);
        n13 = R$string.exo_controls_shuffle_on_description;
        this.shuffleOnContentDescription = object2 = object.getString(n13);
        n13 = R$string.exo_controls_shuffle_off_description;
        object = object.getString(n13);
        this.shuffleOffContentDescription = object;
    }

    public static /* synthetic */ void a(PlayerControlView playerControlView) {
        playerControlView.updateProgress();
    }

    public static /* synthetic */ void access$1000(PlayerControlView playerControlView) {
        playerControlView.updateShuffleButton();
    }

    public static /* synthetic */ boolean access$102(PlayerControlView playerControlView, boolean bl2) {
        playerControlView.scrubbing = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$1100(PlayerControlView playerControlView) {
        playerControlView.updateNavigation();
    }

    public static /* synthetic */ void access$1200(PlayerControlView playerControlView) {
        playerControlView.updateTimeline();
    }

    public static /* synthetic */ View access$1300(PlayerControlView playerControlView) {
        return playerControlView.nextButton;
    }

    public static /* synthetic */ ControlDispatcher access$1400(PlayerControlView playerControlView) {
        return playerControlView.controlDispatcher;
    }

    public static /* synthetic */ View access$1500(PlayerControlView playerControlView) {
        return playerControlView.previousButton;
    }

    public static /* synthetic */ View access$1600(PlayerControlView playerControlView) {
        return playerControlView.fastForwardButton;
    }

    public static /* synthetic */ View access$1700(PlayerControlView playerControlView) {
        return playerControlView.rewindButton;
    }

    public static /* synthetic */ View access$1800(PlayerControlView playerControlView) {
        return playerControlView.playButton;
    }

    public static /* synthetic */ void access$1900(PlayerControlView playerControlView, Player player) {
        playerControlView.dispatchPlay(player);
    }

    public static /* synthetic */ TextView access$200(PlayerControlView playerControlView) {
        return playerControlView.positionView;
    }

    public static /* synthetic */ View access$2000(PlayerControlView playerControlView) {
        return playerControlView.pauseButton;
    }

    public static /* synthetic */ void access$2100(PlayerControlView playerControlView, Player player) {
        playerControlView.dispatchPause(player);
    }

    public static /* synthetic */ ImageView access$2200(PlayerControlView playerControlView) {
        return playerControlView.repeatToggleButton;
    }

    public static /* synthetic */ int access$2300(PlayerControlView playerControlView) {
        return playerControlView.repeatToggleModes;
    }

    public static /* synthetic */ ImageView access$2400(PlayerControlView playerControlView) {
        return playerControlView.shuffleButton;
    }

    public static /* synthetic */ StringBuilder access$300(PlayerControlView playerControlView) {
        return playerControlView.formatBuilder;
    }

    public static /* synthetic */ Formatter access$400(PlayerControlView playerControlView) {
        return playerControlView.formatter;
    }

    public static /* synthetic */ Player access$500(PlayerControlView playerControlView) {
        return playerControlView.player;
    }

    public static /* synthetic */ void access$600(PlayerControlView playerControlView, Player player, long l10) {
        playerControlView.seekToTimeBarPosition(player, l10);
    }

    public static /* synthetic */ void access$700(PlayerControlView playerControlView) {
        playerControlView.updatePlayPauseButton();
    }

    public static /* synthetic */ void access$800(PlayerControlView playerControlView) {
        playerControlView.updateProgress();
    }

    public static /* synthetic */ void access$900(PlayerControlView playerControlView) {
        playerControlView.updateRepeatModeButton();
    }

    private static boolean canShowMultiWindowTimeBar(Timeline timeline, Timeline$Window timeline$Window) {
        int n10;
        int n11 = timeline.getWindowCount();
        if (n11 > (n10 = 100)) {
            return false;
        }
        n11 = timeline.getWindowCount();
        for (n10 = 0; n10 < n11; ++n10) {
            Timeline$Window timeline$Window2 = timeline.getWindow(n10, timeline$Window);
            long l10 = timeline$Window2.durationUs;
            long l11 = -9223372036854775807L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) continue;
            return false;
        }
        return true;
    }

    private void dispatchPause(Player player) {
        this.controlDispatcher.dispatchSetPlayWhenReady(player, false);
    }

    private void dispatchPlay(Player player) {
        int n10;
        int n11 = player.getPlaybackState();
        if (n11 == (n10 = 1)) {
            Object object = this.playbackPreparer;
            if (object != null) {
                object.preparePlayback();
            } else {
                object = this.controlDispatcher;
                object.dispatchPrepare(player);
            }
        } else {
            int n12 = 4;
            if (n11 == n12) {
                n11 = player.getCurrentWindowIndex();
                long l10 = -9223372036854775807L;
                this.seekTo(player, n11, l10);
            }
        }
        this.controlDispatcher.dispatchSetPlayWhenReady(player, n10 != 0);
    }

    private void dispatchPlayPause(Player player) {
        int n10;
        int n11 = player.getPlaybackState();
        if (n11 != (n10 = 1) && n11 != (n10 = 4) && (n11 = (int)(player.getPlayWhenReady() ? 1 : 0)) != 0) {
            this.dispatchPause(player);
        } else {
            this.dispatchPlay(player);
        }
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int n10) {
        int n11 = R$styleable.PlayerControlView_repeat_toggle_modes;
        return typedArray.getInt(n11, n10);
    }

    private void hideAfterTimeout() {
        Runnable runnable = this.hideAction;
        this.removeCallbacks(runnable);
        int n10 = this.showTimeoutMs;
        if (n10 > 0) {
            long l10 = SystemClock.uptimeMillis();
            int n11 = this.showTimeoutMs;
            long l11 = n11;
            this.hideAtMs = l10 += l11;
            n10 = (int)(this.isAttachedToWindow ? 1 : 0);
            if (n10 != 0) {
                runnable = this.hideAction;
                long l12 = n11;
                this.postDelayed(runnable, l12);
            }
        } else {
            long l13;
            this.hideAtMs = l13 = -9223372036854775807L;
        }
    }

    private static boolean isHandledMediaKey(int n10) {
        int n11 = 90;
        n10 = n10 != n11 && n10 != (n11 = 89) && n10 != (n11 = 85) && n10 != (n11 = 79) && n10 != (n11 = 126) && n10 != (n11 = 127) && n10 != (n11 = 87) && n10 != (n11 = 88) ? 0 : 1;
        return n10 != 0;
    }

    private void requestPlayPauseFocus() {
        View view;
        View view2;
        boolean bl2 = this.shouldShowPauseButton();
        if (!bl2 && (view2 = this.playButton) != null) {
            view2.requestFocus();
        } else if (bl2 && (view = this.pauseButton) != null) {
            view.requestFocus();
        }
    }

    private boolean seekTo(Player player, int n10, long l10) {
        return this.controlDispatcher.dispatchSeekTo(player, n10, l10);
    }

    private void seekToTimeBarPosition(Player player, long l10) {
        boolean bl2;
        int n10;
        block4: {
            Timeline timeline = player.getCurrentTimeline();
            int n11 = this.multiWindowTimeBar;
            if (n11 != 0 && (n11 = timeline.isEmpty()) == 0) {
                n11 = timeline.getWindowCount();
                n10 = 0;
                while (true) {
                    Timeline$Window timeline$Window = this.window;
                    long l11 = (timeline$Window = timeline.getWindow(n10, timeline$Window)).getDurationMs();
                    long l12 = l10 - l11;
                    Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object < 0) break block4;
                    object = n11 + -1;
                    if (n10 == object) {
                        l10 = l11;
                        break block4;
                    }
                    l10 -= l11;
                    ++n10;
                }
            }
            n10 = player.getCurrentWindowIndex();
        }
        if (!(bl2 = this.seekTo(player, n10, l10))) {
            this.updateProgress();
        }
    }

    private boolean shouldShowPauseButton() {
        int n10;
        int n11;
        Player player = this.player;
        int n12 = 1;
        if (player == null || (n11 = player.getPlaybackState()) == (n10 = 4) || (n11 = (player = this.player).getPlaybackState()) == n12 || (n11 = (int)((player = this.player).getPlayWhenReady() ? 1 : 0)) == 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private void updateAll() {
        this.updatePlayPauseButton();
        this.updateNavigation();
        this.updateRepeatModeButton();
        this.updateShuffleButton();
        this.updateTimeline();
    }

    private void updateButton(boolean n10, boolean bl2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(bl2);
        float f10 = bl2 ? this.buttonAlphaEnabled : this.buttonAlphaDisabled;
        view.setAlpha(f10);
        n10 = n10 != 0 ? 0 : 8;
        view.setVisibility(n10);
    }

    /*
     * WARNING - void declaration
     */
    private void updateNavigation() {
        block10: {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            Timeline$Window timeline$Window;
            Object object;
            boolean bl6;
            Object object2;
            boolean bl7;
            block15: {
                block11: {
                    block14: {
                        boolean bl5;
                        block13: {
                            block12: {
                                ControlDispatcher controlDispatcher;
                                ControlDispatcher controlDispatcher2;
                                boolean bl8;
                                boolean bl52;
                                bl7 = this.isVisible();
                                if (!bl7 || !(bl7 = this.isAttachedToWindow)) break block10;
                                object2 = this.player;
                                bl6 = false;
                                if (object2 == null || (bl52 = ((Timeline)(object = object2.getCurrentTimeline())).isEmpty()) || (bl8 = object2.isPlayingAd())) break block11;
                                int n10 = object2.getCurrentWindowIndex();
                                timeline$Window = this.window;
                                ((Timeline)object).getWindow(n10, timeline$Window);
                                object = this.window;
                                boolean bl9 = ((Timeline$Window)object).isSeekable;
                                bl5 = true;
                                float f10 = Float.MIN_VALUE;
                                if (!bl9 && (bl4 = ((Timeline$Window)object).isLive()) && !(bl4 = object2.hasPrevious())) {
                                    bl4 = false;
                                    object = null;
                                    float f11 = 0.0f;
                                } else {
                                    bl4 = bl5;
                                    float f12 = f10;
                                }
                                if (bl9 && (bl3 = (controlDispatcher2 = this.controlDispatcher).isRewindEnabled())) {
                                    bl3 = bl5;
                                } else {
                                    bl3 = false;
                                    controlDispatcher2 = null;
                                }
                                if (bl9 && (bl2 = (controlDispatcher = this.controlDispatcher).isFastForwardEnabled())) {
                                    bl2 = bl5;
                                } else {
                                    bl2 = false;
                                    controlDispatcher = null;
                                }
                                Timeline$Window timeline$Window2 = this.window;
                                boolean bl10 = timeline$Window2.isLive();
                                if (!bl10) break block12;
                                timeline$Window2 = this.window;
                                bl10 = timeline$Window2.isDynamic;
                                if (bl10) break block13;
                            }
                            if (!(bl7 = object2.hasNext())) break block14;
                        }
                        bl6 = bl5;
                    }
                    bl7 = bl6;
                    bl6 = bl4;
                    break block15;
                }
                bl7 = false;
                object2 = null;
                boolean bl11 = false;
                bl3 = false;
                Object var11_18 = null;
                bl2 = false;
                Object var13_21 = null;
            }
            bl4 = this.showPreviousButton;
            timeline$Window = this.previousButton;
            this.updateButton(bl4, bl6, (View)timeline$Window);
            bl6 = this.showRewindButton;
            object = this.rewindButton;
            this.updateButton(bl6, bl3, (View)object);
            bl6 = this.showFastForwardButton;
            object = this.fastForwardButton;
            this.updateButton(bl6, bl2, (View)object);
            bl6 = this.showNextButton;
            object = this.nextButton;
            this.updateButton(bl6, bl7, (View)object);
            object2 = this.timeBar;
            if (object2 != null) {
                void var5_10;
                object2.setEnabled((boolean)var5_10);
            }
        }
    }

    private void updatePlayPauseButton() {
        boolean bl2 = this.isVisible();
        if (bl2 && (bl2 = this.isAttachedToWindow)) {
            View view;
            boolean bl3;
            bl2 = this.shouldShowPauseButton();
            View view2 = this.playButton;
            int n10 = 8;
            boolean bl4 = true;
            if (view2 != null) {
                if (bl2 && (bl3 = view2.isFocused())) {
                    bl3 = bl4;
                } else {
                    bl3 = false;
                    view2 = null;
                }
                bl3 |= false;
                view = this.playButton;
                int n11 = bl2 ? n10 : 0;
                view.setVisibility(n11);
            } else {
                bl3 = false;
                view2 = null;
            }
            view = this.pauseButton;
            if (view != null) {
                View view3;
                boolean bl5;
                if (bl2 || !(bl5 = view.isFocused())) {
                    bl4 = false;
                    view3 = null;
                }
                bl3 |= bl4;
                view3 = this.pauseButton;
                if (bl2) {
                    n10 = 0;
                }
                view3.setVisibility(n10);
            }
            if (bl3) {
                this.requestPlayPauseFocus();
            }
        }
    }

    private void updateProgress() {
        int n10 = this.isVisible();
        if (n10 != 0 && (n10 = this.isAttachedToWindow) != 0) {
            boolean bl2;
            boolean bl3;
            long l10;
            long l11;
            Object object = this.player;
            long l12 = 0L;
            if (object != null) {
                l12 = this.currentWindowOffset;
                l11 = object.getContentPosition();
                l12 += l11;
                l11 = this.currentWindowOffset;
                l10 = object.getContentBufferedPosition();
                l11 += l10;
            } else {
                l11 = l12;
            }
            Object object2 = this.positionView;
            if (object2 != null && !(bl3 = this.scrubbing)) {
                CharSequence charSequence = this.formatBuilder;
                Formatter formatter = this.formatter;
                charSequence = Util.getStringForTime(charSequence, formatter, l12);
                object2.setText(charSequence);
            }
            if ((object2 = this.timeBar) != null) {
                object2.setPosition(l12);
                object2 = this.timeBar;
                object2.setBufferedPosition(l11);
            }
            if ((object2 = this.progressUpdateListener) != null) {
                object2.onProgressUpdate(l12, l11);
            }
            Object object3 = this.updateProgressAction;
            this.removeCallbacks((Runnable)object3);
            int n11 = 1;
            int n12 = object == null ? n11 : object.getPlaybackState();
            l10 = 1000L;
            if (object != null && (bl2 = object.isPlaying())) {
                object3 = this.timeBar;
                l11 = object3 != null ? object3.getPreferredUpdateDelay() : l10;
                l12 %= l10;
                l12 = l10 - l12;
                l12 = Math.min(l11, l12);
                object = object.getPlaybackParameters();
                float f10 = ((PlaybackParameters)object).speed;
                object3 = null;
                float f11 = f10 - 0.0f;
                n11 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
                if (n11 > 0) {
                    float f12 = (float)l12 / f10;
                    l10 = (long)f12;
                }
                n10 = this.timeBarMinUpdateIntervalMs;
                long l13 = n10;
                long l14 = 1000L;
                long l15 = Util.constrainValue(l10, l13, l14);
                Runnable runnable = this.updateProgressAction;
                this.postDelayed(runnable, l15);
            } else {
                n10 = 4;
                float f13 = 5.6E-45f;
                if (n12 != n10 && n12 != n11) {
                    object = this.updateProgressAction;
                    this.postDelayed((Runnable)object, l10);
                }
            }
        }
    }

    private void updateRepeatModeButton() {
        ImageView imageView;
        int n10 = this.isVisible();
        if (n10 != 0 && (n10 = this.isAttachedToWindow) != 0 && (imageView = this.repeatToggleButton) != null) {
            int n11 = this.repeatToggleModes;
            if (n11 == 0) {
                this.updateButton(false, false, (View)imageView);
                return;
            }
            Object object = this.player;
            int n12 = 1;
            if (object == null) {
                this.updateButton(n12 != 0, false, (View)imageView);
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonDrawable;
                imageView.setImageDrawable((Drawable)object);
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonContentDescription;
                imageView.setContentDescription((CharSequence)object);
                return;
            }
            this.updateButton(n12 != 0, n12 != 0, (View)imageView);
            n10 = object.getRepeatMode();
            if (n10 != 0) {
                if (n10 != n12) {
                    n11 = 2;
                    if (n10 == n11) {
                        imageView = this.repeatToggleButton;
                        object = this.repeatAllButtonDrawable;
                        imageView.setImageDrawable((Drawable)object);
                        imageView = this.repeatToggleButton;
                        object = this.repeatAllButtonContentDescription;
                        imageView.setContentDescription((CharSequence)object);
                    }
                } else {
                    imageView = this.repeatToggleButton;
                    object = this.repeatOneButtonDrawable;
                    imageView.setImageDrawable((Drawable)object);
                    imageView = this.repeatToggleButton;
                    object = this.repeatOneButtonContentDescription;
                    imageView.setContentDescription((CharSequence)object);
                }
            } else {
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonDrawable;
                imageView.setImageDrawable((Drawable)object);
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonContentDescription;
                imageView.setContentDescription((CharSequence)object);
            }
            imageView = this.repeatToggleButton;
            imageView.setVisibility(0);
        }
    }

    private void updateShuffleButton() {
        ImageView imageView;
        boolean bl2 = this.isVisible();
        if (bl2 && (bl2 = this.isAttachedToWindow) && (imageView = this.shuffleButton) != null) {
            Object object = this.player;
            boolean bl3 = this.showShuffleButton;
            if (!bl3) {
                this.updateButton(false, false, (View)imageView);
            } else {
                bl3 = true;
                if (object == null) {
                    this.updateButton(bl3, false, (View)imageView);
                    imageView = this.shuffleButton;
                    object = this.shuffleOffButtonDrawable;
                    imageView.setImageDrawable((Drawable)object);
                    imageView = this.shuffleButton;
                    object = this.shuffleOffContentDescription;
                    imageView.setContentDescription((CharSequence)object);
                } else {
                    this.updateButton(bl3, bl3, (View)imageView);
                    imageView = this.shuffleButton;
                    bl3 = object.getShuffleModeEnabled();
                    Drawable drawable2 = bl3 ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable;
                    imageView.setImageDrawable(drawable2);
                    imageView = this.shuffleButton;
                    boolean bl4 = object.getShuffleModeEnabled();
                    object = bl4 ? this.shuffleOnContentDescription : this.shuffleOffContentDescription;
                    imageView.setContentDescription((CharSequence)object);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void updateTimeline() {
        Object object;
        Object object2;
        int n10;
        int n11;
        long l10;
        Object object3;
        int n12;
        Object object4;
        PlayerControlView playerControlView;
        block19: {
            block16: {
                void var3_7;
                Timeline timeline;
                boolean bl2;
                playerControlView = this;
                object4 = this.player;
                if (object4 == null) {
                    return;
                }
                boolean n13 = this.showMultiWindowTimeBar;
                n12 = 1;
                if (n13 && (bl2 = PlayerControlView.canShowMultiWindowTimeBar(timeline = object4.getCurrentTimeline(), (Timeline$Window)(object3 = this.window)))) {
                    int n14 = n12;
                } else {
                    boolean bl3 = false;
                    timeline = null;
                }
                playerControlView.multiWindowTimeBar = var3_7;
                playerControlView.currentWindowOffset = l10 = 0L;
                timeline = object4.getCurrentTimeline();
                int n15 = timeline.isEmpty();
                if (n15 != 0) break block16;
                n11 = object4.getCurrentWindowIndex();
                n15 = playerControlView.multiWindowTimeBar;
                int n16 = n15 != 0 ? 0 : n11;
                n15 = n15 != 0 ? timeline.getWindowCount() - n12 : n11;
                long l11 = l10;
                n10 = 0;
                while (n16 <= n15) {
                    long l12;
                    Object object5;
                    if (n16 == n11) {
                        long l13;
                        playerControlView.currentWindowOffset = l13 = C.usToMs(l11);
                    }
                    Timeline$Window timeline$Window = playerControlView.window;
                    timeline.getWindow(n16, timeline$Window);
                    timeline$Window = playerControlView.window;
                    long l14 = timeline$Window.durationUs;
                    long l15 = -9223372036854775807L;
                    long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
                    if (l16 == false) {
                        n11 = playerControlView.multiWindowTimeBar ^ n12;
                        Assertions.checkState(n11 != 0);
                        break;
                    }
                    int n17 = timeline$Window.firstPeriodIndex;
                    while (true) {
                        object5 = playerControlView.window;
                        int n18 = ((Timeline$Window)object5).lastPeriodIndex;
                        if (n17 > n18) break;
                        object5 = playerControlView.period;
                        timeline.getPeriod(n17, (Timeline$Period)object5);
                        object5 = playerControlView.period;
                        l16 = ((Timeline$Period)object5).getAdGroupCount();
                        for (n18 = 0; n18 < l16; ++n18) {
                            block18: {
                                long l17;
                                long l18;
                                long l19;
                                block17: {
                                    long l20;
                                    object2 = playerControlView.period;
                                    l19 = ((Timeline$Period)object2).getAdGroupTimeUs(n18);
                                    long l21 = l19 - (l20 = Long.MIN_VALUE);
                                    n12 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                                    if (n12 != 0) break block17;
                                    object2 = playerControlView.period;
                                    l12 = ((Timeline$Period)object2).durationUs;
                                    long l22 = l12 - l15;
                                    Object object6 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                                    if (object6 == false) break block18;
                                    l19 = l12;
                                }
                                if ((l18 = (l17 = (l19 += (l12 = (object = playerControlView.period).getPositionInWindowUs())) - l10) == 0L ? 0 : (l17 < 0L ? -1 : 1)) >= 0) {
                                    object = playerControlView.adGroupTimesMs;
                                    n12 = ((TextView)object).length;
                                    if (n10 == n12) {
                                        n12 = ((TextView)object).length;
                                        n12 = n12 == 0 ? 1 : ((TextView)object).length * 2;
                                        object = Arrays.copyOf((long[])object, n12);
                                        playerControlView.adGroupTimesMs = (long[])object;
                                        object = Arrays.copyOf(playerControlView.playedAdGroups, n12);
                                        playerControlView.playedAdGroups = (boolean[])object;
                                    }
                                    object = playerControlView.adGroupTimesMs;
                                    l19 = C.usToMs(l11 + l19);
                                    object[n10] = (TextView)l19;
                                    object = playerControlView.playedAdGroups;
                                    object2 = playerControlView.period;
                                    n12 = (int)(((Timeline$Period)object2).hasPlayedAdGroup(n18) ? 1 : 0);
                                    object[n10] = (TextView)n12;
                                    ++n10;
                                }
                            }
                            n12 = 1;
                        }
                        ++n17;
                        n12 = 1;
                    }
                    l12 = ((Timeline$Window)object5).durationUs;
                    l11 += l12;
                    ++n16;
                    n12 = 1;
                }
                l10 = l11;
                break block19;
            }
            n10 = 0;
        }
        long l23 = C.usToMs(l10);
        object = playerControlView.durationView;
        if (object != null) {
            object2 = playerControlView.formatBuilder;
            object3 = playerControlView.formatter;
            object2 = Util.getStringForTime((StringBuilder)object2, (Formatter)object3, l23);
            object.setText((CharSequence)object2);
        }
        if ((object = playerControlView.timeBar) != null) {
            object.setDuration(l23);
            object4 = playerControlView.extraAdGroupTimesMs;
            n11 = ((Object)object4).length;
            int n19 = n10 + n11;
            object = playerControlView.adGroupTimesMs;
            n12 = ((TextView)object).length;
            if (n19 > n12) {
                object = Arrays.copyOf((long[])object, n19);
                playerControlView.adGroupTimesMs = (long[])object;
                object = Arrays.copyOf(playerControlView.playedAdGroups, n19);
                playerControlView.playedAdGroups = (boolean[])object;
            }
            object = playerControlView.extraAdGroupTimesMs;
            object2 = playerControlView.adGroupTimesMs;
            object3 = null;
            System.arraycopy(object, 0, object2, n10, n11);
            object = playerControlView.extraPlayedAdGroups;
            object2 = playerControlView.playedAdGroups;
            System.arraycopy(object, 0, object2, n10, n11);
            object4 = playerControlView.timeBar;
            object = playerControlView.adGroupTimesMs;
            object2 = playerControlView.playedAdGroups;
            object4.setAdGroupTimesMs((long[])object, (boolean[])object2, n19);
        }
        this.updateProgress();
    }

    public void addVisibilityListener(PlayerControlView$VisibilityListener playerControlView$VisibilityListener) {
        Assertions.checkNotNull(playerControlView$VisibilityListener);
        this.visibilityListeners.add(playerControlView$VisibilityListener);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        boolean bl3 = this.dispatchMediaKeyEvent(keyEvent);
        if (!bl3 && !(bl2 = super.dispatchKeyEvent(keyEvent))) {
            bl2 = false;
            keyEvent = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent object) {
        int n10;
        int n11 = object.getKeyCode();
        Player player = this.player;
        if (player != null && (n10 = PlayerControlView.isHandledMediaKey(n11)) != 0) {
            n10 = object.getAction();
            if (n10 == 0) {
                n10 = 90;
                if (n11 == n10) {
                    int n12 = player.getPlaybackState();
                    if (n12 != (n11 = 4)) {
                        object = this.controlDispatcher;
                        object.dispatchFastForward(player);
                    }
                } else {
                    n10 = 89;
                    if (n11 == n10) {
                        object = this.controlDispatcher;
                        object.dispatchRewind(player);
                    } else {
                        int n13 = object.getRepeatCount();
                        if (n13 == 0) {
                            n13 = 79;
                            if (n11 != n13 && n11 != (n13 = 85)) {
                                n13 = 87;
                                if (n11 != n13) {
                                    n13 = 88;
                                    if (n11 != n13) {
                                        n13 = 126;
                                        if (n11 != n13) {
                                            n13 = 127;
                                            if (n11 == n13) {
                                                this.dispatchPause(player);
                                            }
                                        } else {
                                            this.dispatchPlay(player);
                                        }
                                    } else {
                                        object = this.controlDispatcher;
                                        object.dispatchPrevious(player);
                                    }
                                } else {
                                    object = this.controlDispatcher;
                                    object.dispatchNext(player);
                                }
                            } else {
                                this.dispatchPlayPause(player);
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            Runnable runnable = this.hideAction;
            this.removeCallbacks(runnable);
        } else {
            int n11;
            n10 = motionEvent.getAction();
            if (n10 == (n11 = 1)) {
                this.hideAfterTimeout();
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        return this.showShuffleButton;
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        boolean bl2;
        View view = this.vrButton;
        if (view != null && !(bl2 = view.getVisibility())) {
            bl2 = true;
        } else {
            bl2 = false;
            view = null;
        }
        return bl2;
    }

    public void hide() {
        int n10 = this.isVisible();
        if (n10 != 0) {
            long l10;
            boolean bl2;
            n10 = 8;
            this.setVisibility(n10);
            Object object = this.visibilityListeners.iterator();
            while (bl2 = object.hasNext()) {
                PlayerControlView$VisibilityListener playerControlView$VisibilityListener = (PlayerControlView$VisibilityListener)object.next();
                int n11 = this.getVisibility();
                playerControlView$VisibilityListener.onVisibilityChange(n11);
            }
            object = this.updateProgressAction;
            this.removeCallbacks((Runnable)object);
            object = this.hideAction;
            this.removeCallbacks((Runnable)object);
            this.hideAtMs = l10 = -9223372036854775807L;
        }
    }

    public boolean isVisible() {
        int n10 = this.getVisibility();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void onAttachedToWindow() {
        boolean bl2;
        super.onAttachedToWindow();
        this.isAttachedToWindow = bl2 = true;
        long l10 = this.hideAtMs;
        long l11 = -9223372036854775807L;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object != false) {
            l11 = SystemClock.uptimeMillis();
            long l12 = (l10 -= l11) - (l11 = 0L);
            object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object <= 0) {
                this.hide();
            } else {
                Runnable runnable = this.hideAction;
                this.postDelayed(runnable, l10);
            }
        } else {
            bl2 = this.isVisible();
            if (bl2) {
                this.hideAfterTimeout();
            }
        }
        this.updateAll();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        Runnable runnable = this.updateProgressAction;
        this.removeCallbacks(runnable);
        runnable = this.hideAction;
        this.removeCallbacks(runnable);
    }

    public void removeVisibilityListener(PlayerControlView$VisibilityListener playerControlView$VisibilityListener) {
        this.visibilityListeners.remove(playerControlView$VisibilityListener);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        ControlDispatcher controlDispatcher2 = this.controlDispatcher;
        if (controlDispatcher2 != controlDispatcher) {
            this.controlDispatcher = controlDispatcher;
            this.updateNavigation();
        }
    }

    public void setExtraAdGroupMarkers(long[] objectArray, boolean[] blArray) {
        boolean bl2 = false;
        if (objectArray == null) {
            objectArray = new long[]{};
            this.extraAdGroupTimesMs = objectArray;
            objectArray = new boolean[0];
            this.extraPlayedAdGroups = (boolean[])objectArray;
        } else {
            int n10 = objectArray.length;
            int n11 = (blArray = (boolean[])Assertions.checkNotNull(blArray)).length;
            if (n10 == n11) {
                bl2 = true;
            }
            Assertions.checkArgument(bl2);
            this.extraAdGroupTimesMs = objectArray;
            this.extraPlayedAdGroups = blArray;
        }
        this.updateTimeline();
    }

    public void setFastForwardIncrementMs(int n10) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        boolean bl2 = controlDispatcher instanceof DefaultControlDispatcher;
        if (bl2) {
            controlDispatcher = (DefaultControlDispatcher)controlDispatcher;
            long l10 = n10;
            ((DefaultControlDispatcher)controlDispatcher).setFastForwardIncrementMs(l10);
            this.updateNavigation();
        }
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        this.playbackPreparer = playbackPreparer;
    }

    public void setPlayer(Player player) {
        boolean bl2;
        Object object = Looper.myLooper();
        Object object2 = Looper.getMainLooper();
        boolean bl3 = true;
        if (object == object2) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        if (player != null && (object = player.getApplicationLooper()) != (object2 = Looper.getMainLooper())) {
            bl3 = false;
        }
        Assertions.checkArgument(bl3);
        object = this.player;
        if (object == player) {
            return;
        }
        if (object != null) {
            object2 = this.componentListener;
            object.removeListener((Player$EventListener)object2);
        }
        this.player = player;
        if (player != null) {
            object = this.componentListener;
            player.addListener((Player$EventListener)object);
        }
        this.updateAll();
    }

    public void setProgressUpdateListener(PlayerControlView$ProgressUpdateListener playerControlView$ProgressUpdateListener) {
        this.progressUpdateListener = playerControlView$ProgressUpdateListener;
    }

    public void setRepeatToggleModes(int n10) {
        this.repeatToggleModes = n10;
        Player player = this.player;
        if (player != null) {
            int n11 = player.getRepeatMode();
            if (n10 == 0 && n11 != 0) {
                ControlDispatcher controlDispatcher = this.controlDispatcher;
                player = this.player;
                boolean bl2 = false;
                controlDispatcher.dispatchSetRepeatMode(player, 0);
            } else {
                int n12 = 2;
                int n13 = 1;
                if (n10 == n13 && n11 == n12) {
                    ControlDispatcher controlDispatcher = this.controlDispatcher;
                    player = this.player;
                    controlDispatcher.dispatchSetRepeatMode(player, n13);
                } else if (n10 == n12 && n11 == n13) {
                    ControlDispatcher controlDispatcher = this.controlDispatcher;
                    player = this.player;
                    controlDispatcher.dispatchSetRepeatMode(player, n12);
                }
            }
        }
        this.updateRepeatModeButton();
    }

    public void setRewindIncrementMs(int n10) {
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        boolean bl2 = controlDispatcher instanceof DefaultControlDispatcher;
        if (bl2) {
            controlDispatcher = (DefaultControlDispatcher)controlDispatcher;
            long l10 = n10;
            ((DefaultControlDispatcher)controlDispatcher).setRewindIncrementMs(l10);
            this.updateNavigation();
        }
    }

    public void setShowFastForwardButton(boolean bl2) {
        this.showFastForwardButton = bl2;
        this.updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean bl2) {
        this.showMultiWindowTimeBar = bl2;
        this.updateTimeline();
    }

    public void setShowNextButton(boolean bl2) {
        this.showNextButton = bl2;
        this.updateNavigation();
    }

    public void setShowPreviousButton(boolean bl2) {
        this.showPreviousButton = bl2;
        this.updateNavigation();
    }

    public void setShowRewindButton(boolean bl2) {
        this.showRewindButton = bl2;
        this.updateNavigation();
    }

    public void setShowShuffleButton(boolean bl2) {
        this.showShuffleButton = bl2;
        this.updateShuffleButton();
    }

    public void setShowTimeoutMs(int n10) {
        this.showTimeoutMs = n10;
        n10 = (int)(this.isVisible() ? 1 : 0);
        if (n10 != 0) {
            this.hideAfterTimeout();
        }
    }

    public void setShowVrButton(boolean n10) {
        View view = this.vrButton;
        if (view != null) {
            n10 = n10 != 0 ? 0 : 8;
            view.setVisibility(n10);
        }
    }

    public void setTimeBarMinUpdateInterval(int n10) {
        this.timeBarMinUpdateIntervalMs = n10 = Util.constrainValue(n10, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            boolean bl2;
            view.setOnClickListener(onClickListener);
            boolean bl3 = this.getShowVrButton();
            if (onClickListener != null) {
                bl2 = true;
            } else {
                bl2 = false;
                onClickListener = null;
            }
            View view2 = this.vrButton;
            this.updateButton(bl3, bl2, view2);
        }
    }

    public void show() {
        boolean bl2 = this.isVisible();
        if (!bl2) {
            boolean bl3;
            bl2 = false;
            this.setVisibility(0);
            Iterator iterator2 = this.visibilityListeners.iterator();
            while (bl3 = iterator2.hasNext()) {
                PlayerControlView$VisibilityListener playerControlView$VisibilityListener = (PlayerControlView$VisibilityListener)iterator2.next();
                int n10 = this.getVisibility();
                playerControlView$VisibilityListener.onVisibilityChange(n10);
            }
            this.updateAll();
            this.requestPlayPauseFocus();
        }
        this.hideAfterTimeout();
    }
}

