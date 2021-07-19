/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$RoomCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$RoomCommand$1
extends AbstractParser {
    public Messages$RoomCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$RoomCommand messages$RoomCommand = new Messages$RoomCommand(codedInputStream, extensionRegistryLite, null);
        return messages$RoomCommand;
    }
}

