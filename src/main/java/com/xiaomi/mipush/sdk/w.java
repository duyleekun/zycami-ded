/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.ac;
import com.xiaomi.mipush.sdk.s;
import com.xiaomi.mipush.sdk.v;
import com.xiaomi.push.az;
import com.xiaomi.push.y;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class w
implements Runnable {
    public final /* synthetic */ v a;

    public w(v v10) {
        this.a = v10;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        boolean bl2;
        Object object;
        Object object2;
        boolean bl3;
        block15: {
            Serializable serializable;
            block17: {
                block16: {
                    Object object3;
                    CharSequence charSequence;
                    Object object4;
                    Object object5;
                    Object object6;
                    bl3 = false;
                    object2 = null;
                    try {
                        int n10;
                        int n11;
                        int n12;
                        object = this.a;
                        object = v.a((v)object);
                        object = s.a((Context)object);
                        object = ((s)object).a();
                        if (object != null && (n12 = ((ArrayList)object).size()) >= (n11 = 1)) {
                            object6 = this.a;
                            object6 = v.a((v)object6);
                            String string2 = "C100000";
                            object6 = ac.a((Context)object6, string2);
                            string2 = null;
                        } else {
                            object = "no crash file to upload";
                            b.a((String)object);
                            return;
                        }
                        for (n11 = 0; n11 < (n10 = ((ArrayList)object).size()); ++n11) {
                            object5 = ((ArrayList)object).get(n11);
                            object5 = (File)object5;
                            object4 = this.a;
                            object4 = v.a((v)object4);
                            object4 = s.a((Context)object4);
                            object4 = ((s)object4).a((File)object5);
                            charSequence = new StringBuilder();
                            object3 = this.a;
                            object3 = v.a((v)object3);
                            object3 = object3.getFilesDir();
                            ((StringBuilder)charSequence).append(object3);
                            object3 = "/crash";
                            ((StringBuilder)charSequence).append((String)object3);
                            object3 = "/";
                            ((StringBuilder)charSequence).append((String)object3);
                            object3 = ((File)object5).getName();
                            ((StringBuilder)charSequence).append((String)object3);
                            object3 = ".zip";
                            ((StringBuilder)charSequence).append((String)object3);
                            charSequence = ((StringBuilder)charSequence).toString();
                            serializable = new File((String)charSequence);
                        }
                        break block15;
                    }
                    catch (IOException iOException) {
                        serializable = object2;
                        object2 = iOException;
                    }
                    {
                        try {
                            y.a((File)serializable, (File)object5);
                            bl3 = ((File)serializable).exists();
                            if (bl3) {
                                object2 = new StringBuilder();
                                charSequence = "https://api.xmpush.xiaomi.com/upload/crash_log?file=";
                                ((StringBuilder)object2).append((String)charSequence);
                                charSequence = ((File)serializable).getName();
                                ((StringBuilder)object2).append((String)charSequence);
                                object2 = ((StringBuilder)object2).toString();
                                charSequence = "file";
                                az.a((String)object2, (Map)object6, (File)serializable, (String)charSequence);
                                charSequence = new StringBuilder();
                                object3 = this.a;
                                object3 = v.a((v)object3);
                                object3 = object3.getFilesDir();
                                ((StringBuilder)charSequence).append(object3);
                                object3 = "/crash";
                                ((StringBuilder)charSequence).append((String)object3);
                                charSequence = ((StringBuilder)charSequence).toString();
                                object3 = new StringBuilder();
                                ((StringBuilder)object3).append((String)object4);
                                object4 = ":";
                                ((StringBuilder)object3).append((String)object4);
                                object4 = "0";
                                ((StringBuilder)object3).append((String)object4);
                                object4 = ((StringBuilder)object3).toString();
                                object2 = new File((String)charSequence, (String)object4);
                                ((File)object5).renameTo((File)object2);
                                object2 = this.a;
                                v.a((v)object2);
                            } else {
                                object2 = "zip crash file failed";
                                b.a((String)object2);
                            }
                            object2 = serializable;
                            continue;
                        }
                        catch (IOException iOException) {
                            break block16;
                            break;
                        }
                    }
                }
                b.a((Throwable)object2);
                break block17;
                catch (Throwable throwable) {}
            }
            object2 = serializable;
            break block15;
            catch (Throwable throwable) {}
        }
        if (object2 != null && (bl2 = ((File)object2).exists()) && !(bl3 = ((File)object2).delete())) {
            object2 = "delete zip crash file failed";
            b.a((String)object2);
        }
        object2 = v.a();
        synchronized (object2) {
            object = v.a();
            object.notifyAll();
            return;
        }
    }
}

