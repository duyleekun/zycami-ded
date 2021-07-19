/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.appcompat.view;

import android.view.View;
import androidx.appcompat.view.ViewPropertyAnimatorCompatSet;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import java.util.ArrayList;

public class ViewPropertyAnimatorCompatSet$1
extends ViewPropertyAnimatorListenerAdapter {
    private int mProxyEndCount = 0;
    private boolean mProxyStarted = false;
    public final /* synthetic */ ViewPropertyAnimatorCompatSet this$0;

    public ViewPropertyAnimatorCompatSet$1(ViewPropertyAnimatorCompatSet viewPropertyAnimatorCompatSet) {
        this.this$0 = viewPropertyAnimatorCompatSet;
    }

    public void onAnimationEnd(View object) {
        int n10;
        this.mProxyEndCount = n10 = this.mProxyEndCount + 1;
        ArrayList arrayList = this.this$0.mAnimators;
        int n11 = arrayList.size();
        if (n10 == n11) {
            object = this.this$0.mListener;
            if (object != null) {
                n11 = 0;
                arrayList = null;
                object.onAnimationEnd(null);
            }
            this.onEnd();
        }
    }

    public void onAnimationStart(View object) {
        boolean bl2 = this.mProxyStarted;
        if (bl2) {
            return;
        }
        this.mProxyStarted = bl2 = true;
        object = this.this$0.mListener;
        if (object != null) {
            object.onAnimationStart(null);
        }
    }

    public void onEnd() {
        this.mProxyEndCount = 0;
        this.mProxyStarted = false;
        this.this$0.onAnimationsEnded();
    }
}

