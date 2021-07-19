/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.os.Process
 *  android.text.TextUtils
 */
package com.baidu.location.c;

import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.b.b;
import com.baidu.location.f;
import com.baidu.location.f.i;
import com.baidu.location.g.a;
import com.baidu.location.h.d;
import com.baidu.location.h.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;

public class g
implements Thread.UncaughtExceptionHandler {
    private static g a;
    private int b = 0;

    private g() {
    }

    public static g a() {
        g g10 = a;
        if (g10 == null) {
            a = g10 = new g();
        }
        return a;
    }

    private String a(Throwable throwable) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        throwable.printStackTrace(printWriter);
        printWriter.close();
        return ((Object)stringWriter).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(File object, String string2, String string3) {
        try {
            String string4 = "rw";
            RandomAccessFile randomAccessFile = new RandomAccessFile((File)object, string4);
            long l10 = 280L;
            randomAccessFile.seek(l10);
            int n10 = 12346;
            randomAccessFile.writeInt(n10);
            long l11 = 300L;
            randomAccessFile.seek(l11);
            l11 = System.currentTimeMillis();
            randomAccessFile.writeLong(l11);
            object = string2.getBytes();
            int n11 = ((Object)object).length;
            randomAccessFile.writeInt(n11);
            n11 = ((Object)object).length;
            randomAccessFile.write((byte[])object, 0, n11);
            long l12 = 600L;
            randomAccessFile.seek(l12);
            object = string3.getBytes();
            n11 = ((Object)object).length;
            randomAccessFile.writeInt(n11);
            n11 = ((Object)object).length;
            randomAccessFile.write((byte[])object, 0, n11);
            n10 = (int)(this.a(string2, string3) ? 1 : 0);
            if (n10 == 0) {
                randomAccessFile.seek(l10);
                n10 = 1326;
                randomAccessFile.writeInt(n10);
            }
            randomAccessFile.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean a(String object, String string2) {
        Object object2 = "&";
        Object object3 = "=";
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) return false;
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return false;
        }
        Object object4 = i.a();
        bl2 = ((i)object4).j();
        if (!bl2) {
            return false;
        }
        try {
            CharSequence charSequence = l.e;
            object4 = new URL((String)charSequence);
            charSequence = new StringBuffer();
            String string3 = "e0";
            ((StringBuffer)charSequence).append(string3);
            ((StringBuffer)charSequence).append((String)object3);
            ((StringBuffer)charSequence).append((String)object);
            ((StringBuffer)charSequence).append((String)object2);
            object = "e1";
            ((StringBuffer)charSequence).append((String)object);
            ((StringBuffer)charSequence).append((String)object3);
            ((StringBuffer)charSequence).append(string2);
            ((StringBuffer)charSequence).append((String)object2);
            int n10 = ((StringBuffer)charSequence).length();
            int n11 = 1;
            if (n10 > 0) {
                n10 = ((StringBuffer)charSequence).length() - n11;
                ((StringBuffer)charSequence).deleteCharAt(n10);
            }
            object = ((URL)object4).openConnection();
            object = FirebasePerfUrlConnection.instrument(object);
            object = (URLConnection)object;
            object = (HttpsURLConnection)object;
            object2 = "POST";
            ((HttpURLConnection)object).setRequestMethod((String)object2);
            ((URLConnection)object).setDoInput(n11 != 0);
            ((URLConnection)object).setDoOutput(n11 != 0);
            ((URLConnection)object).setUseCaches(false);
            int n12 = com.baidu.location.h.a.b;
            ((URLConnection)object).setConnectTimeout(n12);
            n12 = com.baidu.location.h.a.b;
            ((URLConnection)object).setReadTimeout(n12);
            object2 = "Content-Type";
            object3 = "application/x-www-form-urlencoded; charset=utf-8";
            ((URLConnection)object).setRequestProperty((String)object2, (String)object3);
            object2 = "Accept-Charset";
            object3 = "UTF-8";
            ((URLConnection)object).setRequestProperty((String)object2, (String)object3);
            object2 = ((URLConnection)object).getOutputStream();
            object3 = ((StringBuffer)charSequence).toString();
            object3 = ((String)object3).getBytes();
            ((OutputStream)object2).write((byte[])object3);
            ((OutputStream)object2).flush();
            ((OutputStream)object2).close();
            n10 = ((HttpURLConnection)object).getResponseCode();
            n12 = 200;
            if (n10 != n12) return false;
            return n11 != 0;
        }
        catch (Exception exception) {}
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        try {
            Object object = new StringBuilder();
            Object object2 = Environment.getExternalStorageDirectory();
            object2 = ((File)object2).getPath();
            ((StringBuilder)object).append((String)object2);
            object2 = "/traces";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)object);
            object = "/error_fs2.dat";
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            object2 = new File((String)object);
            boolean bl2 = ((File)object2).exists();
            if (!bl2) return;
            String string2 = "rw";
            object = new RandomAccessFile((File)object2, string2);
            long l10 = 280L;
            ((RandomAccessFile)object).seek(l10);
            int n10 = ((RandomAccessFile)object).readInt();
            int n11 = 1326;
            if (n11 == n10) {
                String string3;
                long l11 = 308L;
                ((RandomAccessFile)object).seek(l11);
                n10 = ((RandomAccessFile)object).readInt();
                n11 = 2048;
                String string4 = null;
                if (n10 > 0 && n10 < n11) {
                    byte[] byArray = new byte[n10];
                    ((RandomAccessFile)object).read(byArray, 0, n10);
                    string3 = new String(byArray, 0, n10);
                } else {
                    string3 = null;
                }
                long l12 = 600L;
                ((RandomAccessFile)object).seek(l12);
                n10 = ((RandomAccessFile)object).readInt();
                if (n10 > 0 && n10 < n11) {
                    byte[] byArray = new byte[n10];
                    ((RandomAccessFile)object).read(byArray, 0, n10);
                    string4 = new String(byArray, 0, n10);
                }
                if ((n10 = (int)(this.a(string3, string4) ? 1 : 0)) != 0) {
                    ((RandomAccessFile)object).seek(l10);
                    int n12 = 12346;
                    ((RandomAccessFile)object).writeInt(n12);
                }
            }
            ((RandomAccessFile)object).close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void uncaughtException(Thread var1_1, Throwable var2_2) {
        block24: {
            var3_3 = this.b;
            var4_4 = 1;
            var5_5 = 1.4E-45f;
            this.b = var3_3 += var4_4;
            var6_6 = 2;
            var7_7 = 2.8E-45f;
            if (var3_3 > var6_6) break block24;
            var8_8 = System.currentTimeMillis();
            var10_9 = com.baidu.location.g.a.b();
            cfr_temp_0 = (var8_8 -= var10_9) - (var10_9 = 10000L);
            var3_3 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
            if (var3_3 < 0 && (var3_3 = (int)((cfr_temp_1 = (var12_10 = 8.4f) - (var7_7 = f.getFrameVersion())) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) > 0) {
                var1_1 = d.a();
                var8_8 = var1_1.c();
                var10_9 = System.currentTimeMillis() - var8_8;
                cfr_temp_2 = var10_9 - (var8_8 = 40000L);
                var3_3 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                if (var3_3 < 0) {
                    var13_11 = new StringBuilder();
                    var14_12 = l.j();
                    var13_11.append((String)var14_12);
                    var14_12 = File.separator;
                    var13_11.append((String)var14_12);
                    var14_12 = f.getJarFileName();
                    var13_11.append((String)var14_12);
                    var13_11 = var13_11.toString();
                    var1_1 = new File((String)var13_11);
                    var6_6 = (int)var1_1.exists();
                    if (var6_6 != 0) {
                        var1_1.delete();
                    }
                } else {
                    var1_1 = d.a();
                    var8_8 = System.currentTimeMillis();
                    var1_1.b(var8_8);
                }
            }
            var3_3 = 0;
            var12_10 = 0.0f;
            var1_1 = null;
            var6_6 = 0;
            var7_7 = 0.0f;
            var13_11 = null;
            var2_2 = this.a((Throwable)var2_2);
            if (var2_2 != null) {
                var14_12 = "com.baidu.location";
            }
            ** GOTO lbl58
        }
lbl52:
        // 5 sources

        while (true) {
            Process.killProcess((int)Process.myPid());
            return;
        }
        try {
            block25: {
                var15_13 = var2_2.contains((CharSequence)var14_12);
                if (var15_13) break block25;
lbl58:
                // 2 sources

                var4_4 = 0;
                var16_14 = null;
                var5_5 = 0.0f;
            }
            var14_12 = com.baidu.location.h.b.a();
            var14_12 = var14_12.a(false);
            var17_15 = new StringBuilder();
            var17_15.append((String)var14_12);
            var14_12 = com.baidu.location.b.b.a();
            var14_12 = var14_12.d();
            var17_15.append((String)var14_12);
            var14_12 = var17_15.toString();
            if (var14_12 != null) {
                var1_1 = Jni.encode((String)var14_12);
            } else {
                var3_3 = 0;
                var1_1 = null;
                var12_10 = 0.0f;
            }
            var18_16 = var2_2;
            var2_2 = var1_1;
            var3_3 = var4_4;
            var12_10 = var5_5;
            var16_14 = var18_16;
        }
        catch (Exception v2) {
            ** continue;
        }
lbl83:
        // 2 sources

        while (true) {
            if (var3_3 == 0) ** GOTO lbl52
            try {
                block26: {
                    var1_1 = new StringBuilder();
                    var14_12 = Environment.getExternalStorageDirectory();
                    var14_12 = var14_12.getPath();
                    var1_1.append((String)var14_12);
                    var14_12 = "/traces";
                    var1_1.append((String)var14_12);
                    var1_1 = var1_1.toString();
                    var14_12 = new StringBuilder();
                    var14_12.append((String)var1_1);
                    var17_15 = "/error_fs2.dat";
                    var14_12.append((String)var17_15);
                    var14_12 = var14_12.toString();
                    var17_15 = new File((String)var14_12);
                    var15_13 = var17_15.exists();
                    if (var15_13) break block26;
                    var14_12 = new File((String)var1_1);
                    var3_3 = (int)var14_12.exists();
                    if (var3_3 == 0) {
                        var14_12.mkdirs();
                    }
                    if ((var3_3 = (int)var17_15.createNewFile()) != 0) {
                        var13_11 = var17_15;
                    }
                    this.a((File)var13_11, (String)var2_2, (String)var16_14);
                    ** GOTO lbl52
                }
                var13_11 = "rw";
                var1_1 = new RandomAccessFile((File)var17_15, (String)var13_11);
                var8_8 = 300L;
                var1_1.seek(var8_8);
                var8_8 = var1_1.readLong();
                var19_17 = System.currentTimeMillis() - var8_8;
                var8_8 = 86400000L;
            }
            catch (Exception v0) {
            }
            var6_6 = (int)(var19_17 == var8_8 ? 0 : (var19_17 < var8_8 ? -1 : 1));
            if (var6_6 <= 0) ** GOTO lbl128
            {
                this.a((File)var17_15, (String)var2_2, (String)var16_14);
lbl128:
                // 2 sources

                var1_1.close();
            }
            ** continue;
            break;
        }
        catch (Exception v1) {
            var2_2 = null;
lbl132:
            // 2 sources

            while (true) {
                var16_14 = var2_2;
                var2_2 = null;
                ** continue;
                break;
            }
        }
    }
}

