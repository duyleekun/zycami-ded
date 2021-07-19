/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.g;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class g$a
extends f {
    public String a = null;
    public final /* synthetic */ g b;

    public g$a(g hashMap) {
        this.b = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String object) {
        this.a = object;
        object = aa.a().c();
        this.a((ExecutorService)object, "https://loc.map.baidu.com/cc.php");
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
                JSONObject jSONObject = new JSONObject((String)object);
                object = "prod";
                String string2 = com.baidu.location.h.b.e;
                jSONObject.put((String)object, (Object)string2);
                object = "uptime";
                long l10 = System.currentTimeMillis();
                jSONObject.put((String)object, l10);
                object = this.b;
                String string3 = jSONObject.toString();
                com.baidu.location.b.g.a((g)object, string3);
            }
            catch (Exception exception) {}
        }
        if ((object = this.k) != null) {
            object.clear();
        }
    }

    public void b() {
        this.h = "https://loc.map.baidu.com/cc.php";
        String string2 = Jni.encode(this.a);
        this.a = null;
        this.k.put("q", string2);
    }
}

