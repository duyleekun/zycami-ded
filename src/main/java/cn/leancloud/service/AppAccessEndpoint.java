/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.service;

import cn.leancloud.core.AVOSService;
import cn.leancloud.service.AppAccessEndpoint$1;
import cn.leancloud.utils.StringUtil;

public class AppAccessEndpoint {
    private String apiServer;
    private String engineServer;
    private String pushServer;
    private String rtmRouterServer;
    private String statsServer;
    private long ttl;

    public void freezeEndpoint(AVOSService aVOSService, String string2) {
        int[] nArray = AppAccessEndpoint$1.$SwitchMap$cn$leancloud$core$AVOSService;
        int n10 = aVOSService.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 == n11) {
                            this.setStatsServer(string2);
                        }
                    } else {
                        this.setRtmRouterServer(string2);
                    }
                } else {
                    this.setPushServer(string2);
                }
            } else {
                this.setEngineServer(string2);
            }
        } else {
            this.setApiServer(string2);
        }
    }

    public String getApiServer() {
        return this.apiServer;
    }

    public String getEngineServer() {
        return this.engineServer;
    }

    public String getPushServer() {
        return this.pushServer;
    }

    public String getRtmRouterServer() {
        return this.rtmRouterServer;
    }

    public String getServerHost(AVOSService object) {
        int[] nArray = AppAccessEndpoint$1.$SwitchMap$cn$leancloud$core$AVOSService;
        int n10 = object.ordinal();
        int n11 = 1;
        object = (n10 = nArray[n10]) != n11 ? (n10 != (n11 = 2) ? (n10 != (n11 = 3) ? (n10 != (n11 = 4) ? (n10 != (n11 = 5) ? "" : this.getStatsServer()) : this.getRtmRouterServer()) : this.getPushServer()) : this.getEngineServer()) : this.getApiServer();
        return object;
    }

    public String getStatsServer() {
        return this.statsServer;
    }

    public long getTtl() {
        return this.ttl;
    }

    public boolean hasSpecifiedEndpoint() {
        String string2 = this.apiServer;
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2 && (bl2 = StringUtil.isEmpty(string2 = this.engineServer)) && (bl2 = StringUtil.isEmpty(string2 = this.pushServer)) && (bl2 = StringUtil.isEmpty(string2 = this.rtmRouterServer))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public void setApiServer(String string2) {
        this.apiServer = string2;
    }

    public void setEngineServer(String string2) {
        this.engineServer = string2;
    }

    public void setPushServer(String string2) {
        this.pushServer = string2;
    }

    public void setRtmRouterServer(String string2) {
        this.rtmRouterServer = string2;
    }

    public void setStatsServer(String string2) {
        this.statsServer = string2;
    }

    public void setTtl(long l10) {
        this.ttl = l10;
    }
}

