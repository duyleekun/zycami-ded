/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.Messages$PatchItem;
import cn.leancloud.Messages$PatchItemOrBuilder;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

public interface Messages$PatchCommandOrBuilder
extends MessageOrBuilder {
    public long getLastPatchTime();

    public Messages$PatchItem getPatches(int var1);

    public int getPatchesCount();

    public List getPatchesList();

    public Messages$PatchItemOrBuilder getPatchesOrBuilder(int var1);

    public List getPatchesOrBuilderList();

    public boolean hasLastPatchTime();
}

