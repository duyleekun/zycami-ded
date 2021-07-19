/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LoggedinCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$LoggedinCommand$1
extends AbstractParser {
    public Messages$LoggedinCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$LoggedinCommand messages$LoggedinCommand = new Messages$LoggedinCommand(codedInputStream, extensionRegistryLite, null);
        return messages$LoggedinCommand;
    }
}

