/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 *  android.graphics.drawable.DrawableContainer
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 *  android.text.method.PasswordTransformationMethod
 *  android.text.method.TransformationMethod
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStructure
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package com.google.android.material.textfield;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.CutoutDrawable;
import com.google.android.material.textfield.IndicatorViewController;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout$1;
import com.google.android.material.textfield.TextInputLayout$2;
import com.google.android.material.textfield.TextInputLayout$3;
import com.google.android.material.textfield.TextInputLayout$AccessibilityDelegate;
import com.google.android.material.textfield.TextInputLayout$SavedState;

public class TextInputLayout
extends LinearLayout {
    public static final int BOX_BACKGROUND_FILLED = 1;
    public static final int BOX_BACKGROUND_NONE = 0;
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    private static final int INVALID_MAX_LENGTH = 255;
    private static final int LABEL_SCALE_ANIMATION_DURATION = 167;
    private static final String LOG_TAG = "TextInputLayout";
    private ValueAnimator animator;
    private GradientDrawable boxBackground;
    private int boxBackgroundColor;
    private int boxBackgroundMode;
    private final int boxBottomOffsetPx;
    private final int boxCollapsedPaddingTopPx;
    private float boxCornerRadiusBottomEnd;
    private float boxCornerRadiusBottomStart;
    private float boxCornerRadiusTopEnd;
    private float boxCornerRadiusTopStart;
    private final int boxLabelCutoutPaddingPx;
    private int boxStrokeColor;
    private final int boxStrokeWidthDefaultPx;
    private final int boxStrokeWidthFocusedPx;
    private int boxStrokeWidthPx;
    public final CollapsingTextHelper collapsingTextHelper;
    public boolean counterEnabled;
    private int counterMaxLength;
    private final int counterOverflowTextAppearance;
    private boolean counterOverflowed;
    private final int counterTextAppearance;
    private TextView counterView;
    private ColorStateList defaultHintTextColor;
    private final int defaultStrokeColor;
    private final int disabledColor;
    public EditText editText;
    private Drawable editTextOriginalDrawable;
    private int focusedStrokeColor;
    private ColorStateList focusedTextColor;
    private boolean hasPasswordToggleTintList;
    private boolean hasPasswordToggleTintMode;
    private boolean hasReconstructedEditTextBackground;
    private CharSequence hint;
    private boolean hintAnimationEnabled;
    private boolean hintEnabled;
    private boolean hintExpanded;
    private final int hoveredStrokeColor;
    private boolean inDrawableStateChanged;
    private final IndicatorViewController indicatorViewController;
    private final FrameLayout inputFrame;
    private boolean isProvidingHint;
    private Drawable originalEditTextEndDrawable;
    private CharSequence originalHint;
    private CharSequence passwordToggleContentDesc;
    private Drawable passwordToggleDrawable;
    private Drawable passwordToggleDummyDrawable;
    private boolean passwordToggleEnabled;
    private ColorStateList passwordToggleTintList;
    private PorterDuff.Mode passwordToggleTintMode;
    private CheckableImageButton passwordToggleView;
    private boolean passwordToggledVisible;
    private boolean restoringSavedState;
    private final Rect tmpRect;
    private final RectF tmpRectF;
    private Typeface typeface;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        int n10 = R$attr.textInputStyle;
        this(context, attributeSet, n10);
    }

    public TextInputLayout(Context context, AttributeSet object, int n10) {
        super(context, (AttributeSet)object, n10);
        int n11;
        float f10;
        FrameLayout frameLayout;
        Object object2 = new IndicatorViewController(this);
        this.indicatorViewController = object2;
        super();
        this.tmpRect = object2;
        super();
        this.tmpRectF = object2;
        this.collapsingTextHelper = object2 = new CollapsingTextHelper((View)this);
        boolean bl2 = true;
        this.setOrientation((int)(bl2 ? 1 : 0));
        int n12 = 0;
        Object object3 = null;
        this.setWillNotDraw(false);
        this.setAddStatesFromChildren(bl2);
        this.inputFrame = frameLayout = new FrameLayout(context);
        frameLayout.setAddStatesFromChildren(bl2);
        this.addView((View)frameLayout);
        frameLayout = AnimationUtils.LINEAR_INTERPOLATOR;
        ((CollapsingTextHelper)object2).setTextSizeInterpolator((TimeInterpolator)frameLayout);
        ((CollapsingTextHelper)object2).setPositionInterpolator((TimeInterpolator)frameLayout);
        ((CollapsingTextHelper)object2).setCollapsedTextGravity(0x800033);
        int[] nArray = R$styleable.TextInputLayout;
        int n13 = R$style.Widget_Design_TextInputLayout;
        int[] nArray2 = new int[]{};
        Object object4 = object;
        int n14 = n10;
        object = ThemeEnforcement.obtainTintedStyledAttributes(context, (AttributeSet)object, nArray, n10, n13, nArray2);
        n10 = R$styleable.TextInputLayout_hintEnabled;
        n10 = (int)(((TintTypedArray)object).getBoolean(n10, bl2) ? 1 : 0);
        this.hintEnabled = n10;
        n10 = R$styleable.TextInputLayout_android_hint;
        CharSequence charSequence = ((TintTypedArray)object).getText(n10);
        this.setHint(charSequence);
        n10 = R$styleable.TextInputLayout_hintAnimationEnabled;
        n10 = (int)(((TintTypedArray)object).getBoolean(n10, bl2) ? 1 : 0);
        this.hintAnimationEnabled = n10;
        charSequence = context.getResources();
        int n15 = R$dimen.mtrl_textinput_box_bottom_offset;
        this.boxBottomOffsetPx = n10 = charSequence.getDimensionPixelOffset(n15);
        charSequence = context.getResources();
        n15 = R$dimen.mtrl_textinput_box_label_cutout_padding;
        this.boxLabelCutoutPaddingPx = n10 = charSequence.getDimensionPixelOffset(n15);
        n10 = R$styleable.TextInputLayout_boxCollapsedPaddingTop;
        this.boxCollapsedPaddingTopPx = n10 = ((TintTypedArray)object).getDimensionPixelOffset(n10, 0);
        n10 = R$styleable.TextInputLayout_boxCornerRadiusTopStart;
        this.boxCornerRadiusTopStart = f10 = ((TintTypedArray)object).getDimension(n10, 0.0f);
        n10 = R$styleable.TextInputLayout_boxCornerRadiusTopEnd;
        this.boxCornerRadiusTopEnd = f10 = ((TintTypedArray)object).getDimension(n10, 0.0f);
        n10 = R$styleable.TextInputLayout_boxCornerRadiusBottomEnd;
        this.boxCornerRadiusBottomEnd = f10 = ((TintTypedArray)object).getDimension(n10, 0.0f);
        n10 = R$styleable.TextInputLayout_boxCornerRadiusBottomStart;
        this.boxCornerRadiusBottomStart = f10 = ((TintTypedArray)object).getDimension(n10, 0.0f);
        n10 = R$styleable.TextInputLayout_boxBackgroundColor;
        this.boxBackgroundColor = n10 = ((TintTypedArray)object).getColor(n10, 0);
        n10 = R$styleable.TextInputLayout_boxStrokeColor;
        this.focusedStrokeColor = n10 = ((TintTypedArray)object).getColor(n10, 0);
        charSequence = context.getResources();
        n15 = R$dimen.mtrl_textinput_box_stroke_width_default;
        this.boxStrokeWidthDefaultPx = n10 = charSequence.getDimensionPixelSize(n15);
        object2 = context.getResources();
        int n16 = R$dimen.mtrl_textinput_box_stroke_width_focused;
        n15 = object2.getDimensionPixelSize(n16);
        this.boxStrokeWidthFocusedPx = n15;
        this.boxStrokeWidthPx = n10;
        n10 = R$styleable.TextInputLayout_boxBackgroundMode;
        n10 = ((TintTypedArray)object).getInt(n10, 0);
        this.setBoxBackgroundMode(n10);
        n10 = R$styleable.TextInputLayout_android_textColorHint;
        n15 = (int)(((TintTypedArray)object).hasValue(n10) ? 1 : 0);
        if (n15) {
            charSequence = ((TintTypedArray)object).getColorStateList(n10);
            this.focusedTextColor = charSequence;
            this.defaultHintTextColor = charSequence;
        }
        n10 = R$color.mtrl_textinput_default_box_stroke_color;
        this.defaultStrokeColor = n10 = ContextCompat.getColor(context, n10);
        n10 = R$color.mtrl_textinput_disabled_color;
        this.disabledColor = n10 = ContextCompat.getColor(context, n10);
        n10 = R$color.mtrl_textinput_hovered_box_stroke_color;
        this.hoveredStrokeColor = n11 = ContextCompat.getColor(context, n10);
        n11 = R$styleable.TextInputLayout_hintTextAppearance;
        n10 = -1;
        f10 = 0.0f / 0.0f;
        n15 = ((TintTypedArray)object).getResourceId(n11, n10);
        if (n15 != n10) {
            n11 = ((TintTypedArray)object).getResourceId(n11, 0);
            this.setHintTextAppearance(n11);
        }
        n11 = R$styleable.TextInputLayout_errorTextAppearance;
        n11 = ((TintTypedArray)object).getResourceId(n11, 0);
        n15 = R$styleable.TextInputLayout_errorEnabled;
        n15 = (int)(((TintTypedArray)object).getBoolean(n15, false) ? 1 : 0);
        n16 = R$styleable.TextInputLayout_helperTextTextAppearance;
        n16 = ((TintTypedArray)object).getResourceId(n16, 0);
        int bl3 = R$styleable.TextInputLayout_helperTextEnabled;
        boolean bl4 = ((TintTypedArray)object).getBoolean(bl3, false);
        int n17 = R$styleable.TextInputLayout_helperText;
        object4 = ((TintTypedArray)object).getText(n17);
        int n18 = R$styleable.TextInputLayout_counterEnabled;
        boolean bl5 = ((TintTypedArray)object).getBoolean(n18, false);
        n14 = R$styleable.TextInputLayout_counterMaxLength;
        n14 = ((TintTypedArray)object).getInt(n14, n10);
        this.setCounterMaxLength(n14);
        n14 = R$styleable.TextInputLayout_counterTextAppearance;
        this.counterTextAppearance = n14 = ((TintTypedArray)object).getResourceId(n14, 0);
        n14 = R$styleable.TextInputLayout_counterOverflowTextAppearance;
        this.counterOverflowTextAppearance = n14 = ((TintTypedArray)object).getResourceId(n14, 0);
        n14 = R$styleable.TextInputLayout_passwordToggleEnabled;
        this.passwordToggleEnabled = n12 = ((TintTypedArray)object).getBoolean(n14, false);
        n12 = R$styleable.TextInputLayout_passwordToggleDrawable;
        this.passwordToggleDrawable = object3 = ((TintTypedArray)object).getDrawable(n12);
        n12 = R$styleable.TextInputLayout_passwordToggleContentDescription;
        object3 = ((TintTypedArray)object).getText(n12);
        this.passwordToggleContentDesc = object3;
        n12 = R$styleable.TextInputLayout_passwordToggleTint;
        n14 = (int)(((TintTypedArray)object).hasValue(n12) ? 1 : 0);
        if (n14 != 0) {
            this.hasPasswordToggleTintList = bl2;
            object3 = ((TintTypedArray)object).getColorStateList(n12);
            this.passwordToggleTintList = object3;
        }
        if ((n14 = (int)(((TintTypedArray)object).hasValue(n12 = R$styleable.TextInputLayout_passwordToggleTintMode) ? 1 : 0)) != 0) {
            this.hasPasswordToggleTintMode = bl2;
            n10 = ((TintTypedArray)object).getInt(n12, n10);
            bl2 = false;
            charSequence = ViewUtils.parseTintMode(n10, null);
            this.passwordToggleTintMode = charSequence;
        }
        ((TintTypedArray)object).recycle();
        this.setHelperTextEnabled(bl4);
        this.setHelperText((CharSequence)object4);
        this.setHelperTextTextAppearance(n16);
        this.setErrorEnabled(n15 != 0);
        this.setErrorTextAppearance(n11);
        this.setCounterEnabled(bl5);
        this.applyPasswordToggleTint();
        ViewCompat.setImportantForAccessibility((View)this, 2);
    }

    public static /* synthetic */ boolean access$000(TextInputLayout textInputLayout) {
        return textInputLayout.restoringSavedState;
    }

    private void applyBoxAttributes() {
        int n10;
        Object object;
        int n11;
        int n12;
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable == null) {
            return;
        }
        this.setBoxAttributes();
        gradientDrawable = this.editText;
        if (gradientDrawable != null && (n12 = this.boxBackgroundMode) == (n11 = 2)) {
            if ((gradientDrawable = gradientDrawable.getBackground()) != null) {
                gradientDrawable = this.editText.getBackground();
                this.editTextOriginalDrawable = gradientDrawable;
            }
            gradientDrawable = this.editText;
            n12 = 0;
            object = null;
            ViewCompat.setBackground((View)gradientDrawable, null);
        }
        if ((gradientDrawable = this.editText) != null && (n12 = this.boxBackgroundMode) == (n11 = 1) && (object = this.editTextOriginalDrawable) != null) {
            ViewCompat.setBackground((View)gradientDrawable, object);
        }
        if ((n10 = this.boxStrokeWidthPx) > (n12 = -1) && (n12 = this.boxStrokeColor) != 0) {
            GradientDrawable gradientDrawable2 = this.boxBackground;
            gradientDrawable2.setStroke(n10, n12);
        }
        gradientDrawable = this.boxBackground;
        object = this.getCornerRadiiAsArray();
        gradientDrawable.setCornerRadii((float[])object);
        gradientDrawable = this.boxBackground;
        n12 = this.boxBackgroundColor;
        gradientDrawable.setColor(n12);
        this.invalidate();
    }

    private void applyCutoutPadding(RectF rectF) {
        float f10 = rectF.left;
        int n10 = this.boxLabelCutoutPaddingPx;
        float f11 = n10;
        rectF.left = f10 -= f11;
        f10 = rectF.top;
        f11 = n10;
        rectF.top = f10 -= f11;
        f10 = rectF.right;
        f11 = n10;
        rectF.right = f10 += f11;
        f10 = rectF.bottom;
        float f12 = n10;
        rectF.bottom = f10 += f12;
    }

    private void applyPasswordToggleTint() {
        boolean bl2;
        Object object = this.passwordToggleDrawable;
        if (object != null && ((bl2 = this.hasPasswordToggleTintList) || (bl2 = this.hasPasswordToggleTintMode))) {
            boolean bl3;
            ColorStateList colorStateList;
            object = DrawableCompat.wrap((Drawable)object).mutate();
            this.passwordToggleDrawable = object;
            bl2 = this.hasPasswordToggleTintList;
            if (bl2) {
                colorStateList = this.passwordToggleTintList;
                DrawableCompat.setTintList((Drawable)object, colorStateList);
            }
            if (bl3 = this.hasPasswordToggleTintMode) {
                object = this.passwordToggleDrawable;
                colorStateList = this.passwordToggleTintMode;
                DrawableCompat.setTintMode((Drawable)object, (PorterDuff.Mode)colorStateList);
            }
            if ((object = this.passwordToggleView) != null && (object = object.getDrawable()) != (colorStateList = this.passwordToggleDrawable)) {
                object = this.passwordToggleView;
                ((AppCompatImageButton)object).setImageDrawable((Drawable)colorStateList);
            }
        }
    }

    private void assignBoxBackgroundByMode() {
        int n10 = this.boxBackgroundMode;
        if (n10 == 0) {
            n10 = 0;
            Object var2_2 = null;
            this.boxBackground = null;
        } else {
            GradientDrawable gradientDrawable;
            int n11 = 2;
            if (n10 == n11 && (n10 = (int)(this.hintEnabled ? 1 : 0)) != 0 && (n10 = (gradientDrawable = this.boxBackground) instanceof CutoutDrawable) == 0) {
                this.boxBackground = gradientDrawable = new CutoutDrawable();
            } else {
                gradientDrawable = this.boxBackground;
                n10 = gradientDrawable instanceof GradientDrawable;
                if (n10 == 0) {
                    this.boxBackground = gradientDrawable = new GradientDrawable();
                }
            }
        }
    }

    private int calculateBoxBackgroundTop() {
        EditText editText = this.editText;
        int n10 = 0;
        if (editText == null) {
            return 0;
        }
        int n11 = this.boxBackgroundMode;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 2;
            if (n11 != n12) {
                return 0;
            }
            int n13 = editText.getTop();
            n10 = this.calculateLabelMarginTop();
            return n13 + n10;
        }
        return editText.getTop();
    }

    private int calculateCollapsedTextTopBounds() {
        int n10 = this.boxBackgroundMode;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return this.getPaddingTop();
            }
            n10 = this.getBoxBackground().getBounds().top;
            n11 = this.calculateLabelMarginTop();
            return n10 - n11;
        }
        n10 = this.getBoxBackground().getBounds().top;
        n11 = this.boxCollapsedPaddingTopPx;
        return n10 + n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private int calculateLabelMarginTop() {
        float f10;
        int n10;
        int n11 = this.hintEnabled;
        float f11 = 0.0f;
        if (n11 == 0) {
            return 0;
        }
        n11 = this.boxBackgroundMode;
        if (n11 != 0 && n11 != (n10 = 1)) {
            n10 = 2;
            if (n11 != n10) {
                return 0;
            }
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            f10 = collapsingTextHelper.getCollapsedTextHeight();
            f11 = 2.0f;
            f10 /= f11;
            return (int)f10;
        }
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        f10 = collapsingTextHelper.getCollapsedTextHeight();
        return (int)f10;
    }

    private void closeCutout() {
        boolean bl2 = this.cutoutEnabled();
        if (bl2) {
            CutoutDrawable cutoutDrawable = (CutoutDrawable)this.boxBackground;
            cutoutDrawable.removeCutout();
        }
    }

    private void collapseHint(boolean bl2) {
        CollapsingTextHelper collapsingTextHelper;
        int n10;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && (n10 = (int)(valueAnimator.isRunning() ? 1 : 0)) != 0) {
            valueAnimator = this.animator;
            valueAnimator.cancel();
        }
        n10 = 1065353216;
        float f10 = 1.0f;
        if (bl2 && (bl2 = this.hintAnimationEnabled)) {
            this.animateToExpansionFraction(f10);
        } else {
            collapsingTextHelper = this.collapsingTextHelper;
            collapsingTextHelper.setExpansionFraction(f10);
        }
        collapsingTextHelper = null;
        this.hintExpanded = false;
        bl2 = this.cutoutEnabled();
        if (bl2) {
            this.openCutout();
        }
    }

    private boolean cutoutEnabled() {
        CharSequence charSequence;
        boolean bl2 = this.hintEnabled;
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(charSequence = this.hint))) && (bl2 = (charSequence = this.boxBackground) instanceof CutoutDrawable)) {
            bl2 = true;
        } else {
            bl2 = false;
            charSequence = null;
        }
        return bl2;
    }

    private void ensureBackgroundDrawableStateWorkaround() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 != n11 && n10 != (n11 = 22)) {
            return;
        }
        Drawable drawable2 = this.editText.getBackground();
        if (drawable2 == null) {
            return;
        }
        n11 = (int)(this.hasReconstructedEditTextBackground ? 1 : 0);
        if (n11 == 0) {
            Drawable drawable3 = drawable2.getConstantState().newDrawable();
            boolean bl2 = drawable2 instanceof DrawableContainer;
            if (bl2) {
                drawable2 = (DrawableContainer)drawable2;
                Drawable.ConstantState constantState = drawable3.getConstantState();
                n10 = (int)(com.google.android.material.internal.DrawableUtils.setContainerConstantState((DrawableContainer)drawable2, constantState) ? 1 : 0);
                this.hasReconstructedEditTextBackground = n10;
            }
            if ((n10 = (int)(this.hasReconstructedEditTextBackground ? 1 : 0)) == 0) {
                drawable2 = this.editText;
                ViewCompat.setBackground((View)drawable2, drawable3);
                n10 = 1;
                this.hasReconstructedEditTextBackground = n10;
                this.onApplyBoxBackgroundMode();
            }
        }
    }

    private void expandHint(boolean bl2) {
        Object object;
        boolean bl3;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null && (bl3 = valueAnimator.isRunning())) {
            valueAnimator = this.animator;
            valueAnimator.cancel();
        }
        bl3 = false;
        valueAnimator = null;
        if (bl2 && (bl2 = this.hintAnimationEnabled)) {
            this.animateToExpansionFraction(0.0f);
        } else {
            object = this.collapsingTextHelper;
            ((CollapsingTextHelper)object).setExpansionFraction(0.0f);
        }
        bl2 = this.cutoutEnabled();
        if (bl2 && (bl2 = ((CutoutDrawable)((Object)(object = (CutoutDrawable)this.boxBackground))).hasCutout())) {
            this.closeCutout();
        }
        this.hintExpanded = true;
    }

    private Drawable getBoxBackground() {
        int n10 = this.boxBackgroundMode;
        int n11 = 1;
        if (n10 != n11 && n10 != (n11 = 2)) {
            IllegalStateException illegalStateException = new IllegalStateException();
            throw illegalStateException;
        }
        return this.boxBackground;
    }

    private float[] getCornerRadiiAsArray() {
        boolean bl2 = ViewUtils.isLayoutRtl((View)this);
        int n10 = 7;
        int n11 = 6;
        int n12 = 5;
        float f10 = 7.0E-45f;
        int n13 = 4;
        int n14 = 3;
        float f11 = 4.2E-45f;
        int n15 = 2;
        int n16 = 1;
        float f12 = Float.MIN_VALUE;
        int n17 = 8;
        float f13 = 1.1E-44f;
        if (!bl2) {
            float[] fArray = new float[n17];
            fArray[0] = f13 = this.boxCornerRadiusTopStart;
            fArray[n16] = f13;
            fArray[n15] = f12 = this.boxCornerRadiusTopEnd;
            fArray[n14] = f12;
            fArray[n13] = f11 = this.boxCornerRadiusBottomEnd;
            fArray[n12] = f11;
            fArray[n11] = f10 = this.boxCornerRadiusBottomStart;
            fArray[n10] = f10;
            return fArray;
        }
        float[] fArray = new float[n17];
        fArray[0] = f13 = this.boxCornerRadiusTopEnd;
        fArray[n16] = f13;
        fArray[n15] = f12 = this.boxCornerRadiusTopStart;
        fArray[n14] = f12;
        fArray[n13] = f11 = this.boxCornerRadiusBottomStart;
        fArray[n12] = f11;
        fArray[n11] = f10 = this.boxCornerRadiusBottomEnd;
        fArray[n10] = f10;
        return fArray;
    }

    private boolean hasPasswordTransformation() {
        boolean bl2;
        EditText editText = this.editText;
        if (editText != null && (bl2 = (editText = editText.getTransformationMethod()) instanceof PasswordTransformationMethod)) {
            bl2 = true;
        } else {
            bl2 = false;
            editText = null;
        }
        return bl2;
    }

    private void onApplyBoxBackgroundMode() {
        this.assignBoxBackgroundByMode();
        int n10 = this.boxBackgroundMode;
        if (n10 != 0) {
            this.updateInputLayoutMargins();
        }
        this.updateTextInputBoxBounds();
    }

    private void openCutout() {
        boolean bl2 = this.cutoutEnabled();
        if (!bl2) {
            return;
        }
        RectF rectF = this.tmpRectF;
        this.collapsingTextHelper.getCollapsedTextActualBounds(rectF);
        this.applyCutoutPadding(rectF);
        ((CutoutDrawable)this.boxBackground).setCutout(rectF);
    }

    private static void recursiveSetEnabled(ViewGroup viewGroup, boolean bl2) {
        int n10 = viewGroup.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = viewGroup.getChildAt(i10);
            view.setEnabled(bl2);
            boolean bl3 = view instanceof ViewGroup;
            if (!bl3) continue;
            view = (ViewGroup)view;
            TextInputLayout.recursiveSetEnabled((ViewGroup)view, bl2);
        }
    }

    private void setBoxAttributes() {
        int n10 = this.boxBackgroundMode;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 == n11 && (n10 = this.focusedStrokeColor) == 0) {
                ColorStateList colorStateList = this.focusedTextColor;
                int[] nArray = this.getDrawableState();
                ColorStateList colorStateList2 = this.focusedTextColor;
                int n12 = colorStateList2.getDefaultColor();
                this.focusedStrokeColor = n10 = colorStateList.getColorForState(nArray, n12);
            }
        } else {
            n10 = 0;
            Object var3_4 = null;
            this.boxStrokeWidthPx = 0;
        }
    }

    private void setEditText(EditText object) {
        Object object2 = this.editText;
        if (object2 == null) {
            String string2;
            boolean bl2 = object instanceof TextInputEditText;
            if (!bl2) {
                object2 = LOG_TAG;
                string2 = "EditText added is not a TextInputEditText. Please switch to using that class instead.";
                Log.i((String)object2, (String)string2);
            }
            this.editText = object;
            this.onApplyBoxBackgroundMode();
            object = new TextInputLayout$AccessibilityDelegate(this);
            this.setTextInputAccessibilityDelegate((TextInputLayout$AccessibilityDelegate)object);
            int n10 = this.hasPasswordTransformation();
            if (n10 == 0) {
                object = this.collapsingTextHelper;
                object2 = this.editText.getTypeface();
                ((CollapsingTextHelper)object).setTypefaces((Typeface)object2);
            }
            object = this.collapsingTextHelper;
            float f10 = this.editText.getTextSize();
            ((CollapsingTextHelper)object).setExpandedTextSize(f10);
            n10 = this.editText.getGravity();
            object2 = this.collapsingTextHelper;
            int n11 = n10 & 0xFFFFFF8F | 0x30;
            ((CollapsingTextHelper)object2).setCollapsedTextGravity(n11);
            this.collapsingTextHelper.setExpandedTextGravity(n10);
            object = this.editText;
            object2 = new TextInputLayout$1(this);
            object.addTextChangedListener((TextWatcher)object2);
            object = this.defaultHintTextColor;
            if (object == null) {
                object = this.editText.getHintTextColors();
                this.defaultHintTextColor = object;
            }
            n10 = (int)(this.hintEnabled ? 1 : 0);
            bl2 = true;
            f10 = Float.MIN_VALUE;
            if (n10 != 0) {
                object = this.hint;
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 != 0) {
                    this.originalHint = object = this.editText.getHint();
                    this.setHint((CharSequence)object);
                    object = this.editText;
                    n11 = 0;
                    string2 = null;
                    object.setHint(null);
                }
                this.isProvidingHint = bl2;
            }
            if ((object = this.counterView) != null) {
                object = this.editText.getText();
                n10 = object.length();
                this.updateCounter(n10);
            }
            this.indicatorViewController.adjustIndicatorPadding();
            this.updatePasswordToggleView();
            this.updateLabelState(false, bl2);
            return;
        }
        object = new IllegalArgumentException("We already have an EditText, can only have one");
        throw object;
    }

    private void setHintInternal(CharSequence charSequence) {
        Object object = this.hint;
        boolean bl2 = TextUtils.equals((CharSequence)charSequence, (CharSequence)object);
        if (!bl2) {
            this.hint = charSequence;
            object = this.collapsingTextHelper;
            ((CollapsingTextHelper)object).setText(charSequence);
            boolean bl3 = this.hintExpanded;
            if (!bl3) {
                this.openCutout();
            }
        }
    }

    private boolean shouldShowPasswordIcon() {
        boolean bl2 = this.passwordToggleEnabled;
        bl2 = bl2 && ((bl2 = this.hasPasswordTransformation()) || (bl2 = this.passwordToggledVisible));
        return bl2;
    }

    private void updateEditTextBackgroundBounds() {
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        if ((editText = editText.getBackground()) == null) {
            return;
        }
        int n10 = DrawableUtils.canSafelyMutateDrawable((Drawable)editText);
        if (n10 != 0) {
            editText = editText.mutate();
        }
        Rect rect = new Rect();
        EditText editText2 = this.editText;
        DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)editText2, rect);
        rect = editText.getBounds();
        int n11 = rect.left;
        int n12 = rect.right;
        if (n11 != n12) {
            editText2 = new Rect();
            editText.getPadding((Rect)editText2);
            n12 = rect.left;
            int n13 = editText2.left;
            n12 -= n13;
            n13 = rect.right;
            n11 = editText2.right * 2;
            n13 += n11;
            n10 = rect.top;
            editText2 = this.editText;
            n11 = editText2.getBottom();
            editText.setBounds(n12, n10, n13, n11);
        }
    }

    private void updateInputLayoutMargins() {
        int n10;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)this.inputFrame.getLayoutParams();
        int n11 = this.calculateLabelMarginTop();
        if (n11 != (n10 = layoutParams.topMargin)) {
            layoutParams.topMargin = n11;
            layoutParams = this.inputFrame;
            layoutParams.requestLayout();
        }
    }

    private void updateLabelState(boolean bl2, boolean bl3) {
        int n10;
        boolean bl4;
        boolean bl5 = this.isEnabled();
        EditText editText = this.editText;
        boolean bl6 = true;
        boolean bl7 = false;
        IndicatorViewController indicatorViewController = null;
        if (editText != null && !(bl4 = TextUtils.isEmpty((CharSequence)(editText = editText.getText())))) {
            bl4 = bl6;
        } else {
            bl4 = false;
            editText = null;
        }
        Object object = this.editText;
        if (object == null || (n10 = object.hasFocus()) == 0) {
            bl6 = false;
        }
        indicatorViewController = this.indicatorViewController;
        bl7 = indicatorViewController.errorShouldBeShown();
        object = this.defaultHintTextColor;
        if (object != null) {
            this.collapsingTextHelper.setCollapsedTextColor((ColorStateList)object);
            object = this.collapsingTextHelper;
            ColorStateList colorStateList = this.defaultHintTextColor;
            ((CollapsingTextHelper)object).setExpandedTextColor(colorStateList);
        }
        if (!bl5) {
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            object = ColorStateList.valueOf((int)this.disabledColor);
            collapsingTextHelper.setCollapsedTextColor((ColorStateList)object);
            collapsingTextHelper = this.collapsingTextHelper;
            n10 = this.disabledColor;
            object = ColorStateList.valueOf((int)n10);
            collapsingTextHelper.setExpandedTextColor((ColorStateList)object);
        } else if (bl7) {
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            object = this.indicatorViewController.getErrorViewTextColors();
            collapsingTextHelper.setCollapsedTextColor((ColorStateList)object);
        } else {
            TextView textView;
            bl5 = this.counterOverflowed;
            if (bl5 && (textView = this.counterView) != null) {
                object = this.collapsingTextHelper;
                textView = textView.getTextColors();
                ((CollapsingTextHelper)object).setCollapsedTextColor((ColorStateList)textView);
            } else if (bl6 && (textView = this.focusedTextColor) != null) {
                object = this.collapsingTextHelper;
                ((CollapsingTextHelper)object).setCollapsedTextColor((ColorStateList)textView);
            }
        }
        if (!(bl4 || (bl5 = this.isEnabled()) && (bl6 || bl7))) {
            if (bl3 || !(bl3 = this.hintExpanded)) {
                this.expandHint(bl2);
            }
        } else if (bl3 || (bl3 = this.hintExpanded)) {
            this.collapseHint(bl2);
        }
    }

    private void updatePasswordToggleView() {
        Object object = this.editText;
        if (object == null) {
            return;
        }
        int n10 = this.shouldShowPasswordIcon();
        int n11 = 3;
        int n12 = 1;
        int n13 = 2;
        int n14 = 0;
        Object object2 = null;
        if (n10 != 0) {
            Object object3;
            Object object4;
            FrameLayout frameLayout;
            int n15;
            object = this.passwordToggleView;
            if (object == null) {
                object = LayoutInflater.from((Context)this.getContext());
                n15 = R$layout.design_text_input_password_icon;
                frameLayout = this.inputFrame;
                object = (CheckableImageButton)object.inflate(n15, (ViewGroup)frameLayout, false);
                this.passwordToggleView = object;
                object4 = this.passwordToggleDrawable;
                ((AppCompatImageButton)object).setImageDrawable((Drawable)object4);
                object = this.passwordToggleView;
                object4 = this.passwordToggleContentDesc;
                object.setContentDescription((CharSequence)object4);
                object = this.inputFrame;
                object4 = this.passwordToggleView;
                object.addView((View)object4);
                object = this.passwordToggleView;
                object4 = new TextInputLayout$2(this);
                object.setOnClickListener((View.OnClickListener)object4);
            }
            if ((object = this.editText) != null && (n10 = ViewCompat.getMinimumHeight((View)object)) <= 0) {
                object = this.editText;
                object4 = this.passwordToggleView;
                n15 = ViewCompat.getMinimumHeight((View)object4);
                object.setMinimumHeight(n15);
            }
            this.passwordToggleView.setVisibility(0);
            object = this.passwordToggleView;
            n15 = (int)(this.passwordToggledVisible ? 1 : 0);
            ((CheckableImageButton)object).setChecked(n15 != 0);
            object = this.passwordToggleDummyDrawable;
            if (object == null) {
                object = new ColorDrawable();
                this.passwordToggleDummyDrawable = object;
            }
            object = this.passwordToggleDummyDrawable;
            n15 = this.passwordToggleView.getMeasuredWidth();
            object.setBounds(0, 0, n15, n12);
            object = TextViewCompat.getCompoundDrawablesRelative((TextView)this.editText);
            object4 = object[n13];
            frameLayout = this.passwordToggleDummyDrawable;
            if (object4 != frameLayout) {
                object3 = object[n13];
                this.originalEditTextEndDrawable = object3;
            }
            object3 = this.editText;
            object2 = object[0];
            Object object5 = object[n12];
            object = object[n11];
            TextViewCompat.setCompoundDrawablesRelative((TextView)object3, (Drawable)object2, (Drawable)object5, (Drawable)frameLayout, (Drawable)object);
            object = this.passwordToggleView;
            EditText editText = this.editText;
            n11 = editText.getPaddingLeft();
            object5 = this.editText;
            n12 = object5.getPaddingTop();
            object3 = this.editText;
            n13 = object3.getPaddingRight();
            object2 = this.editText;
            n14 = object2.getPaddingBottom();
            object.setPadding(n11, n12, n13, n14);
        } else {
            Drawable drawable2;
            Drawable drawable3;
            object = this.passwordToggleView;
            if (object != null && (n10 = object.getVisibility()) == 0) {
                object = this.passwordToggleView;
                int n16 = 8;
                object.setVisibility(n16);
            }
            if ((object = this.passwordToggleDummyDrawable) != null && (drawable3 = (object = TextViewCompat.getCompoundDrawablesRelative((TextView)this.editText))[n13]) == (drawable2 = this.passwordToggleDummyDrawable)) {
                drawable3 = this.editText;
                object2 = object[0];
                Object object6 = object[n12];
                drawable2 = this.originalEditTextEndDrawable;
                object = object[n11];
                TextViewCompat.setCompoundDrawablesRelative((TextView)drawable3, (Drawable)object2, (Drawable)object6, drawable2, (Drawable)object);
                n10 = 0;
                object = null;
                this.passwordToggleDummyDrawable = null;
            }
        }
    }

    private void updateTextInputBoxBounds() {
        GradientDrawable gradientDrawable;
        int n10 = this.boxBackgroundMode;
        if (n10 != 0 && (gradientDrawable = this.boxBackground) != null && (gradientDrawable = this.editText) != null && (n10 = this.getRight()) != 0) {
            gradientDrawable = this.editText;
            n10 = gradientDrawable.getLeft();
            int n11 = this.calculateBoxBackgroundTop();
            EditText editText = this.editText;
            int n12 = editText.getRight();
            EditText editText2 = this.editText;
            int n13 = editText2.getBottom();
            int n14 = this.boxBottomOffsetPx;
            n13 += n14;
            n14 = this.boxBackgroundMode;
            int n15 = 2;
            if (n14 == n15) {
                n14 = this.boxStrokeWidthFocusedPx;
                int n16 = n14 / 2;
                n10 += n16;
                n16 = n14 / 2;
                n11 -= n16;
                n16 = n14 / 2;
                n12 -= n16;
                n13 += (n14 /= n15);
            }
            GradientDrawable gradientDrawable2 = this.boxBackground;
            gradientDrawable2.setBounds(n10, n11, n12, n13);
            this.applyBoxAttributes();
            this.updateEditTextBackgroundBounds();
        }
    }

    public void addView(View view, int n10, ViewGroup.LayoutParams layoutParams) {
        int n11 = view instanceof EditText;
        if (n11 != 0) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = n11 = layoutParams2.gravity & 0xFFFFFF8F | 0x10;
            FrameLayout frameLayout = this.inputFrame;
            frameLayout.addView(view, (ViewGroup.LayoutParams)layoutParams2);
            layoutParams2 = this.inputFrame;
            layoutParams2.setLayoutParams(layoutParams);
            this.updateInputLayoutMargins();
            view = (EditText)view;
            this.setEditText((EditText)view);
        } else {
            super.addView(view, n10, layoutParams);
        }
    }

    public void animateToExpansionFraction(float f10) {
        Object object;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        float f11 = collapsingTextHelper.getExpansionFraction();
        float f12 = f11 - f10;
        Object object2 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object2 == false) {
            return;
        }
        collapsingTextHelper = this.animator;
        if (collapsingTextHelper == null) {
            collapsingTextHelper = new ValueAnimator();
            this.animator = collapsingTextHelper;
            object = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            collapsingTextHelper.setInterpolator((TimeInterpolator)object);
            collapsingTextHelper = this.animator;
            long l10 = 167L;
            collapsingTextHelper.setDuration(l10);
            collapsingTextHelper = this.animator;
            object = new TextInputLayout$3;
            object(this);
            collapsingTextHelper.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
        }
        collapsingTextHelper = this.animator;
        float f13 = this.collapsingTextHelper.getExpansionFraction();
        object = new float[]{f13, f10};
        collapsingTextHelper.setFloatValues((float[])object);
        this.animator.start();
    }

    public boolean cutoutIsOpen() {
        CutoutDrawable cutoutDrawable;
        boolean bl2 = this.cutoutEnabled();
        if (bl2 && (bl2 = (cutoutDrawable = (CutoutDrawable)this.boxBackground).hasCutout())) {
            bl2 = true;
        } else {
            bl2 = false;
            cutoutDrawable = null;
        }
        return bl2;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int n10) {
        CharSequence charSequence = this.originalHint;
        if (charSequence != null && (charSequence = this.editText) != null) {
            boolean bl2 = this.isProvidingHint;
            this.isProvidingHint = false;
            charSequence = charSequence.getHint();
            EditText editText = this.editText;
            CharSequence charSequence2 = this.originalHint;
            editText.setHint(charSequence2);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, n10);
                return;
            }
            finally {
                this.editText.setHint(charSequence);
                this.isProvidingHint = bl2;
            }
        }
        super.dispatchProvideAutofillStructure(viewStructure, n10);
    }

    public void dispatchRestoreInstanceState(SparseArray sparseArray) {
        this.restoringSavedState = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.restoringSavedState = false;
    }

    public void draw(Canvas canvas) {
        Object object = this.boxBackground;
        if (object != null) {
            object.draw(canvas);
        }
        super.draw(canvas);
        boolean bl2 = this.hintEnabled;
        if (bl2) {
            object = this.collapsingTextHelper;
            ((CollapsingTextHelper)object).draw(canvas);
        }
    }

    public void drawableStateChanged() {
        CollapsingTextHelper collapsingTextHelper;
        boolean bl2 = this.inDrawableStateChanged;
        if (bl2) {
            return;
        }
        this.inDrawableStateChanged = bl2 = true;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        boolean bl3 = ViewCompat.isLaidOut((View)this);
        if (!bl3 || !(bl3 = this.isEnabled())) {
            bl2 = false;
            collapsingTextHelper = null;
        }
        this.updateLabelState(bl2);
        this.updateEditTextBackground();
        this.updateTextInputBoxBounds();
        this.updateTextInputBoxState();
        collapsingTextHelper = this.collapsingTextHelper;
        if (collapsingTextHelper != null) {
            bl2 = collapsingTextHelper.setState(nArray) | false;
        } else {
            bl2 = false;
            collapsingTextHelper = null;
        }
        if (bl2) {
            this.invalidate();
        }
        this.inDrawableStateChanged = false;
    }

    public int getBoxBackgroundColor() {
        return this.boxBackgroundColor;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.boxCornerRadiusBottomEnd;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.boxCornerRadiusBottomStart;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.boxCornerRadiusTopEnd;
    }

    public float getBoxCornerRadiusTopStart() {
        return this.boxCornerRadiusTopStart;
    }

    public int getBoxStrokeColor() {
        return this.focusedStrokeColor;
    }

    public int getCounterMaxLength() {
        return this.counterMaxLength;
    }

    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        boolean bl2 = this.counterEnabled;
        if (bl2 && (bl2 = this.counterOverflowed) && (textView = this.counterView) != null) {
            return textView.getContentDescription();
        }
        return null;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.defaultHintTextColor;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public CharSequence getError() {
        Object object = this.indicatorViewController;
        boolean bl2 = ((IndicatorViewController)object).isErrorEnabled();
        if (bl2) {
            object = this.indicatorViewController.getErrorText();
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    public int getErrorCurrentTextColors() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public final int getErrorTextCurrentColor() {
        return this.indicatorViewController.getErrorViewCurrentTextColor();
    }

    public CharSequence getHelperText() {
        Object object = this.indicatorViewController;
        boolean bl2 = ((IndicatorViewController)object).isHelperTextEnabled();
        if (bl2) {
            object = this.indicatorViewController.getHelperText();
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    public int getHelperTextCurrentTextColor() {
        return this.indicatorViewController.getHelperTextViewCurrentTextColor();
    }

    public CharSequence getHint() {
        CharSequence charSequence;
        boolean bl2 = this.hintEnabled;
        if (bl2) {
            charSequence = this.hint;
        } else {
            bl2 = false;
            charSequence = null;
        }
        return charSequence;
    }

    public final float getHintCollapsedTextHeight() {
        return this.collapsingTextHelper.getCollapsedTextHeight();
    }

    public final int getHintCurrentCollapsedTextColor() {
        return this.collapsingTextHelper.getCurrentCollapsedTextColor();
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.passwordToggleContentDesc;
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.passwordToggleDrawable;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public boolean isCounterEnabled() {
        return this.counterEnabled;
    }

    public boolean isErrorEnabled() {
        return this.indicatorViewController.isErrorEnabled();
    }

    public final boolean isHelperTextDisplayed() {
        return this.indicatorViewController.helperTextIsDisplayed();
    }

    public boolean isHelperTextEnabled() {
        return this.indicatorViewController.isHelperTextEnabled();
    }

    public boolean isHintAnimationEnabled() {
        return this.hintAnimationEnabled;
    }

    public boolean isHintEnabled() {
        return this.hintEnabled;
    }

    public final boolean isHintExpanded() {
        return this.hintExpanded;
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.passwordToggleEnabled;
    }

    public boolean isProvidingHint() {
        return this.isProvidingHint;
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        boolean bl3;
        void var5_10;
        int n14;
        int n15;
        int n16;
        super.onLayout(bl2, n16, n15, n14, (int)var5_10);
        Object object = this.boxBackground;
        if (object != null) {
            this.updateTextInputBoxBounds();
        }
        if ((bl3 = this.hintEnabled) && (object = this.editText) != null) {
            boolean bl4;
            Object object2 = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)object, (Rect)object2);
            int n17 = ((Rect)object2).left;
            EditText editText = this.editText;
            n14 = editText.getCompoundPaddingLeft();
            int n18 = n17 + n14;
            n14 = ((Rect)object2).right;
            EditText editText2 = this.editText;
            int n19 = editText2.getCompoundPaddingRight();
            n14 -= n19;
            n19 = this.calculateCollapsedTextTopBounds();
            CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
            int n20 = ((Rect)object2).top;
            int n21 = this.editText.getCompoundPaddingTop();
            n20 += n21;
            n16 = ((Rect)object2).bottom;
            EditText editText3 = this.editText;
            n21 = editText3.getCompoundPaddingBottom();
            collapsingTextHelper.setExpandedBounds(n18, n20, n14, n16 -= n21);
            object2 = this.collapsingTextHelper;
            var5_10 -= n15;
            n15 = this.getPaddingBottom();
            ((CollapsingTextHelper)object2).setCollapsedBounds(n18, n19, n14, (int)(var5_10 -= n15));
            object = this.collapsingTextHelper;
            ((CollapsingTextHelper)object).recalculate();
            boolean bl5 = this.cutoutEnabled();
            if (bl5 && !(bl4 = this.hintExpanded)) {
                this.openCutout();
            }
        }
    }

    public void onMeasure(int n10, int n11) {
        this.updatePasswordToggleView();
        super.onMeasure(n10, n11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        boolean bl2 = parcelable instanceof TextInputLayout$SavedState;
        if (!bl2) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (TextInputLayout$SavedState)parcelable;
        Object object = parcelable.getSuperState();
        super.onRestoreInstanceState(object);
        object = parcelable.error;
        this.setError((CharSequence)object);
        boolean bl3 = parcelable.isPasswordToggledVisible;
        if (bl3) {
            bl3 = true;
            this.passwordVisibilityToggleRequested(bl3);
        }
        this.requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        Object object = super.onSaveInstanceState();
        TextInputLayout$SavedState textInputLayout$SavedState = new TextInputLayout$SavedState((Parcelable)object);
        object = this.indicatorViewController;
        boolean bl2 = ((IndicatorViewController)object).errorShouldBeShown();
        if (bl2) {
            textInputLayout$SavedState.error = object = this.getError();
        }
        textInputLayout$SavedState.isPasswordToggledVisible = bl2 = this.passwordToggledVisible;
        return textInputLayout$SavedState;
    }

    public void passwordVisibilityToggleRequested(boolean bl2) {
        int n10 = this.passwordToggleEnabled;
        if (n10 != 0) {
            CheckableImageButton checkableImageButton;
            boolean bl3;
            Object object;
            EditText editText = this.editText;
            n10 = editText.getSelectionEnd();
            boolean bl4 = this.hasPasswordTransformation();
            if (bl4) {
                object = this.editText;
                bl3 = false;
                Object var7_7 = null;
                object.setTransformationMethod(null);
                this.passwordToggledVisible = bl4 = true;
            } else {
                object = this.editText;
                PasswordTransformationMethod passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                object.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
                bl4 = false;
                object = null;
                this.passwordToggledVisible = false;
            }
            object = this.passwordToggleView;
            bl3 = this.passwordToggledVisible;
            ((CheckableImageButton)object).setChecked(bl3);
            if (bl2) {
                checkableImageButton = this.passwordToggleView;
                checkableImageButton.jumpDrawablesToCurrentState();
            }
            checkableImageButton = this.editText;
            checkableImageButton.setSelection(n10);
        }
    }

    public void setBoxBackgroundColor(int n10) {
        int n11 = this.boxBackgroundColor;
        if (n11 != n10) {
            this.boxBackgroundColor = n10;
            this.applyBoxAttributes();
        }
    }

    public void setBoxBackgroundColorResource(int n10) {
        n10 = ContextCompat.getColor(this.getContext(), n10);
        this.setBoxBackgroundColor(n10);
    }

    public void setBoxBackgroundMode(int n10) {
        int n11 = this.boxBackgroundMode;
        if (n10 == n11) {
            return;
        }
        this.boxBackgroundMode = n10;
        this.onApplyBoxBackgroundMode();
    }

    public void setBoxCornerRadii(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        float f17 = this.boxCornerRadiusTopStart;
        float f18 = f17 - f10;
        Object object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (object != false || (object = (f16 = (f17 = this.boxCornerRadiusTopEnd) - f11) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) != false || (object = (f15 = (f17 = this.boxCornerRadiusBottomEnd) - f13) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false || (object = (f14 = (f17 = this.boxCornerRadiusBottomStart) - f12) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) != false) {
            this.boxCornerRadiusTopStart = f10;
            this.boxCornerRadiusTopEnd = f11;
            this.boxCornerRadiusBottomEnd = f13;
            this.boxCornerRadiusBottomStart = f12;
            this.applyBoxAttributes();
        }
    }

    public void setBoxCornerRadiiResources(int n10, int n11, int n12, int n13) {
        float f10 = this.getContext().getResources().getDimension(n10);
        float f11 = this.getContext().getResources().getDimension(n11);
        float f12 = this.getContext().getResources().getDimension(n12);
        float f13 = this.getContext().getResources().getDimension(n13);
        this.setBoxCornerRadii(f10, f11, f12, f13);
    }

    public void setBoxStrokeColor(int n10) {
        int n11 = this.focusedStrokeColor;
        if (n11 != n10) {
            this.focusedStrokeColor = n10;
            this.updateTextInputBoxState();
        }
    }

    public void setCounterEnabled(boolean n10) {
        int n11 = this.counterEnabled;
        if (n11 != n10) {
            n11 = 2;
            if (n10) {
                Context context = this.getContext();
                Object object = new AppCompatTextView(context);
                this.counterView = object;
                int n12 = R$id.textinput_counter;
                object.setId(n12);
                object = this.typeface;
                if (object != null) {
                    context = this.counterView;
                    context.setTypeface((Typeface)object);
                }
                this.counterView.setMaxLines(1);
                object = this.counterView;
                n12 = this.counterTextAppearance;
                this.setTextAppearanceCompatWithErrorFallback((TextView)object, n12);
                object = this.indicatorViewController;
                context = this.counterView;
                ((IndicatorViewController)object).addIndicator((TextView)context, n11);
                EditText editText = this.editText;
                if (editText == null) {
                    n11 = 0;
                    editText = null;
                    this.updateCounter(0);
                } else {
                    editText = editText.getText();
                    n11 = editText.length();
                    this.updateCounter(n11);
                }
            } else {
                IndicatorViewController indicatorViewController = this.indicatorViewController;
                TextView textView = this.counterView;
                indicatorViewController.removeIndicator(textView, n11);
                n11 = 0;
                Object var6_9 = null;
                this.counterView = null;
            }
            this.counterEnabled = n10;
        }
    }

    public void setCounterMaxLength(int n10) {
        int n11 = this.counterMaxLength;
        if (n11 != n10) {
            this.counterMaxLength = n10 > 0 ? n10 : (n10 = -1);
            n10 = (int)(this.counterEnabled ? 1 : 0);
            if (n10 != 0) {
                EditText editText = this.editText;
                if (editText == null) {
                    n10 = 0;
                    editText = null;
                } else {
                    editText = editText.getText();
                    n10 = editText.length();
                }
                this.updateCounter(n10);
            }
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.defaultHintTextColor = colorStateList;
        this.focusedTextColor = colorStateList;
        colorStateList = this.editText;
        if (colorStateList != null) {
            colorStateList = null;
            this.updateLabelState(false);
        }
    }

    public void setEnabled(boolean bl2) {
        TextInputLayout.recursiveSetEnabled((ViewGroup)this, bl2);
        super.setEnabled(bl2);
    }

    public void setError(CharSequence object) {
        IndicatorViewController indicatorViewController = this.indicatorViewController;
        boolean bl2 = indicatorViewController.isErrorEnabled();
        if (!bl2) {
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) {
                return;
            }
            bl2 = true;
            this.setErrorEnabled(bl2);
        }
        if (!(bl2 = TextUtils.isEmpty((CharSequence)object))) {
            indicatorViewController = this.indicatorViewController;
            indicatorViewController.showError((CharSequence)object);
        } else {
            object = this.indicatorViewController;
            ((IndicatorViewController)object).hideError();
        }
    }

    public void setErrorEnabled(boolean bl2) {
        this.indicatorViewController.setErrorEnabled(bl2);
    }

    public void setErrorTextAppearance(int n10) {
        this.indicatorViewController.setErrorTextAppearance(n10);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setErrorViewTextColor(colorStateList);
    }

    public void setHelperText(CharSequence charSequence) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            boolean bl3 = this.isHelperTextEnabled();
            if (bl3) {
                bl3 = false;
                charSequence = null;
                this.setHelperTextEnabled(false);
            }
        } else {
            bl2 = this.isHelperTextEnabled();
            if (!bl2) {
                bl2 = true;
                this.setHelperTextEnabled(bl2);
            }
            IndicatorViewController indicatorViewController = this.indicatorViewController;
            indicatorViewController.showHelper(charSequence);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.indicatorViewController.setHelperTextViewTextColor(colorStateList);
    }

    public void setHelperTextEnabled(boolean bl2) {
        this.indicatorViewController.setHelperTextEnabled(bl2);
    }

    public void setHelperTextTextAppearance(int n10) {
        this.indicatorViewController.setHelperTextAppearance(n10);
    }

    public void setHint(CharSequence charSequence) {
        boolean bl2 = this.hintEnabled;
        if (bl2) {
            this.setHintInternal(charSequence);
            int n10 = 2048;
            this.sendAccessibilityEvent(n10);
        }
    }

    public void setHintAnimationEnabled(boolean bl2) {
        this.hintAnimationEnabled = bl2;
    }

    public void setHintEnabled(boolean bl2) {
        boolean bl3 = this.hintEnabled;
        if (bl2 != bl3) {
            CharSequence charSequence;
            this.hintEnabled = bl2;
            bl3 = false;
            if (!bl2) {
                this.isProvidingHint = false;
                charSequence = this.hint;
                bl2 = TextUtils.isEmpty((CharSequence)charSequence);
                if (!bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(charSequence = this.editText.getHint())))) {
                    charSequence = this.editText;
                    CharSequence charSequence2 = this.hint;
                    charSequence.setHint(charSequence2);
                }
                this.setHintInternal(null);
            } else {
                charSequence = this.editText.getHint();
                boolean bl4 = TextUtils.isEmpty((CharSequence)charSequence);
                if (!bl4) {
                    CharSequence charSequence3 = this.hint;
                    bl4 = TextUtils.isEmpty((CharSequence)charSequence3);
                    if (bl4) {
                        this.setHint(charSequence);
                    }
                    charSequence = this.editText;
                    charSequence.setHint(null);
                }
                this.isProvidingHint = bl2 = true;
            }
            charSequence = this.editText;
            if (charSequence != null) {
                this.updateInputLayoutMargins();
            }
        }
    }

    public void setHintTextAppearance(int n10) {
        ColorStateList colorStateList;
        CollapsingTextHelper collapsingTextHelper = this.collapsingTextHelper;
        collapsingTextHelper.setCollapsedTextAppearance(n10);
        this.focusedTextColor = colorStateList = this.collapsingTextHelper.getCollapsedTextColor();
        colorStateList = this.editText;
        if (colorStateList != null) {
            n10 = 0;
            colorStateList = null;
            this.updateLabelState(false);
            this.updateInputLayoutMargins();
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int n10) {
        CharSequence charSequence;
        if (n10 != 0) {
            Resources resources = this.getResources();
            charSequence = resources.getText(n10);
        } else {
            n10 = 0;
            charSequence = null;
        }
        this.setPasswordVisibilityToggleContentDescription(charSequence);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.passwordToggleContentDesc = charSequence;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setContentDescription(charSequence);
        }
    }

    public void setPasswordVisibilityToggleDrawable(int n10) {
        Drawable drawable2;
        if (n10 != 0) {
            Context context = this.getContext();
            drawable2 = AppCompatResources.getDrawable(context, n10);
        } else {
            n10 = 0;
            drawable2 = null;
        }
        this.setPasswordVisibilityToggleDrawable(drawable2);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable2) {
        this.passwordToggleDrawable = drawable2;
        CheckableImageButton checkableImageButton = this.passwordToggleView;
        if (checkableImageButton != null) {
            checkableImageButton.setImageDrawable(drawable2);
        }
    }

    public void setPasswordVisibilityToggleEnabled(boolean bl2) {
        boolean bl3 = this.passwordToggleEnabled;
        if (bl3 != bl2) {
            EditText editText;
            this.passwordToggleEnabled = bl2;
            if (!bl2 && (bl2 = this.passwordToggledVisible) && (editText = this.editText) != null) {
                PasswordTransformationMethod passwordTransformationMethod = PasswordTransformationMethod.getInstance();
                editText.setTransformationMethod((TransformationMethod)passwordTransformationMethod);
            }
            bl2 = false;
            editText = null;
            this.passwordToggledVisible = false;
            this.updatePasswordToggleView();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.passwordToggleTintList = colorStateList;
        this.hasPasswordToggleTintList = true;
        this.applyPasswordToggleTint();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.passwordToggleTintMode = mode;
        this.hasPasswordToggleTintMode = true;
        this.applyPasswordToggleTint();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setTextAppearanceCompatWithErrorFallback(TextView textView, int n10) {
        ColorStateList colorStateList;
        int n11 = 1;
        try {
            TextViewCompat.setTextAppearance(textView, n10);
            n10 = Build.VERSION.SDK_INT;
            int n12 = 23;
            if (n10 < n12) return;
            colorStateList = textView.getTextColors();
            n10 = colorStateList.getDefaultColor();
            if (n10 != (n12 = -65281)) return;
        }
        catch (Exception exception) {}
        if (n11 == 0) return;
        n10 = R$style.TextAppearance_AppCompat_Caption;
        TextViewCompat.setTextAppearance(textView, n10);
        colorStateList = this.getContext();
        n11 = R$color.design_error;
        n10 = ContextCompat.getColor((Context)colorStateList, n11);
        textView.setTextColor(n10);
    }

    public void setTextInputAccessibilityDelegate(TextInputLayout$AccessibilityDelegate textInputLayout$AccessibilityDelegate) {
        EditText editText = this.editText;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate((View)editText, textInputLayout$AccessibilityDelegate);
        }
    }

    public void setTypeface(Typeface typeface) {
        Typeface typeface2 = this.typeface;
        if (typeface != typeface2) {
            this.typeface = typeface;
            this.collapsingTextHelper.setTypefaces(typeface);
            this.indicatorViewController.setTypefaces(typeface);
            typeface2 = this.counterView;
            if (typeface2 != null) {
                typeface2.setTypeface(typeface);
            }
        }
    }

    public void updateCounter(int n10) {
        Object object;
        int n11 = this.counterOverflowed;
        int n12 = this.counterMaxLength;
        int n13 = -1;
        if (n12 == n13) {
            TextView textView = this.counterView;
            object = String.valueOf(n10);
            textView.setText((CharSequence)object);
            object = this.counterView;
            n12 = 0;
            textView = null;
            object.setContentDescription(null);
            this.counterOverflowed = false;
        } else {
            Object object2;
            TextView textView = this.counterView;
            n12 = ViewCompat.getAccessibilityLiveRegion((View)textView);
            if (n12 == (n13 = 1)) {
                textView = this.counterView;
                ViewCompat.setAccessibilityLiveRegion((View)textView, 0);
            }
            if (n10 > (n12 = this.counterMaxLength)) {
                n12 = n13;
            } else {
                n12 = 0;
                textView = null;
            }
            this.counterOverflowed = n12;
            if (n11 != n12) {
                object2 = this.counterView;
                n12 = n12 != 0 ? this.counterOverflowTextAppearance : this.counterTextAppearance;
                this.setTextAppearanceCompatWithErrorFallback((TextView)object2, n12);
                n12 = (int)(this.counterOverflowed ? 1 : 0);
                if (n12 != 0) {
                    textView = this.counterView;
                    ViewCompat.setAccessibilityLiveRegion((View)textView, n13);
                }
            }
            textView = this.counterView;
            object2 = this.getContext();
            int n14 = R$string.character_counter_pattern;
            int n15 = 2;
            Object[] objectArray = new Object[n15];
            Integer n16 = n10;
            objectArray[0] = n16;
            int n17 = this.counterMaxLength;
            n16 = n17;
            objectArray[n13] = n16;
            object2 = object2.getString(n14, objectArray);
            textView.setText((CharSequence)object2);
            textView = this.counterView;
            object2 = this.getContext();
            n14 = R$string.character_counter_content_description;
            Object[] objectArray2 = new Object[n15];
            objectArray2[0] = object = Integer.valueOf(n10);
            n10 = this.counterMaxLength;
            objectArray2[n13] = object = Integer.valueOf(n10);
            object = object2.getString(n14, objectArray2);
            textView.setContentDescription((CharSequence)object);
        }
        object = this.editText;
        if (object != null && n11 != (n10 = (int)(this.counterOverflowed ? 1 : 0))) {
            this.updateLabelState(false);
            this.updateTextInputBoxState();
            this.updateEditTextBackground();
        }
    }

    public void updateEditTextBackground() {
        IndicatorViewController indicatorViewController;
        EditText editText = this.editText;
        if (editText == null) {
            return;
        }
        if ((editText = editText.getBackground()) == null) {
            return;
        }
        this.ensureBackgroundDrawableStateWorkaround();
        int n10 = DrawableUtils.canSafelyMutateDrawable((Drawable)editText);
        if (n10 != 0) {
            editText = editText.mutate();
        }
        if ((n10 = (indicatorViewController = this.indicatorViewController).errorShouldBeShown()) != 0) {
            n10 = this.indicatorViewController.getErrorViewCurrentTextColor();
            PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
            indicatorViewController = AppCompatDrawableManager.getPorterDuffColorFilter(n10, mode);
            editText.setColorFilter((ColorFilter)indicatorViewController);
        } else {
            n10 = this.counterOverflowed;
            if (n10 != 0 && (indicatorViewController = this.counterView) != null) {
                n10 = indicatorViewController.getCurrentTextColor();
                PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
                indicatorViewController = AppCompatDrawableManager.getPorterDuffColorFilter(n10, mode);
                editText.setColorFilter((ColorFilter)indicatorViewController);
            } else {
                DrawableCompat.clearColorFilter((Drawable)editText);
                editText = this.editText;
                editText.refreshDrawableState();
            }
        }
    }

    public void updateLabelState(boolean bl2) {
        this.updateLabelState(bl2, false);
    }

    public void updateTextInputBoxState() {
        int n10;
        GradientDrawable gradientDrawable = this.boxBackground;
        if (gradientDrawable != null && (n10 = this.boxBackgroundMode) != 0) {
            int n11;
            gradientDrawable = this.editText;
            int n12 = 1;
            int n13 = 0;
            IndicatorViewController indicatorViewController = null;
            if (gradientDrawable != null && (n10 = (int)(gradientDrawable.hasFocus() ? 1 : 0)) != 0) {
                n10 = n12;
            } else {
                n10 = 0;
                gradientDrawable = null;
            }
            EditText editText = this.editText;
            if (editText == null || (n11 = editText.isHovered()) == 0) {
                n12 = 0;
            }
            n13 = this.boxBackgroundMode;
            n11 = 2;
            if (n13 == n11) {
                n13 = (int)(this.isEnabled() ? 1 : 0);
                if (n13 == 0) {
                    this.boxStrokeColor = n13 = this.disabledColor;
                } else {
                    indicatorViewController = this.indicatorViewController;
                    n13 = (int)(indicatorViewController.errorShouldBeShown() ? 1 : 0);
                    if (n13 != 0) {
                        indicatorViewController = this.indicatorViewController;
                        this.boxStrokeColor = n13 = indicatorViewController.getErrorViewCurrentTextColor();
                    } else {
                        n13 = (int)(this.counterOverflowed ? 1 : 0);
                        this.boxStrokeColor = n13 != 0 && (indicatorViewController = this.counterView) != null ? (n13 = indicatorViewController.getCurrentTextColor()) : (n10 != 0 ? (n13 = this.focusedStrokeColor) : (n12 != 0 ? (n13 = this.hoveredStrokeColor) : (n13 = this.defaultStrokeColor)));
                    }
                }
                this.boxStrokeWidthPx = (n12 != 0 || n10 != 0) && (n10 = (int)(this.isEnabled() ? 1 : 0)) != 0 ? (n10 = this.boxStrokeWidthFocusedPx) : (n10 = this.boxStrokeWidthDefaultPx);
                this.applyBoxAttributes();
            }
        }
    }
}

