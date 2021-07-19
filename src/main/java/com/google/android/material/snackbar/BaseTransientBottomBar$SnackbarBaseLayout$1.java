/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.snackbar;

import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;

public class BaseTransientBottomBar$SnackbarBaseLayout$1
implements AccessibilityManagerCompat$TouchExplorationStateChangeListener {
    public final /* synthetic */ BaseTransientBottomBar$SnackbarBaseLayout this$0;

    public BaseTransientBottomBar$SnackbarBaseLayout$1(BaseTransientBottomBar$SnackbarBaseLayout baseTransientBottomBar$SnackbarBaseLayout) {
        this.this$0 = baseTransientBottomBar$SnackbarBaseLayout;
    }

    public void onTouchExplorationStateChanged(boolean bl2) {
        BaseTransientBottomBar$SnackbarBaseLayout.access$300(this.this$0, bl2);
    }
}

