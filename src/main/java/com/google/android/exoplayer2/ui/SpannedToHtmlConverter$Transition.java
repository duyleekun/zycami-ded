/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

import java.util.ArrayList;
import java.util.List;

public final class SpannedToHtmlConverter$Transition {
    private final List spansAdded;
    private final List spansRemoved;

    public SpannedToHtmlConverter$Transition() {
        ArrayList arrayList;
        this.spansAdded = arrayList = new ArrayList();
        this.spansRemoved = arrayList = new ArrayList();
    }

    public static /* synthetic */ List access$100(SpannedToHtmlConverter$Transition spannedToHtmlConverter$Transition) {
        return spannedToHtmlConverter$Transition.spansRemoved;
    }

    public static /* synthetic */ List access$300(SpannedToHtmlConverter$Transition spannedToHtmlConverter$Transition) {
        return spannedToHtmlConverter$Transition.spansAdded;
    }
}

