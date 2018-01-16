/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;

/**
 *
 * @author G0042204
 */
public class EfikaThread extends Thread {

    private Throwable ex;

    public EfikaThread(Runnable target) {
        super(target);
    }

    @Override
    public void run() {
        Thread.UncaughtExceptionHandler ue = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                setEx(e);
            }
        };
        this.setUncaughtExceptionHandler(ue);
        start();
        System.out.println("Thread: " + Calendar.getInstance().getTime());
        super.run(); //To change body of generated methods, choose Tools | Templates.
    }

    public void possuiException() throws Exception {
        if (ex != null) {
            throw new Exception(ex.getCause());
        }
    }

    public void setEx(Throwable ex) {
        this.ex = ex;
    }

}
