package com.example.rmaiy.talkbox;

/**
 * Created by Rmaiy on 2015/5/10.
 */
public class TalkBox {
    public static final int SEND_MESSAGE = 0;
    public static final int RECEIVE_MESSAGE = 1;
    private int status;
    private String message;

    public TalkBox(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
