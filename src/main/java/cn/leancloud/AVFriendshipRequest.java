/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.AVSaveOption;
import cn.leancloud.AVUser;
import cn.leancloud.utils.ErrorUtils;
import e.a.z;
import java.util.Map;

public class AVFriendshipRequest
extends AVObject {
    public static final String ATTR_FRIEND = "friend";
    public static final String ATTR_STATUS = "status";
    public static final String ATTR_USER = "user";
    public static final String CLASS_NAME = "_FriendshipRequest";
    public static final int STATUS_ACCEPTED = 2;
    public static final int STATUS_ANY = 7;
    public static final int STATUS_DECLINED = 4;
    public static final int STATUS_PENDING = 1;

    public AVFriendshipRequest() {
        super(CLASS_NAME);
    }

    public AVFriendshipRequest(AVFriendshipRequest aVFriendshipRequest) {
        super(aVFriendshipRequest);
    }

    public z accept(Map map) {
        AVUser aVUser = AVUser.currentUser();
        if (aVUser == null) {
            AVObject.logger.d("current user is null.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        return aVUser.acceptFriendshipRequest(this, map);
    }

    public z decline() {
        AVUser aVUser = AVUser.currentUser();
        if (aVUser == null) {
            AVObject.logger.d("current user is null.");
            return z.m2(ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called."));
        }
        return aVUser.declineFriendshipRequest(this);
    }

    public AVUser getFriend() {
        return (AVUser)this.getAVObject(ATTR_FRIEND);
    }

    public AVUser getSourceUser() {
        return (AVUser)this.getAVObject(ATTR_USER);
    }

    public z saveInBackground(AVSaveOption aVSaveOption) {
        return z.m2(ErrorUtils.propagateException(119, "save operation isn't allowed in AVFriendshipRequest class."));
    }

    public void setFriend(AVUser aVUser) {
        this.put(ATTR_FRIEND, aVUser);
    }

    public void setSourceUser(AVUser aVUser) {
        this.put(ATTR_USER, aVUser);
    }
}

