/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps$EntryTransformer;

public final class Maps$9
implements Maps$EntryTransformer {
    public final /* synthetic */ Function val$function;

    public Maps$9(Function function) {
        this.val$function = function;
    }

    public Object transformEntry(Object object, Object object2) {
        return this.val$function.apply(object2);
    }
}

