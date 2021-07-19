/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$PresenceCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$PresenceCommand$1
extends AbstractParser {
    public Messages$PresenceCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$PresenceCommand messages$PresenceCommand = new Messages$PresenceCommand(codedInputStream, extensionRegistryLite, null);
        return messages$PresenceCommand;
    }
}

