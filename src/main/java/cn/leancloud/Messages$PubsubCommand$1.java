/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$PubsubCommand;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$PubsubCommand$1
extends AbstractParser {
    public Messages$PubsubCommand parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$PubsubCommand messages$PubsubCommand = new Messages$PubsubCommand(codedInputStream, extensionRegistryLite, null);
        return messages$PubsubCommand;
    }
}

