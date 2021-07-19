/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.geetest.sdk;

import com.geetest.sdk.GT3Listener;
import com.geetest.sdk.GT3LoadImageView;
import com.geetest.sdk.utils.GT3ServiceNode;
import java.util.Map;
import org.json.JSONObject;

public class GT3ConfigBean {
    private Map GTViewWithParams;
    private JSONObject api1Json;
    private boolean canceledOnTouchOutside;
    private int corners;
    private boolean debug;
    private int dialogOffsetY;
    private GT3ServiceNode gt3ServiceNode;
    private String lang;
    private GT3Listener listener;
    private GT3LoadImageView loadImageView;
    private int pattern;
    private boolean releaseLog;
    private int timeout;
    private boolean unCanceledOnTouchKeyCodeBack;
    private Map userInfo;
    private int webviewTimeout;

    public GT3ConfigBean() {
        int n10;
        this.timeout = n10 = 10000;
        this.webviewTimeout = n10;
        this.debug = false;
        this.pattern = n10 = 1;
        this.releaseLog = n10;
    }

    public JSONObject getApi1Json() {
        return this.api1Json;
    }

    public int getCorners() {
        return this.corners;
    }

    public int getDialogOffsetY() {
        return this.dialogOffsetY;
    }

    public Map getGTViewWithParams() {
        return this.GTViewWithParams;
    }

    public GT3ServiceNode getGt3ServiceNode() {
        return this.gt3ServiceNode;
    }

    public String getLang() {
        return this.lang;
    }

    public GT3Listener getListener() {
        return this.listener;
    }

    public GT3LoadImageView getLoadImageView() {
        return this.loadImageView;
    }

    public int getPattern() {
        return this.pattern;
    }

    public int getTimeout() {
        return this.timeout;
    }

    public Map getUserInfo() {
        return this.userInfo;
    }

    public int getWebviewTimeout() {
        return this.webviewTimeout;
    }

    public boolean isCanceledOnTouchOutside() {
        return this.canceledOnTouchOutside;
    }

    public boolean isReleaseLog() {
        return this.releaseLog;
    }

    public boolean isUnCanceledOnTouchKeyCodeBack() {
        return this.unCanceledOnTouchKeyCodeBack;
    }

    public void setApi1Json(JSONObject jSONObject) {
        this.api1Json = jSONObject;
    }

    public void setCanceledOnTouchOutside(boolean bl2) {
        this.canceledOnTouchOutside = bl2;
    }

    public void setCorners(int n10) {
        this.corners = n10;
    }

    public void setDialogOffsetY(int n10) {
        this.dialogOffsetY = n10;
    }

    public void setGTViewWithParams(Map map) {
        this.GTViewWithParams = map;
    }

    public void setGt3ServiceNode(GT3ServiceNode gT3ServiceNode) {
        this.gt3ServiceNode = gT3ServiceNode;
    }

    public void setLang(String string2) {
        this.lang = string2;
    }

    public void setListener(GT3Listener gT3Listener) {
        this.listener = gT3Listener;
    }

    public void setLoadImageView(GT3LoadImageView gT3LoadImageView) {
        this.loadImageView = gT3LoadImageView;
    }

    public void setPattern(int n10) {
        this.pattern = n10;
    }

    public void setReleaseLog(boolean bl2) {
        this.releaseLog = bl2;
    }

    public void setTimeout(int n10) {
        this.timeout = n10;
    }

    public void setUnCanceledOnTouchKeyCodeBack(boolean bl2) {
        this.unCanceledOnTouchKeyCodeBack = bl2;
    }

    public void setUserInfo(Map map) {
        this.userInfo = map;
    }

    public void setWebviewTimeout(int n10) {
        this.webviewTimeout = n10;
    }
}

