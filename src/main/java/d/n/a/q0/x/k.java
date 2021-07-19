/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.location.LocationManager
 *  android.os.Build$VERSION
 *  android.provider.Settings$Secure
 *  android.provider.Settings$SettingNotFoundException
 */
package d.n.a.q0.x;

import android.content.ContentResolver;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import d.n.a.q0.p;

public class k {
    private final ContentResolver a;
    private final LocationManager b;

    public k(ContentResolver contentResolver, LocationManager locationManager) {
        this.a = contentResolver;
        this.b = locationManager;
    }

    public boolean a() {
        LocationManager locationManager;
        Object object;
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 19;
        if (n10 >= n11) {
            ContentResolver contentResolver = this.a;
            object = "location_mode";
            try {
                n10 = Settings.Secure.getInt((ContentResolver)contentResolver, (String)object);
                if (n10 == 0) {
                    bl2 = false;
                }
                return bl2;
            }
            catch (Settings.SettingNotFoundException settingNotFoundException) {
                object = new Object[]{};
                String string2 = "Could not use LOCATION_MODE check. Falling back to legacy method.";
                p.v(settingNotFoundException, string2, object);
            }
        }
        if ((n10 = (int)((locationManager = this.b).isProviderEnabled((String)(object = "network")) ? 1 : 0)) == 0 && (n10 = (int)((locationManager = this.b).isProviderEnabled((String)(object = "gps")) ? 1 : 0)) == 0) {
            bl2 = false;
        }
        return bl2;
    }
}

