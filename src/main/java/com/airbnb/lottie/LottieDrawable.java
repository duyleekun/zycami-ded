/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.Animator$AnimatorPauseListener
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.Animatable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package com.airbnb.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.FontAssetDelegate;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable$1;
import com.airbnb.lottie.LottieDrawable$10;
import com.airbnb.lottie.LottieDrawable$11;
import com.airbnb.lottie.LottieDrawable$12;
import com.airbnb.lottie.LottieDrawable$13;
import com.airbnb.lottie.LottieDrawable$14;
import com.airbnb.lottie.LottieDrawable$15;
import com.airbnb.lottie.LottieDrawable$16;
import com.airbnb.lottie.LottieDrawable$17;
import com.airbnb.lottie.LottieDrawable$2;
import com.airbnb.lottie.LottieDrawable$3;
import com.airbnb.lottie.LottieDrawable$4;
import com.airbnb.lottie.LottieDrawable$5;
import com.airbnb.lottie.LottieDrawable$6;
import com.airbnb.lottie.LottieDrawable$7;
import com.airbnb.lottie.LottieDrawable$8;
import com.airbnb.lottie.LottieDrawable$9;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.TextDelegate;
import com.airbnb.lottie.manager.FontAssetManager;
import com.airbnb.lottie.manager.ImageAssetManager;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.LayerParser;
import com.airbnb.lottie.utils.BaseLottieAnimator;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.LottieValueAnimator;
import com.airbnb.lottie.utils.MiscUtils;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottieDrawable
extends Drawable
implements Drawable.Callback,
Animatable {
    public static final int INFINITE = 255;
    public static final int RESTART = 1;
    public static final int REVERSE = 2;
    private static final String TAG = LottieDrawable.class.getSimpleName();
    private int alpha;
    private final LottieValueAnimator animator;
    private final Set colorFilterData;
    private LottieComposition composition;
    private CompositionLayer compositionLayer;
    private boolean enableMergePaths;
    public FontAssetDelegate fontAssetDelegate;
    private FontAssetManager fontAssetManager;
    private ImageAssetDelegate imageAssetDelegate;
    private ImageAssetManager imageAssetManager;
    private String imageAssetsFolder;
    private boolean isApplyingOpacityToLayersEnabled;
    private boolean isDirty;
    private boolean isExtraScaleEnabled;
    private final ArrayList lazyCompositionTasks;
    private final Matrix matrix;
    private boolean outlineMasksAndMattes;
    private boolean performanceTrackingEnabled;
    private final ValueAnimator.AnimatorUpdateListener progressUpdateListener;
    private boolean safeMode;
    private float scale;
    private ImageView.ScaleType scaleType;
    private boolean systemAnimationsEnabled;
    public TextDelegate textDelegate;

    public LottieDrawable() {
        boolean bl2;
        Object object = new Matrix();
        this.matrix = object;
        this.animator = object;
        this.scale = 1.0f;
        this.systemAnimationsEnabled = bl2 = true;
        this.safeMode = false;
        Object object2 = new HashSet();
        this.colorFilterData = object2;
        super();
        this.lazyCompositionTasks = object2;
        object2 = new LottieDrawable$1(this);
        this.progressUpdateListener = object2;
        this.alpha = 255;
        this.isExtraScaleEnabled = bl2;
        this.isDirty = false;
        ((BaseLottieAnimator)((Object)object)).addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
    }

    public static /* synthetic */ CompositionLayer access$000(LottieDrawable lottieDrawable) {
        return lottieDrawable.compositionLayer;
    }

    public static /* synthetic */ LottieValueAnimator access$100(LottieDrawable lottieDrawable) {
        return lottieDrawable.animator;
    }

    private void buildCompositionLayer() {
        CompositionLayer compositionLayer;
        Layer layer = LayerParser.parse(this.composition);
        List list = this.composition.getLayers();
        LottieComposition lottieComposition = this.composition;
        this.compositionLayer = compositionLayer = new CompositionLayer(this, layer, list, lottieComposition);
        boolean bl2 = this.outlineMasksAndMattes;
        if (bl2) {
            bl2 = true;
            compositionLayer.setOutlineMasksAndMattes(bl2);
        }
    }

    private void drawInternal(Canvas canvas) {
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        ImageView.ScaleType scaleType2 = this.scaleType;
        if (scaleType == scaleType2) {
            this.drawWithNewAspectRatio(canvas);
        } else {
            this.drawWithOriginalAspectRatio(canvas);
        }
    }

    private void drawWithNewAspectRatio(Canvas canvas) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer == null) {
            return;
        }
        int n10 = -1;
        Object object = this.getBounds();
        int n11 = object.width();
        float f10 = n11;
        Rect rect = this.composition.getBounds();
        float f11 = rect.width();
        f10 /= f11;
        int n12 = object.height();
        f11 = n12;
        Rect rect2 = this.composition.getBounds();
        float f12 = rect2.height();
        f11 /= f12;
        boolean bl2 = this.isExtraScaleEnabled;
        if (bl2) {
            float f13;
            f12 = Math.min(f10, f11);
            int n13 = 1065353216;
            float f14 = 1.0f;
            float f15 = f12 - f14;
            Object object2 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (object2 < 0) {
                f13 = f14 / f12;
                f10 /= f13;
                f11 /= f13;
            } else {
                object2 = n13;
                f13 = f14;
            }
            n13 = (int)(f13 == f14 ? 0 : (f13 > f14 ? 1 : -1));
            if (n13 > 0) {
                n10 = canvas.save();
                n13 = object.width();
                f14 = n13;
                float f16 = 2.0f;
                f14 /= f16;
                int n14 = object.height();
                float f17 = (float)n14 / f16;
                f16 = f14 * f12;
                f12 *= f17;
                canvas.translate(f14 -= f16, f17 -= f12);
                canvas.scale(f13, f13, f16, f12);
            }
        }
        this.matrix.reset();
        this.matrix.preScale(f10, f11);
        object = this.compositionLayer;
        Matrix matrix = this.matrix;
        n12 = this.alpha;
        ((BaseLayer)object).draw(canvas, matrix, n12);
        if (n10 > 0) {
            canvas.restoreToCount(n10);
        }
    }

    private void drawWithOriginalAspectRatio(Canvas canvas) {
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer == null) {
            return;
        }
        float f10 = this.scale;
        float f11 = this.getMaxScale(canvas);
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        int n10 = 1065353216;
        float f13 = 1.0f;
        if (f12 > 0) {
            f10 = this.scale / f11;
        } else {
            f11 = f10;
            f10 = f13;
        }
        f12 = -1;
        n10 = (int)(f10 == f13 ? 0 : (f10 > f13 ? 1 : -1));
        if (n10 > 0) {
            f12 = canvas.save();
            Rect rect = this.composition.getBounds();
            n10 = rect.width();
            f13 = n10;
            float f14 = 2.0f;
            f13 /= f14;
            Rect rect2 = this.composition.getBounds();
            int n11 = rect2.height();
            float f15 = (float)n11 / f14;
            f14 = f13 * f11;
            float f16 = f15 * f11;
            float f17 = this.getScale() * f13 - f14;
            f13 = this.getScale() * f15 - f16;
            canvas.translate(f17, f13);
            canvas.scale(f10, f10, f14, f16);
        }
        this.matrix.reset();
        this.matrix.preScale(f11, f11);
        compositionLayer = this.compositionLayer;
        Matrix matrix = this.matrix;
        n10 = this.alpha;
        compositionLayer.draw(canvas, matrix, n10);
        if (f12 > 0) {
            canvas.restoreToCount((int)f12);
        }
    }

    private Context getContext() {
        Drawable.Callback callback = this.getCallback();
        if (callback == null) {
            return null;
        }
        boolean bl2 = callback instanceof View;
        if (bl2) {
            return ((View)callback).getContext();
        }
        return null;
    }

    private FontAssetManager getFontAssetManager() {
        Object object = this.getCallback();
        if (object == null) {
            return null;
        }
        object = this.fontAssetManager;
        if (object == null) {
            Drawable.Callback callback = this.getCallback();
            FontAssetDelegate fontAssetDelegate = this.fontAssetDelegate;
            object = new FontAssetManager(callback, fontAssetDelegate);
            this.fontAssetManager = object;
        }
        return this.fontAssetManager;
    }

    private ImageAssetManager getImageAssetManager() {
        Object object;
        boolean bl2;
        Object object2 = this.getCallback();
        Drawable.Callback callback = null;
        if (object2 == null) {
            return null;
        }
        object2 = this.imageAssetManager;
        if (object2 != null && !(bl2 = ((ImageAssetManager)object2).hasSameContext((Context)(object = this.getContext())))) {
            this.imageAssetManager = null;
        }
        if ((object2 = this.imageAssetManager) == null) {
            callback = this.getCallback();
            object = this.imageAssetsFolder;
            ImageAssetDelegate imageAssetDelegate = this.imageAssetDelegate;
            Map map = this.composition.getImages();
            this.imageAssetManager = object2 = new ImageAssetManager(callback, (String)object, imageAssetDelegate, map);
        }
        return this.imageAssetManager;
    }

    private float getMaxScale(Canvas canvas) {
        float f10 = canvas.getWidth();
        float f11 = this.composition.getBounds().width();
        f10 /= f11;
        float f12 = canvas.getHeight();
        f11 = this.composition.getBounds().height();
        return Math.min(f10, f12 /= f11);
    }

    private void updateBounds() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            return;
        }
        float f10 = this.getScale();
        int n10 = (int)((float)this.composition.getBounds().width() * f10);
        int n11 = (int)((float)this.composition.getBounds().height() * f10);
        this.setBounds(0, 0, n10, n11);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.addListener(animatorListener);
    }

    public void addAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.addPauseListener(animatorPauseListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.addUpdateListener(animatorUpdateListener);
    }

    public void addValueCallback(KeyPath object, Object object2, LottieValueCallback lottieValueCallback) {
        Object object3 = this.compositionLayer;
        if (object3 == null) {
            object3 = this.lazyCompositionTasks;
            LottieDrawable$16 lottieDrawable$16 = new LottieDrawable$16(this, (KeyPath)object, object2, lottieValueCallback);
            ((ArrayList)object3).add(lottieDrawable$16);
            return;
        }
        Object object4 = KeyPath.COMPOSITION;
        boolean bl2 = true;
        if (object == object4) {
            ((CompositionLayer)object3).addValueCallback(object2, lottieValueCallback);
        } else {
            object3 = ((KeyPath)object).getResolvedElement();
            if (object3 != null) {
                object = ((KeyPath)object).getResolvedElement();
                object.addValueCallback(object2, lottieValueCallback);
            } else {
                int n10;
                object = this.resolveKeyPath((KeyPath)object);
                object3 = null;
                for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
                    object4 = ((KeyPath)object.get(i10)).getResolvedElement();
                    object4.addValueCallback(object2, lottieValueCallback);
                }
                boolean bl3 = object.isEmpty();
                bl2 ^= bl3;
            }
        }
        if (bl2) {
            this.invalidateSelf();
            object = LottieProperty.TIME_REMAP;
            if (object2 == object) {
                float f10 = this.getProgress();
                this.setProgress(f10);
            }
        }
    }

    public void addValueCallback(KeyPath keyPath, Object object, SimpleLottieValueCallback simpleLottieValueCallback) {
        LottieDrawable$17 lottieDrawable$17 = new LottieDrawable$17(this, simpleLottieValueCallback);
        this.addValueCallback(keyPath, object, lottieDrawable$17);
    }

    public void cancelAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.cancel();
    }

    public void clearComposition() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        boolean bl2 = lottieValueAnimator.isRunning();
        if (bl2) {
            lottieValueAnimator = this.animator;
            lottieValueAnimator.cancel();
        }
        this.composition = null;
        this.compositionLayer = null;
        this.imageAssetManager = null;
        this.animator.clearComposition();
        this.invalidateSelf();
    }

    public void disableExtraScaleModeInFitXY() {
        this.isExtraScaleEnabled = false;
    }

    public void draw(Canvas canvas) {
        this.isDirty = false;
        String string2 = "Drawable#draw";
        L.beginSection(string2);
        boolean bl2 = this.safeMode;
        if (bl2) {
            try {
                this.drawInternal(canvas);
            }
            catch (Throwable throwable) {
                String string3 = "Lottie crashed in draw!";
                Logger.error(string3, throwable);
            }
        } else {
            this.drawInternal(canvas);
        }
        L.endSection(string2);
    }

    public void enableMergePathsForKitKatAndAbove(boolean n10) {
        int n11 = this.enableMergePaths;
        if (n11 == n10) {
            return;
        }
        n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 < n12) {
            Logger.warning("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.enableMergePaths = n10;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            this.buildCompositionLayer();
        }
    }

    public boolean enableMergePathsForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public void endAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.endAnimation();
    }

    public int getAlpha() {
        return this.alpha;
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public int getFrame() {
        return (int)this.animator.getFrame();
    }

    public Bitmap getImageAsset(String string2) {
        ImageAssetManager imageAssetManager = this.getImageAssetManager();
        if (imageAssetManager != null) {
            return imageAssetManager.bitmapForId(string2);
        }
        return null;
    }

    public String getImageAssetsFolder() {
        return this.imageAssetsFolder;
    }

    public int getIntrinsicHeight() {
        int n10;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            n10 = -1;
            float f10 = 0.0f / 0.0f;
        } else {
            lottieComposition = lottieComposition.getBounds();
            float f11 = lottieComposition.height();
            float f12 = this.getScale();
            n10 = (int)(f11 *= f12);
        }
        return n10;
    }

    public int getIntrinsicWidth() {
        int n10;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition == null) {
            n10 = -1;
            float f10 = 0.0f / 0.0f;
        } else {
            lottieComposition = lottieComposition.getBounds();
            float f11 = lottieComposition.width();
            float f12 = this.getScale();
            n10 = (int)(f11 *= f12);
        }
        return n10;
    }

    public float getMaxFrame() {
        return this.animator.getMaxFrame();
    }

    public float getMinFrame() {
        return this.animator.getMinFrame();
    }

    public int getOpacity() {
        return -3;
    }

    public PerformanceTracker getPerformanceTracker() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return lottieComposition.getPerformanceTracker();
        }
        return null;
    }

    public float getProgress() {
        return this.animator.getAnimatedValueAbsolute();
    }

    public int getRepeatCount() {
        return this.animator.getRepeatCount();
    }

    public int getRepeatMode() {
        return this.animator.getRepeatMode();
    }

    public float getScale() {
        return this.scale;
    }

    public float getSpeed() {
        return this.animator.getSpeed();
    }

    public TextDelegate getTextDelegate() {
        return this.textDelegate;
    }

    public Typeface getTypeface(String string2, String string3) {
        FontAssetManager fontAssetManager = this.getFontAssetManager();
        if (fontAssetManager != null) {
            return fontAssetManager.getTypeface(string2, string3);
        }
        return null;
    }

    public boolean hasMasks() {
        boolean bl2;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null && (bl2 = compositionLayer.hasMasks())) {
            bl2 = true;
        } else {
            bl2 = false;
            compositionLayer = null;
        }
        return bl2;
    }

    public boolean hasMatte() {
        boolean bl2;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null && (bl2 = compositionLayer.hasMatte())) {
            bl2 = true;
        } else {
            bl2 = false;
            compositionLayer = null;
        }
        return bl2;
    }

    public void invalidateDrawable(Drawable drawable2) {
        drawable2 = this.getCallback();
        if (drawable2 == null) {
            return;
        }
        drawable2.invalidateDrawable((Drawable)this);
    }

    public void invalidateSelf() {
        boolean bl2 = this.isDirty;
        if (bl2) {
            return;
        }
        this.isDirty = bl2 = true;
        Drawable.Callback callback = this.getCallback();
        if (callback != null) {
            callback.invalidateDrawable((Drawable)this);
        }
    }

    public boolean isAnimating() {
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (lottieValueAnimator == null) {
            return false;
        }
        return lottieValueAnimator.isRunning();
    }

    public boolean isApplyingOpacityToLayersEnabled() {
        return this.isApplyingOpacityToLayersEnabled;
    }

    public boolean isLooping() {
        int n10;
        LottieValueAnimator lottieValueAnimator = this.animator;
        int n11 = lottieValueAnimator.getRepeatCount();
        if (n11 == (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            lottieValueAnimator = null;
        }
        return n11 != 0;
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.enableMergePaths;
    }

    public boolean isRunning() {
        return this.isAnimating();
    }

    /*
     * WARNING - void declaration
     */
    public void loop(boolean bl2) {
        void var1_4;
        LottieValueAnimator lottieValueAnimator = this.animator;
        if (bl2) {
            int n10 = -1;
        } else {
            boolean bl3 = false;
        }
        lottieValueAnimator.setRepeatCount((int)var1_4);
    }

    public void pauseAnimation() {
        this.lazyCompositionTasks.clear();
        this.animator.pauseAnimation();
    }

    public void playAnimation() {
        Object object = this.compositionLayer;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$2 lottieDrawable$2 = new LottieDrawable$2(this);
            ((ArrayList)object).add(lottieDrawable$2);
            return;
        }
        int n10 = this.systemAnimationsEnabled;
        if (n10 != 0 || (n10 = this.getRepeatCount()) == 0) {
            object = this.animator;
            ((LottieValueAnimator)((Object)object)).playAnimation();
        }
        if ((n10 = (int)(this.systemAnimationsEnabled ? 1 : 0)) == 0) {
            float f10 = this.getSpeed();
            Object var2_3 = null;
            float f11 = f10 - 0.0f;
            n10 = (int)(f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1));
            f10 = n10 < 0 ? this.getMinFrame() : this.getMaxFrame();
            n10 = (int)f10;
            this.setFrame(n10);
            object = this.animator;
            ((LottieValueAnimator)((Object)object)).endAnimation();
        }
    }

    public void removeAllAnimatorListeners() {
        this.animator.removeAllListeners();
    }

    public void removeAllUpdateListeners() {
        this.animator.removeAllUpdateListeners();
        LottieValueAnimator lottieValueAnimator = this.animator;
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.progressUpdateListener;
        lottieValueAnimator.addUpdateListener(animatorUpdateListener);
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.animator.removeListener(animatorListener);
    }

    public void removeAnimatorPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.animator.removePauseListener(animatorPauseListener);
    }

    public void removeAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.animator.removeUpdateListener(animatorUpdateListener);
    }

    public List resolveKeyPath(KeyPath keyPath) {
        Object object = this.compositionLayer;
        if (object == null) {
            Logger.warning("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        object = new Object();
        CompositionLayer compositionLayer = this.compositionLayer;
        String[] stringArray = new String[]{};
        KeyPath keyPath2 = new KeyPath(stringArray);
        compositionLayer.resolveKeyPath(keyPath, 0, (List)object, keyPath2);
        return object;
    }

    public void resumeAnimation() {
        Object object = this.compositionLayer;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$3 lottieDrawable$3 = new LottieDrawable$3(this);
            ((ArrayList)object).add(lottieDrawable$3);
            return;
        }
        int n10 = this.systemAnimationsEnabled;
        if (n10 != 0 || (n10 = this.getRepeatCount()) == 0) {
            object = this.animator;
            ((LottieValueAnimator)((Object)object)).resumeAnimation();
        }
        if ((n10 = (int)(this.systemAnimationsEnabled ? 1 : 0)) == 0) {
            float f10 = this.getSpeed();
            Object var2_3 = null;
            float f11 = f10 - 0.0f;
            n10 = (int)(f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1));
            f10 = n10 < 0 ? this.getMinFrame() : this.getMaxFrame();
            n10 = (int)f10;
            this.setFrame(n10);
            object = this.animator;
            ((LottieValueAnimator)((Object)object)).endAnimation();
        }
    }

    public void reverseAnimationSpeed() {
        this.animator.reverseAnimationSpeed();
    }

    public void scheduleDrawable(Drawable drawable2, Runnable runnable, long l10) {
        drawable2 = this.getCallback();
        if (drawable2 == null) {
            return;
        }
        drawable2.scheduleDrawable((Drawable)this, runnable, l10);
    }

    public void setAlpha(int n10) {
        this.alpha = n10;
        this.invalidateSelf();
    }

    public void setApplyingOpacityToLayersEnabled(boolean bl2) {
        this.isApplyingOpacityToLayersEnabled = bl2;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Logger.warning("Use addColorFilter instead.");
    }

    public boolean setComposition(LottieComposition lottieComposition) {
        Object object = this.composition;
        boolean bl2 = false;
        Object object2 = null;
        if (object == lottieComposition) {
            return false;
        }
        this.isDirty = false;
        this.clearComposition();
        this.composition = lottieComposition;
        this.buildCompositionLayer();
        this.animator.setComposition(lottieComposition);
        float f10 = this.animator.getAnimatedFraction();
        this.setProgress(f10);
        f10 = this.scale;
        this.setScale(f10);
        this.updateBounds();
        object2 = this.lazyCompositionTasks;
        object = new ArrayList(object2);
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (LottieDrawable$LazyCompositionTask)object.next();
            object2.run(lottieComposition);
            object.remove();
        }
        object = this.lazyCompositionTasks;
        ((ArrayList)object).clear();
        boolean bl3 = this.performanceTrackingEnabled;
        lottieComposition.setPerformanceTrackingEnabled(bl3);
        lottieComposition = this.getCallback();
        bl3 = lottieComposition instanceof ImageView;
        if (bl3) {
            lottieComposition = (ImageView)lottieComposition;
            bl3 = false;
            f10 = 0.0f;
            object = null;
            lottieComposition.setImageDrawable(null);
            lottieComposition.setImageDrawable(this);
        }
        return true;
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.fontAssetDelegate = fontAssetDelegate;
        FontAssetManager fontAssetManager = this.fontAssetManager;
        if (fontAssetManager != null) {
            fontAssetManager.setDelegate(fontAssetDelegate);
        }
    }

    public void setFrame(int n10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$14 lottieDrawable$14 = new LottieDrawable$14(this, n10);
            ((ArrayList)object).add(lottieDrawable$14);
            return;
        }
        object = this.animator;
        float f10 = n10;
        ((LottieValueAnimator)((Object)object)).setFrame(f10);
    }

    public void setImageAssetDelegate(ImageAssetDelegate imageAssetDelegate) {
        this.imageAssetDelegate = imageAssetDelegate;
        ImageAssetManager imageAssetManager = this.imageAssetManager;
        if (imageAssetManager != null) {
            imageAssetManager.setDelegate(imageAssetDelegate);
        }
    }

    public void setImagesAssetsFolder(String string2) {
        this.imageAssetsFolder = string2;
    }

    public void setMaxFrame(int n10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$6 lottieDrawable$6 = new LottieDrawable$6(this, n10);
            ((ArrayList)object).add(lottieDrawable$6);
            return;
        }
        object = this.animator;
        float f10 = (float)n10 + 0.99f;
        ((LottieValueAnimator)((Object)object)).setMaxFrame(f10);
    }

    public void setMaxFrame(String string2) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$9 lottieDrawable$9 = new LottieDrawable$9(this, string2);
            ((ArrayList)object).add(lottieDrawable$9);
            return;
        }
        if ((object = ((LottieComposition)object).getMarker(string2)) != null) {
            float f10 = ((Marker)object).startFrame;
            float f11 = ((Marker)object).durationFrames;
            int n10 = (int)(f10 + f11);
            this.setMaxFrame(n10);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void setMaxProgress(float f10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$7 lottieDrawable$7 = new LottieDrawable$7(this, f10);
            ((ArrayList)object).add(lottieDrawable$7);
            return;
        }
        float f11 = ((LottieComposition)object).getStartFrame();
        float f12 = this.composition.getEndFrame();
        int n10 = (int)MiscUtils.lerp(f11, f12, f10);
        this.setMaxFrame(n10);
    }

    public void setMinAndMaxFrame(int n10, int n11) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$12 lottieDrawable$12 = new LottieDrawable$12(this, n10, n11);
            ((ArrayList)object).add(lottieDrawable$12);
            return;
        }
        object = this.animator;
        float f10 = n10;
        float f11 = (float)n11 + 0.99f;
        ((LottieValueAnimator)((Object)object)).setMinAndMaxFrames(f10, f11);
    }

    public void setMinAndMaxFrame(String string2) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$10 lottieDrawable$10 = new LottieDrawable$10(this, string2);
            ((ArrayList)object).add(lottieDrawable$10);
            return;
        }
        if ((object = ((LottieComposition)object).getMarker(string2)) != null) {
            int n10 = (int)((Marker)object).startFrame;
            int n11 = (int)((Marker)object).durationFrames + n10;
            this.setMinAndMaxFrame(n10, n11);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void setMinAndMaxFrame(String object, String object2, boolean bl2) {
        Object object3 = this.composition;
        if (object3 == null) {
            object3 = this.lazyCompositionTasks;
            LottieDrawable$11 lottieDrawable$11 = new LottieDrawable$11(this, (String)object, (String)object2, bl2);
            ((ArrayList)object3).add(lottieDrawable$11);
            return;
        }
        object3 = ((LottieComposition)object3).getMarker((String)object);
        String string2 = ".";
        String string3 = "Cannot find marker with name ";
        if (object3 != null) {
            float f10 = ((Marker)object3).startFrame;
            int n10 = (int)f10;
            object3 = this.composition.getMarker((String)object2);
            if (object2 != null) {
                float f11;
                float f12 = ((Marker)object3).startFrame;
                if (bl2) {
                    int n11 = 1065353216;
                    f11 = 1.0f;
                } else {
                    boolean bl3 = false;
                    f11 = 0.0f;
                    Object stringBuilder = null;
                }
                int n12 = (int)(f12 + f11);
                this.setMinAndMaxFrame(n10, n12);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string3);
            stringBuilder.append((String)object2);
            stringBuilder.append(string2);
            object2 = stringBuilder.toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        stringBuilder.append(string2);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public void setMinAndMaxProgress(float f10, float f11) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$13 lottieDrawable$13 = new LottieDrawable$13(this, f10, f11);
            ((ArrayList)object).add(lottieDrawable$13);
            return;
        }
        float f12 = ((LottieComposition)object).getStartFrame();
        float f13 = this.composition.getEndFrame();
        int n10 = (int)MiscUtils.lerp(f12, f13, f10);
        f12 = this.composition.getStartFrame();
        f13 = this.composition.getEndFrame();
        int n11 = (int)MiscUtils.lerp(f12, f13, f11);
        this.setMinAndMaxFrame(n10, n11);
    }

    public void setMinFrame(int n10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$4 lottieDrawable$4 = new LottieDrawable$4(this, n10);
            ((ArrayList)object).add(lottieDrawable$4);
            return;
        }
        this.animator.setMinFrame(n10);
    }

    public void setMinFrame(String string2) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$8 lottieDrawable$8 = new LottieDrawable$8(this, string2);
            ((ArrayList)object).add(lottieDrawable$8);
            return;
        }
        if ((object = ((LottieComposition)object).getMarker(string2)) != null) {
            int n10 = (int)((Marker)object).startFrame;
            this.setMinFrame(n10);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot find marker with name ");
        stringBuilder.append(string2);
        stringBuilder.append(".");
        string2 = stringBuilder.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public void setMinProgress(float f10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$5 lottieDrawable$5 = new LottieDrawable$5(this, f10);
            ((ArrayList)object).add(lottieDrawable$5);
            return;
        }
        float f11 = ((LottieComposition)object).getStartFrame();
        float f12 = this.composition.getEndFrame();
        int n10 = (int)MiscUtils.lerp(f11, f12, f10);
        this.setMinFrame(n10);
    }

    public void setOutlineMasksAndMattes(boolean bl2) {
        boolean bl3 = this.outlineMasksAndMattes;
        if (bl3 == bl2) {
            return;
        }
        this.outlineMasksAndMattes = bl2;
        CompositionLayer compositionLayer = this.compositionLayer;
        if (compositionLayer != null) {
            compositionLayer.setOutlineMasksAndMattes(bl2);
        }
    }

    public void setPerformanceTrackingEnabled(boolean bl2) {
        this.performanceTrackingEnabled = bl2;
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            lottieComposition.setPerformanceTrackingEnabled(bl2);
        }
    }

    public void setProgress(float f10) {
        Object object = this.composition;
        if (object == null) {
            object = this.lazyCompositionTasks;
            LottieDrawable$15 lottieDrawable$15 = new LottieDrawable$15(this, f10);
            ((ArrayList)object).add(lottieDrawable$15);
            return;
        }
        object = "Drawable#setProgress";
        L.beginSection((String)object);
        LottieValueAnimator lottieValueAnimator = this.animator;
        float f11 = this.composition.getStartFrame();
        float f12 = this.composition.getEndFrame();
        f10 = MiscUtils.lerp(f11, f12, f10);
        lottieValueAnimator.setFrame(f10);
        L.endSection((String)object);
    }

    public void setRepeatCount(int n10) {
        this.animator.setRepeatCount(n10);
    }

    public void setRepeatMode(int n10) {
        this.animator.setRepeatMode(n10);
    }

    public void setSafeMode(boolean bl2) {
        this.safeMode = bl2;
    }

    public void setScale(float f10) {
        this.scale = f10;
        this.updateBounds();
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        this.scaleType = scaleType;
    }

    public void setSpeed(float f10) {
        this.animator.setSpeed(f10);
    }

    public void setSystemAnimationsAreEnabled(Boolean bl2) {
        boolean bl3;
        this.systemAnimationsEnabled = bl3 = bl2.booleanValue();
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.textDelegate = textDelegate;
    }

    public void start() {
        boolean bl2;
        Drawable.Callback callback = this.getCallback();
        boolean bl3 = callback instanceof View;
        if (bl3 && !(bl2 = (callback = (View)callback).isInEditMode())) {
            this.playAnimation();
        }
    }

    public void stop() {
        this.endAnimation();
    }

    public void unscheduleDrawable(Drawable drawable2, Runnable runnable) {
        drawable2 = this.getCallback();
        if (drawable2 == null) {
            return;
        }
        drawable2.unscheduleDrawable((Drawable)this, runnable);
    }

    public Bitmap updateBitmap(String string2, Bitmap bitmap) {
        ImageAssetManager imageAssetManager = this.getImageAssetManager();
        if (imageAssetManager == null) {
            Logger.warning("Cannot update bitmap. Most likely the drawable is not added to a View which prevents Lottie from getting a Context.");
            return null;
        }
        string2 = imageAssetManager.updateBitmap(string2, bitmap);
        this.invalidateSelf();
        return string2;
    }

    public boolean useTextGlyphs() {
        int n10;
        Object object = this.textDelegate;
        if (object == null && (n10 = ((SparseArrayCompat)(object = this.composition.getCharacters())).size()) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }
}

