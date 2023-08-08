package com.youlan.common.core.restful.enums;

import com.youlan.common.core.spring.helper.MessageHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum ApiResultCode {
    OK("00000", "OK"),
    WARN("00001", "WARN"),
    ERROR("11111", "ERROR"),

    // ********************** 用户类 **********************
    A0001("A0001", "用户名不存在"),
    A0002("A0002", "用户密码错误"),
    A0003("A0003", "用户未登录"),
    A0004("A0004", "用户权限异常"),
    A0005("A0005", "验证码请求过于频繁,请稍后再试"),
    A0006("A0006", "用户登录超出最大重试次数"),
    A0007("A0007", "验证码校验失败"),
    A0008("A0008", "验证码已过期,请刷新后再试"),
    A0009("A0009", "用户被禁用"),
    A0010("A0010", "验证码信息不存在"),

    // ********************** 功能类 **********************
    B0001("B0001", "文件导出失败"),
    B0002("B0002", "文件导入失败"),
    B0003("B0003", "参数解密失败"),
    B0004("B0004", "无法找到AES秘钥"),

    // ********************** 参数类 **********************
    C0001("C0001", "主键ID不能为空"),
    C0002("C0002", "参数校验失败");

    /**
     * 响应码
     */
    private final String status;

    /**
     * 响应消息
     */
    private final String errorMsg;

    public String getErrorMsg() {
        return MessageHelper.message(this.errorMsg);
    }

    public String getErrorMsg(Object[] args) {
        return MessageHelper.message(this.errorMsg, args);
    }
}