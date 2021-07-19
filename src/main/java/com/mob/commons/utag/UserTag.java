/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.commons.utag.TagRequester;
import com.mob.commons.utag.UserTager;
import com.mob.tools.proguard.PublicMemberKeeper;

public class UserTag
implements PublicMemberKeeper {
    private UserTag() {
    }

    public static TagRequester getUserTags() {
        TagRequester tagRequester = new TagRequester();
        return tagRequester;
    }

    public static UserTager tagUser() {
        UserTager userTager = new UserTager();
        return userTager;
    }
}

