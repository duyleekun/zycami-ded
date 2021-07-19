/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.BaseTransientBottomBar$6$1;
import com.google.android.material.snackbar.BaseTransientBottomBar$OnAttachStateChangeListener;

public class BaseTransientBottomBar$6
implements BaseTransientBottomBar$OnAttachStateChangeListener {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$6(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View object) {
        object = this.this$0;
        boolean bl2 = ((BaseTransientBottomBar)object).isShownOrQueued();
        if (bl2) {
            object = BaseTransientBottomBar.handler;
            BaseTransientBottomBar$6$1 baseTransientBottomBar$6$1 = new BaseTransientBottomBar$6$1(this);
            object.post((Runnable)baseTransientBottomBar$6$1);
        }
    }
}

