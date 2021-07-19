/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.baidu.geofence.a;

import android.text.TextUtils;
import com.baidu.geofence.a.j$a;
import com.baidu.location.Jni;
import com.baidu.location.b.aa;
import com.baidu.location.h.b;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

public class j
extends f {
    private int a;
    private List b = null;
    private boolean c = false;
    private boolean d = false;
    private ArrayList e;
    private j$a f;

    public j() {
        HashMap hashMap;
        this.k = hashMap = new HashMap();
        this.a = 0;
    }

    public void a(j$a j$a) {
        this.f = j$a;
    }

    public void a(ArrayList arrayList) {
        this.e = arrayList;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object;
        this.d = false;
        int n10 = 1;
        if (bl2 && (object = this.j) != null) {
            try {
                JSONObject jSONObject = new JSONObject((String)object);
                object = this.f;
                if (object != null) {
                    object.clear();
                }
                this.d = n10;
            }
            catch (Exception exception) {}
        }
        if (!(bl2 = this.d)) {
            int n11;
            this.a = n11 = this.a + n10;
        }
        if (bl2) {
            this.a = 0;
        }
        this.b.clear();
        this.c = false;
    }

    public boolean a(String[] object) {
        int n10;
        int n11 = this.c;
        String string2 = null;
        if (n11 == 0 && (n11 = this.a) < (n10 = 10)) {
            boolean bl2;
            if (object != null) {
                n11 = ((String[])object).length;
                for (n10 = 0; n10 < n11; ++n10) {
                    Object object2 = object[n10];
                    ArrayList<Object> arrayList = this.b;
                    if (arrayList == null) {
                        this.b = arrayList = new ArrayList<Object>();
                    }
                    arrayList = this.b;
                    arrayList.add(object2);
                }
            }
            if ((object = this.b) != null && (bl2 = object.size()) > false) {
                this.c = bl2 = true;
                Object object3 = aa.a().c();
                if (object3 != null) {
                    string2 = com.baidu.location.h.l.g();
                    this.a((ExecutorService)object3, string2);
                } else {
                    object3 = com.baidu.location.h.l.g();
                    this.e((String)object3);
                }
                return bl2;
            }
        }
        return false;
    }

    public void b() {
        Object object;
        int n10;
        this.k.clear();
        Object object2 = this.k;
        Object object3 = "cltrw";
        object2.put("qt", object3);
        this.h = object2 = com.baidu.location.h.l.g();
        object2 = null;
        Object object4 = null;
        for (int i10 = 0; i10 < (n10 = (object3 = this.b).size()); ++i10) {
            CharSequence charSequence;
            block4: {
                CharSequence charSequence2;
                block3: {
                    block1: {
                        block2: {
                            object3 = this.e;
                            object = "]";
                            charSequence = "cltr[";
                            if (object3 == null || (n10 = (int)(object3.isEmpty() ? 1 : 0)) != 0) break block1;
                            object3 = ((StringBuilder)this.e.get(i10)).toString();
                            n10 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                            if (n10 == 0) break block2;
                            object3 = this.k;
                            charSequence2 = new StringBuilder();
                            break block3;
                        }
                        object3 = this.k;
                        charSequence2 = new StringBuilder();
                        charSequence2.append((String)charSequence);
                        charSequence2.append(i10);
                        charSequence2.append((String)object);
                        object = charSequence2.toString();
                        charSequence = new StringBuilder();
                        charSequence2 = (String)this.b.get(i10);
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        ((StringBuilder)charSequence).append("&");
                        charSequence2 = Jni.encode(((StringBuilder)this.e.get(i10)).toString());
                        ((StringBuilder)charSequence).append((String)charSequence2);
                        charSequence = ((StringBuilder)charSequence).toString();
                        break block4;
                    }
                    object3 = this.k;
                    charSequence2 = new StringBuilder();
                }
                charSequence2.append((String)charSequence);
                charSequence2.append(i10);
                charSequence2.append((String)object);
                object = charSequence2.toString();
                charSequence = this.b.get(i10);
            }
            object3.put(object, charSequence);
        }
        object4 = new StringBuilder();
        object3 = com.baidu.location.h.b.a().d();
        ((StringBuilder)object4).append((String)object3);
        ((StringBuilder)object4).append("&isgeofence=1");
        object4 = ((StringBuilder)object4).toString();
        object3 = this.k;
        object4 = Jni.encode((String)object4);
        object3.put("info", object4);
        object4 = Locale.CHINA;
        object = System.currentTimeMillis();
        object3 = new Object[]{object};
        object2 = String.format((Locale)object4, "%d", object3);
        this.k.put("trtm", object2);
        this.b.clear();
    }
}

