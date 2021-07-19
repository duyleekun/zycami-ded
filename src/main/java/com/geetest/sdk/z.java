/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.aa;
import com.geetest.sdk.ac;
import com.geetest.sdk.ai;
import com.geetest.sdk.aj;
import com.geetest.sdk.ak;
import com.geetest.sdk.ap;
import java.io.File;
import java.util.Collections;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class z
implements ak {
    private static z j;
    private boolean a;
    private boolean b;
    private aj c;
    private Set d;
    private String e;
    private String f;
    private String g;
    private String h;
    private int i;

    public z() {
        Set set = new Set();
        this.d = set = Collections.synchronizedSet(set);
    }

    private void a(String string2, int n10) {
        if (n10 < 0) {
            int n11;
            Object object = "gee_logger_write";
            boolean n112 = ((String)object).endsWith(string2);
            if (n112 && n10 != (n11 = -4060)) {
                object = this.d;
                Integer n12 = n10;
                boolean bl2 = object.contains(n12);
                if (bl2) {
                    return;
                }
                object = this.d;
                n12 = n10;
                object.add(n12);
            }
            if ((object = this.c) != null) {
                object.a(string2, n10);
            }
        }
    }

    private int b(int n10, String string2, long l10, String string3, long l11, boolean bl2) {
        byte by2;
        boolean bl3;
        JSONObject jSONObject = new JSONObject();
        String string4 = "c";
        jSONObject.put(string4, (Object)string2);
        string2 = "f";
        jSONObject.put(string2, n10);
        Object object = "i";
        jSONObject.put((String)object, l11);
        object = "l";
        jSONObject.put((String)object, l10);
        object = "m";
        jSONObject.put((String)object, bl2);
        object = "n";
        try {
            jSONObject.put((String)object, (Object)string3);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        object = jSONObject.toString().getBytes();
        int n11 = ((byte[])object).length;
        byte[] byArray = new byte[n11 + 5];
        byArray[0] = bl3 = true;
        byArray[bl3] = by2 = (byte)(n11 >> 24 & 0xFF);
        byArray[2] = by2 = (byte)(n11 >> 16 & 0xFF);
        byArray[3] = by2 = (byte)(n11 >> 8 & 0xFF);
        byArray[4] = by2 = (byte)(n11 & 0xFF);
        System.arraycopy(object, 0, byArray, 5, n11);
        object = new File;
        string2 = this.e;
        object(string2);
        aa.a((File)object, byArray, bl3);
        return -4010;
    }

    private int b(String object) {
        Object object2 = new JSONObject();
        int n10 = 1;
        String string2 = "ver";
        object2.put(string2, n10);
        string2 = "name";
        try {
            object2.put(string2, object);
        }
        catch (JSONException jSONException) {
            jSONException.printStackTrace();
        }
        object = object2.toString();
        int n11 = ((String)object).length();
        int n12 = n11 + 6;
        byte[] byArray = new byte[n12];
        byte[] byArray2 = ap.a(n11);
        if (byArray2 != null) {
            int n13 = byArray2.length;
            System.arraycopy(byArray2, 0, byArray, n10, n13);
            byArray[0] = 13;
            byArray[n12 -= n10] = 14;
            System.arraycopy(((String)object).getBytes(), 0, byArray, 5, n11);
            object2 = this.e;
            object = new File((String)object2);
            aa.a((File)object, byArray);
            return -2010;
        }
        return -2020;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int b(String object, String object2, int n10, String string2, String string3) {
        try {
            boolean bl2;
            String string4 = "gee_logger_cache";
            Object object3 = new File((String)object, string4);
            boolean bl3 = ((File)object3).exists();
            if (!bl3 && (bl3 = ((File)object3).mkdir())) {
                object = "[ init ]: cacheParentFile created";
                ai.a((String)object);
            }
            if (!(bl2 = ((File)(object = new File((String)object2))).exists()) && (bl2 = ((File)object).mkdir())) {
                object2 = "[ init ]: dirFile created";
                ai.a((String)object2);
            }
            string4 = "cache.log";
            object2 = new File((File)object3, string4);
            this.e = object3 = ((File)object2).getAbsolutePath();
            this.f = object = ((File)object).getAbsolutePath();
            this.i = n10;
            this.g = string2;
            this.h = string3;
            bl3 = ((File)object2).exists();
            if (bl3) {
                this.b();
            }
            long l10 = ap.a();
            object = String.valueOf(l10);
            this.a((String)object);
            return -1010;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return -1030;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static z c() {
        Object object = j;
        if (object != null) return j;
        object = z.class;
        synchronized (object) {
            z z10 = j;
            if (z10 != null) return j;
            j = z10 = new z();
            return j;
        }
    }

    public void a() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        try {
            this.b();
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
        }
    }

    public void a(int n10, String string2, long l10, String string3, long l11, boolean bl2) {
        block14: {
            String string4;
            block13: {
                string4 = "gee_logger_write";
                int n11 = this.b;
                if (n11 == 0) {
                    return;
                }
                String string5 = this.e;
                Object object = new File(string5);
                long l12 = ((File)object).length();
                int n12 = this.i;
                long l13 = n12;
                n11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                if (n11 > 0) {
                    this.a();
                    l12 = System.currentTimeMillis();
                    object = String.valueOf(l12);
                    this.a((String)object);
                }
                n10 = this.b(n10, string2, l10, string3, l11, bl2);
                int n13 = -4010;
                if (n10 != n13) break block13;
                n13 = (int)(ac.c ? 1 : 0);
                if (n13 == 0) break block14;
            }
            try {
                this.a(string4, n10);
            }
            catch (UnsatisfiedLinkError unsatisfiedLinkError) {
                unsatisfiedLinkError.printStackTrace();
                n10 = -4060;
                this.a(string4, n10);
            }
        }
    }

    public void a(aj aj2) {
        this.c = aj2;
    }

    public void a(String string2) {
        boolean bl2;
        String string3;
        block9: {
            string3 = "gee_logger_open";
            String string4 = this.f;
            File file = new File(string4, string2);
            bl2 = file.exists();
            if (!bl2) break block9;
            long l10 = System.currentTimeMillis();
            string2 = String.valueOf(l10);
        }
        int n10 = this.b(string2);
        bl2 = true;
        this.b = bl2;
        try {
            this.a(string3, n10);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            n10 = -2070;
            this.a(string3, n10);
        }
    }

    public void a(String string2, String string3, int n10, String string4, String string5) {
        String string6 = "gee_logger_init";
        boolean bl2 = this.a;
        if (bl2) {
            return;
        }
        int n11 = this.b(string2, string3, n10, string4, string5);
        boolean bl3 = true;
        this.a = bl3;
        try {
            this.a(string6, n11);
        }
        catch (UnsatisfiedLinkError unsatisfiedLinkError) {
            unsatisfiedLinkError.printStackTrace();
            n11 = -1060;
            this.a(string6, n11);
        }
    }

    public void a(boolean bl2) {
    }

    public void b() {
        String string2 = this.e;
        File file = new File(string2);
        string2 = this.f;
        String string3 = this.g;
        String string4 = this.h;
        aa.a(file, string2, string3, string4);
    }
}

