/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.json.JSONObject;
import e.a.z;
import java.util.Map;
import k.d;

public interface APIService {
    public static final String HEADER_KEY_LC_SESSIONTOKEN = "X-LC-Session";

    public z acceptFriendshipRequest(String var1, String var2, JSONObject var3);

    public z applyFriendship(String var1, JSONObject var2);

    public z batchCreate(String var1, JSONObject var2);

    public z batchUpdate(String var1, JSONObject var2);

    public z checkAuthenticated(String var1, Map var2);

    public z cloudFunction(String var1, String var2, Map var3);

    public z cloudQuery(String var1, Map var2);

    public z cloudRPC(String var1, String var2, Object var3);

    public z createObject(String var1, String var2, JSONObject var3, boolean var4, JSONObject var5);

    public z createRole(JSONObject var1);

    public z createUploadToken(String var1, JSONObject var2);

    public z currentTimeMillis();

    public z declineFriendshipRequest(String var1, String var2);

    public z deleteInboxStatus(String var1, Map var2);

    public z deleteObject(String var1, String var2, String var3, Map var4);

    public z deleteStatus(String var1, String var2);

    public z deleteWholeObject(String var1, String var2, String var3, Map var4);

    public z fetchFile(String var1, String var2);

    public z fetchObject(String var1, String var2, String var3);

    public z fetchObject(String var1, String var2, String var3, String var4);

    public z fetchSingleStatus(String var1, String var2);

    public z fetchStatuses(String var1, Map var2);

    public d fileCallback(String var1, JSONObject var2);

    public z findObjects(String var1, String var2);

    public z followUser(String var1, String var2, String var3, Map var4);

    public z getFollowees(String var1, String var2);

    public z getFollowers(String var1, String var2);

    public z getFollowersAndFollowees(String var1, String var2);

    public z getInboxCount(String var1, Map var2);

    public z getWholeObject(String var1, String var2, String var3, String var4);

    public z login(JSONObject var1);

    public z postStatus(String var1, Map var2);

    public z queryInbox(String var1, Map var2);

    public z queryObjects(String var1, String var2, Map var3);

    public z queryUsers(String var1, Map var2);

    public z refreshSessionToken(String var1, String var2);

    public z requestCaptcha(Map var1);

    public z requestEmailVerify(Map var1);

    public z requestLoginSmsCode(Map var1);

    public z requestMobilePhoneVerify(Map var1);

    public z requestResetPassword(Map var1);

    public z requestResetPasswordBySmsCode(Map var1);

    public z requestSMSCode(Map var1);

    public z requestSMSCodeForUpdatingPhoneNumber(String var1, Map var2);

    public z resetInboxUnreadCount(String var1);

    public z resetPasswordBySmsCode(String var1, Map var2);

    public z saveWholeObject(String var1, String var2, JSONObject var3, boolean var4, JSONObject var5);

    public z saveWholeObject(String var1, String var2, String var3, JSONObject var4, boolean var5, JSONObject var6);

    public z search(String var1, Map var2);

    public z signup(JSONObject var1);

    public z signup(JSONObject var1, boolean var2);

    public z signupByMobilePhone(JSONObject var1);

    public z unfollowUser(String var1, String var2, String var3);

    public z updateFriendship(String var1, String var2, String var3, Map var4);

    public z updateObject(String var1, String var2, String var3, JSONObject var4, boolean var5, JSONObject var6);

    public z updatePassword(String var1, String var2, JSONObject var3);

    public z verifyCaptcha(Map var1);

    public z verifyMobilePhone(String var1);

    public z verifySMSCode(String var1, Map var2);

    public z verifySMSCodeForUpdatingPhoneNumber(String var1, Map var2);
}

