/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$UnreadCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$UnreadCommand$1
extends AbstractParser {
    public Messages$UnreadCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$UnreadCommand messages$UnreadCommand = new Messages$UnreadCommand(codedInputStream, extensionRegistryLite, null);
        return messages$UnreadCommand;
    }
}

