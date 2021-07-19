/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.database.dao;

import androidx.lifecycle.LiveData;
import com.zhiyun.cama.camera.data.CameraSet$Mode;
import com.zhiyun.cama.data.database.model.CameraParam;
import java.util.List;

public interface CameraDao {
    public void insertCameraParam(CameraParam ... var1);

    public LiveData loadCameraParam(int var1, CameraSet$Mode var2);

    public List loadCameraParamDataList(int var1);
}

