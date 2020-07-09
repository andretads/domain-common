package br.com.damsete.domain.notifications;

import java.util.Arrays;

public class Notification {

    private final String code;
    private final Object[] args;

    public Notification(String code, Object... args) {
        this.code = code;
        this.args = Arrays.copyOf(args, args.length);
    }

    public String getCode() {
        return code;
    }

    public Object[] getArgs() {
        return Arrays.copyOf(args, args.length);
    }
}
