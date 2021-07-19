/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

public class AVIMOperationQueue$Operation {
    public String conversationId;
    public String identifier;
    public int operation;
    public int requestId;
    public String sessionId;

    public static AVIMOperationQueue$Operation getOperation(int n10, String string2, String string3, int n11) {
        AVIMOperationQueue$Operation aVIMOperationQueue$Operation = new AVIMOperationQueue$Operation();
        aVIMOperationQueue$Operation.conversationId = string3;
        aVIMOperationQueue$Operation.sessionId = string2;
        aVIMOperationQueue$Operation.operation = n10;
        aVIMOperationQueue$Operation.requestId = n11;
        return aVIMOperationQueue$Operation;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String string2) {
        this.identifier = string2;
    }
}

