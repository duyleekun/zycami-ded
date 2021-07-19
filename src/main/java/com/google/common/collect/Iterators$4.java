/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class Iterators$4
extends UnmodifiableIterator {
    public final /* synthetic */ Iterator val$iterator;
    public final /* synthetic */ boolean val$pad;
    public final /* synthetic */ int val$size;

    public Iterators$4(Iterator iterator2, int n10, boolean bl2) {
        this.val$iterator = iterator2;
        this.val$size = n10;
        this.val$pad = bl2;
    }

    public boolean hasNext() {
        return this.val$iterator.hasNext();
    }

    public List next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            Iterator iterator2;
            int n12;
            int n13;
            n10 = this.val$size;
            Object object = new Object[n10];
            for (n13 = 0; n13 < (n12 = this.val$size) && (n12 = (int)((iterator2 = this.val$iterator).hasNext() ? 1 : 0)) != 0; ++n13) {
                iterator2 = this.val$iterator.next();
                object[n13] = iterator2;
            }
            for (n12 = n13; n12 < (n11 = this.val$size); ++n12) {
                n11 = 0;
                object[n12] = null;
            }
            object = Collections.unmodifiableList(Arrays.asList(object));
            n12 = (int)(this.val$pad ? 1 : 0);
            if (n12 == 0 && n13 != (n12 = this.val$size)) {
                object = object.subList(0, n13);
            }
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

