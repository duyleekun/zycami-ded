/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.os.Build;
import android.os.Handler;
import com.baidu.location.Jni;
import com.baidu.location.b.u;
import com.baidu.location.b.v;
import com.baidu.location.b.w;
import com.baidu.location.b.x;
import com.baidu.location.f;
import com.baidu.location.h.b;
import com.baidu.location.h.d;
import com.baidu.location.h.k;
import com.baidu.location.h.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONObject;

public class t
extends com.baidu.location.h.f {
    private static t q;
    public String a = null;
    public String b = null;
    public String c = null;
    public String d = null;
    public int e = 1;
    public Handler f = null;

    private t() {
        Handler handler;
        this.f = handler = new Handler();
    }

    public static t a() {
        t t10 = q;
        if (t10 == null) {
            q = t10 = new t();
        }
        return q;
    }

    public static /* synthetic */ void a(t t10) {
        t10.f();
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(File file, File object) {
        void var0_3;
        Closeable closeable;
        BufferedInputStream bufferedInputStream;
        block9: {
            BufferedInputStream bufferedInputStream2;
            block10: {
                int n10;
                FileOutputStream fileOutputStream;
                int n11 = 0;
                bufferedInputStream = null;
                try {
                    closeable = new FileInputStream(file);
                    bufferedInputStream2 = new BufferedInputStream((InputStream)closeable);
                }
                catch (Throwable throwable) {
                    closeable = null;
                    break block9;
                }
                try {
                    fileOutputStream = new FileOutputStream((File)object);
                    closeable = new BufferedOutputStream(fileOutputStream);
                    n10 = 5120;
                }
                catch (Throwable throwable) {
                    closeable = null;
                    break block10;
                }
                try {
                    int n12;
                    object = new byte[n10];
                    while ((n11 = bufferedInputStream2.read((byte[])object)) != (n12 = -1)) {
                        n12 = 0;
                        fileOutputStream = null;
                        ((BufferedOutputStream)closeable).write((byte[])object, 0, n11);
                    }
                    ((BufferedOutputStream)closeable).flush();
                    file.delete();
                }
                catch (Throwable throwable) {
                    break block10;
                }
                bufferedInputStream2.close();
                ((FilterOutputStream)closeable).close();
                return;
            }
            bufferedInputStream = bufferedInputStream2;
        }
        if (bufferedInputStream != null) {
            bufferedInputStream.close();
        }
        if (closeable != null) {
            ((FilterOutputStream)closeable).close();
        }
        throw var0_3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean a(String object, String string2) {
        CharSequence charSequence = new StringBuilder();
        Object object2 = com.baidu.location.h.l.j();
        charSequence.append((String)object2);
        object2 = File.separator;
        charSequence.append((String)object2);
        object2 = "tmp";
        charSequence.append((String)object2);
        charSequence = charSequence.toString();
        File file = new File((String)charSequence);
        boolean bl2 = file.exists();
        if (bl2) {
            file.delete();
        }
        bl2 = false;
        charSequence = null;
        try {
            int n10;
            object2 = new FileOutputStream(file);
            int n11 = 4096;
            Object object3 = new byte[n11];
            Object object4 = new URL((String)object);
            object = ((URL)object4).openConnection();
            object = FirebasePerfUrlConnection.instrument(object);
            object = (URLConnection)object;
            object = (HttpsURLConnection)object;
            InputStream inputStream = ((URLConnection)object).getInputStream();
            object4 = new BufferedInputStream(inputStream);
            while ((n10 = ((FilterInputStream)object4).read((byte[])object3)) > 0) {
                ((FileOutputStream)object2).write((byte[])object3, 0, n10);
            }
            ((HttpURLConnection)object).disconnect();
            ((FileOutputStream)object2).close();
            ((BufferedInputStream)object4).close();
            long l10 = file.length();
            long l11 = 10240L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 < 0) {
                file.delete();
                return false;
            }
            object2 = new StringBuilder();
            object3 = com.baidu.location.h.l.j();
            ((StringBuilder)object2).append((String)object3);
            object3 = File.separator;
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
            object = new File(string2);
            file.renameTo((File)object);
            return true;
        }
        catch (Exception exception) {
            file.delete();
            return false;
        }
    }

    public static /* synthetic */ boolean b(t t10) {
        return t10.g();
    }

    public static /* synthetic */ void c(t t10) {
        t10.h();
    }

    private Handler d() {
        return this.f;
    }

    /*
     * Unable to fully structure code
     */
    private void e() {
        block33: {
            block32: {
                block34: {
                    var1_1 = new StringBuilder();
                    var2_2 = com.baidu.location.h.l.j();
                    var1_1.append((String)var2_2);
                    var2_2 = "/grtcfrsa.dat";
                    var1_1.append((String)var2_2);
                    var1_1 = var1_1.toString();
                    try {
                        var2_2 = new File((String)var1_1);
                        var3_3 = var2_2.exists();
                        var4_4 = 200L;
                        var6_5 = "rw";
                        if (var3_3) break block32;
                    }
                    catch (Exception v0) {
                        ** continue;
                    }
                    var7_6 = com.baidu.location.h.k.a;
                    var1_1 = new File((String)var7_6);
                    var8_7 = var1_1.exists();
                    if (var8_7) ** GOTO lbl26
                    var1_1.mkdirs();
lbl26:
                    // 2 sources

                    if (!(var3_3 = var2_2.createNewFile())) ** GOTO lbl55
                    var1_1 = new RandomAccessFile((File)var2_2, var6_5);
                    var9_8 = 2;
                    var1_1.seek(var9_8);
                    var1_1.writeInt(0);
                    var9_8 = 8;
                    var1_1.seek(var9_8);
                    var7_6 = "1980_01_01:0";
                    var7_6 = var7_6.getBytes();
                    var11_9 = ((Object)var7_6).length;
                    var1_1.writeInt(var11_9);
                    var1_1.write((byte[])var7_6);
                    var1_1.seek(var4_4);
                    var1_1.writeBoolean(false);
                    var9_8 = 800L;
                    var1_1.seek(var9_8);
                    break block34;
lbl55:
                    // 1 sources

                    return;
                }
                var1_1.writeBoolean(false);
                var1_1.close();
            }
            var1_1 = new RandomAccessFile((File)var2_2, var6_5);
            var1_1.seek(var4_4);
            var12_10 = 1;
            var13_11 = 1.4E-45f;
            var1_1.writeBoolean((boolean)var12_10);
            var14_12 = this.e;
            if (var14_12 != var12_10) break block33;
            var1_1.writeBoolean((boolean)var12_10);
            ** GOTO lbl76
        }
        var1_1.writeBoolean(false);
lbl76:
        // 2 sources

        var2_2 = this.d;
        if (var2_2 == null) ** GOTO lbl87
        var2_2 = var2_2.getBytes();
        var14_12 = ((Object)var2_2).length;
        var1_1.writeInt(var14_12);
        var1_1.write((byte[])var2_2);
        ** GOTO lbl99
lbl87:
        // 1 sources

        var13_11 = com.baidu.location.f.getFrameVersion();
        var14_12 = 1090938470;
        var15_13 = 8.4f;
        var13_11 -= var15_13;
        var13_11 = Math.abs(var13_11);
        var14_12 = 841731191;
        var15_13 = 1.0E-8f;
        var12_10 = (int)(var13_11 == var15_13 ? 0 : (var13_11 < var15_13 ? -1 : 1));
        if (var12_10 >= 0) ** GOTO lbl99
        var1_1.writeInt(0);
lbl99:
        // 3 sources

        var1_1.close();
lbl100:
        // 2 sources

    }

    private void f() {
        Object object = this.a;
        if (object == null) {
            return;
        }
        object = new x(this);
        ((Thread)object).start();
    }

    private boolean g() {
        Object object = this.c;
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        CharSequence charSequence = "../";
        boolean bl3 = ((String)object).contains(charSequence);
        if (bl3) {
            return false;
        }
        charSequence = new StringBuilder();
        String string2 = com.baidu.location.h.l.j();
        ((StringBuilder)charSequence).append(string2);
        string2 = File.separator;
        ((StringBuilder)charSequence).append(string2);
        string2 = this.c;
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        object = new File((String)charSequence);
        bl3 = ((File)object).exists();
        if (bl3) {
            return bl2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("https://");
        String string3 = this.a;
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append("/");
        string3 = this.c;
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        string3 = this.c;
        return t.a((String)object, string3);
    }

    private void h() {
        Object object;
        boolean bl2;
        Object object2 = this.b;
        if (object2 != null && !(bl2 = ((String)object2).contains((CharSequence)(object = "../")))) {
            object = new StringBuilder();
            String string2 = com.baidu.location.h.l.j();
            ((StringBuilder)object).append(string2);
            string2 = File.separator;
            ((StringBuilder)object).append(string2);
            CharSequence charSequence = this.b;
            ((StringBuilder)object).append((String)charSequence);
            object = ((StringBuilder)object).toString();
            object2 = new File((String)object);
            boolean bl3 = ((File)object2).exists();
            if (!bl3) {
                String string3;
                object = new StringBuilder();
                ((StringBuilder)object).append("https://");
                charSequence = this.a;
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append("/");
                charSequence = this.b;
                ((StringBuilder)object).append((String)charSequence);
                object = ((StringBuilder)object).toString();
                charSequence = this.b;
                bl3 = t.a((String)object, (String)charSequence);
                if (!bl3) {
                    return;
                }
                object = com.baidu.location.h.l.a((File)object2, "SHA-256");
                charSequence = this.d;
                if (charSequence != null && object != null && (bl3 = com.baidu.location.h.l.b((String)object, (String)charSequence, string3 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCiP7BS5IjEOzrKGR9/Ww9oSDhdX1ir26VOsYjT1T6tk2XumRpkHRwZbrucDcNnvSB4QsqiEJnvTSRi7YMbh2H9sLMkcvHlMV5jAErNvnuskWfcvf7T2mq7EUZI/Hf4oVZhHV0hQJRFVdTcjWI6q2uaaKM3VMh+roDesiE7CR2biQIDAQAB"))) {
                    charSequence = new StringBuilder();
                    string3 = com.baidu.location.h.l.j();
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(string2);
                    string2 = com.baidu.location.f.replaceFileName;
                    ((StringBuilder)charSequence).append(string2);
                    string2 = ((StringBuilder)charSequence).toString();
                    object = new File(string2);
                    boolean bl4 = ((File)object).exists();
                    if (bl4) {
                        ((File)object).delete();
                    }
                    try {
                        t.a((File)object2, (File)object);
                    }
                    catch (Exception exception) {
                        ((File)object).delete();
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        Object object = "u1_rsa";
        String string2 = "u2";
        String string3 = "u1";
        String string4 = "upath";
        String string5 = "ison";
        if (!bl2) return;
        try {
            boolean bl3;
            String string6 = this.j;
            JSONObject jSONObject = new JSONObject(string6);
            string6 = "res";
            string6 = jSONObject.getString(string6);
            String string7 = "up";
            boolean bl4 = string7.equals(string6);
            if (bl4) {
                boolean bl5;
                boolean bl6;
                boolean bl7;
                boolean bl8 = jSONObject.has(string4);
                if (bl8) {
                    this.a = string6 = jSONObject.getString(string4);
                }
                if (bl7 = jSONObject.has(string3)) {
                    this.b = string6 = jSONObject.getString(string3);
                }
                if (bl6 = jSONObject.has(string2)) {
                    this.c = string6 = jSONObject.getString(string2);
                }
                if (bl5 = jSONObject.has((String)object)) {
                    this.d = string6 = jSONObject.getString((String)object);
                }
                string6 = this.d();
                object = new w(this);
                string6.post((Runnable)object);
            }
            if (bl3 = jSONObject.has(string5)) {
                int n10;
                this.e = n10 = jSONObject.getInt(string5);
            }
            this.e();
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
    public void b() {
        String string2;
        String string3;
        CharSequence charSequence;
        StringBuffer stringBuffer;
        block11: {
            int n10;
            CharSequence charSequence2;
            String[] stringArray;
            int n11;
            block10: {
                int n12;
                int n13;
                stringBuffer = new StringBuffer(128);
                stringBuffer.append("&sdk=");
                stringBuffer.append(8.4f);
                stringBuffer.append("&fw=");
                float f10 = com.baidu.location.f.getFrameVersion();
                stringBuffer.append(f10);
                stringBuffer.append("&suit=");
                int n14 = 2;
                f10 = 2.8E-45f;
                stringBuffer.append(n14);
                charSequence = com.baidu.location.h.b.a().c;
                if (charSequence == null) {
                    stringBuffer.append("&im=");
                    charSequence = com.baidu.location.h.b.a().a;
                } else {
                    stringBuffer.append("&cu=");
                    charSequence = com.baidu.location.h.b.a().c;
                }
                stringBuffer.append((String)charSequence);
                stringBuffer.append("&mb=");
                charSequence = Build.MODEL;
                stringBuffer.append((String)charSequence);
                stringBuffer.append("&sv=");
                charSequence = Build.VERSION.RELEASE;
                n11 = 0;
                string3 = null;
                if (charSequence != null && (n13 = ((String)charSequence).length()) > (n12 = 10)) {
                    charSequence = ((String)charSequence).substring(0, n12);
                }
                stringBuffer.append((String)charSequence);
                n14 = 0;
                f10 = 0.0f;
                charSequence = null;
                try {
                    n13 = Build.VERSION.SDK_INT;
                    n12 = 20;
                    if (n13 > n12) {
                        stringArray = Build.SUPPORTED_ABIS;
                        n12 = 0;
                        charSequence2 = null;
                        break block10;
                    }
                    charSequence = Build.CPU_ABI2;
                }
                catch (Error | Exception throwable) {}
                break block11;
            }
            while (n11 < (n10 = stringArray.length)) {
                CharSequence charSequence3;
                String string4 = ";";
                if (n11 == 0) {
                    charSequence2 = new StringBuilder();
                    charSequence3 = stringArray[n11];
                    ((StringBuilder)charSequence2).append((String)charSequence3);
                    ((StringBuilder)charSequence2).append(string4);
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                } else {
                    charSequence3 = new StringBuilder();
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    charSequence2 = stringArray[n11];
                    ((StringBuilder)charSequence3).append((String)charSequence2);
                    ((StringBuilder)charSequence3).append(string4);
                    charSequence2 = ((StringBuilder)charSequence3).toString();
                }
                ++n11;
            }
            charSequence = charSequence2;
        }
        if (charSequence != null) {
            string3 = "&cpuabi=";
            stringBuffer.append(string3);
            stringBuffer.append((String)charSequence);
        }
        stringBuffer.append("&pack=");
        charSequence = com.baidu.location.h.b.e;
        stringBuffer.append((String)charSequence);
        charSequence = new StringBuilder();
        string3 = com.baidu.location.h.l.f();
        ((StringBuilder)charSequence).append(string3);
        ((StringBuilder)charSequence).append("?&it=");
        String string5 = Jni.en1(stringBuffer.toString());
        ((StringBuilder)charSequence).append(string5);
        this.h = string2 = ((StringBuilder)charSequence).toString();
    }

    public void c() {
        d d10 = com.baidu.location.h.d.a();
        long l10 = d10.b();
        long l11 = System.currentTimeMillis() - l10;
        long l12 = l11 - (l10 = 86400000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            d10 = com.baidu.location.h.d.a();
            long l13 = System.currentTimeMillis();
            d10.a(l13);
            d10 = this.d();
            Runnable runnable = new u(this);
            d10.postDelayed(runnable, 10000L);
            d10 = this.d();
            runnable = new v(this);
            l11 = 5000L;
            d10.postDelayed(runnable, l11);
        }
    }
}

