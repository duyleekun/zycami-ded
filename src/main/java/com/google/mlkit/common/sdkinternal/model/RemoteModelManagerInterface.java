/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.tasks.Task;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.common.model.RemoteModel;

public interface RemoteModelManagerInterface {
    public Task deleteDownloadedModel(RemoteModel var1);

    public Task download(RemoteModel var1, DownloadConditions var2);

    public Task getDownloadedModels();

    public Task isModelDownloaded(RemoteModel var1);
}

