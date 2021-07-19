/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.push;

public class PushEntity$Alert {
    private String body;
    private String title;

    public String getBody() {
        return this.body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setBody(String string2) {
        this.body = string2;
    }

    public void setTitle(String string2) {
        this.title = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Alert{title='");
        String string2 = this.title;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", body='");
        String string3 = this.body;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

