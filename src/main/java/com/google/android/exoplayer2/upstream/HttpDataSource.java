/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Predicate;
import d.h.a.a.q0.d;
import java.util.Map;

public interface HttpDataSource
extends DataSource {
    public static final Predicate REJECT_PAYWALL_TYPES = d.a;

    public static /* synthetic */ boolean a(String string2) {
        boolean bl2;
        String string3;
        boolean bl3 = TextUtils.isEmpty((CharSequence)(string2 = Util.toLowerInvariant(string2)));
        if (!(bl3 || (bl3 = string2.contains(string3 = "text")) && !(bl3 = string2.contains(string3 = "text/vtt")) || (bl3 = string2.contains(string3 = "html")) || (bl2 = string2.contains(string3 = "xml")))) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        return bl2;
    }

    public void clearAllRequestProperties();

    public void clearRequestProperty(String var1);

    public void close();

    public int getResponseCode();

    public Map getResponseHeaders();

    public long open(DataSpec var1);

    public int read(byte[] var1, int var2, int var3);

    public void setRequestProperty(String var1, String var2);
}

