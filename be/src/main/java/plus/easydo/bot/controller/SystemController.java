package plus.easydo.bot.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import plus.easydo.bot.config.SystemConfig;
import plus.easydo.bot.enums.SysTemModeEnum;


/**
 * @author yuzhanfeng
 * @Date 2023-12-26
 * @Description 系统相关接口
 */
@RestController
@Tag(name = "系统")
@RequiredArgsConstructor
@RequestMapping("/api/sys")
public class SystemController {

    private final SystemConfig systemConfig;

    @Operation(summary = "获取当前版本")
    @GetMapping("/version")
    public String version() {
        return systemConfig.getCurrentVersion();
    }

    @Operation(summary = "获取当前模式")
    @GetMapping("/mode")
    public String mode() {
        return SysTemModeEnum.getDescByMode(systemConfig.getMode());
    }
}
