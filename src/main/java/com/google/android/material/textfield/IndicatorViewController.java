/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Typeface
 *  android.text.TextUtils
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.EditText
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 */
package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.legacy.widget.Space;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.textfield.IndicatorViewController$1;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;
import java.util.List;

public final class IndicatorViewController {
    private static final int CAPTION_OPACITY_FADE_ANIMATION_DURATION = 167;
    private static final int CAPTION_STATE_ERROR = 1;
    private static final int CAPTION_STATE_HELPER_TEXT = 2;
    private static final int CAPTION_STATE_NONE = 0;
    private static final int CAPTION_TRANSLATE_Y_ANIMATION_DURATION = 217;
    public static final int COUNTER_INDEX = 2;
    public static final int ERROR_INDEX = 0;
    public static final int HELPER_INDEX = 1;
    private Animator captionAnimator;
    private FrameLayout captionArea;
    private int captionDisplayed;
    private int captionToShow;
    private final float captionTranslationYPx;
    private int captionViewsAdded;
    private final Context context;
    private boolean errorEnabled;
    private CharSequence errorText;
    private int errorTextAppearance;
    private TextView errorView;
    private CharSequence helperText;
    private boolean helperTextEnabled;
    private int helperTextTextAppearance;
    private TextView helperTextView;
    private LinearLayout indicatorArea;
    private int indicatorsAdded;
    private final TextInputLayout textInputView;
    private Typeface typeface;

    public IndicatorViewController(TextInputLayout textInputLayout) {
        float f10;
        Context context;
        this.context = context = textInputLayout.getContext();
        this.textInputView = textInputLayout;
        textInputLayout = context.getResources();
        int n10 = R$dimen.design_textinput_caption_translate_y;
        this.captionTranslationYPx = f10 = (float)textInputLayout.getDimensionPixelSize(n10);
    }

    public static /* synthetic */ int access$002(IndicatorViewController indicatorViewController, int n10) {
        indicatorViewController.captionDisplayed = n10;
        return n10;
    }

    public static /* synthetic */ Animator access$102(IndicatorViewController indicatorViewController, Animator animator2) {
        indicatorViewController.captionAnimator = animator2;
        return animator2;
    }

    public static /* synthetic */ TextView access$200(IndicatorViewController indicatorViewController) {
        return indicatorViewController.errorView;
    }

    private boolean canAdjustIndicatorPadding() {
        boolean bl2;
        LinearLayout linearLayout = this.indicatorArea;
        if (linearLayout != null && (linearLayout = this.textInputView.getEditText()) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            linearLayout = null;
        }
        return bl2;
    }

    private void createCaptionAnimators(List list, boolean bl2, TextView textView, int n10, int n11, int n12) {
        if (textView != null && bl2 && (n10 == n12 || n10 == n11)) {
            ObjectAnimator objectAnimator;
            if (n12 == n10) {
                bl2 = true;
            } else {
                bl2 = false;
                objectAnimator = null;
            }
            objectAnimator = this.createCaptionOpacityAnimator(textView, bl2);
            list.add(objectAnimator);
            if (n12 == n10) {
                objectAnimator = this.createCaptionTranslationYAnimator(textView);
                list.add(objectAnimator);
            }
        }
    }

    private ObjectAnimator createCaptionOpacityAnimator(TextView textView, boolean bl2) {
        TimeInterpolator timeInterpolator;
        float f10;
        if (bl2) {
            int n10 = 1065353216;
            f10 = 1.0f;
        } else {
            boolean bl3 = false;
            f10 = 0.0f;
            timeInterpolator = null;
        }
        Property property = View.ALPHA;
        float[] fArray = new float[]{f10};
        textView = ObjectAnimator.ofFloat((Object)textView, (Property)property, (float[])fArray);
        textView.setDuration(167L);
        timeInterpolator = AnimationUtils.LINEAR_INTERPOLATOR;
        textView.setInterpolator(timeInterpolator);
        return textView;
    }

    private ObjectAnimator createCaptionTranslationYAnimator(TextView textView) {
        Property property = View.TRANSLATION_Y;
        float f10 = -this.captionTranslationYPx;
        float[] fArray = new float[]{f10, 0.0f};
        textView = ObjectAnimator.ofFloat((Object)textView, (Property)property, (float[])fArray);
        textView.setDuration(217L);
        property = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        textView.setInterpolator((TimeInterpolator)property);
        return textView;
    }

