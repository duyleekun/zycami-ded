/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Metadata;

public class MapEntry$Metadata$1
extends AbstractParser {
    public final /* synthetic */ MapEntry$Metadata this$0;

    public MapEntry$Metadata$1(MapEntry$Metadata mapEntry$Metadata) {
        this.this$0 = mapEntry$Metadata;
    }

    public MapEntry parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) {
        MapEntry$Metadata mapEntry$Metadata = this.this$0;
        MapEntry mapEntry = new MapEntry(mapEntry$Metadata, codedInputStream, extensionRegistryLite, null);
        return mapEntry;
    }
}

