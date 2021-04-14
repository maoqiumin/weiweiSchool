package com.qmmao.weiweischool.sercurity.auth.apicontroller;

import com.qmmao.weiweischool.common.util.ApiResponseUtil;
import com.qmmao.weiweischool.common.util.UUIDUtil;
import com.qmmao.weiweischool.common.util.VerifyCodeUtil;
import com.qmmao.weiweischool.model.BaseApiResponse;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import com.qmmao.weiweischool.model.vo.login.ImgVO;
import com.qmmao.weiweischool.sercurity.auth.config.handle.LoginFailureHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginFailureHandler.class);

    @GetMapping("/123")
    public Object login() {
        return "hello world";
    }

    @GetMapping("/getCode")
    public BaseApiResponse<ImgVO> getCode(HttpServletRequest request) {
        /* 生成验证码字符串 */
        String verifyCode = VerifyCodeUtil.generateVerifyCode(ConstVar.NUM_4);
        ImgVO imgVO = new ImgVO();
        imgVO.setUuid(UUIDUtil.generator());
        HttpSession session = request.getSession();
        session.setAttribute(imgVO.getUuid(), verifyCode);
        int w = 111, h = 36;
        try (ByteArrayOutputStream stream = new ByteArrayOutputStream()) {
            VerifyCodeUtil.outputImage(w, h, stream, verifyCode);
            imgVO.setImg(String.format("data:image/gif;base64,%s", Base64Utils.encodeToString(stream.toByteArray())));
        } catch (IOException e) {
            LOGGER.error("获取验证码失败", e);
        }
        return ApiResponseUtil.getResult(imgVO);
    }
}
