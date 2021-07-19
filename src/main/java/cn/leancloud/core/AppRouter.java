/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVLogger;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AVOSCloud$REGION;
import cn.leancloud.core.AVOSService;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.core.AppRouter$1;
import cn.leancloud.core.AppRouter$2;
import cn.leancloud.core.AppRouter$3;
import cn.leancloud.core.AppRouter$4;
import cn.leancloud.json.JSON;
import cn.leancloud.service.AppAccessEndpoint;
import cn.leancloud.service.AppRouterService;
import cn.leancloud.service.RTMConnectionServerResponse;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.o;
import g.p;
import g.u;
import g.z;
import g.z$a;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import k.e$a;
import k.h$a;
import k.s;
import k.s$b;
import k.x.a.g;

public class AppRouter {
    private static final String APP_ROUTER_HOST = "https://app-router.com";
    private static final String DEFAULT_REGION_EAST_CHINA = "lncldapi.com";
    private static final String DEFAULT_REGION_NORTH_AMERICA = "lncldglobal.com";
    private static final String DEFAULT_REGION_NORTH_CHINA = "lncld.net";
    private static final String DEFAULT_SERVER_API;
    private static final String DEFAULT_SERVER_ENGINE;
    private static final String DEFAULT_SERVER_HOST_FORMAT = "https://%s.%s.%s";
    private static final String DEFAULT_SERVER_PUSH;
    private static final String DEFAULT_SERVER_RTM_ROUTER;
    private static final String DEFAULT_SERVER_STAT;
    private static AppRouter INSTANCE;
    private static final AVLogger LOGGER;
    private static final Set NorthAmericaSpecialApps;
    private AppAccessEndpoint customizedEndpoint;
    private AppAccessEndpoint defaultEndpoint = null;
    private volatile s retrofit = null;

    static {
        HashSet<String> hashSet;
        LOGGER = LogUtil.getLogger(AppRouter.class);
        INSTANCE = null;
        DEFAULT_SERVER_API = AVOSService.API.toString();
        DEFAULT_SERVER_STAT = AVOSService.STATS.toString();
        DEFAULT_SERVER_ENGINE = AVOSService.ENGINE.toString();
        DEFAULT_SERVER_PUSH = AVOSService.PUSH.toString();
        DEFAULT_SERVER_RTM_ROUTER = AVOSService.RTM.toString();
        NorthAmericaSpecialApps = hashSet = new HashSet<String>();
        hashSet.add("143mgzglqmg4d0simqtn1zswggcro2ykugj76th8l38u3cm5");
        hashSet.add("18ry1wsn1p7808tagf2ka7sy1omna3nihe45cet0ne4xhg46");
        hashSet.add("7az5r9i0v95acx932a518ygz7mvr26uc7e3xxaq9s389sd2o");
        hashSet.add("8FfQwpvihLHK4htqmtEvkNrv");
        hashSet.add("AjQYwoIyObTeEkD16v1eCq55");
        hashSet.add("E0mVu1VMWrwBodUFWBpWzLNV");
        hashSet.add("J0Ev9alAhaS4IdnxBA95wKgn");
        hashSet.add("Ol0Cw6zL1xP9IIqJpiSv9uYC");
        hashSet.add("W9BCIPx2biwKiKfUvVJtc8kF");
        hashSet.add("YHE5exCaW7UolMFJUtHvXTUY");
        hashSet.add("glvame9g0qlj3a4o29j5xdzzrypxvvb30jt4vnvm66klph4r");
        hashSet.add("iuuztdrr4mj683kbsmwoalt1roaypb5d25eu0f23lrfsthgn");
        hashSet.add("kekxwm8uz1wtgxzvv5kitsgsammjcx4lcgm5b159qia5rqo5");
        hashSet.add("msjqtclsfmfeznwvm29dqvuwddt3cqmziszf0rjddxho8eis");
        hashSet.add("nHptjiXlt3g8mcraXYRDpYFT");
        hashSet.add("nf3udjhnnsbe99qg04j7oslck4w1yp2geewcy1kp6wskbu5w");
        hashSet.add("pFcwt2MaALYf70POa7bIqe0J");
        hashSet.add("q3er6vs0dkawy15skjeuktf7l4eam438wn5jkts2j7fpf2y3");
        hashSet.add("tsvezhhlefbdj1jbkohynipehgtpk353sfonvbtlyxaraqxy");
        hashSet.add("wnDg0lPt0wcYGJSiHRwHBhD4");
    }

