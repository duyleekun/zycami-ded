/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.l;
import f.h2.t.f0;
import java.util.Map;
import kotlin.collections.AbstractMap;
import kotlin.jvm.internal.Lambda;

public final class AbstractMap$toString$1
extends Lambda
implements l {
    public final /* synthetic */ AbstractMap this$0;

    public AbstractMap$toString$1(AbstractMap abstractMap) {
        this.this$0 = abstractMap;
        super(1);
    }

    public final CharSequence invoke(Map.Entry entry) {
        f0.p(entry, "it");
        return AbstractMap.b(this.this$0, entry);
    }
}

