/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  cn.sharesdk.loopshare.ActionListener
 */
package cn.sharesdk.framework.loopshare;

import cn.sharesdk.framework.loopshare.MobLinkAPI;
import cn.sharesdk.framework.loopshare.MoblinkActionListener;
import cn.sharesdk.loopshare.ActionListener;

public final class MobLinkAPI$1
implements ActionListener {
    public void onError(Throwable throwable) {
        MoblinkActionListener moblinkActionListener = MobLinkAPI.e();
        if (moblinkActionListener != null) {
            moblinkActionListener = MobLinkAPI.e();
            moblinkActionListener.onError(throwable);
            throwable = null;
            MobLinkAPI.a(null);
        }
    }

    public void onResult(String string2) {
        MoblinkActionListener moblinkActionListener = MobLinkAPI.e();
        if (moblinkActionListener != null) {
            moblinkActionListener = MobLinkAPI.e();
            moblinkActionListener.onResult(string2);
            string2 = null;
            MobLinkAPI.a(null);
        }
    }
}

