/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap$Entry;
import androidx.arch.core.internal.SafeIterableMap$SupportRemove;
import java.util.Iterator;
import java.util.Map;

public abstract class SafeIterableMap$ListIterator
implements Iterator,
SafeIterableMap$SupportRemove {
    public SafeIterableMap$Entry mExpectedEnd;
    public SafeIterableMap$Entry mNext;

    public SafeIterableMap$ListIterator(SafeIterableMap$Entry safeIterableMap$Entry, SafeIterableMap$Entry safeIterableMap$Entry2) {
        this.mExpectedEnd = safeIterableMap$Entry2;
        this.mNext = safeIterableMap$Entry;
    }

    private SafeIterableMap$Entry nextNode() {
        SafeIterableMap$Entry safeIterableMap$Entry = this.mNext;
        SafeIterableMap$Entry safeIterableMap$Entry2 = this.mExpectedEnd;
        if (safeIterableMap$Entry != safeIterableMap$Entry2 && safeIterableMap$Entry2 != null) {
            return this.forward(safeIterableMap$Entry);
        }
        return null;
    }

    public abstract SafeIterableMap$Entry backward(SafeIterableMap$Entry var1);

    public abstract SafeIterableMap$Entry forward(SafeIterableMap$Entry var1);

    public boolean hasNext() {
        boolean bl2;
        SafeIterableMap$Entry safeIterableMap$Entry = this.mNext;
        if (safeIterableMap$Entry != null) {
            bl2 = true;
        } else {
            bl2 = false;
            safeIterableMap$Entry = null;
        }
        return bl2;
    }

    public Map.Entry next() {
        SafeIterableMap$Entry safeIterableMap$Entry;
        SafeIterableMap$Entry safeIterableMap$Entry2 = this.mNext;
        this.mNext = safeIterableMap$Entry = this.nextNode();
        return safeIterableMap$Entry2;
    }

    public void supportRemove(SafeIterableMap$Entry safeIterableMap$Entry) {
        SafeIterableMap$Entry safeIterableMap$Entry2 = this.mExpectedEnd;
        if (safeIterableMap$Entry2 == safeIterableMap$Entry && safeIterableMap$Entry == (safeIterableMap$Entry2 = this.mNext)) {
            safeIterableMap$Entry2 = null;
            this.mNext = null;
            this.mExpectedEnd = null;
        }
        if ((safeIterableMap$Entry2 = this.mExpectedEnd) == safeIterableMap$Entry) {
            this.mExpectedEnd = safeIterableMap$Entry2 = this.backward(safeIterableMap$Entry2);
        }
        if ((safeIterableMap$Entry2 = this.mNext) == safeIterableMap$Entry) {
            this.mNext = safeIterableMap$Entry = this.nextNode();
        }
    }
}

