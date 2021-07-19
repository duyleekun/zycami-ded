/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.mob.commons.GESVERIFY
 *  com.mob.commons.MOBADSDK
 *  com.mob.commons.MOBAPM
 *  com.mob.commons.MOBGUARD
 *  com.mob.commons.MOBLINK
 *  com.mob.commons.MOBPUSH
 *  com.mob.commons.SECVERIFY
 *  com.mob.commons.SMSSDK
 *  com.mob.extension.AWe
 */
package com.mob.commons;

import com.mob.commons.GESVERIFY;
import com.mob.commons.MOBADSDK;
import com.mob.commons.MOBAPM;
import com.mob.commons.MOBGUARD;
import com.mob.commons.MOBLINK;
import com.mob.commons.MOBPUSH;
import com.mob.commons.SECVERIFY;
import com.mob.commons.SHARESDK;
import com.mob.commons.SMSSDK;
import com.mob.extension.AWe;
import java.util.List;

public class g {
    public static final List a;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        List<Class<SHARESDK>> list = new List<Class<SHARESDK>>();
        a = list;
        Class<SHARESDK> clazz = SHARESDK.class;
        try {
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = SMSSDK.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = MOBLINK.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = MOBPUSH.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = AWe.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = SECVERIFY.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = MOBADSDK.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = MOBGUARD.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = GESVERIFY.class;
            list.add(clazz);
        }
        catch (Throwable throwable) {}
        try {
            list = a;
            clazz = MOBAPM.class;
            list.add(clazz);
            return;
        }
        catch (Throwable throwable) {
            return;
        }
    }
}

