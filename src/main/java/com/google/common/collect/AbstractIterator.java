/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator$1;
import com.google.common.collect.AbstractIterator$State;
import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

public abstract class AbstractIterator
extends UnmodifiableIterator {
    private Object next;
    private AbstractIterator$State state;

    public AbstractIterator() {
        AbstractIterator$State abstractIterator$State;
        this.state = abstractIterator$State = AbstractIterator$State.NOT_READY;
    }

    private boolean tryToComputeNext() {
        Object object;
        this.state = object = AbstractIterator$State.FAILED;
        object = this.computeNext();
        this.next = object;
        object = this.state;
        AbstractIterator$State abstractIterator$State = AbstractIterator$State.DONE;
        if (object != abstractIterator$State) {
            this.state = object = AbstractIterator$State.READY;
            return true;
        }
        return false;
    }

    public abstract Object computeNext();

    public final Object endOfData() {
        AbstractIterator$State abstractIterator$State;
        this.state = abstractIterator$State = AbstractIterator$State.DONE;
        return null;
    }

    public final boolean hasNext() {
        int n10;
        Object object = this.state;
        AbstractIterator$State abstractIterator$State = AbstractIterator$State.FAILED;
        int n11 = 1;
        if (object != abstractIterator$State) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        Preconditions.checkState(n10 != 0);
        object = AbstractIterator$1.$SwitchMap$com$google$common$collect$AbstractIterator$State;
        abstractIterator$State = this.state;
        int n12 = abstractIterator$State.ordinal();
        n10 = object[n12];
        if (n10 != n11) {
            n12 = 2;
            if (n10 != n12) {
                return this.tryToComputeNext();
            }
            return n11;
        }
        return false;
    }

    public final Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object;
            this.state = object = AbstractIterator$State.NOT_READY;
            object = this.next;
            this.next = null;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final Object peek() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            return this.next;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

