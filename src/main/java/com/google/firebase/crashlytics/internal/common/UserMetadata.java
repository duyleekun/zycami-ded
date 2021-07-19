/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.common.UserMetadata$1;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMetadata {
    public static final int MAX_ATTRIBUTES = 64;
    public static final int MAX_ATTRIBUTE_SIZE = 1024;
    private final Map attributes;
    private String userId = null;

    public UserMetadata() {
        HashMap hashMap;
        this.attributes = hashMap = new HashMap();
    }

    public static /* synthetic */ String access$000(String string2) {
        return UserMetadata.sanitizeKey(string2);
    }

    public static /* synthetic */ String access$100(String string2) {
        return UserMetadata.sanitizeAttribute(string2);
    }

    private static String sanitizeAttribute(String string2) {
        int n10;
        int n11;
        if (string2 != null && (n11 = (string2 = string2.trim()).length()) > (n10 = 1024)) {
            n11 = 0;
            string2 = string2.substring(0, n10);
        }
        return string2;
    }

    private static String sanitizeKey(String object) {
        if (object != null) {
            return UserMetadata.sanitizeAttribute((String)object);
        }
        object = new IllegalArgumentException("Custom attribute key must not be null.");
        throw object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setSyncCustomKeys(Map list) {
        synchronized (this) {
            Object object;
            Object object2;
            boolean bl2;
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            list = list.entrySet();
            list = list.iterator();
            while (bl2 = list.hasNext()) {
                object2 = list.next();
                object2 = (Map.Entry)object2;
                object = object2.getKey();
                object = (String)object;
                object = UserMetadata.sanitizeKey(object);
                Object object3 = object2.getValue();
                if (object3 == null) {
                    object2 = "";
                } else {
                    object2 = object2.getValue();
                    object2 = (String)object2;
                    object2 = UserMetadata.sanitizeAttribute(object2);
                }
                object3 = this.attributes;
                boolean bl3 = object3.containsKey(object);
                if (bl3) {
                    hashMap.put(object, object2);
                    continue;
                }
                hashMap2.put(object, object2);
            }
            list = this.attributes;
            list.putAll(hashMap);
            list = this.attributes;
            int n10 = list.size();
            int n11 = hashMap2.size();
            n10 += n11;
            n11 = 64;
            if (n10 > n11) {
                list = this.attributes;
                n10 = list.size();
                list = Logger.getLogger();
                object2 = "Exceeded maximum number of custom attributes (64).";
                ((Logger)((Object)list)).v((String)object2);
                object2 = hashMap2.keySet();
                list = new List(object2);
                object2 = hashMap2.keySet();
                object = null;
                list = list.subList(0, n11 -= n10);
                object2.retainAll(list);
            }
            list = this.attributes;
            list.putAll(hashMap2);
            return;
        }
    }

    public Map getCustomKeys() {
        return Collections.unmodifiableMap(this.attributes);
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCustomKey(String string2, String string3) {
        UserMetadata$1 userMetadata$1 = new UserMetadata$1(this, string2, string3);
        this.setSyncCustomKeys(userMetadata$1);
    }

    public void setCustomKeys(Map map) {
        this.setSyncCustomKeys(map);
    }

    public void setUserId(String string2) {
        this.userId = string2 = UserMetadata.sanitizeAttribute(string2);
    }
}

