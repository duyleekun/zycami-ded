/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Xfermode
 *  android.util.Log
 *  android.util.LruCache
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Xfermode;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy;
import d.c.a.m.a;
import d.c.a.m.a$a;
import d.c.a.m.c;
import d.c.a.n.a.b;
import d.c.a.n.a.d.i$a;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class i
implements a {
    private static final String s = "WebpDecoder";
    private static final int t = 5;
    private ByteBuffer f;
    private WebpImage g;
    private final a$a h;
    private int i;
    private final int[] j;
    private final b[] k;
    private int l;
    private int m;
    private int n;
    private final Paint o;
    private WebpFrameCacheStrategy p;
    private Bitmap.Config q;
    private final LruCache r;

    public i(a$a a$a, WebpImage webpImage, ByteBuffer byteBuffer, int n10) {
        WebpFrameCacheStrategy webpFrameCacheStrategy = WebpFrameCacheStrategy.c;
        this(a$a, webpImage, byteBuffer, n10, webpFrameCacheStrategy);
    }

    public i(a$a object, WebpImage object2, ByteBuffer byteBuffer, int n10, WebpFrameCacheStrategy webpFrameCacheStrategy) {
        Object object3;
        int n11;
        Bitmap.Config config;
        this.i = -1;
        this.q = config = Bitmap.Config.ARGB_8888;
        this.h = object;
        this.g = object2;
        object = ((WebpImage)object2).getFrameDurations();
        this.j = (int[])object;
        object = new b[((WebpImage)object2).getFrameCount()];
        this.k = object;
        int n12 = 0;
        object = null;
        config = null;
        for (int i10 = 0; i10 < (n11 = ((WebpImage)(object3 = this.g)).getFrameCount()); ++i10) {
            object3 = this.k;
            Object object4 = this.g.getFrameInfo(i10);
            object3[i10] = object4;
            object4 = s;
            n11 = (int)(Log.isLoggable((String)object4, (int)3) ? 1 : 0);
            if (n11 == 0) continue;
            ((StringBuilder)object3).append("mFrameInfos: ");
            String string2 = this.k[i10].toString();
            ((StringBuilder)object3).append(string2);
            object3 = ((StringBuilder)object3).toString();
            Log.d((String)object4, (String)object3);
        }
        this.p = webpFrameCacheStrategy;
        super();
        this.o = webpFrameCacheStrategy;
        webpFrameCacheStrategy.setColor(0);
        object = Paint.Style.FILL;
        webpFrameCacheStrategy.setStyle((Paint.Style)object);
        config = PorterDuff.Mode.SRC;
        super((PorterDuff.Mode)config);
        webpFrameCacheStrategy.setXfermode((Xfermode)object);
        n12 = 5;
        webpFrameCacheStrategy = this.p;
        boolean bl2 = webpFrameCacheStrategy.a();
        if (bl2) {
            n12 = ((WebpImage)object2).getFrameCount();
        } else {
            object2 = this.p;
            int n13 = ((WebpFrameCacheStrategy)object2).d();
            n12 = Math.max(n12, n13);
        }
        object2 = new i$a(this, n12);
        this.r = object2;
        super();
        this.m((c)object, byteBuffer, n10);
    }

    public static /* synthetic */ a$a p(i i10) {
        return i10.h;
    }

    private void q(int n10, Bitmap bitmap) {
        Object object = this.r;
        Integer n11 = n10;
        object.remove((Object)n11);
        object = this.h;
        int n12 = bitmap.getWidth();
        int n13 = bitmap.getHeight();
        Bitmap.Config config = bitmap.getConfig();
        object = object.b(n12, n13, config);
        object.eraseColor(0);
        n11 = new Canvas((Bitmap)object);
        n11.drawBitmap(bitmap, 0.0f, 0.0f, null);
        bitmap = this.r;
        Integer n14 = n10;
        bitmap.put((Object)n14, object);
    }

    private void r(Canvas canvas, b b10) {
        int n10 = b10.b;
        int n11 = this.l;
        float f10 = n10 / n11;
        int n12 = b10.c;
        float f11 = n12 / n11;
        int n13 = b10.d;
        float f12 = (n10 + n13) / n11;
        int n14 = b10.e;
        float f13 = (n12 + n14) / n11;
        Paint paint = this.o;
        canvas.drawRect(f10, f11, f12, f13, paint);
    }

    private boolean t(b b10) {
        WebpImage webpImage;
        int n10;
        WebpImage webpImage2;
        int n11;
        int n12 = b10.b;
        if (n12 == 0 && (n12 = b10.c) == 0 && (n12 = b10.d) == (n11 = (webpImage2 = this.g).getWidth()) && (n10 = b10.e) == (n12 = (webpImage = this.g).getHeight())) {
            n10 = 1;
        } else {
            n10 = 0;
            b10 = null;
        }
        return n10 != 0;
    }

    private boolean u(int n10) {
        int n11 = 1;
        if (n10 == 0) {
            return n11 != 0;
        }
        b[] bArray = this.k;
        b b10 = bArray[n10];
        b b11 = bArray[n10 -= n11];
        boolean bl2 = b10.g;
        if (!bl2 && (bl2 = this.t(b10))) {
            return n11 != 0;
        }
        bl2 = b11.h;
        if (!bl2 || (n10 = (int)(this.t(b11) ? 1 : 0)) == 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    private int v(int n10, Canvas canvas) {
        while (n10 >= 0) {
            boolean bl2;
            b b10 = this.k[n10];
            boolean bl3 = b10.h;
            if (bl3 && (bl3 = this.t(b10))) {
                return n10 + 1;
            }
            LruCache lruCache = this.r;
            Integer n11 = n10;
            if ((lruCache = (Bitmap)lruCache.get((Object)n11)) != null && !(bl2 = lruCache.isRecycled())) {
                bl2 = false;
                n11 = null;
                canvas.drawBitmap((Bitmap)lruCache, 0.0f, 0.0f, null);
                bl3 = b10.h;
                if (bl3) {
                    this.r(canvas, b10);
                }
                return n10 + 1;
            }
            boolean bl4 = this.u(n10);
            if (bl4) {
                return n10;
            }
            n10 += -1;
        }
        return 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void w(int n10, Canvas object) {
        Throwable throwable2;
        WebpFrame webpFrame;
        block5: {
            block6: {
                Object object2 = this.k[n10];
                int n11 = ((b)object2).d;
                int n12 = this.l;
                n11 /= n12;
                int n13 = ((b)object2).e / n12;
                int n14 = ((b)object2).b / n12;
                int n15 = ((b)object2).c / n12;
                webpFrame = this.g.getFrame(n10);
                a$a a$a = this.h;
                Bitmap.Config config = this.q;
                a$a = a$a.b(n11, n13, config);
                config = null;
                a$a.eraseColor(0);
                webpFrame.renderFrame(n11, n13, (Bitmap)a$a);
                {
                    catch (Throwable throwable2) {
                        break block5;
                    }
                    catch (IllegalStateException illegalStateException) {}
                    object = s;
                    {
                        object2 = new StringBuilder();
                        String string2 = "Rendering of frame failed. Frame number: ";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(n10);
                        String string3 = ((StringBuilder)object2).toString();
                        Log.e((String)object, (String)string3);
                        break block6;
                    }
                }
                float f10 = n14;
                float f11 = n15;
                n13 = 0;
                {
                    object.drawBitmap((Bitmap)a$a, f10, f11, null);
                    object = this.h;
                    object.a((Bitmap)a$a);
                }
            }
            webpFrame.dispose();
            return;
        }
        webpFrame.dispose();
        throw throwable2;
    }

    /*
     * WARNING - void declaration
     */
    public Bitmap a() {
        String string2;
        String string3;
        boolean bl2;
        Object object;
        int bl22 = this.l();
        a$a a$a = this.h;
        int n10 = this.n;
        int bl3 = this.m;
        Object object2 = Bitmap.Config.ARGB_8888;
        a$a = a$a.b(n10, bl3, (Bitmap.Config)object2);
        Object object3 = new Canvas((Bitmap)a$a);
        Object object4 = PorterDuff.Mode.SRC;
        object2 = null;
        object3.drawColor(0, (PorterDuff.Mode)object4);
        object4 = this.p;
        boolean bl4 = ((WebpFrameCacheStrategy)object4).e();
        int n11 = 3;
        String string4 = s;
        if (!bl4) {
            object4 = this.r;
            object = bl22;
            if ((object4 = (Bitmap)object4.get(object)) != null) {
                boolean bl5 = Log.isLoggable((String)string4, (int)n11);
                if (bl5) {
                    object2 = new StringBuilder();
                    object = "hit frame bitmap from memory cache, frameNumber=";
                    ((StringBuilder)object2).append((String)object);
                    ((StringBuilder)object2).append(bl22);
                    String string5 = ((StringBuilder)object2).toString();
                    Log.d((String)string4, (String)string5);
                }
                object3.drawBitmap((Bitmap)object4, 0.0f, 0.0f, null);
                return a$a;
            }
        }
        if (!(bl2 = this.u(bl22))) {
            int n13 = bl22 + -1;
            n13 = this.v(n13, (Canvas)object3);
        } else {
            int n14 = bl22;
        }
        boolean bl6 = Log.isLoggable((String)string4, (int)n11);
        if (bl6) {
            void var4_10;
            object = new StringBuilder();
            ((StringBuilder)object).append("frameNumber=");
            ((StringBuilder)object).append(bl22);
            string3 = ", nextIndex=";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append((int)var4_10);
            object = ((StringBuilder)object).toString();
            Log.d((String)string4, (String)object);
        }
        while (true) {
            void var4_11;
            object = ", dispose=";
            string3 = ", blend=";
            string2 = "renderFrame, index=";
            if (++var4_11 >= bl22) break;
            b b10 = this.k[var4_11];
            boolean bl7 = b10.g;
            if (!bl7) {
                this.r((Canvas)object3, b10);
            }
            this.w((int)var4_11, (Canvas)object3);
            bl7 = Log.isLoggable((String)string4, (int)n11);
            if (bl7) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(string2);
                stringBuilder.append((int)var4_11);
                stringBuilder.append(string3);
                boolean bl8 = b10.g;
                stringBuilder.append(bl8);
                stringBuilder.append((String)object);
                bl6 = b10.h;
                stringBuilder.append(bl6);
                object = stringBuilder.toString();
                Log.d((String)string4, (String)object);
            }
            if (!(bl6 = b10.h)) continue;
            this.r((Canvas)object3, b10);
        }
        object4 = this.k[bl22];
        boolean bl9 = ((b)object4).g;
        if (!bl9) {
            this.r((Canvas)object3, (b)object4);
        }
        this.w(bl22, (Canvas)object3);
        n10 = (int)(Log.isLoggable((String)string4, (int)n11) ? 1 : 0);
        if (n10 != 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append(string2);
            ((StringBuilder)object3).append(bl22);
            ((StringBuilder)object3).append(string3);
            boolean bl10 = ((b)object4).g;
            ((StringBuilder)object3).append(bl10);
            ((StringBuilder)object3).append((String)object);
            boolean bl11 = ((b)object4).h;
            ((StringBuilder)object3).append(bl11);
            object3 = ((StringBuilder)object3).toString();
            Log.d((String)string4, (String)object3);
        }
        this.q(bl22, (Bitmap)a$a);
        return a$a;
    }

    public void b() {
        int n10 = this.i + 1;
        int n11 = this.g.getFrameCount();
        this.i = n10 %= n11;
    }

    public int c() {
        return this.g.getFrameCount();
    }

    public void clear() {
        this.g.dispose();
        this.g = null;
        this.r.evictAll();
        this.f = null;
    }

    public void d(Bitmap.Config object) {
        Object object2 = Bitmap.Config.ARGB_8888;
        if (object == object2) {
            this.q = object;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported format: ");
        stringBuilder.append(object);
        stringBuilder.append(", must be one of ");
        object = Bitmap.Config.ARGB_8888;
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    public int e(int n10) {
        int[] nArray;
        int n11;
        n10 = n10 >= 0 && n10 < (n11 = (nArray = this.j).length) ? nArray[n10] : -1;
        return n10;
    }

    public int f() {
        WebpImage webpImage = this.g;
        int n10 = webpImage.getLoopCount();
        if (n10 == 0) {
            return 0;
        }
        return this.g.getLoopCount();
    }

    public int g() {
        return this.g.getLoopCount();
    }

    public ByteBuffer getData() {
        return this.f;
    }

    public int getHeight() {
        return this.g.getHeight();
    }

    public int getStatus() {
        return 0;
    }

    public int getWidth() {
        return this.g.getWidth();
    }

    public void h(c c10, byte[] object) {
        object = ByteBuffer.wrap(object);
        this.k(c10, (ByteBuffer)object);
    }

    public int i() {
        int[] nArray = this.j;
        int n10 = nArray.length;
        if (n10 != 0 && (n10 = this.i) >= 0) {
            return this.e(n10);
        }
        return 0;
    }

    public void j() {
        this.i = -1;
    }

    public void k(c c10, ByteBuffer byteBuffer) {
        this.m(c10, byteBuffer, 1);
    }

    public int l() {
        return this.i;
    }

    public void m(c object, ByteBuffer object2, int n10) {
        if (n10 > 0) {
            int n11;
            int n12 = Integer.highestOneBit(n10);
            object2 = ((ByteBuffer)object2).asReadOnlyBuffer();
            this.f = object2;
            ((ByteBuffer)object2).position(0);
            this.l = n12;
            this.n = n11 = this.g.getWidth() / n12;
            this.m = n11 = this.g.getHeight() / n12;
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Sample size must be >=0, not: ");
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public int n() {
        return this.g.getLoopCount();
    }

    public int o() {
        return this.g.getSizeInBytes();
    }

    public int read(InputStream inputStream, int n10) {
        return 0;
    }

    public int read(byte[] byArray) {
        return 0;
    }

    public WebpFrameCacheStrategy s() {
        return this.p;
    }
}

