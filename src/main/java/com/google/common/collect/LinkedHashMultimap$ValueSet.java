/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Hashing;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.LinkedHashMultimap$ValueEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSet$1;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Arrays;
import java.util.Iterator;

public final class LinkedHashMultimap$ValueSet
extends Sets$ImprovedAbstractSet
implements LinkedHashMultimap$ValueSetLink {
    private LinkedHashMultimap$ValueSetLink firstEntry;
    public LinkedHashMultimap$ValueEntry[] hashTable;
    private final Object key;
    private LinkedHashMultimap$ValueSetLink lastEntry;
    private int modCount = 0;
    private int size = 0;
    public final /* synthetic */ LinkedHashMultimap this$0;

    public LinkedHashMultimap$ValueSet(LinkedHashMultimap linkedHashMultimap$ValueEntryArray, Object object, int n10) {
        this.this$0 = linkedHashMultimap$ValueEntryArray;
        this.key = object;
        this.firstEntry = this;
        this.lastEntry = this;
        linkedHashMultimap$ValueEntryArray = new LinkedHashMultimap$ValueEntry[Hashing.closedTableSize(n10, 1.0)];
        this.hashTable = linkedHashMultimap$ValueEntryArray;
    }

    public static /* synthetic */ LinkedHashMultimap$ValueSetLink access$000(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        return linkedHashMultimap$ValueSet.firstEntry;
    }

    public static /* synthetic */ int access$100(LinkedHashMultimap$ValueSet linkedHashMultimap$ValueSet) {
        return linkedHashMultimap$ValueSet.modCount;
    }

    private int mask() {
        return this.hashTable.length + -1;
    }

    private void rehashIfNecessary() {
        int n10 = this.size;
        LinkedHashMultimap$ValueEntry[] linkedHashMultimap$ValueEntryArray = this.hashTable;
        int n11 = linkedHashMultimap$ValueEntryArray.length;
        double d10 = 1.0;
        if ((n10 = (int)(Hashing.needsResizing(n10, n11, d10) ? 1 : 0)) != 0) {
            LinkedHashMultimap$ValueEntry[] linkedHashMultimap$ValueEntryArray2 = this.hashTable;
            n10 = linkedHashMultimap$ValueEntryArray2.length * 2;
            this.hashTable = linkedHashMultimap$ValueEntryArray = new LinkedHashMultimap$ValueEntry[n10];
            n10 += -1;
            for (LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink = this.firstEntry; linkedHashMultimap$ValueSetLink != this; linkedHashMultimap$ValueSetLink = linkedHashMultimap$ValueSetLink.getSuccessorInValueSet()) {
                LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
                LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink2 = linkedHashMultimap$ValueSetLink;
                linkedHashMultimap$ValueSetLink2 = (LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink;
                int n12 = ((LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink2).smearedValueHash & n10;
                ((LinkedHashMultimap$ValueEntry)linkedHashMultimap$ValueSetLink2).nextInValueBucket = linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntryArray[n12];
                linkedHashMultimap$ValueEntryArray[n12] = linkedHashMultimap$ValueSetLink2;
            }
        }
    }

    public boolean add(Object object) {
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry;
        int n10 = Hashing.smearedHash(object);
        int n11 = this.mask() & n10;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry = this.hashTable[n11];
        while (linkedHashMultimap$ValueEntry2 != null) {
            boolean bl2 = linkedHashMultimap$ValueEntry2.matchesValue(object, n10);
            if (bl2) {
                return false;
            }
            linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry2.nextInValueBucket;
        }
        Object object2 = this.key;
        linkedHashMultimap$ValueEntry2 = new LinkedHashMultimap$ValueEntry(object2, object, n10, linkedHashMultimap$ValueEntry);
        LinkedHashMultimap.access$200(this.lastEntry, linkedHashMultimap$ValueEntry2);
        LinkedHashMultimap.access$200(linkedHashMultimap$ValueEntry2, this);
        LinkedHashMultimap.access$400(LinkedHashMultimap.access$300(this.this$0).getPredecessorInMultimap(), linkedHashMultimap$ValueEntry2);
        object = LinkedHashMultimap.access$300(this.this$0);
        LinkedHashMultimap.access$400(linkedHashMultimap$ValueEntry2, (LinkedHashMultimap$ValueEntry)object);
        this.hashTable[n11] = linkedHashMultimap$ValueEntry2;
        int n12 = this.size;
        n10 = 1;
        this.size = n12 += n10;
        this.modCount = n12 = this.modCount + n10;
        this.rehashIfNecessary();
        return n10 != 0;
    }

    public void clear() {
        Object object = this.hashTable;
        Object object2 = null;
        Arrays.fill((Object[])object, null);
        int n10 = 0;
        this.size = 0;
        for (object = this.firstEntry; object != this; object = object.getSuccessorInValueSet()) {
            object2 = object;
            object2 = (LinkedHashMultimap$ValueEntry)object;
            LinkedHashMultimap.access$600((LinkedHashMultimap$ValueEntry)object2);
        }
        LinkedHashMultimap.access$200(this, this);
        this.modCount = n10 = this.modCount + 1;
    }

    public boolean contains(Object object) {
        int n10 = Hashing.smearedHash(object);
        Object object2 = this.hashTable;
        int n11 = this.mask() & n10;
        object2 = object2[n11];
        while (object2 != null) {
            n11 = (int)(((LinkedHashMultimap$ValueEntry)object2).matchesValue(object, n10) ? 1 : 0);
            if (n11 != 0) {
                return true;
            }
            object2 = ((LinkedHashMultimap$ValueEntry)object2).nextInValueBucket;
        }
        return false;
    }

    public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
        return this.lastEntry;
    }

    public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
        return this.firstEntry;
    }

    public Iterator iterator() {
        LinkedHashMultimap$ValueSet$1 linkedHashMultimap$ValueSet$1 = new LinkedHashMultimap$ValueSet$1(this);
        return linkedHashMultimap$ValueSet$1;
    }

    public boolean remove(Object object) {
        int n10 = Hashing.smearedHash(object);
        int n11 = this.mask() & n10;
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry = this.hashTable[n11];
        LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry2 = null;
        while (linkedHashMultimap$ValueEntry != null) {
            boolean bl2 = linkedHashMultimap$ValueEntry.matchesValue(object, n10);
            if (bl2) {
                if (linkedHashMultimap$ValueEntry2 == null) {
                    LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry3;
                    object = this.hashTable;
                    object[n11] = linkedHashMultimap$ValueEntry3 = linkedHashMultimap$ValueEntry.nextInValueBucket;
                } else {
                    linkedHashMultimap$ValueEntry2.nextInValueBucket = object = linkedHashMultimap$ValueEntry.nextInValueBucket;
                }
                LinkedHashMultimap.access$500(linkedHashMultimap$ValueEntry);
                LinkedHashMultimap.access$600(linkedHashMultimap$ValueEntry);
                int n12 = this.size;
                n10 = 1;
                this.size = n12 -= n10;
                this.modCount = n12 = this.modCount + n10;
                return n10 != 0;
            }
            LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry4 = linkedHashMultimap$ValueEntry.nextInValueBucket;
            linkedHashMultimap$ValueEntry2 = linkedHashMultimap$ValueEntry;
            linkedHashMultimap$ValueEntry = linkedHashMultimap$ValueEntry4;
        }
        return false;
    }

    public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.lastEntry = linkedHashMultimap$ValueSetLink;
    }

    public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.firstEntry = linkedHashMultimap$ValueSetLink;
    }

    public int size() {
        return this.size;
    }
}

