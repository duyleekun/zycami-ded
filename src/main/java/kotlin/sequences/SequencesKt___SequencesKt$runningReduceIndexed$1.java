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

public final class SequencesKt___SequencesKt$runningReduceIndexed$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ q $operation;
    public final /* synthetic */ m $this_runningReduceIndexed;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private o p$;

    public SequencesKt___SequencesKt$runningReduceIndexed$1(m m10, q q10, c c10) {
        this.$this_runningReduceIndexed = m10;
        this.$operation = q10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_runningReduceIndexed;
        q q10 = this.$operation;
        SequencesKt___SequencesKt$runningReduceIndexed$1 sequencesKt___SequencesKt$runningReduceIndexed$1 = new SequencesKt___SequencesKt$runningReduceIndexed$1(m10, q10, c10);
        sequencesKt___SequencesKt$runningReduceIndexed$1.p$ = object = (o)object;
        return sequencesKt___SequencesKt$runningReduceIndexed$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt___SequencesKt$runningReduceIndexed$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).invokeSuspend(object2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        boolean bl2;
        Object object2;
        o o10;
        Iterator iterator2;
        Object object3;
        int n10;
        int n11;
        Object object4;
        block7: {
            block8: {
                block4: {
                    block5: {
                        block6: {
                            object4 = b.h();
                            int n12 = this.label;
                            n11 = 2;
                            n10 = 1;
                            if (n12 == 0) break block4;
                            if (n12 == n10) break block5;
                            if (n12 != n11) break block6;
                            n12 = this.I$0;
                            object3 = this.L$2;
                            iterator2 = (Iterator)this.L$1;
                            o10 = (o)this.L$0;
                            o0.n(object);
                            object = this;
                            n10 = n12;
                            object2 = object3;
                            break block7;
                        }
                        object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw object;
                    }
                    object2 = this.L$2;
                    iterator2 = (Iterator)this.L$1;
                    o10 = (o)this.L$0;
                    o0.n(object);
                    break block8;
                }
                o0.n(object);
                o10 = this.p$;
                object = this.$this_runningReduceIndexed;
                iterator2 = object.iterator();
                boolean bl3 = iterator2.hasNext();
                if (!bl3) return q1.a;
                object2 = iterator2.next();
                this.L$0 = o10;
                this.L$1 = iterator2;
                this.L$2 = object2;
                this.label = n10;
                object = o10.b(object2, this);
                if (object == object4) {
                    return object4;
                }
            }
            object = this;
        }
        while (bl2 = iterator2.hasNext()) {
            q q10 = ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).$operation;
            int n13 = n10 + 1;
            if (n10 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            object3 = a.f(n10);
            Object e10 = iterator2.next();
            object3 = q10.invoke(object3, object2, e10);
            ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).L$0 = o10;
            ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).L$1 = iterator2;
            ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).L$2 = object3;
            ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).I$0 = n13;
            ((SequencesKt___SequencesKt$runningReduceIndexed$1)object).label = n11;
            object2 = o10.b(object3, (c)object);
            if (object2 == object4) {
                return object4;
            }
            object2 = object3;
            n10 = n13;
        }
        return q1.a;
    }
}

