/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$RcpCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$RcpCommand$1
extends AbstractParser {
    public Messages$RcpCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$RcpCommand messages$RcpCommand = new Messages$RcpCommand(codedInputStream, extensionRegistryLite, null);
        return messages$RcpCommand;
    }
}

