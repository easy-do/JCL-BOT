package plus.easydo.bot.config;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.SaTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import plus.easydo.bot.exception.BaseException;
import plus.easydo.bot.vo.DataResult;
import plus.easydo.bot.vo.R;

import java.util.Objects;

/**
 * 全局异常处理器
 *
 * @author ruoyi
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     *
     * @param e e
     * @return R R
     */
    @ExceptionHandler(BaseException.class)
    public R<Object> baseException(BaseException e) {
        return DataResult.fail(e.getMessage());
    }


    /**
     * 功能描述
     *
     * @param e e
     * @return plus.easydo.core.result.R
     * @author laoyu
     */
    @ExceptionHandler(Exception.class)
    public R<Object> handleException(Exception e) {
        log.error(e.getMessage(), e);
        return DataResult.fail(e.getMessage());
    }

    /**
     * 自定义验证异常
     *
     * @param e e
     * @return plus.easydo.core.result.R
     * @author laoyu
     */
    @ExceptionHandler(BindException.class)
    public R<Object> validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return DataResult.fail(message);
    }

    /**
     * 自定义验证异常
     *
     * @param e e
     * @return java.lang.Object
     * @author laoyu
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R<Object> validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message;
        message = Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage();
        return DataResult.fail(message);
    }

    /**
     * 自定义验证异常
     *
     * @param e e
     * @return java.lang.Object
     * @author laoyu
     */
    @ExceptionHandler(SaTokenException.class)
    public R<Object> authException(SaTokenException e) {
        return DataResult.fail(HttpStatus.UNAUTHORIZED, e.getMessage());
    }

    /**
     * 自定义验证异常
     *
     * @param e e
     * @return java.lang.Object
     * @author laoyu
     */
    @ExceptionHandler(NotLoginException.class)
    public R<Object> notLoginException(NotLoginException e) {
        return DataResult.fail(HttpStatus.UNAUTHORIZED, "未登录，或授权过期");
    }

    /**
     * 自定义验证异常
     *
     * @param e e
     * @return java.lang.Object
     * @author laoyu
     */
    @ExceptionHandler(NotPermissionException.class)
    public R<Object> notLoginException(NotPermissionException e) {
        return DataResult.fail(HttpStatus.UNAUTHORIZED, "无接口权限");
    }

    /**
     * 基础异常
     *
     * @param e e
     * @return R R
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public R<Object> illegalArgumentException(IllegalArgumentException e) {
        return DataResult.fail(e.getMessage());
    }

}
