/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Layout$Alignment
 */
package com.google.android.exoplayer2.ui;

import android.text.Layout;

public class WebViewSubtitleOutput$2 {
    public static final /* synthetic */ int[] $SwitchMap$android$text$Layout$Alignment;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        Layout.Alignment alignment;
        int n12 = Layout.Alignment.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$android$text$Layout$Alignment = nArray;
        try {
            alignment = Layout.Alignment.ALIGN_NORMAL;
            n11 = alignment.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$android$text$Layout$Alignment;
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
            n11 = alignment.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$android$text$Layout$Alignment;
            alignment = Layout.Alignment.ALIGN_CENTER;
            n11 = alignment.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

