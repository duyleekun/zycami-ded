/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.SurfaceView
 *  android.view.TextureView
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.TextView
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ControlDispatcher;
import com.google.android.exoplayer2.PlaybackPreparer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$VideoComponent;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader$AdViewProvider;
import com.google.android.exoplayer2.source.ads.AdsLoader$OverlayInfo;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.ui.AspectRatioFrameLayout$AspectRatioListener;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerControlView$VisibilityListener;
import com.google.android.exoplayer2.ui.PlayerView$ComponentListener;
import com.google.android.exoplayer2.ui.R$color;
import com.google.android.exoplayer2.ui.R$drawable;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.R$styleable;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.ui.spherical.SphericalGLSurfaceView;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public class PlayerView
extends FrameLayout
implements AdsLoader$AdViewProvider {
    private static final int PICTURE_TYPE_FRONT_COVER = 3;
    private static final int PICTURE_TYPE_NOT_SET = 255;
    public static final int SHOW_BUFFERING_ALWAYS = 2;
    public static final int SHOW_BUFFERING_NEVER = 0;
    public static final int SHOW_BUFFERING_WHEN_PLAYING = 1;
    private static final int SURFACE_TYPE_NONE = 0;
    private static final int SURFACE_TYPE_SPHERICAL_GL_SURFACE_VIEW = 3;
    private static final int SURFACE_TYPE_SURFACE_VIEW = 1;
    private static final int SURFACE_TYPE_TEXTURE_VIEW = 2;
    private static final int SURFACE_TYPE_VIDEO_DECODER_GL_SURFACE_VIEW = 4;
    private final FrameLayout adOverlayFrameLayout;
    private final ImageView artworkView;
    private final View bufferingView;
    private final PlayerView$ComponentListener componentListener;
    private final AspectRatioFrameLayout contentFrame;
    private final PlayerControlView controller;
    private boolean controllerAutoShow;
    private boolean controllerHideDuringAds;
    private boolean controllerHideOnTouch;
    private int controllerShowTimeoutMs;
    private PlayerControlView$VisibilityListener controllerVisibilityListener;
    private CharSequence customErrorMessage;
    private Drawable defaultArtwork;
    private ErrorMessageProvider errorMessageProvider;
    private final TextView errorMessageView;
    private boolean isTouching;
    private boolean keepContentOnPlayerReset;
    private final FrameLayout overlayFrameLayout;
    private Player player;
    private int showBuffering;
    private final View shutterView;
    private final SubtitleView subtitleView;
    private final View surfaceView;
    private int textureViewRotation;
    private boolean useArtwork;
    private boolean useController;
    private boolean useSensorRotation;

    public PlayerView(Context context) {
        this(context, null);
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /*
     * WARNING - void declaration
     */
    public PlayerView(Context context, AttributeSet attributeSet, int n10) {
        PlayerControlView playerControlView;
        int n11;
        FrameLayout frameLayout;
        int n12;
        int n13;
        int n14;
        int n15;
        int n16;
        int n18;
        Object object;
        View view;
        int n25;
        int n24;
        int n23;
        int n20;
        int n19;
        PlayerView$ComponentListener playerView$ComponentListener;
        AttributeSet attributeSet2;
        Object object2;
        PlayerView playerView;
        block63: {
            block62: {
                playerView = this;
                object2 = context;
                attributeSet2 = attributeSet;
                super(context, attributeSet, n10);
                this.componentListener = playerView$ComponentListener = new PlayerView$ComponentListener(this);
                n19 = this.isInEditMode();
                n20 = 0;
                if (n19 != 0) {
                    this.contentFrame = null;
                    this.shutterView = null;
                    this.surfaceView = null;
                    this.artworkView = null;
                    this.subtitleView = null;
                    this.bufferingView = null;
                    this.errorMessageView = null;
                    this.controller = null;
                    this.adOverlayFrameLayout = null;
                    this.overlayFrameLayout = null;
                    super(context);
                    int n21 = Util.SDK_INT;
                    int n22 = 23;
                    if (n21 >= n22) {
                        object2 = this.getResources();
                        PlayerView.configureEditModeLogoV23((Resources)object2, (ImageView)attributeSet2);
                    } else {
                        object2 = this.getResources();
                        PlayerView.configureEditModeLogo((Resources)object2, (ImageView)attributeSet2);
                    }
                    playerView.addView((View)attributeSet2);
                    return;
                }
                n19 = R$layout.exo_player_view;
                n23 = 5000;
                n24 = 1;
                this.useSensorRotation = n24;
                n25 = 0;
                view = null;
                if (attributeSet == null) break block62;
                object = context.getTheme();
                int[] nArray = R$styleable.PlayerView;
                object = object.obtainStyledAttributes(attributeSet, nArray, 0, 0);
                n18 = R$styleable.PlayerView_shutter_background_color;
                boolean n17 = object.hasValue(n18);
                n18 = object.getColor(n18, 0);
                n16 = R$styleable.PlayerView_player_layout_id;
                n19 = object.getResourceId(n16, n19);
                n16 = R$styleable.PlayerView_use_artwork;
                n16 = (int)(object.getBoolean(n16, n24 != 0) ? 1 : 0);
                n15 = R$styleable.PlayerView_default_artwork;
                n15 = object.getResourceId(n15, 0);
                n14 = R$styleable.PlayerView_use_controller;
                n14 = (int)(object.getBoolean(n14, n24 != 0) ? 1 : 0);
                int n21 = R$styleable.PlayerView_surface_type;
                n21 = object.getInt(n21, n24);
                n20 = R$styleable.PlayerView_resize_mode;
                n20 = object.getInt(n20, 0);
                n25 = R$styleable.PlayerView_show_timeout;
                n23 = object.getInt(n25, n23);
                n25 = R$styleable.PlayerView_hide_on_touch;
                n25 = (int)(object.getBoolean(n25, n24 != 0) ? 1 : 0);
                n13 = n19;
                n19 = R$styleable.PlayerView_auto_show;
                n19 = (int)(object.getBoolean(n19, n24 != 0) ? 1 : 0);
                n24 = R$styleable.PlayerView_show_buffering;
                n12 = n19;
                n19 = 0;
                frameLayout = null;
                n24 = object.getInteger(n24, 0);
                n19 = R$styleable.PlayerView_keep_content_on_player_reset;
                int n22 = n20;
                n20 = (int)(this.keepContentOnPlayerReset ? 1 : 0);
                n19 = (int)(object.getBoolean(n19, n20 != 0) ? 1 : 0);
                this.keepContentOnPlayerReset = n19;
                n19 = R$styleable.PlayerView_hide_during_ads;
                n20 = 1;
                n19 = (int)(object.getBoolean(n19, n20 != 0) ? 1 : 0);
                n20 = R$styleable.PlayerView_use_sensor_rotation;
                int n26 = n19;
                n19 = (int)(this.useSensorRotation ? 1 : 0);
                this.useSensorRotation = n19 = object.getBoolean(n20, n19 != 0);
                n11 = n21;
                n19 = n13;
                n20 = n12;
                n13 = n23;
                n12 = n14;
                n23 = n26;
                n14 = n15;
                n15 = n16;
                n16 = (int)(n17 ? 1 : 0);
                int n27 = n18;
                n18 = n25;
                n25 = n22;
                break block63;
                finally {
                    object.recycle();
                }
            }
            n13 = n23;
            n20 = 1;
            n23 = 1;
            n24 = 0;
            playerControlView = null;
            n25 = 0;
            view = null;
            n11 = 1;
            n18 = 1;
            boolean bl2 = false;
            n16 = 0;
            n15 = 1;
            n14 = 0;
            n12 = 1;
        }
        LayoutInflater layoutInflater = LayoutInflater.from((Context)context);
        layoutInflater.inflate(n19, (ViewGroup)playerView);
        playerView.setDescendantFocusability(262144);
        n19 = R$id.exo_content_frame;
        frameLayout = (AspectRatioFrameLayout)playerView.findViewById(n19);
        playerView.contentFrame = frameLayout;
        if (frameLayout != null) {
            PlayerView.setResizeModeRaw((AspectRatioFrameLayout)frameLayout, n25);
        }
        n25 = R$id.exo_shutter;
        playerView.shutterView = view = playerView.findViewById(n25);
        if (view != null && n16 != 0) {
            void var19_23;
            view.setBackgroundColor((int)var19_23);
        }
        if (frameLayout != null && n11 != 0) {
            int n28 = -1;
            super(n28, n28);
            int n29 = 2;
            if (n11 != n29) {
                int n30 = 3;
                if (n11 != n30) {
                    int n31 = 4;
                    if (n11 != n31) {
                        super((Context)object2);
                        playerView.surfaceView = object;
                    } else {
                        super((Context)object2);
                        playerView.surfaceView = object;
                    }
                } else {
                    super((Context)object2);
                    ((SphericalGLSurfaceView)((Object)object)).setSingleTapListener(playerView$ComponentListener);
                    boolean bl3 = playerView.useSensorRotation;
                    ((SphericalGLSurfaceView)((Object)object)).setUseSensorRotation(bl3);
                    playerView.surfaceView = object;
                }
            } else {
                super((Context)object2);
                playerView.surfaceView = object;
            }
            playerView.surfaceView.setLayoutParams((ViewGroup.LayoutParams)view);
            view = playerView.surfaceView;
            n11 = 0;
            object = null;
            frameLayout.addView(view, 0);
        } else {
            n19 = 0;
            frameLayout = null;
            playerView.surfaceView = null;
        }
        n19 = R$id.exo_ad_overlay;
        playerView.adOverlayFrameLayout = frameLayout = (FrameLayout)playerView.findViewById(n19);
        n19 = R$id.exo_overlay;
        playerView.overlayFrameLayout = frameLayout = (FrameLayout)playerView.findViewById(n19);
        n19 = R$id.exo_artwork;
        frameLayout = (ImageView)playerView.findViewById(n19);
        playerView.artworkView = frameLayout;
        if (n15 != 0 && frameLayout != null) {
            n19 = 1;
        } else {
            n19 = 0;
            frameLayout = null;
        }
        playerView.useArtwork = n19;
        if (n14 != 0) {
            frameLayout = ContextCompat.getDrawable(this.getContext(), n14);
            playerView.defaultArtwork = frameLayout;
        }
        n19 = R$id.exo_subtitles;
        frameLayout = (SubtitleView)playerView.findViewById(n19);
        playerView.subtitleView = frameLayout;
        if (frameLayout != null) {
            frameLayout.setUserDefaultStyle();
            frameLayout.setUserDefaultTextSize();
        }
        n19 = R$id.exo_buffering;
        frameLayout = playerView.findViewById(n19);
        playerView.bufferingView = frameLayout;
        n25 = 8;
        if (frameLayout != null) {
            frameLayout.setVisibility(n25);
        }
        playerView.showBuffering = n24;
        n19 = R$id.exo_error_message;
        frameLayout = (TextView)playerView.findViewById(n19);
        playerView.errorMessageView = frameLayout;
        if (frameLayout != null) {
            frameLayout.setVisibility(n25);
        }
        n19 = R$id.exo_controller;
        playerControlView = (PlayerControlView)playerView.findViewById(n19);
        n25 = R$id.exo_controller_placeholder;
        view = playerView.findViewById(n25);
        if (playerControlView != null) {
            playerView.controller = playerControlView;
            n11 = 0;
            object = null;
        } else if (view != null) {
            n11 = 0;
            object = null;
            boolean bl4 = false;
            playerView.controller = playerControlView = new PlayerControlView((Context)object2, null, 0, attributeSet2);
            playerControlView.setId(n19);
            object2 = view.getLayoutParams();
            playerControlView.setLayoutParams((ViewGroup.LayoutParams)object2);
            object2 = (ViewGroup)view.getParent();
            int n32 = object2.indexOfChild(view);
            object2.removeView(view);
            object2.addView((View)playerControlView, n32);
        } else {
            n11 = 0;
            object = null;
            boolean bl5 = false;
            playerView.controller = null;
        }
        object2 = playerView.controller;
        if (object2 != null) {
            n19 = n13;
        } else {
            n19 = 0;
            frameLayout = null;
        }
        playerView.controllerShowTimeoutMs = n19;
        playerView.controllerHideOnTouch = n18;
        playerView.controllerAutoShow = n20;
        playerView.controllerHideDuringAds = n23;
        if (n12 != 0 && object2 != null) {
            n24 = 1;
        } else {
            n24 = 0;
            playerControlView = null;
        }
        playerView.useController = n24;
        this.hideController();
        this.updateContentDescription();
        object2 = playerView.controller;
        if (object2 != null) {
            ((PlayerControlView)((Object)object2)).addVisibilityListener(playerView$ComponentListener);
        }
    }

    public static /* synthetic */ SubtitleView access$000(PlayerView playerView) {
        return playerView.subtitleView;
    }

    public static /* synthetic */ View access$100(PlayerView playerView) {
        return playerView.surfaceView;
    }

    public static /* synthetic */ void access$1000(PlayerView playerView) {
        playerView.updateControllerVisibility();
    }

    public static /* synthetic */ boolean access$1100(PlayerView playerView) {
        return playerView.isPlayingAd();
    }

    public static /* synthetic */ boolean access$1200(PlayerView playerView) {
        return playerView.controllerHideDuringAds;
    }

    public static /* synthetic */ boolean access$1300(PlayerView playerView) {
        return playerView.toggleControllerVisibility();
    }

    public static /* synthetic */ void access$1400(PlayerView playerView) {
        playerView.updateContentDescription();
    }

    public static /* synthetic */ int access$200(PlayerView playerView) {
        return playerView.textureViewRotation;
    }

    public static /* synthetic */ int access$202(PlayerView playerView, int n10) {
        playerView.textureViewRotation = n10;
        return n10;
    }

    public static /* synthetic */ void access$300(TextureView textureView, int n10) {
        PlayerView.applyTextureViewRotation(textureView, n10);
    }

    public static /* synthetic */ AspectRatioFrameLayout access$400(PlayerView playerView) {
        return playerView.contentFrame;
    }

    public static /* synthetic */ View access$500(PlayerView playerView) {
        return playerView.shutterView;
    }

    public static /* synthetic */ Player access$600(PlayerView playerView) {
        return playerView.player;
    }

    public static /* synthetic */ void access$700(PlayerView playerView, boolean bl2) {
        playerView.updateForCurrentTrackSelections(bl2);
    }

    public static /* synthetic */ void access$800(PlayerView playerView) {
        playerView.updateBuffering();
    }

    public static /* synthetic */ void access$900(PlayerView playerView) {
        playerView.updateErrorMessage();
    }

    private static void applyTextureViewRotation(TextureView textureView, int n10) {
        float f10;
        Matrix matrix = new Matrix();
        int n11 = textureView.getWidth();
        float f11 = n11;
        int n12 = textureView.getHeight();
        float f12 = n12;
        RectF rectF = null;
        float f13 = f11 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false && (object = (f10 = f12 - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false && n10 != 0) {
            object = 0x40000000;
            float f14 = 2.0f;
            float f15 = f11 / f14;
            f14 = f12 / f14;
            float f16 = n10;
            matrix.postRotate(f16, f15, f14);
            RectF rectF2 = new RectF(0.0f, 0.0f, f11, f12);
            rectF = new RectF();
            matrix.mapRect(rectF, rectF2);
            f16 = rectF.width();
            f11 /= f16;
            f16 = rectF.height();
            matrix.postScale(f11, f12 /= f16, f15, f14);
        }
        textureView.setTransform(matrix);
    }

    private void closeShutter() {
        View view = this.shutterView;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private static void configureEditModeLogo(Resources resources, ImageView imageView) {
        int n10 = R$drawable.exo_edit_mode_logo;
        Drawable drawable2 = resources.getDrawable(n10);
        imageView.setImageDrawable(drawable2);
        n10 = R$color.exo_edit_mode_background_color;
        int n11 = resources.getColor(n10);
        imageView.setBackgroundColor(n11);
    }

    private static void configureEditModeLogoV23(Resources resources, ImageView imageView) {
        int n10 = R$drawable.exo_edit_mode_logo;
        Drawable drawable2 = resources.getDrawable(n10, null);
        imageView.setImageDrawable(drawable2);
        n10 = R$color.exo_edit_mode_background_color;
        int n11 = resources.getColor(n10, null);
        imageView.setBackgroundColor(n11);
    }

    private void hideArtwork() {
        ImageView imageView = this.artworkView;
        if (imageView != null) {
            imageView.setImageResource(17170445);
            imageView = this.artworkView;
            int n10 = 4;
            imageView.setVisibility(n10);
        }
    }

    private boolean isDpadKey(int n10) {
        int n11 = 19;
        n10 = n10 != n11 && n10 != (n11 = 270) && n10 != (n11 = 22) && n10 != (n11 = 271) && n10 != (n11 = 20) && n10 != (n11 = 269) && n10 != (n11 = 21) && n10 != (n11 = 268) && n10 != (n11 = 23) ? 0 : 1;
        return n10 != 0;
    }

    private boolean isPlayingAd() {
        boolean bl2;
        Player player = this.player;
        if (player != null && (bl2 = player.isPlayingAd()) && (bl2 = (player = this.player).getPlayWhenReady())) {
            bl2 = true;
        } else {
            bl2 = false;
            player = null;
        }
        return bl2;
    }

    private void maybeShowController(boolean bl2) {
        int n10 = this.isPlayingAd();
        if (n10 != 0 && (n10 = this.controllerHideDuringAds) != 0) {
            return;
        }
        n10 = this.useController();
        if (n10 != 0) {
            PlayerControlView playerControlView = this.controller;
            n10 = playerControlView.isVisible();
            if (n10 != 0 && (n10 = (playerControlView = this.controller).getShowTimeoutMs()) <= 0) {
                n10 = 1;
            } else {
                n10 = 0;
                playerControlView = null;
            }
            boolean bl3 = this.shouldShowControllerIndefinitely();
            if (bl2 || n10 != 0 || bl3) {
                this.showController(bl3);
            }
        }
    }

    private boolean setArtworkFromMetadata(Metadata metadata) {
        int n10;
        int n11;
        int n12 = n11 = -1;
        boolean bl2 = false;
        BitmapDrawable bitmapDrawable = null;
        for (int i10 = 0; i10 < (n10 = metadata.length()); ++i10) {
            Object object;
            Metadata$Entry metadata$Entry = metadata.get(i10);
            boolean bl3 = metadata$Entry instanceof ApicFrame;
            if (bl3) {
                metadata$Entry = (ApicFrame)metadata$Entry;
                object = ((ApicFrame)metadata$Entry).pictureData;
                n10 = ((ApicFrame)metadata$Entry).pictureType;
            } else {
                bl3 = metadata$Entry instanceof PictureFrame;
                if (!bl3) continue;
                metadata$Entry = (PictureFrame)metadata$Entry;
                object = ((PictureFrame)metadata$Entry).pictureData;
                n10 = ((PictureFrame)metadata$Entry).pictureType;
            }
            int n13 = 3;
            if (n12 != n11 && n10 != n13) continue;
            n12 = ((byte[])object).length;
            Bitmap bitmap = BitmapFactory.decodeByteArray((byte[])object, (int)0, (int)n12);
            object = this.getResources();
            bitmapDrawable = new BitmapDrawable((Resources)object, bitmap);
            bl2 = this.setDrawableArtwork((Drawable)bitmapDrawable);
            if (n10 == n13) break;
            n12 = n10;
        }
        return bl2;
    }

    private boolean setDrawableArtwork(Drawable drawable2) {
        if (drawable2 != null) {
            int n10 = drawable2.getIntrinsicWidth();
            int n11 = drawable2.getIntrinsicHeight();
            if (n10 > 0 && n11 > 0) {
                float f10 = n10;
                float f11 = n11;
                AspectRatioFrameLayout aspectRatioFrameLayout = this.contentFrame;
                ImageView imageView = this.artworkView;
                this.onContentAspectRatioChanged(f10 /= f11, aspectRatioFrameLayout, (View)imageView);
                this.artworkView.setImageDrawable(drawable2);
                this.artworkView.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    private static void setResizeModeRaw(AspectRatioFrameLayout aspectRatioFrameLayout, int n10) {
        aspectRatioFrameLayout.setResizeMode(n10);
    }

    private boolean shouldShowControllerIndefinitely() {
        Player player = this.player;
        int n10 = 1;
        if (player == null) {
            return n10 != 0;
        }
        int n11 = player.getPlaybackState();
        int n12 = this.controllerAutoShow;
        if (n12 == 0 || n11 != n10 && n11 != (n12 = 4) && (n11 = (int)((player = this.player).getPlayWhenReady() ? 1 : 0)) != 0) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private void showController(boolean n10) {
        boolean bl2 = this.useController();
        if (!bl2) {
            return;
        }
        PlayerControlView playerControlView = this.controller;
        n10 = n10 != 0 ? 0 : this.controllerShowTimeoutMs;
        playerControlView.setShowTimeoutMs(n10);
        this.controller.show();
    }

    public static void switchTargetView(Player player, PlayerView playerView, PlayerView playerView2) {
        if (playerView == playerView2) {
            return;
        }
        if (playerView2 != null) {
            playerView2.setPlayer(player);
        }
        if (playerView != null) {
            player = null;
            playerView.setPlayer(null);
        }
    }

    private boolean toggleControllerVisibility() {
        Object object;
        boolean bl2 = this.useController();
        if (bl2 && (object = this.player) != null) {
            object = this.controller;
            bl2 = ((PlayerControlView)((Object)object)).isVisible();
            boolean bl3 = true;
            if (!bl2) {
                this.maybeShowController(bl3);
            } else {
                bl2 = this.controllerHideOnTouch;
                if (bl2) {
                    object = this.controller;
                    ((PlayerControlView)((Object)object)).hide();
                }
            }
            return bl3;
        }
        return false;
    }

    private void updateBuffering() {
        Object object = this.bufferingView;
        if (object != null) {
            int n10;
            int n11;
            object = this.player;
            int n12 = 1;
            int n13 = 0;
            if (object == null || (n11 = object.getPlaybackState()) != (n10 = 2) || (n11 = this.showBuffering) != n10 && (n11 != n12 || (n11 = (int)((object = this.player).getPlayWhenReady() ? 1 : 0)) == 0)) {
                n12 = 0;
            }
            object = this.bufferingView;
            if (n12 == 0) {
                n13 = 8;
            }
            object.setVisibility(n13);
        }
    }

    private void updateContentDescription() {
        boolean bl2;
        Object object = this.controller;
        int n10 = 0;
        String string2 = null;
        if (object != null && (bl2 = this.useController)) {
            int n11 = object.getVisibility();
            if (n11 == 0) {
                n11 = (int)(this.controllerHideOnTouch ? 1 : 0);
                if (n11 != 0) {
                    object = this.getResources();
                    n10 = R$string.exo_controls_hide;
                    string2 = object.getString(n10);
                }
                this.setContentDescription(string2);
            } else {
                object = this.getResources();
                n10 = R$string.exo_controls_show;
                object = object.getString(n10);
                this.setContentDescription((CharSequence)object);
            }
        } else {
            this.setContentDescription(null);
        }
    }

    private void updateControllerVisibility() {
        boolean bl2 = this.isPlayingAd();
        if (bl2 && (bl2 = this.controllerHideDuringAds)) {
            this.hideController();
        } else {
            bl2 = false;
            this.maybeShowController(false);
        }
    }

    private void updateErrorMessage() {
        Object object = this.errorMessageView;
        if (object != null) {
            Object object2 = this.customErrorMessage;
            if (object2 != null) {
                object.setText((CharSequence)object2);
                this.errorMessageView.setVisibility(0);
                return;
            }
            object = this.player;
            object = object != null ? object.getPlayerError() : null;
            if (object != null && (object2 = this.errorMessageProvider) != null) {
                object = (CharSequence)object2.getErrorMessage((Throwable)object).second;
                object2 = this.errorMessageView;
                object2.setText((CharSequence)object);
                object = this.errorMessageView;
                object.setVisibility(0);
            } else {
                object = this.errorMessageView;
                int n10 = 8;
                object.setVisibility(n10);
            }
        }
    }

    private void updateForCurrentTrackSelections(boolean bl2) {
        TrackGroupArray trackGroupArray;
        int n10;
        Object object = this.player;
        if (object != null && (n10 = (trackGroupArray = object.getCurrentTrackGroups()).isEmpty()) == 0) {
            int n11;
            if (bl2 && !(bl2 = this.keepContentOnPlayerReset)) {
                this.closeShutter();
            }
            Object object2 = object.getCurrentTrackSelections();
            trackGroupArray = null;
            for (n10 = 0; n10 < (n11 = ((TrackSelectionArray)object2).length); ++n10) {
                TrackSelection trackSelection;
                int n12;
                n11 = object.getRendererType(n10);
                if (n11 != (n12 = 2) || (trackSelection = ((TrackSelectionArray)object2).get(n10)) == null) continue;
                this.hideArtwork();
                return;
            }
            this.closeShutter();
            bl2 = this.useArtwork();
            if (bl2) {
                boolean bl3;
                object2 = object.getCurrentStaticMetadata().iterator();
                while (bl3 = object2.hasNext()) {
                    object = (Metadata)object2.next();
                    bl3 = this.setArtworkFromMetadata((Metadata)object);
                    if (!bl3) continue;
                    return;
                }
                object2 = this.defaultArtwork;
                bl2 = this.setDrawableArtwork((Drawable)object2);
                if (bl2) {
                    return;
                }
            }
            this.hideArtwork();
            return;
        }
        bl2 = this.keepContentOnPlayerReset;
        if (!bl2) {
            this.hideArtwork();
            this.closeShutter();
        }
    }

    private boolean useArtwork() {
        boolean bl2 = this.useArtwork;
        if (bl2) {
            Assertions.checkStateNotNull(this.artworkView);
            return true;
        }
        return false;
    }

    private boolean useController() {
        boolean bl2 = this.useController;
        if (bl2) {
            Assertions.checkStateNotNull((Object)this.controller);
            return true;
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean bl2;
        PlayerControlView playerControlView;
        boolean bl3;
        int n10;
        Player player = this.player;
        if (player != null && (n10 = player.isPlayingAd()) != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        n10 = keyEvent.getKeyCode();
        n10 = (int)(this.isDpadKey(n10) ? 1 : 0);
        boolean bl4 = false;
        boolean bl5 = true;
        if (n10 != 0 && (bl3 = this.useController()) && !(bl3 = (playerControlView = this.controller).isVisible())) {
            this.maybeShowController(bl5);
            return bl5;
        }
        bl3 = this.dispatchMediaKeyEvent(keyEvent);
        if (bl3 || (bl2 = super.dispatchKeyEvent(keyEvent))) {
            this.maybeShowController(bl5);
            return bl5;
        }
        if (n10 == 0) return bl4;
        bl2 = this.useController();
        if (!bl2) return bl4;
        this.maybeShowController(bl5);
        return bl4;
    }

    public boolean dispatchMediaKeyEvent(KeyEvent keyEvent) {
        PlayerControlView playerControlView;
        boolean bl2;
        boolean bl3 = this.useController();
        if (bl3 && (bl2 = (playerControlView = this.controller).dispatchMediaKeyEvent(keyEvent))) {
            bl2 = true;
        } else {
            bl2 = false;
            keyEvent = null;
        }
        return bl2;
    }

    public List getAdOverlayInfos() {
        AdsLoader$OverlayInfo adsLoader$OverlayInfo;
        int n10;
        ArrayList<AdsLoader$OverlayInfo> arrayList = new ArrayList<AdsLoader$OverlayInfo>();
        FrameLayout frameLayout = this.overlayFrameLayout;
        if (frameLayout != null) {
            n10 = 3;
            String string2 = "Transparent overlay does not impact viewability";
            adsLoader$OverlayInfo = new AdsLoader$OverlayInfo((View)frameLayout, n10, string2);
            arrayList.add(adsLoader$OverlayInfo);
        }
        if ((frameLayout = this.controller) != null) {
            n10 = 0;
            adsLoader$OverlayInfo = new AdsLoader$OverlayInfo((View)frameLayout, 0);
            arrayList.add(adsLoader$OverlayInfo);
        }
        return ImmutableList.copyOf(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup)Assertions.checkStateNotNull(this.adOverlayFrameLayout, "exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.controllerAutoShow;
    }

    public boolean getControllerHideOnTouch() {
        return this.controllerHideOnTouch;
    }

    public int getControllerShowTimeoutMs() {
        return this.controllerShowTimeoutMs;
    }

    public Drawable getDefaultArtwork() {
        return this.defaultArtwork;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.overlayFrameLayout;
    }

    public Player getPlayer() {
        return this.player;
    }

    public int getResizeMode() {
        Assertions.checkStateNotNull((Object)this.contentFrame);
        return this.contentFrame.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.subtitleView;
    }

    public boolean getUseArtwork() {
        return this.useArtwork;
    }

    public boolean getUseController() {
        return this.useController;
    }

    public View getVideoSurfaceView() {
        return this.surfaceView;
    }

    public void hideController() {
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null) {
            playerControlView.hide();
        }
    }

    public boolean isControllerVisible() {
        boolean bl2;
        PlayerControlView playerControlView = this.controller;
        if (playerControlView != null && (bl2 = playerControlView.isVisible())) {
            bl2 = true;
        } else {
            bl2 = false;
            playerControlView = null;
        }
        return bl2;
    }

    public void onContentAspectRatioChanged(float f10, AspectRatioFrameLayout aspectRatioFrameLayout, View view) {
        if (aspectRatioFrameLayout != null) {
            boolean bl2 = view instanceof SphericalGLSurfaceView;
            if (bl2) {
                f10 = 0.0f;
            }
            aspectRatioFrameLayout.setAspectRatio(f10);
        }
    }

    public void onPause() {
        Object object = this.surfaceView;
        boolean bl2 = object instanceof SphericalGLSurfaceView;
        if (bl2) {
            object = (SphericalGLSurfaceView)((Object)object);
            ((SphericalGLSurfaceView)((Object)object)).onPause();
        }
    }

    public void onResume() {
        Object object = this.surfaceView;
        boolean bl2 = object instanceof SphericalGLSurfaceView;
        if (bl2) {
            object = (SphericalGLSurfaceView)((Object)object);
            ((SphericalGLSurfaceView)((Object)object)).onResume();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Player player;
        int n10 = this.useController();
        if (n10 && (player = this.player) != null) {
            int n11 = motionEvent.getAction();
            n10 = 1;
            if (n11 != 0) {
                if (n11 != n10) {
                    return false;
                }
                n11 = (int)(this.isTouching ? 1 : 0);
                if (n11 != 0) {
                    this.isTouching = false;
                    this.performClick();
                    return n10 != 0;
                }
                return false;
            }
            this.isTouching = n10;
            return n10 != 0;
        }
        return false;
    }

    public boolean onTrackballEvent(MotionEvent object) {
        boolean bl2 = this.useController();
        if (bl2 && (object = this.player) != null) {
            bl2 = true;
            this.maybeShowController(bl2);
            return bl2;
        }
        return false;
    }

    public boolean performClick() {
        super.performClick();
        return this.toggleControllerVisibility();
    }

    public void setAspectRatioListener(AspectRatioFrameLayout$AspectRatioListener aspectRatioFrameLayout$AspectRatioListener) {
        Assertions.checkStateNotNull((Object)this.contentFrame);
        this.contentFrame.setAspectRatioListener(aspectRatioFrameLayout$AspectRatioListener);
    }

    public void setControlDispatcher(ControlDispatcher controlDispatcher) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setControlDispatcher(controlDispatcher);
    }

    public void setControllerAutoShow(boolean bl2) {
        this.controllerAutoShow = bl2;
    }

    public void setControllerHideDuringAds(boolean bl2) {
        this.controllerHideDuringAds = bl2;
    }

    public void setControllerHideOnTouch(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controllerHideOnTouch = bl2;
        this.updateContentDescription();
    }

    public void setControllerShowTimeoutMs(int n10) {
        PlayerControlView playerControlView = this.controller;
        Assertions.checkStateNotNull((Object)playerControlView);
        this.controllerShowTimeoutMs = n10;
        PlayerControlView playerControlView2 = this.controller;
        n10 = (int)(playerControlView2.isVisible() ? 1 : 0);
        if (n10 != 0) {
            this.showController();
        }
    }

    public void setControllerVisibilityListener(PlayerControlView$VisibilityListener playerControlView$VisibilityListener) {
        Assertions.checkStateNotNull((Object)this.controller);
        Object object = this.controllerVisibilityListener;
        if (object == playerControlView$VisibilityListener) {
            return;
        }
        if (object != null) {
            PlayerControlView playerControlView = this.controller;
            playerControlView.removeVisibilityListener((PlayerControlView$VisibilityListener)object);
        }
        this.controllerVisibilityListener = playerControlView$VisibilityListener;
        if (playerControlView$VisibilityListener != null) {
            object = this.controller;
            ((PlayerControlView)((Object)object)).addVisibilityListener(playerControlView$VisibilityListener);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        boolean bl2;
        TextView textView = this.errorMessageView;
        if (textView != null) {
            bl2 = true;
        } else {
            bl2 = false;
            textView = null;
        }
        Assertions.checkState(bl2);
        this.customErrorMessage = charSequence;
        this.updateErrorMessage();
    }

    public void setDefaultArtwork(Drawable drawable2) {
        Drawable drawable3 = this.defaultArtwork;
        if (drawable3 != drawable2) {
            this.defaultArtwork = drawable2;
            drawable2 = null;
            this.updateForCurrentTrackSelections(false);
        }
    }

    public void setErrorMessageProvider(ErrorMessageProvider errorMessageProvider) {
        ErrorMessageProvider errorMessageProvider2 = this.errorMessageProvider;
        if (errorMessageProvider2 != errorMessageProvider) {
            this.errorMessageProvider = errorMessageProvider;
            this.updateErrorMessage();
        }
    }

    public void setExtraAdGroupMarkers(long[] lArray, boolean[] blArray) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setExtraAdGroupMarkers(lArray, blArray);
    }

    public void setFastForwardIncrementMs(int n10) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setFastForwardIncrementMs(n10);
    }

    public void setKeepContentOnPlayerReset(boolean bl2) {
        boolean bl3 = this.keepContentOnPlayerReset;
        if (bl3 != bl2) {
            this.keepContentOnPlayerReset = bl2;
            bl2 = false;
            this.updateForCurrentTrackSelections(false);
        }
    }

    public void setPlaybackPreparer(PlaybackPreparer playbackPreparer) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setPlaybackPreparer(playbackPreparer);
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
            bl2 = false;
            object = null;
        } else {
            bl2 = bl3;
        }
        Assertions.checkArgument(bl2);
        object = this.player;
        if (object == player) {
            return;
        }
        object2 = null;
        if (object != null) {
            Object object3 = this.componentListener;
            object.removeListener((Player$EventListener)object3);
            object3 = object.getVideoComponent();
            if (object3 != null) {
                Object object4 = this.componentListener;
                object3.removeVideoListener((VideoListener)object4);
                object4 = this.surfaceView;
                boolean bl4 = object4 instanceof TextureView;
                if (bl4) {
                    object4 = (TextureView)object4;
                    object3.clearVideoTextureView((TextureView)object4);
                } else {
                    bl4 = object4 instanceof SphericalGLSurfaceView;
                    if (bl4) {
                        object4 = (SphericalGLSurfaceView)((Object)object4);
                        ((SphericalGLSurfaceView)((Object)object4)).setVideoComponent(null);
                    } else {
                        bl4 = object4 instanceof SurfaceView;
                        if (bl4) {
                            object4 = (SurfaceView)object4;
                            object3.clearVideoSurfaceView((SurfaceView)object4);
                        }
                    }
                }
            }
            if ((object = object.getTextComponent()) != null) {
                object3 = this.componentListener;
                object.removeTextOutput((TextOutput)object3);
            }
        }
        if ((object = this.subtitleView) != null) {
            ((SubtitleView)object).setCues(null);
        }
        this.player = player;
        bl2 = this.useController();
        if (bl2) {
            object = this.controller;
            ((PlayerControlView)((Object)object)).setPlayer(player);
        }
        this.updateBuffering();
        this.updateErrorMessage();
        this.updateForCurrentTrackSelections(bl3);
        if (player != null) {
            object = player.getVideoComponent();
            if (object != null) {
                object2 = this.surfaceView;
                bl3 = object2 instanceof TextureView;
                if (bl3) {
                    object2 = (TextureView)object2;
                    object.setVideoTextureView((TextureView)object2);
                } else {
                    bl3 = object2 instanceof SphericalGLSurfaceView;
                    if (bl3) {
                        object2 = (SphericalGLSurfaceView)((Object)object2);
                        ((SphericalGLSurfaceView)((Object)object2)).setVideoComponent((Player$VideoComponent)object);
                    } else {
                        bl3 = object2 instanceof SurfaceView;
                        if (bl3) {
                            object2 = (SurfaceView)object2;
                            object.setVideoSurfaceView((SurfaceView)object2);
                        }
                    }
                }
                object2 = this.componentListener;
                object.addVideoListener((VideoListener)object2);
            }
            if ((object = player.getTextComponent()) != null) {
                object2 = this.componentListener;
                object.addTextOutput((TextOutput)object2);
                object2 = this.subtitleView;
                if (object2 != null) {
                    object = object.getCurrentCues();
                    ((SubtitleView)object2).setCues((List)object);
                }
            }
            object = this.componentListener;
            player.addListener((Player$EventListener)object);
            this.maybeShowController(false);
        } else {
            this.hideController();
        }
    }

    public void setRepeatToggleModes(int n10) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setRepeatToggleModes(n10);
    }

    public void setResizeMode(int n10) {
        Assertions.checkStateNotNull((Object)this.contentFrame);
        this.contentFrame.setResizeMode(n10);
    }

    public void setRewindIncrementMs(int n10) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setRewindIncrementMs(n10);
    }

    public void setShowBuffering(int n10) {
        int n11 = this.showBuffering;
        if (n11 != n10) {
            this.showBuffering = n10;
            this.updateBuffering();
        }
    }

    public void setShowFastForwardButton(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowFastForwardButton(bl2);
    }

    public void setShowMultiWindowTimeBar(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowMultiWindowTimeBar(bl2);
    }

    public void setShowNextButton(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowNextButton(bl2);
    }

    public void setShowPreviousButton(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowPreviousButton(bl2);
    }

    public void setShowRewindButton(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowRewindButton(bl2);
    }

    public void setShowShuffleButton(boolean bl2) {
        Assertions.checkStateNotNull((Object)this.controller);
        this.controller.setShowShuffleButton(bl2);
    }

    public void setShutterBackgroundColor(int n10) {
        View view = this.shutterView;
        if (view != null) {
            view.setBackgroundColor(n10);
        }
    }

    public void setUseArtwork(boolean bl2) {
        boolean bl3;
        ImageView imageView;
        if (bl2 && (imageView = this.artworkView) == null) {
            bl3 = false;
            imageView = null;
        } else {
            bl3 = true;
        }
        Assertions.checkState(bl3);
        bl3 = this.useArtwork;
        if (bl3 != bl2) {
            this.useArtwork = bl2;
            this.updateForCurrentTrackSelections(false);
        }
    }

    public void setUseController(boolean bl2) {
        boolean bl3;
        Object object;
        if (bl2 && (object = this.controller) == null) {
            bl3 = false;
            object = null;
        } else {
            bl3 = true;
        }
        Assertions.checkState(bl3);
        bl3 = this.useController;
        if (bl3 == bl2) {
            return;
        }
        this.useController = bl2;
        bl2 = this.useController();
        if (bl2) {
            PlayerControlView playerControlView = this.controller;
            object = this.player;
            playerControlView.setPlayer((Player)object);
        } else {
            PlayerControlView playerControlView = this.controller;
            if (playerControlView != null) {
                playerControlView.hide();
                playerControlView = this.controller;
                bl3 = false;
                object = null;
                playerControlView.setPlayer(null);
            }
        }
        this.updateContentDescription();
    }

    public void setUseSensorRotation(boolean bl2) {
        boolean bl3 = this.useSensorRotation;
        if (bl3 != bl2) {
            this.useSensorRotation = bl2;
            Object object = this.surfaceView;
            boolean bl4 = object instanceof SphericalGLSurfaceView;
            if (bl4) {
                object = (SphericalGLSurfaceView)((Object)object);
                ((SphericalGLSurfaceView)((Object)object)).setUseSensorRotation(bl2);
            }
        }
    }

    public void setVisibility(int n10) {
        super.setVisibility(n10);
        View view = this.surfaceView;
        boolean bl2 = view instanceof SurfaceView;
        if (bl2) {
            view.setVisibility(n10);
        }
    }

    public void showController() {
        boolean bl2 = this.shouldShowControllerIndefinitely();
        this.showController(bl2);
    }
}

