/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.a.c;
import com.baidu.android.bbalbs.common.util.a;
import com.baidu.android.bbalbs.common.util.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

public final class b {
    private static final String e;
    private static final String f;
    private String a;
    private String b;
    private int c = 3;
    private int d;

    static {
        byte[] byArray;
        int n10 = 2;
        Object object = new byte[n10][];
        int n11 = 12;
        byte[] byArray2 = byArray = new byte[n11];
        byte[] byArray3 = byArray;
        byArray2[0] = 81;
        byArray3[1] = 72;
        byArray2[2] = 116;
        byArray3[3] = 79;
        byArray2[4] = 75;
        byArray3[5] = 72;
        byArray2[6] = 69;
        byArray3[7] = 52;
        byArray2[8] = 76;
        byArray3[9] = 51;
        byArray2[10] = 103;
        byArray3[11] = 61;
        object[0] = byArray;
        byte[] byArray4 = byArray = new byte[n11];
        byte[] byArray5 = byArray;
        byArray4[0] = 82;
        byArray5[1] = 51;
        byArray4[2] = 104;
        byArray5[3] = 90;
        byArray4[4] = 83;
        byArray5[5] = 122;
        byArray4[6] = 65;
        byArray5[7] = 105;
        byArray4[8] = 101;
        byArray5[9] = 49;
        byArray4[10] = 107;
        byArray5[11] = 61;
        int n12 = 1;
        object[n12] = byArray;
        e = com.baidu.android.bbalbs.common.util.b.a(object);
        byte[][] byArrayArray = new byte[n10][];
        Object object2 = object = (Object)new byte[n11];
        Object object3 = object;
        object2[0] = (byte[])76;
        object3[1] = (byte[])67;
        object2[2] = (byte[])77;
        object3[3] = (byte[])53;
        object2[4] = (byte[])77;
        object3[5] = (byte[])70;
        object2[6] = (byte[])90;
        object3[7] = (byte[])73;
        object2[8] = (byte[])81;
        object3[9] = (byte[])107;
        object2[10] = (byte[])107;
        object3[11] = (byte[])61;
        byArrayArray[0] = (byte[])object;
        Object object4 = object = (Object)new byte[n11];
        Object object5 = object;
        object4[0] = (byte[])90;
        object5[1] = (byte[])105;
        object4[2] = (byte[])108;
        object5[3] = (byte[])121;
        object4[4] = (byte[])79;
        object5[5] = (byte[])68;
        object4[6] = (byte[])100;
        object5[7] = (byte[])81;
        object4[8] = (byte[])86;
        object5[9] = (byte[])121;
        object4[10] = (byte[])89;
        object5[11] = (byte[])61;
        byArrayArray[n12] = (byte[])object;
        f = com.baidu.android.bbalbs.common.util.b.a(byArrayArray);
    }

    public static b a(Context context, String string2) {
        return com.baidu.android.bbalbs.common.util.b.b(context, string2);
    }

    public static b a(a object) {
        if (object != null) {
            b b10 = new b();
            String string2 = ((a)object).a();
            b10.a(string2);
            object = ((a)object).b();
            b10.b((String)object);
            return b10;
        }
        object = new IllegalArgumentException("arg non-nullable is expected");
        throw object;
    }

