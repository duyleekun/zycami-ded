/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.text.SpannableString
 *  android.text.Spanned
 *  android.text.style.AbsoluteSizeSpan
 *  android.text.style.RelativeSizeSpan
 *  android.util.AttributeSet
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.View
 *  android.view.accessibility.CaptioningManager
 *  android.widget.FrameLayout
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.ui.CanvasSubtitleOutput;
import com.google.android.exoplayer2.ui.SubtitleView$Output;
import com.google.android.exoplayer2.ui.WebViewSubtitleOutput;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SubtitleView
extends FrameLayout
implements TextOutput {
    public static final float DEFAULT_BOTTOM_PADDING_FRACTION = 0.08f;
    public static final float DEFAULT_TEXT_SIZE_FRACTION = 0.0533f;
    public static final int VIEW_TYPE_CANVAS = 1;
    public static final int VIEW_TYPE_WEB = 2;
    private boolean applyEmbeddedFontSizes;
    private boolean applyEmbeddedStyles;
    private float bottomPaddingFraction;
    private List cues;
    private float defaultTextSize;
    private int defaultTextSizeType;
    private View innerSubtitleView;
    private SubtitleView$Output output;
    private CaptionStyleCompat style;
    private int viewType;

    public SubtitleView(Context context) {
        this(context, null);
    }

    public SubtitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        boolean bl2;
        Object object = Collections.emptyList();
        this.cues = object;
        this.style = object = CaptionStyleCompat.DEFAULT;
        this.defaultTextSizeType = 0;
        this.defaultTextSize = 0.0533f;
        this.bottomPaddingFraction = 0.08f;
        this.applyEmbeddedStyles = bl2 = true;
        this.applyEmbeddedFontSizes = bl2;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, attributeSet);
        this.output = canvasSubtitleOutput;
        this.innerSubtitleView = canvasSubtitleOutput;
        this.addView(canvasSubtitleOutput);
        this.viewType = (int)(bl2 ? 1 : 0);
    }

    private List getCuesWithStylingPreferencesApplied() {
        Object object;
        int n10;
        boolean bl2 = this.applyEmbeddedStyles;
        if (bl2 && (bl2 = this.applyEmbeddedFontSizes)) {
            return this.cues;
        }
        int n11 = this.cues.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (n11 = 0; n11 < (n10 = (object = this.cues).size()); ++n11) {
            object = (Cue)this.cues.get(n11);
            object = this.removeEmbeddedStyling((Cue)object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        int n10 = Util.SDK_INT;
        float f10 = 1.0f;
        int n11 = 19;
        if (n10 >= n11 && (n10 = (int)(this.isInEditMode() ? 1 : 0)) == 0) {
            Context context = this.getContext();
            String string2 = "captioning";
            if ((context = (CaptioningManager)context.getSystemService(string2)) != null && (n11 = (int)(context.isEnabled() ? 1 : 0)) != 0) {
                f10 = context.getFontScale();
            }
        }
        return f10;
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        int n10 = Util.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (n10 = (int)(this.isInEditMode() ? 1 : 0)) == 0) {
            Object object = this.getContext();
            String string2 = "captioning";
            object = (object = (CaptioningManager)object.getSystemService(string2)) != null && (n11 = (int)(object.isEnabled() ? 1 : 0)) != 0 ? CaptionStyleCompat.createFromCaptionStyle(object.getUserStyle()) : CaptionStyleCompat.DEFAULT;
            return object;
        }
        return CaptionStyleCompat.DEFAULT;
    }

    private Cue removeEmbeddedStyling(Cue object) {
        CharSequence charSequence = ((Cue)object).text;
        int n10 = this.applyEmbeddedStyles;
        int n11 = -1 << -1;
        int n12 = -8388609;
        float f10 = -3.4028235E38f;
        if (n10 == 0) {
            object = ((Cue)object).buildUpon().setTextSize(f10, n11).clearWindowColor();
            if (charSequence != null) {
                charSequence = charSequence.toString();
                ((Cue$Builder)object).setText(charSequence);
            }
            return ((Cue$Builder)object).build();
        }
        n10 = this.applyEmbeddedFontSizes;
        if (n10 == 0) {
            if (charSequence == null) {
                return object;
            }
            object = ((Cue)object).buildUpon().setTextSize(f10, n11);
            n10 = charSequence instanceof Spanned;
            if (n10 != 0) {
                charSequence = SpannableString.valueOf((CharSequence)charSequence);
                n10 = charSequence.length();
                Class<AbsoluteSizeSpan> clazz = AbsoluteSizeSpan.class;
                n12 = 0;
                f10 = 0.0f;
                AbsoluteSizeSpan[] absoluteSizeSpanArray = (AbsoluteSizeSpan[])charSequence.getSpans(0, n10, clazz);
                n11 = absoluteSizeSpanArray.length;
                AbsoluteSizeSpan absoluteSizeSpan = null;
                for (int i10 = 0; i10 < n11; ++i10) {
                    AbsoluteSizeSpan absoluteSizeSpan2 = absoluteSizeSpanArray[i10];
                    charSequence.removeSpan(absoluteSizeSpan2);
                }
                n10 = charSequence.length();
                clazz = RelativeSizeSpan.class;
                absoluteSizeSpanArray = (RelativeSizeSpan[])charSequence.getSpans(0, n10, clazz);
                n11 = absoluteSizeSpanArray.length;
                while (n12 < n11) {
                    absoluteSizeSpan = absoluteSizeSpanArray[n12];
                    charSequence.removeSpan(absoluteSizeSpan);
                    ++n12;
                }
                ((Cue$Builder)object).setText(charSequence);
            }
            object = ((Cue$Builder)object).build();
        }
        return object;
    }

    private void setTextSize(int n10, float f10) {
        this.defaultTextSizeType = n10;
        this.defaultTextSize = f10;
        this.updateOutput();
    }

    private void setView(View view) {
        Object object = this.innerSubtitleView;
        this.removeView((View)object);
        object = this.innerSubtitleView;
        boolean bl2 = object instanceof WebViewSubtitleOutput;
        if (bl2) {
            object = (WebViewSubtitleOutput)object;
            ((WebViewSubtitleOutput)object).destroy();
        }
        this.innerSubtitleView = view;
        object = view;
        this.output = object = (SubtitleView$Output)view;
        this.addView(view);
    }

    private void updateOutput() {
        SubtitleView$Output subtitleView$Output = this.output;
        List list = this.getCuesWithStylingPreferencesApplied();
        CaptionStyleCompat captionStyleCompat = this.style;
        float f10 = this.defaultTextSize;
        int n10 = this.defaultTextSizeType;
        float f11 = this.bottomPaddingFraction;
        subtitleView$Output.update(list, captionStyleCompat, f10, n10, f11);
    }

    public void onCues(List list) {
        this.setCues(list);
    }

    public void setApplyEmbeddedFontSizes(boolean bl2) {
        this.applyEmbeddedFontSizes = bl2;
        this.updateOutput();
    }

    public void setApplyEmbeddedStyles(boolean bl2) {
        this.applyEmbeddedStyles = bl2;
        this.updateOutput();
    }

    public void setBottomPaddingFraction(float f10) {
        this.bottomPaddingFraction = f10;
        this.updateOutput();
    }

    public void setCues(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.cues = list;
        this.updateOutput();
    }

    public void setFixedTextSize(int n10, float f10) {
        Context context = this.getContext();
        context = context == null ? Resources.getSystem() : context.getResources();
        context = context.getDisplayMetrics();
        float f11 = TypedValue.applyDimension((int)n10, (float)f10, (DisplayMetrics)context);
        this.setTextSize(2, f11);
    }

    public void setFractionalTextSize(float f10) {
        this.setFractionalTextSize(f10, false);
    }

    public void setFractionalTextSize(float f10, boolean bl2) {
        this.setTextSize((int)(bl2 ? 1 : 0), f10);
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.style = captionStyleCompat;
        this.updateOutput();
    }

    public void setUserDefaultStyle() {
        CaptionStyleCompat captionStyleCompat = this.getUserCaptionStyle();
        this.setStyle(captionStyleCompat);
    }

    public void setUserDefaultTextSize() {
        float f10 = this.getUserCaptionFontScale() * 0.0533f;
        this.setFractionalTextSize(f10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void setViewType(int n10) {
        int n11 = this.viewType;
        if (n11 == n10) {
            return;
        }
        n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                throw illegalArgumentException;
            }
            Context context = this.getContext();
            WebViewSubtitleOutput webViewSubtitleOutput = new WebViewSubtitleOutput(context);
            this.setView((View)webViewSubtitleOutput);
        } else {
            Context context = this.getContext();
            CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context);
            this.setView(canvasSubtitleOutput);
        }
        this.viewType = n10;
    }
}

