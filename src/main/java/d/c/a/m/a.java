/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 */
package d.c.a.m;

import android.graphics.Bitmap;
import d.c.a.m.c;
import java.io.InputStream;
import java.nio.ByteBuffer;

public interface a {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 3;
    public static final int e;

    public Bitmap a();

    public void b();

    public int c();

    public void clear();

    public void d(Bitmap.Config var1);

    public int e(int var1);

    public int f();

    public int g();

    public ByteBuffer getData();

    public int getHeight();

    public int getStatus();

    public int getWidth();

    public void h(c var1, byte[] var2);

    public int i();

    public void j();

    public void k(c var1, ByteBuffer var2);

    public int l();

    public void m(c var1, ByteBuffer var2, int var3);

    public int n();

    public int o();

    public int read(InputStream var1, int var2);

    public int read(byte[] var1);
}

