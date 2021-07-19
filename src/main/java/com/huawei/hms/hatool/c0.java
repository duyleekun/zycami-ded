/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.hatool;

import android.content.Context;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.r0;
import com.huawei.hms.hatool.y;
import d.j.f.a.a.h.f.c;
import java.io.File;
import java.io.IOException;

public class c0 {
    public String a;

    public c0() {
        String string2;
        this.a = string2 = b.f().getFilesDir().getPath();
    }

    public static boolean b(File file) {
        int n10;
        File[] fileArray;
        boolean bl2;
        if (file != null && (bl2 = file.exists()) && (bl2 = file.isDirectory()) && (fileArray = file.listFiles()) != null && (n10 = fileArray.length) != 0) {
            for (File file2 : fileArray) {
                boolean bl3 = file2.isFile();
                if (bl3) {
                    bl3 = file2.delete();
                    if (bl3) continue;
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "delete file failed : ";
                    charSequence.append(string2);
                    String string3 = file2.getName();
                    charSequence.append(string3);
                    String string4 = charSequence.toString();
                    charSequence = "hmsSdk";
                    y.c((String)charSequence, string4);
                    continue;
                }
                bl3 = file2.isDirectory();
                if (!bl3) continue;
                c0.b(file2);
            }
            return file.delete();
        }
        return false;
    }

    public static boolean d() {
        CharSequence charSequence = new StringBuilder();
        Object object = b.f().getFilesDir().getPath();
        charSequence.append((String)object);
        charSequence.append("/");
        charSequence.append("hms");
        charSequence = charSequence.toString();
        object = new File((String)charSequence);
        return c0.b((File)object);
    }

    public String a() {
        Object object;
        String string2;
        Object object2 = this.c();
        int n10 = this.b();
        String string3 = "maywnj";
        String string4 = "marfil";
        String string5 = "febdoc";
        String string6 = "aprpap";
        if (n10 != 0) {
            y.c("hmsSdk", "refresh components");
            n10 = 128;
            string2 = d.j.f.a.a.h.f.b.f(n10);
            this.a(string6, string2);
            string6 = d.j.f.a.a.h.f.b.f(n10);
            this.a(string5, string6);
            string5 = d.j.f.a.a.h.f.b.f(n10);
            this.a(string4, string5);
            object = d.j.f.a.a.h.f.b.f(n10);
            this.a(string3, (String)object);
            string3 = b.f();
            long l10 = System.currentTimeMillis();
            string4 = "Privacy_MY";
            String string7 = "assemblyFlash";
            g0.b((Context)string3, string4, string7, l10);
        } else {
            string2 = this.b(string6);
            string6 = this.b(string5);
            string5 = this.b(string4);
            object = this.b(string3);
        }
        object2 = this.a(string2, string6, string5, (String)object2);
        object = c.c((String)object);
        return c.b(d.j.f.a.a.h.c.c.c((char[])object2, (byte[])object, 10000, 16));
    }

    public final String a(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = this.a;
        stringBuilder.append(string3);
        string2 = "/hms/component/".replace("component", string2);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void a(String string2, String string3) {
        Object object = this.a(string2);
        File file = new File((String)object);
        String string4 = this.a(string2);
        StringBuilder stringBuilder = new StringBuilder();
        String string5 = "hianalytics_";
        stringBuilder.append(string5);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new File(string4, string2);
        boolean bl2 = file.exists();
        string4 = "hmsSdk";
        if (!bl2 && (bl2 = file.mkdirs())) {
            string2 = "file directory is mkdirs";
            y.c(string4, string2);
        }
        if (bl2 = this.a((File)object)) {
            r0.a((File)object, string3);
        } else {
            string2 = "refreshComponent():file is not found,and file is create failed";
            y.f(string4, string2);
        }
    }

    public final boolean a(File file) {
        boolean bl2 = file.exists();
        if (bl2) {
            return true;
        }
        try {
            return file.createNewFile();
        }
        catch (IOException iOException) {
            y.f("hmsSdk", "create new file error!");
            return false;
        }
    }

    public final char[] a(String object, String object2, String object3, String object4) {
        object = c.c((String)object);
        object2 = c.c((String)object2);
        object3 = c.c((String)object3);
        object4 = c.c((String)object4);
        int n10 = ((Object)object).length;
        int n11 = ((Object)object2).length;
        if (n10 > n11) {
            n10 = ((Object)object2).length;
        }
        if (n10 > (n11 = ((Object)object3).length)) {
            n10 = ((Object)object3).length;
        }
        if (n10 > (n11 = ((Object)object4).length)) {
            n10 = ((Object)object4).length;
        }
        char[] cArray = new char[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object5 = object[i10];
            Object object6 = object2[i10];
            object5 = object5 ^ object6;
            object6 = object3[i10];
            object5 = object5 ^ object6;
            object6 = object4[i10];
            object5 = (char)(object5 ^ object6);
            cArray[i10] = (char)object5;
        }
        return cArray;
    }

    public final String b(String string2) {
        String string3 = this.a(string2);
        StringBuilder stringBuilder = new StringBuilder();
        String string4 = "hianalytics_";
        stringBuilder.append(string4);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        File file = new File(string3, string2);
        boolean bl2 = this.a(file);
        if (bl2) {
            return r0.a(file);
        }
        string2 = d.j.f.a.a.h.f.b.f(128);
        r0.a(file, string2);
        return string2;
    }

    public final boolean b() {
        Context context = b.f();
        String string2 = "Privacy_MY";
        String string3 = "assemblyFlash";
        long l10 = -1;
        long l11 = g0.a(context, string2, string3, l10);
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        boolean bl2 = true;
        if (l12 == false) {
            y.c("hmsSdk", "First init components");
            return bl2;
        }
        long l13 = System.currentTimeMillis() - l11;
        long l14 = l13 - (l11 = 31536000000L);
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public final String c() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }
}

