/*
 * Decompiled with CFR 0.151.
 */
package androidx.drawerlayout.widget;

import androidx.drawerlayout.widget.DrawerLayout$ViewDragCallback;

public class DrawerLayout$ViewDragCallback$1
implements Runnable {
    public final /* synthetic */ DrawerLayout$ViewDragCallback this$1;

    public DrawerLayout$ViewDragCallback$1(DrawerLayout$ViewDragCallback viewDragCallback) {
        this.this$1 = viewDragCallback;
    }

    public void run() {
        this.this$1.peekDrawer();
    }
}

