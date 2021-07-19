/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.b.b.f$a;
import java.util.HashMap;

public abstract class CustomPlatform
extends Platform {
    public abstract boolean checkAuthorize(int var1, Object var2);

    public void doAuthorize(String[] stringArray) {
    }

    public void doCustomerProtocol(String string2, String string3, int n10, HashMap hashMap, HashMap hashMap2) {
    }

    public void doShare(Platform$ShareParams platform$ShareParams) {
    }

    public HashMap filterFriendshipInfo(int n10, HashMap hashMap) {
        return null;
    }

    public final f$a filterShareContent(Platform$ShareParams platform$ShareParams, HashMap hashMap) {
        return null;
    }

    public void follow(String string2) {
    }

    public HashMap getBilaterals(int n10, int n11, String string2) {
        return null;
    }

    public int getCustomPlatformId() {
        return 1;
    }

    public HashMap getFollowers(int n10, int n11, String string2) {
        return null;
    }

    public HashMap getFollowings(int n10, int n11, String string2) {
        return null;
    }

    public void getFriendList(int n10, int n11, String string2) {
    }

    public abstract String getName();

    public final int getPlatformId() {
        return -Math.abs(this.getCustomPlatformId());
    }

    public int getVersion() {
        return 0;
    }

    public boolean hasShareCallback() {
        return false;
    }

    public final void initDevInfo(String string2) {
    }

    public final void setNetworkDevinfo() {
    }

    public void timeline(int n10, int n11, String string2) {
    }

    public void userInfor(String string2) {
    }
}

