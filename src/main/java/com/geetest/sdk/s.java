/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import com.geetest.sdk.bb;
import com.geetest.sdk.bb$a;
import com.geetest.sdk.c;
import com.geetest.sdk.model.beans.a;
import com.geetest.sdk.model.beans.b;
import com.geetest.sdk.s$a;
import com.geetest.sdk.utils.l;
import com.geetest.sdk.utils.u;
import org.json.JSONObject;

public class s
extends com.geetest.sdk.u {
    private static final String f = "s";

    private void a(int n10, String object, JSONObject object2) {
        int n11;
        Object object3 = this.b;
        int n12 = ((bb)object3).g();
        if (n12 == (n11 = 2) && (object3 = this.b.a()) != null) {
            object3.g();
        }
        n10 = (int)(u.a(n10) ? 1 : 0);
        object3 = "208";
        String string2 = "ajax\u63a5\u53e3\u8fd4\u56de\u9519\u8bef\uff0c\u9519\u8bef\u7801\u4e3a\uff1a208-->";
        String string3 = "0";
        if (n10 == 0) {
            Object object4 = "OK";
            n10 = (int)(((String)object4).equals(object) ? 1 : 0);
            if (n10 == 0) {
                this.b.i().a(string3);
                object4 = object2.optString("error_code");
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append((String)object);
                object2 = ((StringBuilder)object2).toString();
                this.a((String)object4, (String)object2, (String)object);
            } else {
                object4 = this.b.d();
                String string4 = ((b)object4).o();
                this.b.i().f(string4);
                String string5 = "success";
                boolean bl2 = string5.equals(string4);
                String string6 = "1";
                if (bl2) {
                    l.b(f, "\u8fdb\u5165\u4e00\u952e\u901a\u8fc7\u6a21\u5f0f\uff01\uff01\uff01");
                    this.b.i().a(string6);
                    object = this.b;
                    this.e((bb)object);
                    object = this.b;
                    object2 = bb$a.ONEPASS;
                    ((bb)object).k = object2;
                    object = ((b)object4).c();
                    ((b)object4).d((String)object);
                    object = ((b)object4).t();
                    ((b)object4).f((String)object);
                    object = new StringBuilder();
                    object2 = ((b)object4).t();
                    ((StringBuilder)object).append((String)object2);
                    object2 = "|jordan";
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    ((b)object4).e((String)object);
                    object4 = this.b;
                    int n13 = 22;
                    ((bb)object4).b(n13);
                    object4 = this.a;
                    object = this.b;
                    ((com.geetest.sdk.u)object4).c((bb)object);
                } else {
                    string5 = "forbidden";
                    bl2 = string5.equals(string4);
                    if (bl2) {
                        this.b.i().a(string3);
                        object4 = new StringBuilder();
                        object3 = "ajax\u63a5\u53e3\u88abforbidden\uff0c\u9519\u8bef\u7801\u4e3a\uff1a200-->";
                        ((StringBuilder)object4).append((String)object3);
                        ((StringBuilder)object4).append((String)object);
                        object4 = ((StringBuilder)object4).toString();
                        object = object2.toString();
                        object2 = "200";
                        this.a((String)object2, (String)object4, (String)object);
                    } else {
                        string5 = ((b)object4).j().b();
                        bl2 = string5.has(string4);
                        if (bl2) {
                            object2 = (Integer)((b)object4).j().a().get(string4);
                            int n14 = (Integer)object2;
                            if (n14 == 0) {
                                this.b.i().a(string3);
                                object2 = new StringBuilder();
                                string2 = "ajax\u63a5\u53e3\u8fd4\u56de\u9519\u8bef\uff0cdialogHeight\u4e3a0\uff0c\u9519\u8bef\u7801\u4e3a\uff1a208-->";
                                ((StringBuilder)object2).append(string2);
                                object4 = ((b)object4).j().toString();
                                ((StringBuilder)object2).append((String)object4);
                                object4 = ((StringBuilder)object2).toString();
                                this.a((String)object3, (String)object4, (String)object);
                            } else {
                                this.b.i().a(string6);
                                ((b)object4).c(n14);
                                object4 = this.a;
                                object = this.b;
                                ((com.geetest.sdk.u)object4).c((bb)object);
                            }
                        } else {
                            this.b.i().a(string3);
                            object4 = new StringBuilder();
                            ((StringBuilder)object4).append(string2);
                            object = object2.toString();
                            ((StringBuilder)object4).append((String)object);
                            object4 = ((StringBuilder)object4).toString();
                            object = new StringBuilder();
                            string2 = "data type error-->";
                            ((StringBuilder)object).append(string2);
                            object2 = object2.toString();
                            ((StringBuilder)object).append((String)object2);
                            object = ((StringBuilder)object).toString();
                            this.a((String)object3, (String)object4, (String)object);
                        }
                    }
                }
            }
        } else {
            this.b.i().a(string3);
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            this.a((String)object3, (String)charSequence, (String)object);
        }
    }

    public static /* synthetic */ void a(s s10, int n10, String string2, JSONObject jSONObject) {
        s10.a(n10, string2, jSONObject);
    }

    private void a(String object, String object2, String string2) {
        l.b(f, (String)object2);
        object2 = new a();
        ((a)object2).c(string2);
        ((a)object2).b((String)object);
        long l10 = System.currentTimeMillis();
        long l11 = this.b.j();
        ((a)object2).a(l10 -= l11);
        object = this.b.d().c();
        ((a)object2).a((String)object);
        this.b.a((a)object2);
        object = this.b;
        this.e((bb)object);
        object = this.b;
        this.b((bb)object);
    }

    public int a() {
        return 15;
    }

    public void a(bb object) {
        Context context = ((bb)object).c();
        object = ((bb)object).d();
        s$a s$a = new s$a(this);
        com.geetest.sdk.c.a(context, (b)object, s$a);
    }
}

