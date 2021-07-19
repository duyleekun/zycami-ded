/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.mediaprovider.data.local.dao;

import com.zhiyun.mediaprovider.data.local.model.AlbumCustomizeData;
import java.util.List;

public interface AlbumCustomizeDao {
    public void deleteAlbumLikeData(int var1);

    public void deleteAlbumLikeData(int var1, String var2);

    public void deleteAlbumLikeData(String var1, int var2, String var3);

    public void insertAlbumCustomizeData(AlbumCustomizeData var1);

    public AlbumCustomizeData queryAlbumCustomizeData(String var1, int var2);

    public AlbumCustomizeData queryAlbumCustomizeData(String var1, int var2, String var3);

    public List queryAllAlbumCustomizeDataList(String var1);
}

