/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import com.baidu.location.Jni;
import com.baidu.location.b.a;
import com.baidu.location.h.f;
import java.util.HashMap;
import org.json.JSONObject;

public class a$a
extends f {
    public String a = null;
    public boolean b = false;
    public final /* synthetic */ a c;

    public a$a(a hashMap) {
        this.c = hashMap;
        this.k = hashMap = new HashMap();
    }

    public void a(String string2) {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        this.b = true;
        this.a = string2;
        this.e("https://loc.map.baidu.com/cfgs/loc/commcfgs");
    }

    public void a(boolean bl2) {
        Object object;
        block16: {
            if (bl2 && (object = this.j) != null) {
                CharSequence charSequence = this.j;
                object = new JSONObject((String)charSequence);
                object = this.c;
                object = com.baidu.location.b.a.a((a)object);
                if (object == null) break block16;
                object = this.c;
                object = com.baidu.location.b.a.a((a)object);
                object = object.edit();
                charSequence = new StringBuilder();
                String string2 = com.baidu.location.b.a.b();
                ((StringBuilder)charSequence).append(string2);
                string2 = "_config";
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                string2 = this.j;
                try {
                    object.putString((String)charSequence, string2);
                    object.commit();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        if ((object = this.k) != null) {
            object.clear();
        }
        this.b = false;
    }

    public void b() {
        this.i = 2;
        String string2 = Jni.encode(this.a);
        this.a = null;
        this.k.put("qt", "conf");
        this.k.put("req", string2);
    }
}

