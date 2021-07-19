/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import java.util.Collections;
import java.util.List;

public class UninitializedMessageException
extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List missingFields;

    public UninitializedMessageException(MessageLite messageLite) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.missingFields = null;
    }

    public UninitializedMessageException(List list) {
        String string2 = UninitializedMessageException.buildDescription(list);
        super(string2);
        this.missingFields = list;
    }

    private static String buildDescription(List object) {
        boolean bl2;
        String string2 = "Message missing required fields: ";
        StringBuilder stringBuilder = new StringBuilder(string2);
        object = object.iterator();
        boolean bl3 = true;
        while (bl2 = object.hasNext()) {
            String string3 = (String)object.next();
            if (bl3) {
                bl3 = false;
                string2 = null;
            } else {
                String string4 = ", ";
                stringBuilder.append(string4);
            }
            stringBuilder.append(string3);
        }
        return stringBuilder.toString();
    }

    public InvalidProtocolBufferException asInvalidProtocolBufferException() {
        String string2 = this.getMessage();
        InvalidProtocolBufferException invalidProtocolBufferException = new InvalidProtocolBufferException(string2);
        return invalidProtocolBufferException;
    }

    public List getMissingFields() {
        return Collections.unmodifiableList(this.missingFields);
    }
}

