/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$JsonObjectMessage;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$JsonObjectMessage$1
extends AbstractParser {
    public Messages$JsonObjectMessage parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$JsonObjectMessage messages$JsonObjectMessage = new Messages$JsonObjectMessage(codedInputStream, extensionRegistryLite, null);
        return messages$JsonObjectMessage;
    }
}

