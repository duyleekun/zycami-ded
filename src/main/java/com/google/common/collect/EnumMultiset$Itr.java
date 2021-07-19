/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.EnumMultiset;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class EnumMultiset$Itr
implements Iterator {
    public int index = 0;
    public final /* synthetic */ EnumMultiset this$0;
    public int toRemove = -1;

    public EnumMultiset$Itr(EnumMultiset enumMultiset) {
        this.this$0 = enumMultiset;
    }

    public boolean hasNext() {
        Enum[] enumArray;
        int n10;
        int n11;
        while ((n11 = this.index) < (n10 = (enumArray = EnumMultiset.access$000(this.this$0)).length)) {
            int[] nArray = EnumMultiset.access$100(this.this$0);
            n11 = nArray[n10 = this.index];
            if (n11 > 0) {
                return true;
            }
            this.index = ++n10;
        }
        return false;
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            n10 = this.index;
            Object object = this.output(n10);
            int n11 = this.index;
            this.toRemove = n11++;
            this.index = n11;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public abstract Object output(int var1);

    public void remove() {
        Object object;
        int n10 = this.toRemove;
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        object = EnumMultiset.access$100(this.this$0);
        int n11 = this.toRemove;
        n10 = object[n11];
        if (n10 > 0) {
            EnumMultiset.access$210(this.this$0);
            object = this.this$0;
            long l10 = EnumMultiset.access$300((EnumMultiset)object);
            int[] nArray = EnumMultiset.access$100(this.this$0);
            int n12 = this.toRemove;
            int n13 = nArray[n12];
            long l11 = n13;
            EnumMultiset.access$302((EnumMultiset)object, l10 -= l11);
            object = EnumMultiset.access$100(this.this$0);
            n11 = this.toRemove;
            object[n11] = 0;
        }
        this.toRemove = -1;
    }
}

