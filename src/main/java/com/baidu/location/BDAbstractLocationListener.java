/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

import com.baidu.location.BDLocation;

public abstract class BDAbstractLocationListener {
    public void onConnectHotSpotMessage(String string2, int n10) {
    }

    public void onLocDiagnosticMessage(int n10, int n11, String string2) {
    }

    public abstract void onReceiveLocation(BDLocation var1);
}

