/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.TooltipCompatHandler;

public class TooltipCompatHandler$1
implements Runnable {
    public final /* synthetic */ TooltipCompatHandler this$0;

    public TooltipCompatHandler$1(TooltipCompatHandler tooltipCompatHandler) {
        this.this$0 = tooltipCompatHandler;
    }

    public void run() {
        this.this$0.show(false);
    }
}

