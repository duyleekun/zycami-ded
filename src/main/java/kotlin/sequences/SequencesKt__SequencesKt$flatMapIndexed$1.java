/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.b2.c;
import f.b2.j.b;
import f.b2.k.a.a;
import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.n2.m;
import f.n2.o;
import f.o0;
import f.q1;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

public final class SequencesKt__SequencesKt$flatMapIndexed$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ l $iterator;
    public final /* synthetic */ m $source;
    public final /* synthetic */ p $transform;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SequencesKt__SequencesKt$flatMapIndexed$1(m m10, p p10, l l10, c c10) {
        this.$source = m10;
        this.$transform = p10;
        this.$iterator = l10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$source;
        p p10 = this.$transform;
        l l10 = this.$iterator;
        SequencesKt__SequencesKt$flatMapIndexed$1 sequencesKt__SequencesKt$flatMapIndexed$1 = new SequencesKt__SequencesKt$flatMapIndexed$1(m10, p10, l10, c10);
        sequencesKt__SequencesKt$flatMapIndexed$1.p$ = object = (o)object;
        return sequencesKt__SequencesKt$flatMapIndexed$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt__SequencesKt$flatMapIndexed$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt__SequencesKt$flatMapIndexed$1)object).invokeSuspend(object2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object invokeSuspend(Object object) {
        Object object2;
        int n10;
        Object object3;
        Iterator iterator2;
        Object object4 = b.h();
        int n11 = this.label;
        int n12 = 1;
        if (n11 != 0) {
            if (n11 != n12) {
                object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw object;
            }
            iterator2 = (Iterator)this.L$2;
            int n13 = this.I$0;
            object3 = (o)this.L$0;
            o0.n(object);
            n10 = n13;
        } else {
            o0.n(object);
            object = this.p$;
            n11 = 0;
            object2 = this.$source.iterator();
            object3 = object;
            n10 = 0;
            object = null;
            iterator2 = object2;
        }
        object2 = this;
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object5 = ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).$transform;
            int n14 = n10 + 1;
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object = a.f(n10);
            object = object5.invoke(object, e10);
            object5 = (Iterator)((SequencesKt__SequencesKt$flatMapIndexed$1)object2).$iterator.invoke(object);
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).L$0 = object3;
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).I$0 = n14;
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).L$1 = e10;
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).L$2 = iterator2;
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).L$3 = object;
            ((SequencesKt__SequencesKt$flatMapIndexed$1)object2).label = n12;
            object = ((o)object3).e((Iterator)object5, (c)object2);
            if (object == object4) {
                return object4;
            }
            n10 = n14;
        }
        return q1.a;
    }
}

