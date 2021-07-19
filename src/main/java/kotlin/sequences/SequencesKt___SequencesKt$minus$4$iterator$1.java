/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import java.util.HashSet;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesKt$minus$4$iterator$1
extends Lambda
implements l {
    public final /* synthetic */ HashSet $other;

    public SequencesKt___SequencesKt$minus$4$iterator$1(HashSet hashSet) {
        this.$other = hashSet;
        super(1);
    }

    public final boolean invoke(Object object) {
        return this.$other.contains(object);
    }
}

