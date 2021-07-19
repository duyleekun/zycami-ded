/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.ServiceConnection
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.Parcel
 *  android.os.RemoteException
 *  android.os.SystemClock
 *  android.text.TextUtils
 */
package com.mob.commons.b;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mob.commons.b.c;
import com.mob.commons.b.f$a;
import com.mob.commons.b.f$b;
import com.mob.commons.b.f$c;

public abstract class f {
    public Context a;
    public String b;
    private boolean c = false;
    private boolean d = false;
    private String e = null;
    private String f = null;
    private String g = null;
    private String h = null;

    public f(Context object) {
        this.a = object;
        object = object.getPackageName();
        this.b = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private long a(Intent object) {
        synchronized (this) {
            long l10 = SystemClock.elapsedRealtime();
            try {
                f$c f$c = this.c();
                if (f$c == null) {
                    f$c = this.a;
                    f$c = this.a((Context)f$c, (Intent)object);
                }
                if (f$c != null) {
                    String string2;
                    String string3;
                    String string4;
                    String string5;
                    boolean bl2;
                    this.d = bl2 = f$c.a;
                    this.e = string5 = f$c.b;
                    this.f = string4 = f$c.c;
                    this.g = string3 = f$c.d;
                    this.h = string2 = f$c.e;
                }
            }
            catch (Throwable throwable) {
                c c10 = com.mob.commons.b.c.a();
                c10.a(throwable);
            }
            long l11 = SystemClock.elapsedRealtime() - l10;
            c c11 = com.mob.commons.b.c.a();
            StringBuilder stringBuilder = new StringBuilder();
            String string6 = "usedTime: ";
            stringBuilder.append(string6);
            stringBuilder.append(l11);
            String string7 = stringBuilder.toString();
            c11.a(string7);
            return l11;
        }
    }

    private f$c a(Context object, Intent object2) {
        Object object3;
        Object object4 = Looper.myLooper();
        if (object4 != (object3 = Looper.getMainLooper())) {
            StringBuilder stringBuilder;
            block28: {
                block27: {
                    object4 = new f$b(this, null);
                    object3 = " failed!";
                    if (object2 != null) {
                        int n10 = 1;
                        n10 = (int)(object.bindService(object2, (ServiceConnection)object4, n10) ? 1 : 0);
                        if (n10 == 0) break block27;
                        long l10 = this.d();
                        Object object5 = ((f$b)object4).a(l10);
                        if (object5 != null) {
                            object2 = this.a((IBinder)object5);
                            return object2;
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        String string2 = "get binder ";
                        stringBuilder2.append(string2);
                        object2 = object2.getComponent();
                        stringBuilder2.append(object2);
                        stringBuilder2.append((String)object3);
                        object2 = stringBuilder2.toString();
                        object5 = new Throwable((String)object2);
                        throw object5;
                    }
                }
                stringBuilder = new StringBuilder();
                String string3 = "bind service ";
                stringBuilder.append(string3);
                if (object2 != null) break block28;
                object2 = "null";
            }
            object2 = object2.getComponent();
            stringBuilder.append(object2);
            stringBuilder.append((String)object3);
            object2 = stringBuilder.toString();
            try {
                Throwable throwable = new Throwable((String)object2);
                throw throwable;
            }
            finally {
                try {
                    object.unbindService((ServiceConnection)object4);
                }
                catch (Throwable throwable) {
                    object4 = com.mob.commons.b.c.a();
                    ((c)object4).a(throwable);
                }
            }
        }
        object = new Throwable("unable to invoke in main thread!");
        throw object;
    }

    private long j() {
        synchronized (this) {
            block6: {
                boolean bl2 = this.c;
                if (!bl2) break block6;
                return -1;
            }
            Intent intent = this.a();
            long l10 = this.a(intent);
            boolean bl3 = true;
            this.c = bl3;
            return l10;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int a(String string2, IBinder iBinder, String object, int n10) {
        void var1_5;
        void var6_15;
        int n11;
        Parcel parcel;
        block33: {
            block35: {
                block34: {
                    Parcel parcel2;
                    block32: {
                        parcel = null;
                        parcel2 = Parcel.obtain();
                        parcel = Parcel.obtain();
                        parcel2.writeInterfaceToken((String)object);
                        iBinder.transact(n10, parcel2, parcel, 0);
                        parcel.readException();
                        n11 = parcel.readInt();
                        if (parcel == null) break block32;
                        parcel.recycle();
                    }
                    if (parcel2 != null) {
                        parcel2.recycle();
                    }
                    return n11;
                    catch (Throwable throwable) {
                        break block33;
                    }
                    catch (RemoteException remoteException) {
                        iBinder = parcel;
                        parcel = parcel2;
                        break block34;
                    }
                    catch (Throwable throwable) {
                        Object var6_11 = null;
                        break block33;
                    }
                    catch (RemoteException remoteException) {
                        iBinder = null;
                    }
                }
                object = com.mob.commons.b.c.a();
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "getIntValue: ";
                stringBuilder.append(string3);
                stringBuilder.append(string2);
                string2 = " failed! (remoteException)";
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                ((c)object).a(string2);
                if (iBinder == null) break block35;
                try {
                    iBinder.recycle();
                }
                catch (Throwable throwable) {
                    return 0;
                }
            }
            if (parcel != null) {
                parcel.recycle();
            }
            return 0;
            catch (Throwable throwable) {
                Parcel parcel3 = parcel;
                parcel = iBinder;
            }
        }
        if (parcel != null) {
            parcel.recycle();
        }
        if (var6_15 != null) {
            var6_15.recycle();
        }
        throw var1_5;
        catch (Throwable throwable) {
            return n11;
        }
        catch (Throwable throwable) {
            throw var1_5;
        }
    }

    public Intent a() {
        return null;
    }

    public f$c a(IBinder iBinder) {
        return null;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public String a(String string2, IBinder iBinder, String object, int n10, String ... object2) {
        Parcel parcel;
        Parcel parcel2;
        block37: {
            block36: {
                block35: {
                    parcel2 = Parcel.obtain();
                    parcel = Parcel.obtain();
                    parcel2.writeInterfaceToken((String)object);
                    object = null;
                    if (object2 == null) break block35;
                    int n11 = ((String[])object2).length;
                    if (n11 <= 0) break block35;
                    n11 = ((String[])object2).length;
                    for (int i10 = 0; i10 < n11; ++i10) {
                        String string3 = object2[i10];
                        parcel2.writeString(string3);
                        continue;
                    }
                }
                iBinder.transact(n10, parcel2, parcel, 0);
                parcel.readException();
                string2 = parcel.readString();
                if (parcel == null) break block36;
                try {
                    parcel.recycle();
                }
                catch (Throwable throwable) {
                    return string2;
                }
            }
            if (parcel2 != null) {
                parcel2.recycle();
            }
            return string2;
            catch (Throwable throwable) {}
            break block37;
            catch (Throwable throwable) {
                parcel = null;
                break block37;
            }
            catch (Throwable throwable) {
                parcel2 = null;
                parcel = null;
            }
        }
        try {
            void var2_7;
            object = com.mob.commons.b.c.a();
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "getStringValue: ";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            string2 = " failed! ";
            stringBuilder.append(string2);
            string2 = var2_7.getMessage();
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            ((c)object).a(string2);
            return null;
        }
        finally {
            if (parcel != null) {
                parcel.recycle();
            }
            if (parcel2 != null) {
                parcel2.recycle();
            }
        }
    }

    public void a(String string2) {
        synchronized (this) {
            this.e = string2;
            return;
        }
    }

    public String b() {
        synchronized (this) {
            this.j();
            String string2 = this.f;
            return string2;
        }
    }

    public void b(String string2) {
        synchronized (this) {
            this.f = string2;
            return;
        }
    }

    public f$c c() {
        return null;
    }

    public void c(String string2) {
        synchronized (this) {
            this.h = string2;
            return;
        }
    }

    public long d() {
        return 2500L;
    }

    public String e() {
        synchronized (this) {
            this.j();
            String string2 = this.e;
            return string2;
        }
    }

    public String f() {
        synchronized (this) {
            this.j();
            String string2 = this.g;
            return string2;
        }
    }

    public String g() {
        synchronized (this) {
            this.j();
            String string2 = this.h;
            return string2;
        }
    }

    public boolean h() {
        synchronized (this) {
            this.j();
            boolean bl2 = this.d;
            return bl2;
        }
    }

    public String i() {
        CharSequence charSequence = this.b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            charSequence = "";
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("0x1008611");
            String string2 = this.b;
            ((StringBuilder)charSequence).append(string2);
            string2 = "0xdzfdweiwu";
            ((StringBuilder)charSequence).append(string2);
            charSequence = f$a.a(((StringBuilder)charSequence).toString());
        }
        return charSequence;
    }
}

