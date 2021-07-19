/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.y;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class s {
    private static volatile s a;
    private static final Object a;
    private Context a;

    static {
        Object object;
        a = object = new Object();
    }

    private s(Context context) {
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static s a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = s.class;
        synchronized (object) {
            s s10 = a;
            if (s10 != null) return a;
            a = s10 = new s(context);
            return a;
        }
    }

    private File a(String string2) {
        int n10;
        CharSequence charSequence = new StringBuilder();
        File file = this.a.getFilesDir();
        charSequence.append(file);
        charSequence.append("/crash");
        charSequence = charSequence.toString();
        File[] fileArray = new File((String)charSequence);
        int n11 = fileArray.exists();
        file = null;
        if (n11 == 0) {
            fileArray.mkdirs();
            return null;
        }
        fileArray = fileArray.listFiles();
        charSequence = null;
        for (n11 = 0; n11 < (n10 = fileArray.length); ++n11) {
            Object object = fileArray[n11];
            n10 = (int)(((File)object).isFile() ? 1 : 0);
            if (n10 == 0 || (n10 = (int)(((String)(object = fileArray[n11].getName())).startsWith(string2) ? 1 : 0)) == 0) continue;
            return fileArray[n11];
        }
        return null;
    }

    public String a(File stringArray) {
        int n10;
        String string2 = "";
        if (stringArray == null) {
            return string2;
        }
        stringArray = stringArray.getName();
        String string3 = ":";
        int n11 = (stringArray = stringArray.split(string3)).length;
        if (n11 != (n10 = 2)) {
            return string2;
        }
        return stringArray[0];
    }

    public ArrayList a() {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        CharSequence charSequence = new StringBuilder();
        Object object = this.a.getFilesDir();
        charSequence.append(object);
        object = "/crash";
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        File[] fileArray = new File((String)charSequence);
        int n11 = fileArray.exists();
        if (n11 == 0) {
            fileArray.mkdirs();
            return arrayList;
        }
        fileArray = fileArray.listFiles();
        charSequence = null;
        for (n11 = 0; n11 < (n10 = fileArray.length); ++n11) {
            int n12;
            object = fileArray[n11].getName();
            String string2 = ":";
            int n13 = ((String[])(object = ((String)object).split(string2))).length;
            if (n13 < (n12 = 2) || (n10 = Integer.parseInt((String)(object = object[n13 = 1]))) < n13 || (n10 = (int)(((File)(object = fileArray[n11])).isFile() ? 1 : 0)) == 0) continue;
            object = fileArray[n11];
            arrayList.add(object);
        }
        return arrayList;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String var1_1, String var2_7) {
        var3_8 = TextUtils.isEmpty((CharSequence)var2_7);
        if (var3_8 != false) return;
        var3_8 = TextUtils.isEmpty((CharSequence)var1_1 /* !! */ );
        if (var3_8) {
            return;
        }
        var4_9 = s.a;
        synchronized (var4_9) {
            block13: {
                block15: {
                    block14: {
                        var5_10 = this.a(var2_7);
                        if (var5_10 == null) break block14;
                        var1_1 /* !! */  = var5_10.getName();
                        var6_11 = ":";
                        var7_13 = (var1_1 /* !! */  = var1_1 /* !! */ .split((String)var6_11)).length;
                        if (var7_13 < (var8_14 = 2)) {
                            return;
                        }
                        var7_13 = 1;
                        var1_1 /* !! */  = var1_1 /* !! */ [var7_13];
                        var9_15 = Integer.parseInt((String)var1_1 /* !! */ ) + var7_13;
                        var10_16 = new StringBuilder();
                        var11_18 /* !! */  = this.a;
                        var11_18 /* !! */  = var11_18 /* !! */ .getFilesDir();
                        var10_16.append(var11_18 /* !! */ );
                        var11_18 /* !! */  = "/crash";
                        var10_16.append((String)var11_18 /* !! */ );
                        var11_18 /* !! */  = "/";
                        var10_16.append((String)var11_18 /* !! */ );
                        var10_16.append(var2_7);
                        var2_7 = ":";
                        var10_16.append(var2_7);
                        var1_1 /* !! */  = String.valueOf(var9_15);
                        var10_16.append((String)var1_1 /* !! */ );
                        var1_1 /* !! */  = var10_16.toString();
                        var6_11 = new File((String)var1_1 /* !! */ );
                        var5_10.renameTo((File)var6_11);
                        break block15;
                    }
                    var5_10 = null;
                    try {
                        var11_19 = new StringBuilder();
                        var12_20 /* !! */  = this.a;
                        var12_20 /* !! */  = var12_20 /* !! */ .getFilesDir();
                        var11_19.append(var12_20 /* !! */ );
                        var12_20 /* !! */  = "/crash";
                        var11_19.append((String)var12_20 /* !! */ );
                        var12_20 /* !! */  = "/";
                        var11_19.append((String)var12_20 /* !! */ );
                        var11_19.append(var2_7);
                        var2_7 = ":";
                        var11_19.append(var2_7);
                        var2_7 = "1";
                        var11_19.append(var2_7);
                        var2_7 = var11_19.toString();
                        var10_17 = new File(var2_7);
                        var6_12 = new FileOutputStream(var10_17);
                    }
                    catch (Throwable var1_4) {
                        break block13;
                    }
                    catch (Exception var1_5) {
                        // empty catch block
                        ** GOTO lbl-1000
                    }
                    try {
                        var1_1 /* !! */  = (String[])var1_1 /* !! */ .getBytes();
                        var6_12.write((byte[])var1_1 /* !! */ );
                        var6_12.flush();
                    }
                    catch (Throwable var1_2) {
                        var5_10 = var6_12;
                        break block13;
                    }
                    catch (Exception var1_3) {
                        var5_10 = var6_12;
                        ** GOTO lbl-1000
                    }
                    y.a(var6_12);
                    break block15;
lbl-1000:
                    // 2 sources

                    {
                        b.a((Throwable)var1_1 /* !! */ );
                    }
                    y.a((Closeable)var5_10);
                }
                return;
            }
            y.a((Closeable)var5_10);
            throw var1_6;
        }
    }
}

