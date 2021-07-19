/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DecodeJob;
import d.c.a.o.k.g$a;
import d.c.a.o.k.s;

public final class DecodeJob$c
implements g$a {
    private final DataSource a;
    public final /* synthetic */ DecodeJob b;

    public DecodeJob$c(DecodeJob decodeJob, DataSource dataSource) {
        this.b = decodeJob;
        this.a = dataSource;
    }

    public s a(s s10) {
        DecodeJob decodeJob = this.b;
        DataSource dataSource = this.a;
        return decodeJob.w(dataSource, s10);
    }
}

