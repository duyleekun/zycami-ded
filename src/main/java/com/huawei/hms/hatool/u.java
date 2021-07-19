/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.b1;
import com.huawei.hms.hatool.c;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.i0;
import com.huawei.hms.hatool.l0;
import com.huawei.hms.hatool.m0;
import com.huawei.hms.hatool.n0;
import com.huawei.hms.hatool.p0;
import com.huawei.hms.hatool.q;
import com.huawei.hms.hatool.r0;
import com.huawei.hms.hatool.r_0;
import com.huawei.hms.hatool.s0;
import com.huawei.hms.hatool.y;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class u {
    public String a;
    public String b;
    public String c;
    public List d;
    public String e;

    public u(String string2, String string3, String string4, List list, String string5) {
        this.a = string2;
        this.b = string3;
        this.c = string4;
        this.d = list;
        this.e = string5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final String a(String string2, String string3) {
        Object[] objectArray = com.huawei.hms.hatool.c.f(string2, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)objectArray);
        String string4 = "";
        if (bl2) {
            objectArray = new Object[]{string2, string3};
            y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", objectArray);
            return string4;
        }
        string2 = "oper";
        boolean bl3 = string2.equals(string3);
        String string5 = "{url}";
        if (bl3) {
            string2 = "{url}/common/hmshioperqrt";
            return string2.replace(string5, (CharSequence)objectArray);
        }
        string2 = "maint";
        bl3 = string2.equals(string3);
        if (bl3) {
            string2 = "{url}/common/hmshimaintqrt";
            return string2.replace(string5, (CharSequence)objectArray);
        }
        string2 = "diffprivacy";
        bl3 = string2.equals(string3);
        if (!bl3) return string4;
        string2 = "{url}/common/common2";
        return string2.replace(string5, (CharSequence)objectArray);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a() {
        Object object;
        Object object2;
        block8: {
            Object object3;
            String string2;
            block6: {
                byte[] byArray;
                block7: {
                    block5: {
                        int n10;
                        block4: {
                            object2 = this.a;
                            object = this.b;
                            string2 = this.a((String)object2, (String)object);
                            n10 = TextUtils.isEmpty((CharSequence)string2);
                            object = "hmsSdk";
                            if (n10 == 0 || (n10 = ((String)(object3 = "preins")).equals(object2 = this.b)) != 0) break block4;
                            object2 = "collectUrl is empty";
                            break block5;
                        }
                        object3 = "_hms_config_tag";
                        object2 = this.a;
                        n10 = ((String)object3).equals(object2);
                        if (n10 == 0 && (n10 = ((String)(object3 = "_openness_config_tag")).equals(object2 = this.a)) == 0) {
                            this.b();
                        }
                        if ((object2 = this.d()) == null) break block6;
                        byArray = this.a((r_0)object2);
                        n10 = byArray.length;
                        if (n10 != 0) break block7;
                        object2 = "request body is empty";
                    }
                    y.e((String)object, (String)object2);
                    return;
                }
                String string3 = this.a;
                String string4 = this.b;
                String string5 = this.e;
                List list = this.d;
                object3 = object2;
                object2 = new i0(byArray, string2, string3, string4, string5, list);
                object = n0.a();
                break block8;
            }
            object = this.d;
            object3 = this.a;
            String string6 = this.e;
            string2 = this.b;
            object2 = new l0((List)object, (String)object3, string6, string2);
            object = n0.b();
        }
        ((n0)object).a((m0)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final byte[] a(r_0 object) {
        String string2 = "hmsSdk";
        try {
            object = ((r_0)object).a();
            if (object == null) {
                object = "uploadEvents is null";
                y.e(string2, (String)object);
                return new byte[0];
            }
            object = object.toString();
            String string3 = "UTF-8";
            object = ((String)object).getBytes(string3);
            return r0.a((byte[])object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = "sendData(): getBytes - Unsupported coding format!!";
        }
        catch (JSONException jSONException) {
            object = "uploadEvents to json error";
        }
        y.e(string2, (String)object);
        return new byte[0];
    }

    public final void b() {
        Object object = com.huawei.hms.hatool.b.f();
        String string2 = "backup_event";
        int n10 = 0x500000;
        boolean bl2 = p0.a(object, string2, n10);
        String string3 = "hmsSdk";
        if (bl2) {
            y.d(string3, "backup file reach max limited size, discard new event ");
            return;
        }
        object = this.c();
        String string4 = this.a;
        CharSequence charSequence = this.b;
        String string5 = this.e;
        string4 = s0.a(string4, (String)charSequence, string5);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Update data cached into backup,spKey: ");
        ((StringBuilder)charSequence).append(string4);
        charSequence = ((StringBuilder)charSequence).toString();
        y.c(string3, (String)charSequence);
        string3 = com.huawei.hms.hatool.b.f();
        object = object.toString();
        g0.b((Context)string3, string2, string4, (String)object);
    }

    public final JSONArray c() {
        boolean bl2;
        JSONArray jSONArray = new JSONArray();
        Iterator iterator2 = this.d.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (q)iterator2.next();
            try {
                object = ((q)object).d();
            }
            catch (JSONException jSONException) {
                object = "hmsSdk";
                String string2 = "handleEvents: json error,Abandon this data";
                y.c((String)object, string2);
                continue;
            }
            jSONArray.put(object);
        }
        return jSONArray;
    }

    public final r_0 d() {
        List list = this.d;
        String string2 = this.a;
        String string3 = this.b;
        String string4 = this.e;
        String string5 = this.c;
        return b1.a(list, string2, string3, string4, string5);
    }
}

