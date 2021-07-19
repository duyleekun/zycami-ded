/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.net.MediaType;
import java.util.Collection;

public class MediaType$1
implements Function {
    public final /* synthetic */ MediaType this$0;

    public MediaType$1(MediaType mediaType) {
        this.this$0 = mediaType;
    }

    public ImmutableMultiset apply(Collection collection) {
        return ImmutableMultiset.copyOf(collection);
    }
}

