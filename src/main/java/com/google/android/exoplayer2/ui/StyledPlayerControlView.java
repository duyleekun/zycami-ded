/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.DefaultControlDispatcher;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.DefaultTimeBar;
import com.google.android.exoplayer2.ui.DefaultTrackNameProvider;
import com.google.android.exoplayer2.ui.R$array;
import com.google.android.exoplayer2.ui.R$dimen;
import com.google.android.exoplayer2.ui.R$drawable;
import com.google.android.exoplayer2.ui.R$font;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.R$integer;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.R$plurals;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.R$style;
import com.google.android.exoplayer2.ui.R$styleable;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$AudioTrackSelectionAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$ComponentListener;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$OnFullScreenModeChangedListener;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$ProgressUpdateListener;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$SettingsAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$SubSettingsAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TextTrackSelectionAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackInfo;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$TrackSelectionAdapter;
import com.google.android.exoplayer2.ui.StyledPlayerControlView$VisibilityListener;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.ui.TrackNameProvider;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.p0.n;
import d.h.a.a.p0.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;

public class StyledPlayerControlView
extends FrameLayout {
    public static final int DEFAULT_REPEAT_TOGGLE_MODES = 0;
    public static final int DEFAULT_SHOW_TIMEOUT_MS = 5000;
    public static final int DEFAULT_TIME_BAR_MIN_UPDATE_INTERVAL_MS = 200;
    private static final int MAX_UPDATE_INTERVAL_MS = 1000;
    public static final int MAX_WINDOWS_FOR_MULTI_WINDOW_TIME_BAR = 100;
    private static final int SETTINGS_AUDIO_TRACK_SELECTION_POSITION = 1;
    private static final int SETTINGS_PLAYBACK_SPEED_POSITION;
    private long[] adGroupTimesMs;
    private StyledPlayerControlView$TrackSelectionAdapter audioTrackSelectionAdapter;
    private final float buttonAlphaDisabled;
    private final float buttonAlphaEnabled;
    private final StyledPlayerControlView$ComponentListener componentListener;
    private ControlDispatcher controlDispatcher;
    private StyledPlayerControlViewLayoutManager controlViewLayoutManager;
    private long currentWindowOffset;
    private final TextView durationView;
    private long[] extraAdGroupTimesMs;
    private boolean[] extraPlayedAdGroups;
    private final View fastForwardButton;
    private final TextView fastForwardButtonTextView;
    private long fastForwardMs;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private ImageView fullScreenButton;
    private final String fullScreenEnterContentDescription;
    private final Drawable fullScreenEnterDrawable;
    private final String fullScreenExitContentDescription;
    private final Drawable fullScreenExitDrawable;
    private boolean isAttachedToWindow;
    private boolean isFullScreen;
    private ImageView minimalFullScreenButton;
    private boolean multiWindowTimeBar;
    private boolean needToHideBars;
    private final View nextButton;
    private StyledPlayerControlView$OnFullScreenModeChangedListener onFullScreenModeChangedListener;
    private final Timeline$Period period;
    private final View playPauseButton;
    private PlaybackPreparer playbackPreparer;
    private String[] playbackSpeedTexts;
    private int[] playbackSpeedsMultBy100;
    private boolean[] playedAdGroups;
    private Player player;
    private final TextView positionView;
    private final View previousButton;
    private StyledPlayerControlView$ProgressUpdateListener progressUpdateListener;
    private final String repeatAllButtonContentDescription;
    private final Drawable repeatAllButtonDrawable;
    private final String repeatOffButtonContentDescription;
    private final Drawable repeatOffButtonDrawable;
    private final String repeatOneButtonContentDescription;
    private final Drawable repeatOneButtonDrawable;
    private final ImageView repeatToggleButton;
    private int repeatToggleModes;
    private Resources resources;
    private final View rewindButton;
    private final TextView rewindButtonTextView;
    private long rewindMs;
    private boolean scrubbing;
    private int selectedMainSettingsPosition;
    private int selectedPlaybackSpeedIndex;
    private StyledPlayerControlView$SettingsAdapter settingsAdapter;
    private View settingsButton;
    private RecyclerView settingsView;
    private PopupWindow settingsWindow;
    private int settingsWindowMargin;
    private boolean showMultiWindowTimeBar;
    private int showTimeoutMs;
    private final ImageView shuffleButton;
    private final Drawable shuffleOffButtonDrawable;
    private final String shuffleOffContentDescription;
    private final Drawable shuffleOnButtonDrawable;
    private final String shuffleOnContentDescription;
    private StyledPlayerControlView$SubSettingsAdapter subSettingsAdapter;
    private ImageView subtitleButton;
    private final Drawable subtitleOffButtonDrawable;
    private final String subtitleOffContentDescription;
    private final Drawable subtitleOnButtonDrawable;
    private final String subtitleOnContentDescription;
    private StyledPlayerControlView$TrackSelectionAdapter textTrackSelectionAdapter;
    private final TimeBar timeBar;
    private int timeBarMinUpdateIntervalMs;
    private TrackNameProvider trackNameProvider;
    private DefaultTrackSelector trackSelector;
    private final Runnable updateProgressAction;
    private final CopyOnWriteArrayList visibilityListeners;
    private final View vrButton;
    private final Timeline$Window window;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.ui");
    }

    public StyledPlayerControlView(Context context) {
        this(context, null);
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, attributeSet);
    }

    /*
     * WARNING - void declaration
     */
    public StyledPlayerControlView(Context context, AttributeSet attributeSet, int n10, AttributeSet attributeSet2) {
        void var29_72;
        int n11;
        AttributeSet attributeSet3;
        boolean bl2;
        void var40_82;
        void var23_50;
        StyledPlayerControlView$ComponentListener styledPlayerControlView$ComponentListener;
        void var25_65;
        boolean bl3;
        boolean bl4;
        boolean bl5;
        boolean bl6;
        boolean bl7;
        Object object;
        Object object2;
        long l10;
        StyledPlayerControlView styledPlayerControlView = this;
        Object object3 = attributeSet2;
        super(context, attributeSet, n10);
        int n112 = R$layout.exo_styled_player_control_view;
        this.rewindMs = 5000L;
        this.fastForwardMs = l10 = 15000L;
        this.showTimeoutMs = 5000;
        boolean bl14 = false;
        Object object4 = null;
        this.repeatToggleModes = 0;
        int n12 = 200;
        float f10 = 2.8E-43f;
        this.timeBarMinUpdateIntervalMs = n12;
        boolean bl15 = true;
        if (attributeSet2 != null) {
            object2 = context.getTheme();
            object = R$styleable.StyledPlayerControlView;
            object2 = object2.obtainStyledAttributes(attributeSet2, object, 0, 0);
            int bl13 = R$styleable.StyledPlayerControlView_rewind_increment;
            long l11 = this.rewindMs;
            int n13 = (int)l11;
            int n14 = object2.getInt(bl13, n13);
            long l12 = n14;
            this.rewindMs = l12;
            int n15 = R$styleable.StyledPlayerControlView_fastforward_increment;
            l11 = this.fastForwardMs;
            int n16 = (int)l11;
            int n17 = object2.getInt(n15, n16);
            l12 = n17;
            try {
                int n18;
                int n19;
                this.fastForwardMs = l12;
                int n20 = R$styleable.StyledPlayerControlView_controller_layout_id;
                n112 = object2.getResourceId(n20, n112);
                int n21 = R$styleable.StyledPlayerControlView_show_timeout;
                int n22 = this.showTimeoutMs;
                this.showTimeoutMs = n19 = object2.getInt(n21, n22);
                int n23 = this.repeatToggleModes;
                this.repeatToggleModes = n18 = StyledPlayerControlView.getRepeatToggleModes((TypedArray)object2, n23);
                int n24 = R$styleable.StyledPlayerControlView_show_rewind_button;
                boolean bl8 = object2.getBoolean(n24, bl15);
                int n25 = R$styleable.StyledPlayerControlView_show_fastforward_button;
                boolean bl9 = object2.getBoolean(n25, bl15);
                int n26 = R$styleable.StyledPlayerControlView_show_previous_button;
                boolean bl10 = object2.getBoolean(n26, bl15);
                bl7 = R$styleable.StyledPlayerControlView_show_next_button;
                bl7 = object2.getBoolean((int)(bl7 ? 1 : 0), bl15);
                int n27 = R$styleable.StyledPlayerControlView_show_shuffle_button;
                boolean bl11 = object2.getBoolean(n27, false);
                bl6 = R$styleable.StyledPlayerControlView_show_subtitle_button;
                bl6 = object2.getBoolean((int)(bl6 ? 1 : 0), false);
                bl5 = R$styleable.StyledPlayerControlView_show_vr_button;
                bl5 = object2.getBoolean((int)(bl5 ? 1 : 0), false);
                bl4 = R$styleable.StyledPlayerControlView_time_bar_min_update_interval;
                int n28 = this.timeBarMinUpdateIntervalMs;
                bl4 = object2.getInt((int)(bl4 ? 1 : 0), n28);
                this.setTimeBarMinUpdateInterval((int)(bl4 ? 1 : 0));
                bl4 = R$styleable.StyledPlayerControlView_animation_enabled;
                bl4 = object2.getBoolean((int)(bl4 ? 1 : 0), bl15);
                boolean bl12 = bl11;
                bl3 = bl6;
                boolean bl16 = bl8;
                bl6 = bl9;
                boolean bl17 = bl5;
                bl5 = bl10;
                boolean bl18 = bl4;
                bl4 = bl7;
                bl7 = bl17;
            }
            finally {
                object2.recycle();
            }
        } else {
            bl7 = false;
            boolean bl19 = false;
            bl3 = false;
            boolean bl20 = bl15;
            boolean bl21 = bl15;
            bl6 = bl15;
            bl5 = bl15;
            bl4 = bl15;
        }
        LayoutInflater.from((Context)context).inflate(n112, (ViewGroup)styledPlayerControlView);
        float f11 = 3.67342E-40f;
        styledPlayerControlView.setDescendantFocusability(262144);
        boolean bl22 = false;
        Object object5 = new StyledPlayerControlView$ComponentListener(styledPlayerControlView, null);
        styledPlayerControlView.componentListener = object5;
        Object object6 = new CopyOnWriteArrayList();
        styledPlayerControlView.visibilityListeners = object6;
        styledPlayerControlView.period = object6 = new Timeline$Period();
        styledPlayerControlView.window = object6 = new Timeline$Window();
        styledPlayerControlView.formatBuilder = object6 = new StringBuilder();
        object = Locale.getDefault();
        super((Appendable)object6, (Locale)object);
        styledPlayerControlView.formatter = object2;
        object6 = new long[0];
        styledPlayerControlView.adGroupTimesMs = (long[])object6;
        object6 = new boolean[0];
        styledPlayerControlView.playedAdGroups = (boolean[])object6;
        object6 = new long[0];
        styledPlayerControlView.extraAdGroupTimesMs = (long[])object6;
        object6 = new boolean[0];
        styledPlayerControlView.extraPlayedAdGroups = (boolean[])object6;
        l10 = styledPlayerControlView.fastForwardMs;
        void var35_78 = var25_65;
        long l13 = styledPlayerControlView.rewindMs;
        styledPlayerControlView.controlDispatcher = object6 = new DefaultControlDispatcher(l10, l13);
        styledPlayerControlView.updateProgressAction = object6 = new n(styledPlayerControlView);
        n112 = R$id.exo_duration;
        object6 = (TextView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.durationView = object6;
        n112 = R$id.exo_position;
        object6 = (TextView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.positionView = object6;
        n112 = R$id.exo_subtitle;
        object6 = (ImageView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.subtitleButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object5);
        }
        n112 = R$id.exo_fullscreen;
        object6 = (ImageView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.fullScreenButton = object6;
        super(styledPlayerControlView);
        StyledPlayerControlView.initializeFullScreenButton((View)object6, (View.OnClickListener)object2);
        n112 = R$id.exo_minimal_fullscreen;
        object6 = (ImageView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.minimalFullScreenButton = object6;
        super(styledPlayerControlView);
        StyledPlayerControlView.initializeFullScreenButton((View)object6, (View.OnClickListener)object2);
        n112 = R$id.exo_settings;
        object6 = styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.settingsButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object5);
        }
        bl15 = R$id.exo_progress;
        object6 = (TimeBar)styledPlayerControlView.findViewById((int)(bl15 ? 1 : 0));
        n12 = R$id.exo_progress_placeholder;
        View view = styledPlayerControlView.findViewById(n12);
        if (object6 != null) {
            styledPlayerControlView.timeBar = object6;
            styledPlayerControlView$ComponentListener = object5;
            var40_82 = var23_50;
            bl2 = bl7;
        } else if (view != null) {
            object = new DefaultTimeBar;
            boolean bl23 = R$style.ExoStyledControls_TimeBar;
            object6 = object;
            object2 = context;
            object4 = object;
            boolean bl24 = false;
            object = null;
            styledPlayerControlView$ComponentListener = object5;
            boolean bl25 = false;
            object5 = null;
            var40_82 = var23_50;
            attributeSet3 = attributeSet2;
            bl2 = bl7;
            bl7 = bl23;
            object6 = new DefaultTimeBar(context, null, 0, attributeSet2, (int)(bl23 ? 1 : 0));
            object6.setId((int)(bl15 ? 1 : 0));
            object6 = view.getLayoutParams();
            object4.setLayoutParams((ViewGroup.LayoutParams)object6);
            object6 = (ViewGroup)view.getParent();
            n12 = object6.indexOfChild(view);
            object6.removeView(view);
            object6.addView((View)object4, n12);
            styledPlayerControlView.timeBar = object4;
        } else {
            styledPlayerControlView$ComponentListener = object5;
            var40_82 = var23_50;
            bl2 = bl7;
            n112 = 0;
            f11 = 0.0f;
            object6 = null;
            styledPlayerControlView.timeBar = null;
        }
        object6 = styledPlayerControlView.timeBar;
        object2 = styledPlayerControlView$ComponentListener;
        if (object6 != null) {
            object6.addListener(styledPlayerControlView$ComponentListener);
        }
        n112 = R$id.exo_play_pause;
        object6 = styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.playPauseButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object2);
        }
        n112 = R$id.exo_prev;
        object6 = styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.previousButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object2);
        }
        n112 = R$id.exo_next;
        object6 = styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.nextButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object2);
        }
        n112 = R$font.roboto_medium_numbers;
        object = context;
        object6 = ResourcesCompat.getFont(context, n112);
        int n29 = R$id.exo_rew;
        object5 = styledPlayerControlView.findViewById(n29);
        if (object5 == null) {
            int n30 = R$id.exo_rew_with_amount;
            attributeSet3 = (TextView)styledPlayerControlView.findViewById(n30);
        } else {
            boolean bl26 = false;
            attributeSet3 = null;
        }
        styledPlayerControlView.rewindButtonTextView = attributeSet3;
        if (attributeSet3 != null) {
            attributeSet3.setTypeface((Typeface)object6);
        }
        if (object5 == null) {
            object5 = attributeSet3;
        }
        styledPlayerControlView.rewindButton = object5;
        if (object5 != null) {
            object5.setOnClickListener((View.OnClickListener)object2);
        }
        if ((object5 = styledPlayerControlView.findViewById(n11 = R$id.exo_ffwd)) == null) {
            int n31 = R$id.exo_ffwd_with_amount;
            attributeSet3 = (TextView)styledPlayerControlView.findViewById(n31);
        } else {
            boolean bl27 = false;
            attributeSet3 = null;
        }
        styledPlayerControlView.fastForwardButtonTextView = attributeSet3;
        if (attributeSet3 != null) {
            attributeSet3.setTypeface((Typeface)object6);
        }
        if (object5 == null) {
            object5 = attributeSet3;
        }
        styledPlayerControlView.fastForwardButton = object5;
        if (object5 != null) {
            object5.setOnClickListener((View.OnClickListener)object2);
        }
        n112 = R$id.exo_repeat_toggle;
        object6 = (ImageView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.repeatToggleButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object2);
        }
        n112 = R$id.exo_shuffle;
        object6 = (ImageView)styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.shuffleButton = object6;
        if (object6 != null) {
            object6.setOnClickListener((View.OnClickListener)object2);
        }
        object6 = context.getResources();
        styledPlayerControlView.resources = object6;
        n12 = R$integer.exo_media_button_opacity_percentage_enabled;
        f11 = object6.getInteger(n12);
        n12 = 1120403456;
        f10 = 100.0f;
        styledPlayerControlView.buttonAlphaEnabled = f11 /= f10;
        object6 = styledPlayerControlView.resources;
        int n32 = R$integer.exo_media_button_opacity_percentage_disabled;
        styledPlayerControlView.buttonAlphaDisabled = f11 = (float)object6.getInteger(n32) / f10;
        n112 = R$id.exo_vr;
        object6 = styledPlayerControlView.findViewById(n112);
        styledPlayerControlView.vrButton = object6;
        if (object6 != null) {
            n12 = 0;
            f10 = 0.0f;
            object2 = null;
            styledPlayerControlView.updateButton(false, (View)object6);
        }
        styledPlayerControlView.controlViewLayoutManager = object6 = new StyledPlayerControlViewLayoutManager(styledPlayerControlView);
        bl15 = var40_82;
        ((StyledPlayerControlViewLayoutManager)object6).setAnimationEnabled((boolean)var40_82);
        n112 = 2;
        f11 = 2.8E-45f;
        object2 = new String[n112];
        object6 = new Drawable[n112];
        object5 = styledPlayerControlView.resources;
        int n33 = R$string.exo_controls_playback_speed;
        object5 = object5.getString(n33);
        attributeSet3 = null;
        object2[0] = object5;
        object5 = styledPlayerControlView.resources;
        bl7 = R$drawable.exo_styled_controls_speed;
        object5 = object5.getDrawable((int)(bl7 ? 1 : 0));
        object6[0] = object5;
        object5 = styledPlayerControlView.resources;
        int n34 = R$string.exo_track_selection_title_audio;
        object5 = object5.getString(n34);
        int n35 = 1;
        object2[n35] = object5;
        object5 = styledPlayerControlView.resources;
        bl7 = R$drawable.exo_styled_controls_audiotrack;
        object5 = object5.getDrawable((int)(bl7 ? 1 : 0));
        object6[n35] = object5;
        styledPlayerControlView.settingsAdapter = object5 = new StyledPlayerControlView$SettingsAdapter(styledPlayerControlView, (String[])object2, (Drawable[])object6);
        object6 = styledPlayerControlView.resources;
        n12 = R$array.exo_playback_speeds;
        object6 = object6.getStringArray(n12);
        styledPlayerControlView.playbackSpeedTexts = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$array.exo_speed_multiplied_by_100;
        object6 = object6.getIntArray(n12);
        styledPlayerControlView.playbackSpeedsMultBy100 = (int[])object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$dimen.exo_settings_offset;
        styledPlayerControlView.settingsWindowMargin = n112 = object6.getDimensionPixelSize(n12);
        super(styledPlayerControlView);
        styledPlayerControlView.subSettingsAdapter = object6;
        object6 = LayoutInflater.from((Context)context);
        n12 = R$layout.exo_styled_settings_list;
        object6 = (RecyclerView)object6.inflate(n12, null);
        styledPlayerControlView.settingsView = object6;
        object2 = styledPlayerControlView.settingsAdapter;
        ((RecyclerView)object6).setAdapter((RecyclerView$Adapter)object2);
        object6 = styledPlayerControlView.settingsView;
        object = this.getContext();
        super((Context)object);
        ((RecyclerView)object6).setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = styledPlayerControlView.settingsView;
        int n36 = -2;
        boolean bl28 = true;
        object6 = new PopupWindow((View)object2, n36, n36, bl28);
        styledPlayerControlView.settingsWindow = object6;
        n112 = Util.SDK_INT;
        n12 = 23;
        f10 = 3.2E-44f;
        if (n112 < n12) {
            object6 = styledPlayerControlView.settingsWindow;
            boolean bl29 = false;
            object = null;
            object2 = new ColorDrawable(0);
            object6.setBackgroundDrawable((Drawable)object2);
        } else {
            boolean bl30 = false;
            object = null;
        }
        object6 = styledPlayerControlView.settingsWindow;
        object2 = styledPlayerControlView.componentListener;
        object6.setOnDismissListener((PopupWindow.OnDismissListener)object2);
        f11 = Float.MIN_VALUE;
        styledPlayerControlView.needToHideBars = true;
        object2 = this.getResources();
        styledPlayerControlView.trackNameProvider = object6 = new DefaultTrackNameProvider((Resources)object2);
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_subtitle_on;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.subtitleOnButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_subtitle_off;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.subtitleOffButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_cc_enabled_description;
        styledPlayerControlView.subtitleOnContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_cc_disabled_description;
        styledPlayerControlView.subtitleOffContentDescription = object6 = object6.getString(n12);
        f10 = 0.0f;
        styledPlayerControlView.textTrackSelectionAdapter = object6 = new StyledPlayerControlView$TextTrackSelectionAdapter(styledPlayerControlView, null);
        styledPlayerControlView.audioTrackSelectionAdapter = object6 = new StyledPlayerControlView$AudioTrackSelectionAdapter(styledPlayerControlView, null);
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_fullscreen_exit;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.fullScreenExitDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_fullscreen_enter;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.fullScreenEnterDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_repeat_off;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.repeatOffButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_repeat_one;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.repeatOneButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_repeat_all;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.repeatAllButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_shuffle_on;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.shuffleOnButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$drawable.exo_styled_controls_shuffle_off;
        object6 = object6.getDrawable(n12);
        styledPlayerControlView.shuffleOffButtonDrawable = object6;
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_fullscreen_exit_description;
        styledPlayerControlView.fullScreenExitContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_fullscreen_enter_description;
        styledPlayerControlView.fullScreenEnterContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_repeat_off_description;
        styledPlayerControlView.repeatOffButtonContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_repeat_one_description;
        styledPlayerControlView.repeatOneButtonContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_repeat_all_description;
        styledPlayerControlView.repeatAllButtonContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_shuffle_on_description;
        styledPlayerControlView.shuffleOnContentDescription = object6 = object6.getString(n12);
        object6 = styledPlayerControlView.resources;
        n12 = R$string.exo_controls_shuffle_off_description;
        styledPlayerControlView.shuffleOffContentDescription = object6 = object6.getString(n12);
        n112 = R$id.exo_bottom_bar;
        object6 = (ViewGroup)styledPlayerControlView.findViewById(n112);
        object2 = styledPlayerControlView.controlViewLayoutManager;
        boolean bl31 = true;
        ((StyledPlayerControlViewLayoutManager)object2).setShowButton((View)object6, bl31);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.fastForwardButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, bl6);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.rewindButton;
        bl15 = var35_78;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, (boolean)var35_78);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.previousButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, bl5);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.nextButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, bl4);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.shuffleButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, (boolean)var29_72);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.subtitleButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, bl3);
        object6 = styledPlayerControlView.controlViewLayoutManager;
        object2 = styledPlayerControlView.vrButton;
        ((StyledPlayerControlViewLayoutManager)object6).setShowButton((View)object2, bl2);
        object3 = styledPlayerControlView.controlViewLayoutManager;
        object6 = styledPlayerControlView.repeatToggleButton;
        n12 = styledPlayerControlView.repeatToggleModes;
        if (n12 != 0) {
            bl14 = bl31;
        } else {
            bl14 = false;
            object4 = null;
        }
        ((StyledPlayerControlViewLayoutManager)object3).setShowButton((View)object6, bl14);
        object3 = new o(styledPlayerControlView);
        styledPlayerControlView.addOnLayoutChangeListener((View.OnLayoutChangeListener)object3);
    }

    public static /* synthetic */ void a(StyledPlayerControlView styledPlayerControlView, View view) {
        styledPlayerControlView.onFullScreenButtonClicked(view);
    }

    public static /* synthetic */ void access$1000(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updatePlayPauseButton();
    }

    public static /* synthetic */ void access$1100(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateProgress();
    }

    public static /* synthetic */ void access$1200(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateRepeatModeButton();
    }

    public static /* synthetic */ void access$1300(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateShuffleButton();
    }

    public static /* synthetic */ void access$1400(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateNavigation();
    }

    public static /* synthetic */ void access$1500(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateTimeline();
    }

    public static /* synthetic */ void access$1600(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateSettingsPlaybackSpeedLists();
    }

    public static /* synthetic */ void access$1700(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateTrackLists();
    }

    public static /* synthetic */ boolean access$1800(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.needToHideBars;
    }

    public static /* synthetic */ View access$1900(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.nextButton;
    }

    public static /* synthetic */ ControlDispatcher access$2000(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.controlDispatcher;
    }

    public static /* synthetic */ View access$2100(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.previousButton;
    }

    public static /* synthetic */ View access$2200(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.fastForwardButton;
    }

    public static /* synthetic */ View access$2300(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.rewindButton;
    }

    public static /* synthetic */ View access$2400(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.playPauseButton;
    }

    public static /* synthetic */ void access$2500(StyledPlayerControlView styledPlayerControlView, Player player) {
        styledPlayerControlView.dispatchPlayPause(player);
    }

    public static /* synthetic */ ImageView access$2600(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.repeatToggleButton;
    }

    public static /* synthetic */ int access$2700(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.repeatToggleModes;
    }

    public static /* synthetic */ ImageView access$2800(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.shuffleButton;
    }

    public static /* synthetic */ View access$2900(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.settingsButton;
    }

    public static /* synthetic */ StyledPlayerControlView$SettingsAdapter access$3000(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.settingsAdapter;
    }

    public static /* synthetic */ boolean access$302(StyledPlayerControlView styledPlayerControlView, boolean bl2) {
        styledPlayerControlView.scrubbing = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$3100(StyledPlayerControlView styledPlayerControlView, RecyclerView$Adapter recyclerView$Adapter) {
        styledPlayerControlView.displaySettingsWindow(recyclerView$Adapter);
    }

    public static /* synthetic */ ImageView access$3200(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.subtitleButton;
    }

    public static /* synthetic */ StyledPlayerControlView$TrackSelectionAdapter access$3300(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.textTrackSelectionAdapter;
    }

    public static /* synthetic */ void access$3700(StyledPlayerControlView styledPlayerControlView, int n10) {
        styledPlayerControlView.onSettingViewClicked(n10);
    }

    public static /* synthetic */ TextView access$400(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.positionView;
    }

    public static /* synthetic */ void access$4000(StyledPlayerControlView styledPlayerControlView, int n10) {
        styledPlayerControlView.onSubSettingViewClicked(n10);
    }

    public static /* synthetic */ Drawable access$4100(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.subtitleOnButtonDrawable;
    }

    public static /* synthetic */ Drawable access$4200(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.subtitleOffButtonDrawable;
    }

    public static /* synthetic */ String access$4300(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.subtitleOnContentDescription;
    }

    public static /* synthetic */ String access$4400(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.subtitleOffContentDescription;
    }

    public static /* synthetic */ DefaultTrackSelector access$4500(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.trackSelector;
    }

    public static /* synthetic */ PopupWindow access$4600(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.settingsWindow;
    }

    public static /* synthetic */ StringBuilder access$500(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.formatBuilder;
    }

    public static /* synthetic */ Formatter access$600(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.formatter;
    }

    public static /* synthetic */ StyledPlayerControlViewLayoutManager access$700(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.controlViewLayoutManager;
    }

    public static /* synthetic */ Player access$800(StyledPlayerControlView styledPlayerControlView) {
        return styledPlayerControlView.player;
    }

    public static /* synthetic */ void access$900(StyledPlayerControlView styledPlayerControlView, Player player, long l10) {
        styledPlayerControlView.seekToTimeBarPosition(player, l10);
    }

    public static /* synthetic */ void b(StyledPlayerControlView styledPlayerControlView) {
        styledPlayerControlView.updateProgress();
    }

    public static /* synthetic */ void c(StyledPlayerControlView styledPlayerControlView, View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        styledPlayerControlView.onLayoutChange(view, n10, n11, n12, n13, n14, n15, n16, n17);
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

    private void displaySettingsWindow(RecyclerView$Adapter recyclerView$Adapter) {
        this.settingsView.setAdapter(recyclerView$Adapter);
        this.updateSettingsWindowSize();
        this.needToHideBars = false;
        this.settingsWindow.dismiss();
        this.needToHideBars = true;
        int n10 = this.getWidth();
        int n11 = this.settingsWindow.getWidth();
        n10 -= n11;
        n11 = this.settingsWindowMargin;
        n10 -= n11;
        n11 = -this.settingsWindow.getHeight();
        int n12 = this.settingsWindowMargin;
        this.settingsWindow.showAsDropDown((View)this, n10, n11 -= n12);
    }

    private void gatherTrackInfosForAdapter(MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo, int n10, List list) {
        int n11;
        StyledPlayerControlView styledPlayerControlView = this;
        int n12 = n10;
        TrackGroupArray trackGroupArray = mappingTrackSelector$MappedTrackInfo.getTrackGroups(n10);
        Object object = ((Player)Assertions.checkNotNull(this.player)).getCurrentTrackSelections();
        TrackSelection trackSelection = ((TrackSelectionArray)object).get(n10);
        for (int i10 = 0; i10 < (n11 = trackGroupArray.length); i10 += 1) {
            TrackGroup trackGroup = trackGroupArray.get(i10);
            for (int i11 = 0; i11 < (n11 = trackGroup.length); i11 += 1) {
                int n13;
                object = trackGroup.getFormat(i11);
                int n14 = mappingTrackSelector$MappedTrackInfo.getTrackSupport(n12, i10, i11);
                if (n14 == (n13 = 4)) {
                    StyledPlayerControlView$TrackInfo styledPlayerControlView$TrackInfo;
                    int n15 = trackSelection != null && (n14 = trackSelection.indexOf((Format)object)) != (n13 = -1) ? (n14 = 1) : 0;
                    TrackNameProvider trackNameProvider = styledPlayerControlView.trackNameProvider;
                    String string2 = trackNameProvider.getTrackName((Format)object);
                    object = styledPlayerControlView$TrackInfo;
                    n14 = n10;
                    n13 = i10;
                    styledPlayerControlView$TrackInfo = new StyledPlayerControlView$TrackInfo(n10, i10, i11, string2, n15 != 0);
                    object = list;
                    list.add(styledPlayerControlView$TrackInfo);
                    continue;
                }
                object = list;
            }
            object = list;
        }
    }

    private static int getRepeatToggleModes(TypedArray typedArray, int n10) {
        int n11 = R$styleable.StyledPlayerControlView_repeat_toggle_modes;
        return typedArray.getInt(n11, n10);
    }

    private void initTrackSelectionAdapter() {
        this.textTrackSelectionAdapter.clear();
        this.audioTrackSelectionAdapter.clear();
        Object object = this.player;
        if (object != null && (object = this.trackSelector) != null) {
            int n10;
            if ((object = ((MappingTrackSelector)object).getCurrentMappedTrackInfo()) == null) {
                return;
            }
            Object object2 = new ArrayList();
            ArrayList arrayList = new ArrayList();
            ArrayList<Object> arrayList2 = new ArrayList<Object>();
            ArrayList<Object> arrayList3 = new ArrayList<Object>();
            StyledPlayerControlView$TrackSelectionAdapter styledPlayerControlView$TrackSelectionAdapter = null;
            for (int i10 = 0; i10 < (n10 = ((MappingTrackSelector$MappedTrackInfo)object).getRendererCount()); ++i10) {
                ImageView imageView;
                Object object3;
                int n11;
                n10 = ((MappingTrackSelector$MappedTrackInfo)object).getRendererType(i10);
                if (n10 == (n11 = 3) && (n10 = (int)(((StyledPlayerControlViewLayoutManager)(object3 = this.controlViewLayoutManager)).getShowButton((View)(imageView = this.subtitleButton)) ? 1 : 0)) != 0) {
                    this.gatherTrackInfosForAdapter((MappingTrackSelector$MappedTrackInfo)object, i10, (List)object2);
                    object3 = i10;
                    arrayList2.add(object3);
                    continue;
                }
                n10 = ((MappingTrackSelector$MappedTrackInfo)object).getRendererType(i10);
                if (n10 != (n11 = 1)) continue;
                this.gatherTrackInfosForAdapter((MappingTrackSelector$MappedTrackInfo)object, i10, arrayList);
                object3 = i10;
                arrayList3.add(object3);
            }
            styledPlayerControlView$TrackSelectionAdapter = this.textTrackSelectionAdapter;
            styledPlayerControlView$TrackSelectionAdapter.init(arrayList2, (List)object2, (MappingTrackSelector$MappedTrackInfo)object);
            object2 = this.audioTrackSelectionAdapter;
            ((StyledPlayerControlView$TrackSelectionAdapter)object2).init(arrayList3, arrayList, (MappingTrackSelector$MappedTrackInfo)object);
        }
    }

    private static void initializeFullScreenButton(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    private static boolean isHandledMediaKey(int n10) {
        int n11 = 90;
        n10 = n10 != n11 && n10 != (n11 = 89) && n10 != (n11 = 85) && n10 != (n11 = 79) && n10 != (n11 = 126) && n10 != (n11 = 127) && n10 != (n11 = 87) && n10 != (n11 = 88) ? 0 : 1;
        return n10 != 0;
    }

    private void onFullScreenButtonClicked(View object) {
        boolean bl2;
        object = this.onFullScreenModeChangedListener;
        if (object == null) {
            return;
        }
        this.isFullScreen = bl2 = this.isFullScreen ^ true;
        ImageView imageView = this.fullScreenButton;
        this.updateFullScreenButtonForState(imageView, bl2);
        object = this.minimalFullScreenButton;
        boolean bl3 = this.isFullScreen;
        this.updateFullScreenButtonForState((ImageView)object, bl3);
        object = this.onFullScreenModeChangedListener;
        if (object != null) {
            bl3 = this.isFullScreen;
            object.onFullScreenModeChanged(bl3);
        }
    }

    private void onLayoutChange(View view, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        PopupWindow popupWindow;
        if (((n12 -= n10) != (n16 -= n14) || (n13 -= n11) != (n17 -= n15)) && (n10 = (int)((popupWindow = this.settingsWindow).isShowing() ? 1 : 0)) != 0) {
            this.updateSettingsWindowSize();
            n10 = this.getWidth();
            PopupWindow popupWindow2 = this.settingsWindow;
            n11 = popupWindow2.getWidth();
            n10 -= n11;
            n11 = this.settingsWindowMargin;
            n14 = n10 - n11;
            popupWindow = this.settingsWindow;
            n10 = -popupWindow.getHeight();
            n11 = this.settingsWindowMargin;
            n15 = n10 - n11;
            PopupWindow popupWindow3 = this.settingsWindow;
            n16 = -1;
            n17 = -1;
            popupWindow3.update(view, n14, n15, n16, n17);
        }
    }

    private void onSettingViewClicked(int n10) {
        if (n10 == 0) {
            StyledPlayerControlView$SubSettingsAdapter styledPlayerControlView$SubSettingsAdapter = this.subSettingsAdapter;
            String[] stringArray = this.playbackSpeedTexts;
            int n11 = this.selectedPlaybackSpeedIndex;
            styledPlayerControlView$SubSettingsAdapter.init(stringArray, n11);
            n10 = 0;
            this.selectedMainSettingsPosition = 0;
            styledPlayerControlView$SubSettingsAdapter = this.subSettingsAdapter;
            this.displaySettingsWindow(styledPlayerControlView$SubSettingsAdapter);
        } else {
            int n12 = 1;
            if (n10 == n12) {
                this.selectedMainSettingsPosition = n12;
                StyledPlayerControlView$TrackSelectionAdapter styledPlayerControlView$TrackSelectionAdapter = this.audioTrackSelectionAdapter;
                this.displaySettingsWindow(styledPlayerControlView$TrackSelectionAdapter);
            } else {
                PopupWindow popupWindow = this.settingsWindow;
                popupWindow.dismiss();
            }
        }
    }

    private void onSubSettingViewClicked(int n10) {
        int n11 = this.selectedMainSettingsPosition;
        if (n11 == 0 && n10 != (n11 = this.selectedPlaybackSpeedIndex)) {
            int[] nArray = this.playbackSpeedsMultBy100;
            n10 = nArray[n10];
            float f10 = n10;
            n11 = 1120403456;
            float f11 = 100.0f;
            this.setPlaybackSpeed(f10 /= f11);
        }
        this.settingsWindow.dismiss();
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

    private void setPlaybackSpeed(float f10) {
        Player player = this.player;
        if (player == null) {
            return;
        }
        ControlDispatcher controlDispatcher = this.controlDispatcher;
        PlaybackParameters playbackParameters = player.getPlaybackParameters().withSpeed(f10);
        controlDispatcher.dispatchSetPlaybackParameters(player, playbackParameters);
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

    private void updateButton(boolean bl2, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(bl2);
        float f10 = bl2 ? this.buttonAlphaEnabled : this.buttonAlphaDisabled;
        view.setAlpha(f10);
    }

    private void updateFastForwardButton() {
        String string2;
        long l10;
        Object object = this.controlDispatcher;
        boolean bl2 = object instanceof DefaultControlDispatcher;
        if (bl2) {
            object = (DefaultControlDispatcher)object;
            this.fastForwardMs = l10 = ((DefaultControlDispatcher)object).getFastForwardIncrementMs();
        }
        l10 = this.fastForwardMs;
        long l11 = 1000L;
        int n10 = (int)(l10 /= l11);
        TextView textView = this.fastForwardButtonTextView;
        if (textView != null) {
            string2 = String.valueOf(n10);
            textView.setText((CharSequence)string2);
        }
        if ((textView = this.fastForwardButton) != null) {
            string2 = this.resources;
            int n11 = R$plurals.exo_controls_fastforward_by_amount_description;
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            Integer n13 = n10;
            objectArray[0] = n13;
            object = string2.getQuantityString(n11, n10, objectArray);
            textView.setContentDescription((CharSequence)object);
        }
    }

    private void updateFullScreenButtonForState(ImageView imageView, boolean bl2) {
        if (imageView == null) {
            return;
        }
        if (bl2) {
            Object object = this.fullScreenExitDrawable;
            imageView.setImageDrawable(object);
            object = this.fullScreenExitContentDescription;
            imageView.setContentDescription((CharSequence)object);
        } else {
            Object object = this.fullScreenEnterDrawable;
            imageView.setImageDrawable(object);
            object = this.fullScreenEnterContentDescription;
            imageView.setContentDescription((CharSequence)object);
        }
    }

    private static void updateFullScreenButtonVisibility(View view, boolean bl2) {
        if (view == null) {
            return;
        }
        if (bl2) {
            boolean bl3 = false;
            view.setVisibility(0);
        } else {
            int n10 = 8;
            view.setVisibility(n10);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void updateNavigation() {
        block12: {
            boolean bl2;
            boolean bl3;
            Timeline$Window timeline$Window;
            Object object;
            View view;
            boolean bl5;
            Object object2;
            boolean bl6;
            block17: {
                block13: {
                    boolean bl4;
                    block16: {
                        boolean bl7;
                        block15: {
                            block14: {
                                ControlDispatcher controlDispatcher;
                                ControlDispatcher controlDispatcher2;
                                boolean bl8;
                                boolean bl42;
                                bl6 = this.isVisible();
                                if (!bl6 || !(bl6 = this.isAttachedToWindow)) break block12;
                                object2 = this.player;
                                bl5 = false;
                                view = null;
                                if (object2 == null || (bl42 = ((Timeline)(object = object2.getCurrentTimeline())).isEmpty()) || (bl8 = object2.isPlayingAd())) break block13;
                                int n10 = object2.getCurrentWindowIndex();
                                timeline$Window = this.window;
                                ((Timeline)object).getWindow(n10, timeline$Window);
                                object = this.window;
                                boolean bl9 = ((Timeline$Window)object).isSeekable;
                                bl7 = true;
                                float f10 = Float.MIN_VALUE;
                                if (!bl9 && (bl3 = ((Timeline$Window)object).isLive()) && !(bl3 = object2.hasPrevious())) {
                                    bl3 = false;
                                    object = null;
                                } else {
                                    bl3 = bl7;
                                }
                                if (bl9 && (bl4 = (controlDispatcher2 = this.controlDispatcher).isRewindEnabled())) {
                                    bl4 = bl7;
                                    float f11 = f10;
                                } else {
                                    bl4 = false;
                                    controlDispatcher2 = null;
                                    float f12 = 0.0f;
                                }
                                if (bl9 && (bl2 = (controlDispatcher = this.controlDispatcher).isFastForwardEnabled())) {
                                    bl2 = bl7;
                                } else {
                                    bl2 = false;
                                    controlDispatcher = null;
                                }
                                Timeline$Window timeline$Window2 = this.window;
                                boolean bl10 = timeline$Window2.isLive();
                                if (!bl10) break block14;
                                timeline$Window2 = this.window;
                                bl10 = timeline$Window2.isDynamic;
                                if (bl10) break block15;
                            }
                            if (!(bl6 = object2.hasNext())) break block16;
                        }
                        bl5 = bl7;
                    }
                    bl6 = bl5;
                    bl5 = bl4;
                    break block17;
                }
                bl6 = false;
                object2 = null;
                bl3 = false;
                object = null;
                boolean bl11 = false;
                bl2 = false;
                Object var14_21 = null;
            }
            if (bl5) {
                this.updateRewindButton();
            }
            if (bl2) {
                this.updateFastForwardButton();
            }
            timeline$Window = this.previousButton;
            this.updateButton(bl3, (View)timeline$Window);
            object = this.rewindButton;
            this.updateButton(bl5, (View)object);
            view = this.fastForwardButton;
            this.updateButton(bl2, view);
            view = this.nextButton;
            this.updateButton(bl6, view);
            object2 = this.timeBar;
            if (object2 != null) {
                void var6_11;
                object2.setEnabled((boolean)var6_11);
            }
        }
    }

    private void updatePlayPauseButton() {
        View view;
        boolean bl2 = this.isVisible();
        if (bl2 && (bl2 = this.isAttachedToWindow) && (view = this.playPauseButton) != null) {
            bl2 = this.shouldShowPauseButton();
            if (bl2) {
                view = (ImageView)this.playPauseButton;
                Object object = this.resources;
                int n10 = R$drawable.exo_styled_controls_pause;
                object = object.getDrawable(n10);
                view.setImageDrawable((Drawable)object);
                view = this.playPauseButton;
                object = this.resources;
                n10 = R$string.exo_controls_pause_description;
                object = object.getString(n10);
                view.setContentDescription((CharSequence)object);
            } else {
                view = (ImageView)this.playPauseButton;
                Object object = this.resources;
                int n11 = R$drawable.exo_styled_controls_play;
                object = object.getDrawable(n11);
                view.setImageDrawable((Drawable)object);
                view = this.playPauseButton;
                object = this.resources;
                n11 = R$string.exo_controls_play_description;
                object = object.getString(n11);
                view.setContentDescription((CharSequence)object);
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
            int n12 = 0;
            if (n11 == 0) {
                this.updateButton(false, (View)imageView);
                return;
            }
            Object object = this.player;
            if (object == null) {
                this.updateButton(false, (View)imageView);
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonDrawable;
                imageView.setImageDrawable((Drawable)object);
                imageView = this.repeatToggleButton;
                object = this.repeatOffButtonContentDescription;
                imageView.setContentDescription((CharSequence)object);
                return;
            }
            n12 = 1;
            this.updateButton(n12 != 0, (View)imageView);
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
        }
    }

    private void updateRewindButton() {
        String string2;
        long l10;
        Object object = this.controlDispatcher;
        boolean bl2 = object instanceof DefaultControlDispatcher;
        if (bl2) {
            object = (DefaultControlDispatcher)object;
            this.rewindMs = l10 = ((DefaultControlDispatcher)object).getRewindIncrementMs();
        }
        l10 = this.rewindMs;
        long l11 = 1000L;
        int n10 = (int)(l10 /= l11);
        TextView textView = this.rewindButtonTextView;
        if (textView != null) {
            string2 = String.valueOf(n10);
            textView.setText((CharSequence)string2);
        }
        if ((textView = this.rewindButton) != null) {
            string2 = this.resources;
            int n11 = R$plurals.exo_controls_rewind_by_amount_description;
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            Integer n13 = n10;
            objectArray[0] = n13;
            object = string2.getQuantityString(n11, n10, objectArray);
            textView.setContentDescription((CharSequence)object);
        }
    }

    private void updateSettingsPlaybackSpeedLists() {
        int[] nArray;
        int n10;
        Object object = this.player;
        if (object == null) {
            return;
        }
        object = object.getPlaybackParameters();
        float f10 = ((PlaybackParameters)object).speed * 100.0f;
        int n11 = Math.round(f10);
        int n12 = -1 >>> 1;
        int n13 = 0;
        for (int i10 = 0; i10 < (n10 = (nArray = this.playbackSpeedsMultBy100).length); ++i10) {
            int n14 = nArray[i10];
            if ((n14 = Math.abs(n11 - n14)) >= n12) continue;
            n13 = i10;
            n12 = n14;
        }
        this.selectedPlaybackSpeedIndex = n13;
        object = this.settingsAdapter;
        String string2 = this.playbackSpeedTexts[n13];
        ((StyledPlayerControlView$SettingsAdapter)object).setSubTextAtPosition(0, string2);
    }

    private void updateSettingsWindowSize() {
        this.settingsView.measure(0, 0);
        int n10 = this.getWidth();
        int n11 = this.settingsWindowMargin * 2;
        n10 -= n11;
        n10 = Math.min(this.settingsView.getMeasuredWidth(), n10);
        this.settingsWindow.setWidth(n10);
        n10 = this.getHeight();
        n11 = this.settingsWindowMargin * 2;
        n10 -= n11;
        n11 = this.settingsView.getMeasuredHeight();
        n10 = Math.min(n10, n11);
        this.settingsWindow.setHeight(n10);
    }

    private void updateShuffleButton() {
        ImageView imageView;
        boolean bl2 = this.isVisible();
        if (bl2 && (bl2 = this.isAttachedToWindow) && (imageView = this.shuffleButton) != null) {
            Object object = this.player;
            bl2 = this.controlViewLayoutManager.getShowButton((View)imageView);
            boolean bl3 = false;
            ImageView imageView2 = null;
            if (!bl2) {
                imageView = this.shuffleButton;
                this.updateButton(false, (View)imageView);
            } else if (object == null) {
                imageView = this.shuffleButton;
                this.updateButton(false, (View)imageView);
                imageView = this.shuffleButton;
                object = this.shuffleOffButtonDrawable;
                imageView.setImageDrawable((Drawable)object);
                imageView = this.shuffleButton;
                object = this.shuffleOffContentDescription;
                imageView.setContentDescription((CharSequence)object);
            } else {
                bl2 = true;
                imageView2 = this.shuffleButton;
                this.updateButton(bl2, (View)imageView2);
                imageView = this.shuffleButton;
                bl3 = object.getShuffleModeEnabled();
                imageView2 = bl3 ? this.shuffleOnButtonDrawable : this.shuffleOffButtonDrawable;
                imageView.setImageDrawable((Drawable)imageView2);
                imageView = this.shuffleButton;
                boolean bl4 = object.getShuffleModeEnabled();
                object = bl4 ? this.shuffleOnContentDescription : this.shuffleOffContentDescription;
                imageView.setContentDescription((CharSequence)object);
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
        StyledPlayerControlView styledPlayerControlView;
        block19: {
            block16: {
                void var3_7;
                Timeline timeline;
                boolean bl2;
                styledPlayerControlView = this;
                object4 = this.player;
                if (object4 == null) {
                    return;
                }
                boolean n13 = this.showMultiWindowTimeBar;
                n12 = 1;
                if (n13 && (bl2 = StyledPlayerControlView.canShowMultiWindowTimeBar(timeline = object4.getCurrentTimeline(), (Timeline$Window)(object3 = this.window)))) {
                    int n14 = n12;
                } else {
                    boolean bl3 = false;
                    timeline = null;
                }
                styledPlayerControlView.multiWindowTimeBar = var3_7;
                styledPlayerControlView.currentWindowOffset = l10 = 0L;
                timeline = object4.getCurrentTimeline();
                int n15 = timeline.isEmpty();
                if (n15 != 0) break block16;
                n11 = object4.getCurrentWindowIndex();
                n15 = styledPlayerControlView.multiWindowTimeBar;
                int n16 = n15 != 0 ? 0 : n11;
                n15 = n15 != 0 ? timeline.getWindowCount() - n12 : n11;
                long l11 = l10;
                n10 = 0;
                while (n16 <= n15) {
                    long l12;
                    Object object5;
                    if (n16 == n11) {
                        long l13;
                        styledPlayerControlView.currentWindowOffset = l13 = C.usToMs(l11);
                    }
                    Timeline$Window timeline$Window = styledPlayerControlView.window;
                    timeline.getWindow(n16, timeline$Window);
                    timeline$Window = styledPlayerControlView.window;
                    long l14 = timeline$Window.durationUs;
                    long l15 = -9223372036854775807L;
                    long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
                    if (l16 == false) {
                        n11 = styledPlayerControlView.multiWindowTimeBar ^ n12;
                        Assertions.checkState(n11 != 0);
                        break;
                    }
                    int n17 = timeline$Window.firstPeriodIndex;
                    while (true) {
                        object5 = styledPlayerControlView.window;
                        int n18 = ((Timeline$Window)object5).lastPeriodIndex;
                        if (n17 > n18) break;
                        object5 = styledPlayerControlView.period;
                        timeline.getPeriod(n17, (Timeline$Period)object5);
                        object5 = styledPlayerControlView.period;
                        l16 = ((Timeline$Period)object5).getAdGroupCount();
                        for (n18 = 0; n18 < l16; ++n18) {
                            block18: {
                                long l17;
                                long l18;
                                long l19;
                                block17: {
                                    long l20;
                                    object2 = styledPlayerControlView.period;
                                    l19 = ((Timeline$Period)object2).getAdGroupTimeUs(n18);
                                    long l21 = l19 - (l20 = Long.MIN_VALUE);
                                    n12 = (int)(l21 == 0L ? 0 : (l21 < 0L ? -1 : 1));
                                    if (n12 != 0) break block17;
                                    object2 = styledPlayerControlView.period;
                                    l12 = ((Timeline$Period)object2).durationUs;
                                    long l22 = l12 - l15;
                                    Object object6 = l22 == 0L ? 0 : (l22 < 0L ? -1 : 1);
                                    if (object6 == false) break block18;
                                    l19 = l12;
                                }
                                if ((l18 = (l17 = (l19 += (l12 = (object = styledPlayerControlView.period).getPositionInWindowUs())) - l10) == 0L ? 0 : (l17 < 0L ? -1 : 1)) >= 0) {
                                    object = styledPlayerControlView.adGroupTimesMs;
                                    n12 = ((TextView)object).length;
                                    if (n10 == n12) {
                                        n12 = ((TextView)object).length;
                                        n12 = n12 == 0 ? 1 : ((TextView)object).length * 2;
                                        object = Arrays.copyOf((long[])object, n12);
                                        styledPlayerControlView.adGroupTimesMs = (long[])object;
                                        object = Arrays.copyOf(styledPlayerControlView.playedAdGroups, n12);
                                        styledPlayerControlView.playedAdGroups = (boolean[])object;
                                    }
                                    object = styledPlayerControlView.adGroupTimesMs;
                                    l19 = C.usToMs(l11 + l19);
                                    object[n10] = (TextView)l19;
                                    object = styledPlayerControlView.playedAdGroups;
                                    object2 = styledPlayerControlView.period;
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
        object = styledPlayerControlView.durationView;
        if (object != null) {
            object2 = styledPlayerControlView.formatBuilder;
            object3 = styledPlayerControlView.formatter;
            object2 = Util.getStringForTime((StringBuilder)object2, (Formatter)object3, l23);
            object.setText((CharSequence)object2);
        }
        if ((object = styledPlayerControlView.timeBar) != null) {
            object.setDuration(l23);
            object4 = styledPlayerControlView.extraAdGroupTimesMs;
            n11 = ((Object)object4).length;
            int n19 = n10 + n11;
            object = styledPlayerControlView.adGroupTimesMs;
            n12 = ((TextView)object).length;
            if (n19 > n12) {
                object = Arrays.copyOf((long[])object, n19);
                styledPlayerControlView.adGroupTimesMs = (long[])object;
                object = Arrays.copyOf(styledPlayerControlView.playedAdGroups, n19);
                styledPlayerControlView.playedAdGroups = (boolean[])object;
            }
            object = styledPlayerControlView.extraAdGroupTimesMs;
            object2 = styledPlayerControlView.adGroupTimesMs;
            object3 = null;
            System.arraycopy(object, 0, object2, n10, n11);
            object = styledPlayerControlView.extraPlayedAdGroups;
            object2 = styledPlayerControlView.playedAdGroups;
            System.arraycopy(object, 0, object2, n10, n11);
            object4 = styledPlayerControlView.timeBar;
            object = styledPlayerControlView.adGroupTimesMs;
            object2 = styledPlayerControlView.playedAdGroups;
            object4.setAdGroupTimesMs((long[])object, (boolean[])object2, n19);
        }
        this.updateProgress();
    }

    /*
     * WARNING - void declaration
     */
    private void updateTrackLists() {
        void var2_5;
        this.initTrackSelectionAdapter();
        StyledPlayerControlView$TrackSelectionAdapter styledPlayerControlView$TrackSelectionAdapter = this.textTrackSelectionAdapter;
        int bl2 = styledPlayerControlView$TrackSelectionAdapter.getItemCount();
        if (bl2 > 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            styledPlayerControlView$TrackSelectionAdapter = null;
        }
        ImageView imageView = this.subtitleButton;
        this.updateButton((boolean)var2_5, (View)imageView);
    }

    public void addVisibilityListener(StyledPlayerControlView$VisibilityListener styledPlayerControlView$VisibilityListener) {
        Assertions.checkNotNull(styledPlayerControlView$VisibilityListener);
        this.visibilityListeners.add(styledPlayerControlView$VisibilityListener);
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
        if (player != null && (n10 = StyledPlayerControlView.isHandledMediaKey(n11)) != 0) {
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

    public Player getPlayer() {
        return this.player;
    }

    public int getRepeatToggleModes() {
        return this.repeatToggleModes;
    }

    public boolean getShowShuffleButton() {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        ImageView imageView = this.shuffleButton;
        return styledPlayerControlViewLayoutManager.getShowButton((View)imageView);
    }

    public boolean getShowSubtitleButton() {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        ImageView imageView = this.subtitleButton;
        return styledPlayerControlViewLayoutManager.getShowButton((View)imageView);
    }

    public int getShowTimeoutMs() {
        return this.showTimeoutMs;
    }

    public boolean getShowVrButton() {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.vrButton;
        return styledPlayerControlViewLayoutManager.getShowButton(view);
    }

    public void hide() {
        this.controlViewLayoutManager.hide();
    }

    public void hideImmediately() {
        this.controlViewLayoutManager.hideImmediately();
    }

    public boolean isAnimationEnabled() {
        return this.controlViewLayoutManager.isAnimationEnabled();
    }

    public boolean isFullyVisible() {
        return this.controlViewLayoutManager.isFullyVisible();
    }

    public boolean isVisible() {
        int n10 = this.getVisibility();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void notifyOnVisibilityChange() {
        boolean bl2;
        Iterator iterator2 = this.visibilityListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            StyledPlayerControlView$VisibilityListener styledPlayerControlView$VisibilityListener = (StyledPlayerControlView$VisibilityListener)iterator2.next();
            int n10 = this.getVisibility();
            styledPlayerControlView$VisibilityListener.onVisibilityChange(n10);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        styledPlayerControlViewLayoutManager.onAttachedToWindow();
        this.isAttachedToWindow = true;
        boolean bl2 = this.isFullyVisible();
        if (bl2) {
            styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
            styledPlayerControlViewLayoutManager.resetHideCallbacks();
        }
        this.updateAll();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.controlViewLayoutManager.onDetachedFromWindow();
        this.isAttachedToWindow = false;
        Runnable runnable = this.updateProgressAction;
        this.removeCallbacks(runnable);
        this.controlViewLayoutManager.removeHideCallbacks();
    }

    public void removeVisibilityListener(StyledPlayerControlView$VisibilityListener styledPlayerControlView$VisibilityListener) {
        this.visibilityListeners.remove(styledPlayerControlView$VisibilityListener);
    }

    public void requestPlayPauseFocus() {
        View view = this.playPauseButton;
        if (view != null) {
            view.requestFocus();
        }
    }

    public void setAnimationEnabled(boolean bl2) {
        this.controlViewLayoutManager.setAnimationEnabled(bl2);
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

    public void setOnFullScreenModeChangedListener(StyledPlayerControlView$OnFullScreenModeChangedListener styledPlayerControlView$OnFullScreenModeChangedListener) {
        this.onFullScreenModeChangedListener = styledPlayerControlView$OnFullScreenModeChangedListener;
        ImageView imageView = this.fullScreenButton;
        boolean bl2 = true;
        boolean bl3 = styledPlayerControlView$OnFullScreenModeChangedListener != null ? bl2 : false;
        StyledPlayerControlView.updateFullScreenButtonVisibility((View)imageView, bl3);
        imageView = this.minimalFullScreenButton;
        if (styledPlayerControlView$OnFullScreenModeChangedListener == null) {
            bl2 = false;
        }
        StyledPlayerControlView.updateFullScreenButtonVisibility((View)imageView, bl2);
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        this.playbackPreparer = playbackPreparer;
    }

    public void setPlayer(Player object) {
        boolean bl2;
        Object object2 = Looper.myLooper();
        Object object3 = Looper.getMainLooper();
        boolean bl3 = true;
        if (object2 == object3) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object2 = null;
        }
        Assertions.checkState(bl2);
        if (object != null && (object2 = object.getApplicationLooper()) != (object3 = Looper.getMainLooper())) {
            bl3 = false;
        }
        Assertions.checkArgument(bl3);
        object2 = this.player;
        if (object2 == object) {
            return;
        }
        if (object2 != null) {
            object3 = this.componentListener;
            object2.removeListener((Player$EventListener)object3);
        }
        this.player = object;
        if (object != null) {
            object2 = this.componentListener;
            object.addListener((Player$EventListener)object2);
        }
        if (bl2 = object instanceof ExoPlayer) {
            bl2 = (object = ((ExoPlayer)object).getTrackSelector()) instanceof DefaultTrackSelector;
            if (bl2) {
                this.trackSelector = object = (DefaultTrackSelector)object;
            }
        } else {
            object = null;
            this.trackSelector = null;
        }
        this.updateAll();
        this.updateSettingsPlaybackSpeedLists();
    }

    public void setProgressUpdateListener(StyledPlayerControlView$ProgressUpdateListener styledPlayerControlView$ProgressUpdateListener) {
        this.progressUpdateListener = styledPlayerControlView$ProgressUpdateListener;
    }

    public void setRepeatToggleModes(int n10) {
        Object object;
        this.repeatToggleModes = n10;
        Object object2 = this.player;
        int n11 = 0;
        int n12 = 1;
        if (object2 != null) {
            int n13 = object2.getRepeatMode();
            if (n10 == 0 && n13 != 0) {
                object2 = this.controlDispatcher;
                object = this.player;
                object2.dispatchSetRepeatMode((Player)object, 0);
            } else {
                int n14 = 2;
                if (n10 == n12 && n13 == n14) {
                    object2 = this.controlDispatcher;
                    object = this.player;
                    object2.dispatchSetRepeatMode((Player)object, n12);
                } else if (n10 == n14 && n13 == n12) {
                    object2 = this.controlDispatcher;
                    Player player = this.player;
                    object2.dispatchSetRepeatMode(player, n14);
                }
            }
        }
        object2 = this.controlViewLayoutManager;
        object = this.repeatToggleButton;
        if (n10 != 0) {
            n11 = n12;
        }
        ((StyledPlayerControlViewLayoutManager)object2).setShowButton((View)object, n11 != 0);
        this.updateRepeatModeButton();
    }

    public void setShowFastForwardButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.fastForwardButton;
        styledPlayerControlViewLayoutManager.setShowButton(view, bl2);
        this.updateNavigation();
    }

    public void setShowMultiWindowTimeBar(boolean bl2) {
        this.showMultiWindowTimeBar = bl2;
        this.updateTimeline();
    }

    public void setShowNextButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.nextButton;
        styledPlayerControlViewLayoutManager.setShowButton(view, bl2);
        this.updateNavigation();
    }

    public void setShowPreviousButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.previousButton;
        styledPlayerControlViewLayoutManager.setShowButton(view, bl2);
        this.updateNavigation();
    }

    public void setShowRewindButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.rewindButton;
        styledPlayerControlViewLayoutManager.setShowButton(view, bl2);
        this.updateNavigation();
    }

    public void setShowShuffleButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        ImageView imageView = this.shuffleButton;
        styledPlayerControlViewLayoutManager.setShowButton((View)imageView, bl2);
        this.updateShuffleButton();
    }

    public void setShowSubtitleButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        ImageView imageView = this.subtitleButton;
        styledPlayerControlViewLayoutManager.setShowButton((View)imageView, bl2);
    }

    public void setShowTimeoutMs(int n10) {
        this.showTimeoutMs = n10;
        n10 = (int)(this.isFullyVisible() ? 1 : 0);
        if (n10 != 0) {
            StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
            styledPlayerControlViewLayoutManager.resetHideCallbacks();
        }
    }

    public void setShowVrButton(boolean bl2) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.controlViewLayoutManager;
        View view = this.vrButton;
        styledPlayerControlViewLayoutManager.setShowButton(view, bl2);
    }

    public void setTimeBarMinUpdateInterval(int n10) {
        this.timeBarMinUpdateIntervalMs = n10 = Util.constrainValue(n10, 16, 1000);
    }

    public void setVrButtonListener(View.OnClickListener onClickListener) {
        View view = this.vrButton;
        if (view != null) {
            boolean bl2;
            view.setOnClickListener(onClickListener);
            if (onClickListener != null) {
                bl2 = true;
            } else {
                bl2 = false;
                onClickListener = null;
            }
            view = this.vrButton;
            this.updateButton(bl2, view);
        }
    }

    public void show() {
        this.controlViewLayoutManager.show();
    }

    public void updateAll() {
        this.updatePlayPauseButton();
        this.updateNavigation();
        this.updateRepeatModeButton();
        this.updateShuffleButton();
        this.updateTrackLists();
        this.updateTimeline();
    }
}

