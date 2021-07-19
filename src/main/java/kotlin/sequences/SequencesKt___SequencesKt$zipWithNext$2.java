/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.b2.c;
import f.b2.j.b;
import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.n2.o;
import f.o0;
import f.q1;
import java.util.Iterator;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

public final class SequencesKt___SequencesKt$zipWithNext$2
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ m $this_zipWithNext;
    public final /* synthetic */ p $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SequencesKt___SequencesKt$zipWithNext$2(m m10, p p10, c c10) {
        this.$this_zipWithNext = m10;
        this.$transform = p10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_zipWithNext;
        p p10 = this.$transform;
        SequencesKt___SequencesKt$zipWithNext$2 sequencesKt___SequencesKt$zipWithNext$2 = new SequencesKt___SequencesKt$zipWithNext$2(m10, p10, c10);
        sequencesKt___SequencesKt$zipWithNext$2.p$ = object = (o)object;
        return sequencesKt___SequencesKt$zipWithNext$2;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt___SequencesKt$zipWithNext$2)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt___SequencesKt$zipWithNext$2)object).invokeSuspend(object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object invokeSuspend(Object object) {
        Object object2;
        Object object3;
        Object object4;
        Object object5 = b.h();
        int n10 = this.label;
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw object;
            }
            object4 = this.L$3;
            object3 = (Iterator)this.L$1;
            object2 = (o)this.L$0;
            o0.n(object);
            object = object4;
        } else {
            o0.n(object);
            object = this.p$;
            object4 = this.$this_zipWithNext.iterator();
            boolean bl2 = object4.hasNext();
            if (!bl2) {
                return q1.a;
            }
            object3 = object4.next();
            object2 = object;
            object = object3;
            object3 = object4;
        }
        object4 = this;
        boolean bl3;
        while (bl3 = object3.hasNext()) {
            Object e10 = object3.next();
            Object object6 = ((SequencesKt___SequencesKt$zipWithNext$2)object4).$transform.invoke(object, e10);
            ((SequencesKt___SequencesKt$zipWithNext$2)object4).L$0 = object2;
            ((SequencesKt___SequencesKt$zipWithNext$2)object4).L$1 = object3;
            ((SequencesKt___SequencesKt$zipWithNext$2)object4).L$2 = object;
            ((SequencesKt___SequencesKt$zipWithNext$2)object4).L$3 = e10;
            ((SequencesKt___SequencesKt$zipWithNext$2)object4).label = n11;
            object = ((o)object2).b(object6, (c)object4);
            if (object == object5) {
                return object5;
            }
            object = e10;
        }
        return q1.a;
    }
}

