/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  androidx.viewpager2.widget.AnimateLayoutChangeDetector
 */
package androidx.viewpager2.widget;

import androidx.viewpager2.widget.AnimateLayoutChangeDetector;
import java.util.Comparator;

public class AnimateLayoutChangeDetector$1
implements Comparator {
    public final /* synthetic */ AnimateLayoutChangeDetector this$0;

    public AnimateLayoutChangeDetector$1(AnimateLayoutChangeDetector animateLayoutChangeDetector) {
        this.this$0 = animateLayoutChangeDetector;
    }

    public int compare(int[] nArray, int[] nArray2) {
        int n10 = nArray[0];
        int n11 = nArray2[0];
        return n10 - n11;
    }
}

