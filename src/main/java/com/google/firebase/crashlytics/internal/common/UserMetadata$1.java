/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.crashlytics.internal.common;

import com.google.firebase.crashlytics.internal.common.UserMetadata;
import java.util.HashMap;

public class UserMetadata$1
extends HashMap {
    public final /* synthetic */ UserMetadata this$0;
    public final /* synthetic */ String val$key;
    public final /* synthetic */ String val$value;

    public UserMetadata$1(UserMetadata object, String string2, String string3) {
        this.this$0 = object;
        this.val$key = string2;
        this.val$value = string3;
        object = UserMetadata.access$000(string2);
        string2 = UserMetadata.access$100(string3);
        this.put(object, string2);
    }
}

