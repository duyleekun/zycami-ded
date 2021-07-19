/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Message;
import com.google.android.material.snackbar.BaseTransientBottomBar;

public final class BaseTransientBottomBar$1
implements Handler.Callback {
    public boolean handleMessage(Message message) {
        boolean bl2 = message.what;
        boolean bl3 = true;
        if (bl2) {
            if (bl2 != bl3) {
                return false;
            }
            BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar)message.obj;
            int n10 = message.arg1;
            baseTransientBottomBar.hideView(n10);
            return bl3;
        }
        ((BaseTransientBottomBar)message.obj).showView();
        return bl3;
    }
}

