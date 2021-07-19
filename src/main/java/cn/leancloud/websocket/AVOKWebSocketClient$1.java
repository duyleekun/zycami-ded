/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.websocket;

import cn.leancloud.AVLogger;
import cn.leancloud.Messages$GenericCommand;
import cn.leancloud.websocket.AVOKWebSocketClient;
import cn.leancloud.websocket.AVOKWebSocketClient$Status;
import com.google.protobuf.AbstractMessage;
import g.c0;
import g.f0;
import g.g0;
import okio.ByteString;

public class AVOKWebSocketClient$1
extends g0 {
    public final /* synthetic */ AVOKWebSocketClient this$0;

    public AVOKWebSocketClient$1(AVOKWebSocketClient aVOKWebSocketClient) {
        this.this$0 = aVOKWebSocketClient;
    }

    public void onClosed(f0 object, int n10, String string2) {
        object = AVOKWebSocketClient.access$000();
        String string3 = "onClosed";
        ((AVLogger)object).d(string3);
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onClosed(n10, string2);
        }
    }

    public void onClosing(f0 object, int n10, String string2) {
        object = AVOKWebSocketClient.access$000();
        String string3 = "onClosing";
        ((AVLogger)object).d(string3);
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onClosing(n10, string2);
        }
    }

    public void onFailure(f0 object, Throwable throwable, c0 c02) {
        object = this.this$0;
        boolean bl2 = AVOKWebSocketClient.access$500((AVOKWebSocketClient)object);
        if (bl2) {
            return;
        }
        AVOKWebSocketClient.access$600(this.this$0);
        object = AVOKWebSocketClient.access$000();
        String string2 = "onFailure";
        ((AVLogger)object).w(string2, throwable);
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onFailure(throwable, c02);
        }
    }

    public void onMessage(f0 object, String string2) {
        object = AVOKWebSocketClient.access$000();
        CharSequence charSequence = new StringBuilder();
        String string3 = "onMessage(text): ";
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        ((AVLogger)object).d((String)charSequence);
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onMessage(string2);
        }
    }

    public void onMessage(f0 object, ByteString byteString) {
        object = byteString.toByteArray();
        object = Messages$GenericCommand.parseFrom((byte[])object);
        Object object2 = AVOKWebSocketClient.access$000();
        CharSequence charSequence = new StringBuilder();
        String string2 = "downLink: ";
        ((StringBuilder)charSequence).append(string2);
        object = ((AbstractMessage)object).toString();
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        try {
            ((AVLogger)object2).d((String)object);
        }
        catch (Exception exception) {
            object = AVOKWebSocketClient.access$000();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("onMessage ");
            charSequence = byteString.utf8();
            ((StringBuilder)object2).append((String)charSequence);
            object2 = ((StringBuilder)object2).toString();
            ((AVLogger)object).d((String)object2);
        }
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onMessage(byteString);
        }
    }

    public void onOpen(f0 object, c0 c02) {
        Object object2 = AVOKWebSocketClient.access$000();
        String string2 = "onOpen";
        object2.d(string2);
        AVOKWebSocketClient.access$102(this.this$0, (f0)object);
        object = this.this$0;
        object2 = AVOKWebSocketClient$Status.CONNECTED;
        AVOKWebSocketClient.access$202((AVOKWebSocketClient)object, (AVOKWebSocketClient$Status)((Object)object2));
        AVOKWebSocketClient.access$300(this.this$0);
        object = AVOKWebSocketClient.access$400(this.this$0);
        if (object != null) {
            object = AVOKWebSocketClient.access$400(this.this$0);
            object.onOpen(c02);
        }
    }
}

