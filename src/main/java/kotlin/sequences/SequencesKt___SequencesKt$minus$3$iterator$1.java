/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import java.util.Collection;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$minus$3$iterator$1
extends Lambda
implements l {
    public final /* synthetic */ Collection $other;

    public SequencesKt___SequencesKt$minus$3$iterator$1(Collection collection) {
        this.$other = collection;
        super(1);
    }

    public final boolean invoke(Object object) {
        return this.$other.contains(object);
    }
}

