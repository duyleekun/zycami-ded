/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ErrorCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$ErrorCommand$1
extends AbstractParser {
    public Messages$ErrorCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$ErrorCommand messages$ErrorCommand = new Messages$ErrorCommand(codedInputStream, extensionRegistryLite, null);
        return messages$ErrorCommand;
    }
}

