/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.apache.http.NameValuePair
 */
package com.xiaomi.push;

import java.util.Comparator;
import org.apache.http.NameValuePair;

public final class cs
implements Comparator {
    public int a(NameValuePair object, NameValuePair object2) {
        object = object.getName();
        object2 = object2.getName();
        return ((String)object).compareTo((String)object2);
    }

    public /* synthetic */ int compare(Object object, Object object2) {
        object = (NameValuePair)object;
        object2 = (NameValuePair)object2;
        return this.a((NameValuePair)object, (NameValuePair)object2);
    }
}

