/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 */
package com.kwai.opensdk.sdk.model.socialshare;

import android.os.Bundle;

public interface KwaiMediaMessage$IMediaObject {
    public static final int TYPE_UNKNOWN = 0;
    public static final int TYPE_WEB_PAGE = 1;

    public boolean checkArgs();

    public void serialize(Bundle var1);

    public int type();

    public void unserialize(Bundle var1);
}

