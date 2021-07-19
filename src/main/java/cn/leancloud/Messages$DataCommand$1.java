/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$DataCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$DataCommand$1
extends AbstractParser {
    public Messages$DataCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$DataCommand messages$DataCommand = new Messages$DataCommand(codedInputStream, extensionRegistryLite, null);
        return messages$DataCommand;
    }
}

