/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multisets$AbstractEntry;
import com.google.common.collect.ObjectCountHashMap;

public class ObjectCountHashMap$MapEntry
extends Multisets$AbstractEntry {
    public final Object key;
    public int lastKnownIndex;
    public final /* synthetic */ ObjectCountHashMap this$0;

    public ObjectCountHashMap$MapEntry(ObjectCountHashMap object, int n10) {
        this.this$0 = object;
        this.key = object = ((ObjectCountHashMap)object).keys[n10];
        this.lastKnownIndex = n10;
    }

    public int getCount() {
        this.updateLastKnownIndex();
        int n10 = this.lastKnownIndex;
        int n11 = -1;
        if (n10 == n11) {
            n10 = 0;
        } else {
            int[] nArray = this.this$0.values;
            n10 = nArray[n10];
        }
        return n10;
    }

    public Object getElement() {
        return this.key;
    }

    public int setCount(int n10) {
        this.updateLastKnownIndex();
        int n11 = this.lastKnownIndex;
        int n12 = -1;
        if (n11 == n12) {
            ObjectCountHashMap objectCountHashMap = this.this$0;
            Object object = this.key;
            objectCountHashMap.put(object, n10);
            return 0;
        }
        int[] nArray = this.this$0.values;
        int n13 = nArray[n11];
        nArray[n11] = n10;
        return n13;
    }

    public void updateLastKnownIndex() {
        block3: {
            Object object;
            Object object2;
            int n10;
            block2: {
                n10 = this.lastKnownIndex;
                int n11 = -1;
                if (n10 == n11 || n10 >= (n11 = (object2 = this.this$0).size())) break block2;
                object = this.key;
                object2 = this.this$0.keys;
                int n12 = this.lastKnownIndex;
                n10 = (int)(Objects.equal(object, object2 = object2[n12]) ? 1 : 0);
                if (n10 != 0) break block3;
            }
            object = this.this$0;
            object2 = this.key;
            this.lastKnownIndex = n10 = ((ObjectCountHashMap)object).indexOf(object2);
        }
    }
}

