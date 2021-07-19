/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.baidu.location.h;

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
import javax.net.ssl.HttpsURLConnection;

public class j
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ f b;

    public j(f f10, String string2) {
        this.b = f10;
        this.a = string2;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        void var2_18;
        Object object;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        String string2;
        String string3;
        String string4;
        block76: {
            Object object6;
            block67: {
                Object object7;
                block75: {
                    block74: {
                        j j10;
                        block66: {
                            int n10;
                            block69: {
                                block72: {
                                    block73: {
                                        block65: {
                                            block68: {
                                                block71: {
                                                    block70: {
                                                        int n11;
                                                        block64: {
                                                            int n12;
                                                            block63: {
                                                                int n13;
                                                                Object object8;
                                                                j10 = this;
                                                                object7 = "gzip";
                                                                string4 = "close baos IOException!";
                                                                string3 = "close is IOException!";
                                                                string2 = "close os IOException!";
                                                                this.b.b();
                                                                object5 = this.b;
                                                                object4 = this.a;
                                                                ((f)object5).h = object4;
                                                                object5 = null;
                                                                object4 = null;
                                                                object3 = new StringBuffer();
                                                                object6 = this.b;
                                                                object6 = ((f)object6).h;
                                                                URL uRL = new URL((String)object6);
                                                                object6 = uRL.openConnection();
                                                                object6 = FirebasePerfUrlConnection.instrument(object6);
                                                                object6 = (URLConnection)object6;
                                                                object6 = (HttpsURLConnection)object6;
                                                                ((HttpURLConnection)object6).setInstanceFollowRedirects(false);
                                                                int n14 = 1;
                                                                ((URLConnection)object6).setDoOutput(n14 != 0);
                                                                ((URLConnection)object6).setDoInput(n14 != 0);
                                                                n11 = com.baidu.location.h.a.b;
                                                                ((URLConnection)object6).setConnectTimeout(n11);
                                                                n11 = com.baidu.location.h.a.c;
                                                                ((URLConnection)object6).setReadTimeout(n11);
                                                                object2 = "POST";
                                                                ((HttpURLConnection)object6).setRequestMethod((String)object2);
                                                                object2 = "Content-Type";
                                                                object = "application/x-www-form-urlencoded; charset=utf-8";
                                                                ((URLConnection)object6).setRequestProperty((String)object2, (String)object);
                                                                object2 = "Accept-Encoding";
                                                                ((URLConnection)object6).setRequestProperty((String)object2, (String)object7);
                                                                object2 = l.az;
                                                                if (object2 != null) {
                                                                    object = "bd-loc-android";
                                                                    ((URLConnection)object6).setRequestProperty((String)object, (String)object2);
                                                                }
                                                                object2 = j10.b;
                                                                object2 = ((f)object2).k;
                                                                object2 = object2.entrySet();
                                                                object2 = object2.iterator();
                                                                while ((n10 = object2.hasNext()) != 0) {
                                                                    object = object2.next();
                                                                    object = (Map.Entry)object;
                                                                    object8 = object.getKey();
                                                                    object8 = (String)object8;
                                                                    ((StringBuffer)object3).append((String)object8);
                                                                    object8 = "=";
                                                                    ((StringBuffer)object3).append((String)object8);
                                                                    object = object.getValue();
                                                                    ((StringBuffer)object3).append(object);
                                                                    object = "&";
                                                                    ((StringBuffer)object3).append((String)object);
                                                                }
                                                                n11 = ((StringBuffer)object3).length();
                                                                if (n11 > 0) {
                                                                    n11 = ((StringBuffer)object3).length() - n14;
                                                                    ((StringBuffer)object3).deleteCharAt(n11);
                                                                }
                                                                object2 = ((URLConnection)object6).getOutputStream();
                                                                object3 = ((StringBuffer)object3).toString();
                                                                object3 = ((String)object3).getBytes();
                                                                ((OutputStream)object2).write((byte[])object3);
                                                                ((OutputStream)object2).flush();
                                                                n12 = ((HttpURLConnection)object6).getResponseCode();
                                                                n10 = 200;
                                                                if (n12 != n10) break block63;
                                                                object3 = ((URLConnection)object6).getInputStream();
                                                                object = ((URLConnection)object6).getContentEncoding();
                                                                if (object != null && (n13 = ((String)object).contains((CharSequence)object7)) != 0) {
                                                                    object = new BufferedInputStream((InputStream)object3);
                                                                    object3 = object7 = new GZIPInputStream((InputStream)object);
                                                                }
                                                                object = new ByteArrayOutputStream();
                                                                n13 = 1024;
                                                                try {
                                                                    int n15;
                                                                    int n16;
                                                                    object7 = new byte[n13];
                                                                    while ((n16 = ((InputStream)object3).read((byte[])object7)) != (n15 = -1)) {
                                                                        ((ByteArrayOutputStream)object).write((byte[])object7, 0, n16);
                                                                    }
                                                                    object7 = j10.b;
                                                                    byte[] byArray = ((ByteArrayOutputStream)object).toByteArray();
                                                                    String string5 = "utf-8";
                                                                    object8 = new Object(byArray, string5);
                                                                    ((f)object7).j = object8;
                                                                    object7 = j10.b;
                                                                    ((f)object7).a(n14 != 0);
                                                                    object4 = object3;
                                                                    break block64;
                                                                }
                                                                catch (Error error) {
                                                                    break block65;
                                                                }
                                                                catch (Exception exception) {
                                                                    break block66;
                                                                }
                                                                catch (Throwable throwable) {
                                                                    n10 = 0;
                                                                    object = null;
                                                                    break block67;
                                                                }
                                                                catch (Error error) {
                                                                    n10 = 0;
                                                                    object = null;
                                                                    break block65;
                                                                }
                                                                catch (Exception exception) {
                                                                    n10 = 0;
                                                                    object = null;
                                                                    break block66;
                                                                }
                                                            }
                                                            try {
                                                                object7 = j10.b;
                                                                ((f)object7).j = null;
                                                                ((f)object7).a(false);
                                                                n10 = 0;
                                                                object = null;
                                                            }
                                                            catch (Throwable throwable) {
                                                                n12 = 0;
                                                                object3 = null;
                                                                n10 = 0;
                                                                object = null;
                                                                break block67;
                                                            }
                                                            catch (Error error) {
                                                                n12 = 0;
                                                                object3 = null;
                                                                n10 = 0;
                                                                object = null;
                                                                break block65;
                                                            }
                                                            catch (Exception exception) {
                                                                n12 = 0;
                                                                object3 = null;
                                                                n10 = 0;
                                                                object = null;
                                                                break block66;
                                                            }
                                                        }
                                                        if (object6 != null) {
                                                            ((HttpURLConnection)object6).disconnect();
                                                        }
                                                        if (object2 != null) {
                                                            try {
                                                                ((OutputStream)object2).close();
                                                            }
                                                            catch (Exception exception) {
                                                                object7 = com.baidu.location.h.a.a;
                                                                Log.d((String)object7, (String)string2);
                                                            }
                                                        }
                                                        if (object4 != null) {
                                                            try {
                                                                ((InputStream)object4).close();
                                                            }
                                                            catch (Exception exception) {
                                                                object7 = com.baidu.location.h.a.a;
                                                                Log.d((String)object7, (String)string3);
                                                            }
                                                        }
                                                        if (object == null) return;
                                                        break block75;
                                                        catch (Throwable throwable) {
                                                            boolean bl2 = false;
                                                            object3 = null;
                                                            n11 = 0;
                                                            object2 = null;
                                                            n10 = 0;
                                                            object = null;
                                                            break block67;
                                                        }
                                                        catch (Error error) {
                                                            boolean bl3 = false;
                                                            object3 = null;
                                                            n11 = 0;
                                                            object2 = null;
                                                            break block68;
                                                        }
                                                        catch (Exception exception) {
                                                            boolean bl4 = false;
                                                            object3 = null;
                                                            n11 = 0;
                                                            object2 = null;
                                                            break block69;
                                                        }
                                                        catch (Throwable throwable) {
                                                            boolean bl5 = false;
                                                            object3 = null;
                                                            boolean bl6 = false;
                                                            object2 = null;
                                                            break block70;
                                                        }
                                                        catch (Error error) {
                                                            boolean bl7 = false;
                                                            object3 = null;
                                                            object6 = null;
                                                            break block71;
                                                        }
                                                        catch (Exception exception) {
                                                            boolean bl8 = false;
                                                            object3 = null;
                                                            object6 = null;
                                                            break block72;
                                                        }
                                                        catch (Throwable throwable) {
                                                            boolean bl9 = false;
                                                            object3 = null;
                                                            Object var9_29 = null;
                                                            boolean bl10 = false;
                                                            object2 = null;
                                                        }
                                                    }
                                                    boolean bl11 = false;
                                                    object = null;
                                                    break block76;
                                                    catch (Error error) {
                                                        boolean bl12 = false;
                                                        object3 = null;
                                                        Object var9_30 = null;
                                                        object6 = null;
                                                    }
                                                }
                                                boolean bl13 = false;
                                                object2 = null;
                                            }
                                            n10 = 0;
                                            object = null;
                                        }
                                        ((Throwable)object7).printStackTrace();
                                        object7 = com.baidu.location.h.a.a;
                                        String string6 = "https NetworkCommunicationError!";
                                        Log.i((String)object7, (String)string6);
                                        object7 = j10.b;
                                        ((f)object7).j = null;
                                        ((f)object7).a(false);
                                        if (object6 == null) break block73;
                                        ((HttpURLConnection)object6).disconnect();
                                    }
                                    if (object2 != null) {
                                        try {
                                            ((OutputStream)object2).close();
                                        }
                                        catch (Exception exception) {
                                            object7 = com.baidu.location.h.a.a;
                                            Log.d((String)object7, (String)string2);
                                        }
                                    }
                                    if (object3 != null) {
                                        try {
                                            ((InputStream)object3).close();
                                        }
                                        catch (Exception exception) {
                                            object7 = com.baidu.location.h.a.a;
                                            Log.d((String)object7, (String)string3);
                                        }
                                    }
                                    if (object == null) return;
                                    break block75;
                                    catch (Exception exception) {
                                        boolean bl14 = false;
                                        object3 = null;
                                        Object var9_31 = null;
                                        object6 = null;
                                    }
                                }
                                boolean bl15 = false;
                                object2 = null;
                            }
                            n10 = 0;
                            object = null;
                        }
                        ((Throwable)object7).printStackTrace();
                        object7 = com.baidu.location.h.a.a;
                        String string7 = "https NetworkCommunicationException!";
                        Log.i((String)object7, (String)string7);
                        object7 = j10.b;
                        ((f)object7).j = null;
                        ((f)object7).a(false);
                        if (object6 == null) break block74;
                        ((HttpURLConnection)object6).disconnect();
                    }
                    if (object2 != null) {
                        try {
                            ((OutputStream)object2).close();
                        }
                        catch (Exception exception) {
                            object7 = com.baidu.location.h.a.a;
                            Log.d((String)object7, (String)string2);
                        }
                    }
                    if (object3 != null) {
                        try {
                            ((InputStream)object3).close();
                        }
                        catch (Exception exception) {
                            object7 = com.baidu.location.h.a.a;
                            Log.d((String)object7, (String)string3);
                        }
                    }
                    if (object == null) return;
                }
                try {
                    ((ByteArrayOutputStream)object).close();
                    return;
                }
                catch (Exception exception) {
                    object7 = com.baidu.location.h.a.a;
                    Log.d((String)object7, (String)string4);
                }
                return;
                catch (Throwable throwable) {
                    // empty catch block
                }
            }
            object4 = object6;
        }
        if (object4 != null) {
            ((HttpURLConnection)object4).disconnect();
        }
        if (object2 != null) {
            try {
                ((OutputStream)object2).close();
            }
            catch (Exception exception) {
                object5 = com.baidu.location.h.a.a;
                Log.d((String)object5, (String)string2);
            }
        }
        if (object3 != null) {
            try {
                ((InputStream)object3).close();
            }
            catch (Exception exception) {
                string2 = com.baidu.location.h.a.a;
                Log.d((String)string2, (String)string3);
            }
        }
        if (object == null) throw var2_18;
        try {
            ((ByteArrayOutputStream)object).close();
            throw var2_18;
        }
        catch (Exception exception) {
            string3 = com.baidu.location.h.a.a;
            Log.d((String)string3, (String)string4);
        }
        throw var2_18;
    }
}

