/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package d.c.a.n.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpImage;
import com.bumptech.glide.integration.webp.decoder.WebpFrameCacheStrategy;
import d.c.a.c;
import d.c.a.n.a.d.h;
import d.c.a.n.a.d.i;
import d.c.a.n.a.d.k;
import d.c.a.n.a.d.m;
import d.c.a.n.a.d.o;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.o.k.x.e;
import java.nio.ByteBuffer;

public class d
implements g {
    public static final d.c.a.o.e d;
    private final Context a;
    private final e b;
    private final d.c.a.o.m.h.b c;

    static {
        Boolean bl2 = Boolean.FALSE;
        d = d.c.a.o.e.g("com.bumptech.glide.integration.webp.decoder.ByteBufferWebpDecoder.DisableAnimation", bl2);
    }

    public d(Context context) {
        b b10 = d.c.a.c.d(context).f();
        e e10 = d.c.a.c.d(context).g();
        this(context, b10, e10);
    }

    public d(Context object, b b10, e e10) {
        this.a = object = object.getApplicationContext();
        this.b = e10;
        super(e10, b10);
        this.c = object;
    }

    public s c(ByteBuffer byteBuffer, int n10, int n11, f f10) {
        int n12 = byteBuffer.remaining();
        Object object = new byte[n12];
        byteBuffer.get((byte[])object, 0, n12);
        WebpImage webpImage = WebpImage.create(object);
        n12 = webpImage.getWidth();
        int n13 = webpImage.getHeight();
        int n14 = h.a(n12, n13, n10, n11);
        Object object2 = o.q;
        object = f10;
        Object object3 = object2 = f10.c((d.c.a.o.e)object2);
        object3 = (WebpFrameCacheStrategy)object2;
        d.c.a.o.m.h.b b10 = this.c;
        Object object4 = object2;
        object2 = new i(b10, webpImage, byteBuffer, n14, (WebpFrameCacheStrategy)object3);
        ((i)object2).b();
        Bitmap bitmap = ((i)object2).a();
        if (bitmap == null) {
            return null;
        }
        d.c.a.o.m.c c10 = d.c.a.o.m.c.c();
        object = new m;
        Context context = this.a;
        e e10 = this.b;
        object3 = object2;
        object4 = new k(context, (i)object2, e10, c10, n10, n11, bitmap);
        object((k)object4);
        return object;
    }

    public boolean d(ByteBuffer byteBuffer, f object) {
        d.c.a.o.e e10 = d;
        boolean bl2 = (Boolean)(object = (Boolean)((f)object).c(e10));
        if (bl2) {
            return false;
        }
        return WebpHeaderParser.f(WebpHeaderParser.c(byteBuffer));
    }
}