    public AppRouter() {
        Object object = new AppAccessEndpoint();
        this.customizedEndpoint = object;
        object = new z$a();
        Object object2 = TimeUnit.SECONDS;
        object = ((z$a)object).k(15, (TimeUnit)((Object)object2));
        long l10 = 10;
        object = ((z$a)object).j0(l10, (TimeUnit)((Object)object2)).R0(l10, (TimeUnit)((Object)object2));
        object = ((z$a)object).c((u)object2);
        super();
        object = ((z$a)object).q((p)object2).f();
        super();
        object2 = ((s$b)object2).c(APP_ROUTER_HOST);
        Object object3 = AppConfiguration.getRetrofitConverterFactory();
        object2 = ((s$b)object2).b((h$a)object3);
        object3 = g.d();
        this.retrofit = object = ((s$b)object2).a((e$a)object3).j((z)object).f();
    }

    public static /* synthetic */ AVLogger access$000() {
        return LOGGER;
    }

    public static /* synthetic */ AppAccessEndpoint access$100(AppRouter appRouter) {
        return appRouter.defaultEndpoint;
    }

    public static /* synthetic */ AppAccessEndpoint access$102(AppRouter appRouter, AppAccessEndpoint appAccessEndpoint) {
        appRouter.defaultEndpoint = appAccessEndpoint;
        return appAccessEndpoint;
    }

    private e.a.z fetchRTMServerFromRemote(String string2, String string3, String object, int n10) {
        Object object2;
        Object object3 = LOGGER;
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("fetchRTMServerFromRemote. router=");
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append(", appId=");
        ((StringBuilder)object4).append(string3);
        String string4 = ", installationId=";
        ((StringBuilder)object4).append(string4);
        ((StringBuilder)object4).append((String)object);
        object4 = ((StringBuilder)object4).toString();
        ((AVLogger)object3).d((String)object4);
        object3 = this.retrofit.i().c(string2).f();
        object4 = AppRouterService.class;
        object3 = (AppRouterService)((s)object3).g((Class)object4);
        object = object3.getRTMConnectionServer(string3, (String)object, n10);
        n10 = (int)(AppConfiguration.isAsynchronized() ? 1 : 0);
        if (n10 != 0) {
            object2 = b.d();
            object = ((e.a.z)object).L5((h0)object2);
        }
        if ((object2 = AppConfiguration.getDefaultScheduler()) != null) {
            object2 = object2.create();
            object = ((e.a.z)object).i4((h0)object2);
        }
        object2 = new AppRouter$3(this, string3, string2);
        return ((e.a.z)object).H3((o)object2);
    }

    private e.a.z fetchServerFromRemote(String object, AVOSService aVOSService) {
        object = this.fetchServerHostsInBackground((String)object);
        AppRouter$1 appRouter$1 = new AppRouter$1(this, aVOSService);
        return ((e.a.z)object).H3(appRouter$1);
    }

