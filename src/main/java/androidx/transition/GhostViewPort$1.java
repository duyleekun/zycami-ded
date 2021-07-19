/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.view.ViewCompat;
import androidx.transition.GhostViewPort;

public class GhostViewPort$1
implements ViewTreeObserver.OnPreDrawListener {
    public final /* synthetic */ GhostViewPort this$0;

    public GhostViewPort$1(GhostViewPort ghostViewPort) {
        this.this$0 = ghostViewPort;
    }

    public boolean onPreDraw() {
        ViewCompat.postInvalidateOnAnimation((View)this.this$0);
        GhostViewPort ghostViewPort = this.this$0;
        ViewGroup viewGroup = ghostViewPort.mStartParent;
        if (viewGroup != null && (ghostViewPort = ghostViewPort.mStartView) != null) {
            viewGroup.endViewTransition((View)ghostViewPort);
            ViewCompat.postInvalidateOnAnimation((View)this.this$0.mStartParent);
            ghostViewPort = this.this$0;
            viewGroup = null;
            ghostViewPort.mStartParent = null;
            ghostViewPort.mStartView = null;
        }
        return true;
    }
}

