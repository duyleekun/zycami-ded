/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.me.remote.data;

public class KwaiTokenInfo {
    private String access_token;
    private int expires_in;
    private String open_id;
    private String refresh_token;
    private int result;
    private String token_type;

    public String getAccess_token() {
        return this.access_token;
    }

    public int getExpires_in() {
        return this.expires_in;
    }

    public String getOpen_id() {
        return this.open_id;
    }

    public String getRefresh_token() {
        return this.refresh_token;
    }

    public int getResult() {
        return this.result;
    }

    public String getToken_type() {
        return this.token_type;
    }

    public void setAccess_token(String string2) {
        this.access_token = string2;
    }

    public void setExpires_in(int n10) {
        this.expires_in = n10;
    }

    public void setOpen_id(String string2) {
        this.open_id = string2;
    }

    public void setRefresh_token(String string2) {
        this.refresh_token = string2;
    }

    public void setResult(int n10) {
        this.result = n10;
    }

    public void setToken_type(String string2) {
        this.token_type = string2;
    }
}

