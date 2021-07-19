/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.activity.internal;

import android.text.TextUtils;
import com.huawei.hms.activity.internal.BusResponseCallback;
import java.util.HashMap;
import java.util.Map;

public class ForegroundBusResponseMgr {
    private static final ForegroundBusResponseMgr instance;
    private final Map callbackMap;

    static {
        ForegroundBusResponseMgr foregroundBusResponseMgr;
        instance = foregroundBusResponseMgr = new ForegroundBusResponseMgr();
    }

    public ForegroundBusResponseMgr() {
        HashMap hashMap;
        this.callbackMap = hashMap = new HashMap();
    }

    public static ForegroundBusResponseMgr getInstance() {
        return instance;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public BusResponseCallback get(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        Map map = this.callbackMap;
        synchronized (map) {
            Map map2 = this.callbackMap;
            object = map2.get(object);
            return (BusResponseCallback)object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void registerObserver(String string2, BusResponseCallback busResponseCallback) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) return;
        if (busResponseCallback == null) {
            return;
        }
        Map map = this.callbackMap;
        synchronized (map) {
            Map map2 = this.callbackMap;
            boolean bl3 = map2.containsKey(string2);
            if (bl3) return;
            map2 = this.callbackMap;
            map2.put(string2, busResponseCallback);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void unRegisterObserver(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return;
        }
        Map map = this.callbackMap;
        synchronized (map) {
            Map map2 = this.callbackMap;
            map2.remove(string2);
            return;
        }
    }
}

