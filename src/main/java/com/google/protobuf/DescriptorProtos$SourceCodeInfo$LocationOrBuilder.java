/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface DescriptorProtos$SourceCodeInfo$LocationOrBuilder
extends MessageOrBuilder {
    public String getLeadingComments();

    public ByteString getLeadingCommentsBytes();

    public String getLeadingDetachedComments(int var1);

    public ByteString getLeadingDetachedCommentsBytes(int var1);

    public int getLeadingDetachedCommentsCount();

    public List getLeadingDetachedCommentsList();

    public int getPath(int var1);

    public int getPathCount();

    public List getPathList();

    public int getSpan(int var1);

    public int getSpanCount();

    public List getSpanList();

    public String getTrailingComments();

    public ByteString getTrailingCommentsBytes();

    public boolean hasLeadingComments();

    public boolean hasTrailingComments();
}

