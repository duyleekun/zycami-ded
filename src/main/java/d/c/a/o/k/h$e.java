/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;
import d.c.a.o.k.h;

public class h$e
extends h {
    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public boolean c(DataSource dataSource) {
        boolean bl2;
        DataSource dataSource2 = DataSource.REMOTE;
        if (dataSource == dataSource2) {
            bl2 = true;
        } else {
            bl2 = false;
            dataSource = null;
        }
        return bl2;
    }

    public boolean d(boolean bl2, DataSource dataSource, EncodeStrategy encodeStrategy) {
        Enum enum_;
        if ((bl2 && dataSource == (enum_ = DataSource.DATA_DISK_CACHE) || dataSource == (enum_ = DataSource.LOCAL)) && encodeStrategy == (enum_ = EncodeStrategy.TRANSFORMED)) {
            bl2 = true;
        } else {
            bl2 = false;
            enum_ = null;
        }
        return bl2;
    }
}

