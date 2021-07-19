/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.basic.datareport;

public class TXCDRExtInfo {
    public String command_id_comment;
    public boolean report_common;
    public int report_datatime;
    public boolean report_status;
    public String url;

    public TXCDRExtInfo() {
        String string2;
        this.command_id_comment = string2 = "";
        this.url = string2;
        this.report_common = true;
        this.report_status = false;
        this.report_datatime = 0;
    }
}

