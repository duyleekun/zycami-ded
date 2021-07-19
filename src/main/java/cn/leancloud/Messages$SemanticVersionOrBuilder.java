/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;

public interface Messages$SemanticVersionOrBuilder
extends MessageOrBuilder {
    public String getBuild();

    public ByteString getBuildBytes();

    public int getMajor();

    public int getMinor();

    public int getPatch();

    public String getPreRelease();

    public ByteString getPreReleaseBytes();

    public boolean hasBuild();

    public boolean hasMajor();

    public boolean hasMinor();

    public boolean hasPatch();

    public boolean hasPreRelease();
}

