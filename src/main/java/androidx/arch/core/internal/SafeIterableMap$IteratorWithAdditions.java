/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.internal;

import androidx.arch.core.internal.SafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap$Entry;
import androidx.arch.core.internal.SafeIterableMap$SupportRemove;
import java.util.Iterator;
import java.util.Map;

public class SafeIterableMap$IteratorWithAdditions
implements Iterator,
SafeIterableMap$SupportRemove {
    private boolean mBeforeStart = true;
    private SafeIterableMap$Entry mCurrent;
    public final /* synthetic */ SafeIterableMap this$0;

    public SafeIterableMap$IteratorWithAdditions(SafeIterableMap safeIterableMap) {
        this.this$0 = safeIterableMap;
    }

    public boolean hasNext() {
        boolean bl2 = this.mBeforeStart;
        boolean bl3 = true;
        if (bl2) {
            SafeIterableMap$Entry safeIterableMap$Entry = this.this$0.mStart;
            if (safeIterableMap$Entry == null) {
                bl3 = false;
            }
            return bl3;
        }
        SafeIterableMap$Entry safeIterableMap$Entry = this.mCurrent;
        if (safeIterableMap$Entry == null || (safeIterableMap$Entry = safeIterableMap$Entry.mNext) == null) {
            bl3 = false;
        }
        return bl3;
    }

    public Map.Entry next() {
        boolean bl2 = this.mBeforeStart;
        if (bl2) {
            SafeIterableMap$Entry safeIterableMap$Entry;
            bl2 = false;
            this.mBeforeStart = false;
            this.mCurrent = safeIterableMap$Entry = this.this$0.mStart;
        } else {
            SafeIterableMap$Entry safeIterableMap$Entry = this.mCurrent;
            if (safeIterableMap$Entry != null) {
                safeIterableMap$Entry = safeIterableMap$Entry.mNext;
            } else {
                bl2 = false;
                safeIterableMap$Entry = null;
            }
            this.mCurrent = safeIterableMap$Entry;
        }
        return this.mCurrent;
    }

    public void supportRemove(SafeIterableMap$Entry safeIterableMap$Entry) {
        SafeIterableMap$Entry safeIterableMap$Entry2 = this.mCurrent;
        if (safeIterableMap$Entry == safeIterableMap$Entry2) {
            boolean bl2;
            this.mCurrent = safeIterableMap$Entry = safeIterableMap$Entry2.mPrevious;
            if (safeIterableMap$Entry == null) {
                bl2 = true;
            } else {
                bl2 = false;
                safeIterableMap$Entry = null;
            }
            this.mBeforeStart = bl2;
        }
    }
}

