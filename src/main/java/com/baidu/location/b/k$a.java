/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentValues
 *  android.database.sqlite.SQLiteDatabase
 *  android.os.Bundle
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.k;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class k$a
extends f {
    public final /* synthetic */ k a;
    private String b = null;
    private String c = null;
    private boolean d = true;
    private boolean e = false;

    public k$a(k hashMap) {
        this.a = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String object, String string2) {
        k k10 = this.a;
        boolean bl2 = com.baidu.location.b.k.c(k10);
        if (!bl2) {
            k10 = this.a;
            boolean bl3 = true;
            com.baidu.location.b.k.a(k10, bl3);
            this.b = object;
            this.c = string2;
            object = aa.a().c();
            if (object != null) {
                string2 = com.baidu.location.h.l.f;
                this.a((ExecutorService)object, string2);
            } else {
                object = com.baidu.location.h.l.f;
                this.e((String)object);
            }
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object;
        block11: {
            int n10;
            Object object2;
            String string2;
            String string3;
            block12: {
                string3 = "hstdata";
                string2 = "mac";
                object2 = "content";
                Object object3 = "imo";
                if (bl2 && (object = this.j) != null) {
                    long l10;
                    boolean bl3;
                    int n11 = this.d;
                    if (n11 == 0) break block11;
                    JSONObject jSONObject = new JSONObject((String)object);
                    boolean bl4 = jSONObject.has((String)object2);
                    if (bl4) {
                        object = jSONObject.getJSONObject((String)object2);
                    } else {
                        boolean bl5 = false;
                        object = null;
                    }
                    if (object == null || !(bl3 = object.has((String)object3))) break block11;
                    object2 = object.getJSONObject((String)object3);
                    object2 = object2.getString(string2);
                    object2 = Long.valueOf((String)object2);
                    object = object.getJSONObject((String)object3);
                    object3 = "mv";
                    n10 = object.getInt((String)object3);
                    object3 = this.b;
                    long l11 = (Long)(object3 = Jni.encode3((String)object3));
                    long l12 = l11 - (l10 = ((Long)object2).longValue());
                    Object object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object4 != false) break block11;
                    object3 = new ContentValues();
                    String string4 = "tt";
                    l10 = System.currentTimeMillis();
                    long l13 = 1000L;
                    int n12 = (int)(l10 /= l13);
                    Object object5 = n12;
                    object3.put(string4, (Integer)object5);
                    String string5 = "hst";
                    object5 = n10;
                    object3.put(string5, (Integer)object5);
                    k k10 = this.a;
                    SQLiteDatabase sQLiteDatabase = com.baidu.location.b.k.a(k10);
                    object5 = new StringBuilder();
                    String string6 = "id = \"";
                    ((StringBuilder)object5).append(string6);
                    ((StringBuilder)object5).append(object2);
                    string6 = "\"";
                    ((StringBuilder)object5).append(string6);
                    object5 = ((StringBuilder)object5).toString();
                    n11 = sQLiteDatabase.update(string3, (ContentValues)object3, (String)object5, null);
                    if (n11 <= 0) {
                        String string7 = "id";
                        object3.put(string7, (Long)object2);
                        object2 = this.a;
                        object2 = com.baidu.location.b.k.a((k)object2);
                        object2.insert(string3, null, (ContentValues)object3);
                    }
                    break block12;
                }
                boolean bl6 = this.d;
                if (bl6) {
                    object = this.a;
                    com.baidu.location.b.k.b((k)object);
                }
                break block11;
                catch (Exception exception) {}
            }
            try {
                string3 = new Bundle();
                object2 = this.b;
                object2 = ((String)object2).getBytes();
                string3.putByteArray(string2, (byte[])object2);
                string2 = "hotspot";
                string3.putInt(string2, n10);
                object = this.a;
                com.baidu.location.b.k.a((k)object, (Bundle)string3);
            }
            catch (Exception exception) {}
        }
        if ((object = this.k) != null) {
            object.clear();
        }
        com.baidu.location.b.k.a(this.a, false);
    }

    public void b() {
        String string2;
        this.i = 1;
        this.h = string2 = com.baidu.location.h.l.e();
        string2 = Jni.encodeTp4(this.c);
        this.c = null;
        this.k.put("bloc", string2);
    }
}

