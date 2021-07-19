/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$PatchCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$PatchCommand$1
extends AbstractParser {
    public Messages$PatchCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$PatchCommand messages$PatchCommand = new Messages$PatchCommand(codedInputStream, extensionRegistryLite, null);
        return messages$PatchCommand;
    }
}

