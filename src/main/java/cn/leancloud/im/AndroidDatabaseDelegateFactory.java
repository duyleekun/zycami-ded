/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.im;

import android.content.Context;
import cn.leancloud.im.DatabaseDelegate;
import cn.leancloud.im.DatabaseDelegateFactory;
import cn.leancloud.im.v2.AndroidDatabaseDelegate;

public class AndroidDatabaseDelegateFactory
implements DatabaseDelegateFactory {
    private Context context;

    public AndroidDatabaseDelegateFactory(Context context) {
        this.context = context;
    }

    public DatabaseDelegate createInstance(String string2) {
        Context context = this.context;
        AndroidDatabaseDelegate androidDatabaseDelegate = new AndroidDatabaseDelegate(context, string2);
        return androidDatabaseDelegate;
    }
}

