/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.text.cea;

import android.text.Layout;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Cue$Builder;

public final class Cea708Decoder$Cea708CueInfo {
    public final Cue cue;
    public final int priority;

    public Cea708Decoder$Cea708CueInfo(CharSequence object, Layout.Alignment alignment, float f10, int n10, int n11, float f11, int n12, float f12, boolean bl2, int n13, int n14) {
        Cue$Builder cue$Builder = new Cue$Builder();
        object = cue$Builder.setText((CharSequence)object).setTextAlignment(alignment).setLine(f10, n10).setLineAnchor(n11).setPosition(f11).setPositionAnchor(n12).setSize(f12);
        if (bl2) {
            ((Cue$Builder)object).setWindowColor(n13);
        }
        this.cue = object = ((Cue$Builder)object).build();
        this.priority = n14;
    }
}

