/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.b.m;
import com.baidu.location.b.q;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class q$b
extends f {
    public final /* synthetic */ q a;
    private String b = null;

    public q$b(q hashMap) {
        this.a = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String object) {
        this.b = object;
        object = aa.a().c();
        if (object != null) {
            String string2 = com.baidu.location.h.l.f;
            this.a((ExecutorService)object, string2);
        } else {
            object = com.baidu.location.h.l.f;
            this.e((String)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean n10) {
        Object object;
        Object object2 = "enc";
        if (n10 != 0 && (object = this.j) != null) {
            Object object3;
            block9: {
                boolean bl2 = ((String)object).contains((CharSequence)object2);
                if (!bl2) break block9;
                try {
                    object3 = new JSONObject((String)object);
                    boolean bl3 = object3.has((String)object2);
                    if (bl3) {
                        object2 = object3.getString((String)object2);
                        object3 = com.baidu.location.b.m.a();
                        object = ((m)object3).b((String)object2);
                    }
                }
                catch (Exception exception) {}
            }
            try {
                object2 = this.a;
                object3 = new BDLocation((String)object);
                q.a((q)object2, (BDLocation)object3);
                object = this.a;
                object = q.a((q)object);
                n10 = ((BDLocation)object).getLocType();
                int n11 = 167;
                if (n10 == n11) {
                    object = this.a;
                    q.a((q)object, null);
                }
            }
            catch (Exception exception) {
                object = this.a;
                q.a((q)object, null);
            }
        }
        if ((object = this.k) != null) {
            object.clear();
        }
    }

    public void b() {
        String string2;
        this.i = 1;
        this.h = string2 = com.baidu.location.h.l.e();
        string2 = Jni.encodeTp4(this.b);
        this.b = null;
        this.k.put("bloc", string2);
    }
}

