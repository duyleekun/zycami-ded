/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.im.AVIMBaseBroadcastReceiver;
import cn.leancloud.im.AndroidOperationTube;
import cn.leancloud.im.v2.AVIMException;
import cn.leancloud.im.v2.Conversation$AVIMOperation;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResult;
import cn.leancloud.im.v2.callback.AVIMConversationIterableResultCallback;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AndroidOperationTube$14
extends AVIMBaseBroadcastReceiver {
    public final /* synthetic */ AndroidOperationTube this$0;
    public final /* synthetic */ Conversation$AVIMOperation val$op;

    public AndroidOperationTube$14(AndroidOperationTube androidOperationTube, AVCallback aVCallback, Conversation$AVIMOperation conversation$AVIMOperation) {
        this.this$0 = androidOperationTube;
        this.val$op = conversation$AVIMOperation;
        super(aVCallback);
    }

    public void execute(Map object, Throwable throwable) {
        Object object2 = Conversation$AVIMOperation.CONVERSATION_MEMBER_COUNT_QUERY;
        Object object3 = this.val$op;
        if (object2 == object3) {
            boolean bl2;
            int n10 = 0;
            object2 = null;
            if (object != null && (bl2 = (object = object.get(object3 = "callbackMemberCount")) instanceof Integer)) {
                object = (Integer)object;
                n10 = (Integer)object;
            }
            object = this.callback;
            object2 = n10;
            throwable = AVIMException.wrapperAVException(throwable);
            ((AVCallback)object).internalDone(object2, (AVException)throwable);
        } else {
            object2 = Conversation$AVIMOperation.CONVERSATION_BLOCKED_MEMBER_QUERY;
            if (object2 != object3 && (object2 = Conversation$AVIMOperation.CONVERSATION_MUTED_MEMBER_QUERY) != object3) {
                object2 = this.callback;
                throwable = AVIMException.wrapperAVException(throwable);
                ((AVCallback)object2).internalDone(object, (AVException)throwable);
            } else {
                boolean bl3;
                object2 = new ArrayList();
                boolean bl4 = false;
                object3 = null;
                if (object != null) {
                    object3 = object.get("callbackData");
                    String string2 = "callbackNext";
                    object = (String)object.get(string2);
                    bl3 = object3 instanceof Collection;
                    if (bl3) {
                        object3 = (Collection)object3;
                        object2.addAll(object3);
                    } else {
                        bl3 = object3 instanceof String[];
                        if (bl3) {
                            object3 = Arrays.asList((String[])object3);
                            object2.addAll(object3);
                        }
                    }
                    object3 = object;
                }
                if (bl3 = (object = this.callback) instanceof AVIMConversationIterableResultCallback) {
                    object = new AVIMConversationIterableResult();
                    ((AVIMConversationIterableResult)object).setMembers((List)object2);
                    ((AVIMConversationIterableResult)object).setNext((String)object3);
                    object2 = this.callback;
                    throwable = AVIMException.wrapperAVException(throwable);
                    ((AVCallback)object2).internalDone(object, (AVException)throwable);
                } else {
                    throwable = AVIMException.wrapperAVException(throwable);
                    ((AVCallback)object).internalDone(object2, (AVException)throwable);
                }
            }
        }
    }
}

