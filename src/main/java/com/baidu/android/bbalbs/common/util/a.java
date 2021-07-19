/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.JsonReader
 */
package com.baidu.android.bbalbs.common.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import com.baidu.android.bbalbs.common.a.b;
import com.baidu.android.bbalbs.common.util.d;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class a {
    private static final String e;
    private String a;
    private String b;
    private int c = 0;
    private int d = 2;

    static {
        Object object;
        int n10 = 12;
        byte[] byArray = object = new byte[n10];
        byte[] byArray2 = object;
        byArray[0] = 77;
        byArray2[1] = 122;
        byArray[2] = 65;
        byArray2[3] = 121;
        byArray[4] = 77;
        byArray2[5] = 84;
        byArray[6] = 73;
        byArray2[7] = 120;
        byArray[8] = 77;
        byArray2[9] = 68;
        byArray[10] = 73;
        byArray2[11] = 61;
        object = com.baidu.android.bbalbs.common.a.b.a(object);
        String string2 = new String((byte[])object);
        object = new String;
        Object object2 = new byte[n10];
        byte[] byArray3 = object2;
        byte[] byArray4 = object2;
        byArray3[0] = 90;
        byArray4[1] = 71;
        byArray3[2] = 108;
        byArray4[3] = 106;
        byArray3[4] = 100;
        byArray4[5] = 87;
        byArray3[6] = 82;
        byArray4[7] = 112;
        byArray3[8] = 89;
        byArray4[9] = 87;
        byArray3[10] = 73;
        byArray4[11] = 61;
        object2 = com.baidu.android.bbalbs.common.a.b.a((byte[])object2);
        object((byte[])object2);
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append((String)object);
        e = ((StringBuilder)object2).toString();
    }

    public static boolean a(Context object) {
        boolean bl2 = ((File)(object = com.baidu.android.bbalbs.common.util.a.c((Context)object))).exists();
        if (bl2) {
            return ((File)object).delete();
        }
        return false;
    }

    public static a b(Context context) {
        return com.baidu.android.bbalbs.common.util.a.d(com.baidu.android.bbalbs.common.util.d.a(com.baidu.android.bbalbs.common.util.a.c(context)));
    }

    public static boolean b(int n10) {
        int n11 = 14;
        n10 = n10 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a c(String string2) {
        void var0_3;
        Object object;
        JsonReader jsonReader;
        boolean bl2;
        block17: {
            int n10;
            String string3;
            String string4;
            block16: {
                boolean bl3;
                boolean bl4;
                bl2 = TextUtils.isEmpty((CharSequence)string2);
                jsonReader = null;
                if (bl2) {
                    return null;
                }
                Object object2 = new StringReader(string2);
                object = new JsonReader((Reader)object2);
                object.beginObject();
                string2 = "ZGV2aWNlaWQ=";
                string2 = com.baidu.android.bbalbs.common.util.a.g(string2);
                object2 = "dmVy";
                object2 = com.baidu.android.bbalbs.common.util.a.g((String)object2);
                int n11 = 2;
                string4 = "0";
                string3 = "";
                int n12 = n11;
                while (bl4 = object.hasNext()) {
                    String string5 = object.nextName();
                    boolean bl5 = string2.equals(string5);
                    if (bl5) {
                        string3 = object.nextString();
                        continue;
                    }
                    bl4 = ((String)object2).equals(string5);
                    if (bl4) {
                        n12 = object.nextInt();
                        continue;
                    }
                    string4 = object.nextString();
                }
                object.endObject();
                n10 = 0;
                string2 = null;
                if (n12 != n11 || (bl3 = TextUtils.isEmpty((CharSequence)string4))) break block16;
                n10 = string4.length();
            }
            try {
                object.close();
            }
            catch (Exception exception) {
                com.baidu.android.bbalbs.common.util.d.a(exception);
            }
            bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) return null;
            object = new a();
            ((a)object).a(string3);
            ((a)object).a(n10);
            n10 = (int)(((a)object).d() ? 1 : 0);
            if (n10 != 0) return object;
            ((a)object).b(string4);
            return object;
            catch (Throwable throwable) {
                jsonReader = object;
                break block17;
            }
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (jsonReader == null) throw var0_3;
        try {
            jsonReader.close();
            throw var0_3;
        }
        catch (Exception exception) {
            com.baidu.android.bbalbs.common.util.d.a(exception);
        }
        throw var0_3;
        catch (IOException iOException) {
            block18: {
                bl2 = false;
                object = null;
                break block18;
                catch (IOException iOException2) {}
            }
            if (object == null) return null;
            try {
                object.close();
                return null;
            }
            catch (Exception exception) {
                com.baidu.android.bbalbs.common.util.d.a(exception);
            }
            return null;
        }
    }

    private static File c(Context object) {
        object = object.getFilesDir();
        File file = new File((File)object, "libcuid.so");
        return file;
    }

    public static a d(String string2) {
        return com.baidu.android.bbalbs.common.util.a.c(com.baidu.android.bbalbs.common.util.a.f(string2));
    }

    public static boolean e(String string2) {
        return TextUtils.isEmpty((CharSequence)string2);
    }

    private static String f(String object) {
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
        object = ((String)object).getBytes();
        object = com.baidu.android.bbalbs.common.a.b.a((byte[])object);
        object = com.baidu.android.bbalbs.common.a.a.b(string2, string2, (byte[])object);
        String string3 = new String((byte[])object);
        return string3;
    }

    private static String g(String object) {
        object = com.baidu.android.bbalbs.common.a.b.a(((String)object).getBytes());
        String string2 = new String((byte[])object);
        return string2;
    }

    public String a() {
        return this.a;
    }

    public void a(int n10) {
        this.c = n10;
    }

    public void a(String string2) {
        this.a = string2;
    }

    public String b() {
        return this.b;
    }

    public void b(String string2) {
        this.b = string2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean c() {
        String string2;
        boolean bl2 = this.d();
        boolean bl3 = true;
        if (bl2) {
            string2 = "O";
        } else {
            bl2 = this.e();
            if (!bl2) {
                return false;
            }
            string2 = "0";
        }
        this.b = string2;
        return bl3;
    }

    public boolean d() {
        return com.baidu.android.bbalbs.common.util.a.b(this.c);
    }

    public boolean e() {
        return com.baidu.android.bbalbs.common.util.a.e(this.b);
    }
}

