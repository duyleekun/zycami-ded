/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.text.TextUtils;
import com.baidu.location.b.aa;
import com.baidu.location.b.ab;
import com.baidu.location.b.m;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class ab$b
extends f {
    public boolean a = false;
    public long b = 0L;
    public final /* synthetic */ ab c;
    private boolean d = false;
    private String e = null;

    public ab$b(ab hashMap) {
        this.c = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String object, long l10) {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        this.e = object;
        this.b = l10;
        object = aa.a().c();
        String string2 = "https://ofloc.map.baidu.com/locnu";
        if (object != null) {
            this.a((ExecutorService)object, string2);
        } else {
            this.e(string2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object;
        if (bl2 && (object = this.j) != null) {
            try {
                String string2 = this.j;
                object = new JSONObject(string2);
                this.a = bl2 = true;
            }
            catch (Throwable throwable) {}
        }
        if ((object = this.k) != null) {
            object.clear();
        }
        this.d = false;
    }

    public boolean a() {
        return this.d;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        Object object;
        String string2 = "utf-8";
        Object object2 = com.baidu.location.h.b.a().c();
        if (object2 != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append("&gnsst=");
            long l10 = this.b;
            ((StringBuilder)object).append(l10);
            object2 = ((StringBuilder)object).toString();
        }
        object = com.baidu.location.b.m.a();
        object2 = ((m)object).a((String)object2);
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        String string3 = "";
        String string4 = "\r|\n";
        String string5 = "null";
        object2 = !bl2 ? ((String)object2).trim().replaceAll(string4, string3) : string5;
        object = com.baidu.location.b.m.a();
        String string6 = this.e;
        boolean bl3 = TextUtils.isEmpty((CharSequence)(object = ((m)object).a(string6)));
        if (!bl3) {
            object = ((String)object).trim();
            string5 = ((String)object).replaceAll(string4, string3);
        }
        try {
            object = this.k;
            string3 = "info";
        }
        catch (Exception exception) {
            return;
        }
        object2 = URLEncoder.encode((String)object2, string2);
        object.put(string3, object2);
        object2 = this.k;
        object = "enl";
        string2 = URLEncoder.encode(string5, string2);
        object2.put(object, string2);
    }
}

