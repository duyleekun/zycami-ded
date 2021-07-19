/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.im;

import cn.leancloud.im.SignatureFactory;
import cn.leancloud.im.SystemReporter;

public class AVIMOptions {
    private static final AVIMOptions globalOptions;
    private boolean alwaysRetrieveAllNotification;
    private boolean disableAutoLogin4Push;
    private boolean isAutoOpen;
    private boolean messageQueryCacheEnabled;
    private boolean onlyPushCount;
    private String rtmConnectionServer = "";
    private SignatureFactory signatureFactory = null;
    private SystemReporter systemReporter;
    private int timeoutInSecs = 10;
    private boolean wrapMessageBinaryBufferAsString;

    static {
        AVIMOptions aVIMOptions;
        globalOptions = aVIMOptions = new AVIMOptions();
    }

    private AVIMOptions() {
        boolean bl2;
        this.isAutoOpen = bl2 = true;
        this.messageQueryCacheEnabled = false;
        this.wrapMessageBinaryBufferAsString = false;
        this.systemReporter = null;
        this.alwaysRetrieveAllNotification = false;
        this.disableAutoLogin4Push = false;
        this.onlyPushCount = bl2;
    }

    public static AVIMOptions getGlobalOptions() {
        return globalOptions;
    }

    public String getRtmServer() {
        return this.rtmConnectionServer;
    }

    public SignatureFactory getSignatureFactory() {
        return this.signatureFactory;
    }

    public SystemReporter getSystemReporter() {
        return this.systemReporter;
    }

    public int getTimeoutInSecs() {
        return this.timeoutInSecs;
    }

    public boolean isAlwaysRetrieveAllNotification() {
        return this.alwaysRetrieveAllNotification;
    }

    public boolean isAutoOpen() {
        return this.isAutoOpen;
    }

    public boolean isDisableAutoLogin4Push() {
        return this.disableAutoLogin4Push;
    }

    public boolean isMessageQueryCacheEnabled() {
        return this.messageQueryCacheEnabled;
    }

    public boolean isOnlyPushCount() {
        return this.onlyPushCount;
    }

    public boolean isResetConnectionWhileBroken() {
        return true;
    }

    public boolean isWrapMessageBinaryBufferAsString() {
        return this.wrapMessageBinaryBufferAsString;
    }

    public void setAlwaysRetrieveAllNotification(boolean bl2) {
        this.alwaysRetrieveAllNotification = bl2;
    }

    public void setAutoOpen(boolean bl2) {
        this.isAutoOpen = bl2;
    }

    public void setDisableAutoLogin4Push(boolean bl2) {
        this.disableAutoLogin4Push = bl2;
    }

    public void setMessageQueryCacheEnabled(boolean bl2) {
        this.messageQueryCacheEnabled = bl2;
    }

    public void setResetConnectionWhileBroken(boolean bl2) {
    }

    public void setRtmServer(String string2) {
        this.rtmConnectionServer = string2;
    }

    public void setSignatureFactory(SignatureFactory signatureFactory) {
        this.signatureFactory = signatureFactory;
    }

    public void setSystemReporter(SystemReporter systemReporter) {
        this.systemReporter = systemReporter;
    }

    public void setTimeoutInSecs(int n10) {
        this.timeoutInSecs = n10;
    }

    public void setUnreadNotificationEnabled(boolean bl2) {
        this.onlyPushCount = bl2;
    }
}

