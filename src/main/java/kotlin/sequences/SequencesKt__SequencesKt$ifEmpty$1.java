/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.b2.c;
import f.b2.j.b;
import f.h2.s.a;
import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.n2.o;
import f.o0;
import f.q1;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

public final class SequencesKt__SequencesKt$ifEmpty$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ a $defaultValue;
    public final /* synthetic */ m $this_ifEmpty;
    public Object L$0;
    public Object L$1;
    public int label;
    private o p$;

    public SequencesKt__SequencesKt$ifEmpty$1(m m10, a a10, c c10) {
        this.$this_ifEmpty = m10;
        this.$defaultValue = a10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_ifEmpty;
        a a10 = this.$defaultValue;
        SequencesKt__SequencesKt$ifEmpty$1 sequencesKt__SequencesKt$ifEmpty$1 = new SequencesKt__SequencesKt$ifEmpty$1(m10, a10, c10);
        sequencesKt__SequencesKt$ifEmpty$1.p$ = object = (o)object;
        return sequencesKt__SequencesKt$ifEmpty$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt__SequencesKt$ifEmpty$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt__SequencesKt$ifEmpty$1)object).invokeSuspend(object2);
    }

    public final Object invokeSuspend(Object object) {
        Object object2 = b.h();
        int n10 = this.label;
        int n11 = 2;
        int n12 = 1;
        if (n10 != 0) {
            if (n10 != n12 && n10 != n11) {
                object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw object;
            }
            object2 = (Iterator)this.L$1;
            object2 = (o)this.L$0;
            o0.n(object);
        } else {
            o0.n(object);
            object = this.p$;
            Iterator iterator2 = this.$this_ifEmpty.iterator();
            boolean bl2 = iterator2.hasNext();
            if (bl2) {
                this.L$0 = object;
                this.L$1 = iterator2;
                this.label = n12;
                if ((object = ((o)object).e(iterator2, this)) == object2) {
                    return object2;
                }
            } else {
                m m10 = (m)this.$defaultValue.invoke();
                this.L$0 = object;
                this.L$1 = iterator2;
                this.label = n11;
                if ((object = ((o)object).f(m10, this)) == object2) {
                    return object2;
                }
            }
        }
        return q1.a;
    }
}

