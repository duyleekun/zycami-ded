/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.kwai.opensdk.sdk.openapi;

import android.text.TextUtils;
import com.kwai.opensdk.sdk.openapi.IKwaiAPIEventListener;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EventListenerManager {
    private static Map sMap;

    static {
        HashMap hashMap;
        sMap = hashMap = new HashMap(1);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void addListener(String string2, SoftReference softReference) {
        Class<EventListenerManager> clazz = EventListenerManager.class;
        synchronized (clazz) {
            Object object;
            void var1_1;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2 && var1_1 != null && (object = var1_1.get()) != null) {
                object = sMap;
                object.put((String)string2, var1_1);
                return;
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void clearListener(IKwaiAPIEventListener iKwaiAPIEventListener) {
        Class<EventListenerManager> clazz = EventListenerManager.class;
        synchronized (clazz) {
            if (iKwaiAPIEventListener == null) {
                return;
            }
            Iterator iterator2 = sMap;
            iterator2 = iterator2.keySet();
            iterator2 = iterator2.iterator();
            boolean bl2;
            while (bl2 = iterator2.hasNext()) {
                Object object = iterator2.next();
                boolean bl3 = TextUtils.isEmpty(object = (String)object);
                if (bl3) continue;
                Object object2 = sMap;
                if ((object2 = object2.get(object)) == null) continue;
                object2 = sMap;
                object2 = object2.get(object);
                object2 = (SoftReference)object2;
                if ((object2 = ((SoftReference)object2).get()) == null) continue;
                object2 = sMap;
                object2 = object2.get(object);
                object2 = (SoftReference)object2;
                object2 = ((SoftReference)object2).get();
                bl3 = (object2 = (IKwaiAPIEventListener)object2).equals(iKwaiAPIEventListener);
                if (!bl3) continue;
                object2 = sMap;
                object2.remove(object);
            }
            return;
        }
    }

    public static void clearListener(String string2) {
        Class<EventListenerManager> clazz = EventListenerManager.class;
        synchronized (clazz) {
            block5: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block5;
                return;
            }
            Map map = sMap;
            map.remove(string2);
            return;
        }
    }

    public static SoftReference getListener(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return null;
        }
        return (SoftReference)sMap.get(string2);
    }

    public static void release() {
        Class<EventListenerManager> clazz = EventListenerManager.class;
        synchronized (clazz) {
            Map map = sMap;
            map.clear();
            return;
        }
    }
}

