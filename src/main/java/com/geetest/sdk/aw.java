/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.geetest.sdk.ay;
import com.geetest.sdk.az;
import com.geetest.sdk.utils.k;
import com.geetest.sdk.utils.l;
import java.util.Map;
import org.json.JSONObject;

public abstract class aw {
    private static final String i = "aw";
    private String a;
    public Context b;
    private int c;
    private String d;
    private Object e;
    public byte[] f;
    private String g;
    private boolean h = false;

    public aw(String string2, Context context) {
        this.a = string2;
        this.b = context;
    }

    public final String a() {
        return this.g;
    }

    public final String a(String string2) {
        Object[] objectArray = new Object[]{"absent", string2};
        return this.a("%s %s", objectArray);
    }

    public final String a(String string2, Object ... objectArray) {
        String string3 = i;
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = this.g;
        stringBuilder.append(string4);
        stringBuilder.append(" ");
        string2 = String.format(string2, objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        l.b(string3, string2);
        return "request data error";
    }

    public final void a(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1) && n10 != (n11 = 2)) {
            RuntimeException runtimeException = new RuntimeException("unknown et.");
            throw runtimeException;
        }
    }

    public final void a(int n10, String string2) {
        this.c = n10;
        this.d = string2;
    }

    public final void a(int n10, String string2, Object object) {
        this.c = n10;
        this.d = string2;
        this.e = object;
    }

    public final void a(ay ay2) {
        if (ay2 != null) {
            int n10 = this.c;
            String string2 = this.d;
            Object object = this.e;
            try {
                ay2.a(n10, string2, object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    public final void a(boolean bl2) {
        this.h = bl2;
    }

    public abstract boolean a(int var1, az var2, JSONObject var3);

    public Context b() {
        return this.b;
    }

    public final String b(String string2, Object ... objectArray) {
        String string3 = i;
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = this.g;
        stringBuilder.append(string4);
        stringBuilder.append(" ");
        string2 = String.format(string2, objectArray);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        l.c(string3, string2);
        return "request net error";
    }

    public final void b(ay ay2) {
        l.b(i, "request cancel");
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void b(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        CharSequence charSequence = " parse error: response null!";
        int n10 = -2;
        if (bl2) {
            this.a(n10, "response null!");
            string2 = i;
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = this.g;
            stringBuilder.append(string3);
            stringBuilder.append((String)charSequence);
            String string4 = stringBuilder.toString();
            l.b(string2, string4);
            return;
        }
        String string5 = "GT3_Error_Info: ";
        boolean bl3 = string2.startsWith(string5);
        String string6 = "";
        if (bl3) {
            string2 = string2.replace(string5, string6);
            this.a(n10, string2);
            string2 = i;
            StringBuilder stringBuilder = new StringBuilder();
            String string7 = this.g;
            stringBuilder.append(string7);
            stringBuilder.append((String)charSequence);
            String string8 = stringBuilder.toString();
            l.b(string2, string8);
            return;
        }
        String string9 = i;
        charSequence = new StringBuilder();
        Object object = this.g;
        ((StringBuilder)charSequence).append((String)object);
        object = " response body: ";
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        l.d(string9, (String)charSequence);
        string2 = string2.replace("(", string6);
        charSequence = ")";
        string2 = string2.replace(charSequence, string6);
        int n11 = TextUtils.isEmpty((CharSequence)string2);
        if (n11 != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("decrypt error: ");
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            this.a(n10, string2);
            return;
        }
        charSequence = new StringBuilder();
        object = this.g;
        ((StringBuilder)charSequence).append((String)object);
        object = " parsed response body: ";
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        l.d(string9, (String)charSequence);
        try {
            JSONObject jSONObject = new JSONObject(string2);
            charSequence = "result";
            n11 = jSONObject.optInt((String)charSequence);
            string6 = null;
            object = new az(null, null);
            bl2 = this.a(n11, (az)object, jSONObject);
            if (!bl2) {
                Object object2 = ((az)object).a;
                String string10 = (String)object2;
                this.a(n10, string10);
                return;
            }
            Object object3 = ((az)object).a;
            String string11 = (String)object3;
            object = ((az)object).b;
            this.a(n11, string11, object);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            charSequence = new StringBuilder();
            object = "parse json error\uff1a";
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" Exception: ");
            string2 = exception.toString();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            this.a(n10, string2);
            string2 = i;
            charSequence = new StringBuilder();
            String string12 = this.g;
            ((StringBuilder)charSequence).append(string12);
            string12 = " parse error: ";
            ((StringBuilder)charSequence).append(string12);
            String string13 = exception.toString();
            ((StringBuilder)charSequence).append(string13);
            String string14 = ((StringBuilder)charSequence).toString();
            l.b(string2, string14);
        }
    }

    public abstract Map c();

    public final void c(String string2) {
        this.g = string2;
    }

    public String d() {
        return this.a;
    }

    public boolean e() {
        return true;
    }

    /*
     * Loose catch block
     */
    public final byte[] f() {
        block25: {
            boolean bl2;
            Object object;
            block24: {
                block23: {
                    block22: {
                        this.f = null;
                        object = this.g();
                        if (object == null) break block22;
                        object = object.toString();
                        break block23;
                    }
                    object = this.h();
                }
                Object object2 = i;
                CharSequence charSequence = new StringBuilder();
                String string2 = this.g;
                charSequence.append(string2);
                string2 = " request body: ";
                charSequence.append(string2);
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                l.d((String)object2, (String)charSequence);
                bl2 = this.h;
                if (!bl2) break block24;
                object2 = object.getBytes();
                try {
                    object2 = k.a((byte[])object2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    charSequence = i;
                    object2 = exception.toString();
                    l.b((String)charSequence, (String)object2);
                    bl2 = false;
                    object2 = null;
                }
                if (object2 != null) {
                    this.f = (byte[])object2;
                    return object2;
                }
            }
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) break block25;
            object = object.getBytes();
            this.f = (byte[])object;
            return object;
            {
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return null;
    }

    public JSONObject g() {
        return null;
    }

    public String h() {
        return null;
    }
}

