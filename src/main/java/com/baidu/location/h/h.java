/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.baidu.location.h;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.h.a;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.zip.GZIPInputStream;

public class h
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ f c;

    public h(f f10, String string2, boolean bl2) {
        this.c = f10;
        this.a = string2;
        this.b = bl2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        int n10;
        int n11;
        String string2;
        Object object;
        h h10;
        block68: {
            void var2_6;
            Object object2;
            Object object3;
            Object object4;
            Object object5;
            Object object6;
            String string3;
            String string4;
            block74: {
                Object object7;
                h10 = this;
                object = "gzip";
                string2 = "close baos IOException!";
                string4 = "close is IOException!";
                string3 = "close os IOException!";
                object6 = this.c;
                object5 = l.e();
                ((f)object6).h = object5;
                this.c.b();
                object6 = this.c;
                n11 = ((f)object6).i;
                object5 = null;
                int n12 = 0;
                object4 = null;
                while (true) {
                    int n13;
                    block81: {
                        block83: {
                            block80: {
                                Object object8;
                                Object object9;
                                block78: {
                                    block76: {
                                        block73: {
                                            block79: {
                                                block77: {
                                                    block75: {
                                                        block72: {
                                                            int n14;
                                                            int n15;
                                                            block82: {
                                                                block71: {
                                                                    block70: {
                                                                        block69: {
                                                                            Object object10;
                                                                            int n16;
                                                                            n13 = 0;
                                                                            object7 = null;
                                                                            n10 = 1;
                                                                            if (n11 <= 0) break block68;
                                                                            object3 = h10.c;
                                                                            object3 = ((f)object3).h;
                                                                            object9 = new URL((String)object3);
                                                                            object3 = new StringBuffer();
                                                                            object2 = h10.c;
                                                                            object2 = ((f)object2).k;
                                                                            object2 = object2.entrySet();
                                                                            object2 = object2.iterator();
                                                                            while ((n16 = object2.hasNext()) != 0) {
                                                                                object8 = object2.next();
                                                                                object8 = (Map.Entry)object8;
                                                                                object10 = object8.getKey();
                                                                                object10 = (String)object10;
                                                                                ((StringBuffer)object3).append((String)object10);
                                                                                object10 = "=";
                                                                                ((StringBuffer)object3).append((String)object10);
                                                                                object8 = object8.getValue();
                                                                                ((StringBuffer)object3).append(object8);
                                                                                object8 = "&";
                                                                                ((StringBuffer)object3).append((String)object8);
                                                                            }
                                                                            n15 = ((StringBuffer)object3).length();
                                                                            if (n15 > 0) {
                                                                                n15 = ((StringBuffer)object3).length() - n10;
                                                                                ((StringBuffer)object3).deleteCharAt(n15);
                                                                            }
                                                                            object9 = ((URL)object9).openConnection();
                                                                            object9 = FirebasePerfUrlConnection.instrument(object9);
                                                                            object9 = (URLConnection)object9;
                                                                            object9 = (HttpURLConnection)object9;
                                                                            object4 = "POST";
                                                                            ((HttpURLConnection)object9).setRequestMethod((String)object4);
                                                                            ((URLConnection)object9).setDoInput(n10 != 0);
                                                                            ((URLConnection)object9).setDoOutput(n10 != 0);
                                                                            ((URLConnection)object9).setUseCaches(false);
                                                                            n12 = com.baidu.location.h.a.b;
                                                                            ((URLConnection)object9).setConnectTimeout(n12);
                                                                            n12 = com.baidu.location.h.a.b;
                                                                            ((URLConnection)object9).setReadTimeout(n12);
                                                                            object4 = "Content-Type";
                                                                            object2 = "application/x-www-form-urlencoded; charset=utf-8";
                                                                            ((URLConnection)object9).setRequestProperty((String)object4, (String)object2);
                                                                            object4 = "Accept-Charset";
                                                                            object2 = "UTF-8";
                                                                            ((URLConnection)object9).setRequestProperty((String)object4, (String)object2);
                                                                            object4 = "Accept-Encoding";
                                                                            ((URLConnection)object9).setRequestProperty((String)object4, (String)object);
                                                                            object4 = l.az;
                                                                            if (object4 != null) {
                                                                                object2 = "bd-loc-android";
                                                                                ((URLConnection)object9).setRequestProperty((String)object2, (String)object4);
                                                                            }
                                                                            if ((n12 = (int)(TextUtils.isEmpty((CharSequence)(object4 = h10.a)) ? 1 : 0)) == 0) {
                                                                                object4 = "Host";
                                                                                object2 = h10.a;
                                                                                ((URLConnection)object9).setRequestProperty((String)object4, (String)object2);
                                                                            }
                                                                            object4 = ((URLConnection)object9).getOutputStream();
                                                                            object3 = ((StringBuffer)object3).toString();
                                                                            object3 = ((String)object3).getBytes();
                                                                            ((OutputStream)object4).write((byte[])object3);
                                                                            ((OutputStream)object4).flush();
                                                                            n14 = ((HttpURLConnection)object9).getResponseCode();
                                                                            n15 = 200;
                                                                            if (n14 != n15) break block69;
                                                                            object3 = ((URLConnection)object9).getInputStream();
                                                                            object2 = ((URLConnection)object9).getContentEncoding();
                                                                            if (object2 != null && (n15 = (int)(((String)object2).contains((CharSequence)object) ? 1 : 0)) != 0) {
                                                                                object8 = new BufferedInputStream((InputStream)object3);
                                                                                object3 = object2 = new GZIPInputStream((InputStream)object8);
                                                                            }
                                                                            object2 = new ByteArrayOutputStream();
                                                                            n16 = 1024;
                                                                            try {
                                                                                int n17;
                                                                                int n18;
                                                                                object8 = new byte[n16];
                                                                                while ((n18 = ((InputStream)object3).read((byte[])object8)) != (n17 = -1)) {
                                                                                    ((ByteArrayOutputStream)object2).write((byte[])object8, 0, n18);
                                                                                }
                                                                                object8 = h10.c;
                                                                                byte[] byArray = ((ByteArrayOutputStream)object2).toByteArray();
                                                                                object7 = "utf-8";
                                                                                object10 = new Object(byArray, (String)object7);
                                                                                ((f)object8).j = object10;
                                                                                n13 = h10.b;
                                                                                if (n13 != 0) {
                                                                                    object7 = h10.c;
                                                                                    object8 = ((ByteArrayOutputStream)object2).toByteArray();
                                                                                    ((f)object7).m = (byte[])object8;
                                                                                }
                                                                                object7 = h10.c;
                                                                                ((f)object7).a(n10 != 0);
                                                                                n13 = n10;
                                                                                break block70;
                                                                            }
                                                                            catch (Throwable throwable) {
                                                                                break block71;
                                                                            }
                                                                            catch (Throwable throwable) {
                                                                                n15 = 0;
                                                                                object2 = null;
                                                                                break block71;
                                                                            }
                                                                            catch (Error error) {
                                                                                n15 = 0;
                                                                                object2 = null;
                                                                                break block72;
                                                                            }
                                                                            catch (Exception exception) {
                                                                                n15 = 0;
                                                                                object2 = null;
                                                                                break block73;
                                                                            }
                                                                        }
                                                                        n14 = 0;
                                                                        object3 = null;
                                                                        n15 = 0;
                                                                        object2 = null;
                                                                        n13 = 0;
                                                                        object7 = null;
                                                                    }
                                                                    if (object9 != null) {
                                                                        ((HttpURLConnection)object9).disconnect();
                                                                    }
                                                                    if (object4 != null) {
                                                                        try {
                                                                            ((OutputStream)object4).close();
                                                                        }
                                                                        catch (Exception exception) {
                                                                            object4 = com.baidu.location.h.a.a;
                                                                            Log.d((String)object4, (String)string3);
                                                                        }
                                                                    }
                                                                    if (object3 != null) {
                                                                        try {
                                                                            ((InputStream)object3).close();
                                                                        }
                                                                        catch (Exception exception) {
                                                                            object4 = com.baidu.location.h.a.a;
                                                                            Log.d((String)object4, (String)string4);
                                                                        }
                                                                    }
                                                                    if (object2 != null) {
                                                                        try {
                                                                            ((ByteArrayOutputStream)object2).close();
                                                                        }
                                                                        catch (Exception exception) {
                                                                            object4 = com.baidu.location.h.a.a;
                                                                            Log.d((String)object4, (String)string2);
                                                                        }
                                                                    }
                                                                    object4 = object9;
                                                                    break block81;
                                                                    catch (Throwable throwable) {
                                                                        n14 = 0;
                                                                        object3 = null;
                                                                        n15 = 0;
                                                                        object2 = null;
                                                                    }
                                                                }
                                                                object5 = object4;
                                                                break block82;
                                                                catch (Error error) {
                                                                    n14 = 0;
                                                                    object3 = null;
                                                                    n15 = 0;
                                                                    object2 = null;
                                                                    break block72;
                                                                }
                                                                catch (Exception exception) {
                                                                    n14 = 0;
                                                                    object3 = null;
                                                                    n15 = 0;
                                                                    object2 = null;
                                                                    break block73;
                                                                }
                                                                catch (Throwable throwable) {
                                                                    n14 = 0;
                                                                    object3 = null;
                                                                    n15 = 0;
                                                                    object2 = null;
                                                                }
                                                            }
                                                            object4 = object9;
                                                            break block74;
                                                            catch (Error error) {
                                                                n13 = 0;
                                                                object7 = null;
                                                                n14 = 0;
                                                                object3 = null;
                                                                n15 = 0;
                                                                object2 = null;
                                                                break block75;
                                                            }
                                                            catch (Exception exception) {
                                                                n13 = 0;
                                                                object7 = null;
                                                                n14 = 0;
                                                                object3 = null;
                                                                n15 = 0;
                                                                object2 = null;
                                                                break block76;
                                                            }
                                                            catch (Throwable throwable) {
                                                                n14 = 0;
                                                                object3 = null;
                                                                n15 = 0;
                                                                object2 = null;
                                                                break block74;
                                                            }
                                                            catch (Error error) {
                                                                n13 = 0;
                                                                object7 = null;
                                                                n14 = 0;
                                                                object3 = null;
                                                                n15 = 0;
                                                                object2 = null;
                                                                break block77;
                                                            }
                                                            catch (Exception exception) {
                                                                n13 = 0;
                                                                object7 = null;
                                                                n14 = 0;
                                                                object3 = null;
                                                                n15 = 0;
                                                                object2 = null;
                                                                break block78;
                                                            }
                                                            catch (Error error) {}
                                                        }
                                                        object7 = object4;
                                                    }
                                                    object4 = object9;
                                                }
                                                object9 = com.baidu.location.h.a.a;
                                                object8 = "NetworkCommunicationError!";
                                                Log.d((String)object9, (String)object8);
                                                if (object4 != null) {
                                                    ((HttpURLConnection)object4).disconnect();
                                                }
                                                if (object7 == null) break block79;
                                                try {
                                                    ((OutputStream)object7).close();
                                                }
                                                catch (Exception exception) {
                                                    object7 = com.baidu.location.h.a.a;
                                                    Log.d((String)object7, (String)string3);
                                                }
                                            }
                                            if (object3 != null) {
                                                try {
                                                    ((InputStream)object3).close();
                                                }
                                                catch (Exception exception) {
                                                    object7 = com.baidu.location.h.a.a;
                                                    Log.d((String)object7, (String)string4);
                                                }
                                            }
                                            if (object2 == null) break block83;
                                            ((ByteArrayOutputStream)object2).close();
                                            catch (Exception exception) {}
                                        }
                                        object7 = object4;
                                    }
                                    object4 = object9;
                                }
                                object9 = com.baidu.location.h.a.a;
                                object8 = "NetworkCommunicationException!";
                                Log.d((String)object9, (String)object8);
                                if (object4 != null) {
                                    ((HttpURLConnection)object4).disconnect();
                                }
                                if (object7 == null) break block80;
                                try {
                                    ((OutputStream)object7).close();
                                }
                                catch (Exception exception) {
                                    object7 = com.baidu.location.h.a.a;
                                    Log.d((String)object7, (String)string3);
                                }
                            }
                            if (object3 != null) {
                                try {
                                    ((InputStream)object3).close();
                                }
                                catch (Exception exception) {
                                    object7 = com.baidu.location.h.a.a;
                                    Log.d((String)object7, (String)string4);
                                }
                            }
                            if (object2 == null) break block83;
                            try {
                                ((ByteArrayOutputStream)object2).close();
                            }
                            catch (Exception exception) {
                                object7 = com.baidu.location.h.a.a;
                                Log.d((String)object7, (String)string2);
                            }
                        }
                        n13 = 0;
                        object7 = null;
                    }
                    if (n13 == 0) {
                        n11 += -1;
                        continue;
                    }
                    break block68;
                    break;
                }
                catch (Throwable throwable) {
                    object5 = object7;
                }
            }
            if (object4 != null) {
                ((HttpURLConnection)object4).disconnect();
            }
            if (object5 != null) {
                try {
                    ((OutputStream)object5).close();
                }
                catch (Exception exception) {
                    object6 = com.baidu.location.h.a.a;
                    Log.d((String)object6, (String)string3);
                }
            }
            if (object3 != null) {
                try {
                    ((InputStream)object3).close();
                }
                catch (Exception exception) {
                    string3 = com.baidu.location.h.a.a;
                    Log.d((String)string3, (String)string4);
                }
            }
            if (object2 == null) throw var2_6;
            try {
                ((ByteArrayOutputStream)object2).close();
                throw var2_6;
            }
            catch (Exception exception) {
                string4 = com.baidu.location.h.a.a;
                Log.d((String)string4, (String)string2);
            }
            throw var2_6;
        }
        if (n11 <= 0) {
            int n19;
            f.p = n19 = f.p + n10;
            object = h10.c;
            ((f)object).j = null;
            string2 = null;
            ((f)object).a(false);
            return;
        }
        string2 = null;
        f.p = 0;
    }
}

