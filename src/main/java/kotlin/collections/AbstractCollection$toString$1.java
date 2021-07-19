/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.l;
import kotlin.collections.AbstractCollection;
import kotlin.jvm.internal.Lambda;

public final class AbstractCollection$toString$1
extends Lambda
implements l {
    public final /* synthetic */ AbstractCollection this$0;

    public AbstractCollection$toString$1(AbstractCollection abstractCollection) {
        this.this$0 = abstractCollection;
        super(1);
    }

    public final CharSequence invoke(Object object) {
        AbstractCollection abstractCollection = this.this$0;
        object = object == abstractCollection ? "(this Collection)" : String.valueOf(object);
        return object;
    }
}

