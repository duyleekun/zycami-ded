/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.tencent.ugc;

import android.os.Bundle;
import com.tencent.ugc.TXRecordCommon$TXRecordResult;

public interface TXRecordCommon$ITXVideoRecordListener {
    public void onRecordComplete(TXRecordCommon$TXRecordResult var1);

    public void onRecordEvent(int var1, Bundle var2);

    public void onRecordProgress(long var1);
}

