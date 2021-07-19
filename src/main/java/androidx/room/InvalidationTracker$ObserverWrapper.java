/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker$Observer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class InvalidationTracker$ObserverWrapper {
    public final InvalidationTracker$Observer mObserver;
    private final Set mSingleTableSet;
    public final int[] mTableIds;
    private final String[] mTableNames;

    public InvalidationTracker$ObserverWrapper(InvalidationTracker$Observer set, int[] object, String[] stringArray) {
        this.mObserver = set;
        this.mTableIds = object;
        this.mTableNames = stringArray;
        int n10 = ((int[])object).length;
        int n11 = 1;
        if (n10 == n11) {
            set = new Set<Object>();
            n11 = 0;
            object = stringArray[0];
            set.add(object);
            this.mSingleTableSet = set = Collections.unmodifiableSet(set);
        } else {
            n10 = 0;
            set = null;
            this.mSingleTableSet = null;
        }
    }

    public void notifyByTableInvalidStatus(Set object) {
        int[] nArray = this.mTableIds;
        int n10 = nArray.length;
        HashSet<Object> hashSet = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = this.mTableIds[i10];
            int n11 = object.contains(object2);
            if (n11 == 0) continue;
            n11 = 1;
            if (n10 == n11) {
                hashSet = this.mSingleTableSet;
                continue;
            }
            if (hashSet == null) {
                hashSet = new HashSet<Object>(n10);
            }
            object2 = this.mTableNames[i10];
            hashSet.add(object2);
        }
        if (hashSet != null) {
            object = this.mObserver;
            ((InvalidationTracker$Observer)object).onInvalidated(hashSet);
        }
    }

    public void notifyByTableNames(String[] object) {
        Object object2 = this.mTableNames;
        int n10 = ((String[])object2).length;
        int n11 = 1;
        Object object3 = null;
        if (n10 == n11) {
            for (String string2 : object) {
                String string3 = this.mTableNames[0];
                boolean bl2 = string2.equalsIgnoreCase(string3);
                if (!bl2) continue;
                object3 = this.mSingleTableSet;
                break;
            }
        } else {
            object2 = new HashSet();
            n11 = ((String[])object).length;
            Object var6_7 = null;
            block1: for (int i10 = 0; i10 < n11; ++i10) {
                Object object4 = object[i10];
                for (String string4 : this.mTableNames) {
                    boolean bl3 = string4.equalsIgnoreCase((String)object4);
                    if (!bl3) continue;
                    ((HashSet)object2).add(string4);
                    continue block1;
                }
            }
            int n12 = ((HashSet)object2).size();
            if (n12 > 0) {
                object3 = object2;
            }
        }
        if (object3 != null) {
            object = this.mObserver;
            ((InvalidationTracker$Observer)object).onInvalidated((Set)object3);
        }
    }
}

