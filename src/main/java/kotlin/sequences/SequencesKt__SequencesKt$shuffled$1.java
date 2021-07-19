/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.b2.c;
import f.b2.j.b;
import f.h2.s.p;
import f.h2.t.f0;
import f.k2.e;
import f.n2.m;
import f.n2.o;
import f.o0;
import f.q1;
import f.x1.y;
import java.util.List;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;

public final class SequencesKt__SequencesKt$shuffled$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ e $random;
    public final /* synthetic */ m $this_shuffled;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SequencesKt__SequencesKt$shuffled$1(m m10, e e10, c c10) {
        this.$this_shuffled = m10;
        this.$random = e10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_shuffled;
        e e10 = this.$random;
        SequencesKt__SequencesKt$shuffled$1 sequencesKt__SequencesKt$shuffled$1 = new SequencesKt__SequencesKt$shuffled$1(m10, e10, c10);
        sequencesKt__SequencesKt$shuffled$1.p$ = object = (o)object;
        return sequencesKt__SequencesKt$shuffled$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt__SequencesKt$shuffled$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt__SequencesKt$shuffled$1)object).invokeSuspend(object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object invokeSuspend(Object object) {
        Object object2;
        Object object3;
        Object object4;
        List list;
        Object object5 = b.h();
        int n10 = this.label;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw object;
            }
            list = (List)this.L$1;
            object4 = (o)this.L$0;
            o0.n(object);
        } else {
            o0.n(object);
            object = this.p$;
            list = SequencesKt___SequencesKt.W2(this.$this_shuffled);
            object4 = object;
        }
        object = this;
        do {
            int n12;
            if ((n12 = list.isEmpty() ^ n11) == 0) {
                return q1.a;
            }
            object3 = ((SequencesKt__SequencesKt$shuffled$1)object).$random;
            int n13 = list.size();
            n12 = ((e)object3).m(n13);
            Object object6 = y.N0(list);
            int n14 = list.size();
            object2 = n12 < n14 ? list.set(n12, object6) : object6;
            ((SequencesKt__SequencesKt$shuffled$1)object).L$0 = object4;
            ((SequencesKt__SequencesKt$shuffled$1)object).L$1 = list;
            ((SequencesKt__SequencesKt$shuffled$1)object).I$0 = n12;
            ((SequencesKt__SequencesKt$shuffled$1)object).L$2 = object6;
            ((SequencesKt__SequencesKt$shuffled$1)object).L$3 = object2;
            ((SequencesKt__SequencesKt$shuffled$1)object).label = n11;
        } while ((object3 = ((o)object4).b(object2, (c)object)) != object5);
        return object5;
    }
}

