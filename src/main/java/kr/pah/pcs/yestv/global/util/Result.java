package kr.pah.pcs.yestv.global.util;

import lombok.Data;
import lombok.Getter;

@Getter
public class Result<T> {
    private final T message;
    private final boolean isError;

    public Result(T message, boolean isError) {
        this.message = message;
        this.isError = isError;
    }
}
