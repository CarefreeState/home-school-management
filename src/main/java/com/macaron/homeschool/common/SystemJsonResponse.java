package com.macaron.homeschool.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.macaron.homeschool.common.enums.GlobalServiceStatusCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;


@NoArgsConstructor
@Getter
public class SystemJsonResponse<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonInclude
    private int code;

    @JsonInclude
    private String message;

    @JsonInclude
    private T data;

    private SystemJsonResponse(int code, String msg, T data) {
        this.code = code;
        Optional.ofNullable(msg).ifPresent(m -> this.message = m);
        Optional.ofNullable(data).ifPresent(d -> this.data = d);
    }

    private SystemJsonResponse(int code, String msg) {
        this(code, msg, null);
    }

    /**
     * 成功信息返回, 无数据
     * {@link GlobalServiceStatusCode#SYSTEM_SUCCESS}
     *
     * @return 成功状态码
     */
    public static SystemJsonResponse SYSTEM_SUCCESS() {
        return new SystemJsonResponse(GlobalServiceStatusCode.SYSTEM_SUCCESS.getCode(),
                GlobalServiceStatusCode.SYSTEM_SUCCESS.getMessage());
    }

    /**
     * 成功信息返回
     * {@link GlobalServiceStatusCode#SYSTEM_SUCCESS}
     *
     * @param data 返回时带上的数据
     * @return 成功状态码以及数据
     */
    public static <E> SystemJsonResponse<E> SYSTEM_SUCCESS(E data) {
        return new SystemJsonResponse<>(GlobalServiceStatusCode.SYSTEM_SUCCESS.getCode(),
                GlobalServiceStatusCode.SYSTEM_SUCCESS.getMessage(), data);
    }

    /**
     * 错误信息返回
     * {@link GlobalServiceStatusCode#SYSTEM_SERVICE_FAIL}
     *
     * @return SystemJsonResponse
     */
    public static SystemJsonResponse SYSTEM_FAIL() {
        return new SystemJsonResponse(GlobalServiceStatusCode.SYSTEM_SERVICE_FAIL.getCode(),
                GlobalServiceStatusCode.SYSTEM_SERVICE_FAIL.getMessage());
    }

    /**
     * 系统异常返回
     * {@link GlobalServiceStatusCode#SYSTEM_SERVICE_ERROR}
     *
     * @return SystemJsonResponse
     */
    public static SystemJsonResponse SERVICE_ERROR() {
        return new SystemJsonResponse(GlobalServiceStatusCode.SYSTEM_SERVICE_ERROR.getCode(),
                GlobalServiceStatusCode.SYSTEM_SERVICE_ERROR.getMessage());
    }

    /**
     * 系统异常返回, 自定义code
     * {@link GlobalServiceStatusCode#SYSTEM_SERVICE_ERROR}
     *
     * @param code 自定义状态码 {@link GlobalServiceStatusCode}
     * @return code对应的错误信息
     */
    public static SystemJsonResponse CUSTOMIZE_ERROR(GlobalServiceStatusCode code) {
        return new SystemJsonResponse(code.getCode(), code.getMessage());
    }

    /**
     * 系统异常返回, 自定义code
     * {@link GlobalServiceStatusCode#SYSTEM_SERVICE_ERROR}
     *
     * @param code 自定义状态码 {@link GlobalServiceStatusCode}
     * @param msg 自定义异常信息
     * @return code对应的错误信息
     */
    public static SystemJsonResponse CUSTOMIZE_MSG_ERROR(GlobalServiceStatusCode code, String msg) {
        return new SystemJsonResponse(code.getCode(), Optional.ofNullable(msg).orElseGet(code::getMessage));
    }

}