/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.baidu.location.c;

import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.c.h;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONArray;
import org.json.JSONObject;

public class h$a
extends f {
    public final /* synthetic */ h a;
    private boolean b = false;
    private int c = 0;
    private JSONArray d = null;
    private JSONArray e = null;

    public h$a(h hashMap) {
        this.a = hashMap;
        this.k = hashMap = new HashMap();
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object;
        if (bl2 && (object = this.j) != null) {
            void var3_6;
            Object object2;
            bl2 = false;
            object = null;
            try {
                object2 = this.j;
                JSONObject jSONObject = new JSONObject((String)object2);
                bl2 = true;
            }
            catch (Exception exception) {
                Object var3_5 = null;
                bl2 = false;
                object = null;
            }
            if (bl2 && var3_6 != null) {
                object = "tt";
                long l10 = System.currentTimeMillis();
                var3_6.put((String)object, l10);
                object = "data";
                object2 = this.e;
                var3_6.put((String)object, object2);
                {
                    catch (Exception exception) {}
                }
                try {
                    object2 = this.a;
                    object2 = com.baidu.location.c.h.b((h)object2);
                    Object object3 = "wcnf.dat";
                    object = new File((String)object2, (String)object3);
                    boolean bl3 = ((File)object).exists();
                    if (!bl3) {
                        ((File)object).createNewFile();
                    }
                    object3 = new FileWriter((File)object, false);
                    object2 = new BufferedWriter((Writer)object3);
                    String string2 = var3_6.toString();
                    byte[] byArray2 = string2.getBytes();
                    byArray2 = Base64.encode((byte[])byArray2, (int)0);
                    object3 = "UTF-8";
                    object = new String(byArray2, (String)object3);
                    ((Writer)object2).write((String)object);
                    ((BufferedWriter)object2).flush();
                    ((BufferedWriter)object2).close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        this.b = false;
    }

    public void a(boolean bl2, JSONArray object, JSONArray jSONArray) {
        Object object2;
        boolean bl3 = this.b;
        if (bl3) {
            return;
        }
        this.b = bl3 = true;
        if (bl2) {
            this.c = (int)(bl3 ? 1 : 0);
        } else {
            bl2 = false;
            object2 = null;
            this.c = 0;
        }
        this.d = object;
        this.e = jSONArray;
        object2 = aa.a().c();
        if (object2 != null) {
            object = com.baidu.location.h.l.g();
            this.a((ExecutorService)object2, (String)object);
        } else {
            object2 = com.baidu.location.h.l.g();
            this.e((String)object2);
        }
    }

    public void b() {
        Object object = com.baidu.location.h.l.g();
        this.h = object;
        this.k.clear();
        object = this.k;
        Object object2 = "cltrw";
        object.put("qt", object2);
        object = new JSONObject();
        Object[] objectArray = "data";
        object2 = this.d;
        object.put((String)objectArray, object2);
        objectArray = "frt";
        int n10 = this.c;
        try {
            object.put((String)objectArray, n10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        object = Jni.encodeOfflineLocationUpdateRequest(object.toString());
        objectArray = this.k;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        objectArray.put("cltr[0]", object);
        object = this.k;
        int n11 = 1;
        object2 = n11;
        object.put("cfg", object2);
        object = this.k;
        object2 = Jni.encode(com.baidu.location.h.b.a().c());
        object.put("info", object2);
        object = Locale.CHINA;
        objectArray = new Object[n11];
        Long l10 = System.currentTimeMillis();
        objectArray[0] = l10;
        object = String.format((Locale)object, "%d", objectArray);
        this.k.put("trtm", object);
    }
}

