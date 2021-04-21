package com.qmmao.weiweischool.auth.web.restcontroller;

import com.qmmao.weiweischool.model.auth.vo.UserVO;
import com.qmmao.weiweischool.model.constvar.ConstVar;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author DELL
 */
@Controller
public class MasterController {

    protected UserVO getUser(HttpServletRequest request) {
        return (UserVO) request.getAttribute(ConstVar.USERINFO);
    }

    protected UserVO getUserOfRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        UserVO user = getUser(request);
        if (user == null || StringUtils.isEmpty(user.getRealName())) {
            response.sendRedirect("/login");
        }
        return user;
    }
}
