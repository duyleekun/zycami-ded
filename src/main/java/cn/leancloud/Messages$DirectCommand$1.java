/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$DirectCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$DirectCommand$1
extends AbstractParser {
    public Messages$DirectCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$DirectCommand messages$DirectCommand = new Messages$DirectCommand(codedInputStream, extensionRegistryLite, null);
        return messages$DirectCommand;
    }
}

