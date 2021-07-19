/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.b2.c;
import f.b2.j.b;
import f.b2.k.a.a;
import f.h2.s.p;
import f.h2.s.q;
import f.h2.t.f0;
import f.n2.m;
import f.n2.o;
import f.o0;
import f.q1;
import java.util.Iterator;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;

public final class SequencesKt___SequencesKt$runningFoldIndexed$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ q $operation;
    public final /* synthetic */ m $this_runningFoldIndexed;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SequencesKt___SequencesKt$runningFoldIndexed$1(m m10, Object object, q q10, c c10) {
        this.$this_runningFoldIndexed = m10;
        this.$initial = object;
        this.$operation = q10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_runningFoldIndexed;
        Object object2 = this.$initial;
        q q10 = this.$operation;
        SequencesKt___SequencesKt$runningFoldIndexed$1 sequencesKt___SequencesKt$runningFoldIndexed$1 = new SequencesKt___SequencesKt$runningFoldIndexed$1(m10, object2, q10, c10);
        sequencesKt___SequencesKt$runningFoldIndexed$1.p$ = object = (o)object;
        return sequencesKt___SequencesKt$runningFoldIndexed$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt___SequencesKt$runningFoldIndexed$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt___SequencesKt$runningFoldIndexed$1)object).invokeSuspend(object2);
    }

    public final Object invokeSuspend(Object object) {
        boolean bl2;
        Object object2;
        int n10;
        Object object3;
        Object object4;
        Object object5;
        int n11;
        Object object6;
        block7: {
            block8: {
                int n12;
                block4: {
                    block5: {
                        block6: {
                            object6 = b.h();
                            int n13 = this.label;
                            n11 = 2;
                            n12 = 1;
                            if (n13 == 0) break block4;
                            if (n13 == n12) break block5;
                            if (n13 != n11) break block6;
                            object5 = (Iterator)this.L$3;
                            object4 = this.L$1;
                            int n14 = this.I$0;
                            object3 = (o)this.L$0;
                            o0.n(object);
                            n10 = n14;
                            break block7;
                        }
                        object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw object;
                    }
                    object5 = (o)this.L$0;
                    o0.n(object);
                    break block8;
                }
                o0.n(object);
                object5 = this.p$;
                object = this.$initial;
                this.L$0 = object5;
                this.label = n12;
                object = ((o)object5).b(object, this);
                if (object == object6) {
                    return object6;
                }
            }
            n10 = 0;
            object = null;
            object4 = this.$initial;
            object2 = this.$this_runningFoldIndexed.iterator();
            object3 = object5;
            object5 = object2;
        }
        object2 = this;
        while (bl2 = object5.hasNext()) {
            Object e10 = object5.next();
            q q10 = ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).$operation;
            int n15 = n10 + 1;
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object = a.f(n10);
            object4 = q10.invoke(object, object4, e10);
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).L$0 = object3;
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).I$0 = n15;
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).L$1 = object4;
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).L$2 = e10;
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).L$3 = object5;
            ((SequencesKt___SequencesKt$runningFoldIndexed$1)object2).label = n11;
            object = ((o)object3).b(object4, (c)object2);
            if (object == object6) {
                return object6;
            }
            n10 = n15;
        }
        return q1.a;
    }
}

