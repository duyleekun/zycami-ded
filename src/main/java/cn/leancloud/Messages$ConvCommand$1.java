/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ConvCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$ConvCommand$1
extends AbstractParser {
    public Messages$ConvCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$ConvCommand messages$ConvCommand = new Messages$ConvCommand(codedInputStream, extensionRegistryLite, null);
        return messages$ConvCommand;
    }
}

