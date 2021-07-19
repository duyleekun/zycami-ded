/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.l;
import f.y1.b;
import kotlin.jvm.internal.Lambda;

public final class CollectionsKt__CollectionsKt$binarySearchBy$1
extends Lambda
implements l {
    public final /* synthetic */ Comparable $key;
    public final /* synthetic */ l $selector;

    public CollectionsKt__CollectionsKt$binarySearchBy$1(l l10, Comparable comparable) {
        this.$selector = l10;
        this.$key = comparable;
        super(1);
    }

    public final int invoke(Object object) {
        object = (Comparable)this.$selector.invoke(object);
        Comparable comparable = this.$key;
        return b.g((Comparable)object, comparable);
    }
}

