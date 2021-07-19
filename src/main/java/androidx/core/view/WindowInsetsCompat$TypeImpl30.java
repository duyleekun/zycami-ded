/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.WindowInsets$Type
 */
package androidx.core.view;

import android.view.WindowInsets;

public final class WindowInsetsCompat$TypeImpl30 {
    private WindowInsetsCompat$TypeImpl30() {
    }

    public static int toPlatformType(int n10) {
        int n11;
        int n12 = 1;
        int n13 = 0;
        for (int i10 = n12; i10 <= (n11 = 256); i10 <<= 1) {
            n11 = n10 & i10;
            if (n11 == 0) continue;
            if (i10 != n12) {
                n11 = 2;
                if (i10 != n11) {
                    n11 = 4;
                    if (i10 != n11) {
                        n11 = 8;
                        if (i10 != n11) {
                            n11 = 16;
                            if (i10 != n11) {
                                n11 = 32;
                                if (i10 != n11) {
                                    n11 = 64;
                                    if (i10 != n11) {
                                        n11 = 128;
                                        if (i10 != n11) continue;
                                        n11 = WindowInsets.Type.displayCutout();
                                    } else {
                                        n11 = WindowInsets.Type.tappableElement();
                                    }
                                } else {
                                    n11 = WindowInsets.Type.mandatorySystemGestures();
                                }
                            } else {
                                n11 = WindowInsets.Type.systemGestures();
                            }
                        } else {
                            n11 = WindowInsets.Type.ime();
                        }
                    } else {
                        n11 = WindowInsets.Type.captionBar();
                    }
                } else {
                    n11 = WindowInsets.Type.navigationBars();
                }
            } else {
                n11 = WindowInsets.Type.statusBars();
            }
            n13 |= n11;
        }
        return n13;
    }
}

