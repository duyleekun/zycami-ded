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

public final class SequencesKt___SequencesKt$runningReduce$1
extends RestrictedSuspendLambda
implements p {
    public final /* synthetic */ p $operation;
    public final /* synthetic */ m $this_runningReduce;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private o p$;

    public SequencesKt___SequencesKt$runningReduce$1(m m10, p p10, c c10) {
        this.$this_runningReduce = m10;
        this.$operation = p10;
        super(2, c10);
    }

    public final c create(Object object, c c10) {
        f0.p(c10, "completion");
        m m10 = this.$this_runningReduce;
        p p10 = this.$operation;
        SequencesKt___SequencesKt$runningReduce$1 sequencesKt___SequencesKt$runningReduce$1 = new SequencesKt___SequencesKt$runningReduce$1(m10, p10, c10);
        sequencesKt___SequencesKt$runningReduce$1.p$ = object = (o)object;
        return sequencesKt___SequencesKt$runningReduce$1;
    }

    public final Object invoke(Object object, Object object2) {
        object2 = (c)object2;
        object = (SequencesKt___SequencesKt$runningReduce$1)this.create(object, (c)object2);
        object2 = q1.a;
        return ((SequencesKt___SequencesKt$runningReduce$1)object).invokeSuspend(object2);
    }

    public final Object invokeSuspend(Object object) {
        block8: {
            boolean bl2;
            o o10;
            Object object2;
            Object object3;
            int n10;
            Object object4;
            block7: {
                int n11;
                int n12;
                block5: {
                    block6: {
                        object4 = b.h();
                        n12 = this.label;
                        n10 = 2;
                        n11 = 1;
                        if (n12 == 0) break block5;
                        if (n12 != n11 && n12 != n10) break block6;
                        object3 = this.L$2;
                        object2 = (Iterator)this.L$1;
                        o10 = (o)this.L$0;
                        o0.n(object);
                        break block7;
                    }
                    object = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw object;
                }
                o0.n(object);
                o10 = this.p$;
                object = this.$this_runningReduce.iterator();
                n12 = (int)(object.hasNext() ? 1 : 0);
                if (n12 == 0) break block8;
                object3 = object.next();
                this.L$0 = o10;
                this.L$1 = object;
                this.L$2 = object3;
                this.label = n11;
                object2 = o10.b(object3, this);
                if (object2 == object4) {
                    return object4;
                }
                object2 = object;
            }
            object = this;
            while (bl2 = object2.hasNext()) {
                Object object5 = ((SequencesKt___SequencesKt$runningReduce$1)object).$operation;
                Object e10 = object2.next();
                object3 = object5.invoke(object3, e10);
                ((SequencesKt___SequencesKt$runningReduce$1)object).L$0 = o10;
                ((SequencesKt___SequencesKt$runningReduce$1)object).L$1 = object2;
                ((SequencesKt___SequencesKt$runningReduce$1)object).L$2 = object3;
                ((SequencesKt___SequencesKt$runningReduce$1)object).label = n10;
                object5 = o10.b(object3, (c)object);
                if (object5 != object4) continue;
                return object4;
            }
        }
        return q1.a;
    }
}

