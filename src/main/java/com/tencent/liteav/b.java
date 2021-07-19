/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.drawable.ColorDrawable
 *  android.os.HandlerThread
 *  android.os.Looper
 */
package com.tencent.liteav;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.liteav.b$a;
import com.tencent.liteav.b$b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b {
    private static final String a = "b";
    private int b = 300;
    private long c = 0L;
    private b$a d;
    private HandlerThread e;
    private boolean f = false;
    private ByteBuffer g = null;
    private Bitmap h = null;
    private int i = 0;
    private int j = 0;
    private WeakReference k = null;

    public b(b$b b$b) {
        WeakReference<b$b> weakReference;
        this.k = weakReference = new WeakReference<b$b>(b$b);
    }

    public static /* synthetic */ void a(b b10) {
        b10.f();
    }

    public static /* synthetic */ boolean a(b b10, boolean bl2) {
        b10.f = bl2;
        return bl2;
    }

    public static /* synthetic */ WeakReference b(b b10) {
        return b10.k;
    }

    private void b(int n10, int n11) {
        if (n10 > 0) {
            int n12 = 5;
            int n13 = 20;
            if (n10 >= n13) {
                n10 = n13;
            } else if (n10 <= n12) {
                n10 = n12;
            }
            this.b = n12 = 1000 / n10;
        } else {
            this.b = n10 = 200;
        }
        long l10 = n11;
        if (n11 > 0) {
            long l11 = System.currentTimeMillis();
            long l12 = 1000L;
            this.c = l11 += (l10 *= l12);
        } else if (n11 == 0) {
            long l13 = System.currentTimeMillis();
            l10 = 300000L;
            this.c = l13 += l10;
        } else {
            long l14;
            this.c = l14 = (long)-1;
        }
    }

    public static /* synthetic */ String c() {
        return a;
    }

    public static /* synthetic */ boolean c(b b10) {
        return b10.f;
    }

    private void d() {
        Object object;
        this.e();
        this.e = object = new HandlerThread("TXImageCapturer");
        object.start();
        Looper looper = this.e.getLooper();
        int n10 = this.b;
        long l10 = this.c;
        object = new b$a(this, looper, n10, l10);
        this.d = object;
    }

    private void e() {
        b$a b$a = this.d;
        if (b$a != null) {
            b$a.removeCallbacksAndMessages(null);
            this.d = null;
        }
        if ((b$a = this.e) != null) {
            b$a.quit();
            this.e = null;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        Object object;
        int n10;
        StringBuilder stringBuilder;
        Object object2;
        int n11;
        String string2;
        block13: {
            block12: {
                block11: {
                    ByteBuffer byteBuffer;
                    block10: {
                        string2 = "*";
                        n11 = 0;
                        object2 = this.k;
                        if (object2 == null) return;
                        boolean bl2 = this.f;
                        if (!bl2) return;
                        object2 = ((Reference)object2).get();
                        if ((object2 = (b$b)object2) == null) return;
                        stringBuilder = this.h;
                        byteBuffer = this.g;
                        if (byteBuffer != null || stringBuilder == null) break block10;
                        n10 = stringBuilder.getWidth();
                        try {
                            n11 = stringBuilder.getHeight();
                            int n12 = n10 * n11 * 4;
                            object = ByteBuffer.allocateDirect(n12);
                            stringBuilder.copyPixelsToBuffer((Buffer)object);
                            ((ByteBuffer)object).rewind();
                            this.g = object;
                            int n13 = n10;
                            n10 = n11;
                            n11 = n13;
                            break block11;
                        }
                        catch (Error error) {
                            int n14 = n10;
                            n10 = n11;
                            n11 = n14;
                            break block12;
                        }
                        catch (Exception exception) {
                            int n15 = n10;
                            n10 = n11;
                            n11 = n15;
                            break block13;
                        }
                    }
                    object = byteBuffer;
                    n10 = 0;
                    byteBuffer = null;
                }
                if (stringBuilder == null) return;
                if (object == null) return;
                int n16 = this.i;
                int n17 = this.j;
                object2.a((Bitmap)stringBuilder, (ByteBuffer)object, n16, n17);
                return;
                catch (Error error) {
                    n10 = 0;
                    Object var6_7 = null;
                    break block12;
                }
                catch (Exception exception) {
                    n10 = 0;
                    Object var6_8 = null;
                    break block13;
                }
                catch (Error error) {}
            }
            object2 = a;
            stringBuilder = new StringBuilder();
            object = "bkgpush: generate bitmap pixel error ";
            stringBuilder.append((String)object);
            stringBuilder.append(n11);
            stringBuilder.append(string2);
            stringBuilder.append(n10);
            string2 = stringBuilder.toString();
            TXCLog.w((String)object2, string2);
            return;
            catch (Exception exception) {}
        }
        object2 = a;
        stringBuilder = new StringBuilder();
        object = "bkgpush: generate bitmap pixel exception ";
        stringBuilder.append((String)object);
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        string2 = stringBuilder.toString();
        TXCLog.w((String)object2, string2);
    }

    public void a(int n10, int n11) {
        long l10;
        int n12 = this.f;
        if (n12 != 0) {
            TXCLog.w(a, "bkgpush: start background publish return when started");
            return;
        }
        this.f = n12 = 1;
        this.b(n10, n11);
        this.d();
        Object object = this.d;
        if (object != null) {
            n11 = 1001;
            n12 = this.b;
            l10 = n12;
            object.sendEmptyMessageDelayed(n11, l10);
        }
        object = a;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("bkgpush: start background publish with time:");
        l10 = this.c;
        long l11 = System.currentTimeMillis();
        l10 = (l10 - l11) / 1000L;
        charSequence.append(l10);
        charSequence.append(", interval:");
        n12 = this.b;
        charSequence.append(n12);
        charSequence = charSequence.toString();
        TXCLog.w((String)object, (String)charSequence);
    }

    public void a(int n10, int n11, Bitmap object, int n12, int n13) {
        CharSequence charSequence;
        CharSequence charSequence2;
        boolean bl2 = this.f;
        if (bl2) {
            TXCLog.w(a, "bkgpush: start background publish return when started");
            return;
        }
        String string2 = "*";
        String string3 = "save bitmap failed.";
        if (object == null) {
            object = a;
            charSequence2 = new StringBuilder();
            charSequence = "bkgpush: background publish img is empty, add default img ";
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(n12);
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(n13);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            TXCLog.w((String)object, (String)charSequence2);
            int n14 = -16777216;
            object = new ColorDrawable(n14);
            charSequence2 = Bitmap.Config.ARGB_8888;
            charSequence2 = Bitmap.createBitmap((int)n12, (int)n13, (Bitmap.Config)charSequence2);
            charSequence = new Canvas((Bitmap)charSequence2);
            object.draw((Canvas)charSequence);
            object = charSequence2;
        }
        charSequence2 = a;
        charSequence = new StringBuilder();
        String string4 = "bkgpush: generate bitmap ";
        ((StringBuilder)charSequence).append(string4);
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n13);
        string2 = ((StringBuilder)charSequence).toString();
        TXCLog.w((String)charSequence2, string2);
        try {
            this.h = object;
        }
        catch (Error error) {
            string2 = a;
            TXCLog.e(string2, string3, error);
        }
        catch (Exception exception) {
            string2 = a;
            TXCLog.e(string2, string3, exception);
        }
        this.i = n12;
        this.j = n13;
        this.a(n10, n11);
    }

    public boolean a() {
        return this.f;
    }

    public void b() {
        this.f = false;
        this.g = null;
        this.h = null;
        TXCLog.w(a, "bkgpush: stop background publish");
        this.e();
    }
}

