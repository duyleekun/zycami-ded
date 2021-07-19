/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;
import com.google.android.exoplayer2.ui.SubtitlePainter;
import com.google.android.exoplayer2.ui.SubtitleView$Output;
import com.google.android.exoplayer2.ui.SubtitleViewUtils;
import java.util.Collections;
import java.util.List;

public final class CanvasSubtitleOutput
extends View
implements SubtitleView$Output {
    private float bottomPaddingFraction;
    private List cues;
    private final List painters;
    private CaptionStyleCompat style;
    private float textSize;
    private int textSizeType;

    public CanvasSubtitleOutput(Context context) {
        this(context, null);
    }

    public CanvasSubtitleOutput(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super();
        this.painters = object;
        object = Collections.emptyList();
        this.cues = object;
        this.textSizeType = 0;
        this.textSize = 0.0533f;
        object = CaptionStyleCompat.DEFAULT;
        this.style = object;
        this.bottomPaddingFraction = 0.08f;
    }

    private static Cue repositionVerticalCue(Cue cue) {
        Cue$Builder cue$Builder = cue.buildUpon().setPosition(-3.4028235E38f).setPositionAnchor(-1 << -1);
        float f10 = 0.0f;
        cue$Builder = cue$Builder.setTextAlignment(null);
        int n10 = cue.lineType;
        int n11 = 1065353216;
        float f11 = 1.0f;
        if (n10 == 0) {
            f10 = cue.line;
            cue$Builder.setLine(f11 -= f10, 0);
        } else {
            f10 = -cue.line - f11;
            n11 = 1;
            f11 = Float.MIN_VALUE;
            cue$Builder.setLine(f10, n11);
        }
        int n12 = cue.lineAnchor;
        n10 = 2;
        f10 = 2.8E-45f;
        if (n12 != 0) {
            if (n12 == n10) {
                cue$Builder.setLineAnchor(0);
            }
        } else {
            cue$Builder.setLineAnchor(n10);
        }
        return cue$Builder.build();
    }

    public void dispatchDraw(Canvas canvas) {
        CanvasSubtitleOutput canvasSubtitleOutput = this;
        List list = this.cues;
        int n10 = list.isEmpty();
        if (n10 != 0) {
            return;
        }
        n10 = this.getHeight();
        int n11 = this.getPaddingLeft();
        int n12 = this.getPaddingTop();
        int n13 = this.getWidth();
        int n14 = this.getPaddingRight();
        int n15 = n13 - n14;
        n13 = this.getPaddingBottom();
        int n16 = n10 - n13;
        if (n16 > n12 && n15 > n11) {
            int n17 = n16 - n12;
            n13 = this.textSizeType;
            float f10 = this.textSize;
            float f11 = SubtitleViewUtils.resolveTextSize(n13, f10, n10, n17);
            Object object = null;
            float f12 = f11 - 0.0f;
            n13 = (int)(f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1));
            if (n13 <= 0) {
                return;
            }
            int n18 = list.size();
            n13 = 0;
            object = null;
            for (int i10 = 0; i10 < n18; ++i10) {
                object = (Cue)list.get(i10);
                n14 = ((Cue)object).verticalType;
                int n19 = -1 << -1;
                float f13 = -0.0f;
                if (n14 != n19) {
                    object = CanvasSubtitleOutput.repositionVerticalCue((Cue)object);
                }
                Cue cue = object;
                n13 = ((Cue)object).textSizeType;
                f13 = ((Cue)object).textSize;
                float f14 = SubtitleViewUtils.resolveTextSize(n13, f13, n10, n17);
                object = (SubtitlePainter)canvasSubtitleOutput.painters.get(i10);
                CaptionStyleCompat captionStyleCompat = canvasSubtitleOutput.style;
                float f15 = canvasSubtitleOutput.bottomPaddingFraction;
                int n20 = n18;
                n18 = n11;
                int n21 = n17;
                n17 = n12;
                int n22 = n16;
                n16 = n15;
                int n23 = n15;
                n15 = n22;
                ((SubtitlePainter)object).draw(cue, captionStyleCompat, f11, f14, f15, canvas, n11, n12, n16, n22);
                n18 = n20;
                n17 = n21;
                n16 = n22;
                n15 = n23;
            }
        }
    }

    public void update(List list, CaptionStyleCompat object, float f10, int n10, float f11) {
        int n11;
        int n12;
        this.cues = list;
        this.style = object;
        this.textSize = f10;
        this.textSizeType = n10;
        this.bottomPaddingFraction = f11;
        while ((n12 = (object = this.painters).size()) < (n11 = list.size())) {
            object = this.painters;
            Context context = this.getContext();
            SubtitlePainter subtitlePainter = new SubtitlePainter(context);
            object.add(subtitlePainter);
        }
        this.invalidate();
    }
}

