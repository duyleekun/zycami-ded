/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.google.android.material.snackbar;

import android.view.View;
import com.google.android.material.behavior.SwipeDismissBehavior$OnDismissListener;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.SnackbarManager;
import com.google.android.material.snackbar.SnackbarManager$Callback;

public class BaseTransientBottomBar$5
implements SwipeDismissBehavior$OnDismissListener {
    public final /* synthetic */ BaseTransientBottomBar this$0;

    public BaseTransientBottomBar$5(BaseTransientBottomBar baseTransientBottomBar) {
        this.this$0 = baseTransientBottomBar;
    }

    public void onDismiss(View view) {
        view.setVisibility(8);
        this.this$0.dispatchDismiss(0);
    }

    public void onDragStateChanged(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11 || n10 == (n11 = 2)) {
                SnackbarManager snackbarManager = SnackbarManager.getInstance();
                SnackbarManager$Callback snackbarManager$Callback = this.this$0.managerCallback;
                snackbarManager.pauseTimeout(snackbarManager$Callback);
            }
        } else {
            SnackbarManager snackbarManager = SnackbarManager.getInstance();
            SnackbarManager$Callback snackbarManager$Callback = this.this$0.managerCallback;
            snackbarManager.restoreTimeoutIfPaused(snackbarManager$Callback);
        }
    }
}

