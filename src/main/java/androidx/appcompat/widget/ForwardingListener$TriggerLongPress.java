/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.widget;

import androidx.appcompat.widget.ForwardingListener;

public class ForwardingListener$TriggerLongPress
implements Runnable {
    public final /* synthetic */ ForwardingListener this$0;

    public ForwardingListener$TriggerLongPress(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    public void run() {
        this.this$0.onLongPress();
    }
}

