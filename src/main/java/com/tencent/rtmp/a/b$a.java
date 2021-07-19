/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.a;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.a.b;
import com.tencent.rtmp.a.c;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.ref.WeakReference;

public class b$a
implements Runnable {
    private WeakReference a;
    private String b;

    public b$a(b b10, String string2) {
        WeakReference<b> weakReference;
        this.a = weakReference = new WeakReference<b>(b10);
        this.b = string2;
    }

    private float a(String object) {
        float f10;
        float f11;
        Object object2 = ":";
        object = ((String)object).split((String)object2);
        int n10 = ((String[])object).length;
        int n11 = 2;
        float f12 = 2.8E-45f;
        int n12 = 1;
        float f13 = Float.MIN_VALUE;
        float f14 = 0.0f;
        String string2 = null;
        int n13 = 3;
        if (n10 == n13) {
            string2 = object[0];
            object2 = object[n12];
            object = object[n11];
        } else {
            n10 = ((String[])object).length;
            if (n10 == n11) {
                object2 = object[0];
                object = object[n12];
            } else {
                n10 = ((String[])object).length;
                if (n10 == n12) {
                    object = object[0];
                    n10 = 0;
                    object2 = null;
                    f11 = 0.0f;
                } else {
                    object = null;
                    f10 = 0.0f;
                    n10 = 0;
                    object2 = null;
                    f11 = 0.0f;
                }
            }
        }
        n11 = 0;
        f12 = 0.0f;
        if (string2 != null) {
            Float f15 = Float.valueOf(0.0f);
            f13 = f15.floatValue();
            f14 = 3600.0f;
            f12 = 0.0f + (f13 *= f14);
        }
        if (object2 != null) {
            object2 = Float.valueOf((String)object2);
            f11 = ((Float)object2).floatValue();
            n12 = 1114636288;
            f13 = 60.0f;
            f12 += (f11 *= f13);
        }
        if (object != null) {
            object = Float.valueOf((String)object);
            f10 = ((Float)object).floatValue();
            f12 += f10;
        }
        return f12;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        void var1_4;
        Object object;
        block22: {
            Object object2;
            String string2;
            block23: {
                BufferedReader bufferedReader;
                block21: {
                    b b10;
                    block20: {
                        int n10;
                        string2 = "TXImageSprite";
                        b10 = (b)this.a.get();
                        boolean bl2 = false;
                        object = null;
                        object2 = this.b;
                        object2 = com.tencent.rtmp.a.b.a(b10, (String)object2);
                        if (object2 == null) {
                            return;
                        }
                        Object object3 = new InputStreamReader((InputStream)object2);
                        bufferedReader = new BufferedReader((Reader)object3);
                        object = bufferedReader.readLine();
                        if (object == null || (n10 = ((String)object).length()) == 0 || !(bl2 = ((String)object).contains((CharSequence)(object2 = "WEBVTT")))) break block20;
                        do {
                            int n11;
                            float f10;
                            float f11;
                            int n12;
                            if ((object = bufferedReader.readLine()) == null || (n10 = (int)(((String)object).contains((CharSequence)(object2 = "-->")) ? 1 : 0)) == 0) continue;
                            object2 = " --> ";
                            int n13 = ((String[])(object2 = ((String)object).split((String)object2))).length;
                            if (n13 != (n12 = 2)) continue;
                            object3 = bufferedReader.readLine();
                            c c10 = new c();
                            String string3 = object2[0];
                            c10.a = f11 = this.a(string3);
                            int n14 = 1;
                            f11 = Float.MIN_VALUE;
                            object2 = object2[n14];
                            c10.b = f10 = this.a((String)object2);
                            c10.c = object3;
                            object2 = "#";
                            n10 = ((String)object3).indexOf((String)object2);
                            if (n10 != (n11 = -1)) {
                                object2 = ((String)object3).substring(0, n10);
                                c10.d = object2;
                            }
                            if ((n10 = ((String)object3).indexOf((String)(object2 = "="))) != n11 && ++n10 < (n11 = ((String)object3).length())) {
                                n11 = ((String)object3).length();
                                object2 = ((String)object3).substring(n10, n11);
                                object3 = ",";
                                n13 = ((Object)(object2 = ((String)object2).split((String)object3))).length;
                                if (n13 == (n11 = 4)) {
                                    object3 = object2[0];
                                    object3 = Integer.valueOf((String)object3);
                                    c10.e = n13 = ((Integer)object3).intValue();
                                    object3 = object2[n14];
                                    object3 = Integer.valueOf((String)object3);
                                    c10.f = n13 = ((Integer)object3).intValue();
                                    object3 = object2[n12];
                                    object3 = Integer.valueOf((String)object3);
                                    c10.g = n13 = ((Integer)object3).intValue();
                                    n13 = 3;
                                    object2 = object2[n13];
                                    object2 = Integer.valueOf((String)object2);
                                    c10.h = n10 = ((Integer)object2).intValue();
                                }
                            }
                            if (b10 == null || (object2 = com.tencent.rtmp.a.b.a(b10)) == null) continue;
                            object2 = com.tencent.rtmp.a.b.a(b10);
                            object2.add(c10);
                        } while (object != null);
                        try {
                            bufferedReader.close();
                            return;
                        }
                        catch (IOException iOException) {
                            return;
                        }
                    }
                    object = "DownloadAndParseVTTFileTask : getVTT File Error!";
                    TXCLog.e(string2, (String)object);
                    if (b10 == null) break block21;
                    com.tencent.rtmp.a.b.c(b10);
                }
                try {
                    bufferedReader.close();
                    return;
                }
                catch (IOException iOException) {
                    return;
                }
                catch (Throwable throwable) {
                    object = bufferedReader;
                    break block22;
                }
                catch (IOException iOException) {
                    object = bufferedReader;
                    break block23;
                }
                catch (Throwable throwable) {
                    break block22;
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
            object2 = "load image sprite failed.";
            {
                void var2_8;
                TXCLog.e(string2, (String)object2, (Throwable)var2_8);
                if (object == null) return;
            }
            ((BufferedReader)object).close();
            return;
        }
        if (object == null) throw var1_4;
        try {}
        catch (IOException iOException) {
            throw var1_4;
        }
        ((BufferedReader)object).close();
        throw var1_4;
    }
}

