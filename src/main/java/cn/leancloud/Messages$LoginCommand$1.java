/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LoginCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$LoginCommand$1
extends AbstractParser {
    public Messages$LoginCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$LoginCommand messages$LoginCommand = new Messages$LoginCommand(codedInputStream, extensionRegistryLite, null);
        return messages$LoginCommand;
    }
}

