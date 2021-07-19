/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.cache.PersistenceUtil;
import cn.leancloud.codec.MDFive;
import cn.leancloud.core.AVOSCloud;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.io.File;
import java.util.TimeZone;
import java.util.UUID;

public final class AVInstallation
extends AVObject {
    private static final String CHANNELSTAG = "channel";
    public static final String CLASS_NAME = "_Installation";
    private static String DEFAULT_DEVICETYPE;
    private static final String DEVICETYPETAG = "deviceType";
    public static final String INSTALLATION = "installation";
    private static final String INSTALLATIONIDTAG = "installationId";
    private static final AVLogger LOGGER;
    public static final String REGISTRATION_ID = "registrationId";
    private static final String TIMEZONE = "timeZone";
    public static final String VENDOR = "vendor";
    private static volatile AVInstallation currentInstallation;

    static {
        LOGGER = LogUtil.getLogger(AVInstallation.class);
        DEFAULT_DEVICETYPE = "android";
    }

    public AVInstallation() {
        super(CLASS_NAME);
        this.totallyOverwrite = true;
        this.initialize();
        this.endpointClassName = "installations";
    }

    public AVInstallation(AVObject object) {
        Object object2 = ((AVObject)object).getObjectId();
        this.objectId = object2;
        this.acl = object2 = ((AVObject)object).getACL();
        this.serverData = object = ((AVObject)object).getServerData();
        this.totallyOverwrite = true;
        this.endpointClassName = "installations";
    }

    public static void changeDeviceType(String string2) {
        DEFAULT_DEVICETYPE = string2;
    }

    public static AVInstallation createInstanceFromLocal(String object) {
        int n10;
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        object = AVInstallation.getCacheFile();
        Object object5 = AVInstallation.genInstallationId();
        int n11 = 1;
        if (object != null) {
            String string2;
            object4 = LOGGER;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("installation cache file path: ");
            object2 = ((File)object).getAbsolutePath();
            ((StringBuilder)object3).append((String)object2);
            object3 = ((StringBuilder)object3).toString();
            ((AVLogger)object4).d((String)object3);
            bl2 = ((File)object).exists();
            if (!bl2 && (bl2 = ((File)(object2 = new File((String)(object3 = AppConfiguration.getImportantFileDir()), string2 = INSTALLATION))).exists()) && !(bl2 = ((File)object2).renameTo((File)object))) {
                object3 = "failed to rename installation cache file.";
                ((AVLogger)object4).w((String)object3);
            }
            if (bl2 = ((File)object).exists()) {
                object3 = PersistenceUtil.sharedInstance().readContentFromFile((File)object);
                int n12 = StringUtil.isEmpty((String)object3);
                if (n12 == 0) {
                    object4 = "{";
                    n10 = ((String)object3).indexOf((String)object4);
                    if (n10 >= 0) {
                        object4 = AVObject.parseAVObject((String)object3);
                        object4 = (AVInstallation)object4;
                        object4 = currentInstallation = object4;
                        try {
                            ((AVObject)object4).totallyOverwrite = n11;
                        }
                        catch (Exception exception) {
                            object3 = LOGGER;
                            object2 = "failed to parse local installation data.";
                            ((AVLogger)object3).w((String)object2, exception);
                        }
                    } else {
                        n10 = ((String)object3).length();
                        if (n10 == (n12 = AVObject.UUID_LEN)) {
                            object5 = object3;
                        }
                    }
                } else {
                    object3 = "installation cache file is empty, create new instance.";
                    ((AVLogger)object4).d((String)object3);
                }
            }
        }
        if ((object4 = currentInstallation) == null) {
            n10 = 2;
            object4 = new Object[n10];
            bl2 = false;
            object4[0] = object5;
            object4[n11] = object3 = AVInstallation.timezone();
            object4 = String.format("{ \"_version\":\"5\",\"className\":\"_Installation\",\"serverData\":{\"@type\":\"java.util.concurrent.ConcurrentHashMap\",\"deviceType\":\"android\",\"installationId\":\"%s\",\"timeZone\":\"%s\"}}", (Object[])object4);
            PersistenceUtil.sharedInstance().saveContentToFile((String)object4, (File)object);
            object = LOGGER;
            object3 = new StringBuilder();
            object2 = "create-ahead installation with json: ";
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)object4);
            object3 = ((StringBuilder)object3).toString();
            ((AVLogger)object).d((String)object3);
            object = AVObject.parseAVObject((String)object4);
            object = (AVInstallation)object;
            object = currentInstallation = object;
            try {
                ((AVObject)object).totallyOverwrite = n11;
            }
            catch (Exception exception) {
                AVInstallation aVInstallation;
                AVLogger aVLogger = LOGGER;
                object4 = "failed to parse create-ahead installation string.";
                aVLogger.w((String)object4, exception);
                aVInstallation = currentInstallation = (aVInstallation = new AVInstallation());
                aVInstallation.setInstallationId((String)object5);
            }
        }
        return currentInstallation;
    }

    private static String deviceType() {
        return DEFAULT_DEVICETYPE;
    }

    private static String genInstallationId() {
        String string2 = AppConfiguration.getApplicationPackageName();
        String string3 = UUID.randomUUID().toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        return MDFive.computeMD5(stringBuilder.toString());
    }

    private static File getCacheFile() {
        String string2 = AppConfiguration.getImportantFileDir();
        boolean bl2 = StringUtil.isEmpty(string2);
        if (bl2) {
            return null;
        }
        CharSequence charSequence = new StringBuilder();
        String string3 = AVOSCloud.getSimplifiedAppId();
        charSequence.append(string3);
        charSequence.append(INSTALLATION);
        charSequence = charSequence.toString();
        File file = new File(string2, (String)charSequence);
        return file;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static AVInstallation getCurrentInstallation() {
        Object object = currentInstallation;
        if (object != null) return currentInstallation;
        object = AVInstallation.class;
        synchronized (object) {
            Object object2 = currentInstallation;
            if (object2 != null) return currentInstallation;
            object2 = INSTALLATION;
            currentInstallation = object2 = AVInstallation.createInstanceFromLocal((String)object2);
            return currentInstallation;
        }
    }

    public static AVQuery getQuery() {
        AVQuery aVQuery = new AVQuery(CLASS_NAME);
        return aVQuery;
    }

    private void initialize() {
        Object object = currentInstallation;
        String string2 = INSTALLATIONIDTAG;
        if (object != null) {
            object = currentInstallation.getInstallationId();
            this.put(string2, object);
        } else {
            object = AVInstallation.genInstallationId();
            boolean bl2 = StringUtil.isEmpty((String)object);
            if (!bl2) {
                this.put(string2, object);
            }
        }
        object = AVInstallation.deviceType();
        this.put(DEVICETYPETAG, object);
        object = AVInstallation.timezone();
        this.put(TIMEZONE, object);
    }

    private static String timezone() {
        return TimeZone.getDefault().getID();
    }

    public String getInstallationId() {
        return this.getString(INSTALLATIONIDTAG);
    }

    public void onDataSynchronized() {
        super.onDataSynchronized();
        this.updateCurrentInstallationCache();
    }

    public void onSaveSuccess() {
        super.onSaveSuccess();
        this.updateCurrentInstallationCache();
    }

    public void setInstallationId(String string2) {
        this.put(INSTALLATIONIDTAG, string2);
    }

    public void updateCurrentInstallationCache() {
        Object object = currentInstallation;
        if (object == this) {
            object = AVInstallation.getCacheFile();
            String string2 = currentInstallation.toJSONString();
            PersistenceUtil persistenceUtil = PersistenceUtil.sharedInstance();
            persistenceUtil.saveContentToFile(string2, (File)object);
        }
    }
}

