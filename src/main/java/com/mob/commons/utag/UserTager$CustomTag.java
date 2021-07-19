/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.commons.utag.UserTager;
import com.mob.commons.utag.UserTager$1;
import com.mob.tools.proguard.PublicMemberKeeper;

public class UserTager$CustomTag
implements PublicMemberKeeper {
    public final /* synthetic */ UserTager a;
    private UserTager b;
    private String c;

    private UserTager$CustomTag(UserTager userTager, UserTager userTager2, String string2) {
        this.a = userTager;
        this.b = userTager2;
        this.c = string2;
    }

    public /* synthetic */ UserTager$CustomTag(UserTager userTager, UserTager userTager2, String string2, UserTager$1 userTager$1) {
        this(userTager, userTager2, string2);
    }

    private UserTager a(Object object) {
        UserTager userTager = this.b;
        String string2 = this.c;
        UserTager.a(userTager, string2, object);
        return this.b;
    }

    public UserTager withValue(Boolean bl2) {
        return this.a(bl2);
    }

    public UserTager withValue(Number number) {
        return this.a(number);
    }

    public UserTager withValue(String string2) {
        return this.a(string2);
    }
}

