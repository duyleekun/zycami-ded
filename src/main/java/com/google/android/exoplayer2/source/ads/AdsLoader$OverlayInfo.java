/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.exoplayer2.source.ads;

import android.view.View;

public final class AdsLoader$OverlayInfo {
    public static final int PURPOSE_CLOSE_AD = 1;
    public static final int PURPOSE_CONTROLS = 0;
    public static final int PURPOSE_NOT_VISIBLE = 3;
    public static final int PURPOSE_OTHER = 2;
    public final int purpose;
    public final String reasonDetail;
    public final View view;

    public AdsLoader$OverlayInfo(View view, int n10) {
        this(view, n10, null);
    }

    public AdsLoader$OverlayInfo(View view, int n10, String string2) {
        this.view = view;
        this.purpose = n10;
        this.reasonDetail = string2;
    }
}

