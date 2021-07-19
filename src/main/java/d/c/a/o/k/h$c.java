/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.k.h;

public class h$c
extends h {
    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public boolean c(DataSource dataSource) {
        boolean bl2;
        DataSource dataSource2 = DataSource.DATA_DISK_CACHE;
        if (dataSource != dataSource2 && dataSource != (dataSource2 = DataSource.MEMORY_CACHE)) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource = null;
        }
        return bl2;
    }

    public boolean d(boolean bl2, DataSource dataSource, EncodeStrategy encodeStrategy) {
        return false;
    }
}

