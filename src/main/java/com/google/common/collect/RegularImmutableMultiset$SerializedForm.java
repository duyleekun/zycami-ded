/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.io.Serializable;

public class RegularImmutableMultiset$SerializedForm
implements Serializable {
    private static final long serialVersionUID;
    public final int[] counts;
    public final Object[] elements;

    public RegularImmutableMultiset$SerializedForm(Multiset object) {
        int n10;
        int n11 = object.entrySet().size();
        Object object2 = new Object[n11];
        this.elements = object2;
        int[] nArray = new int[n11];
        this.counts = nArray;
        object = object.entrySet().iterator();
        n11 = 0;
        nArray = null;
        while ((n10 = object.hasNext()) != 0) {
            Object object3;
            object2 = (Multiset$Entry)object.next();
            Object[] objectArray = this.elements;
            objectArray[n11] = object3 = object2.getElement();
            objectArray = this.counts;
            n10 = object2.getCount();
            objectArray[n11] = n10;
            ++n11;
        }
    }

    public Object readResolve() {
        Object object;
        int n10;
        int n11 = this.elements.length;
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder(n11);
        for (n11 = 0; n11 < (n10 = ((Object[])(object = this.elements)).length); ++n11) {
            object = object[n11];
            int[] nArray = this.counts;
            n10 = nArray[n11];
            immutableMultiset$Builder.addCopies(object, n10);
        }
        return immutableMultiset$Builder.build();
    }
}

