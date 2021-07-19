/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.snackbar;

import com.google.android.material.snackbar.SnackbarManager$Callback;
import java.lang.ref.WeakReference;

public class SnackbarManager$SnackbarRecord {
    public final WeakReference callback;
    public int duration;
    public boolean paused;

    public SnackbarManager$SnackbarRecord(int n10, SnackbarManager$Callback snackbarManager$Callback) {
        WeakReference<SnackbarManager$Callback> weakReference;
        this.callback = weakReference = new WeakReference<SnackbarManager$Callback>(snackbarManager$Callback);
        this.duration = n10;
    }

    public boolean isSnackbar(SnackbarManager$Callback snackbarManager$Callback) {
        boolean bl2;
        Object t10;
        if (snackbarManager$Callback != null && (t10 = this.callback.get()) == snackbarManager$Callback) {
            bl2 = true;
        } else {
            bl2 = false;
            snackbarManager$Callback = null;
        }
        return bl2;
    }
}

