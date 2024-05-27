package org.fyh.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code; //状态码 0-成功 1-失败
    private String msg;//提示信息
    private T data;//响应数据

    public static <E> Result<E> success(E data) {
        return new Result(0, "success", data);
    }

    public static Result success() {
        return new Result(0, "success", null);
    }

    public static Result error(String msg) {
        return new Result(420, msg, null);
    }


}
