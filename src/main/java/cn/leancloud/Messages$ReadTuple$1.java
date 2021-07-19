/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$ReadTuple;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;

public final class Messages$ReadTuple$1
extends AbstractParser {
    public Messages$ReadTuple parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        Messages$ReadTuple messages$ReadTuple = new Messages$ReadTuple(codedInputStream, extensionRegistryLite, null);
        return messages$ReadTuple;
    }
}

