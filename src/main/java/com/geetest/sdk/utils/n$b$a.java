/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import com.geetest.sdk.utils.n;
import g.m;
import g.t;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class n$b$a
implements m {
    public List loadForRequest(t arrayList) {
        ConcurrentHashMap concurrentHashMap = n.a();
        arrayList = ((t)((Object)arrayList)).F();
        if ((arrayList = (List)concurrentHashMap.get(arrayList)) == null) {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public void saveFromResponse(t object, List list) {
        ConcurrentHashMap concurrentHashMap = n.a();
        object = ((t)object).F();
        concurrentHashMap.put(object, list);
    }
}

