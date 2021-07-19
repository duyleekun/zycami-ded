/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.weibo.ssosdk;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.weibo.ssosdk.WeiboSsoSdk$a;
import com.weibo.ssosdk.WeiboSsoSdk$c;
import com.weibo.ssosdk.WeiboSsoSdk$d;
import com.weibo.ssosdk.WeiboSsoSdk$e;
import com.weibo.ssosdk.WeiboSsoSdk$f;
import com.weibo.ssosdk.WeiboSsoSdk$g;
import com.weibo.ssosdk.WeiboSsoSdk$h;
import d.s.a.a;
import d.s.a.c;
import d.s.a.d;
import d.s.a.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class WeiboSsoSdk {
    private static final String e = "https://login.sina.com.cn/visitor/signin";
    private static final int f = 1;
    private static final int g = 2;
    public static final String h = "1.0";
    private static final String i = "WeiboSsoSdk";
    private static final int j = 1;
    private static final String k = "weibo_sso_sdk_aid";
    private static final String l = "weibo_sso_sdk_init";
    private static WeiboSsoSdk m;
    private static e n;
    private volatile ReentrantLock a;
    private boolean b;
    private WeiboSsoSdk$h c;
    private int d;

    static {
        System.loadLibrary("wind");
    }

    private WeiboSsoSdk() {
        boolean bl2;
        boolean bl3 = true;
        Object object = new ReentrantLock(bl3);
        this.a = object;
        this.b = bl3;
        object = n;
        if (object != null && (bl2 = ((e)object).u())) {
            this.d = 0;
            Runnable runnable = new WeiboSsoSdk$a(this);
            object = new Thread(runnable);
            ((Thread)object).start();
            super(this);
            object = new Thread(runnable);
            ((Thread)object).start();
            return;
        }
        object = new Exception("config error");
        throw object;
    }

    private static void a(String string2) {
    }

    private static void b(String string2) {
    }

    public static /* synthetic */ WeiboSsoSdk$h c(WeiboSsoSdk weiboSsoSdk) {
        return weiboSsoSdk.c;
    }

    public static /* synthetic */ WeiboSsoSdk$h d(WeiboSsoSdk weiboSsoSdk, WeiboSsoSdk$h weiboSsoSdk$h) {
        weiboSsoSdk.c = weiboSsoSdk$h;
        return weiboSsoSdk$h;
    }

    public static /* synthetic */ String e(WeiboSsoSdk weiboSsoSdk) {
        return weiboSsoSdk.p();
    }

    public static /* synthetic */ void f(WeiboSsoSdk weiboSsoSdk, String string2, int n10) {
        weiboSsoSdk.s(string2, n10);
    }

    public static /* synthetic */ boolean g(WeiboSsoSdk weiboSsoSdk) {
        return weiboSsoSdk.b;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h(String object) {
        synchronized (this) {
            FileOutputStream fileOutputStream;
            block17: {
                void var1_4;
                block16: {
                    FileOutputStream fileOutputStream2;
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (bl2) {
                        return;
                    }
                    bl2 = false;
                    fileOutputStream = null;
                    int n10 = 1;
                    try {
                        File file = this.l(n10);
                        fileOutputStream2 = new FileOutputStream(file);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                        break block16;
                    }
                    catch (Exception exception) {
                        break block17;
                    }
                    try {
                        object = ((String)object).getBytes();
                        fileOutputStream2.write((byte[])object);
                    }
                    catch (Throwable throwable) {
                        fileOutputStream = fileOutputStream2;
                        break block16;
                    }
                    catch (Exception exception) {
                        fileOutputStream = fileOutputStream2;
                        break block17;
                    }
                    try {
                        fileOutputStream2.close();
                        return;
                    }
                    catch (IOException iOException) {
                        return;
                    }
                }
                if (fileOutputStream == null) throw var1_4;
                try {
                    fileOutputStream.close();
                    throw var1_4;
                }
                catch (IOException iOException) {
                    throw var1_4;
                }
            }
            if (fileOutputStream == null) return;
            try {
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String i(String object) {
        Object object2 = null;
        try {
            String string2 = e;
            Object object3 = new URL(string2);
            object3 = ((URL)object3).openConnection();
            object3 = FirebasePerfUrlConnection.instrument(object3);
            object3 = (URLConnection)object3;
            object3 = (HttpURLConnection)object3;
            string2 = "POST";
            ((HttpURLConnection)object3).setRequestMethod(string2);
            boolean bl2 = 3000 != 0;
            ((URLConnection)object3).setReadTimeout((int)(bl2 ? 1 : 0));
            bl2 = 1000 != 0;
            ((URLConnection)object3).setConnectTimeout((int)(bl2 ? 1 : 0));
            bl2 = true;
            ((URLConnection)object3).setDoOutput(bl2);
            ((URLConnection)object3).setDoInput(bl2);
            bl2 = false;
            string2 = null;
            ((URLConnection)object3).setUseCaches(false);
            Object object4 = ((URLConnection)object3).getOutputStream();
            object = ((String)object).getBytes();
            ((OutputStream)object4).write((byte[])object);
            ((OutputStream)object4).flush();
            int n10 = ((HttpURLConnection)object3).getResponseCode();
            int n11 = 200;
            if (n10 != n11) return object2;
            object = ((URLConnection)object3).getInputStream();
            object3 = new ByteArrayOutputStream();
            n11 = 1024;
            object4 = new byte[n11];
            while (true) {
                int n12;
                int n13;
                if ((n13 = ((InputStream)object).read((byte[])object4)) == (n12 = -1)) {
                    ((InputStream)object).close();
                    ((ByteArrayOutputStream)object3).close();
                    object3 = ((ByteArrayOutputStream)object3).toByteArray();
                    object = new String((byte[])object3);
                    return object;
                }
                ((ByteArrayOutputStream)object3).write((byte[])object4, 0, n13);
            }
        }
        catch (Exception exception) {
            return object2;
        }
    }

    private File l(int n10) {
        File file = n.c().getFilesDir();
        StringBuilder stringBuilder = new StringBuilder(k);
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        File file2 = new File(file, string2);
        return file2;
    }

    private File m() {
        File file = n.c().getFilesDir();
        File file2 = new File(file, l);
        return file2;
    }

    public static WeiboSsoSdk n() {
        Class<WeiboSsoSdk> clazz = WeiboSsoSdk.class;
        synchronized (clazz) {
            WeiboSsoSdk weiboSsoSdk = m;
            if (weiboSsoSdk == null) {
                m = weiboSsoSdk = new WeiboSsoSdk();
            }
            weiboSsoSdk = m;
            return weiboSsoSdk;
        }
    }

    public static boolean o(e object) {
        Class<WeiboSsoSdk> clazz = WeiboSsoSdk.class;
        synchronized (clazz) {
            block10: {
                block9: {
                    if (object == null) {
                        return false;
                    }
                    boolean bl2 = ((e)object).u();
                    if (bl2) break block9;
                    return false;
                }
                e e10 = n;
                if (e10 != null) break block10;
                object = ((e)object).clone();
                object = (e)object;
                n = object;
                object = ((e)object).c();
                d.s.a.c.A((Context)object);
                return true;
            }
            return false;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private String p() {
        void var3_6;
        Object object;
        block23: {
            block22: {
                int n10 = 1;
                object = null;
                Object object2 = this.l(n10);
                FileInputStream fileInputStream = new FileInputStream((File)object2);
                n10 = fileInputStream.available();
                object2 = new byte[n10];
                fileInputStream.read((byte[])object2);
                object = new String((byte[])object2);
                try {
                    fileInputStream.close();
                    return object;
                }
                catch (IOException iOException) {
                    return object;
                }
                catch (Throwable throwable) {
                    object = fileInputStream;
                    break block22;
                }
                catch (Exception exception) {
                    object = fileInputStream;
                    break block23;
                }
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            if (object != null) {
                ((FileInputStream)object).close();
            }
            throw var3_6;
            catch (Exception exception) {}
        }
        if (object != null) {
            ((FileInputStream)object).close();
        }
        return "";
        catch (IOException iOException) {
            throw var3_6;
        }
        catch (IOException iOException) {
            return "";
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private String q() {
        FileInputStream fileInputStream;
        Throwable throwable;
        block12: {
            throwable = null;
            Object object = this.m();
            fileInputStream = new FileInputStream((File)object);
            int n10 = fileInputStream.available();
            object = new byte[n10];
            fileInputStream.read((byte[])object);
            String string2 = new String((byte[])object);
            fileInputStream.close();
            return string2;
            {
                catch (IOException iOException) {
                    return string2;
                }
            }
            catch (Throwable throwable2) {
                break block12;
            }
            catch (Throwable throwable3) {
                fileInputStream = null;
                throwable = throwable3;
            }
        }
        if (fileInputStream == null) throw throwable;
        fileInputStream.close();
        {
            catch (IOException iOException) {
                throw throwable;
            }
        }
        throw throwable;
        catch (Exception exception) {
            block13: {
                fileInputStream = null;
                break block13;
                catch (Exception exception2) {}
            }
            if (fileInputStream == null) return null;
            try {
                fileInputStream.close();
                return null;
            }
            catch (IOException iOException) {
                return null;
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void r(String object) {
        synchronized (this) {
            FileOutputStream fileOutputStream;
            block17: {
                void var1_4;
                block16: {
                    FileOutputStream fileOutputStream2;
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (bl2) {
                        return;
                    }
                    bl2 = false;
                    fileOutputStream = null;
                    try {
                        File file = this.m();
                        fileOutputStream2 = new FileOutputStream(file);
                    }
                    catch (Throwable throwable) {
                        // empty catch block
                        break block16;
                    }
                    catch (Exception exception) {
                        break block17;
                    }
                    try {
                        object = ((String)object).getBytes();
                        fileOutputStream2.write((byte[])object);
                    }
                    catch (Throwable throwable) {
                        fileOutputStream = fileOutputStream2;
                        break block16;
                    }
                    catch (Exception exception) {
                        fileOutputStream = fileOutputStream2;
                        break block17;
                    }
                    try {
                        fileOutputStream2.close();
                        return;
                    }
                    catch (IOException iOException) {
                        return;
                    }
                }
                if (fileOutputStream == null) throw var1_4;
                try {
                    fileOutputStream.close();
                    throw var1_4;
                }
                catch (IOException iOException) {
                    throw var1_4;
                }
            }
            if (fileOutputStream == null) return;
            try {
                fileOutputStream.close();
                return;
            }
            catch (IOException iOException) {
                return;
            }
        }
    }

    private native String riseWind(String var1, String var2, String var3, String var4, String var5, String var6, String var7, String var8, String var9, String var10, int var11, int var12);

    private void s(String string2, int n10) {
        WeiboSsoSdk weiboSsoSdk = this;
        Object object = n;
        int n11 = 0;
        Object object2 = null;
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object = ((e)object).b(false)));
        if (bl2) {
            return;
        }
        object = this.a;
        bl2 = ((ReentrantLock)object).tryLock();
        if (!bl2) {
            this.a.lock();
            this.a.unlock();
            return;
        }
        this.b = false;
        String string3 = d.s.a.c.q(n.c());
        object = "utf-8";
        object2 = string2;
        try {
            object = URLEncoder.encode(string2, (String)object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            object = "";
        }
        Object object3 = object;
        String string4 = n.c().getPackageName();
        object = n;
        int n12 = 1;
        String string5 = ((e)object).b(n12 != 0);
        String string6 = n.e(n12 != 0);
        String string7 = n.f(n12 != 0);
        String string8 = n.k(n12 != 0);
        String string9 = n.j(n12 != 0);
        String string10 = n.i(n12 != 0);
        String string11 = n.d(n12 != 0);
        int n13 = weiboSsoSdk.d;
        object2 = this;
        object = this.riseWind(string5, string4, (String)object3, string3, string6, string7, string8, string9, string10, string11, n10, n13);
        object = weiboSsoSdk.i((String)object);
        weiboSsoSdk.d = n11 = weiboSsoSdk.d + n12;
        if (object != null) {
            try {
                object = WeiboSsoSdk$h.d((String)object);
            }
            catch (Exception exception) {
                weiboSsoSdk.a.unlock();
                throw exception;
            }
            if (object != null && (n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = ((WeiboSsoSdk$h)object).b())) ? 1 : 0)) == 0) {
                object2 = ((WeiboSsoSdk$h)object).b();
                weiboSsoSdk.h((String)object2);
            }
            n11 = n10;
            if (n10 == n12) {
                weiboSsoSdk.c = object;
            }
            weiboSsoSdk.a.unlock();
            return;
        }
        weiboSsoSdk.a.unlock();
        object = new Exception("network error.");
        throw object;
    }

    public String j() {
        Object object;
        block5: {
            block4: {
                boolean bl2;
                object = this.p();
                boolean bl3 = TextUtils.isEmpty((CharSequence)object);
                if (!bl3) {
                    return object;
                }
                object = this.c;
                if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b())))) break block4;
                WeiboSsoSdk$f weiboSsoSdk$f = new WeiboSsoSdk$f(this);
                object = new Thread(weiboSsoSdk$f);
                ((Thread)object).start();
                ((Thread)object).join();
                object = this.c;
                if (object == null || (bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b())))) break block5;
            }
            return this.c.b();
        }
        object = new Exception("visitor login failed");
        throw object;
    }

    public void k(a a10) {
        boolean bl2;
        Object object = this.p();
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (!bl3) {
            a10.a((String)object);
        }
        if ((object = this.c) != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b())))) {
            object = this.c.b();
            a10.a((String)object);
            return;
        }
        object = Executors.newSingleThreadExecutor();
        WeiboSsoSdk$g weiboSsoSdk$g = new WeiboSsoSdk$g(this, a10);
        object.execute(weiboSsoSdk$g);
    }

    public void t(String object) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)object);
        if (bl3) {
            return;
        }
        n.r((String)object);
        Object object2 = this.c.c();
        boolean bl4 = TextUtils.isEmpty((CharSequence)object2);
        if (bl4 || !(bl2 = ((String)object2).equals(object))) {
            object2 = new WeiboSsoSdk$c(this);
            object = new Thread((Runnable)object2);
            ((Thread)object).start();
        }
    }

    public WeiboSsoSdk$h u() {
        Object object;
        block3: {
            block2: {
                boolean bl2;
                object = this.c;
                if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b()))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.c.c())))) break block2;
                WeiboSsoSdk$d weiboSsoSdk$d = new WeiboSsoSdk$d(this);
                object = new Thread(weiboSsoSdk$d);
                ((Thread)object).start();
                ((Thread)object).join();
                object = this.c;
                if (object == null || (bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b()))) || (bl2 = TextUtils.isEmpty((CharSequence)(object = this.c.c())))) break block3;
            }
            return this.c;
        }
        object = new Exception("visitor login failed");
        throw object;
    }

    public void v(d d10) {
        boolean bl2;
        Object object = this.c;
        if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)(object = ((WeiboSsoSdk$h)object).b()))) && !(bl2 = TextUtils.isEmpty((CharSequence)(object = this.c.c())))) {
            object = this.c;
            d10.handler((WeiboSsoSdk$h)object);
            return;
        }
        object = Executors.newSingleThreadExecutor();
        WeiboSsoSdk$e weiboSsoSdk$e = new WeiboSsoSdk$e(this, d10);
        object.execute(weiboSsoSdk$e);
    }
}

