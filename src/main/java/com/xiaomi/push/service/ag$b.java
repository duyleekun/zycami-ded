/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 */
package com.xiaomi.push.service;

import android.app.Notification;
import com.xiaomi.push.service.ag;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ag$b {
    public int a;
    public Notification a;
    public final /* synthetic */ ag a;

    public ag$b(ag ag2, int n10, Notification notification) {
        this.a = ag2;
        this.a = n10;
        this.a = notification;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id:");
        int n10 = this.a;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

