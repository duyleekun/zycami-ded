/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.os.Message
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder$Notifier;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.base.zap;

public final class ListenerHolder$zaa
extends zap {
    private final /* synthetic */ ListenerHolder zajm;

    public ListenerHolder$zaa(ListenerHolder listenerHolder, Looper looper) {
        this.zajm = listenerHolder;
        super(looper);
    }

    public final void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        Preconditions.checkArgument(n11 != 0);
        ListenerHolder listenerHolder = this.zajm;
        object = (ListenerHolder$Notifier)object.obj;
        listenerHolder.notifyListenerInternal((ListenerHolder$Notifier)object);
    }
}

