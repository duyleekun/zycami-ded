/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$LogItem;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$LogItem$1
extends AbstractParser {
    public Messages$LogItem parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$LogItem messages$LogItem = new Messages$LogItem(codedInputStream, extensionRegistryLite, null);
        return messages$LogItem;
    }
}

