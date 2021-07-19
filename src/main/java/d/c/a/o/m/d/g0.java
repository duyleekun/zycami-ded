/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.media.MediaMetadataRetriever
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.util.Log;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import d.c.a.o.e;
import d.c.a.o.e$b;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.d.g0$a;
import d.c.a.o.m.d.g0$b;
import d.c.a.o.m.d.g0$c;
import d.c.a.o.m.d.g0$d;
import d.c.a.o.m.d.g0$e;
import d.c.a.o.m.d.g0$f;
import d.c.a.o.m.d.g0$g;
import java.io.IOException;

public class g0
implements g {
    private static final String d = "VideoDecoder";
    public static final long e = 255L;
    public static final int f = 2;
    public static final e g;
    public static final e h;
    private static final g0$e i;
    private final g0$f a;
    private final d.c.a.o.k.x.e b;
    private final g0$e c;

    static {
        Object object = (long)-1;
        e$b e$b = new g0$a();
        g = d.c.a.o.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", object, e$b);
        object = 2;
        e$b = new g0$b();
        h = d.c.a.o.e.b("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", object, e$b);
        i = object = new g0$e();
    }

    public g0(d.c.a.o.k.x.e e10, g0$f g0$f) {
        g0$e g0$e = i;
        this(e10, g0$f, g0$e);
    }

    public g0(d.c.a.o.k.x.e e10, g0$f g0$f, g0$e g0$e) {
        this.b = e10;
        this.a = g0$f;
        this.c = g0$e;
    }

    public static g c(d.c.a.o.k.x.e e10) {
        g0$c g0$c = new g0$c(null);
        g0 g02 = new g0(e10, g0$c);
        return g02;
    }

    public static g d(d.c.a.o.k.x.e e10) {
        g0$d g0$d = new g0$d();
        g0 g02 = new g0(e10, g0$d);
        return g02;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long l10, int n10, int n11, int n12, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmap;
        DownsampleStrategy downsampleStrategy2;
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 27;
        if (n13 >= n14 && n11 != (n13 = -1 << -1) && n12 != n13 && downsampleStrategy != (downsampleStrategy2 = DownsampleStrategy.f)) {
            bitmap = g0.g(mediaMetadataRetriever, l10, n10, n11, n12, downsampleStrategy);
        } else {
            n11 = 0;
            bitmap = null;
        }
        if (bitmap == null) {
            bitmap = g0.f(mediaMetadataRetriever, l10, n10);
        }
        return bitmap;
    }

    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long l10, int n10) {
        return mediaMetadataRetriever.getFrameAtTime(l10, n10);
    }

    private static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long l10, int n10, int n11, int n12, DownsampleStrategy downsampleStrategy) {
        String string2;
        int n13;
        int n14;
        block12: {
            String string3;
            n14 = 18;
            try {
                string3 = mediaMetadataRetriever.extractMetadata(n14);
            }
            catch (Throwable throwable) {
                String string4 = d;
                boolean bl2 = Log.isLoggable((String)string4, (int)3);
                if (bl2) {
                    String string5 = "Exception trying to decode frame on oreo+";
                    Log.d((String)string4, (String)string5, (Throwable)throwable);
                }
                return null;
            }
            n14 = Integer.parseInt(string3);
            n13 = 19;
            String string6 = mediaMetadataRetriever.extractMetadata(n13);
            n13 = Integer.parseInt(string6);
            int n15 = 24;
            string2 = mediaMetadataRetriever.extractMetadata(n15);
            n15 = Integer.parseInt(string2);
            int n16 = 90;
            if (n15 != n16 && n15 != (n16 = 270)) break block12;
            int n17 = n13;
            n13 = n14;
            n14 = n17;
        }
        float f10 = downsampleStrategy.b(n14, n13, n11, n12);
        float f11 = (float)n14 * f10;
        int n18 = Math.round(f11);
        f11 = n13;
        f10 *= f11;
        int n19 = Math.round(f10);
        string2 = mediaMetadataRetriever;
        return mediaMetadataRetriever.getScaledFrameAtTime(l10, n10, n18, n19);
    }

    public static g h(d.c.a.o.k.x.e e10) {
        g0$g g0$g = new g0$g();
        g0 g02 = new g0(e10, g0$g);
        return g02;
    }

    public boolean a(Object object, f f10) {
        return true;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public s b(Object object, int n10, int n11, f object2) {
        Throwable throwable2222222;
        block7: {
            Object object3;
            long l10;
            long l11;
            Object object4 = g;
            long l12 = (Long)(object4 = (Long)((f)object2).c((e)object4));
            long l13 = l12 - (l11 = 0L);
            Object object5 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object5 < 0 && (object5 = (l10 = l12 - (l11 = (long)-1)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) != false) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("Requested frame must be non-negative, or DEFAULT_FRAME, given: ");
                charSequence.append(l12);
                charSequence = charSequence.toString();
                object = new IllegalArgumentException((String)charSequence);
                throw object;
            }
            object4 = h;
            if ((object4 = (Integer)((f)object2).c((e)object4)) == null) {
                object5 = 2;
                object4 = (int)object5;
            }
            if ((object2 = (DownsampleStrategy)((f)object2).c((e)(object3 = DownsampleStrategy.h))) == null) {
                object2 = DownsampleStrategy.g;
            }
            Object object6 = object2;
            object2 = this.c.a();
            object3 = this.a;
            object3.a((MediaMetadataRetriever)object2, object);
            int n12 = (Integer)object4;
            object3 = object2;
            object = g0.e((MediaMetadataRetriever)object2, l12, n12, n10, n11, (DownsampleStrategy)object6);
            {
                catch (Throwable throwable2222222) {
                    break block7;
                }
                catch (RuntimeException runtimeException) {}
                {
                    IOException iOException = new IOException(runtimeException);
                    throw iOException;
                }
            }
            object2.release();
            d.c.a.o.k.x.e e10 = this.b;
            return d.c.a.o.m.d.g.d((Bitmap)object, e10);
        }
        object2.release();
        throw throwable2222222;
    }
}

