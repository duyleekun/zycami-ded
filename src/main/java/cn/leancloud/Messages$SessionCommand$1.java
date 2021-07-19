/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$SessionCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$SessionCommand$1
extends AbstractParser {
    public Messages$SessionCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$SessionCommand messages$SessionCommand = new Messages$SessionCommand(codedInputStream, extensionRegistryLite, null);
        return messages$SessionCommand;
    }
}

