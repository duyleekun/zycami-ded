/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Log
 */
package d.m.a.e;

import android.graphics.Bitmap;
import android.util.Log;
import d.m.a.e.a;
import d.m.a.e.a$a;
import d.m.a.e.c;
import d.m.a.e.d;
import d.m.a.e.e$a;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class e {
    public static final int e = 0;
    public static final int f = 1;
    public static final int g = 2;
    private final String a;
    private d b;
    private c c;
    private a d;

    public e() {
        this.a = "NvsGifDecoder";
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int n10 = 1024;
        byte[] byArray = new byte[n10];
        try {
            int n12;
            int n11;
            while ((n11 = inputStream.read(byArray)) != (n12 = -1)) {
                n12 = 0;
                byteArrayOutputStream.write(byArray, 0, n11);
            }
            return byteArrayOutputStream.toByteArray();
        }
        finally {
            inputStream.close();
        }
    }

    public int b(int n10) {
        a a10 = this.d;
        if (a10 == null) {
            return 0;
        }
        return a10.l(n10);
    }

    public Bitmap c() {
        boolean bl2;
        a a10 = this.d;
        if (a10 != null && (bl2 = this.g())) {
            this.d.x();
            this.d.e();
            return this.d.r();
        }
        return null;
    }

    public int d() {
        boolean bl2;
        c c10 = this.c;
        if (c10 != null && (bl2 = this.g())) {
            return this.c.c;
        }
        return 0;
    }

    public a e() {
        boolean bl2 = this.g();
        if (bl2) {
            return this.d;
        }
        return null;
    }

    public long f() {
        int n10;
        Object object = this.c;
        long l10 = 0L;
        if (object != null && (object = this.d) != null && (n10 = this.g()) != 0) {
            object = this.c;
            n10 = ((c)object).b();
            this.d.x();
            for (int i10 = 0; i10 < n10; ++i10) {
                this.d.e();
                a a10 = this.d;
                int n11 = a10.l(i10);
                long l11 = n11;
                l10 += l11;
            }
        }
        return l10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean g() {
        Object object = this.b;
        String string2 = "NvsGifDecoder";
        if (object != null) {
            boolean bl2 = ((d)object).e;
            if (bl2) {
                return true;
            }
            object = "isGif: this file is not gif!";
        } else {
            object = "isGif: headerParser is null!";
        }
        Log.e((String)string2, (String)object);
        return false;
    }

    public int h(InputStream object) {
        int n10 = 2;
        if (object == null) {
            return n10;
        }
        try {
            object = this.a((InputStream)object);
        }
        catch (Exception exception) {
            Log.e((String)"NvsGifDecoder", (String)"read: InputStream to bytes exception!");
            exception.printStackTrace();
            return n10;
        }
        Object object2 = new d();
        this.b = object2;
        ((d)object2).r((byte[])object);
        object2 = this.b;
        object2 = ((d)object2).q();
        this.c = object2;
        object2 = new e$a(this);
        a a10 = new a((a$a)object2);
        this.d = a10;
        object2 = this.c;
        a10.y((c)object2, (byte[])object);
        return 0;
    }
}

