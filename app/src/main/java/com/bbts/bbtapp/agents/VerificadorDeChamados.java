package com.bbts.bbtapp.agents;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.bbts.bbtapp.thread.RecebeGeoLocalizacaoEquipTask;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by wesley on 12/06/17.
 */


public class VerificadorDeChamados  {

    private final Context context;
    private Timer timer;
    private TimerTask task;
    private Handler mTimerHandler = new Handler();


    public VerificadorDeChamados(Context context) {
        this.context = context;

        startTimer();
    }

    private void stopTimer(){
        if(timer != null){
            timer.cancel();
            timer.purge();
        }
    }

    private void startTimer(){
        timer = new Timer();
        task = new TimerTask() {
            public void run() {
                mTimerHandler.post(new Runnable() {
                    public void run(){
                        new RecebeGeoLocalizacaoEquipTask(context, 3L).execute();

                    }
                });
            }
        };

        timer.schedule(task, 1, 5000);
    }


}