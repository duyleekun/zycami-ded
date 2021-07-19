/*
 * Decompiled with CFR 0.151.
 */
package androidx.appcompat.app;

import androidx.appcompat.app.AppCompatDelegateImpl;

public class AppCompatDelegateImpl$2
implements Runnable {
    public final /* synthetic */ AppCompatDelegateImpl this$0;

    public AppCompatDelegateImpl$2(AppCompatDelegateImpl appCompatDelegateImpl) {
        this.this$0 = appCompatDelegateImpl;
    }

    public void run() {
        AppCompatDelegateImpl appCompatDelegateImpl = this.this$0;
        int n10 = appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 1;
        if (n10 != 0) {
            appCompatDelegateImpl.doInvalidatePanelMenu(0);
        }
        appCompatDelegateImpl = this.this$0;
        n10 = appCompatDelegateImpl.mInvalidatePanelMenuFeatures & 0x1000;
        if (n10 != 0) {
            n10 = 108;
            appCompatDelegateImpl.doInvalidatePanelMenu(n10);
        }
        appCompatDelegateImpl = this.this$0;
        appCompatDelegateImpl.mInvalidatePanelMenuPosted = false;
        appCompatDelegateImpl.mInvalidatePanelMenuFeatures = 0;
    }
}

