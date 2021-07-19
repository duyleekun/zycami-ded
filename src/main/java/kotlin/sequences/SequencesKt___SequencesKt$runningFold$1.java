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

public final class SequencesKt___SequencesKt$runningFold$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ Object $initial;
    public final /* synthetic */ p $operation;
    public final /* synthetic */ m $this_runningFold;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    private o p$;

    public SequencesKt___SequencesKt$runningFold$1(m m10, Object object, p p10, c c10) {
        this.$this_runningFold = m10;
        this.$initial = object;
        this.$operation = p10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_runningFold;
        Object object2 = this.$initial;
        p p10 = this.$operation;
        SequencesKt___SequencesKt$runningFold$1 sequencesKt___SequencesKt$runningFold$1 = new SequencesKt___SequencesKt$runningFold$1(m10, object2, p10, c10);
        sequencesKt___SequencesKt$runningFold$1.p$ = object = (o)object;
        return sequencesKt___SequencesKt$runningFold$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt___SequencesKt$runningFold$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt___SequencesKt$runningFold$1)object).invokeSuspend(object2);
    }

    public final Object invokeSuspend(Object object) {
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        int n10;
        Object object5;
        block5: {
            block6: {
                int n11;
                block2: {
                    block3: {
                        block4: {
                            object5 = b.h();
                            int n12 = this.label;
                            n10 = 2;
                            n11 = 1;
                            if (n12 == 0) break block2;
                            if (n12 == n11) break block3;
                            if (n12 != n10) break block4;
                            object4 = (Iterator)this.L$3;
                            object3 = this.L$1;
                            object2 = (o)this.L$0;
                            o0.n(object);
                            object = object3;
                            break block5;
                        }
                        object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw object;
                    }
                    object4 = (o)this.L$0;
                    o0.n(object);
                    break block6;
                }
                o0.n(object);
                object4 = this.p$;
                object = this.$initial;
                this.L$0 = object4;
                this.label = n11;
                object = ((o)object4).b(object, this);
                if (object == object5) {
                    return object5;
                }
            }
            object = this.$initial;
            object3 = this.$this_runningFold.iterator();
            object2 = object4;
            object4 = object3;
        }
        object3 = this;
        while (bl2 = object4.hasNext()) {
            Object object6 = object4.next();
            p p10 = ((SequencesKt___SequencesKt$runningFold$1)object3).$operation;
            object = p10.invoke(object, object6);
            ((SequencesKt___SequencesKt$runningFold$1)object3).L$0 = object2;
            ((SequencesKt___SequencesKt$runningFold$1)object3).L$1 = object;
            ((SequencesKt___SequencesKt$runningFold$1)object3).L$2 = object6;
            ((SequencesKt___SequencesKt$runningFold$1)object3).L$3 = object4;
            ((SequencesKt___SequencesKt$runningFold$1)object3).label = n10;
            object6 = ((o)object2).b(object, (c)object3);
            if (object6 != object5) continue;
            return object5;
        }
        return q1.a;
    }
}

