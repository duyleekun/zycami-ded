/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.sina.weibo.sdk.net;

import android.os.Bundle;
import com.sina.weibo.sdk.net.d;
import com.sina.weibo.sdk.net.e$a;
import java.util.Map;

public final class e
implements d {
    private Bundle k;
    private Bundle l;
    private Map m;
    private Map n;
    private int o;
    private int p;
    private String url;

    public e(e$a e$a) {
        int n10;
        int n11;
        Object object = new Bundle();
        this.k = object;
        object = new Bundle();
        this.l = object;
        this.m = object;
        super();
        this.n = object;
        object = e$a.url;
        this.url = object;
        object = this.k;
        Object object2 = e$a.k;
        object.putAll(object2);
        object = this.l;
        object2 = e$a.l;
        object.putAll(object2);
        object = this.m;
        object2 = e$a.m;
        object.putAll(object2);
        object = this.n;
        object2 = e$a.n;
        object.putAll(object2);
        this.o = n11 = e$a.o;
        this.p = n10 = e$a.p;
    }

    public final int getConnectTimeout() {
        return this.o;
    }

    public final Bundle getParams() {
        return this.k;
    }

    public final int getReadTimeout() {
        return this.p;
    }

    public final String getUrl() {
        return this.url;
    }

    public final Bundle h() {
        return this.l;
    }
}

