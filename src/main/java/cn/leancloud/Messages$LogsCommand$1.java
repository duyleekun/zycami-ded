/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LogsCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$LogsCommand$1
extends AbstractParser {
    public Messages$LogsCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$LogsCommand messages$LogsCommand = new Messages$LogsCommand(codedInputStream, extensionRegistryLite, null);
        return messages$LogsCommand;
    }
}

