package com.itpvt.notificationstyle;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.RemoteInput;
import android.widget.Toast;

/**
 * Created by Hassan on 10/22/2018.
 */

public class DirectReplyReceiver extends BroadcastReceiver {


    @RequiresApi(api = Build.VERSION_CODES.KITKAT_WATCH)
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle remoteInput = RemoteInput.getResultsFromIntent(intent);
        if (remoteInput != null) {
            CharSequence replyText = remoteInput.getCharSequence("key_text_reply");
            Message answer = new Message(replyText, null);
            MainActivity.MESSAGES.add(answer);

            MainActivity.sendChannel1Notification(context);
        }

    }
}