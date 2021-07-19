/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.UserMetadata;
import org.json.JSONObject;

public class MetaDataStore$1
extends JSONObject {
    public final /* synthetic */ UserMetadata val$userData;

    public MetaDataStore$1(UserMetadata object) {
        this.val$userData = object;
        object = ((UserMetadata)object).getUserId();
        this.put("userId", object);
    }
}

