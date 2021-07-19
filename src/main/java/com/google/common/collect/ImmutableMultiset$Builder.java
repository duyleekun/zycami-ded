/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.ObjectCountHashMap;
import com.google.common.collect.ObjectCountLinkedHashMap;
import com.google.common.collect.RegularImmutableMultiset;
import java.util.Iterator;

public class ImmutableMultiset$Builder
extends ImmutableCollection$Builder {
    public boolean buildInvoked = false;
    public ObjectCountHashMap contents;
    public boolean isLinkedHash = false;

    public ImmutableMultiset$Builder() {
        this(4);
    }

    public ImmutableMultiset$Builder(int n10) {
        ObjectCountHashMap objectCountHashMap;
        this.contents = objectCountHashMap = ObjectCountHashMap.createWithExpectedSize(n10);
    }

    public ImmutableMultiset$Builder(boolean bl2) {
        this.contents = null;
    }

    public static ObjectCountHashMap tryGetMap(Iterable iterable) {
        boolean bl2 = iterable instanceof RegularImmutableMultiset;
        if (bl2) {
            return ((RegularImmutableMultiset)iterable).contents;
        }
        bl2 = iterable instanceof AbstractMapBasedMultiset;
        if (bl2) {
            return ((AbstractMapBasedMultiset)iterable).backingMap;
        }
        return null;
    }

    public ImmutableMultiset$Builder add(Object object) {
        return this.addCopies(object, 1);
    }

    public ImmutableMultiset$Builder add(Object ... objectArray) {
        super.add(objectArray);
        return this;
    }

    public ImmutableMultiset$Builder addAll(Iterable iterator2) {
        int n10 = iterator2 instanceof Multiset;
        if (n10 != 0) {
            Object object = ImmutableMultiset$Builder.tryGetMap((Iterable)((Object)(iterator2 = Multisets.cast((Iterable)((Object)iterator2)))));
            if (object != null) {
                iterator2 = this.contents;
                int n11 = ((ObjectCountHashMap)((Object)iterator2)).size();
                int n12 = ((ObjectCountHashMap)object).size();
                n11 = Math.max(n11, n12);
                ((ObjectCountHashMap)((Object)iterator2)).ensureCapacity(n11);
                int n13 = ((ObjectCountHashMap)object).firstIndex();
                while (n13 >= 0) {
                    Object object2 = ((ObjectCountHashMap)object).getKey(n13);
                    n12 = ((ObjectCountHashMap)object).getValue(n13);
                    this.addCopies(object2, n12);
                    n13 = ((ObjectCountHashMap)object).nextIndex(n13);
                }
            } else {
                object = iterator2.entrySet();
                Object object3 = this.contents;
                int n14 = ((ObjectCountHashMap)object3).size();
                n10 = object.size();
                n10 = Math.max(n14, n10);
                ((ObjectCountHashMap)object3).ensureCapacity(n10);
                iterator2 = iterator2.entrySet().iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object = (Multiset$Entry)iterator2.next();
                    object3 = object.getElement();
                    n10 = object.getCount();
                    this.addCopies(object3, n10);
                }
            }
        } else {
            super.addAll((Iterable)((Object)iterator2));
        }
        return this;
    }

    public ImmutableMultiset$Builder addAll(Iterator iterator2) {
        super.addAll(iterator2);
        return this;
    }

    public ImmutableMultiset$Builder addCopies(Object object, int n10) {
        ObjectCountHashMap objectCountHashMap;
        if (n10 == 0) {
            return this;
        }
        boolean bl2 = this.buildInvoked;
        int n11 = 0;
        if (bl2) {
            ObjectCountHashMap objectCountHashMap2 = this.contents;
            this.contents = objectCountHashMap = new ObjectCountHashMap(objectCountHashMap2);
            this.isLinkedHash = false;
        }
        this.buildInvoked = false;
        Preconditions.checkNotNull(object);
        objectCountHashMap = this.contents;
        n11 = objectCountHashMap.get(object);
        objectCountHashMap.put(object, n10 += n11);
        return this;
    }

    public ImmutableMultiset build() {
        ObjectCountHashMap objectCountHashMap;
        Object object = this.contents;
        int n10 = ((ObjectCountHashMap)object).size();
        if (n10 == 0) {
            return ImmutableMultiset.of();
        }
        n10 = (int)(this.isLinkedHash ? 1 : 0);
        if (n10 != 0) {
            objectCountHashMap = this.contents;
            this.contents = object = new ObjectCountHashMap(objectCountHashMap);
            n10 = 0;
            object = null;
            this.isLinkedHash = false;
        }
        this.buildInvoked = true;
        objectCountHashMap = this.contents;
        object = new RegularImmutableMultiset(objectCountHashMap);
        return object;
    }

    public ImmutableMultiset$Builder setCount(Object object, int n10) {
        boolean bl2;
        ObjectCountHashMap objectCountHashMap = null;
        if (n10 == 0 && !(bl2 = this.isLinkedHash)) {
            ObjectCountHashMap objectCountHashMap2 = this.contents;
            ObjectCountLinkedHashMap objectCountLinkedHashMap = new ObjectCountLinkedHashMap(objectCountHashMap2);
            this.contents = objectCountLinkedHashMap;
            this.isLinkedHash = bl2 = true;
        } else {
            bl2 = this.buildInvoked;
            if (bl2) {
                ObjectCountHashMap objectCountHashMap3;
                ObjectCountHashMap objectCountHashMap4 = this.contents;
                this.contents = objectCountHashMap3 = new ObjectCountHashMap(objectCountHashMap4);
                this.isLinkedHash = false;
            }
        }
        this.buildInvoked = false;
        Preconditions.checkNotNull(object);
        if (n10 == 0) {
            ObjectCountHashMap objectCountHashMap5 = this.contents;
            objectCountHashMap5.remove(object);
        } else {
            objectCountHashMap = this.contents;
            object = Preconditions.checkNotNull(object);
            objectCountHashMap.put(object, n10);
        }
        return this;
    }
}

