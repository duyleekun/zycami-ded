/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ViewParent
 */
package androidx.appcompat.widget;

import android.view.ViewParent;
import androidx.appcompat.widget.ForwardingListener;

public class ForwardingListener$DisallowIntercept
implements Runnable {
    public final /* synthetic */ ForwardingListener this$0;

    public ForwardingListener$DisallowIntercept(ForwardingListener forwardingListener) {
        this.this$0 = forwardingListener;
    }

    public void run() {
        ViewParent viewParent = this.this$0.mSrc.getParent();
        if (viewParent != null) {
            boolean bl2 = true;
            viewParent.requestDisallowInterceptTouchEvent(bl2);
        }
    }
}

