/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;
import java.io.Serializable;

public class Funnels$SequentialFunnel
implements Funnel,
Serializable {
    private final Funnel elementFunnel;

    public Funnels$SequentialFunnel(Funnel funnel) {
        this.elementFunnel = funnel = (Funnel)Preconditions.checkNotNull(funnel);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Funnels$SequentialFunnel;
        if (bl2) {
            object = (Funnels$SequentialFunnel)object;
            Funnel funnel = this.elementFunnel;
            object = ((Funnels$SequentialFunnel)object).elementFunnel;
            return funnel.equals(object);
        }
        return false;
    }

    public void funnel(Iterable object, PrimitiveSink primitiveSink) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            Funnel funnel = this.elementFunnel;
            funnel.funnel(e10, primitiveSink);
        }
    }

    public int hashCode() {
        int n10 = Funnels$SequentialFunnel.class.hashCode();
        int n11 = this.elementFunnel.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Funnels.sequentialFunnel(");
        Funnel funnel = this.elementFunnel;
        stringBuilder.append(funnel);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

