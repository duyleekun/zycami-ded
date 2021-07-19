/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.LinkedHashMultimap$ValueSetLink;

public final class LinkedHashMultimap$ValueEntry
extends ImmutableEntry
implements LinkedHashMultimap$ValueSetLink {
    public LinkedHashMultimap$ValueEntry nextInValueBucket;
    public LinkedHashMultimap$ValueEntry predecessorInMultimap;
    public LinkedHashMultimap$ValueSetLink predecessorInValueSet;
    public final int smearedValueHash;
    public LinkedHashMultimap$ValueEntry successorInMultimap;
    public LinkedHashMultimap$ValueSetLink successorInValueSet;

    public LinkedHashMultimap$ValueEntry(Object object, Object object2, int n10, LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        super(object, object2);
        this.smearedValueHash = n10;
        this.nextInValueBucket = linkedHashMultimap$ValueEntry;
    }

    public LinkedHashMultimap$ValueEntry getPredecessorInMultimap() {
        return this.predecessorInMultimap;
    }

    public LinkedHashMultimap$ValueSetLink getPredecessorInValueSet() {
        return this.predecessorInValueSet;
    }

    public LinkedHashMultimap$ValueEntry getSuccessorInMultimap() {
        return this.successorInMultimap;
    }

    public LinkedHashMultimap$ValueSetLink getSuccessorInValueSet() {
        return this.successorInValueSet;
    }

    public boolean matchesValue(Object object, int n10) {
        Object object2;
        boolean bl2;
        int n11 = this.smearedValueHash;
        if (n11 == n10 && (bl2 = Objects.equal(object2 = this.getValue(), object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void setPredecessorInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        this.predecessorInMultimap = linkedHashMultimap$ValueEntry;
    }

    public void setPredecessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.predecessorInValueSet = linkedHashMultimap$ValueSetLink;
    }

    public void setSuccessorInMultimap(LinkedHashMultimap$ValueEntry linkedHashMultimap$ValueEntry) {
        this.successorInMultimap = linkedHashMultimap$ValueEntry;
    }

    public void setSuccessorInValueSet(LinkedHashMultimap$ValueSetLink linkedHashMultimap$ValueSetLink) {
        this.successorInValueSet = linkedHashMultimap$ValueSetLink;
    }
}

