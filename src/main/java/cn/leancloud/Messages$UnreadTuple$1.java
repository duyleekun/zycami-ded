/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$UnreadTuple;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$UnreadTuple$1
extends AbstractParser {
    public Messages$UnreadTuple parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$UnreadTuple messages$UnreadTuple = new Messages$UnreadTuple(codedInputStream, extensionRegistryLite, null);
        return messages$UnreadTuple;
    }
}

