/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$GenericCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$GenericCommand$1
extends AbstractParser {
    public Messages$GenericCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$GenericCommand messages$GenericCommand = new Messages$GenericCommand(codedInputStream, extensionRegistryLite, null);
        return messages$GenericCommand;
    }
}

