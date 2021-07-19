/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFromArray$BaseArraySubscription;

public final class FlowableFromArray$ArraySubscription
extends FlowableFromArray$BaseArraySubscription {
    private static final long serialVersionUID = 2587302975077663557L;
    public final d downstream;

    public FlowableFromArray$ArraySubscription(d d10, Object[] objectArray) {
        super(objectArray);
        this.downstream = d10;
    }

    public void fastPath() {
        Object object = this.array;
        int n10 = ((Object[])object).length;
        d d10 = this.downstream;
        for (int i10 = this.index; i10 != n10; ++i10) {
            boolean bl2 = this.cancelled;
            if (bl2) {
                return;
            }
            Object object2 = object[i10];
            if (object2 == null) {
                CharSequence charSequence = new StringBuilder();
                charSequence.append("The element at index ");
                charSequence.append(i10);
                charSequence.append(" is null");
                charSequence = charSequence.toString();
                object = new NullPointerException((String)charSequence);
                d10.onError((Throwable)object);
                return;
            }
            d10.onNext(object2);
        }
        boolean bl3 = this.cancelled;
        if (bl3) {
            return;
        }
        d10.onComplete();
    }

    public void slowPath(long l10) {
        long l11;
        long l12;
        Object[] objectArray = this.array;
        int n10 = objectArray.length;
        int n11 = this.index;
        d d10 = this.downstream;
        long l13 = 0L;
        do {
            long l14 = l13;
            while (true) {
                Object object;
                if ((object = l14 == l10 ? 0 : (l14 < l10 ? -1 : 1)) != false && n11 != n10) {
                    object = this.cancelled;
                    if (object != false) {
                        return;
                    }
                    Object object2 = objectArray[n11];
                    if (object2 == null) {
                        CharSequence charSequence = new StringBuilder();
                        charSequence.append("The element at index ");
                        charSequence.append(n11);
                        charSequence.append(" is null");
                        charSequence = charSequence.toString();
                        NullPointerException nullPointerException = new NullPointerException((String)charSequence);
                        d10.onError(nullPointerException);
                        return;
                    }
                    d10.onNext(object2);
                    long l15 = 1L;
                    l14 += l15;
                    ++n11;
                    continue;
                }
                if (n11 == n10) {
                    boolean bl2 = this.cancelled;
                    if (!bl2) {
                        d10.onComplete();
                    }
                    return;
                }
                l10 = this.get();
                long l16 = l14 - l10;
                object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object == false) break;
            }
            this.index = n11;
            l10 = -l14;
        } while ((l12 = (l11 = (l10 = this.addAndGet(l10)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) != false);
    }
}

