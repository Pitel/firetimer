package cz.pitel.firetimer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class FireService extends Service {
    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {
        //Log.d("FireService", "onStartCommand");
        final Notification notification = new Notification.Builder(this)
                .setPriority(Notification.PRIORITY_MAX)
                .setCategory(Notification.CATEGORY_ALARM)
                .setVisibility(Notification.VISIBILITY_PUBLIC)
                .setSmallIcon(R.mipmap.ic_whatshot_white_24dp)
                .setContentTitle("Fire")
                .setContentText("You just started a fire")
                .setProgress(0, 0, true)
                .setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, FireActivity.class), 0))
                .addAction(0, "Add log", null)
                .build();
        startForeground(1, notification);
        return START_STICKY;
    }

    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }
}
