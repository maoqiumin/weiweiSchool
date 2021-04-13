package com.qmmao.weiweischool.sercurity.auth.apicontroller;

import com.qmmao.weiweischool.common.util.ApiResponseUtil;
import com.qmmao.weiweischool.common.util.UUIDUtil;
import com.qmmao.weiweischool.common.util.VerifyCodeUtil;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author DELL
 */
@RestController
public class MainController {
    @GetMapping("/123")
    public Object login() {
        return "hello world";
    }

    @GetMapping("/getCode")
    public Object getCode(HttpServletRequest request) {
        /* 生成验证码字符串 */
        String verifyCode = VerifyCodeUtil.generateVerifyCode(ConstVar.NUM_4);
        String uuid = UUIDUtil.generator();
        HttpSession session = request.getSession();
        session.setAttribute(uuid, verifyCode);
        int w = 111, h = 36;
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            VerifyCodeUtil.outputImage(w, h, stream, verifyCode);

            return ApiResponseUtil.getResult(customer);
            return new BaseResult(ReturnCode.SUCCESS.getCode(), ReturnCode.SUCCESS.getMessage(), new ImgVO("data:image/gif;base64," + Base64Utils.encodeToString(stream.toByteArray()), uuid));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
