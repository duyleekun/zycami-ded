/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.sequences.SequencesKt___SequencesKt$minus$1;

public final class SequencesKt___SequencesKt$minus$1$iterator$1
extends Lambda
implements l {
    public final /* synthetic */ Ref$BooleanRef $removed;
    public final /* synthetic */ SequencesKt___SequencesKt$minus$1 this$0;

    public SequencesKt___SequencesKt$minus$1$iterator$1(SequencesKt___SequencesKt$minus$1 sequencesKt___SequencesKt$minus$1, Ref$BooleanRef ref$BooleanRef) {
        this.this$0 = sequencesKt___SequencesKt$minus$1;
        this.$removed = ref$BooleanRef;
        super(1);
    }

    public final boolean invoke(Object object) {
        boolean bl2;
        Object object2 = this.$removed;
        boolean bl3 = ((Ref$BooleanRef)object2).element;
        boolean bl4 = true;
        if (!bl3 && (bl2 = f0.g(object, object2 = this.this$0.b))) {
            object = this.$removed;
            ((Ref$BooleanRef)object).element = bl4;
            bl4 = false;
        }
        return bl4;
    }
}

