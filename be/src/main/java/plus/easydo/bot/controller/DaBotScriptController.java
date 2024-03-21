package plus.easydo.bot.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaMode;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import plus.easydo.bot.vo.DataResult;
import plus.easydo.bot.vo.R;
import plus.easydo.bot.entity.DaBotEventScript;
import plus.easydo.bot.qo.DaBotEventScriptQo;
import plus.easydo.bot.service.BotScriptService;

import java.util.List;

/**
 * cdk配置 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/botScript")
public class DaBotScriptController {

    private final BotScriptService botScriptService;

    /**
     * 分页查询机器人脚本
     *
     * @param daBotEventScriptQo daBotEventScriptQo
     * @return 分页对象
     */
    @Operation(summary = "分页查询")
    @SaCheckPermission("botScript")
    @PostMapping("/page")
    public R<List<DaBotEventScript>> pageBotScript(@RequestBody DaBotEventScriptQo daBotEventScriptQo) {
        return DataResult.ok(botScriptService.pageBotScript(daBotEventScriptQo));
    }

    /**
     * 所有脚本列表
     *
     * @return vo.plus.easydo.lowcode.bot.R<java.util.List<plus.easydo.bot.entity.DaBotEventScript>>
     * @author laoyu
     * @date 2024/2/24
     */
    @Operation(summary = "所有脚本列表")
    @SaCheckPermission(mode=SaMode.OR,value = {"botScript","platformBot"})
    @GetMapping("/botScriptList")
    public R<List<DaBotEventScript>> botScriptList() {
        return DataResult.ok(botScriptService.botScriptList());
    }

    /**
     * 机器人脚本详情
     *
     * @param id id
     * @return vo.plus.easydo.lowcode.bot.R<java.lang.Boolean>
     * @author laoyu
     * @date 2024/2/21
     */
    @Operation(summary = "机器人脚本详情")
    @SaCheckPermission("botScript")
    @PostMapping("/info/{id}")
    public R<DaBotEventScript> infoBotScript(@PathVariable("id") Long id) {
        return DataResult.ok(botScriptService.infoBotScript(id));
    }

    /**
     * 添加机器人脚本配置
     *
     * @param daBotEventScript daCdk
     * @return 分页对象
     */
    @Operation(summary = "添加机器人脚本配置")
    @SaCheckPermission("botScript.add")
    @PostMapping("/add")
    public R<Boolean> addBotScript(@RequestBody DaBotEventScript daBotEventScript) {
        return DataResult.ok(botScriptService.addBotScript(daBotEventScript));
    }

    /**
     * 添加机器人脚本配置
     *
     * @param daBotEventScript daCdk
     * @return 分页对象
     */
    @Operation(summary = "更新机器人脚本配置")
    @SaCheckPermission("botScript.update")
    @PostMapping("/update")
    public R<Boolean> updateBotScript(@RequestBody DaBotEventScript daBotEventScript) {
        return DataResult.ok(botScriptService.updateBotScript(daBotEventScript));
    }


    /**
     * 根据主键删除机器人脚本
     *
     * @param ids 主键集合
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @Operation(summary = "删除机器人脚本")
    @SaCheckPermission("botScript.remove")
    @PostMapping("/remove")
    public R<Boolean> removeBotScript(@RequestBody List<String> ids) {
        return DataResult.ok(botScriptService.removeBotScript(ids));
    }

}
