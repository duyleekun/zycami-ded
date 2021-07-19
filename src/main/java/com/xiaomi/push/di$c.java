/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.az;
import com.xiaomi.push.di;
import com.xiaomi.push.di$b;
import com.xiaomi.push.service.be;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class di$c
extends di$b {
    public int a;
    public final /* synthetic */ di a;
    public File a;
    public String a;
    public boolean a;
    public String b;
    public boolean b;

    public di$c(di di2, String string2, String string3, File file, boolean bl2) {
        this.a = di2;
        super(di2);
        this.a = string2;
        this.b = string3;
        this.a = file;
        this.b = bl2;
    }

    private boolean c() {
        int n10;
        String string2 = "times";
        CharSequence charSequence = "time";
        Object object = di.a(this.a);
        int n11 = 0;
        object = object.getSharedPreferences("log.timestamp", 0);
        String string3 = "log.requst";
        String string4 = object.getString(string3, "");
        long l10 = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject(string4);
        l10 = jSONObject.getLong((String)charSequence);
        try {
            n10 = jSONObject.getInt(string2);
        }
        catch (JSONException jSONException) {
            n10 = 0;
            string4 = null;
        }
        long l11 = System.currentTimeMillis() - l10;
        long l12 = 86400000L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 < 0) {
            l13 = 10;
            if (n10 > l13) {
                return false;
            }
            n11 = n10;
        } else {
            l10 = System.currentTimeMillis();
        }
        string4 = new JSONObject();
        l13 = 1;
        string4.put((String)charSequence, l10);
        n11 += l13;
        string4.put(string2, n11);
        string2 = object.edit();
        charSequence = string4.toString();
        string2 = string2.putString(string3, (String)charSequence);
        try {
            string2.commit();
        }
        catch (JSONException jSONException) {
            charSequence = new StringBuilder();
            object = "JSONException on put ";
            ((StringBuilder)charSequence).append((String)object);
            String string5 = jSONException.getMessage();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            com.xiaomi.channel.commonutils.logger.b.c(string5);
        }
        return (boolean)l13;
    }

    public boolean a() {
        Context context = di.a(this.a);
        boolean bl2 = az.d(context);
        if (!(bl2 || (bl2 = this.b) && (bl2 = az.b(context = di.a(this.a))))) {
            bl2 = false;
            context = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void b() {
        boolean bl2;
        block16: {
            try {
                bl2 = this.c();
                if (!bl2) break block16;
            }
            catch (IOException iOException) {
                return;
            }
            HashMap<String, Object> hashMap = new HashMap<String, Object>();
            String string2 = "uid";
            Object object = be.a();
            hashMap.put(string2, object);
            string2 = "token";
            object = this.b;
            hashMap.put(string2, object);
            string2 = "net";
            object = this.a;
            object = di.a((di)object);
            object = az.a((Context)object);
            hashMap.put(string2, object);
            string2 = this.a;
            object = this.a;
            String string3 = "file";
            az.a(string2, hashMap, (File)object, string3);
        }
        bl2 = true;
        this.a = bl2;
    }

    public void c() {
        Object object;
        int n10 = this.a;
        int n11 = 3;
        int n12 = 1;
        if (n10 == 0) {
            this.a = n10 = this.a + n12;
            if (n10 < n11) {
                object = di.a(this.a);
                ((ConcurrentLinkedQueue)object).add(this);
            }
        }
        if ((n10 = this.a) != 0 || (n10 = this.a) >= n11) {
            object = this.a;
            ((File)object).delete();
        }
        object = this.a;
        n11 = this.a;
        long l10 = (n12 << n11) * 1000;
        di.a((di)object, l10);
    }
}

