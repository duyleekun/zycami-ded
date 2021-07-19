/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$AckCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$AckCommand$1
extends AbstractParser {
    public Messages$AckCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$AckCommand messages$AckCommand = new Messages$AckCommand(codedInputStream, extensionRegistryLite, null);
        return messages$AckCommand;
    }
}

