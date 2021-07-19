/*
 * Decompiled with CFR 0.151.
 */
package d.v.j0;

import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Assertions;
import d.v.j0.a;

public final class a$a {
    private DefaultAllocator a;
    private int b = 15000;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private boolean j;
    private boolean k;

    public a$a() {
        int n10;
        this.c = n10 = 50000;
        this.d = n10;
        this.e = 2500;
        this.f = 5000;
        this.g = -1;
        this.h = true;
        this.i = 0;
        this.j = false;
    }

    public a a() {
        boolean bl2 = this.k;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^= bl3);
        this.k = bl3;
        Object object = this.a;
        if (object == null) {
            int n10 = 65536;
            this.a = object = new DefaultAllocator(bl3, n10);
        }
        DefaultAllocator defaultAllocator = this.a;
        int n11 = this.b;
        int n12 = this.c;
        int n13 = this.d;
        int n14 = this.e;
        int n15 = this.f;
        int n16 = this.g;
        boolean bl4 = this.h;
        int n17 = this.i;
        boolean bl5 = this.j;
        object = new a(defaultAllocator, n11, n12, n13, n14, n15, n16, bl4, n17, bl5);
        return object;
    }

    public a$a b(DefaultAllocator defaultAllocator) {
        Assertions.checkState(this.k ^ true);
        this.a = defaultAllocator;
        return this;
    }

    public a$a c(int n10, boolean bl2) {
        Assertions.checkState(this.k ^ true);
        d.v.j0.a.a(n10, 0, "backBufferDurationMs", "0");
        this.i = n10;
        this.j = bl2;
        return this;
    }

    public a$a d(int n10, int n11, int n12, int n13) {
        Assertions.checkState(this.k ^ true);
        String string2 = "bufferForPlaybackMs";
        String string3 = "0";
        d.v.j0.a.a(n12, 0, string2, string3);
        String string4 = "bufferForPlaybackAfterRebufferMs";
        d.v.j0.a.a(n13, 0, string4, string3);
        String string5 = "minBufferMs";
        d.v.j0.a.a(n10, n12, string5, string2);
        d.v.j0.a.a(n10, n13, string5, string4);
        d.v.j0.a.a(n11, n10, "maxBufferMs", string5);
        this.b = n10;
        this.c = n10;
        this.d = n11;
        this.e = n12;
        this.f = n13;
        return this;
    }

    public a$a e(boolean bl2) {
        Assertions.checkState(this.k ^ true);
        this.h = bl2;
        return this;
    }

    public a$a f(int n10) {
        Assertions.checkState(this.k ^ true);
        this.g = n10;
        return this;
    }
}

