/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.TypedArray
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.TintableBackgroundView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TintableImageSourceView;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.expandable.ExpandableTransformationWidget;
import com.google.android.material.expandable.ExpandableWidgetHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton$1;
import com.google.android.material.floatingactionbutton.FloatingActionButton$OnVisibilityChangedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton$ShadowDelegateImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$InternalVisibilityChangedListener;
import com.google.android.material.floatingactionbutton.FloatingActionButtonImplLollipop;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.stateful.ExtendableSavedState;

public class FloatingActionButton
extends VisibilityAwareImageButton
implements TintableBackgroundView,
TintableImageSourceView,
ExpandableTransformationWidget {
    private static final int AUTO_MINI_LARGEST_SCREEN_WIDTH = 470;
    private static final String EXPANDABLE_WIDGET_HELPER_KEY = "expandableWidgetHelper";
    private static final String LOG_TAG = "FloatingActionButton";
    public static final int NO_CUSTOM_SIZE = 0;
    public static final int SIZE_AUTO = 255;
    public static final int SIZE_MINI = 1;
    public static final int SIZE_NORMAL;
    private ColorStateList backgroundTint;
    private PorterDuff.Mode backgroundTintMode;
    private int borderWidth;
    public boolean compatPadding;
    private int customSize;
    private final ExpandableWidgetHelper expandableWidgetHelper;
    private final AppCompatImageHelper imageHelper;
    private PorterDuff.Mode imageMode;
    private int imagePadding;
    private ColorStateList imageTint;
    private FloatingActionButtonImpl impl;
    private int maxImageSize;
    private ColorStateList rippleColor;
    public final Rect shadowPadding;
    private int size;
    private final Rect touchArea;

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.floatingActionButtonStyle;
        this(context, attributeSet, n10);
    }

    public FloatingActionButton(Context object, AttributeSet object2, int n10) {
        super((Context)object, (AttributeSet)object2, n10);
        int n11;
        Object object3;
        this.shadowPadding = object3 = new Rect();
        this.touchArea = object3 = new Rect();
        int[] nArray = R$styleable.FloatingActionButton;
        int n12 = R$style.Widget_Design_FloatingActionButton;
        int[] nArray2 = new int[]{};
        Object object4 = object;
        AttributeSet attributeSet = object2;
        int n13 = n10;
        object4 = ThemeEnforcement.obtainStyledAttributes(object, (AttributeSet)object2, nArray, n10, n12, nArray2);
        int n14 = R$styleable.FloatingActionButton_backgroundTint;
        attributeSet = MaterialResources.getColorStateList(object, (TypedArray)object4, n14);
        this.backgroundTint = attributeSet;
        n14 = R$styleable.FloatingActionButton_backgroundTintMode;
        int n15 = -1;
        attributeSet = ViewUtils.parseTintMode(object4.getInt(n14, n15), null);
        this.backgroundTintMode = attributeSet;
        n14 = R$styleable.FloatingActionButton_rippleColor;
        attributeSet = MaterialResources.getColorStateList(object, (TypedArray)object4, n14);
        this.rippleColor = attributeSet;
        n14 = R$styleable.FloatingActionButton_fabSize;
        this.size = n14 = object4.getInt(n14, n15);
        n14 = R$styleable.FloatingActionButton_fabCustomSize;
        this.customSize = n14 = object4.getDimensionPixelSize(n14, 0);
        n14 = R$styleable.FloatingActionButton_borderWidth;
        this.borderWidth = n14 = object4.getDimensionPixelSize(n14, 0);
        n14 = R$styleable.FloatingActionButton_elevation;
        float f10 = object4.getDimension(n14, 0.0f);
        n13 = R$styleable.FloatingActionButton_hoveredFocusedTranslationZ;
        float f11 = object4.getDimension(n13, 0.0f);
        n12 = R$styleable.FloatingActionButton_pressedTranslationZ;
        float f12 = object4.getDimension(n12, 0.0f);
        n12 = R$styleable.FloatingActionButton_useCompatPadding;
        n12 = (int)(object4.getBoolean(n12, false) ? 1 : 0);
        this.compatPadding = n12;
        n12 = R$styleable.FloatingActionButton_maxImageSize;
        this.maxImageSize = n11 = object4.getDimensionPixelSize(n12, 0);
        n11 = R$styleable.FloatingActionButton_showMotionSpec;
        object3 = MotionSpec.createFromAttribute(object, (TypedArray)object4, n11);
        n12 = R$styleable.FloatingActionButton_hideMotionSpec;
        object = MotionSpec.createFromAttribute(object, (TypedArray)object4, n12);
        object4.recycle();
        super((ImageView)this);
        this.imageHelper = object4;
        ((AppCompatImageHelper)object4).loadFromAttributes((AttributeSet)object2, n10);
        super(this);
        this.expandableWidgetHelper = object2;
        object2 = this.getImpl();
        ColorStateList colorStateList = this.backgroundTint;
        object4 = this.backgroundTintMode;
        ColorStateList colorStateList2 = this.rippleColor;
        int n16 = this.borderWidth;
        ((FloatingActionButtonImpl)object2).setBackgroundDrawable(colorStateList, (PorterDuff.Mode)object4, colorStateList2, n16);
        this.getImpl().setElevation(f10);
        this.getImpl().setHoveredFocusedTranslationZ(f11);
        this.getImpl().setPressedTranslationZ(f12);
        object2 = this.getImpl();
        n10 = this.maxImageSize;
        ((FloatingActionButtonImpl)object2).setMaxImageSize(n10);
        this.getImpl().setShowMotionSpec((MotionSpec)object3);
        this.getImpl().setHideMotionSpec((MotionSpec)object);
        object = ImageView.ScaleType.MATRIX;
        this.setScaleType((ImageView.ScaleType)object);
    }

    public static /* synthetic */ int access$000(FloatingActionButton floatingActionButton) {
        return floatingActionButton.imagePadding;
    }

    public static /* synthetic */ void access$101(FloatingActionButton floatingActionButton, Drawable drawable2) {
        super.setBackgroundDrawable(drawable2);
    }

    private FloatingActionButtonImpl createImpl() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            FloatingActionButton$ShadowDelegateImpl floatingActionButton$ShadowDelegateImpl = new FloatingActionButton$ShadowDelegateImpl(this);
            FloatingActionButtonImplLollipop floatingActionButtonImplLollipop = new FloatingActionButtonImplLollipop(this, floatingActionButton$ShadowDelegateImpl);
            return floatingActionButtonImplLollipop;
        }
        FloatingActionButton$ShadowDelegateImpl floatingActionButton$ShadowDelegateImpl = new FloatingActionButton$ShadowDelegateImpl(this);
        FloatingActionButtonImpl floatingActionButtonImpl = new FloatingActionButtonImpl(this, floatingActionButton$ShadowDelegateImpl);
        return floatingActionButtonImpl;
    }

    private FloatingActionButtonImpl getImpl() {
        FloatingActionButtonImpl floatingActionButtonImpl = this.impl;
        if (floatingActionButtonImpl == null) {
            this.impl = floatingActionButtonImpl = this.createImpl();
        }
        return this.impl;
    }

    private int getSizeDimension(int n10) {
        int n11 = this.customSize;
        if (n11 != 0) {
            return n11;
        }
        Resources resources = this.getResources();
        int n12 = -1;
        int n13 = 1;
        if (n10 != n12) {
            if (n10 != n13) {
                n10 = R$dimen.design_fab_size_normal;
                return resources.getDimensionPixelSize(n10);
            }
            n10 = R$dimen.design_fab_size_mini;
            return resources.getDimensionPixelSize(n10);
        }
        Configuration configuration = resources.getConfiguration();
        n10 = configuration.screenWidthDp;
        resources = resources.getConfiguration();
        n11 = resources.screenHeightDp;
        if ((n10 = Math.max(n10, n11)) < (n11 = 470)) {
            n10 = this.getSizeDimension(n13);
        } else {
            configuration = null;
            n10 = this.getSizeDimension(0);
        }
        return n10;
    }

    private void offsetRectWithShadow(Rect rect) {
        int n10 = rect.left;
        Rect rect2 = this.shadowPadding;
        int n11 = rect2.left;
        rect.left = n10 += n11;
        n10 = rect.top;
        n11 = rect2.top;
        rect.top = n10 += n11;
        n10 = rect.right;
        n11 = rect2.right;
        rect.right = n10 -= n11;
        n10 = rect.bottom;
        int n12 = rect2.bottom;
        rect.bottom = n10 -= n12;
    }

    private void onApplySupportImageTint() {
        Drawable drawable2 = this.getDrawable();
        if (drawable2 == null) {
            return;
        }
        ColorStateList colorStateList = this.imageTint;
        if (colorStateList == null) {
            DrawableCompat.clearColorFilter(drawable2);
            return;
        }
        Object object = this.getDrawableState();
        int n10 = colorStateList.getColorForState(object, 0);
        object = this.imageMode;
        if (object == null) {
            object = PorterDuff.Mode.SRC_IN;
        }
        drawable2 = drawable2.mutate();
        colorStateList = AppCompatDrawableManager.getPorterDuffColorFilter(n10, (PorterDuff.Mode)object);
        drawable2.setColorFilter((ColorFilter)colorStateList);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static int resolveAdjustedSize(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        int n13 = -1 << -1;
        if (n12 == n13) return Math.min(n10, n11);
        if (n12 == 0) return n10;
        n10 = 0x40000000;
        if (n12 == n10) {
            return n11;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    private FloatingActionButtonImpl$InternalVisibilityChangedListener wrapOnVisibilityChangedListener(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        if (floatingActionButton$OnVisibilityChangedListener == null) {
            return null;
        }
        FloatingActionButton$1 floatingActionButton$1 = new FloatingActionButton$1(this, floatingActionButton$OnVisibilityChangedListener);
        return floatingActionButton$1;
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().addOnHideAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().addOnShowAnimationListener(animatorListener);
    }

    public void clearCustomSize() {
        this.setCustomSize(0);
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        FloatingActionButtonImpl floatingActionButtonImpl = this.getImpl();
        int[] nArray = this.getDrawableState();
        floatingActionButtonImpl.onDrawableStateChanged(nArray);
    }

    public ColorStateList getBackgroundTintList() {
        return this.backgroundTint;
    }

    public PorterDuff.Mode getBackgroundTintMode() {
        return this.backgroundTintMode;
    }

    public float getCompatElevation() {
        return this.getImpl().getElevation();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return this.getImpl().getHoveredFocusedTranslationZ();
    }

    public float getCompatPressedTranslationZ() {
        return this.getImpl().getPressedTranslationZ();
    }

    public Drawable getContentBackground() {
        return this.getImpl().getContentBackground();
    }

    public boolean getContentRect(Rect rect) {
        int n10 = ViewCompat.isLaidOut((View)this);
        if (n10 != 0) {
            n10 = this.getWidth();
            int n11 = this.getHeight();
            rect.set(0, 0, n10, n11);
            this.offsetRectWithShadow(rect);
            return true;
        }
        return false;
    }

    public int getCustomSize() {
        return this.customSize;
    }

    public int getExpandedComponentIdHint() {
        return this.expandableWidgetHelper.getExpandedComponentIdHint();
    }

    public MotionSpec getHideMotionSpec() {
        return this.getImpl().getHideMotionSpec();
    }

    public void getMeasuredContentRect(Rect rect) {
        int n10 = this.getMeasuredWidth();
        int n11 = this.getMeasuredHeight();
        rect.set(0, 0, n10, n11);
        this.offsetRectWithShadow(rect);
    }

    public int getRippleColor() {
        int n10;
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != null) {
            n10 = colorStateList.getDefaultColor();
        } else {
            n10 = 0;
            colorStateList = null;
        }
        return n10;
    }

    public ColorStateList getRippleColorStateList() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.getImpl().getShowMotionSpec();
    }

    public int getSize() {
        return this.size;
    }

    public int getSizeDimension() {
        int n10 = this.size;
        return this.getSizeDimension(n10);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return this.getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.imageTint;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.imageMode;
    }

    public boolean getUseCompatPadding() {
        return this.compatPadding;
    }

    public void hide() {
        this.hide(null);
    }

    public void hide(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        this.hide(floatingActionButton$OnVisibilityChangedListener, true);
    }

    public void hide(FloatingActionButton$OnVisibilityChangedListener object, boolean bl2) {
        FloatingActionButtonImpl floatingActionButtonImpl = this.getImpl();
        object = this.wrapOnVisibilityChangedListener((FloatingActionButton$OnVisibilityChangedListener)object);
        floatingActionButtonImpl.hide((FloatingActionButtonImpl$InternalVisibilityChangedListener)object, bl2);
    }

    public boolean isExpanded() {
        return this.expandableWidgetHelper.isExpanded();
    }

    public boolean isOrWillBeHidden() {
        return this.getImpl().isOrWillBeHidden();
    }

    public boolean isOrWillBeShown() {
        return this.getImpl().isOrWillBeShown();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.getImpl().jumpDrawableToCurrentState();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.getImpl().onAttachedToWindow();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getImpl().onDetachedFromWindow();
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.getSizeDimension();
        int n13 = this.maxImageSize;
        this.imagePadding = n13 = (n12 - n13) / 2;
        this.getImpl().updatePadding();
        n10 = FloatingActionButton.resolveAdjustedSize(n12, n10);
        n11 = FloatingActionButton.resolveAdjustedSize(n12, n11);
        n10 = Math.min(n10, n11);
        Rect rect = this.shadowPadding;
        n12 = rect.left + n10;
        n13 = rect.right;
        n12 += n13;
        n13 = rect.top;
        n10 += n13;
        n11 = rect.bottom;
        this.setMeasuredDimension(n12, n10 += n11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof ExtendableSavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (ExtendableSavedState)parcelable;
        Object object = parcelable.getSuperState();
        super.onRestoreInstanceState((Parcelable)object);
        object = this.expandableWidgetHelper;
        parcelable = (Bundle)parcelable.extendableStates.get(EXPANDABLE_WIDGET_HELPER_KEY);
        ((ExpandableWidgetHelper)object).onRestoreInstanceState((Bundle)parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Object object = super.onSaveInstanceState();
        ExtendableSavedState extendableSavedState = new ExtendableSavedState((Parcelable)object);
        object = extendableSavedState.extendableStates;
        Bundle bundle = this.expandableWidgetHelper.onSaveInstanceState();
        ((SimpleArrayMap)object).put(EXPANDABLE_WIDGET_HELPER_KEY, bundle);
        return extendableSavedState;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f10;
        int n10;
        float f11;
        int n11;
        Rect rect;
        int n12 = motionEvent.getAction();
        if (n12 == 0 && (n12 = (int)(this.getContentRect(rect = this.touchArea) ? 1 : 0)) != 0 && (n12 = (int)((rect = this.touchArea).contains(n11 = (int)(f11 = motionEvent.getX()), n10 = (int)(f10 = motionEvent.getY())) ? 1 : 0)) == 0) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().removeOnHideAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.getImpl().removeOnShowAnimationListener(animatorListener);
    }

    public void setBackgroundColor(int n10) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundDrawable(Drawable drawable2) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundResource(int n10) {
        Log.i((String)LOG_TAG, (String)"Setting a custom background is not supported.");
    }

    public void setBackgroundTintList(ColorStateList colorStateList) {
        Object object = this.backgroundTint;
        if (object != colorStateList) {
            this.backgroundTint = colorStateList;
            object = this.getImpl();
            ((FloatingActionButtonImpl)object).setBackgroundTintList(colorStateList);
        }
    }

    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        Object object = this.backgroundTintMode;
        if (object != mode) {
            this.backgroundTintMode = mode;
            object = this.getImpl();
            ((FloatingActionButtonImpl)object).setBackgroundTintMode(mode);
        }
    }

    public void setCompatElevation(float f10) {
        this.getImpl().setElevation(f10);
    }

    public void setCompatElevationResource(int n10) {
        float f10 = this.getResources().getDimension(n10);
        this.setCompatElevation(f10);
    }

    public void setCompatHoveredFocusedTranslationZ(float f10) {
        this.getImpl().setHoveredFocusedTranslationZ(f10);
    }

    public void setCompatHoveredFocusedTranslationZResource(int n10) {
        float f10 = this.getResources().getDimension(n10);
        this.setCompatHoveredFocusedTranslationZ(f10);
    }

    public void setCompatPressedTranslationZ(float f10) {
        this.getImpl().setPressedTranslationZ(f10);
    }

    public void setCompatPressedTranslationZResource(int n10) {
        float f10 = this.getResources().getDimension(n10);
        this.setCompatPressedTranslationZ(f10);
    }

    public void setCustomSize(int n10) {
        if (n10 >= 0) {
            this.customSize = n10;
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Custom size must be non-negative");
        throw illegalArgumentException;
    }

    public boolean setExpanded(boolean bl2) {
        return this.expandableWidgetHelper.setExpanded(bl2);
    }

    public void setExpandedComponentIdHint(int n10) {
        this.expandableWidgetHelper.setExpandedComponentIdHint(n10);
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.getImpl().setHideMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int n10) {
        MotionSpec motionSpec = MotionSpec.createFromResource(this.getContext(), n10);
        this.setHideMotionSpec(motionSpec);
    }

    public void setImageDrawable(Drawable drawable2) {
        super.setImageDrawable(drawable2);
        this.getImpl().updateImageMatrixScale();
    }

    public void setImageResource(int n10) {
        this.imageHelper.setImageResource(n10);
    }

    public void setRippleColor(int n10) {
        ColorStateList colorStateList = ColorStateList.valueOf((int)n10);
        this.setRippleColor(colorStateList);
    }

    public void setRippleColor(ColorStateList object) {
        ColorStateList colorStateList = this.rippleColor;
        if (colorStateList != object) {
            this.rippleColor = object;
            object = this.getImpl();
            colorStateList = this.rippleColor;
            ((FloatingActionButtonImpl)object).setRippleColor(colorStateList);
        }
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.getImpl().setShowMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int n10) {
        MotionSpec motionSpec = MotionSpec.createFromResource(this.getContext(), n10);
        this.setShowMotionSpec(motionSpec);
    }

    public void setSize(int n10) {
        this.customSize = 0;
        int n11 = this.size;
        if (n10 != n11) {
            this.size = n10;
            this.requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        this.setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        this.setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.imageTint;
        if (colorStateList2 != colorStateList) {
            this.imageTint = colorStateList;
            this.onApplySupportImageTint();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        PorterDuff.Mode mode2 = this.imageMode;
        if (mode2 != mode) {
            this.imageMode = mode;
            this.onApplySupportImageTint();
        }
    }

    public void setUseCompatPadding(boolean bl2) {
        boolean bl3 = this.compatPadding;
        if (bl3 != bl2) {
            this.compatPadding = bl2;
            FloatingActionButtonImpl floatingActionButtonImpl = this.getImpl();
            floatingActionButtonImpl.onCompatShadowChanged();
        }
    }

    public void show() {
        this.show(null);
    }

    public void show(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        this.show(floatingActionButton$OnVisibilityChangedListener, true);
    }

    public void show(FloatingActionButton$OnVisibilityChangedListener object, boolean bl2) {
        FloatingActionButtonImpl floatingActionButtonImpl = this.getImpl();
        object = this.wrapOnVisibilityChangedListener((FloatingActionButton$OnVisibilityChangedListener)object);
        floatingActionButtonImpl.show((FloatingActionButtonImpl$InternalVisibilityChangedListener)object, bl2);
    }
}

