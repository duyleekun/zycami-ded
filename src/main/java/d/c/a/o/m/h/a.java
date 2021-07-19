/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.util.Log
 */
package d.c.a.o.m.h;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import d.c.a.m.d;
import d.c.a.o.b;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.i;
import d.c.a.o.m.c;
import d.c.a.o.m.h.a$a;
import d.c.a.o.m.h.a$b;
import java.nio.ByteBuffer;
import java.util.List;

public class a
implements g {
    private static final String f = "BufferGifDecoder";
    private static final a$a g;
    private static final a$b h;
    private final Context a;
    private final List b;
    private final a$b c;
    private final a$a d;
    private final d.c.a.o.m.h.b e;

    static {
        Object object = new a$a();
        g = object;
        h = object = new a$b();
    }

    public a(Context context) {
        List list = d.c.a.c.d(context).m().g();
        d.c.a.o.k.x.e e10 = d.c.a.c.d(context).g();
        d.c.a.o.k.x.b b10 = d.c.a.c.d(context).f();
        this(context, list, e10, b10);
    }

    public a(Context context, List list, d.c.a.o.k.x.e e10, d.c.a.o.k.x.b b10) {
        a$b a$b = h;
        a$a a$a = g;
        this(context, list, e10, b10, a$b, a$a);
    }

    public a(Context object, List list, d.c.a.o.k.x.e e10, d.c.a.o.k.x.b b10, a$b a$b, a$a a$a) {
        this.a = object = object.getApplicationContext();
        this.b = list;
        this.d = a$a;
        super(e10, b10);
        this.e = object;
        this.c = a$b;
    }

    private d.c.a.o.m.h.e c(ByteBuffer byteBuffer, int n10, int n11, d d10, f f10) {
        boolean bl2;
        Object object;
        int n12;
        long l10;
        String string2;
        String string3;
        block23: {
            Bitmap bitmap;
            Object object2;
            Object object3;
            a$a a$a;
            Object object4;
            Object object5;
            a a10;
            block26: {
                block25: {
                    block24: {
                        a10 = this;
                        string3 = "Decoded GIF from stream in ";
                        string2 = f;
                        l10 = d.c.a.u.g.b();
                        n12 = 2;
                        try {
                            object = d10.d();
                        }
                        catch (Throwable throwable) {
                            n12 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                            if (n12 != 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(string3);
                                double d11 = d.c.a.u.g.a(l10);
                                stringBuilder.append(d11);
                                string3 = stringBuilder.toString();
                                Log.v((String)string2, (String)string3);
                            }
                            throw throwable;
                        }
                        int n13 = ((d.c.a.m.c)object).b();
                        if (n13 <= 0) break block23;
                        n13 = ((d.c.a.m.c)object).c();
                        if (n13 != 0) break block23;
                        object5 = d.c.a.o.m.h.i.a;
                        object4 = f10;
                        object5 = f10.c((e)object5);
                        object4 = DecodeFormat.PREFER_RGB_565;
                        if (object5 != object4) break block24;
                        object5 = Bitmap.Config.RGB_565;
                        break block25;
                    }
                    object5 = Bitmap.Config.ARGB_8888;
                }
                int n14 = d.c.a.o.m.h.a.e((d.c.a.m.c)object, n10, n11);
                a$a = a10.d;
                object3 = a10.e;
                object2 = byteBuffer;
                object3 = a$a.a((d.c.a.m.a$a)object3, (d.c.a.m.c)object, byteBuffer, n14);
                object3.d((Bitmap.Config)object5);
                object3.b();
                bitmap = object3.a();
                if (bitmap != null) break block26;
                boolean bl3 = Log.isLoggable((String)string2, (int)n12);
                if (bl3) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    double d12 = d.c.a.u.g.a(l10);
                    ((StringBuilder)object).append(d12);
                    object = ((StringBuilder)object).toString();
                    Log.v((String)string2, (String)object);
                }
                return null;
            }
            object2 = d.c.a.o.m.c.c();
            a$a = a10.a;
            object4 = object;
            object = new d.c.a.o.m.h.c((Context)a$a, (d.c.a.m.a)object3, (i)object2, n10, n11, bitmap);
            object5 = new d.c.a.o.m.h.e((d.c.a.o.m.h.c)object);
            boolean bl4 = Log.isLoggable((String)string2, (int)n12);
            if (bl4) {
                object = new StringBuilder();
                ((StringBuilder)object).append(string3);
                double d13 = d.c.a.u.g.a(l10);
                ((StringBuilder)object).append(d13);
                object = ((StringBuilder)object).toString();
                Log.v((String)string2, (String)object);
            }
            return object5;
        }
        if (bl2 = Log.isLoggable((String)string2, (int)n12)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string3);
            double d14 = d.c.a.u.g.a(l10);
            ((StringBuilder)object).append(d14);
            object = ((StringBuilder)object).toString();
            Log.v((String)string2, (String)object);
        }
        return null;
    }

    private static int e(d.c.a.m.c object, int n10, int n11) {
        int n12 = ((d.c.a.m.c)object).a() / n11;
        int n13 = ((d.c.a.m.c)object).d() / n10;
        n12 = (n12 = Math.min(n12, n13)) == 0 ? 0 : Integer.highestOneBit(n12);
        n13 = 1;
        n12 = Math.max(n13, n12);
        String string2 = f;
        boolean bl2 = Log.isLoggable((String)string2, (int)2);
        if (bl2 && n12 > n13) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Downsampling GIF, sampleSize: ");
            stringBuilder.append(n12);
            String string3 = ", target dimens: [";
            stringBuilder.append(string3);
            stringBuilder.append(n10);
            String string4 = "x";
            stringBuilder.append(string4);
            stringBuilder.append(n11);
            String string5 = "], actual dimens: [";
            stringBuilder.append(string5);
            n11 = ((d.c.a.m.c)object).d();
            stringBuilder.append(n11);
            stringBuilder.append(string4);
            int n14 = ((d.c.a.m.c)object).a();
            stringBuilder.append(n14);
            stringBuilder.append("]");
            object = stringBuilder.toString();
            Log.v((String)string2, (String)object);
        }
        return n12;
    }

    public d.c.a.o.m.h.e d(ByteBuffer object, int n10, int n11, f f10) {
        d d10 = this.c.a((ByteBuffer)object);
        try {
            object = this.c((ByteBuffer)object, n10, n11, d10, f10);
            return object;
        }
        finally {
            this.c.b(d10);
        }
    }

    public boolean f(ByteBuffer object, f object2) {
        boolean bl2;
        e e10 = d.c.a.o.m.h.i.b;
        boolean bl3 = (Boolean)(object2 = (Boolean)((f)object2).c(e10));
        if (!bl3 && (object = d.c.a.o.b.f(this.b, object)) == (object2 = ImageHeaderParser$ImageType.GIF)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

