/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.net;

import com.google.common.base.CharMatcher;
import com.google.common.base.Function;
import com.google.common.net.MediaType;

public class MediaType$2
implements Function {
    public final /* synthetic */ MediaType this$0;

    public MediaType$2(MediaType mediaType) {
        this.this$0 = mediaType;
    }

    public String apply(String string2) {
        CharMatcher charMatcher = MediaType.access$000();
        boolean bl2 = charMatcher.matchesAllOf(string2);
        if (!bl2 || (bl2 = string2.isEmpty())) {
            string2 = MediaType.access$100(string2);
        }
        return string2;
    }
}

