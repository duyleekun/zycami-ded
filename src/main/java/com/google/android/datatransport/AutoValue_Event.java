/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.datatransport;

import com.google.android.datatransport.Event;
import com.google.android.datatransport.Priority;
import java.util.Objects;

public final class AutoValue_Event
extends Event {
    private final Integer code;
    private final Object payload;
    private final Priority priority;

    public AutoValue_Event(Integer n10, Object object, Priority priority) {
        this.code = n10;
        Objects.requireNonNull(object, "Null payload");
        this.payload = object;
        Objects.requireNonNull(priority, "Null priority");
        this.priority = priority;
    }

    public boolean equals(Object object) {
        block4: {
            boolean bl2;
            block6: {
                block5: {
                    boolean bl3;
                    Object object2;
                    bl2 = true;
                    if (object == this) {
                        return bl2;
                    }
                    boolean bl4 = object instanceof Event;
                    if (!bl4) break block4;
                    object = (Event)object;
                    Object object3 = this.code;
                    if (!(object3 == null ? (object3 = ((Event)object).getCode()) == null : (bl4 = ((Integer)object3).equals(object2 = ((Event)object).getCode())))) break block5;
                    object3 = this.payload;
                    object2 = ((Event)object).getPayload();
                    bl4 = object3.equals(object2);
                    if (bl4 && (bl3 = ((Enum)(object3 = this.priority)).equals(object = ((Event)object).getPriority()))) break block6;
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Integer getCode() {
        return this.code;
    }

    public Object getPayload() {
        return this.payload;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public int hashCode() {
        int n10;
        Integer n11 = this.code;
        if (n11 == null) {
            n10 = 0;
            n11 = null;
        } else {
            n10 = n11.hashCode();
        }
        int n12 = 1000003;
        n10 = (n10 ^ n12) * n12;
        int n13 = this.payload.hashCode();
        n10 = (n10 ^ n13) * n12;
        n12 = this.priority.hashCode();
        return n10 ^ n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Event{code=");
        Object object = this.code;
        stringBuilder.append(object);
        stringBuilder.append(", payload=");
        object = this.payload;
        stringBuilder.append(object);
        stringBuilder.append(", priority=");
        object = this.priority;
        stringBuilder.append(object);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

