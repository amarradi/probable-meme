package probablememe.amarradi.github.com.setClockAtboot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import probablememe.amarradi.github.com.setClockAtboot.helpers.NotificationHelper;

public class AlertReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper notfificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notfificationHelper.getChannelNotification();
        notfificationHelper.getManager().notify(1, nb.build());
    }
}
