package kr.pah.pcs.yestv.global.common;

import lombok.Getter;

@Getter
public class Result<T> {
    private final T message;
    private final boolean isError;

    public Result(T message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }

    public Result(T message) {
        this.message = message;
        this.isError = false;
    }
}
