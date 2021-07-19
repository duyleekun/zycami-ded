/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.k.h;

public class h$d
extends h {
    public boolean a() {
        return false;
    }

    public boolean b() {
        return true;
    }

    public boolean c(DataSource dataSource) {
        return false;
    }

    public boolean d(boolean bl2, DataSource dataSource, EncodeStrategy encodeStrategy) {
        DataSource dataSource2 = DataSource.RESOURCE_DISK_CACHE;
        if (dataSource != dataSource2 && dataSource != (dataSource2 = DataSource.MEMORY_CACHE)) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource2 = null;
        }
        return bl2;
    }
}

