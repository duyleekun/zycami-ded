/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im.v2.messages;

import cn.leancloud.AVException;
import cn.leancloud.callback.AVCallback;
import cn.leancloud.callback.SaveCallback;
import cn.leancloud.im.v2.messages.AVIMFileMessage;
import java.util.Map;

public class AVIMFileMessage$2
extends SaveCallback {
    public final /* synthetic */ AVIMFileMessage this$0;
    public final /* synthetic */ SaveCallback val$callback;
    public final /* synthetic */ Map val$metaData;

    public AVIMFileMessage$2(AVIMFileMessage aVIMFileMessage, Map map, SaveCallback saveCallback) {
        this.this$0 = aVIMFileMessage;
        this.val$metaData = map;
        this.val$callback = saveCallback;
    }

    public void done(AVException aVException) {
        Object object = this.this$0.file;
        Map map = this.val$metaData;
        String string2 = "metaData";
        object.put(string2, map);
        object = this.val$callback;
        if (object != null) {
            ((AVCallback)object).internalDone(aVException);
        }
    }
}