    private TextView getCaptionViewFromDisplayState(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                return null;
            }
            return this.helperTextView;
        }
        return this.errorView;
    }

    private boolean isCaptionStateError(int n10) {
        Object object;
        int n11 = 1;
        if (n10 != n11 || (object = this.errorView) == null || (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.errorText)) ? 1 : 0)) != 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private boolean isCaptionStateHelperText(int n10) {
        Object object;
        int n11 = 2;
        if (n10 == n11 && (object = this.helperTextView) != null && (n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.helperText)) ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    private void setCaptionViewVisibilities(int n10, int n11) {
        float f10;
        int n12;
        TextView textView;
        if (n10 == n11) {
            return;
        }
        if (n11 != 0 && (textView = this.getCaptionViewFromDisplayState(n11)) != null) {
            textView.setVisibility(0);
            n12 = 1065353216;
            f10 = 1.0f;
            textView.setAlpha(f10);
        }
        if (n10 != 0 && (textView = this.getCaptionViewFromDisplayState(n10)) != null) {
            textView.setVisibility(4);
            n12 = 1;
            f10 = Float.MIN_VALUE;
            if (n10 == n12) {
                n10 = 0;
                textView.setText(null);
            }
        }
        this.captionDisplayed = n11;
    }

    private void setTextViewTypeface(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    private void setViewGroupGoneIfEmpty(ViewGroup viewGroup, int n10) {
        if (n10 == 0) {
            n10 = 8;
            viewGroup.setVisibility(n10);
        }
    }

    private boolean shouldAnimateCaptionView(TextView object, CharSequence charSequence) {
        boolean bl2;
        int n10;
        TextInputLayout textInputLayout = this.textInputView;
        int n11 = ViewCompat.isLaidOut((View)textInputLayout);
        if (!(n11 == 0 || (n11 = (textInputLayout = this.textInputView).isEnabled()) == 0 || (n11 = this.captionToShow) == (n10 = this.captionDisplayed) && object != null && (bl2 = TextUtils.equals((CharSequence)(object = object.getText()), (CharSequence)charSequence)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void updateCaptionViewsVisibility(int n10, int n11, boolean bl2) {
        if (bl2) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.captionAnimator = animatorSet;
            ArrayList arrayList = new ArrayList();
            int n12 = this.helperTextEnabled;
            TextView textView = this.helperTextView;
            this.createCaptionAnimators(arrayList, n12 != 0, textView, 2, n10, n11);
            n12 = this.errorEnabled;
            textView = this.errorView;
            this.createCaptionAnimators(arrayList, n12 != 0, textView, 1, n10, n11);
            AnimatorSetCompat.playTogether(animatorSet, arrayList);
            textView = this.getCaptionViewFromDisplayState(n10);
            TextView textView2 = this.getCaptionViewFromDisplayState(n11);
            n12 = n11;
            IndicatorViewController$1 indicatorViewController$1 = new IndicatorViewController$1(this, n11, textView, n10, textView2);
            animatorSet.addListener((Animator.AnimatorListener)indicatorViewController$1);
            animatorSet.start();
        } else {
            this.setCaptionViewVisibilities(n10, n11);
        }
        this.textInputView.updateEditTextBackground();
        this.textInputView.updateLabelState(bl2);
        this.textInputView.updateTextInputBoxState();
    }

    public void addIndicator(TextView textView, int n10) {
        int n11;
        boolean bl2;
        Object object = this.indicatorArea;
        if (object == null && (object = this.captionArea) == null) {
            Context context = this.context;
            this.indicatorArea = object = new LinearLayout(context);
            object.setOrientation(0);
            object = this.textInputView;
            context = this.indicatorArea;
            int n12 = -1;
            int n13 = -2;
            object.addView((View)context, n12, n13);
            context = this.context;
            object = new FrameLayout(context);
            this.captionArea = object;
            context = this.indicatorArea;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(n13, n13);
            context.addView((View)object, n12, (ViewGroup.LayoutParams)layoutParams);
            context = this.context;
            object = new Space(context);
            n12 = 1065353216;
            float f10 = 1.0f;
            context = new LinearLayout.LayoutParams(0, 0, f10);
            LinearLayout linearLayout = this.indicatorArea;
            linearLayout.addView((View)object, (ViewGroup.LayoutParams)context);
            object = this.textInputView.getEditText();
            if (object != null) {
                this.adjustIndicatorPadding();
            }
        }
        if (bl2 = this.isCaptionView(n10)) {
            this.captionArea.setVisibility(0);
            FrameLayout frameLayout = this.captionArea;
            frameLayout.addView((View)textView);
            this.captionViewsAdded = n11 = this.captionViewsAdded + 1;
        } else {
            object = this.indicatorArea;
            object.addView((View)textView, n10);
        }
        this.indicatorArea.setVisibility(0);
        this.indicatorsAdded = n11 = this.indicatorsAdded + 1;
    }

    public void adjustIndicatorPadding() {
        boolean bl2 = this.canAdjustIndicatorPadding();
        if (bl2) {
            LinearLayout linearLayout = this.indicatorArea;
            EditText editText = this.textInputView.getEditText();
            int n10 = ViewCompat.getPaddingStart((View)editText);
            EditText editText2 = this.textInputView.getEditText();
            int n11 = ViewCompat.getPaddingEnd((View)editText2);
            ViewCompat.setPaddingRelative((View)linearLayout, n10, 0, n11, 0);
        }
    }

    public void cancelCaptionAnimator() {
        Animator animator2 = this.captionAnimator;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    public boolean errorIsDisplayed() {
        int n10 = this.captionDisplayed;
        return this.isCaptionStateError(n10);
    }

    public boolean errorShouldBeShown() {
        int n10 = this.captionToShow;
        return this.isCaptionStateError(n10);
    }

    public CharSequence getErrorText() {
        return this.errorText;
    }

    public int getErrorViewCurrentTextColor() {
        TextView textView = this.errorView;
        int n10 = textView != null ? textView.getCurrentTextColor() : -1;
        return n10;
    }

    public ColorStateList getErrorViewTextColors() {
        Object object = this.errorView;
        object = object != null ? object.getTextColors() : null;
        return object;
    }

    public CharSequence getHelperText() {
        return this.helperText;
    }

    public ColorStateList getHelperTextViewColors() {
        Object object = this.helperTextView;
        object = object != null ? object.getTextColors() : null;
        return object;
    }

    public int getHelperTextViewCurrentTextColor() {
        TextView textView = this.helperTextView;
        int n10 = textView != null ? textView.getCurrentTextColor() : -1;
        return n10;
    }

    public boolean helperTextIsDisplayed() {
        int n10 = this.captionDisplayed;
        return this.isCaptionStateHelperText(n10);
    }

    public boolean helperTextShouldBeShown() {
        int n10 = this.captionToShow;
        return this.isCaptionStateHelperText(n10);
    }

    public void hideError() {
        boolean bl2 = false;
        this.errorText = null;
        this.cancelCaptionAnimator();
        int n10 = this.captionDisplayed;
        int n11 = 1;
        if (n10 == n11) {
            CharSequence charSequence;
            n10 = (int)(this.helperTextEnabled ? 1 : 0);
            if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)(charSequence = this.helperText)) ? 1 : 0)) == 0) {
                this.captionToShow = n10 = 2;
            } else {
                n10 = 0;
                charSequence = null;
                this.captionToShow = 0;
            }
        }
        n10 = this.captionDisplayed;
        n11 = this.captionToShow;
        TextView textView = this.errorView;
        bl2 = this.shouldAnimateCaptionView(textView, null);
        this.updateCaptionViewsVisibility(n10, n11, bl2);
    }

    public void hideHelperText() {
        this.cancelCaptionAnimator();
        int n10 = this.captionDisplayed;
        int n11 = 2;
        if (n10 == n11) {
            n11 = 0;
            this.captionToShow = 0;
        }
        n11 = this.captionToShow;
        TextView textView = this.helperTextView;
        boolean bl2 = this.shouldAnimateCaptionView(textView, null);
        this.updateCaptionViewsVisibility(n10, n11, bl2);
    }

    public boolean isCaptionView(int n10) {
        int n11 = 1;
        if (n10 != 0 && n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isErrorEnabled() {
        return this.errorEnabled;
    }

    public boolean isHelperTextEnabled() {
        return this.helperTextEnabled;
    }

    public void removeIndicator(TextView textView, int n10) {
        int n11;
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.indicatorArea;
        if (linearLayout == null) {
            return;
        }
        if ((n10 = (int)(this.isCaptionView(n10) ? 1 : 0)) != 0 && (frameLayout = this.captionArea) != null) {
            int n12;
            this.captionViewsAdded = n12 = this.captionViewsAdded + -1;
            this.setViewGroupGoneIfEmpty((ViewGroup)frameLayout, n12);
            frameLayout = this.captionArea;
            frameLayout.removeView((View)textView);
        } else {
            frameLayout = this.indicatorArea;
            frameLayout.removeView((View)textView);
        }
        this.indicatorsAdded = n11 = this.indicatorsAdded + -1;
        frameLayout = this.indicatorArea;
        this.setViewGroupGoneIfEmpty((ViewGroup)frameLayout, n11);
    }

    public void setErrorEnabled(boolean bl2) {
        boolean bl3 = this.errorEnabled;
        if (bl3 == bl2) {
            return;
        }
        this.cancelCaptionAnimator();
        bl3 = false;
        TextInputLayout textInputLayout = null;
        if (bl2) {
            Context context = this.context;
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            this.errorView = appCompatTextView;
            int n10 = R$id.textinput_error;
            appCompatTextView.setId(n10);
            appCompatTextView = this.typeface;
            if (appCompatTextView != null) {
                context = this.errorView;
                context.setTypeface((Typeface)appCompatTextView);
            }
            int n11 = this.errorTextAppearance;
            this.setErrorTextAppearance(n11);
            this.errorView.setVisibility(4);
            appCompatTextView = this.errorView;
            n10 = 1;
            ViewCompat.setAccessibilityLiveRegion((View)appCompatTextView, n10);
            appCompatTextView = this.errorView;
            this.addIndicator(appCompatTextView, 0);
        } else {
            this.hideError();
            TextView textView = this.errorView;
            this.removeIndicator(textView, 0);
            bl3 = false;
            this.errorView = null;
            this.textInputView.updateEditTextBackground();
            textInputLayout = this.textInputView;
            textInputLayout.updateTextInputBoxState();
        }
        this.errorEnabled = bl2;
    }

    public void setErrorTextAppearance(int n10) {
        this.errorTextAppearance = n10;
        TextView textView = this.errorView;
        if (textView != null) {
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.setTextAppearanceCompatWithErrorFallback(textView, n10);
        }
    }

    public void setErrorViewTextColor(ColorStateList colorStateList) {
        TextView textView = this.errorView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setHelperTextAppearance(int n10) {
        this.helperTextTextAppearance = n10;
        TextView textView = this.helperTextView;
        if (textView != null) {
            TextViewCompat.setTextAppearance(textView, n10);
        }
    }

    public void setHelperTextEnabled(boolean n10) {
        int n11 = (int)(this.helperTextEnabled ? 1 : 0);
        if (n11 == n10) {
            return;
        }
        this.cancelCaptionAnimator();
        n11 = 1;
        if (n10) {
            Context context = this.context;
            AppCompatTextView appCompatTextView = new AppCompatTextView(context);
            this.helperTextView = appCompatTextView;
            int n12 = R$id.textinput_helper_text;
            appCompatTextView.setId(n12);
            appCompatTextView = this.typeface;
            if (appCompatTextView != null) {
                context = this.helperTextView;
                context.setTypeface((Typeface)appCompatTextView);
            }
            appCompatTextView = this.helperTextView;
            n12 = 4;
            appCompatTextView.setVisibility(n12);
            ViewCompat.setAccessibilityLiveRegion((View)this.helperTextView, n11);
            int n13 = this.helperTextTextAppearance;
            this.setHelperTextAppearance(n13);
            appCompatTextView = this.helperTextView;
            this.addIndicator(appCompatTextView, n11);
        } else {
            this.hideHelperText();
            TextView textView = this.helperTextView;
            this.removeIndicator(textView, n11);
            n11 = 0;
            this.helperTextView = null;
            this.textInputView.updateEditTextBackground();
            TextInputLayout textInputLayout = this.textInputView;
            textInputLayout.updateTextInputBoxState();
        }
        this.helperTextEnabled = n10;
    }

    public void setHelperTextViewTextColor(ColorStateList colorStateList) {
        TextView textView = this.helperTextView;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTypefaces(Typeface typeface) {
        Typeface typeface2 = this.typeface;
        if (typeface != typeface2) {
            this.typeface = typeface;
            typeface2 = this.errorView;
            this.setTextViewTypeface((TextView)typeface2, typeface);
            typeface2 = this.helperTextView;
            this.setTextViewTypeface((TextView)typeface2, typeface);
        }
    }

    public void showError(CharSequence charSequence) {
        this.cancelCaptionAnimator();
        this.errorText = charSequence;
        TextView textView = this.errorView;
        textView.setText(charSequence);
        int n10 = this.captionDisplayed;
        int n11 = 1;
        if (n10 != n11) {
            this.captionToShow = n11;
        }
        n11 = this.captionToShow;
        TextView textView2 = this.errorView;
        boolean bl2 = this.shouldAnimateCaptionView(textView2, charSequence);
        this.updateCaptionViewsVisibility(n10, n11, bl2);
    }

    public void showHelper(CharSequence charSequence) {
        this.cancelCaptionAnimator();
        this.helperText = charSequence;
        TextView textView = this.helperTextView;
        textView.setText(charSequence);
        int n10 = this.captionDisplayed;
        int n11 = 2;
        if (n10 != n11) {
            this.captionToShow = n11;
        }
        n11 = this.captionToShow;
        TextView textView2 = this.helperTextView;
        boolean bl2 = this.shouldAnimateCaptionView(textView2, charSequence);
        this.updateCaptionViewsVisibility(n10, n11, bl2);
    }
}

