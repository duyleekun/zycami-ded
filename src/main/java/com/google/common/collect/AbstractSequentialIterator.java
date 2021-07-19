/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

public abstract class AbstractSequentialIterator
extends UnmodifiableIterator {
    private Object nextOrNull;

    public AbstractSequentialIterator(Object object) {
        this.nextOrNull = object;
    }

    public abstract Object computeNext(Object var1);

    public final boolean hasNext() {
        boolean bl2;
        Object object = this.nextOrNull;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public final Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            try {
                Object object;
                Object object2 = this.nextOrNull;
                this.nextOrNull = object = this.computeNext(object2);
                return object2;
            }
            catch (Throwable throwable) {
                Object object = this.nextOrNull;
                this.nextOrNull = object = this.computeNext(object);
                throw throwable;
            }
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

