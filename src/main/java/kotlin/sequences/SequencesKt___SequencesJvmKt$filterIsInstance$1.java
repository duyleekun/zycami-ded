/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import kotlin.jvm.internal.Lambda;

public final class SequencesKt___SequencesJvmKt$filterIsInstance$1
extends Lambda
implements l {
    public final /* synthetic */ Class $klass;

    public SequencesKt___SequencesJvmKt$filterIsInstance$1(Class clazz) {
        this.$klass = clazz;
        super(1);
    }

    public final boolean invoke(Object object) {
        return this.$klass.isInstance(object);
    }
}

