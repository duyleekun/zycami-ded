/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MessageInfo;
import com.google.protobuf.MessageLite;
import com.google.protobuf.ProtoSyntax;

public final class RawMessageInfo
implements MessageInfo {
    private final MessageLite defaultInstance;
    private final int flags;
    private final String info;
    private final Object[] objects;

    public RawMessageInfo(MessageLite messageLite, String string2, Object[] objectArray) {
        this.defaultInstance = messageLite;
        this.info = string2;
        this.objects = objectArray;
        messageLite = null;
        int n10 = string2.charAt(0);
        int n11 = 55296;
        if (n10 < n11) {
            this.flags = n10;
        } else {
            n10 &= 0x1FFF;
            int n12 = 13;
            int n13 = 1;
            while (true) {
                int n14 = n13 + 1;
                if ((n13 = (int)string2.charAt(n13)) < n11) break;
                n13 = (n13 & 0x1FFF) << n12;
                n10 |= n13;
                n12 += 13;
                n13 = n14;
            }
            int n15 = n13 << n12;
            this.flags = n10 |= n15;
        }
    }

    public MessageLite getDefaultInstance() {
        return this.defaultInstance;
    }

    public Object[] getObjects() {
        return this.objects;
    }

    public String getStringInfo() {
        return this.info;
    }

    public ProtoSyntax getSyntax() {
        int n10 = this.flags;
        int n11 = 1;
        ProtoSyntax protoSyntax = (n10 &= n11) == n11 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
        return protoSyntax;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isMessageSetWireFormat() {
        void var1_5;
        int bl2 = this.flags;
        int n10 = 2;
        int n11 = bl2 & n10;
        if (n11 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_5;
    }
}