    private static String a(byte[] ... byArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte[] byArray2 : byArray) {
            byArray2 = com.baidu.android.bbalbs.common.a.b.a(byArray2);
            String string2 = new String(byArray2);
            stringBuilder.append(string2);
        }
        return stringBuilder.toString();
    }

    public static b b(Context object) {
        boolean bl2 = ((File)(object = com.baidu.android.bbalbs.common.util.b.d((Context)object))).exists();
        if (!bl2) {
            return null;
        }
        return com.baidu.android.bbalbs.common.util.b.d(com.baidu.android.bbalbs.common.util.d.a((File)object));
    }

    private static b b(Context object, String string2) {
        String string3;
        b b10 = new b();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 23;
        if (n10 < n12) {
            n12 = n11;
        } else {
            n12 = 0;
            string3 = null;
        }
        String string4 = com.baidu.android.bbalbs.common.util.d.a((Context)object);
        if (n12 != 0) {
            string3 = com.baidu.android.bbalbs.common.util.b.e((Context)object);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) {
                string3 = UUID.randomUUID().toString();
                com.baidu.android.bbalbs.common.util.b.c((Context)object, string3);
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(string3);
        } else {
            object = new StringBuilder();
            string3 = "com.baidu";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(string4);
        }
        object = com.baidu.android.bbalbs.common.a.c.a(((StringBuilder)object).toString().getBytes(), n11 != 0);
        b10.a((String)object);
        b10.b(string2);
        b10.a(n10);
        return b10;
    }

    private String b() {
        String string2;
        String string3;
        JSONObject jSONObject;
        block16: {
            try {
                jSONObject = new JSONObject();
                string3 = "ZGV2aWNlaWQ=";
            }
            catch (JSONException jSONException) {
                com.baidu.android.bbalbs.common.util.d.a(jSONException);
                return null;
            }
            string3 = com.baidu.android.bbalbs.common.util.b.i(string3);
            string2 = this.a;
            jSONObject = jSONObject.put(string3, (Object)string2);
            string3 = "ZmxhZw==";
            string3 = com.baidu.android.bbalbs.common.util.b.i(string3);
            string2 = this.b;
            if (string2 != null) break block16;
            string2 = "0";
        }
        jSONObject = jSONObject.put(string3, (Object)string2);
        string3 = "dmVy";
        string3 = com.baidu.android.bbalbs.common.util.b.i(string3);
        int n10 = this.c;
        jSONObject = jSONObject.put(string3, n10);
        string3 = "c2Rr";
        string3 = com.baidu.android.bbalbs.common.util.b.i(string3);
        n10 = this.d;
        jSONObject = jSONObject.put(string3, n10);
        return jSONObject.toString();
    }

    public static b c(String string2) {
        block16: {
            int n10 = TextUtils.isEmpty((CharSequence)string2);
            if (n10 != 0) {
                return null;
            }
            JSONObject jSONObject = new JSONObject(string2);
            string2 = "ZmxhZw==";
            string2 = com.baidu.android.bbalbs.common.util.b.i(string2);
            String string3 = "0";
            string2 = jSONObject.optString(string2, string3);
            string3 = "ZGV2aWNlaWQ=";
            string3 = com.baidu.android.bbalbs.common.util.b.i(string3);
            string3 = jSONObject.getString(string3);
            Object object = "c2Rr";
            object = com.baidu.android.bbalbs.common.util.b.i((String)object);
            n10 = jSONObject.optInt((String)object, 0);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) break block16;
            object = new b();
            ((b)object).a(string3);
            ((b)object).b(string2);
            try {
                ((b)object).a(n10);
                return object;
            }
            catch (JSONException jSONException) {
                com.baidu.android.bbalbs.common.util.d.a(jSONException);
            }
        }
        return null;
    }

    private static void c(Context context, String string2) {
        String string3 = "XL5g0WZAHpIaKspIHIHYg5k";
        String string4 = com.baidu.android.bbalbs.common.util.d.a(context, string3);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (bl2 && (bl2 = com.baidu.android.bbalbs.common.util.d.b(context))) {
            string2 = com.baidu.android.bbalbs.common.util.b.g(string2);
            com.baidu.android.bbalbs.common.util.d.a(context, string3, string2);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean c(Context object) {
        Throwable throwable2222222;
        FileOutputStream fileOutputStream;
        block10: {
            String string2 = com.baidu.android.bbalbs.common.util.b.e(this.b());
            fileOutputStream = null;
            String string3 = "libcuid_v3.so";
            fileOutputStream = object.openFileOutput(string3, 0);
            object = string2.getBytes();
            fileOutputStream.write((byte[])object);
            fileOutputStream.flush();
            if (fileOutputStream == null) return true;
            {
                catch (Throwable throwable2222222) {
                    break block10;
                }
                catch (Exception exception) {}
                {
                    com.baidu.android.bbalbs.common.util.d.a(exception);
                    if (fileOutputStream == null) return false;
                }
                try {
                    fileOutputStream.close();
                    return false;
                }
                catch (Exception exception) {
                    com.baidu.android.bbalbs.common.util.d.a(exception);
                }
                return false;
            }
            try {
                fileOutputStream.close();
                return true;
            }
            catch (Exception exception) {
                com.baidu.android.bbalbs.common.util.d.a(exception);
            }
            return true;
        }
        if (fileOutputStream == null) throw throwable2222222;
        try {
            fileOutputStream.close();
            throw throwable2222222;
        }
        catch (Exception exception) {
            com.baidu.android.bbalbs.common.util.d.a(exception);
        }
        throw throwable2222222;
    }

    public static b d(String string2) {
        return com.baidu.android.bbalbs.common.util.b.c(com.baidu.android.bbalbs.common.util.b.f(string2));
    }

    private static File d(Context object) {
        object = object.getFilesDir();
        File file = new File((File)object, "libcuid_v3.so");
        return file;
    }

    private static String e(Context context) {
        return com.baidu.android.bbalbs.common.util.b.h(com.baidu.android.bbalbs.common.util.d.a(context, "XL5g0WZAHpIaKspIHIHYg5k"));
    }

    /*
     * WARNING - void declaration
     */
    public static String e(String object) {
        void var0_3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        String string2 = e;
        String string3 = f;
        object = ((String)object).getBytes();
        object = com.baidu.android.bbalbs.common.a.a.a(string2, string3, (byte[])object);
        string2 = "utf-8";
        try {
            return com.baidu.android.bbalbs.common.a.b.a((byte[])object, string2);
        }
        catch (Exception exception) {
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        com.baidu.android.bbalbs.common.util.d.a((Throwable)var0_3);
        return "";
    }

    public static String f(String object) {
        String string2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        try {
            string2 = e;
        }
        catch (Exception exception) {
            com.baidu.android.bbalbs.common.util.d.a(exception);
            return "";
        }
        String string3 = f;
        object = ((String)object).getBytes();
        object = com.baidu.android.bbalbs.common.a.b.a((byte[])object);
        object = com.baidu.android.bbalbs.common.a.a.b(string2, string3, (byte[])object);
        String string4 = new String((byte[])object);
        return string4;
    }

    /*
     * WARNING - void declaration
     */
    public static String g(String object) {
        void var0_3;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        String string2 = f;
        String string3 = e;
        object = ((String)object).getBytes();
        object = com.baidu.android.bbalbs.common.a.a.a(string2, string3, (byte[])object);
        string2 = "utf-8";
        try {
            return com.baidu.android.bbalbs.common.a.b.a((byte[])object, string2);
        }
        catch (Exception exception) {
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            // empty catch block
        }
        com.baidu.android.bbalbs.common.util.d.a((Throwable)var0_3);
        return "";
    }

    public static String h(String object) {
        String string2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return null;
        }
        try {
            string2 = f;
        }
        catch (Exception exception) {
            com.baidu.android.bbalbs.common.util.d.a(exception);
            return "";
        }
        String string3 = e;
        object = ((String)object).getBytes();
        object = com.baidu.android.bbalbs.common.a.b.a((byte[])object);
        object = com.baidu.android.bbalbs.common.a.a.b(string2, string3, (byte[])object);
        String string4 = new String((byte[])object);
        return string4;
    }

    public static String i(String object) {
        object = com.baidu.android.bbalbs.common.a.b.a(((String)object).getBytes());
        String string2 = new String((byte[])object);
        return string2;
    }

    public String a() {
        CharSequence charSequence = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            charSequence = "0";
            this.b = charSequence;
        }
        charSequence = new StringBuilder();
        String string2 = this.a;
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append("|");
        string2 = this.b;
        ((StringBuilder)charSequence).append(string2);
        return ((StringBuilder)charSequence).toString();
    }

    public void a(int n10) {
        this.d = n10;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public boolean a(Context context) {
        return this.c(context);
    }

    public void b(String string2) {
        this.b = string2;
    }
}

