/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.Toolbar;

public class Toolbar$2
implements Runnable {
    public final /* synthetic */ Toolbar this$0;

    public Toolbar$2(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public void run() {
        this.this$0.showOverflowMenu();
    }
}

