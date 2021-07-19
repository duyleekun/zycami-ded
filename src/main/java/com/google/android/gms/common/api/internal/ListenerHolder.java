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
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.api.internal.ListenerHolder$Notifier;
import com.google.android.gms.common.api.internal.ListenerHolder$zaa;
import com.google.android.gms.common.internal.Preconditions;

public final class ListenerHolder {
    private final ListenerHolder$zaa zajj;
    private volatile Object zajk;
    private final ListenerHolder$ListenerKey zajl;

    public ListenerHolder(Looper object, Object object2, String string2) {
        ListenerHolder$zaa listenerHolder$zaa;
        this.zajj = listenerHolder$zaa = new ListenerHolder$zaa(this, (Looper)object);
        object = Preconditions.checkNotNull(object2, "Listener must not be null");
        this.zajk = object;
        string2 = Preconditions.checkNotEmpty(string2);
        super(object2, string2);
        this.zajl = object;
    }

    public final void clear() {
        this.zajk = null;
    }

    public final ListenerHolder$ListenerKey getListenerKey() {
        return this.zajl;
    }

    public final boolean hasListener() {
        Object object = this.zajk;
        return object != null;
    }

    public final void notifyListener(ListenerHolder$Notifier listenerHolder$Notifier) {
        Preconditions.checkNotNull(listenerHolder$Notifier, "Notifier must not be null");
        listenerHolder$Notifier = this.zajj.obtainMessage(1, listenerHolder$Notifier);
        this.zajj.sendMessage((Message)listenerHolder$Notifier);
    }

    public final void notifyListenerInternal(ListenerHolder$Notifier listenerHolder$Notifier) {
        Object object = this.zajk;
        if (object == null) {
            listenerHolder$Notifier.onNotifyListenerFailed();
            return;
        }
        try {
            listenerHolder$Notifier.notifyListener(object);
            return;
        }
        catch (RuntimeException runtimeException) {
            listenerHolder$Notifier.onNotifyListenerFailed();
            throw runtimeException;
        }
    }
}

