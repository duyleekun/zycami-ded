/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ReadCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$ReadCommand$1
extends AbstractParser {
    public Messages$ReadCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$ReadCommand messages$ReadCommand = new Messages$ReadCommand(codedInputStream, extensionRegistryLite, null);
        return messages$ReadCommand;
    }
}

