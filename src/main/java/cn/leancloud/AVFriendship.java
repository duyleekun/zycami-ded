/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVSaveOption;
import cn.leancloud.AVUser;
import cn.leancloud.utils.ErrorUtils;
import e.a.z;

public class AVFriendship
extends AVObject {
    public static final String ATTR_FOLLOWEE = "followee";
    public static final String ATTR_FOLLOWER = "follower";
    public static final String ATTR_FRIEND_STATUS = "friendStatus";
    public static final String ATTR_USER = "user";
    public static final String CLASS_NAME = "_Followee";

    public AVFriendship() {
        super(CLASS_NAME);
    }

    public AVUser getFollowee() {
        return (AVUser)this.getAVObject(ATTR_FOLLOWEE);
    }

    public AVUser getFollower() {
        return (AVUser)this.getAVObject(ATTR_FOLLOWER);
    }

    public z saveInBackground(AVSaveOption object) {
        object = AVUser.currentUser();
        if (object == null) {
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        return ((AVUser)object).updateFriendship(this);
    }

    public void setFollowee(AVUser aVUser) {
        this.put(ATTR_FOLLOWEE, aVUser);
    }

    public void setFollower(AVUser aVUser) {
        this.put(ATTR_FOLLOWER, aVUser);
    }
}

