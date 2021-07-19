/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.content.Context
 *  android.location.Location
 *  android.os.Handler
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.location.b;

import android.app.ActivityManager;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import com.baidu.location.b.b;
import com.baidu.location.b.g$a;
import com.baidu.location.b.h;
import com.baidu.location.b.i;
import com.baidu.location.c.d;
import com.baidu.location.f;
import com.baidu.location.f.e;
import com.baidu.location.h.k;
import com.baidu.location.h.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    public static String f = "0";
    private static g j;
    private g$a A;
    private boolean B;
    private boolean C;
    private int D;
    private float E;
    private float F;
    private long G;
    private int H;
    private Handler I;
    private byte[] J;
    private byte[] K;
    private int L;
    private List M;
    private boolean N;
    public long a;
    public Location b;
    public Location c;
    public StringBuilder d;
    public long e;
    public int g;
    public double h;
    public double i;
    private int k;
    private double l;
    private String m;
    private int n;
    private int o;
    private int p;
    private int q;
    private double r;
    private double s;
    private double t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private long z;

    private g() {
        Handler handler;
        long l10;
        int n10;
        this.k = n10 = 1;
        this.l = 0.7f;
        this.m = "3G|4G";
        this.n = n10;
        this.o = 307200;
        this.p = 15;
        this.q = n10;
        this.r = 3.5;
        this.s = 3.0;
        this.t = 0.5;
        this.u = 300;
        this.v = n10 = 60;
        this.w = 0;
        this.x = n10;
        this.y = 0;
        this.z = l10 = 0L;
        this.A = null;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = 0.0f;
        this.F = 0.0f;
        this.G = l10;
        this.H = 500;
        this.a = l10;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = l10;
        this.I = null;
        byte[] byArray = new byte[4];
        this.J = byArray;
        this.K = null;
        this.L = 0;
        this.M = null;
        this.N = false;
        this.g = 0;
        this.h = 116.22345545;
        this.i = 40.245667323;
        this.I = handler = new Handler();
    }

    public static g a() {
        g g10 = j;
        if (g10 == null) {
            j = g10 = new g();
        }
        return j;
    }

    public static /* synthetic */ String a(g g10, File file, String string2) {
        return g10.a(file, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String a(File object, String object2) {
        String string2 = UUID.randomUUID().toString();
        String string3 = "--";
        String string4 = "\r\n";
        Object object3 = "multipart/form-data";
        try {
            boolean bl2;
            URL uRL = new URL((String)object2);
            object2 = uRL.openConnection();
            object2 = FirebasePerfUrlConnection.instrument(object2);
            object2 = (URLConnection)object2;
            object2 = (HttpsURLConnection)object2;
            boolean bl3 = 10000 != 0;
            ((URLConnection)object2).setReadTimeout((int)(bl3 ? 1 : 0));
            ((URLConnection)object2).setConnectTimeout((int)(bl3 ? 1 : 0));
            bl3 = true;
            ((URLConnection)object2).setDoInput(bl3);
            ((URLConnection)object2).setDoOutput(bl3);
            bl3 = false;
            uRL = null;
            ((URLConnection)object2).setUseCaches(false);
            Object object4 = "POST";
            ((HttpURLConnection)object2).setRequestMethod((String)object4);
            object4 = "Charset";
            Object object5 = "utf-8";
            ((URLConnection)object2).setRequestProperty((String)object4, (String)object5);
            object4 = "connection";
            object5 = "close";
            ((URLConnection)object2).setRequestProperty((String)object4, (String)object5);
            object4 = "Content-Type";
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)object3);
            object3 = ";boundary=";
            ((StringBuilder)object5).append((String)object3);
            ((StringBuilder)object5).append(string2);
            object3 = ((StringBuilder)object5).toString();
            ((URLConnection)object2).setRequestProperty((String)object4, (String)object3);
            if (object == null || !(bl2 = ((File)object).exists())) return "0";
            object3 = ((URLConnection)object2).getOutputStream();
            object4 = new DataOutputStream((OutputStream)object3);
            object5 = new StringBuffer();
            ((StringBuffer)object5).append(string3);
            ((StringBuffer)object5).append(string2);
            ((StringBuffer)object5).append(string4);
            CharSequence charSequence = new StringBuilder();
            String string5 = "Content-Disposition: form-data; name=\"location_dat\"; filename=\"";
            ((StringBuilder)charSequence).append(string5);
            string5 = ((File)object).getName();
            ((StringBuilder)charSequence).append(string5);
            string5 = "\"";
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            ((StringBuffer)object5).append((String)charSequence);
            charSequence = new StringBuilder();
            string5 = "Content-Type: application/octet-stream; charset=utf-8";
            ((StringBuilder)charSequence).append(string5);
            ((StringBuilder)charSequence).append(string4);
            charSequence = ((StringBuilder)charSequence).toString();
            ((StringBuffer)object5).append((String)charSequence);
            ((StringBuffer)object5).append(string4);
            object5 = ((StringBuffer)object5).toString();
            object5 = ((String)object5).getBytes();
            ((FilterOutputStream)object4).write((byte[])object5);
            object5 = new FileInputStream((File)object);
            int n10 = 1024;
            object = new byte[n10];
            while (true) {
                int n11;
                int n12;
                if ((n12 = ((InputStream)object5).read((byte[])object)) == (n11 = -1)) {
                    int n13;
                    ((InputStream)object5).close();
                    object = string4.getBytes();
                    ((FilterOutputStream)object4).write((byte[])object);
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(string3);
                    ((StringBuilder)object).append(string4);
                    object = ((StringBuilder)object).toString();
                    object = ((String)object).getBytes();
                    ((FilterOutputStream)object4).write((byte[])object);
                    ((DataOutputStream)object4).flush();
                    ((FilterOutputStream)object4).close();
                    n10 = ((HttpURLConnection)object2).getResponseCode();
                    ((OutputStream)object3).close();
                    ((HttpURLConnection)object2).disconnect();
                    this.y = n13 = this.y + 400;
                    this.c(n13);
                    n13 = 200;
                    if (n10 != n13) return "0";
                    return "1";
                }
                ((DataOutputStream)object4).write((byte[])object, 0, n12);
            }
        }
        catch (IOException | MalformedURLException iOException) {}
        return "0";
    }

    public static /* synthetic */ void a(g g10, Location location) {
        g10.b(location);
    }

    public static /* synthetic */ void a(g g10, String string2) {
        g10.e(string2);
    }

    private boolean a(String string2, Context object) {
        boolean bl2;
        block12: {
            int n10;
            bl2 = false;
            String string3 = "activity";
            object = object.getSystemService(string3);
            object = (ActivityManager)object;
            object = object.getRunningAppProcesses();
            if (object == null) break block12;
            try {
                object = object.iterator();
            }
            catch (Exception exception) {}
            while (true) {
                n10 = object.hasNext();
                if (n10 == 0) break block12;
                break;
            }
            {
                string3 = object.next();
                string3 = (ActivityManager.RunningAppProcessInfo)string3;
                String string4 = ((ActivityManager.RunningAppProcessInfo)string3).processName;
                int n11 = string4.equals(string2);
                if (n11 == 0) continue;
                n10 = ((ActivityManager.RunningAppProcessInfo)string3).importance;
                n11 = 200;
                if (n10 != n11 && n10 != (n11 = 100)) continue;
                bl2 = true;
                continue;
            }
        }
        return bl2;
    }

    private byte[] a(int n10) {
        byte by2 = (byte)(n10 & 0xFF);
        by2 = (byte)((0xFF00 & n10) >> 8);
        by2 = (byte)((0xFF0000 & n10) >> 16);
        byte[] byArray = new byte[]{by2, by2, by2, n10 = (int)((byte)((n10 & 0xFF000000) >> 24))};
        return byArray;
    }

    private byte[] a(String object) {
        if (object == null) {
            return null;
        }
        object = ((String)object).getBytes();
        Random random = new Random();
        int n10 = 255;
        byte by2 = (byte)random.nextInt(n10);
        Object object2 = new Random();
        n10 = (byte)((Random)object2).nextInt(n10);
        int n11 = ((Object)object).length + 2;
        object2 = new byte[n11];
        int n12 = ((Object)object).length;
        int n13 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            Object object3 = object[i10];
            int n14 = n13 + 1;
            object2[n13] = object3 = (Object)((byte)(object3 ^ by2));
            n13 = n14;
        }
        int n15 = n13 + 1;
        object2[n13] = by2;
        object2[n15] = n10;
        return object2;
    }

    private String b(String string2) {
        Comparable<Calendar> comparable = Calendar.getInstance();
        Object[] objectArray = new Object[3];
        int n10 = 1;
        Integer n11 = comparable.get(n10);
        objectArray[0] = n11;
        int n12 = 2;
        Integer n13 = comparable.get(n12) + n10;
        objectArray[n10] = n13;
        comparable = comparable.get(5);
        objectArray[n12] = comparable;
        return String.format(string2, objectArray);
    }

    private void b(int n10) {
        int n11;
        byte[] byArray = this.a(n10);
        for (int i10 = 0; i10 < (n11 = 4); ++i10) {
            List list = this.M;
            byte by2 = byArray[i10];
            Byte by3 = by2;
            list.add(by3);
        }
    }

    private void b(Location location) {
        this.c(location);
        this.h();
    }

    private void c() {
        boolean bl2 = this.N;
        if (bl2) {
            return;
        }
        this.N = true;
        String string2 = com.baidu.location.h.b.e;
        this.d(string2);
        this.j();
        this.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(int n10) {
        if (n10 == 0) {
            return;
        }
        Object object = new StringBuilder();
        Object object2 = com.baidu.location.h.k.a;
        ((StringBuilder)object).append((String)object2);
        object2 = "/grtcf.dat";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        try {
            object2 = new File((String)object);
            boolean bl2 = ((File)object2).exists();
            long l10 = 8;
            String string2 = "rw";
            if (!bl2) {
                String string3 = com.baidu.location.h.k.a;
                object = new File(string3);
                boolean bl3 = ((File)object).exists();
                if (!bl3) {
                    ((File)object).mkdirs();
                }
                if (!(bl2 = ((File)object2).createNewFile())) return;
                object = new RandomAccessFile((File)object2, string2);
                long l11 = 2;
                ((RandomAccessFile)object).seek(l11);
                bl3 = false;
                string3 = null;
                ((RandomAccessFile)object).writeInt(0);
                ((RandomAccessFile)object).seek(l10);
                Object object3 = "1980_01_01:0";
                object3 = ((String)object3).getBytes();
                int n11 = ((Object)object3).length;
                ((RandomAccessFile)object).writeInt(n11);
                ((RandomAccessFile)object).write((byte[])object3);
                long l12 = 200L;
                ((RandomAccessFile)object).seek(l12);
                ((RandomAccessFile)object).writeBoolean(false);
                l12 = 800L;
                ((RandomAccessFile)object).seek(l12);
                ((RandomAccessFile)object).writeBoolean(false);
                ((RandomAccessFile)object).close();
            }
            object = new RandomAccessFile((File)object2, string2);
            ((RandomAccessFile)object).seek(l10);
            object2 = new StringBuilder();
            String string4 = "%d_%02d_%02d";
            string4 = this.b(string4);
            ((StringBuilder)object2).append(string4);
            string4 = ":";
            ((StringBuilder)object2).append(string4);
            ((StringBuilder)object2).append(n10);
            Object object4 = ((StringBuilder)object2).toString();
            object4 = ((String)object4).getBytes();
            int n12 = ((Object)object4).length;
            ((RandomAccessFile)object).writeInt(n12);
            ((RandomAccessFile)object).write((byte[])object4);
            ((RandomAccessFile)object).close();
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
    private void c(Location location) {
        int n10;
        float f10;
        float f11;
        float f12;
        float f13;
        boolean bl2;
        long l10 = System.currentTimeMillis();
        long l11 = this.a;
        int n11 = this.H;
        long l12 = (l10 -= l11) - (l11 = (long)n11);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) return;
        if (location == null) {
            return;
        }
        if (location != null && (bl2 = location.hasSpeed()) && (f13 = (f12 = (f11 = location.getSpeed()) - (f10 = this.E)) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0) {
            this.E = f11 = location.getSpeed();
        }
        try {
            ArrayList arrayList = this.M;
            if (arrayList == null) {
                this.M = arrayList = new ArrayList();
                this.i();
                this.d(location);
            } else {
                this.e(location);
            }
        }
        catch (Exception exception) {}
        this.L = n10 = this.L + 1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(String string2) {
        g g10 = this;
        String string3 = string2;
        String string4 = "nondrper";
        String string5 = "nondron";
        String string6 = "stper";
        String string7 = "drstsh";
        String string8 = "stspsh";
        String string9 = "acsh";
        String string10 = "spsh";
        String string11 = "chdron";
        String string12 = "per";
        String string13 = "tcsh";
        String string14 = "tcon";
        String string15 = "net";
        String string16 = "bash";
        String string17 = "uptime";
        String string18 = "on";
        if (string2 == null) return;
        String string19 = string4;
        try {
            double d10;
            string4 = new JSONObject(string2);
            int n10 = string4.has(string18);
            if (n10 != 0) {
                this.k = n10 = string4.getInt(string18);
            }
            if ((n10 = (int)(string4.has(string16) ? 1 : 0)) != 0) {
                g10.l = d10 = string4.getDouble(string16);
            }
            if ((n10 = (int)(string4.has(string15) ? 1 : 0)) != 0) {
                g10.m = string3 = string4.getString(string15);
            }
            if ((n10 = (int)(string4.has(string14) ? 1 : 0)) != 0) {
                g10.n = n10 = string4.getInt(string14);
            }
            if ((n10 = (int)(string4.has(string13) ? 1 : 0)) != 0) {
                g10.o = n10 = string4.getInt(string13);
            }
            if ((n10 = (int)(string4.has(string12) ? 1 : 0)) != 0) {
                g10.p = n10 = string4.getInt(string12);
            }
            if ((n10 = (int)(string4.has(string11) ? 1 : 0)) != 0) {
                g10.q = n10 = string4.getInt(string11);
            }
            if ((n10 = (int)(string4.has(string10) ? 1 : 0)) != 0) {
                g10.r = d10 = string4.getDouble(string10);
            }
            if ((n10 = (int)(string4.has(string9) ? 1 : 0)) != 0) {
                g10.s = d10 = string4.getDouble(string9);
            }
            if ((n10 = (int)(string4.has(string8) ? 1 : 0)) != 0) {
                g10.t = d10 = string4.getDouble(string8);
            }
            if ((n10 = (int)(string4.has(string7) ? 1 : 0)) != 0) {
                g10.u = n10 = string4.getInt(string7);
            }
            if ((n10 = (int)(string4.has(string6) ? 1 : 0)) != 0) {
                g10.v = n10 = string4.getInt(string6);
            }
            if ((n10 = (int)(string4.has(string5) ? 1 : 0)) != 0) {
                g10.w = n10 = string4.getInt(string5);
            }
            string3 = string19;
            boolean bl2 = string4.has(string19);
            if (bl2) {
                g10.x = n10 = string4.getInt(string19);
            }
            string3 = string17;
            bl2 = string4.has(string17);
            if (bl2) {
                long l10;
                g10.z = l10 = string4.getLong(string17);
            }
            this.k();
            return;
        }
        catch (JSONException jSONException) {
            return;
        }
    }

    private void d() {
        String string2 = "\\.";
        Object object = "8.4.0".split(string2);
        int n10 = ((String[])object).length;
        byte[] byArray = this.J;
        int n11 = 0;
        byArray[0] = 0;
        byArray[1] = 0;
        byArray[2] = 0;
        int n12 = 3;
        byArray[n12] = 0;
        int n13 = 4;
        if (n10 >= n13) {
            n10 = n13;
        }
        while (n11 < n10) {
            try {
                byArray = this.J;
            }
            catch (Exception exception) {}
            Object object2 = object[n11];
            object2 = Integer.valueOf((String)object2);
            n12 = (byte)((Integer)object2 & 0xFF);
            byArray[n11] = n12;
            ++n11;
            continue;
            break;
        }
        object = new StringBuilder();
        string2 = com.baidu.location.h.b.e;
        object.append(string2);
        object.append(":");
        string2 = com.baidu.location.h.b.a().c;
        object.append(string2);
        object = object.toString();
        object = this.a((String)object);
        this.K = (byte[])object;
    }

    /*
     * WARNING - void declaration
     */
    private void d(Location location) {
        void var4_12;
        void var4_9;
        float f10;
        long l10;
        this.e = l10 = System.currentTimeMillis();
        l10 = location.getTime() / 1000L;
        int by2 = (int)l10;
        this.b(by2);
        double d10 = location.getLongitude();
        double d11 = 1000000.0;
        int n10 = (int)(d10 * d11);
        this.b(n10);
        d10 = location.getLatitude() * d11;
        int n11 = (int)d10;
        this.b(n11);
        int n12 = location.hasBearing() ^ 1;
        int n13 = location.hasSpeed() ^ 1;
        if (n12 > 0) {
            int n14 = 32;
            f10 = 4.5E-44f;
        } else {
            f10 = location.getBearing();
            float f11 = 15.0f;
            byte by3 = (byte)((byte)((int)(f10 /= f11) & 0xFF) & 0xFFFFFFDF);
        }
        List list = this.M;
        Byte by4 = (byte)var4_9;
        list.add(by4);
        if (n13 > 0) {
            int n15 = -128;
            f10 = 0.0f / 0.0f;
        } else {
            f10 = location.getSpeed();
            d10 = (double)f10 * 3.6;
            d11 = 4.0;
            byte by5 = (byte)((byte)((int)(d10 /= d11) & 0xFF) & 0x7F);
        }
        List list2 = this.M;
        by4 = (byte)var4_12;
        list2.add(by4);
        this.b = location;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void d(String var1_1) {
        block30: {
            var2_2 = ":";
            var3_3 = new StringBuilder();
            var4_4 = com.baidu.location.h.k.a;
            var3_3.append((String)var4_4);
            var4_4 = "/grtcf.dat";
            var3_3.append((String)var4_4);
            var3_3 = var3_3.toString();
            var4_4 = new File((String)var3_3);
            var5_5 = var4_4.exists();
            if (!var5_5) ** GOTO lbl83
            var6_6 = "rw";
            var3_3 = new RandomAccessFile((File)var4_4, (String)var6_6);
            var7_7 = 2;
            var3_3.seek(var7_7);
            var9_8 = var3_3.readInt();
            var10_9 = 8;
            var3_3.seek(var10_9);
            var12_10 = var3_3.readInt();
            var13_11 /* !! */  = new byte[var12_10];
            var3_3.read(var13_11 /* !! */ , 0, var12_10);
            var6_6 = new String(var13_11 /* !! */ );
            var13_11 /* !! */  = (byte[])"%d_%02d_%02d";
            var13_11 /* !! */  = (byte[])this.b((String)var13_11 /* !! */ );
            var14_12 = var6_6.contains((CharSequence)var13_11 /* !! */ );
            var15_13 = 1;
            if (!var14_12) break block30;
            var14_12 = var6_6.contains((CharSequence)var2_2);
            if (!var14_12) break block30;
            var2_2 = var6_6.split((String)var2_2);
            var12_10 = ((String[])var2_2).length;
            if (var12_10 <= var15_13) break block30;
            var2_2 = var2_2[var15_13];
            var2_2 = Integer.valueOf((String)var2_2);
            var16_14 = var2_2.intValue();
            try {
                this.y = var16_14;
            }
            catch (Exception v0) {
                ** continue;
            }
        }
lbl56:
        // 2 sources

        while (true) {
            block32: {
                if (var15_13 <= var9_8) {
                    block31: {
                        var16_14 = var15_13 * 2048;
                        var10_9 = var16_14;
                        var3_3.seek(var10_9);
                        var16_14 = var3_3.readInt();
                        var6_6 = new byte[var16_14];
                        var3_3.read((byte[])var6_6, 0, var16_14);
                        var2_2 = new String((byte[])var6_6);
                        if (var1_1 == null) break block31;
                        var12_10 = (int)var2_2.contains(var1_1);
                        if (var12_10 == 0) break block31;
                        this.c((String)var2_2);
                        break block32;
                    }
                    ++var15_13;
                    continue;
                }
            }
            var3_3.close();
lbl83:
            // 3 sources

            return;
            break;
        }
        catch (Exception v1) {
            ** continue;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void e(Location location) {
        byte by2;
        float f10;
        Object object;
        int n10;
        Object object2;
        Object object3;
        g g10;
        block13: {
            void var9_14;
            block14: {
                int n11;
                int n12;
                int n13;
                block12: {
                    float f11;
                    int n14;
                    Byte by3;
                    long l10;
                    long l11;
                    long l12;
                    Object object4;
                    g10 = this;
                    object3 = location;
                    if (location == null) {
                        return;
                    }
                    double d10 = location.getLongitude();
                    Location location2 = this.b;
                    double d11 = location2.getLongitude();
                    d10 -= d11;
                    d11 = 1000000.0;
                    int by22 = (int)(d10 *= d11);
                    double d12 = location.getLatitude();
                    object2 = this.b;
                    double d13 = object2.getLatitude();
                    d12 = (d12 - d13) * d11;
                    n13 = (int)d12;
                    int n15 = location.hasBearing();
                    int n16 = 1;
                    float f12 = Float.MIN_VALUE;
                    n15 ^= n16;
                    n10 = location.hasSpeed() ^ n16;
                    n12 = by22 > 0 ? 0 : n16;
                    int n17 = Math.abs(by22);
                    n11 = n13 > 0 ? 0 : n16;
                    n13 = Math.abs(n13);
                    int n18 = g10.L;
                    if (n18 > n16) {
                        n16 = 0;
                        f12 = 0.0f;
                        g10.c = null;
                        g10.c = object4 = g10.b;
                    }
                    g10.b = object3;
                    if (object3 != null && (object4 = g10.c) != null && (n16 = (int)((l12 = (l11 = location.getTime()) - (l10 = (object4 = g10.c).getTime())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) > 0) {
                        l11 = g10.b.getTime();
                        object4 = g10.c;
                        l10 = object4.getTime();
                        l11 -= l10;
                        l10 = 5000L;
                        double d14 = 2.4703E-320;
                        n16 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                        if (n16 < 0) {
                            l11 = g10.b.getTime();
                            l10 = g10.c.getTime();
                            object4 = new float[2];
                            d14 = g10.b.getAltitude();
                            Location location3 = g10.b;
                            double d15 = location3.getLongitude();
                            double d16 = g10.c.getLatitude();
                            by3 = g10.c;
                            double d17 = by3.getLongitude();
                            Location.distanceBetween((double)d14, (double)d15, (double)d16, (double)d17, (float[])object4);
                            n14 = 0x40000000;
                            f12 = (float)object4[0];
                            Location location4 = g10.c;
                            float f13 = location4.getSpeed();
                            float f14 = l11 -= l10;
                            f12 = (f12 - (f13 *= f14)) * 2.0f;
                            l11 *= l11;
                            f11 = l11;
                            double d18 = f12 / f11;
                            f12 = g10.F;
                            d14 = f12;
                            n16 = (int)(d18 == d14 ? 0 : (d18 > d14 ? 1 : -1));
                            if (n16 > 0) {
                                g10.F = f12 = (float)d18;
                            }
                        }
                    }
                    object4 = g10.M;
                    by3 = (byte)(n17 & 0xFF);
                    object4.add(by3);
                    object4 = g10.M;
                    n14 = 65280;
                    f11 = 9.1477E-41f;
                    byte by4 = (byte)((n17 & n14) >> 8);
                    object = by4;
                    object4.add(object);
                    object = g10.M;
                    n16 = (byte)(n13 & 0xFF);
                    object4 = (byte)n16;
                    object.add(object4);
                    object = g10.M;
                    n13 = (byte)((n13 & n14) >> 8);
                    object2 = (byte)n13;
                    object.add(object2);
                    if (n15 <= 0) break block12;
                    int n19 = 32;
                    f10 = 4.5E-44f;
                    if (n11 > 0) {
                        f10 = 1.35E-43f;
                        byte by5 = (byte)96;
                    }
                    if (n12 <= 0) break block13;
                    break block14;
                }
                f10 = location.getBearing();
                n13 = 1097859072;
                float f15 = 15.0f;
                byte by6 = (byte)((byte)((int)(f10 /= f15) & 0xFF) & 0x1F);
                if (n11 > 0) {
                    byte by7 = (byte)(by6 | 0x40);
                }
                if (n12 <= 0) break block13;
            }
            by2 = (byte)(var9_14 | 0xFFFFFF80);
        }
        object2 = g10.M;
        object = by2;
        object2.add(object);
        if (n10 > 0) {
            object3 = g10.M;
            byte by8 = -128;
            f10 = 0.0f / 0.0f;
            object = by8;
            object3.add(object);
        } else {
            float f16 = location.getSpeed();
            double d19 = (double)f16 * 3.6;
            double d20 = 4.0;
            byte by9 = (byte)((byte)((int)(d19 /= d20) & 0xFF) & 0x7F);
            object = g10.M;
            object3 = by9;
            object.add(object3);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void e(String var1_1) {
        block36: {
            block37: {
                var2_2 = new StringBuilder();
                var3_3 = com.baidu.location.h.k.a;
                var2_2.append((String)var3_3);
                var3_3 = "/grtcf.dat";
                var2_2.append((String)var3_3);
                var2_2 = var2_2.toString();
                var3_3 = new File((String)var2_2);
                var4_4 = var3_3.exists();
                var5_5 = "rw";
                var6_6 = 2;
                if (var4_4) break block36;
                var8_7 = com.baidu.location.h.k.a;
                var2_2 = new File((String)var8_7);
                var9_8 = var2_2.exists();
                if (var9_8 != 0) ** GOTO lbl24
                var2_2.mkdirs();
lbl24:
                // 2 sources

                if (!(var4_4 = var3_3.createNewFile())) ** GOTO lbl53
                var2_2 = new RandomAccessFile((File)var3_3, var5_5);
                var2_2.seek(var6_6);
                var2_2.writeInt(0);
                var10_9 = 8;
                var2_2.seek(var10_9);
                var8_7 = "1980_01_01:0";
                var8_7 = var8_7.getBytes();
                var12_10 = ((Object)var8_7).length;
                var2_2.writeInt(var12_10);
                var2_2.write((byte[])var8_7);
                var10_9 = 200L;
                var2_2.seek(var10_9);
                var2_2.writeBoolean(false);
                var10_9 = 800L;
                var2_2.seek(var10_9);
                break block37;
lbl53:
                // 1 sources

                return;
            }
            var2_2.writeBoolean(false);
            var2_2.close();
        }
        var2_2 = new RandomAccessFile((File)var3_3, var5_5);
        var2_2.seek(var6_6);
        var13_11 = var2_2.readInt();
        for (var14_12 = 1; var14_12 <= var13_11; ++var14_12) {
            var9_8 = var14_12 * 2048;
            var10_9 = var9_8;
            var2_2.seek(var10_9);
            var9_8 = var2_2.readInt();
            var15_13 /* !! */  = new byte[var9_8];
            var2_2.read(var15_13 /* !! */ , 0, var9_8);
            var8_7 = new String(var15_13 /* !! */ );
            var15_13 /* !! */  = (byte[])com.baidu.location.h.b.e;
            var9_8 = (int)var8_7.contains((CharSequence)var15_13 /* !! */ );
            if (var9_8 != 0) break;
            continue;
        }
        if (var14_12 >= var13_11) {
            var2_2.seek(var6_6);
            var2_2.writeInt(var14_12);
        }
        var16_14 = var14_12 *= 2048;
        try {
            var2_2.seek(var16_14);
            var1_1 = var1_1.getBytes();
        }
        catch (Exception v0) {
            ** continue;
        }
        var13_11 = ((Object)var1_1).length;
        var2_2.writeInt(var13_11);
        var2_2.write((byte[])var1_1);
        var2_2.close();
lbl99:
        // 2 sources

    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean e() {
        void var3_7;
        boolean bl2;
        block35: {
            Object object;
            block34: {
                Object object2;
                block33: {
                    boolean bl3;
                    Object object3;
                    String string2;
                    block32: {
                        object = null;
                        bl2 = false;
                        Object var3_3 = null;
                        object2 = new StringBuilder();
                        string2 = com.baidu.location.h.l.i();
                        ((StringBuilder)object2).append(string2);
                        string2 = File.separator;
                        ((StringBuilder)object2).append(string2);
                        string2 = "gflk.dat";
                        ((StringBuilder)object2).append(string2);
                        object2 = ((StringBuilder)object2).toString();
                        object3 = new File((String)object2);
                        bl3 = ((File)object3).exists();
                        if (bl3) break block32;
                        ((File)object3).createNewFile();
                    }
                    string2 = "rw";
                    object2 = new RandomAccessFile((File)object3, string2);
                    object3 = ((RandomAccessFile)object2).getChannel();
                    try {
                        object = ((FileChannel)object3).tryLock();
                    }
                    catch (Throwable throwable) {
                        object = object3;
                        break block33;
                    }
                    catch (Exception exception) {
                        bl2 = true;
                    }
                    if (object != null) {
                        ((FileLock)object).release();
                    }
                    if (object3 != null) {
                        ((AbstractInterruptibleChannel)object3).close();
                    }
                    if (object2 == null) break block35;
                    try {
                        ((RandomAccessFile)object2).close();
                        return bl2;
                    }
                    catch (Exception exception) {
                        return bl2;
                    }
                    catch (Throwable throwable) {
                        break block33;
                    }
                    catch (Exception exception) {
                        object = object2;
                        break block34;
                    }
                    catch (Throwable throwable) {
                        bl3 = false;
                        object2 = null;
                    }
                }
                if (object != null) {
                    ((AbstractInterruptibleChannel)object).close();
                }
                if (object2 != null) {
                    ((RandomAccessFile)object2).close();
                }
                throw var3_7;
                catch (Exception exception) {}
            }
            if (object != null) {
                ((RandomAccessFile)object).close();
            }
        }
        return bl2;
        catch (Exception exception) {
            throw var3_7;
        }
    }

    private boolean f() {
        int n10;
        block5: {
            int n11;
            block4: {
                block6: {
                    double d10;
                    Object object;
                    block1: {
                        block2: {
                            block3: {
                                object = this.B;
                                n10 = 0;
                                n11 = 1;
                                if (object == 0) break block1;
                                object = this.C;
                                if (object == 0) break block2;
                                float f10 = this.E;
                                double d11 = f10;
                                double d12 = this.t;
                                double d13 = d11 - d12;
                                object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
                                if (object >= 0) break block3;
                                object = this.D;
                                int n12 = this.p;
                                this.D = object += n12;
                                n12 = this.u;
                                if (object <= n12) break block4;
                                long l10 = System.currentTimeMillis();
                                long l11 = this.G;
                                long l12 = (l10 -= l11) - (l11 = (long)(this.v * 1000));
                                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                                if (object <= 0) break block5;
                                break block4;
                            }
                            this.D = 0;
                            this.C = false;
                            break block4;
                        }
                        float f11 = this.E;
                        double d14 = f11;
                        double d15 = this.t;
                        double d16 = d14 - d15;
                        object = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
                        if (object < 0) {
                            this.C = n11;
                            this.D = 0;
                            object = this.p;
                            this.D = n10 = 0 + object;
                        }
                        break block4;
                    }
                    float f12 = this.E;
                    double d17 = f12;
                    double d18 = this.r;
                    double d19 = d17 - d18;
                    object = d19 == 0.0 ? 0 : (d19 > 0.0 ? 1 : -1);
                    if (object >= 0 || (object = (Object)((d10 = (d17 = (double)(f12 = this.F)) - (d18 = this.s)) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1))) >= 0) break block6;
                    object = this.w;
                    if (object != n11) break block5;
                    long l13 = System.currentTimeMillis();
                    long l14 = this.G;
                    long l15 = (l13 -= l14) - (l14 = (long)(this.x * 1000));
                    object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                    if (object <= 0) break block5;
                    break block4;
                }
                this.B = n11;
            }
            n10 = n11;
        }
        return n10 != 0;
    }

    private void g() {
        this.M = null;
        this.e = 0L;
        this.L = 0;
        this.b = null;
        this.c = null;
        this.E = 0.0f;
        this.F = 0.0f;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        boolean bl2;
        long l10 = this.e;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) return;
        l10 = System.currentTimeMillis();
        l11 = this.e;
        int n10 = this.p * 1000;
        long l13 = (l10 -= l11) - (l11 = (long)n10);
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 < 0) {
            return;
        }
        Object object3 = com.baidu.location.f.getServiceContext();
        int n11 = 4;
        object3 = object3.getSharedPreferences("loc_navi_mode", n11);
        Object object4 = "is_navi_on";
        n10 = 0;
        Object object5 = null;
        boolean bl3 = object3.getBoolean((String)object4, false);
        if (bl3) {
            this.g();
            return;
        }
        int n12 = this.n;
        n11 = 1;
        if (n12 == n11 && !(bl2 = this.f())) {
            this.g();
            return;
        }
        object3 = com.baidu.location.h.b.e;
        Object object6 = "com.ubercab.driver";
        boolean bl4 = ((String)object3).equals(object6);
        if (!bl4) {
            object3 = com.baidu.location.h.b.e;
            object6 = com.baidu.location.f.getServiceContext();
            boolean bl5 = this.a((String)object3, (Context)object6);
            if (!bl5) {
                this.g();
                return;
            }
        } else {
            boolean bl6 = this.e();
            if (bl6) {
                this.g();
                return;
            }
        }
        if ((object3 = this.M) == null) return;
        int n13 = object3.size();
        object6 = this.M;
        Byte by2 = (byte)(n13 & 0xFF);
        object6.set(0, by2);
        object6 = this.M;
        by2 = (byte)((0xFF00 & n13) >> 8);
        object6.set(n11, by2);
        object4 = this.M;
        int n14 = 3;
        byte by3 = (byte)(this.L & 0xFF);
        by2 = by3;
        object4.set(n14, by2);
        object4 = new byte[n13];
        while (n10 < n13) {
            object6 = (Byte)this.M.get(n10);
            n14 = ((Byte)object6).byteValue();
            object4[n10] = n14;
            ++n10;
        }
        object5 = com.baidu.location.h.l.k();
        object3 = new File((String)object5, (String)(object6 = "baidu/tempdata"));
        n10 = (int)(((File)object3).exists() ? 1 : 0);
        if (n10 == 0) {
            ((File)object3).mkdirs();
        }
        if ((n10 = (int)(((File)object3).exists() ? 1 : 0)) != 0) {
            object6 = "intime.dat";
            object5 = new File((File)object3, (String)object6);
            boolean bl7 = ((File)object5).exists();
            if (bl7) {
                ((File)object5).delete();
            }
            try {
                object6 = new FileOutputStream((File)object5);
                object3 = new BufferedOutputStream((OutputStream)object6);
                ((FilterOutputStream)object3).write((byte[])object4);
                ((BufferedOutputStream)object3).flush();
                ((FilterOutputStream)object3).close();
                object3 = new i(this);
                ((Thread)object3).start();
            }
            catch (Exception exception) {}
        }
        this.g();
        this.G = l10 = System.currentTimeMillis();
    }

    private void i() {
        byte by2;
        Object object = this.M;
        int n10 = 0;
        Object object2 = (byte)0;
        object.add(object2);
        this.M.add(object2);
        object = f;
        Object object3 = "0";
        boolean n11 = ((String)object).equals(object3);
        if (n11) {
            object = this.M;
            by2 = -82;
        } else {
            object = this.M;
            by2 = -66;
        }
        object3 = by2;
        object.add(object3);
        this.M.add(object2);
        object = this.M;
        object2 = this.J[0];
        object.add(object2);
        object = this.M;
        object2 = this.J[1];
        object.add(object2);
        object = this.M;
        object2 = this.J[2];
        object.add(object2);
        object = this.M;
        byte by3 = this.J[3];
        object2 = by3;
        object.add(object2);
        object = this.K;
        int n12 = ((Object)object).length;
        object2 = this.M;
        by2 = (byte)(n12 + 1 & 0xFF);
        object3 = by2;
        object2.add(object3);
        while (n10 < n12) {
            object2 = this.M;
            by2 = this.K[n10];
            object3 = by2;
            object2.add(object3);
            ++n10;
        }
    }

    private void j() {
        long l10 = System.currentTimeMillis();
        long l11 = this.z;
        long l12 = (l10 -= l11) - (l11 = 86400000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            Object object2 = this.A;
            if (object2 == null) {
                this.A = object2 = new g$a(this);
            }
            object2 = new StringBuffer();
            Object object3 = com.baidu.location.h.b.a().a(false);
            ((StringBuffer)object2).append((String)object3);
            object3 = com.baidu.location.b.b.a().d();
            ((StringBuffer)object2).append((String)object3);
            object3 = this.A;
            object2 = ((StringBuffer)object2).toString();
            ((g$a)object3).a((String)object2);
        }
        this.k();
    }

    private void k() {
    }

    public void a(Location location) {
        String string2;
        int n10 = this.N;
        if (n10 == 0) {
            this.c();
        }
        Object object = com.baidu.location.c.d.a();
        double d10 = ((d)object).f();
        double d11 = this.l;
        double d12 = 100.0;
        double d13 = d10 - (d11 *= d12);
        n10 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        int n11 = 1;
        if (n10 < 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        int n12 = this.k;
        if (n12 == n11 && n10 != 0 && (n10 = (int)(((String)(object = this.m)).contains(string2 = com.baidu.location.f.e.a(n12 = com.baidu.location.f.b.a().e())) ? 1 : 0)) != 0) {
            n10 = this.n;
            if (n10 == n11 && (n10 = this.y) > (n11 = this.o)) {
                return;
            }
            object = this.I;
            h h10 = new h(this, location);
            object.post((Runnable)h10);
        }
    }

    public void b() {
        boolean bl2 = this.N;
        if (!bl2) {
            return;
        }
        this.N = false;
        this.g();
    }
}

