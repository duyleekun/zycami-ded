/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.widget.ImageView$ScaleType
 */
package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView$1;
import com.airbnb.lottie.LottieAnimationView$4;
import com.airbnb.lottie.LottieAnimationView$5;
import com.airbnb.lottie.LottieAnimationView$6;
import com.airbnb.lottie.LottieAnimationView$7;
import com.airbnb.lottie.LottieAnimationView$SavedState;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.R$attr;
import com.airbnb.lottie.R$styleable;
import com.airbnb.lottie.RenderMode;
import com.airbnb.lottie.SimpleColorFilter;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.utils.Utils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Set;

public class LottieAnimationView
extends AppCompatImageView {
    private static final LottieListener DEFAULT_FAILURE_LISTENER;
    private static final String TAG;
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private int buildDrawingCacheDepth;
    private boolean cacheComposition;
    private LottieComposition composition;
    private LottieTask compositionTask;
    private LottieListener failureListener;
    private int fallbackResource;
    private boolean isInitialized;
    private final LottieListener loadedListener;
    private final LottieDrawable lottieDrawable;
    private final Set lottieOnCompositionLoadedListeners;
    private boolean playAnimationWhenShown;
    private RenderMode renderMode;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;
    private final LottieListener wrappedFailureListener;

    static {
        TAG = LottieAnimationView.class.getSimpleName();
        LottieAnimationView$1 lottieAnimationView$1 = new LottieAnimationView$1();
        DEFAULT_FAILURE_LISTENER = lottieAnimationView$1;
    }

    public LottieAnimationView(Context object) {
        super((Context)object);
        Object object2;
        super(this);
        this.loadedListener = object;
        super(this);
        this.wrappedFailureListener = object;
        this.fallbackResource = 0;
        this.lottieDrawable = object2 = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        object2 = RenderMode.AUTOMATIC;
        this.renderMode = object2;
        super();
        this.lottieOnCompositionLoadedListeners = object2;
        this.buildDrawingCacheDepth = 0;
        int n10 = R$attr.lottieAnimationViewStyle;
        this.init(null, n10);
    }

    public LottieAnimationView(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        Object object2;
        super(this);
        this.loadedListener = object;
        super(this);
        this.wrappedFailureListener = object;
        this.fallbackResource = 0;
        this.lottieDrawable = object2 = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        object2 = RenderMode.AUTOMATIC;
        this.renderMode = object2;
        super();
        this.lottieOnCompositionLoadedListeners = object2;
        this.buildDrawingCacheDepth = 0;
        int n10 = R$attr.lottieAnimationViewStyle;
        this.init(attributeSet, n10);
    }

    public LottieAnimationView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        Object object2;
        super(this);
        this.loadedListener = object;
        super(this);
        this.wrappedFailureListener = object;
        this.fallbackResource = 0;
        this.lottieDrawable = object2 = new LottieDrawable();
        this.playAnimationWhenShown = false;
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.cacheComposition = true;
        object2 = RenderMode.AUTOMATIC;
        this.renderMode = object2;
        super();
        this.lottieOnCompositionLoadedListeners = object2;
        this.buildDrawingCacheDepth = 0;
        this.init(attributeSet, n10);
    }

    public static /* synthetic */ int access$000(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.fallbackResource;
    }

    public static /* synthetic */ LottieListener access$100(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.failureListener;
    }

    public static /* synthetic */ LottieListener access$200() {
        return DEFAULT_FAILURE_LISTENER;
    }

    public static /* synthetic */ boolean access$300(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.cacheComposition;
    }

    private void cancelLoaderTask() {
        LottieTask lottieTask = this.compositionTask;
        if (lottieTask != null) {
            LottieListener lottieListener = this.loadedListener;
            lottieTask.removeListener(lottieListener);
            lottieTask = this.compositionTask;
            lottieListener = this.wrappedFailureListener;
            lottieTask.removeFailureListener(lottieListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.clearComposition();
    }

    /*
     * Enabled aggressive block sorting
     */
    private void enableOrDisableHardwareLayer() {
        int n10;
        int n11;
        block5: {
            int n12;
            block6: {
                int n13;
                int n14;
                n11 = Build.VERSION.SDK_INT;
                Object object = LottieAnimationView$7.$SwitchMap$com$airbnb$lottie$RenderMode;
                RenderMode renderMode = this.renderMode;
                n10 = renderMode.ordinal();
                int n15 = object[n10];
                n10 = 2;
                n12 = 1;
                if (n15 == n12) break block5;
                if (n15 == n10 || n15 != (n14 = 3)) break block6;
                object = this.composition;
                n14 = 0;
                if (!(object != null && (n15 = (int)(((LottieComposition)object).hasDashPattern() ? 1 : 0)) != 0 && n11 < (n15 = 28) || (object = this.composition) != null && (n15 = ((LottieComposition)object).getMaskAndMatteCount()) > (n13 = 4) || n11 < (n15 = 21) || n11 == (n15 = 24) || n11 == (n15 = 25))) {
                    n14 = n12;
                }
                if (n14 != 0) break block5;
            }
            n10 = n12;
        }
        if (n10 != (n11 = this.getLayerType())) {
            n11 = 0;
            this.setLayerType(n10, null);
        }
    }

    private LottieTask fromAssets(String object) {
        boolean bl2 = this.isInEditMode();
        if (bl2) {
            LottieAnimationView$5 lottieAnimationView$5 = new LottieAnimationView$5(this, (String)object);
            LottieTask lottieTask = new LottieTask(lottieAnimationView$5, true);
            return lottieTask;
        }
        bl2 = this.cacheComposition;
        if (bl2) {
            Context context = this.getContext();
            object = LottieCompositionFactory.fromAsset(context, (String)object);
        } else {
            Context context = this.getContext();
            Object var4_7 = null;
            object = LottieCompositionFactory.fromAsset(context, (String)object, null);
        }
        return object;
    }

    private LottieTask fromRawRes(int n10) {
        LottieTask lottieTask;
        boolean bl2 = this.isInEditMode();
        if (bl2) {
            LottieAnimationView$4 lottieAnimationView$4 = new LottieAnimationView$4(this, n10);
            LottieTask lottieTask2 = new LottieTask(lottieAnimationView$4, true);
            return lottieTask2;
        }
        bl2 = this.cacheComposition;
        if (bl2) {
            Context context = this.getContext();
            lottieTask = LottieCompositionFactory.fromRawRes(context, n10);
        } else {
            Context context = this.getContext();
            Object var4_7 = null;
            lottieTask = LottieCompositionFactory.fromRawRes(context, n10, null);
        }
        return lottieTask;
    }

    private void init(AttributeSet object, int n10) {
        RenderMode[] renderModeArray;
        Object object2;
        float f10;
        Object object3;
        Context context = this.getContext();
        int[] nArray = R$styleable.LottieAnimationView;
        boolean bl2 = false;
        object = context.obtainStyledAttributes((AttributeSet)object, nArray, n10, 0);
        n10 = R$styleable.LottieAnimationView_lottie_cacheComposition;
        boolean bl3 = true;
        n10 = (int)(object.getBoolean(n10, bl3) ? 1 : 0);
        this.cacheComposition = n10;
        n10 = R$styleable.LottieAnimationView_lottie_rawRes;
        int n11 = object.hasValue(n10);
        int n12 = R$styleable.LottieAnimationView_lottie_fileName;
        int n13 = object.hasValue(n12);
        int n14 = R$styleable.LottieAnimationView_lottie_url;
        boolean bl4 = object.hasValue(n14);
        if (n11 != 0 && n13 != 0) {
            object = new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            throw object;
        }
        if (n11 != 0) {
            if ((n10 = object.getResourceId(n10, 0)) != 0) {
                this.setAnimation(n10);
            }
        } else if (n13 != 0) {
            object3 = object.getString(n12);
            if (object3 != null) {
                this.setAnimation((String)object3);
            }
        } else if (bl4 && (object3 = object.getString(n14)) != null) {
            this.setAnimationFromUrl((String)object3);
        }
        n10 = R$styleable.LottieAnimationView_lottie_fallbackRes;
        n10 = object.getResourceId(n10, 0);
        this.setFallbackResource(n10);
        n10 = R$styleable.LottieAnimationView_lottie_autoPlay;
        n10 = (int)(object.getBoolean(n10, false) ? 1 : 0);
        if (n10 != 0) {
            this.wasAnimatingWhenDetached = bl3;
            this.autoPlay = bl3;
        }
        n10 = R$styleable.LottieAnimationView_lottie_loop;
        n10 = (int)(object.getBoolean(n10, false) ? 1 : 0);
        n11 = -1;
        if (n10 != 0) {
            object3 = this.lottieDrawable;
            ((LottieDrawable)((Object)object3)).setRepeatCount(n11);
        }
        if ((n12 = (int)(object.hasValue(n10 = R$styleable.LottieAnimationView_lottie_repeatMode) ? 1 : 0)) != 0) {
            n10 = object.getInt(n10, (int)(bl3 ? 1 : 0));
            this.setRepeatMode(n10);
        }
        if ((n12 = (int)(object.hasValue(n10 = R$styleable.LottieAnimationView_lottie_repeatCount) ? 1 : 0)) != 0) {
            n10 = object.getInt(n10, n11);
            this.setRepeatCount(n10);
        }
        n10 = R$styleable.LottieAnimationView_lottie_speed;
        n11 = (int)(object.hasValue(n10) ? 1 : 0);
        n12 = 1065353216;
        float f11 = 1.0f;
        if (n11 != 0) {
            f10 = object.getFloat(n10, f11);
            this.setSpeed(f10);
        }
        n10 = R$styleable.LottieAnimationView_lottie_imageAssetsFolder;
        object3 = object.getString(n10);
        this.setImageAssetsFolder((String)object3);
        n10 = R$styleable.LottieAnimationView_lottie_progress;
        n11 = 0;
        nArray = null;
        f10 = object.getFloat(n10, 0.0f);
        this.setProgress(f10);
        n10 = R$styleable.LottieAnimationView_lottie_enableMergePathsForKitKatAndAbove;
        n10 = (int)(object.getBoolean(n10, false) ? 1 : 0);
        this.enableMergePathsForKitKatAndAbove(n10 != 0);
        n10 = R$styleable.LottieAnimationView_lottie_colorFilter;
        n13 = object.hasValue(n10);
        if (n13 != 0) {
            n10 = object.getColor(n10, 0);
            object2 = new SimpleColorFilter(n10);
            Object object4 = new String[]{"**"};
            object3 = new KeyPath((String)object4);
            object4 = new LottieValueCallback(object2);
            object2 = LottieProperty.COLOR_FILTER;
            this.addValueCallback((KeyPath)object3, object2, (LottieValueCallback)object4);
        }
        if ((n13 = object.hasValue(n10 = R$styleable.LottieAnimationView_lottie_scale)) != 0) {
            object2 = this.lottieDrawable;
            f10 = object.getFloat(n10, f11);
            ((LottieDrawable)((Object)object2)).setScale(f10);
        }
        if ((n12 = (int)(object.hasValue(n10 = R$styleable.LottieAnimationView_lottie_renderMode) ? 1 : 0)) != 0) {
            renderModeArray = RenderMode.AUTOMATIC;
            n13 = renderModeArray.ordinal();
            if ((n10 = object.getInt(n10, n13)) >= (n13 = ((Object)(object2 = RenderMode.values())).length)) {
                n10 = renderModeArray.ordinal();
            }
            renderModeArray = RenderMode.values();
            object3 = renderModeArray[n10];
            this.setRenderMode((RenderMode)((Object)object3));
        }
        if ((object3 = this.getScaleType()) != null) {
            object3 = this.lottieDrawable;
            renderModeArray = this.getScaleType();
            ((LottieDrawable)((Object)object3)).setScaleType((ImageView.ScaleType)renderModeArray);
        }
        object.recycle();
        object = this.lottieDrawable;
        object3 = this.getContext();
        f10 = Utils.getAnimationScale((Context)object3);
        float f12 = f10 - 0.0f;
        n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
        if (n10 != 0) {
            bl2 = bl3;
        }
        object3 = bl2;
        ((LottieDrawable)((Object)object)).setSystemAnimationsAreEnabled((Boolean)object3);
        this.enableOrDisableHardwareLayer();
        this.isInitialized = bl3;
    }

    private void setCompositionTask(LottieTask lottieTask) {
        this.clearComposition();
        this.cancelLoaderTask();
        LottieListener lottieListener = this.loadedListener;
        lottieTask = lottieTask.addListener(lottieListener);
        lottieListener = this.wrappedFailureListener;
        this.compositionTask = lottieTask = lottieTask.addFailureListener(lottieListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.addAnimatorListener(animatorListener);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.addAnimatorPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.addAnimatorUpdateListener(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieOnCompositionLoadedListener.onCompositionLoaded(lottieComposition);
        }
        return this.lottieOnCompositionLoadedListeners.add(lottieOnCompositionLoadedListener);
    }

    public void addValueCallback(KeyPath keyPath, Object object, LottieValueCallback lottieValueCallback) {
        this.lottieDrawable.addValueCallback(keyPath, object, lottieValueCallback);
    }

    public void addValueCallback(KeyPath keyPath, Object object, SimpleLottieValueCallback simpleLottieValueCallback) {
        LottieDrawable lottieDrawable = this.lottieDrawable;
        LottieAnimationView$6 lottieAnimationView$6 = new LottieAnimationView$6(this, simpleLottieValueCallback);
        lottieDrawable.addValueCallback(keyPath, object, lottieAnimationView$6);
    }

    public void buildDrawingCache(boolean bl2) {
        int n10;
        Object object;
        String string2 = "buildDrawingCache";
        L.beginSection(string2);
        int n11 = this.buildDrawingCacheDepth;
        int n12 = 1;
        this.buildDrawingCacheDepth = n11 += n12;
        super.buildDrawingCache(bl2);
        n11 = this.buildDrawingCacheDepth;
        if (n11 == n12 && (n11 = this.getWidth()) > 0 && (n11 = this.getHeight()) > 0 && (n11 = this.getLayerType()) == n12 && (object = this.getDrawingCache(bl2)) == null) {
            object = RenderMode.HARDWARE;
            this.setRenderMode((RenderMode)((Object)object));
        }
        this.buildDrawingCacheDepth = n10 = this.buildDrawingCacheDepth - n12;
        L.endSection(string2);
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.cancelAnimation();
        this.enableOrDisableHardwareLayer();
    }

    public void disableExtraScaleModeInFitXY() {
        this.lottieDrawable.disableExtraScaleModeInFitXY();
    }

    public void enableMergePathsForKitKatAndAbove(boolean bl2) {
        this.lottieDrawable.enableMergePathsForKitKatAndAbove(bl2);
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        long l10;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            float f10 = lottieComposition.getDuration();
            l10 = (long)f10;
        } else {
            l10 = 0L;
        }
        return l10;
    }

    public int getFrame() {
        return this.lottieDrawable.getFrame();
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.getImageAssetsFolder();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.getMaxFrame();
    }

    public float getMinFrame() {
        return this.lottieDrawable.getMinFrame();
    }

    public PerformanceTracker getPerformanceTracker() {
        return this.lottieDrawable.getPerformanceTracker();
    }

    public float getProgress() {
        return this.lottieDrawable.getProgress();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.getRepeatMode();
    }

    public float getScale() {
        return this.lottieDrawable.getScale();
    }

    public float getSpeed() {
        return this.lottieDrawable.getSpeed();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.hasMasks();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.hasMatte();
    }

    public void invalidateDrawable(Drawable drawable2) {
        LottieDrawable lottieDrawable;
        Drawable drawable3 = this.getDrawable();
        if (drawable3 == (lottieDrawable = this.lottieDrawable)) {
            super.invalidateDrawable((Drawable)lottieDrawable);
        } else {
            super.invalidateDrawable(drawable2);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.isAnimating();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.isMergePathsEnabledForKitKatAndAbove();
    }

    /*
     * WARNING - void declaration
     */
    public void loop(boolean bl2) {
        void var1_4;
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (bl2) {
            int n10 = -1;
        } else {
            boolean bl3 = false;
        }
        lottieDrawable.setRepeatCount((int)var1_4);
    }

    public void onAttachedToWindow() {
        int n10;
        super.onAttachedToWindow();
        int n11 = this.isInEditMode();
        if (n11 == 0 && ((n11 = (int)(this.autoPlay ? 1 : 0)) != 0 || (n11 = (int)(this.wasAnimatingWhenDetached ? 1 : 0)) != 0)) {
            this.playAnimation();
            n11 = 0;
            this.autoPlay = false;
            this.wasAnimatingWhenDetached = false;
        }
        if ((n11 = Build.VERSION.SDK_INT) < (n10 = 23)) {
            n11 = this.getVisibility();
            this.onVisibilityChanged((View)this, n11);
        }
    }

    public void onDetachedFromWindow() {
        boolean bl2 = this.isAnimating();
        if (bl2) {
            this.cancelAnimation();
            this.wasAnimatingWhenDetached = bl2 = true;
        }
        super.onDetachedFromWindow();
    }

    public void onRestoreInstanceState(Parcelable object) {
        int n10 = object instanceof LottieAnimationView$SavedState;
        if (n10 == 0) {
            super.onRestoreInstanceState(object);
            return;
        }
        object = (LottieAnimationView$SavedState)((Object)object);
        Object object2 = object.getSuperState();
        super.onRestoreInstanceState((Parcelable)object2);
        object2 = object.animationName;
        this.animationName = object2;
        n10 = TextUtils.isEmpty((CharSequence)object2);
        if (n10 == 0) {
            object2 = this.animationName;
            this.setAnimation((String)object2);
        }
        this.animationResId = n10 = object.animationResId;
        if (n10 != 0) {
            this.setAnimation(n10);
        }
        float f10 = object.progress;
        this.setProgress(f10);
        n10 = (int)(object.isAnimating ? 1 : 0);
        if (n10 != 0) {
            this.playAnimation();
        }
        object2 = this.lottieDrawable;
        String string2 = object.imageAssetsFolder;
        ((LottieDrawable)((Object)object2)).setImagesAssetsFolder(string2);
        n10 = object.repeatMode;
        this.setRepeatMode(n10);
        int n11 = object.repeatCount;
        this.setRepeatCount(n11);
    }

    public Parcelable onSaveInstanceState() {
        float f10;
        int n10;
        Object object = super.onSaveInstanceState();
        LottieAnimationView$SavedState lottieAnimationView$SavedState = new LottieAnimationView$SavedState((Parcelable)object);
        object = this.animationName;
        lottieAnimationView$SavedState.animationName = object;
        lottieAnimationView$SavedState.animationResId = n10 = this.animationResId;
        lottieAnimationView$SavedState.progress = f10 = this.lottieDrawable.getProgress();
        object = this.lottieDrawable;
        n10 = (int)(object.isAnimating() ? 1 : 0);
        if (n10 == 0 && ((n10 = (int)(ViewCompat.isAttachedToWindow((View)this) ? 1 : 0)) != 0 || (n10 = (int)(this.wasAnimatingWhenDetached ? 1 : 0)) == 0)) {
            n10 = 0;
            f10 = 0.0f;
            object = null;
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        }
        lottieAnimationView$SavedState.isAnimating = n10;
        lottieAnimationView$SavedState.imageAssetsFolder = object = this.lottieDrawable.getImageAssetsFolder();
        lottieAnimationView$SavedState.repeatMode = n10 = this.lottieDrawable.getRepeatMode();
        lottieAnimationView$SavedState.repeatCount = n10 = this.lottieDrawable.getRepeatCount();
        return lottieAnimationView$SavedState;
    }

    public void onVisibilityChanged(View view, int n10) {
        boolean bl2 = this.isInitialized;
        if (!bl2) {
            return;
        }
        bl2 = this.isShown();
        if (bl2) {
            bl2 = this.wasAnimatingWhenNotShown;
            if (bl2) {
                this.resumeAnimation();
            } else {
                bl2 = this.playAnimationWhenShown;
                if (bl2) {
                    this.playAnimation();
                }
            }
            bl2 = false;
            this.wasAnimatingWhenNotShown = false;
            this.playAnimationWhenShown = false;
        } else {
            bl2 = this.isAnimating();
            if (bl2) {
                this.pauseAnimation();
                this.wasAnimatingWhenNotShown = bl2 = true;
            }
        }
    }

    public void pauseAnimation() {
        this.autoPlay = false;
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.playAnimationWhenShown = false;
        this.lottieDrawable.pauseAnimation();
        this.enableOrDisableHardwareLayer();
    }

    public void playAnimation() {
        boolean bl2 = this.isShown();
        if (bl2) {
            LottieDrawable lottieDrawable = this.lottieDrawable;
            lottieDrawable.playAnimation();
            this.enableOrDisableHardwareLayer();
        } else {
            this.playAnimationWhenShown = bl2 = true;
        }
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.removeAllAnimatorListeners();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.removeAllUpdateListeners();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.removeAnimatorListener(animatorListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lottieDrawable.removeAnimatorPauseListener(animatorPauseListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(LottieOnCompositionLoadedListener lottieOnCompositionLoadedListener) {
        return this.lottieOnCompositionLoadedListeners.remove(lottieOnCompositionLoadedListener);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.removeAnimatorUpdateListener(animatorUpdateListener);
    }

    public List resolveKeyPath(KeyPath keyPath) {
        return this.lottieDrawable.resolveKeyPath(keyPath);
    }

    public void resumeAnimation() {
        boolean bl2 = this.isShown();
        if (bl2) {
            LottieDrawable lottieDrawable = this.lottieDrawable;
            lottieDrawable.resumeAnimation();
            this.enableOrDisableHardwareLayer();
        } else {
            Object var2_3 = null;
            this.playAnimationWhenShown = false;
            this.wasAnimatingWhenNotShown = bl2 = true;
        }
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.reverseAnimationSpeed();
    }

    public void setAnimation(int n10) {
        this.animationResId = n10;
        this.animationName = null;
        LottieTask lottieTask = this.fromRawRes(n10);
        this.setCompositionTask(lottieTask);
    }

    public void setAnimation(InputStream object, String string2) {
        object = LottieCompositionFactory.fromJsonInputStream((InputStream)object, string2);
        this.setCompositionTask((LottieTask)object);
    }

    public void setAnimation(String object) {
        this.animationName = object;
        this.animationResId = 0;
        object = this.fromAssets((String)object);
        this.setCompositionTask((LottieTask)object);
    }

    public void setAnimationFromJson(String string2) {
        this.setAnimationFromJson(string2, null);
    }

    public void setAnimationFromJson(String object, String string2) {
        object = ((String)object).getBytes();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])object);
        this.setAnimation(byteArrayInputStream, string2);
    }

    public void setAnimationFromUrl(String object) {
        boolean bl2 = this.cacheComposition;
        if (bl2) {
            Context context = this.getContext();
            object = LottieCompositionFactory.fromUrl(context, (String)object);
        } else {
            Context context = this.getContext();
            object = LottieCompositionFactory.fromUrl(context, (String)object, null);
        }
        this.setCompositionTask((LottieTask)object);
    }

    public void setAnimationFromUrl(String object, String string2) {
        object = LottieCompositionFactory.fromUrl(this.getContext(), (String)object, string2);
        this.setCompositionTask((LottieTask)object);
    }

    public void setApplyingOpacityToLayersEnabled(boolean bl2) {
        this.lottieDrawable.setApplyingOpacityToLayersEnabled(bl2);
    }

    public void setCacheComposition(boolean bl2) {
        this.cacheComposition = bl2;
    }

    public void setComposition(LottieComposition lottieComposition) {
        boolean bl2;
        Object object;
        Object object2;
        Object object3;
        boolean n10 = L.DBG;
        if (n10) {
            object3 = TAG;
            object2 = new StringBuilder();
            object = "Set Composition \n";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(lottieComposition);
            object2 = ((StringBuilder)object2).toString();
            Log.v((String)object3, (String)object2);
        }
        this.lottieDrawable.setCallback((Drawable.Callback)this);
        this.composition = lottieComposition;
        object3 = this.lottieDrawable;
        boolean bl3 = ((LottieDrawable)((Object)object3)).setComposition(lottieComposition);
        this.enableOrDisableHardwareLayer();
        object2 = this.getDrawable();
        object = this.lottieDrawable;
        if (object2 == object && !bl3) {
            return;
        }
        int n11 = this.getVisibility();
        this.onVisibilityChanged((View)this, n11);
        this.requestLayout();
        object3 = this.lottieOnCompositionLoadedListeners.iterator();
        while (bl2 = object3.hasNext()) {
            object2 = (LottieOnCompositionLoadedListener)object3.next();
            object2.onCompositionLoaded(lottieComposition);
        }
    }

    public void setFailureListener(LottieListener lottieListener) {
        this.failureListener = lottieListener;
    }

    public void setFallbackResource(int n10) {
        this.fallbackResource = n10;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.setFontAssetDelegate(fontAssetDelegate);
    }

    public void setFrame(int n10) {
        this.lottieDrawable.setFrame(n10);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.lottieDrawable.setImageAssetDelegate(imageAssetDelegate);
    }

    public void setImageAssetsFolder(String string2) {
        this.lottieDrawable.setImagesAssetsFolder(string2);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    public void setImageDrawable(Drawable drawable2) {
        this.cancelLoaderTask();
        super.setImageDrawable(drawable2);
    }

    public void setImageResource(int n10) {
        this.cancelLoaderTask();
        super.setImageResource(n10);
    }

    public void setMaxFrame(int n10) {
        this.lottieDrawable.setMaxFrame(n10);
    }

    public void setMaxFrame(String string2) {
        this.lottieDrawable.setMaxFrame(string2);
    }

    public void setMaxProgress(float f10) {
        this.lottieDrawable.setMaxProgress(f10);
    }

    public void setMinAndMaxFrame(int n10, int n11) {
        this.lottieDrawable.setMinAndMaxFrame(n10, n11);
    }

    public void setMinAndMaxFrame(String string2) {
        this.lottieDrawable.setMinAndMaxFrame(string2);
    }

    public void setMinAndMaxFrame(String string2, String string3, boolean bl2) {
        this.lottieDrawable.setMinAndMaxFrame(string2, string3, bl2);
    }

    public void setMinAndMaxProgress(float f10, float f11) {
        this.lottieDrawable.setMinAndMaxProgress(f10, f11);
    }

    public void setMinFrame(int n10) {
        this.lottieDrawable.setMinFrame(n10);
    }

    public void setMinFrame(String string2) {
        this.lottieDrawable.setMinFrame(string2);
    }

    public void setMinProgress(float f10) {
        this.lottieDrawable.setMinProgress(f10);
    }

    public void setOutlineMasksAndMattes(boolean bl2) {
        this.lottieDrawable.setOutlineMasksAndMattes(bl2);
    }

    public void setPerformanceTrackingEnabled(boolean bl2) {
        this.lottieDrawable.setPerformanceTrackingEnabled(bl2);
    }

    public void setProgress(float f10) {
        this.lottieDrawable.setProgress(f10);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.renderMode = renderMode;
        this.enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int n10) {
        this.lottieDrawable.setRepeatCount(n10);
    }

    public void setRepeatMode(int n10) {
        this.lottieDrawable.setRepeatMode(n10);
    }

    public void setSafeMode(boolean bl2) {
        this.lottieDrawable.setSafeMode(bl2);
    }

    public void setScale(float f10) {
        this.lottieDrawable.setScale(f10);
        Drawable drawable2 = this.getDrawable();
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (drawable2 == lottieDrawable) {
            f10 = 0.0f;
            this.setImageDrawable(null);
            drawable2 = this.lottieDrawable;
            this.setImageDrawable(drawable2);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        LottieDrawable lottieDrawable = this.lottieDrawable;
        if (lottieDrawable != null) {
            lottieDrawable.setScaleType(scaleType);
        }
    }

    public void setSpeed(float f10) {
        this.lottieDrawable.setSpeed(f10);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.setTextDelegate(textDelegate);
    }

    public Bitmap updateBitmap(String string2, Bitmap bitmap) {
        return this.lottieDrawable.updateBitmap(string2, bitmap);
    }
}

