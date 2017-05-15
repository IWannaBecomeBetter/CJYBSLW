package com.bs.common.entity;


import com.bs.common.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by fusj on 16/3/2.
 */
public class BaseController {

    private static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /**
     * 后台管理VM路径
     */
    protected static final String MANAGER_VM_ROOT = "/manager/%s";

    /**
     * 后台管理common路径
     */
    protected static final String PHONE_VM_ROOT = "/common/%s";

    /**
     * 异常处理
     * @param request
     * @param ex
     * @return
     * @throws Exception
     */
    @ExceptionHandler
    public String doHandle(HttpServletRequest request, Exception ex) throws Exception {

        logger.error(ex.getMessage(), ex);

        request.setAttribute("ex", ex);

        if (request.getHeader("x-requested-with") != null) {
            throw ex;
        }

        return "error/500";
    }

    /**
     * ajax请求异常返回
     * @param ex
     * @return
     */
    protected ResultBean ajaxException(Exception ex) {
        logger.error(ex.getMessage(), ex);

        ResultBean resultBean = new ResultBean(false);

        if(ex instanceof ApplicationException) {
            resultBean.setMsg(ex.getMessage());
        } else {
            resultBean.setMsg("系统出错了");
        }

        return resultBean;
    }

}
