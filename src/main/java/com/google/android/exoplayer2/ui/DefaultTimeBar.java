/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Point
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.AttributeSet
 *  android.view.KeyEvent
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 */
package com.google.android.exoplayer2.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.exoplayer2.ui.R$styleable;
import com.google.android.exoplayer2.ui.TimeBar;
import com.google.android.exoplayer2.ui.TimeBar$OnScrubListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

public class DefaultTimeBar
extends View
implements TimeBar {
    private static final String ACCESSIBILITY_CLASS_NAME = "android.widget.SeekBar";
    public static final int BAR_GRAVITY_BOTTOM = 1;
    public static final int BAR_GRAVITY_CENTER = 0;
    public static final int DEFAULT_AD_MARKER_COLOR = -1291845888;
    public static final int DEFAULT_AD_MARKER_WIDTH_DP = 4;
    public static final int DEFAULT_BAR_HEIGHT_DP = 4;
    public static final int DEFAULT_BUFFERED_COLOR = -855638017;
    private static final int DEFAULT_INCREMENT_COUNT = 20;
    public static final int DEFAULT_PLAYED_AD_MARKER_COLOR = 0x33FFFF00;
    public static final int DEFAULT_PLAYED_COLOR = 255;
    public static final int DEFAULT_SCRUBBER_COLOR = 255;
    public static final int DEFAULT_SCRUBBER_DISABLED_SIZE_DP = 0;
    public static final int DEFAULT_SCRUBBER_DRAGGED_SIZE_DP = 16;
    public static final int DEFAULT_SCRUBBER_ENABLED_SIZE_DP = 12;
    public static final int DEFAULT_TOUCH_TARGET_HEIGHT_DP = 26;
    public static final int DEFAULT_UNPLAYED_COLOR = 0x33FFFFFF;
    private static final int FINE_SCRUB_RATIO = 3;
    private static final int FINE_SCRUB_Y_THRESHOLD_DP = 206;
    private static final float HIDDEN_SCRUBBER_SCALE = 0.0f;
    private static final float SHOWN_SCRUBBER_SCALE = 1.0f;
    private static final long STOP_SCRUBBING_TIMEOUT_MS = 1000L;
    private int adGroupCount;
    private long[] adGroupTimesMs;
    private final Paint adMarkerPaint;
    private final int adMarkerWidth;
    private final int barGravity;
    private final int barHeight;
    private final Rect bufferedBar;
    private final Paint bufferedPaint;
    private long bufferedPosition;
    private final float density;
    private long duration;
    private final int fineScrubYThreshold;
    private final StringBuilder formatBuilder;
    private final Formatter formatter;
    private int keyCountIncrement;
    private long keyTimeIncrement;
    private int lastCoarseScrubXPosition;
    private Rect lastExclusionRectangle;
    private final CopyOnWriteArraySet listeners;
    private boolean[] playedAdGroups;
    private final Paint playedAdMarkerPaint;
    private final Paint playedPaint;
    private long position;
    private final Rect progressBar;
    private long scrubPosition;
    private final Rect scrubberBar;
    private final int scrubberDisabledSize;
    private final int scrubberDraggedSize;
    private final Drawable scrubberDrawable;
    private final int scrubberEnabledSize;
    private final int scrubberPadding;
    private boolean scrubberPaddingDisabled;
    private final Paint scrubberPaint;
    private float scrubberScale;
    private ValueAnimator scrubberScalingAnimator;
    private boolean scrubbing;
    private final Rect seekBounds;
    private final Runnable stopScrubbingRunnable;
    private final Point touchPosition;
    private final int touchTargetHeight;
    private final Paint unplayedPaint;

    public DefaultTimeBar(Context context) {
        this(context, null);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int n10) {
        this(context, attributeSet, n10, attributeSet);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int n10, AttributeSet attributeSet2) {
        this(context, attributeSet, n10, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int n10, AttributeSet attributeSet2, int n11) {
        long l10;
        int n12;
        int n13;
        float f10;
        Point point;
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        Object object;
        Object object2;
        DefaultTimeBar defaultTimeBar = this;
        Object object3 = attributeSet2;
        super(context, attributeSet, n10);
        this.seekBounds = object2 = new Rect();
        this.progressBar = object2 = new Rect();
        this.bufferedBar = object2 = new Rect();
        this.scrubberBar = object2 = new Rect();
        super();
        this.playedPaint = object2;
        this.bufferedPaint = object = new Paint();
        this.unplayedPaint = paint4 = new Paint();
        this.adMarkerPaint = paint3 = new Paint();
        this.playedAdMarkerPaint = paint2 = new Paint();
        this.scrubberPaint = paint = new Paint();
        paint.setAntiAlias(true);
        this.listeners = point = new CopyOnWriteArraySet();
        this.touchPosition = point = new Point();
        point = context.getResources().getDisplayMetrics();
        this.density = f10 = point.density;
        this.fineScrubYThreshold = n13 = DefaultTimeBar.dpToPx(f10, -50);
        n13 = 4;
        int n14 = DefaultTimeBar.dpToPx(f10, n13);
        int n15 = DefaultTimeBar.dpToPx(f10, 26);
        n13 = DefaultTimeBar.dpToPx(f10, n13);
        int n16 = DefaultTimeBar.dpToPx(f10, 12);
        int[] nArray = null;
        int n17 = DefaultTimeBar.dpToPx(f10, 0);
        int n18 = DefaultTimeBar.dpToPx(f10, 16);
        if (attributeSet2 != null) {
            int n19;
            Paint paint5;
            Paint paint6;
            block43: {
                point = context.getTheme();
                nArray = R$styleable.DefaultTimeBar;
                paint6 = paint3;
                paint5 = paint2;
                n19 = n10;
                int n20 = n11;
                paint3 = point.obtainStyledAttributes(attributeSet2, nArray, n10, n11);
                n12 = R$styleable.DefaultTimeBar_scrubber_drawable;
                object3 = paint3.getDrawable(n12);
                this.scrubberDrawable = object3;
                if (object3 == null) break block43;
                this.setDrawableLayoutDirection((Drawable)object3);
                n12 = object3.getMinimumHeight();
                n15 = Math.max(n12, n15);
            }
            n12 = R$styleable.DefaultTimeBar_bar_height;
            n12 = paint3.getDimensionPixelSize(n12, n14);
            defaultTimeBar.barHeight = n12;
            n12 = R$styleable.DefaultTimeBar_touch_target_height;
            n12 = paint3.getDimensionPixelSize(n12, n15);
            defaultTimeBar.touchTargetHeight = n12;
            n12 = R$styleable.DefaultTimeBar_bar_gravity;
            n19 = 0;
            paint2 = null;
            n12 = paint3.getInt(n12, 0);
            defaultTimeBar.barGravity = n12;
            n12 = R$styleable.DefaultTimeBar_ad_marker_width;
            n12 = paint3.getDimensionPixelSize(n12, n13);
            defaultTimeBar.adMarkerWidth = n12;
            n12 = R$styleable.DefaultTimeBar_scrubber_enabled_size;
            n12 = paint3.getDimensionPixelSize(n12, n16);
            defaultTimeBar.scrubberEnabledSize = n12;
            n12 = R$styleable.DefaultTimeBar_scrubber_disabled_size;
            n12 = paint3.getDimensionPixelSize(n12, n17);
            defaultTimeBar.scrubberDisabledSize = n12;
            n12 = R$styleable.DefaultTimeBar_scrubber_dragged_size;
            n12 = paint3.getDimensionPixelSize(n12, n18);
            defaultTimeBar.scrubberDraggedSize = n12;
            n12 = R$styleable.DefaultTimeBar_played_color;
            n19 = -1;
            n12 = paint3.getInt(n12, n19);
            n18 = R$styleable.DefaultTimeBar_scrubber_color;
            n19 = paint3.getInt(n18, n19);
            n18 = R$styleable.DefaultTimeBar_buffered_color;
            int n21 = -855638017;
            f10 = -1.3421772E8f;
            try {
                n18 = paint3.getInt(n18, n21);
                n21 = R$styleable.DefaultTimeBar_unplayed_color;
                n13 = 0x33FFFFFF;
                n21 = paint3.getInt(n21, n13);
                n13 = R$styleable.DefaultTimeBar_ad_marker_color;
                n14 = -1291845888;
                n13 = paint3.getInt(n13, n14);
                n14 = R$styleable.DefaultTimeBar_played_ad_marker_color;
                n15 = 0x33FFFF00;
                n14 = paint3.getInt(n14, n15);
                object2.setColor(n12);
                paint.setColor(n19);
                object.setColor(n18);
                paint4.setColor(n21);
                object3 = paint6;
                paint6.setColor(n13);
                paint2 = paint5;
                paint5.setColor(n14);
            }
            finally {
                paint3.recycle();
            }
        }
        object3 = paint3;
        this.barHeight = n14;
        this.touchTargetHeight = n15;
        paint3 = null;
        this.barGravity = 0;
        this.adMarkerWidth = n13;
        this.scrubberEnabledSize = n16;
        this.scrubberDisabledSize = n17;
        this.scrubberDraggedSize = n18;
        int n22 = -1;
        object2.setColor(n22);
        paint.setColor(n22);
        object.setColor(-855638017);
        paint4.setColor(0x33FFFFFF);
        int n23 = -1291845888;
        object3.setColor(n23);
        paint2.setColor(0x33FFFF00);
        n12 = 0;
        object3 = null;
        this.scrubberDrawable = null;
        super();
        defaultTimeBar.formatBuilder = object3;
        object = Locale.getDefault();
        super((Appendable)object3, (Locale)object);
        defaultTimeBar.formatter = object2;
        super(defaultTimeBar);
        defaultTimeBar.stopScrubbingRunnable = object3;
        object3 = defaultTimeBar.scrubberDrawable;
        if (object3 != null) {
            n12 = object3.getMinimumWidth();
            n23 = 1;
            defaultTimeBar.scrubberPadding = n12 = (n12 + n23) / 2;
        } else {
            n23 = 1;
            n12 = defaultTimeBar.scrubberDisabledSize;
            int n24 = defaultTimeBar.scrubberEnabledSize;
            int n25 = defaultTimeBar.scrubberDraggedSize;
            n24 = Math.max(n24, n25);
            defaultTimeBar.scrubberPadding = n12 = (Math.max(n12, n24) + n23) / 2;
        }
        defaultTimeBar.scrubberScale = 1.0f;
        super();
        defaultTimeBar.scrubberScalingAnimator = object3;
        super(defaultTimeBar);
        object3.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object2);
        defaultTimeBar.duration = l10 = -9223372036854775807L;
        defaultTimeBar.keyTimeIncrement = l10;
        defaultTimeBar.keyCountIncrement = 20;
        n12 = 1;
        defaultTimeBar.setFocusable(n12 != 0);
        n23 = this.getImportantForAccessibility();
        if (n23 == 0) {
            defaultTimeBar.setImportantForAccessibility(n12);
        }
    }

    private /* synthetic */ void a() {
        this.stopScrubbing(false);
    }

    private /* synthetic */ void c(ValueAnimator valueAnimator) {
        float f10;
        this.scrubberScale = f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator = this.seekBounds;
        this.invalidate((Rect)valueAnimator);
    }

    private static int dpToPx(float f10, int n10) {
        return (int)((float)n10 * f10 + 0.5f);
    }

    private void drawPlayhead(Canvas canvas) {
        long l10 = this.duration;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            return;
        }
        Rect rect = this.scrubberBar;
        int n10 = rect.right;
        object = rect.left;
        int n11 = this.progressBar.right;
        object = Util.constrainValue(n10, (int)object, n11);
        Rect rect2 = this.scrubberBar;
        n10 = rect2.centerY();
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 == null) {
            n11 = (int)(this.scrubbing ? 1 : 0);
            n11 = n11 == 0 && (n11 = (int)(this.isFocused() ? 1 : 0)) == 0 ? ((n11 = (int)(this.isEnabled() ? 1 : 0)) != 0 ? this.scrubberEnabledSize : this.scrubberDisabledSize) : this.scrubberDraggedSize;
            float f10 = n11;
            float f11 = this.scrubberScale;
            f10 *= f11;
            int n12 = 0x40000000;
            f11 = 2.0f;
            n11 = (int)(f10 / f11);
            float f12 = object;
            float f13 = n10;
            f10 = n11;
            Paint paint = this.scrubberPaint;
            canvas.drawCircle(f12, f13, f10, paint);
        } else {
            float f14 = drawable2.getIntrinsicWidth();
            float f15 = this.scrubberScale;
            n11 = (int)(f14 *= f15);
            Drawable drawable3 = this.scrubberDrawable;
            f15 = drawable3.getIntrinsicHeight();
            float f16 = this.scrubberScale;
            int n13 = (int)(f15 *= f16);
            Drawable drawable4 = this.scrubberDrawable;
            long l13 = object - (n11 /= 2);
            int n14 = n10 - (n13 /= 2);
            drawable4.setBounds((int)l13, n14, (int)(object += n11), n10 += n13);
            rect = this.scrubberDrawable;
            rect.draw(canvas);
        }
    }

    private void drawTimeBar(Canvas canvas) {
        int n10;
        Paint paint;
        float f10;
        float f11;
        float f12;
        float f13;
        DefaultTimeBar defaultTimeBar = this;
        Rect rect = this.progressBar;
        int n11 = rect.height();
        Rect rect2 = this.progressBar;
        int n12 = rect2.centerY();
        int n13 = n11 / 2;
        n11 += (n12 -= n13);
        long l10 = this.duration;
        long l11 = 0L;
        long l12 = l10 - l11;
        n13 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n13 <= 0) {
            Rect rect3 = this.progressBar;
            float f14 = rect3.left;
            float f15 = n12;
            float f16 = rect3.right;
            float f17 = n11;
            Paint paint2 = this.unplayedPaint;
            Canvas canvas2 = canvas;
            canvas.drawRect(f14, f15, f16, f17, paint2);
            return;
        }
        Object object = this.bufferedBar;
        int n14 = object.left;
        n13 = object.right;
        Rect rect4 = this.progressBar;
        int n15 = Math.max(rect4.left, n13);
        int n16 = this.scrubberBar.right;
        n15 = Math.max(n15, n16);
        Rect rect5 = this.progressBar;
        n16 = rect5.right;
        if (n15 < n16) {
            f13 = n15;
            f12 = n12;
            float f18 = n16;
            float f19 = n11;
            Paint paint3 = this.unplayedPaint;
            canvas.drawRect(f13, f12, f18, f19, paint3);
        }
        rect4 = defaultTimeBar.scrubberBar;
        n15 = rect4.right;
        if (n13 > (n14 = Math.max(n14, n15))) {
            f11 = n14;
            f10 = n12;
            f13 = n13;
            f12 = n11;
            paint = defaultTimeBar.bufferedPaint;
            rect4 = canvas;
            canvas.drawRect(f11, f10, f13, f12, paint);
        }
        if ((n13 = (object = defaultTimeBar.scrubberBar).width()) > 0) {
            object = defaultTimeBar.scrubberBar;
            n14 = object.left;
            f11 = n14;
            f10 = n12;
            n13 = object.right;
            f13 = n13;
            f12 = n11;
            paint = defaultTimeBar.playedPaint;
            rect4 = canvas;
            canvas.drawRect(f11, f10, f13, f12, paint);
        }
        if ((n13 = defaultTimeBar.adGroupCount) == 0) {
            return;
        }
        object = (long[])Assertions.checkNotNull(defaultTimeBar.adGroupTimesMs);
        boolean[] blArray = (boolean[])Assertions.checkNotNull(defaultTimeBar.playedAdGroups);
        n15 = defaultTimeBar.adMarkerWidth / 2;
        n16 = 0;
        f11 = 0.0f;
        rect5 = null;
        f10 = 0.0f;
        for (int i10 = 0; i10 < (n10 = defaultTimeBar.adGroupCount); ++i10) {
            Rect rect6 = object[i10];
            long l13 = 0L;
            long l14 = defaultTimeBar.duration;
            long l15 = Util.constrainValue((long)rect6, l13, l14);
            paint = defaultTimeBar.progressBar;
            long l16 = (long)paint.width() * l15;
            l15 = defaultTimeBar.duration;
            n10 = (int)(l16 /= l15) - n15;
            Rect rect7 = defaultTimeBar.progressBar;
            int n17 = rect7.left;
            int n18 = rect7.width();
            int n19 = defaultTimeBar.adMarkerWidth;
            n10 = Math.max(0, n10);
            n10 = Math.min(n18 -= n19, n10);
            n17 += n10;
            n10 = blArray[i10];
            Paint paint4 = n10 != 0 ? defaultTimeBar.playedAdMarkerPaint : defaultTimeBar.adMarkerPaint;
            float f20 = n17;
            float f21 = n12;
            n10 = defaultTimeBar.adMarkerWidth;
            float f22 = n17 += n10;
            float f23 = n11;
            canvas.drawRect(f20, f21, f22, f23, paint4);
        }
    }

    private long getPositionIncrement() {
        long l10 = this.keyTimeIncrement;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = this.duration;
            long l13 = l10 - l11;
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 == false) {
                l10 = 0L;
            } else {
                object2 = this.keyCountIncrement;
                l11 = object2;
                l10 /= l11;
            }
        }
        return l10;
    }

    private String getProgressText() {
        StringBuilder stringBuilder = this.formatBuilder;
        Formatter formatter = this.formatter;
        long l10 = this.position;
        return Util.getStringForTime(stringBuilder, formatter, l10);
    }

    private long getScrubberPosition() {
        long l10;
        long l11;
        long l12;
        Rect rect = this.progressBar;
        int n10 = rect.width();
        if (n10 > 0 && (n10 = (int)((l12 = (l11 = this.duration) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            l11 = this.scrubberBar.width();
            l10 = this.duration;
            l11 *= l10;
            l10 = this.progressBar.width();
            return l11 / l10;
        }
        return 0L;
    }

    private boolean isInSeekBar(float f10, float f11) {
        Rect rect = this.seekBounds;
        int n10 = (int)f10;
        int n11 = (int)f11;
        return rect.contains(n10, n11);
    }

    private void positionScrubber(float f10) {
        Rect rect = this.scrubberBar;
        int n10 = (int)f10;
        Rect rect2 = this.progressBar;
        int n11 = rect2.left;
        int n12 = rect2.right;
        rect.right = n10 = Util.constrainValue(n10, n11, n12);
    }

    private static int pxToDp(float f10, int n10) {
        return (int)((float)n10 / f10);
    }

    private Point resolveRelativeTouchPosition(MotionEvent motionEvent) {
        Point point = this.touchPosition;
        int n10 = (int)motionEvent.getX();
        int n11 = (int)motionEvent.getY();
        point.set(n10, n11);
        return this.touchPosition;
    }

    private boolean scrubIncrementally(long l10) {
        long l11 = this.duration;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object <= 0) {
            return false;
        }
        object = this.scrubbing;
        l12 = object != false ? this.scrubPosition : this.position;
        long l14 = l12;
        long l15 = 0L;
        long l16 = (l10 = Util.constrainValue(l12 += l10, l15, l11)) - l14;
        object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            return false;
        }
        object = this.scrubbing;
        if (object == false) {
            this.startScrubbing(l10);
        } else {
            this.updateScrubbing(l10);
        }
        this.update();
        return true;
    }

    private boolean setDrawableLayoutDirection(Drawable drawable2) {
        boolean bl2;
        int n10 = Util.SDK_INT;
        int n11 = 23;
        if (n10 >= n11 && (bl2 = DefaultTimeBar.setDrawableLayoutDirection(drawable2, n10 = this.getLayoutDirection()))) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private static boolean setDrawableLayoutDirection(Drawable drawable2, int n10) {
        boolean bl2;
        int n11 = Util.SDK_INT;
        int n12 = 23;
        if (n11 >= n12 && (bl2 = drawable2.setLayoutDirection(n10))) {
            bl2 = true;
        } else {
            bl2 = false;
            drawable2 = null;
        }
        return bl2;
    }

    private void setSystemGestureExclusionRectsV29(int n10, int n11) {
        int n12;
        Rect rect = this.lastExclusionRectangle;
        if (rect != null && (n12 = rect.width()) == n10 && (n12 = (rect = this.lastExclusionRectangle).height()) == n11) {
            return;
        }
        this.lastExclusionRectangle = rect = new Rect(0, 0, n10, n11);
        List<Rect> list = Collections.singletonList(rect);
        this.setSystemGestureExclusionRects(list);
    }

    private void startScrubbing(long l10) {
        boolean bl2;
        boolean bl3;
        this.scrubPosition = l10;
        this.scrubbing = bl3 = true;
        this.setPressed(bl3);
        Object object = this.getParent();
        if (object != null) {
            object.requestDisallowInterceptTouchEvent(bl3);
        }
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (TimeBar$OnScrubListener)iterator2.next();
            object.onScrubStart(this, l10);
        }
    }

    private void stopScrubbing(boolean bl2) {
        boolean bl3;
        Object object = this.stopScrubbingRunnable;
        this.removeCallbacks((Runnable)object);
        object = null;
        this.scrubbing = false;
        this.setPressed(false);
        Object object2 = this.getParent();
        if (object2 != null) {
            object2.requestDisallowInterceptTouchEvent(false);
        }
        this.invalidate();
        object = this.listeners.iterator();
        while (bl3 = object.hasNext()) {
            object2 = (TimeBar$OnScrubListener)object.next();
            long l10 = this.scrubPosition;
            object2.onScrubStop(this, l10, bl2);
        }
    }

    private void update() {
        Rect rect = this.bufferedBar;
        Rect rect2 = this.progressBar;
        rect.set(rect2);
        rect = this.scrubberBar;
        rect2 = this.progressBar;
        rect.set(rect2);
        int n10 = this.scrubbing;
        long l10 = n10 != 0 ? this.scrubPosition : this.position;
        long l11 = this.duration;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            l11 = this.progressBar.width();
            l12 = this.bufferedPosition;
            l11 *= l12;
            l12 = this.duration;
            l13 = (int)(l11 / l12);
            Rect rect3 = this.bufferedBar;
            Rect rect4 = this.progressBar;
            int n11 = rect4.left + l13;
            l13 = rect4.right;
            l13 = Math.min(n11, (int)l13);
            rect3.right = (int)l13;
            l13 = this.progressBar.width();
            l11 = (long)l13 * l10;
            l10 = this.duration;
            n10 = (int)(l11 /= l10);
            rect2 = this.scrubberBar;
            Rect rect5 = this.progressBar;
            int n12 = rect5.left + n10;
            n10 = rect5.right;
            rect2.right = n10 = Math.min(n12, n10);
        } else {
            int n13;
            rect = this.bufferedBar;
            rect2 = this.progressBar;
            rect.right = n13 = rect2.left;
            rect = this.scrubberBar;
            rect.right = n13;
        }
        rect = this.seekBounds;
        this.invalidate(rect);
    }

    private void updateDrawableState() {
        int[] nArray;
        boolean bl2;
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null && (bl2 = drawable2.isStateful()) && (bl2 = (drawable2 = this.scrubberDrawable).setState(nArray = this.getDrawableState()))) {
            this.invalidate();
        }
    }

    private void updateScrubbing(long l10) {
        boolean bl2;
        long l11 = this.scrubPosition;
        long l12 = l11 - l10;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return;
        }
        this.scrubPosition = l10;
        Iterator iterator2 = this.listeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            TimeBar$OnScrubListener timeBar$OnScrubListener = (TimeBar$OnScrubListener)iterator2.next();
            timeBar$OnScrubListener.onScrubMove(this, l10);
        }
    }

    public void addListener(TimeBar$OnScrubListener timeBar$OnScrubListener) {
        Assertions.checkNotNull(timeBar$OnScrubListener);
        this.listeners.add(timeBar$OnScrubListener);
    }

    public /* synthetic */ void b() {
        this.a();
    }

    public /* synthetic */ void d(ValueAnimator valueAnimator) {
        this.c(valueAnimator);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.updateDrawableState();
    }

    public long getPreferredUpdateDelay() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        float f10 = this.density;
        Rect rect = this.progressBar;
        int n10 = rect.width();
        int n11 = DefaultTimeBar.pxToDp(f10, n10);
        if (n11 != 0 && (l14 = (l13 = (l12 = this.duration) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false && (l14 = (l10 = l12 - (l11 = -9223372036854775807L)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
            l11 = n11;
            l12 /= l11;
        } else {
            l12 = Long.MAX_VALUE;
        }
        return l12;
    }

    public void hideScrubber(long l10) {
        ValueAnimator valueAnimator = this.scrubberScalingAnimator;
        boolean bl2 = valueAnimator.isStarted();
        if (bl2) {
            valueAnimator = this.scrubberScalingAnimator;
            valueAnimator.cancel();
        }
        valueAnimator = this.scrubberScalingAnimator;
        float f10 = this.scrubberScale;
        float[] fArray = new float[]{f10, 0.0f};
        valueAnimator.setFloatValues(fArray);
        this.scrubberScalingAnimator.setDuration(l10);
        this.scrubberScalingAnimator.start();
    }

    public void hideScrubber(boolean bl2) {
        ValueAnimator valueAnimator = this.scrubberScalingAnimator;
        boolean bl3 = valueAnimator.isStarted();
        if (bl3) {
            valueAnimator = this.scrubberScalingAnimator;
            valueAnimator.cancel();
        }
        this.scrubberPaddingDisabled = bl2;
        this.scrubberScale = 0.0f;
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
    }

    public void onDraw(Canvas canvas) {
        canvas.save();
        this.drawTimeBar(canvas);
        this.drawPlayhead(canvas);
        canvas.restore();
    }

    public void onFocusChanged(boolean bl2, int n10, Rect rect) {
        super.onFocusChanged(bl2, n10, rect);
        n10 = (int)(this.scrubbing ? 1 : 0);
        if (n10 != 0 && !bl2) {
            bl2 = false;
            this.stopScrubbing(false);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int n10 = accessibilityEvent.getEventType();
        int n11 = 4;
        if (n10 == n11) {
            List list = accessibilityEvent.getText();
            String string2 = this.getProgressText();
            list.add(string2);
        }
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((CharSequence)ACCESSIBILITY_CLASS_NAME);
        String string2 = this.getProgressText();
        accessibilityNodeInfo.setContentDescription((CharSequence)string2);
        long l10 = this.duration;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 <= 0) {
            return;
        }
        l12 = Util.SDK_INT;
        int n10 = 21;
        if (l12 >= n10) {
            string2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD;
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)string2);
            string2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD;
            accessibilityNodeInfo.addAction((AccessibilityNodeInfo.AccessibilityAction)string2);
        } else {
            accessibilityNodeInfo.addAction(4096);
            l12 = 8192;
            accessibilityNodeInfo.addAction((int)l12);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean onKeyDown(int n10, KeyEvent keyEvent) {
        boolean bl2 = this.isEnabled();
        if (!bl2) return super.onKeyDown(n10, keyEvent);
        long l10 = this.getPositionIncrement();
        int n11 = 66;
        boolean bl3 = true;
        if (n10 != n11) {
            switch (n10) {
                default: {
                    return super.onKeyDown(n10, keyEvent);
                }
                case 21: {
                    l10 = -l10;
                }
                case 22: {
                    bl2 = this.scrubIncrementally(l10);
                    if (!bl2) return super.onKeyDown(n10, keyEvent);
                    Runnable runnable = this.stopScrubbingRunnable;
                    this.removeCallbacks(runnable);
                    runnable = this.stopScrubbingRunnable;
                    this.postDelayed(runnable, 1000L);
                    return bl3;
                }
                case 23: 
            }
        }
        if (!(bl2 = this.scrubbing)) return super.onKeyDown(n10, keyEvent);
        this.stopScrubbing(false);
        return bl3;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        int n15;
        n13 -= n11;
        n14 -= n12;
        n10 = this.getPaddingLeft();
        n11 = this.getPaddingRight();
        n11 = n13 - n11;
        n12 = (int)(this.scrubberPaddingDisabled ? 1 : 0);
        int n16 = 0;
        Rect rect = null;
        n12 = n12 != 0 ? 0 : this.scrubberPadding;
        int n17 = this.barGravity;
        int n18 = 1;
        if (n17 == n18) {
            n17 = this.getPaddingBottom();
            n17 = n14 - n17;
            n18 = this.touchTargetHeight;
            n17 -= n18;
            n18 = this.getPaddingBottom();
            n18 = n14 - n18;
            n15 = this.barHeight;
            n18 -= n15;
            n15 /= 2;
            n15 = n12 - n15;
            n16 = Math.max(n15, 0);
            n18 -= n16;
        } else {
            n16 = this.touchTargetHeight;
            n17 = (n14 - n16) / 2;
            n16 = this.barHeight;
            n16 = n14 - n16;
            n18 = n16 / 2;
        }
        rect = this.seekBounds;
        n15 = this.touchTargetHeight + n17;
        rect.set(n10, n17, n11, n15);
        Rect rect2 = this.progressBar;
        Rect rect3 = this.seekBounds;
        n16 = rect3.left + n12;
        n11 = rect3.right - n12;
        n12 = this.barHeight + n18;
        rect2.set(n16, n18, n11, n12);
        n10 = Util.SDK_INT;
        n11 = 29;
        if (n10 >= n11) {
            this.setSystemGestureExclusionRectsV29(n13, n14);
        }
        this.update();
    }

    public void onMeasure(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        if (n12 == 0) {
            n11 = this.touchTargetHeight;
        } else {
            int n13 = 0x40000000;
            if (n12 != n13) {
                n12 = this.touchTargetHeight;
                n11 = Math.min(n12, n11);
            }
        }
        n10 = View.MeasureSpec.getSize((int)n10);
        this.setMeasuredDimension(n10, n11);
        this.updateDrawableState();
    }

    public void onRtlPropertiesChanged(int n10) {
        Drawable drawable2 = this.scrubberDrawable;
        if (drawable2 != null && (n10 = (int)(DefaultTimeBar.setDrawableLayoutDirection(drawable2, n10) ? 1 : 0)) != 0) {
            this.invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block6: {
            int n10;
            int n11;
            int n12;
            block7: {
                int n13;
                int n14;
                block8: {
                    block9: {
                        long l10;
                        long l11;
                        long l12;
                        n12 = this.isEnabled();
                        n14 = 0;
                        if (n12 == 0 || (n12 = (l12 = (l11 = this.duration) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) break block6;
                        Point point = this.resolveRelativeTouchPosition(motionEvent);
                        n11 = point.x;
                        n12 = point.y;
                        int n15 = motionEvent.getAction();
                        n10 = 1;
                        if (n15 == 0) break block7;
                        n13 = 3;
                        if (n15 == n10) break block8;
                        int n16 = 2;
                        if (n15 == n16) break block9;
                        if (n15 == n13) break block8;
                        break block6;
                    }
                    int n17 = this.scrubbing;
                    if (n17 != 0) {
                        n17 = this.fineScrubYThreshold;
                        if (n12 < n17) {
                            n17 = this.lastCoarseScrubXPosition;
                            n11 = (n11 - n17) / n13;
                            float f10 = n17 += n11;
                            this.positionScrubber(f10);
                        } else {
                            this.lastCoarseScrubXPosition = n11;
                            float f11 = n11;
                            this.positionScrubber(f11);
                        }
                        long l13 = this.getScrubberPosition();
                        this.updateScrubbing(l13);
                        this.update();
                        this.invalidate();
                        return n10 != 0;
                    }
                    break block6;
                }
                if ((n12 = (int)(this.scrubbing ? 1 : 0)) != 0) {
                    int n18 = motionEvent.getAction();
                    if (n18 == n13) {
                        n14 = n10;
                    }
                    this.stopScrubbing(n14 != 0);
                    return n10 != 0;
                }
                break block6;
            }
            float f12 = n11;
            float f13 = n12;
            if ((n12 = (int)(this.isInSeekBar(f12, f13) ? 1 : 0)) != 0) {
                this.positionScrubber(f12);
                long l14 = this.getScrubberPosition();
                this.startScrubbing(l14);
                this.update();
                this.invalidate();
                return n10 != 0;
            }
        }
        return false;
    }

    public boolean performAccessibilityAction(int n10, Bundle bundle) {
        block10: {
            boolean bl2;
            block9: {
                Object object;
                block8: {
                    object = super.performAccessibilityAction(n10, bundle);
                    bl2 = true;
                    if (object != 0) {
                        return bl2;
                    }
                    long l10 = this.duration;
                    long l11 = 0L;
                    long l12 = l10 - l11;
                    object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object <= 0) {
                        return false;
                    }
                    object = 8192;
                    if (n10 != object) break block8;
                    long l13 = -this.getPositionIncrement();
                    n10 = (int)(this.scrubIncrementally(l13) ? 1 : 0);
                    if (n10 != 0) {
                        this.stopScrubbing(false);
                    }
                    break block9;
                }
                object = 4096;
                if (n10 != object) break block10;
                long l14 = this.getPositionIncrement();
                n10 = (int)(this.scrubIncrementally(l14) ? 1 : 0);
                if (n10 != 0) {
                    this.stopScrubbing(false);
                }
            }
            this.sendAccessibilityEvent(4);
            return bl2;
        }
        return false;
    }

    public void removeListener(TimeBar$OnScrubListener timeBar$OnScrubListener) {
        this.listeners.remove(timeBar$OnScrubListener);
    }

    public void setAdGroupTimesMs(long[] lArray, boolean[] blArray, int n10) {
        boolean bl2 = n10 == 0 || lArray != null && blArray != null;
        Assertions.checkArgument(bl2);
        this.adGroupCount = n10;
        this.adGroupTimesMs = lArray;
        this.playedAdGroups = blArray;
        this.update();
    }

    public void setAdMarkerColor(int n10) {
        this.adMarkerPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void setBufferedColor(int n10) {
        this.bufferedPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void setBufferedPosition(long l10) {
        this.bufferedPosition = l10;
        this.update();
    }

    public void setDuration(long l10) {
        long l11;
        long l12;
        long l13;
        this.duration = l10;
        boolean bl2 = this.scrubbing;
        if (bl2 && (l13 = (l12 = l10 - (l11 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
            l13 = 1;
            this.stopScrubbing((boolean)l13);
        }
        this.update();
    }

    public void setEnabled(boolean bl2) {
        super.setEnabled(bl2);
        boolean bl3 = this.scrubbing;
        if (bl3 && !bl2) {
            bl2 = true;
            this.stopScrubbing(bl2);
        }
    }

    public void setKeyCountIncrement(int n10) {
        boolean bl2 = n10 > 0;
        Assertions.checkArgument(bl2);
        this.keyCountIncrement = n10;
        this.keyTimeIncrement = -9223372036854775807L;
    }

    public void setKeyTimeIncrement(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        Assertions.checkArgument((boolean)object);
        this.keyCountIncrement = -1;
        this.keyTimeIncrement = l10;
    }

    public void setPlayedAdMarkerColor(int n10) {
        this.playedAdMarkerPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void setPlayedColor(int n10) {
        this.playedPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void setPosition(long l10) {
        this.position = l10;
        String string2 = this.getProgressText();
        this.setContentDescription(string2);
        this.update();
    }

    public void setScrubberColor(int n10) {
        this.scrubberPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void setUnplayedColor(int n10) {
        this.unplayedPaint.setColor(n10);
        Rect rect = this.seekBounds;
        this.invalidate(rect);
    }

    public void showScrubber() {
        ValueAnimator valueAnimator = this.scrubberScalingAnimator;
        boolean bl2 = valueAnimator.isStarted();
        if (bl2) {
            valueAnimator = this.scrubberScalingAnimator;
            valueAnimator.cancel();
        }
        this.scrubberPaddingDisabled = false;
        this.scrubberScale = 1.0f;
        valueAnimator = this.seekBounds;
        this.invalidate((Rect)valueAnimator);
    }

    public void showScrubber(long l10) {
        ValueAnimator valueAnimator = this.scrubberScalingAnimator;
        boolean bl2 = valueAnimator.isStarted();
        if (bl2) {
            valueAnimator = this.scrubberScalingAnimator;
            valueAnimator.cancel();
        }
        this.scrubberPaddingDisabled = false;
        ValueAnimator valueAnimator2 = this.scrubberScalingAnimator;
        float f10 = this.scrubberScale;
        float[] fArray = new float[]{f10, 1.0f};
        valueAnimator2.setFloatValues(fArray);
        this.scrubberScalingAnimator.setDuration(l10);
        this.scrubberScalingAnimator.start();
    }
}

