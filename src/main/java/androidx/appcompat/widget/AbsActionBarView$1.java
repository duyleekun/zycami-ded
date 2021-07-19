/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.AbsActionBarView;

public class AbsActionBarView$1
implements Runnable {
    public final /* synthetic */ AbsActionBarView this$0;

    public AbsActionBarView$1(AbsActionBarView absActionBarView) {
        this.this$0 = absActionBarView;
    }

    public void run() {
        this.this$0.showOverflowMenu();
    }
}

