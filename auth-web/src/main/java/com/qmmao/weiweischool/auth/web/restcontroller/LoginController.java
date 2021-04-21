package com.qmmao.weiweischool.auth.web.restcontroller;

import com.qmmao.weiweischool.auth.web.config.RsaKeyProperties;
import com.qmmao.weiweischool.common.util.ApiResponseUtil;
import com.qmmao.weiweischool.common.util.UUIDUtil;
import com.qmmao.weiweischool.common.util.login.JwtUtil;
import com.qmmao.weiweischool.common.util.login.VerifyCodeUtil;
import com.qmmao.weiweischool.model.BaseApiResponse;
import com.qmmao.weiweischool.model.auth.dto.AccountInfoDTO;
import com.qmmao.weiweischool.model.auth.form.LoginForm;
import com.qmmao.weiweischool.model.auth.vo.ImgVO;
import com.qmmao.weiweischool.model.auth.vo.UserVO;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import com.qmmao.weiweischool.model.enums.AccountStatusEnum;
import com.qmmao.weiweischool.model.enums.ResponseCodeEnum;
import com.qmmao.weiweischool.service.servicemanger.user.UserService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Base64Utils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author DELL
 */
@RestController
@Api(tags = {"登陆接口"})
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private RsaKeyProperties prop;

    @Autowired
    private UserService userService;

    @GetMapping("/123")
    public Object test() {
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

    @PostMapping("/login")
    @ResponseBody
    public BaseApiResponse<String> login(@RequestBody LoginForm loginForm, HttpServletRequest request, HttpServletResponse response) {
        //校验验证码是否正确
        String captcha = loginForm.getCaptcha();
        String code = (String) request.getSession().getAttribute(request.getParameter(loginForm.getUuid()));
        LOGGER.info("获取提交的code:【{}】", captcha);
        LOGGER.info("获取保存的code:【{}】", code);
        if (StringUtils.isEmpty(captcha) || !captcha.equalsIgnoreCase(code)) {
            return ApiResponseUtil.getFail(ResponseCodeEnum.CODEFAIL);
        }
        request.getSession().removeAttribute(request.getParameter("uuid"));
        //校验密码与账号是否匹配根据登陆名查询 todo 支持手机号
        AccountInfoDTO accountInfo = userService.findUserByUsername(loginForm.getLoginName());
        if (accountInfo == null || StringUtils.isEmpty(accountInfo.getAccountCode())) {
            return ApiResponseUtil.getFail(ResponseCodeEnum.ACCOUNTFAIL);
        }
        if (AccountStatusEnum.CLOSE.getCode().equals(accountInfo.getStatus())) {
            //封号提醒
            return ApiResponseUtil.getFail("封号中，详情咨询官方客服");
        }
        UserVO userVO = new UserVO(accountInfo);
        //生成JWT token返回
        String token = JwtUtil.generateTokenExpireInMinutes(userVO, prop.getPrivateKey(), 24 * 60);
        response.addHeader(ConstVar.AUTHORIZATION, String.format("%s %s", ConstVar.BEARER, token));
        return ApiResponseUtil.getResult("登录成功");
    }
}
