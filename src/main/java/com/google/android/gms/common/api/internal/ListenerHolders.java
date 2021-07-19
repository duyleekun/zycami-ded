/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class ListenerHolders {
    private final Set zajo;

    public ListenerHolders() {
        Object object = new WeakHashMap();
        this.zajo = object = Collections.newSetFromMap(object);
    }

    public static ListenerHolder createListenerHolder(Object object, Looper looper, String string2) {
        Preconditions.checkNotNull(object, "Listener must not be null");
        Preconditions.checkNotNull(looper, "Looper must not be null");
        Preconditions.checkNotNull(string2, "Listener type must not be null");
        ListenerHolder listenerHolder = new ListenerHolder(looper, object, string2);
        return listenerHolder;
    }

    public static ListenerHolder$ListenerKey createListenerKey(Object object, String string2) {
        Preconditions.checkNotNull(object, "Listener must not be null");
        Preconditions.checkNotNull(string2, "Listener type must not be null");
        Preconditions.checkNotEmpty(string2, "Listener type must not be empty");
        ListenerHolder$ListenerKey listenerHolder$ListenerKey = new ListenerHolder$ListenerKey(object, string2);
        return listenerHolder$ListenerKey;
    }

    public final void release() {
        boolean bl2;
        Iterator iterator2 = this.zajo.iterator();
        while (bl2 = iterator2.hasNext()) {
            ListenerHolder listenerHolder = (ListenerHolder)iterator2.next();
            listenerHolder.clear();
        }
        this.zajo.clear();
    }

    public final ListenerHolder zaa(Object object, Looper looper, String string2) {
        object = ListenerHolders.createListenerHolder(object, looper, string2);
        this.zajo.add(object);
        return object;
    }
}

