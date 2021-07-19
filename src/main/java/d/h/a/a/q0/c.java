/*
 * Decompiled with CFR 0.151.
 */
package d.h.a.a.q0;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DummyDataSource;

public final class c
implements DataSource$Factory {
    public static final /* synthetic */ c a;

    static {
        c c10;
        a = c10 = new c();
    }

    public final DataSource createDataSource() {
        return DummyDataSource.b();
    }
}