    public static AVOSCloud$REGION getAppRegion(String string2) {
        AVOSCloud$REGION aVOSCloud$REGION;
        Object object = AVOSCloud.getRegion();
        if (object != (aVOSCloud$REGION = AVOSCloud$REGION.NorthChina)) {
            return AVOSCloud.getRegion();
        }
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return aVOSCloud$REGION;
        }
        object = "-MdYXbMMI";
        bl2 = string2.endsWith((String)object);
        if (!bl2 && !(bl2 = (object = NorthAmericaSpecialApps).contains(string2))) {
            object = "-9Nh9j0Va";
            boolean bl3 = string2.endsWith((String)object);
            if (bl3) {
                return AVOSCloud$REGION.EastChina;
            }
            return aVOSCloud$REGION;
        }
        return AVOSCloud$REGION.NorthAmerica;
    }

    private e.a.z getEndpoint(String object, AVOSService object2, boolean object3) {
        int n10;
        Object object4;
        int n11;
        int n12 = StringUtil.isEmpty((String)object);
        Object object5 = "";
        if (n12) {
            LOGGER.e("application id is empty.");
            return e.a.z.t3(object5);
        }
        n12 = ((String)object).length();
        if (n12 <= (n11 = 8)) {
            object2 = LOGGER;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("application id is invalid(too short):");
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            ((AVLogger)object2).e((String)object);
            return e.a.z.t3(object5);
        }
        String string2 = this.customizedEndpoint.getServerHost((AVOSService)((Object)object2));
        n11 = (int)(StringUtil.isEmpty(string2) ? 1 : 0);
        if (!n11) {
            return e.a.z.t3(string2);
        }
        if (object3 != 0) {
            return this.fetchServerFromRemote((String)object, (AVOSService)((Object)object2));
        }
        Object object6 = this.defaultEndpoint;
        n12 = 1;
        n11 = 0;
        String string3 = null;
        if (object6 == null) {
            object6 = AppConfiguration.getDefaultSetting();
            if (object6 != null) {
                String string4 = this.getPersistenceKeyZone((String)object, n12 != 0);
                object6 = object6.getString(string4, (String)object, (String)object5);
            } else {
                object3 = 0;
                object6 = null;
            }
            boolean bl2 = StringUtil.isEmpty((String)object6);
            if (!bl2) {
                long l10;
                object5 = AppAccessEndpoint.class;
                this.defaultEndpoint = object6 = (AppAccessEndpoint)JSON.parseObject((String)object6, (Class)object5);
                long l11 = System.currentTimeMillis() / 1000L;
                long l12 = l11 - (l10 = ((AppAccessEndpoint)(object6 = this.defaultEndpoint)).getTtl());
                object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object3 > 0) {
                    this.defaultEndpoint = null;
                }
            }
            if ((object6 = this.defaultEndpoint) == null) {
                this.defaultEndpoint = object = this.buildDefaultEndpoint((String)object);
            }
        }
        if ((object4 = (object = (Object)AppRouter$4.$SwitchMap$cn$leancloud$core$AVOSService)[n10 = ((Enum)object2).ordinal()]) != n12) {
            n10 = 2;
            if (object4 != n10) {
                n10 = 3;
                if (object4 != n10) {
                    n10 = 4;
                    if (object4 != n10) {
                        n10 = 5;
                        if (object4 == n10) {
                            object = this.defaultEndpoint;
                            string3 = ((AppAccessEndpoint)object).getStatsServer();
                        }
                    } else {
                        object = this.defaultEndpoint;
                        string3 = ((AppAccessEndpoint)object).getRtmRouterServer();
                    }
                } else {
                    object = this.defaultEndpoint;
                    string3 = ((AppAccessEndpoint)object).getPushServer();
                }
            } else {
                object = this.defaultEndpoint;
                string3 = ((AppAccessEndpoint)object).getEngineServer();
            }
        } else {
            object = this.defaultEndpoint;
            string3 = ((AppAccessEndpoint)object).getApiServer();
        }
        object4 = StringUtil.isEmpty(string3);
        if (object4 == false && (object4 = (Object)string3.startsWith((String)(object = "http"))) == false) {
            object = new StringBuilder();
            object2 = "https://";
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(string3);
            string3 = ((StringBuilder)object).toString();
        }
        return e.a.z.t3(string3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AppRouter getInstance() {
        Object object = INSTANCE;
        if (object != null) return INSTANCE;
        object = AppRouter.class;
        synchronized (object) {
            AppRouter appRouter = INSTANCE;
            if (appRouter != null) return INSTANCE;
            INSTANCE = appRouter = new AppRouter();
            return INSTANCE;
        }
    }

    public AppAccessEndpoint buildDefaultEndpoint(String object) {
        int n10;
        int n11;
        if (object != null && (n11 = ((String)object).length()) > (n10 = 8)) {
            Object object2;
            AppAccessEndpoint appAccessEndpoint = new AppAccessEndpoint();
            String string2 = ((String)object).substring(0, n10).toLowerCase();
            object = AppRouter.getAppRegion((String)object);
            Object[] objectArray = AppRouter$4.$SwitchMap$cn$leancloud$core$AVOSCloud$REGION;
            int n12 = ((Enum)object).ordinal();
            n12 = objectArray[n12];
            int n13 = 3;
            int n14 = 2;
            int n15 = 1;
            if (n12 != n15) {
                if (n12 != n14) {
                    if (n12 != n13) {
                        object = LOGGER;
                        object2 = "Invalid region";
                        ((AVLogger)object).w((String)object2);
                        object = "";
                    } else {
                        object = DEFAULT_REGION_NORTH_AMERICA;
                    }
                } else {
                    object = DEFAULT_REGION_EAST_CHINA;
                }
            } else {
                object = DEFAULT_REGION_NORTH_CHINA;
            }
            object2 = new Object[n13];
            object2[0] = string2;
            String string3 = DEFAULT_SERVER_API;
            object2[n15] = string3;
            object2[n14] = object;
            string3 = DEFAULT_SERVER_HOST_FORMAT;
            object2 = String.format(string3, object2);
            appAccessEndpoint.setApiServer((String)object2);
            object2 = new Object[n13];
            object2[0] = string2;
            String string4 = DEFAULT_SERVER_ENGINE;
            object2[n15] = string4;
            object2[n14] = object;
            object2 = String.format(string3, object2);
            appAccessEndpoint.setEngineServer((String)object2);
            object2 = new Object[n13];
            object2[0] = string2;
            string4 = DEFAULT_SERVER_PUSH;
            object2[n15] = string4;
            object2[n14] = object;
            object2 = String.format(string3, object2);
            appAccessEndpoint.setPushServer((String)object2);
            object2 = new Object[n13];
            object2[0] = string2;
            string4 = DEFAULT_SERVER_RTM_ROUTER;
            object2[n15] = string4;
            object2[n14] = object;
            object2 = String.format(string3, object2);
            appAccessEndpoint.setRtmRouterServer((String)object2);
            objectArray = new Object[n13];
            objectArray[0] = (int)string2;
            string2 = DEFAULT_SERVER_STAT;
            objectArray[n15] = (int)string2;
            objectArray[n14] = (int)object;
            object = String.format(string3, objectArray);
            appAccessEndpoint.setStatsServer((String)object);
            long l10 = System.currentTimeMillis() / 1000L + 36000L;
            appAccessEndpoint.setTtl(l10);
            return appAccessEndpoint;
        }
        return null;
    }

    public e.a.z fetchRTMConnectionServer(String string2, String string3, String string4, int n10, boolean bl2) {
        block10: {
            Object object;
            String string5;
            SystemSetting systemSetting;
            block9: {
                if (bl2 || (systemSetting = AppConfiguration.getDefaultSetting()) == null) break block10;
                string5 = null;
                object = this.getPersistenceKeyZone(string3, false);
                Object object2 = "";
                int n11 = StringUtil.isEmpty((String)(object = systemSetting.getString((String)object, string2, (String)object2)));
                if (n11 != 0) break block10;
                object2 = RTMConnectionServerResponse.class;
                object = JSON.parseObject((String)object, (Class)object2);
                object = (RTMConnectionServerResponse)object;
                long l10 = System.currentTimeMillis();
                long l11 = 1000L;
                l10 /= l11;
                l11 = ((RTMConnectionServerResponse)object).getTtl();
                n11 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (n11 <= 0) break block9;
                object = this.getPersistenceKeyZone(string3, false);
                systemSetting.removeKey((String)object, string2);
                object = null;
            }
            if (object == null) break block10;
            try {
                return e.a.z.t3(object);
            }
            catch (Exception exception) {
                string5 = this.getPersistenceKeyZone(string3, false);
                systemSetting.removeKey(string5, string2);
            }
        }
        return this.fetchRTMServerFromRemote(string2, string3, string4, n10);
    }

    public e.a.z fetchServerHostsInBackground(String string2) {
        Object object = this.retrofit;
        Object object2 = AppRouterService.class;
        object = ((AppRouterService)((s)object).g((Class)object2)).getRouter(string2);
        boolean bl2 = AppConfiguration.isAsynchronized();
        if (bl2) {
            object2 = b.d();
            object = ((e.a.z)object).L5((h0)object2);
        }
        if ((object2 = AppConfiguration.getDefaultScheduler()) != null) {
            object2 = object2.create();
            object = ((e.a.z)object).i4((h0)object2);
        }
        object2 = new AppRouter$2(this, string2);
        return ((e.a.z)object).H3((o)object2);
    }

    public void freezeEndpoint(AVOSService aVOSService, String string2) {
        this.customizedEndpoint.freezeEndpoint(aVOSService, string2);
    }

    public e.a.z getEndpoint(String string2, AVOSService aVOSService) {
        return this.getEndpoint(string2, aVOSService, false);
    }

    public String getPersistenceKeyZone(String string2, boolean bl2) {
        if (bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("com.avos.avoscloud.approuter.");
            stringBuilder.append(string2);
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("com.avos.push.router.server.cache");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public boolean hasFrozenEndpoint() {
        return this.customizedEndpoint.hasSpecifiedEndpoint();
    }
}

