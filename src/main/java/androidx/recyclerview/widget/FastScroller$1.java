/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.FastScroller;

public class FastScroller$1
implements Runnable {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$1(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void run() {
        this.this$0.hide(500);
    }
}

