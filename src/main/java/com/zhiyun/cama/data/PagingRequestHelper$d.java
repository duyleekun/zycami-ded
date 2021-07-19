/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data;

import com.zhiyun.cama.data.PagingRequestHelper;
import com.zhiyun.cama.data.PagingRequestHelper$RequestType;
import com.zhiyun.cama.data.PagingRequestHelper$Status;
import com.zhiyun.cama.data.PagingRequestHelper$c;
import com.zhiyun.cama.data.PagingRequestHelper$e;

public class PagingRequestHelper$d {
    public final PagingRequestHelper$RequestType a;
    public PagingRequestHelper$e b;
    public PagingRequestHelper$c c;
    public Throwable d;
    public PagingRequestHelper$Status e;
    public final /* synthetic */ PagingRequestHelper f;

    public PagingRequestHelper$d(PagingRequestHelper object, PagingRequestHelper$RequestType pagingRequestHelper$RequestType) {
        this.f = object;
        object = PagingRequestHelper$Status.SUCCESS;
        this.e = object;
        this.a = pagingRequestHelper$RequestType;
    }
}

