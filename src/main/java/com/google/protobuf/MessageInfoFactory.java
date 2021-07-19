/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageInfo;

public interface MessageInfoFactory {
    public boolean isSupported(Class var1);

    public MessageInfo messageInfoFor(Class var1);
}

