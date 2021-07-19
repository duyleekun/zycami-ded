/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.eventbus;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.base.Preconditions;

public class DeadEvent {
    private final Object event;
    private final Object source;

    public DeadEvent(Object object, Object object2) {
        this.source = object = Preconditions.checkNotNull(object);
        this.event = object = Preconditions.checkNotNull(object2);
    }

    public Object getEvent() {
        return this.event;
    }

    public Object getSource() {
        return this.source;
    }

    public String toString() {
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = MoreObjects.toStringHelper(this);
        Object object = this.source;
        moreObjects$ToStringHelper = moreObjects$ToStringHelper.add("source", object);
        object = this.event;
        return moreObjects$ToStringHelper.add("event", object).toString();
    }
}

