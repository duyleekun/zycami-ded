/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.Region$Op
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.text.Layout
 *  android.text.Layout$Alignment
 *  android.text.StaticLayout
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.Property
 *  android.view.ActionMode$Callback
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.accessibility.AccessibilityEvent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.CompoundButton
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$string;
import androidx.appcompat.R$styleable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.text.AllCapsTransformationMethod;
import androidx.appcompat.widget.AppCompatTextHelper;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.SwitchCompat$1;
import androidx.appcompat.widget.ThemeUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;

public class SwitchCompat
extends CompoundButton {
    private static final String ACCESSIBILITY_EVENT_CLASS_NAME = "android.widget.Switch";
    private static final int[] CHECKED_STATE_SET;
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int THUMB_ANIMATION_DURATION = 250;
    private static final Property THUMB_POS;
    private static final int TOUCH_MODE_DOWN = 1;
    private static final int TOUCH_MODE_DRAGGING = 2;
    private static final int TOUCH_MODE_IDLE;
    private boolean mHasThumbTint;
    private boolean mHasThumbTintMode;
    private boolean mHasTrackTint;
    private boolean mHasTrackTintMode;
    private int mMinFlingVelocity;
    private Layout mOffLayout;
    private Layout mOnLayout;
    public ObjectAnimator mPositionAnimator;
    private boolean mShowText;
    private boolean mSplitTrack;
    private int mSwitchBottom;
    private int mSwitchHeight;
    private int mSwitchLeft;
    private int mSwitchMinWidth;
    private int mSwitchPadding;
    private int mSwitchRight;
    private int mSwitchTop;
    private TransformationMethod mSwitchTransformationMethod;
    private int mSwitchWidth;
    private final Rect mTempRect;
    private ColorStateList mTextColors;
    private final AppCompatTextHelper mTextHelper;
    private CharSequence mTextOff;
    private CharSequence mTextOn;
    private final TextPaint mTextPaint;
    private Drawable mThumbDrawable;
    public float mThumbPosition;
    private int mThumbTextPadding;
    private ColorStateList mThumbTintList;
    private PorterDuff.Mode mThumbTintMode;
    private int mThumbWidth;
    private int mTouchMode;
    private int mTouchSlop;
    private float mTouchX;
    private float mTouchY;
    private Drawable mTrackDrawable;
    private ColorStateList mTrackTintList;
    private PorterDuff.Mode mTrackTintMode;
    private VelocityTracker mVelocityTracker;

    static {
        Object object = new SwitchCompat$1(Float.class, "thumbPos");
        THUMB_POS = object;
        object = new int[1];
        object[0] = (SwitchCompat$1)0x10100A0;
        CHECKED_STATE_SET = (int[])object;
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.switchStyle;
        this(context, attributeSet, n10);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int bl3;
        int n11;
        Object object;
        float f10;
        int n12 = 0;
        Object object2 = null;
        this.mThumbTintList = null;
        this.mThumbTintMode = null;
        this.mHasThumbTint = false;
        this.mHasThumbTintMode = false;
        this.mTrackTintList = null;
        this.mTrackTintMode = null;
        this.mHasTrackTint = false;
        this.mHasTrackTintMode = false;
        Object object3 = VelocityTracker.obtain();
        this.mVelocityTracker = object3;
        super();
        this.mTempRect = object3;
        object3 = this.getContext();
        ThemeUtils.checkAppCompatTheme((View)this, (Context)object3);
        boolean bl2 = true;
        super(bl2 ? 1 : 0);
        this.mTextPaint = object3;
        ((TextPaint)object3).density = f10 = this.getResources().getDisplayMetrics().density;
        int[] nArray = R$styleable.SwitchCompat;
        object3 = TintTypedArray.obtainStyledAttributes(context, attributeSet, nArray, n10, 0);
        TypedArray typedArray = ((TintTypedArray)object3).getWrappedTypeArray();
        Context context2 = context;
        ViewCompat.saveAttributeDataForStyleable((View)this, context, nArray, attributeSet, typedArray, n10, 0);
        int n13 = R$styleable.SwitchCompat_android_thumb;
        this.mThumbDrawable = object = ((TintTypedArray)object3).getDrawable(n13);
        if (object != null) {
            object.setCallback((Drawable.Callback)this);
        }
        n13 = R$styleable.SwitchCompat_track;
        this.mTrackDrawable = object = ((TintTypedArray)object3).getDrawable(n13);
        if (object != null) {
            object.setCallback((Drawable.Callback)this);
        }
        n13 = R$styleable.SwitchCompat_android_textOn;
        object = ((TintTypedArray)object3).getText(n13);
        this.mTextOn = object;
        n13 = R$styleable.SwitchCompat_android_textOff;
        object = ((TintTypedArray)object3).getText(n13);
        this.mTextOff = object;
        n13 = R$styleable.SwitchCompat_showText;
        n13 = ((TintTypedArray)object3).getBoolean(n13, bl2) ? 1 : 0;
        this.mShowText = n13;
        n13 = R$styleable.SwitchCompat_thumbTextPadding;
        this.mThumbTextPadding = n13 = ((TintTypedArray)object3).getDimensionPixelSize(n13, 0);
        n13 = R$styleable.SwitchCompat_switchMinWidth;
        this.mSwitchMinWidth = n13 = ((TintTypedArray)object3).getDimensionPixelSize(n13, 0);
        n13 = R$styleable.SwitchCompat_switchPadding;
        this.mSwitchPadding = n13 = ((TintTypedArray)object3).getDimensionPixelSize(n13, 0);
        n13 = R$styleable.SwitchCompat_splitTrack;
        n13 = ((TintTypedArray)object3).getBoolean(n13, false) ? 1 : 0;
        this.mSplitTrack = n13;
        n13 = R$styleable.SwitchCompat_thumbTint;
        object = ((TintTypedArray)object3).getColorStateList(n13);
        if (object != null) {
            this.mThumbTintList = object;
            this.mHasThumbTint = bl2;
        }
        n13 = R$styleable.SwitchCompat_thumbTintMode;
        context2 = this.mThumbTintMode;
        int n14 = -1;
        object = DrawableUtils.parseTintMode(n13 = ((TintTypedArray)object3).getInt(n13, n14), null);
        if (context2 != object) {
            this.mThumbTintMode = object;
            this.mHasThumbTintMode = bl2;
        }
        if ((n13 = (int)(this.mHasThumbTint ? 1 : 0)) != 0 || (n13 = (int)(this.mHasThumbTintMode ? 1 : 0)) != 0) {
            this.applyThumbTint();
        }
        if ((object = ((TintTypedArray)object3).getColorStateList(n13 = R$styleable.SwitchCompat_trackTint)) != null) {
            this.mTrackTintList = object;
            this.mHasTrackTint = bl2;
        }
        n13 = R$styleable.SwitchCompat_trackTintMode;
        object = this.mTrackTintMode;
        object2 = DrawableUtils.parseTintMode(n13 = ((TintTypedArray)object3).getInt(n13, n14), null);
        if (object != object2) {
            this.mTrackTintMode = object2;
            this.mHasTrackTintMode = bl2;
        }
        if ((n12 = this.mHasTrackTint) != 0 || (n12 = this.mHasTrackTintMode) != 0) {
            this.applyTrackTint();
        }
        n12 = R$styleable.SwitchCompat_switchTextAppearance;
        if ((n12 = ((TintTypedArray)object3).getResourceId(n12, 0)) != 0) {
            this.setSwitchTextAppearance(context, n12);
        }
        super((TextView)this);
        this.mTextHelper = object2;
        ((AppCompatTextHelper)object2).loadFromAttributes(attributeSet, n10);
        ((TintTypedArray)object3).recycle();
        context = ViewConfiguration.get((Context)context);
        this.mTouchSlop = n11 = context.getScaledTouchSlop();
        this.mMinFlingVelocity = bl3 = context.getScaledMinimumFlingVelocity();
        this.refreshDrawableState();
        boolean bl4 = this.isChecked();
        this.setChecked(bl4);
    }

    private void animateThumbToCheckedState(boolean n10) {
        ObjectAnimator objectAnimator;
        float f10;
        if (n10 != 0) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            n10 = 0;
            f10 = 0.0f;
            objectAnimator = null;
        }
        Property property = THUMB_POS;
        boolean bl2 = true;
        float[] fArray = new float[bl2];
        fArray[0] = f10;
        this.mPositionAnimator = objectAnimator = ObjectAnimator.ofFloat((Object)((Object)this), (Property)property, (float[])fArray);
        long l10 = 250L;
        objectAnimator.setDuration(l10);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            objectAnimator = this.mPositionAnimator;
            objectAnimator.setAutoCancel(bl2);
        }
        this.mPositionAnimator.start();
    }

    private void applyThumbTint() {
        boolean bl2;
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null && ((bl2 = this.mHasThumbTint) || (bl2 = this.mHasThumbTintMode))) {
            boolean bl3;
            Object object;
            this.mThumbDrawable = drawable2 = DrawableCompat.wrap(drawable2).mutate();
            bl2 = this.mHasThumbTint;
            if (bl2) {
                object = this.mThumbTintList;
                DrawableCompat.setTintList(drawable2, object);
            }
            if (bl3 = this.mHasThumbTintMode) {
                drawable2 = this.mThumbDrawable;
                object = this.mThumbTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)object);
            }
            if (bl3 = (drawable2 = this.mThumbDrawable).isStateful()) {
                drawable2 = this.mThumbDrawable;
                object = this.getDrawableState();
                drawable2.setState((int[])object);
            }
        }
    }

    private void applyTrackTint() {
        boolean bl2;
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null && ((bl2 = this.mHasTrackTint) || (bl2 = this.mHasTrackTintMode))) {
            boolean bl3;
            Object object;
            this.mTrackDrawable = drawable2 = DrawableCompat.wrap(drawable2).mutate();
            bl2 = this.mHasTrackTint;
            if (bl2) {
                object = this.mTrackTintList;
                DrawableCompat.setTintList(drawable2, object);
            }
            if (bl3 = this.mHasTrackTintMode) {
                drawable2 = this.mTrackDrawable;
                object = this.mTrackTintMode;
                DrawableCompat.setTintMode(drawable2, (PorterDuff.Mode)object);
            }
            if (bl3 = (drawable2 = this.mTrackDrawable).isStateful()) {
                drawable2 = this.mTrackDrawable;
                object = this.getDrawableState();
                drawable2.setState((int[])object);
            }
        }
    }

    private void cancelPositionAnimator() {
        ObjectAnimator objectAnimator = this.mPositionAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void cancelSuperTouch(MotionEvent motionEvent) {
        motionEvent = MotionEvent.obtain((MotionEvent)motionEvent);
        motionEvent.setAction(3);
        super.onTouchEvent(motionEvent);
        motionEvent.recycle();
    }

    private static float constrain(float f10, float f11, float f12) {
        float f13 = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (f13 < 0) {
            f10 = f11;
        } else {
            float f14 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
            if (f14 > 0) {
                f10 = f12;
            }
        }
        return f10;
    }

    private boolean getTargetCheckedState() {
        float f10 = this.mThumbPosition;
        float f11 = 0.5f;
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 > 0) {
            f13 = 1.0f;
            f10 = Float.MIN_VALUE;
        } else {
            f13 = 0.0f;
            f10 = 0.0f;
        }
        return (boolean)f13;
    }

    private int getThumbOffset() {
        float f10;
        float f11;
        int n10 = ViewUtils.isLayoutRtl((View)this);
        if (n10 != 0) {
            n10 = 1065353216;
            f11 = this.mThumbPosition;
            f10 = 1.0f - f11;
        } else {
            f10 = this.mThumbPosition;
        }
        f11 = this.getThumbScrollRange();
        return (int)(f10 * f11 + 0.5f);
    }

    private int getThumbScrollRange() {
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            Rect rect = this.mTempRect;
            drawable2.getPadding(rect);
            drawable2 = this.mThumbDrawable;
            drawable2 = drawable2 != null ? DrawableUtils.getOpticalBounds(drawable2) : DrawableUtils.INSETS_NONE;
            int n10 = this.mSwitchWidth;
            int n11 = this.mThumbWidth;
            n10 -= n11;
            n11 = rect.left;
            n10 -= n11;
            int n12 = rect.right;
            n10 -= n12;
            n12 = drawable2.left;
            int n13 = drawable2.right;
            return (n10 -= n12) - n13;
        }
        return 0;
    }

    private boolean hitThumb(float f10, float f11) {
        float f12;
        float f13;
        float f14;
        float f15;
        float f16;
        Drawable drawable2 = this.mThumbDrawable;
        boolean bl2 = false;
        if (drawable2 == null) {
            return false;
        }
        int n10 = this.getThumbOffset();
        Drawable drawable3 = this.mThumbDrawable;
        Rect rect = this.mTempRect;
        drawable3.getPadding(rect);
        int n11 = this.mSwitchTop;
        int n12 = this.mTouchSlop;
        n11 -= n12;
        int n13 = this.mSwitchLeft + n10 - n12;
        n10 = this.mThumbWidth + n13;
        Rect rect2 = this.mTempRect;
        int n14 = rect2.left;
        n10 += n14;
        int n15 = rect2.right;
        n10 = n10 + n15 + n12;
        n15 = this.mSwitchBottom + n12;
        float f17 = n13;
        n12 = f10 == f17 ? 0 : (f10 > f17 ? 1 : -1);
        if (n12 > 0 && (f16 = (f15 = f10 - (f14 = (float)n10)) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1)) < 0 && (f16 = (f13 = f11 - (f10 = (float)n11)) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0 && (f16 = (f12 = f11 - (f10 = (float)n15)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) < 0) {
            bl2 = true;
        }
        return bl2;
    }

    private Layout makeLayout(CharSequence charSequence) {
        int n10;
        Object object = this.mSwitchTransformationMethod;
        if (object != null) {
            charSequence = object.getTransformation(charSequence, (View)this);
        }
        CharSequence charSequence2 = charSequence;
        TextPaint textPaint = this.mTextPaint;
        if (charSequence2 != null) {
            float f10 = Layout.getDesiredWidth((CharSequence)charSequence2, (TextPaint)textPaint);
            double d10 = Math.ceil(f10);
            n10 = (int)d10;
        } else {
            n10 = 0;
            float f11 = 0.0f;
            object = null;
        }
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        object = charSequence;
        charSequence = new StaticLayout(charSequence2, textPaint, n10, alignment, 1.0f, 0.0f, true);
        return charSequence;
    }

    private void setOffStateDescriptionOnRAndAbove() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            CharSequence charSequence = this.mTextOff;
            if (charSequence == null) {
                charSequence = this.getResources();
                n11 = R$string.abc_capital_off;
                charSequence = charSequence.getString(n11);
            }
            ViewCompat.setStateDescription((View)this, charSequence);
        }
    }

    private void setOnStateDescriptionOnRAndAbove() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            CharSequence charSequence = this.mTextOn;
            if (charSequence == null) {
                charSequence = this.getResources();
                n11 = R$string.abc_capital_on;
                charSequence = charSequence.getString(n11);
            }
            ViewCompat.setStateDescription((View)this, charSequence);
        }
    }

    private void setSwitchTypefaceByIndex(int n10, int n11) {
        Typeface typeface;
        int n12 = 1;
        if (n10 != n12) {
            n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    n10 = 0;
                    typeface = null;
                } else {
                    typeface = Typeface.MONOSPACE;
                }
            } else {
                typeface = Typeface.SERIF;
            }
        } else {
            typeface = Typeface.SANS_SERIF;
        }
        this.setSwitchTypeface(typeface, n11);
    }

    private void stopDrag(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        float f10;
        this.mTouchMode = 0;
        int n10 = motionEvent.getAction();
        int n11 = 1;
        float f11 = Float.MIN_VALUE;
        if (n10 == n11 && (n10 = (int)(this.isEnabled() ? 1 : 0)) != 0) {
            n10 = n11;
            f10 = f11;
        } else {
            n10 = 0;
            velocityTracker = null;
            f10 = 0.0f;
        }
        int n12 = this.isChecked();
        if (n10 != 0) {
            this.mVelocityTracker.computeCurrentVelocity(1000);
            velocityTracker = this.mVelocityTracker;
            f10 = velocityTracker.getXVelocity();
            float f12 = Math.abs(f10);
            int n13 = this.mMinFlingVelocity;
            float f13 = n13;
            float f14 = f12 == f13 ? 0 : (f12 > f13 ? 1 : -1);
            if (f14 > 0) {
                float f15;
                float f16;
                f14 = (float)ViewUtils.isLayoutRtl((View)this);
                n13 = 0;
                f13 = 0.0f;
                if (!(f14 != false ? (n10 = (f16 = f10 - 0.0f) == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1)) < 0 : (n10 = (f15 = f10 - 0.0f) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) > 0)) {
                    n11 = 0;
                    f11 = 0.0f;
                }
            } else {
                n11 = this.getTargetCheckedState();
            }
        } else {
            n11 = n12;
        }
        if (n11 != n12) {
            this.playSoundEffect(0);
        }
        this.setChecked(n11 != 0);
        this.cancelSuperTouch(motionEvent);
    }

    public void draw(Canvas canvas) {
        Drawable drawable2;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        Rect rect;
        block4: {
            int n15;
            int n16;
            block7: {
                block6: {
                    block5: {
                        rect = this.mTempRect;
                        n14 = this.mSwitchLeft;
                        n13 = this.mSwitchTop;
                        n12 = this.mSwitchRight;
                        n11 = this.mSwitchBottom;
                        n10 = this.getThumbOffset() + n14;
                        Drawable drawable3 = this.mThumbDrawable;
                        drawable3 = drawable3 != null ? DrawableUtils.getOpticalBounds(drawable3) : DrawableUtils.INSETS_NONE;
                        Drawable drawable4 = this.mTrackDrawable;
                        if (drawable4 == null) break block4;
                        drawable4.getPadding(rect);
                        n16 = rect.left;
                        n10 += n16;
                        if (drawable3 == null) break block5;
                        int n17 = drawable3.left;
                        if (n17 > n16) {
                            n14 += (n17 -= n16);
                        }
                        n16 = (n16 = drawable3.top) > (n17 = rect.top) ? n16 - n17 + n13 : n13;
                        n17 = drawable3.right;
                        int n18 = rect.right;
                        if (n17 > n18) {
                            n12 -= (n17 -= n18);
                        }
                        if ((n15 = drawable3.bottom) <= (n17 = rect.bottom)) break block6;
                        n15 -= n17;
                        n15 = n11 - n15;
                        break block7;
                    }
                    n16 = n13;
                }
                n15 = n11;
            }
            Drawable drawable5 = this.mTrackDrawable;
            drawable5.setBounds(n14, n16, n12, n15);
        }
        if ((drawable2 = this.mThumbDrawable) != null) {
            drawable2.getPadding(rect);
            n14 = rect.left;
            n14 = n10 - n14;
            n12 = this.mThumbWidth;
            n10 += n12;
            int n19 = rect.right;
            this.mThumbDrawable.setBounds(n14, n13, n10 += n19, n11);
            rect = this.getBackground();
            if (rect != null) {
                DrawableCompat.setHotspotBounds((Drawable)rect, n14, n13, n10, n11);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f10, float f11) {
        Drawable drawable2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            super.drawableHotspotChanged(f10, f11);
        }
        if ((drawable2 = this.mThumbDrawable) != null) {
            DrawableCompat.setHotspot(drawable2, f10, f11);
        }
        if ((drawable2 = this.mTrackDrawable) != null) {
            DrawableCompat.setHotspot(drawable2, f10, f11);
        }
    }

    public void drawableStateChanged() {
        boolean bl2;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable2 = this.mThumbDrawable;
        boolean bl3 = false;
        if (drawable2 != null && (bl2 = drawable2.isStateful())) {
            boolean bl4 = drawable2.setState(nArray);
            bl3 = false | bl4;
        }
        if ((drawable2 = this.mTrackDrawable) != null && (bl2 = drawable2.isStateful())) {
            boolean bl5 = drawable2.setState(nArray);
            bl3 |= bl5;
        }
        if (bl3) {
            this.invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        int n10 = ViewUtils.isLayoutRtl((View)this);
        if (n10 == 0) {
            return super.getCompoundPaddingLeft();
        }
        n10 = super.getCompoundPaddingLeft();
        int n11 = this.mSwitchWidth;
        n10 += n11;
        CharSequence charSequence = this.getText();
        n11 = TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0;
        if (n11 == 0) {
            n11 = this.mSwitchPadding;
            n10 += n11;
        }
        return n10;
    }

    public int getCompoundPaddingRight() {
        int n10 = ViewUtils.isLayoutRtl((View)this);
        if (n10 != 0) {
            return super.getCompoundPaddingRight();
        }
        n10 = super.getCompoundPaddingRight();
        int n11 = this.mSwitchWidth;
        n10 += n11;
        CharSequence charSequence = this.getText();
        n11 = TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0;
        if (n11 == 0) {
            n11 = this.mSwitchPadding;
            n10 += n11;
        }
        return n10;
    }

    public boolean getShowText() {
        return this.mShowText;
    }

    public boolean getSplitTrack() {
        return this.mSplitTrack;
    }

    public int getSwitchMinWidth() {
        return this.mSwitchMinWidth;
    }

    public int getSwitchPadding() {
        return this.mSwitchPadding;
    }

    public CharSequence getTextOff() {
        return this.mTextOff;
    }

    public CharSequence getTextOn() {
        return this.mTextOn;
    }

    public Drawable getThumbDrawable() {
        return this.mThumbDrawable;
    }

    public int getThumbTextPadding() {
        return this.mThumbTextPadding;
    }

    public ColorStateList getThumbTintList() {
        return this.mThumbTintList;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.mThumbTintMode;
    }

    public Drawable getTrackDrawable() {
        return this.mTrackDrawable;
    }

    public ColorStateList getTrackTintList() {
        return this.mTrackTintList;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.mTrackTintMode;
    }

    public void jumpDrawablesToCurrentState() {
        boolean bl2;
        super.jumpDrawablesToCurrentState();
        Drawable drawable2 = this.mThumbDrawable;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        if ((drawable2 = this.mTrackDrawable) != null) {
            drawable2.jumpToCurrentState();
        }
        if ((drawable2 = this.mPositionAnimator) != null && (bl2 = drawable2.isStarted())) {
            this.mPositionAnimator.end();
            bl2 = false;
            drawable2 = null;
            this.mPositionAnimator = null;
        }
    }

    public int[] onCreateDrawableState(int n10) {
        int[] nArray = super.onCreateDrawableState(++n10);
        boolean bl2 = this.isChecked();
        if (bl2) {
            int[] nArray2 = CHECKED_STATE_SET;
            CompoundButton.mergeDrawableStates((int[])nArray, (int[])nArray2);
        }
        return nArray;
    }

    public void onDraw(Canvas canvas) {
        boolean bl2;
        ColorStateList colorStateList;
        int n10;
        Object object;
        int n11;
        super.onDraw(canvas);
        Rect rect = this.mTempRect;
        Drawable drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int n12 = this.mSwitchTop;
        int n13 = this.mSwitchBottom;
        int n14 = rect.top;
        n12 += n14;
        n14 = rect.bottom;
        n13 -= n14;
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable2 != null) {
            n11 = this.mSplitTrack;
            if (n11 != 0 && drawable3 != null) {
                object = DrawableUtils.getOpticalBounds(drawable3);
                drawable3.copyBounds(rect);
                n10 = rect.left;
                int n15 = object.left;
                rect.left = n10 += n15;
                n10 = rect.right;
                n11 = object.right;
                rect.right = n10 -= n11;
                n11 = canvas.save();
                colorStateList = Region.Op.DIFFERENCE;
                canvas.clipRect(rect, (Region.Op)colorStateList);
                drawable2.draw(canvas);
                canvas.restoreToCount(n11);
            } else {
                drawable2.draw(canvas);
            }
        }
        int n16 = canvas.save();
        if (drawable3 != null) {
            drawable3.draw(canvas);
        }
        if ((drawable2 = (bl2 = this.getTargetCheckedState()) ? this.mOnLayout : this.mOffLayout) != null) {
            object = this.getDrawableState();
            colorStateList = this.mTextColors;
            if (colorStateList != null) {
                TextPaint textPaint = this.mTextPaint;
                n10 = colorStateList.getColorForState((int[])object, 0);
                textPaint.setColor(n10);
            }
            colorStateList = this.mTextPaint;
            colorStateList.drawableState = (int[])object;
            if (drawable3 != null) {
                drawable3 = drawable3.getBounds();
                n11 = drawable3.left;
                n14 = drawable3.right;
                n11 += n14;
            } else {
                n11 = this.getWidth();
            }
            n11 /= 2;
            n14 = drawable2.getWidth() / 2;
            n12 = (n12 + n13) / 2;
            n13 = drawable2.getHeight() / 2;
            float f10 = n11 -= n14;
            float f11 = n12 -= n13;
            canvas.translate(f10, f11);
            drawable2.draw(canvas);
        }
        canvas.restoreToCount(n16);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName((CharSequence)ACCESSIBILITY_EVENT_CLASS_NAME);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        boolean bl2;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        CharSequence charSequence = ACCESSIBILITY_EVENT_CLASS_NAME;
        accessibilityNodeInfo.setClassName(charSequence);
        char c10 = Build.VERSION.SDK_INT;
        char c11 = '\u001e';
        if (c10 < c11 && (c11 = (char)(TextUtils.isEmpty((CharSequence)(charSequence = (bl2 = this.isChecked()) ? this.mTextOn : this.mTextOff)) ? 1 : 0)) == '\u0000') {
            CharSequence charSequence2 = accessibilityNodeInfo.getText();
            boolean bl3 = TextUtils.isEmpty((CharSequence)charSequence2);
            if (bl3) {
                accessibilityNodeInfo.setText(charSequence);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(charSequence2);
                c11 = ' ';
                stringBuilder.append(c11);
                stringBuilder.append(charSequence);
                accessibilityNodeInfo.setText((CharSequence)stringBuilder);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var1_8;
        int n14;
        int n15;
        int n16;
        block9: {
            block8: {
                int n17;
                block6: {
                    block7: {
                        super.onLayout(bl2, n16, n15, n14, n17);
                        Drawable drawable2 = this.mThumbDrawable;
                        n16 = 0;
                        if (drawable2 != null) {
                            drawable2 = this.mTempRect;
                            Drawable drawable3 = this.mTrackDrawable;
                            if (drawable3 != null) {
                                drawable3.getPadding((Rect)drawable2);
                            } else {
                                drawable2.setEmpty();
                            }
                            drawable3 = DrawableUtils.getOpticalBounds(this.mThumbDrawable);
                            n14 = drawable3.left;
                            n17 = drawable2.left;
                            n14 -= n17;
                            n14 = Math.max(0, n14);
                            n15 = drawable3.right;
                            int n18 = drawable2.right;
                            n16 = Math.max(0, n15 -= n18);
                        } else {
                            n14 = 0;
                        }
                        boolean bl3 = ViewUtils.isLayoutRtl((View)this);
                        if (bl3) {
                            int n19 = this.getPaddingLeft() + n14;
                            n15 = this.mSwitchWidth + n19 - n14 - n16;
                        } else {
                            int n20 = this.getWidth();
                            n15 = this.getPaddingRight();
                            n15 = n20 - n15 - n16;
                            int n22 = this.mSwitchWidth;
                            n22 = n15 - n22 + n14 + n16;
                        }
                        n16 = this.getGravity() & 0x70;
                        n14 = 16;
                        if (n16 == n14) break block6;
                        n14 = 80;
                        if (n16 == n14) break block7;
                        n16 = this.getPaddingTop();
                        n14 = this.mSwitchHeight;
                        break block8;
                    }
                    n16 = this.getHeight();
                    n14 = this.getPaddingBottom();
                    n14 = n16 - n14;
                    n16 = this.mSwitchHeight;
                    n16 = n14 - n16;
                    break block9;
                }
                n16 = this.getPaddingTop();
                n14 = this.getHeight();
                n16 += n14;
                n14 = this.getPaddingBottom();
                n16 = (n16 - n14) / 2;
                n14 = this.mSwitchHeight;
                n17 = n14 / 2;
                n16 -= n17;
            }
            n14 += n16;
        }
        this.mSwitchLeft = var1_8;
        this.mSwitchTop = n16;
        this.mSwitchBottom = n14;
        this.mSwitchRight = n15;
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        Layout layout2;
        int n13;
        int n14;
        Object object;
        int n15 = this.mShowText;
        if (n15 != 0) {
            object = this.mOnLayout;
            if (object == null) {
                object = this.mTextOn;
                this.mOnLayout = object = this.makeLayout((CharSequence)object);
            }
            if ((object = this.mOffLayout) == null) {
                object = this.mTextOff;
                this.mOffLayout = object = this.makeLayout((CharSequence)object);
            }
        }
        object = this.mTempRect;
        Drawable drawable2 = this.mThumbDrawable;
        int n16 = 0;
        if (drawable2 != null) {
            drawable2.getPadding((Rect)object);
            drawable2 = this.mThumbDrawable;
            n14 = drawable2.getIntrinsicWidth();
            n13 = object.left;
            n14 -= n13;
            n13 = object.right;
            n14 -= n13;
            Drawable drawable3 = this.mThumbDrawable;
            n13 = drawable3.getIntrinsicHeight();
        } else {
            n14 = 0;
            drawable2 = null;
            n13 = 0;
            Object var9_10 = null;
        }
        int n17 = this.mShowText;
        if (n17 != 0) {
            layout2 = this.mOnLayout;
            n17 = layout2.getWidth();
            Layout layout3 = this.mOffLayout;
            n12 = layout3.getWidth();
            n17 = Math.max(n17, n12);
            n12 = this.mThumbTextPadding * 2;
            n17 += n12;
        } else {
            n17 = 0;
            layout2 = null;
        }
        this.mThumbWidth = n14 = Math.max(n17, n14);
        drawable2 = this.mTrackDrawable;
        if (drawable2 != null) {
            drawable2.getPadding((Rect)object);
            drawable2 = this.mTrackDrawable;
            n16 = drawable2.getIntrinsicHeight();
        } else {
            object.setEmpty();
        }
        n14 = object.left;
        n15 = object.right;
        layout2 = this.mThumbDrawable;
        if (layout2 != null) {
            layout2 = DrawableUtils.getOpticalBounds((Drawable)layout2);
            n12 = layout2.left;
            n14 = Math.max(n14, n12);
            n17 = layout2.right;
            n15 = Math.max(n15, n17);
        }
        n17 = this.mSwitchMinWidth;
        n12 = this.mThumbWidth * 2 + n14 + n15;
        n15 = Math.max(n17, n12);
        n14 = Math.max(n16, n13);
        this.mSwitchWidth = n15;
        this.mSwitchHeight = n14;
        super.onMeasure(n10, n11);
        n10 = this.getMeasuredHeight();
        if (n10 < n14) {
            n10 = this.getMeasuredWidthAndState();
            this.setMeasuredDimension(n10, n14);
        }
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent object) {
        super.onPopulateAccessibilityEvent((AccessibilityEvent)object);
        boolean bl2 = this.isChecked();
        CharSequence charSequence = bl2 ? this.mTextOn : this.mTextOff;
        if (charSequence != null) {
            object = object.getText();
            object.add(charSequence);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        block15: {
            boolean bl2;
            int n10;
            block12: {
                int n11;
                int n12;
                VelocityTracker velocityTracker;
                block13: {
                    float f10;
                    float f11;
                    block17: {
                        int n13;
                        float f12;
                        block16: {
                            float f13;
                            block14: {
                                velocityTracker = this.mVelocityTracker;
                                velocityTracker.addMovement(motionEvent);
                                int bl4 = motionEvent.getActionMasked();
                                n10 = 1;
                                if (bl4 == 0) break block12;
                                n12 = 2;
                                f13 = 2.8E-45f;
                                if (bl4 == n10) break block13;
                                if (bl4 == n12) break block14;
                                int n14 = 3;
                                float f14 = 4.2E-45f;
                                if (bl4 == n14) break block13;
                                break block15;
                            }
                            int n15 = this.mTouchMode;
                            if (n15 == n10) break block16;
                            if (n15 == n12) {
                                float f15;
                                float f16;
                                float f17;
                                float f18 = motionEvent.getX();
                                int n16 = this.getThumbScrollRange();
                                f13 = this.mTouchX;
                                f13 = f18 - f13;
                                int n17 = 1065353216;
                                float f19 = 1.0f;
                                boolean bl3 = false;
                                float f20 = 0.0f;
                                if (n16 != 0) {
                                    f17 = n16;
                                    f13 /= f17;
                                } else {
                                    float f21 = f13 - 0.0f;
                                    float f22 = f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1);
                                    if (f22 > 0) {
                                        int n18 = n17;
                                        f13 = f19;
                                    } else {
                                        int n19 = -1082130432;
                                        f17 = -1.0f;
                                        int n20 = n19;
                                        f13 = f17;
                                    }
                                }
                                boolean bl4 = ViewUtils.isLayoutRtl((View)this);
                                if (bl4) {
                                    f13 = -f13;
                                }
                                if ((f16 = (f15 = (f17 = SwitchCompat.constrain(this.mThumbPosition + f13, 0.0f, f19)) - (f13 = this.mThumbPosition)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false) {
                                    this.mTouchX = f18;
                                    this.setThumbPosition(f17);
                                }
                                return n10 != 0;
                            }
                            break block15;
                        }
                        f11 = motionEvent.getX();
                        f10 = motionEvent.getY();
                        float f23 = this.mTouchX;
                        float f24 = (f23 = Math.abs(f11 - f23)) - (f12 = (float)(n13 = this.mTouchSlop));
                        float f25 = f24 == 0.0f ? 0 : (f24 > 0.0f ? 1 : -1);
                        if (f25 > 0) break block17;
                        f23 = this.mTouchY;
                        float f26 = (f23 = Math.abs(f10 - f23)) - (f12 = (float)(n13 = this.mTouchSlop));
                        f25 = f26 == 0.0f ? 0 : (f26 > 0.0f ? 1 : -1);
                        if (f25 <= 0) break block15;
                    }
                    this.mTouchMode = n12;
                    this.getParent().requestDisallowInterceptTouchEvent(n10 != 0);
                    this.mTouchX = f11;
                    this.mTouchY = f10;
                    return n10 != 0;
                    break block15;
                }
                if ((n11 = this.mTouchMode) == n12) {
                    this.stopDrag(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return n10 != 0;
                }
                boolean bl5 = false;
                float f27 = 0.0f;
                this.mTouchMode = 0;
                velocityTracker = this.mVelocityTracker;
                velocityTracker.clear();
                break block15;
            }
            float f28 = motionEvent.getX();
            float f29 = motionEvent.getY();
            boolean bl6 = this.isEnabled();
            if (bl6 && (bl2 = this.hitThumb(f28, f29))) {
                this.mTouchMode = n10;
                this.mTouchX = f28;
                this.mTouchY = f29;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean bl2) {
        boolean bl3;
        super.setChecked(bl2);
        boolean bl4 = this.isChecked();
        if (bl4) {
            this.setOnStateDescriptionOnRAndAbove();
        } else {
            this.setOffStateDescriptionOnRAndAbove();
        }
        IBinder iBinder = this.getWindowToken();
        if (iBinder != null && (bl3 = ViewCompat.isLaidOut((View)this))) {
            this.animateThumbToCheckedState(bl4);
        } else {
            float f10;
            this.cancelPositionAnimator();
            if (bl4) {
                int n10 = 1065353216;
                f10 = 1.0f;
            } else {
                boolean bl5 = false;
                f10 = 0.0f;
            }
            this.setThumbPosition(f10);
        }
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        callback = TextViewCompat.wrapCustomSelectionActionModeCallback((TextView)this, callback);
        super.setCustomSelectionActionModeCallback(callback);
    }

    public void setShowText(boolean bl2) {
        boolean bl3 = this.mShowText;
        if (bl3 != bl2) {
            this.mShowText = bl2;
            this.requestLayout();
        }
    }

    public void setSplitTrack(boolean bl2) {
        this.mSplitTrack = bl2;
        this.invalidate();
    }

    public void setSwitchMinWidth(int n10) {
        this.mSwitchMinWidth = n10;
        this.requestLayout();
    }

    public void setSwitchPadding(int n10) {
        this.mSwitchPadding = n10;
        this.requestLayout();
    }

    public void setSwitchTextAppearance(Context object, int n10) {
        TextPaint textPaint;
        float f10;
        float f11;
        float f12;
        int n11;
        Object object2 = R$styleable.TextAppearance;
        Object object3 = ((TintTypedArray)(object = TintTypedArray.obtainStyledAttributes((Context)object, n10, object2))).getColorStateList(n10 = R$styleable.TextAppearance_android_textColor);
        this.mTextColors = object3 != null ? object3 : (object3 = this.getTextColors());
        n10 = R$styleable.TextAppearance_android_textSize;
        object2 = null;
        if ((n10 = ((TintTypedArray)object).getDimensionPixelSize(n10, 0)) != 0 && (n11 = (int)((f12 = (f11 = (float)n10) - (f10 = (textPaint = this.mTextPaint).getTextSize())) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) != 0) {
            textPaint = this.mTextPaint;
            textPaint.setTextSize(f11);
            this.requestLayout();
        }
        n10 = R$styleable.TextAppearance_android_typeface;
        n11 = -1;
        f10 = 0.0f / 0.0f;
        n10 = ((TintTypedArray)object).getInt(n10, n11);
        int n12 = R$styleable.TextAppearance_android_textStyle;
        n11 = ((TintTypedArray)object).getInt(n12, n11);
        this.setSwitchTypefaceByIndex(n10, n11);
        n10 = R$styleable.TextAppearance_textAllCaps;
        n10 = ((TintTypedArray)object).getBoolean(n10, false) ? 1 : 0;
        if (n10 != 0) {
            object2 = this.getContext();
            object3 = new AllCapsTransformationMethod((Context)object2);
            this.mSwitchTransformationMethod = object3;
        } else {
            n10 = 0;
            f11 = 0.0f;
            object3 = null;
            this.mSwitchTransformationMethod = null;
        }
        ((TintTypedArray)object).recycle();
    }

    public void setSwitchTypeface(Typeface typeface) {
        boolean bl2;
        Typeface typeface2 = this.mTextPaint.getTypeface();
        if (typeface2 != null && !(bl2 = (typeface2 = this.mTextPaint.getTypeface()).equals((Object)typeface)) || (typeface2 = this.mTextPaint.getTypeface()) == null && typeface != null) {
            typeface2 = this.mTextPaint;
            typeface2.setTypeface(typeface);
            this.requestLayout();
            this.invalidate();
        }
    }

    public void setSwitchTypeface(Typeface typeface, int n10) {
        float f10 = 0.0f;
        boolean bl2 = false;
        if (n10 > 0) {
            int n11;
            typeface = typeface == null ? Typeface.defaultFromStyle((int)n10) : Typeface.create((Typeface)typeface, (int)n10);
            this.setSwitchTypeface(typeface);
            if (typeface != null) {
                n11 = typeface.getStyle();
            } else {
                n11 = 0;
                typeface = null;
            }
            n11 = ~n11 & n10;
            TextPaint textPaint = this.mTextPaint;
            int n12 = n11 & 1;
            if (n12 != 0) {
                bl2 = true;
            }
            textPaint.setFakeBoldText(bl2);
            textPaint = this.mTextPaint;
            if ((n11 &= 2) != 0) {
                f10 = -0.25f;
            }
            textPaint.setTextSkewX(f10);
        } else {
            this.mTextPaint.setFakeBoldText(false);
            TextPaint textPaint = this.mTextPaint;
            textPaint.setTextSkewX(0.0f);
            this.setSwitchTypeface(typeface);
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.mTextOff = charSequence;
        this.requestLayout();
        boolean bl2 = this.isChecked();
        if (!bl2) {
            this.setOffStateDescriptionOnRAndAbove();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        this.mTextOn = charSequence;
        this.requestLayout();
        boolean bl2 = this.isChecked();
        if (bl2) {
            this.setOnStateDescriptionOnRAndAbove();
        }
    }

    public void setThumbDrawable(Drawable drawable2) {
        Drawable drawable3 = this.mThumbDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        this.mThumbDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
        }
        this.requestLayout();
    }

    public void setThumbPosition(float f10) {
        this.mThumbPosition = f10;
        this.invalidate();
    }

    public void setThumbResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setThumbDrawable(drawable2);
    }

    public void setThumbTextPadding(int n10) {
        this.mThumbTextPadding = n10;
        this.requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.mThumbTintList = colorStateList;
        this.mHasThumbTint = true;
        this.applyThumbTint();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.mThumbTintMode = mode;
        this.mHasThumbTintMode = true;
        this.applyThumbTint();
    }

    public void setTrackDrawable(Drawable drawable2) {
        Drawable drawable3 = this.mTrackDrawable;
        if (drawable3 != null) {
            drawable3.setCallback(null);
        }
        this.mTrackDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback)this);
        }
        this.requestLayout();
    }

    public void setTrackResource(int n10) {
        Drawable drawable2 = AppCompatResources.getDrawable(this.getContext(), n10);
        this.setTrackDrawable(drawable2);
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.mTrackTintList = colorStateList;
        this.mHasTrackTint = true;
        this.applyTrackTint();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.mTrackTintMode = mode;
        this.mHasTrackTintMode = true;
        this.applyTrackTint();
    }

    public void toggle() {
        boolean bl2 = this.isChecked() ^ true;
        this.setChecked(bl2);
    }

    public boolean verifyDrawable(Drawable drawable2) {
        boolean bl2;
        Drawable drawable3;
        boolean bl3 = super.verifyDrawable(drawable2);
        if (!bl3 && drawable2 != (drawable3 = this.mThumbDrawable) && drawable2 != (drawable3 = this.mTrackDrawable)) {
            bl2 = false;
            drawable2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }
}

