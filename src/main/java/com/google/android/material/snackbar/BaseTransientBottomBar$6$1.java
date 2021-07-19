/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.BaseTransientBottomBar$6;

public class BaseTransientBottomBar$6$1
implements Runnable {
    public final /* synthetic */ BaseTransientBottomBar$6 this$1;

    public BaseTransientBottomBar$6$1(BaseTransientBottomBar$6 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        this.this$1.this$0.onViewHidden(3);
    }
}

