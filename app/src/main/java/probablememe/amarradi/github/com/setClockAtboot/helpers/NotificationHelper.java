package probablememe.amarradi.github.com.setClockAtboot.helpers;

import android.annotation.TargetApi;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import probablememe.amarradi.github.com.setClockAtboot.R;

public class NotificationHelper extends ContextWrapper {
    public static final String channel1ID = "Channel1ID";
    public static final String channel1Name ="Channel 1";

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createChannel() {
        NotificationChannel channel = new NotificationChannel(channel1ID, channel1Name, NotificationManager.IMPORTANCE_HIGH);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if(mManager == null) {
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification() {
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setContentTitle("Alarm!")
                .setContentText("Your AlarmManager ist working")
                .setSmallIcon(R.drawable.ic_one);
    }
}
