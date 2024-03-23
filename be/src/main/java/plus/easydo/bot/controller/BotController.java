package plus.easydo.bot.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import plus.easydo.bot.dto.EnableBotScriptDto;
import plus.easydo.bot.entity.BotInfo;
import plus.easydo.bot.vo.DataResult;
import plus.easydo.bot.vo.R;
import plus.easydo.bot.entity.BotConf;
import plus.easydo.bot.entity.BotMessage;
import plus.easydo.bot.entity.BotNotice;
import plus.easydo.bot.entity.BotRequest;
import plus.easydo.bot.qo.DaBotMessageQo;
import plus.easydo.bot.qo.DaBotNoticeQo;
import plus.easydo.bot.qo.DaBotQo;
import plus.easydo.bot.qo.DaBotRequestQo;
import plus.easydo.bot.service.BotService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * cdk配置 控制层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bot")
public class BotController {

    private final BotService botService;

    /**
     * 分页查询机器人
     *
     * @param daBotQo 分页对象
     * @return 分页对象
     */
    @Operation(summary = "分页查询")
    @SaCheckPermission("platformBot")
    @PostMapping("/page")
    public R<List<BotInfo>> pageBot(@RequestBody DaBotQo daBotQo) {
        return DataResult.ok(botService.pageBot(daBotQo));
    }

    /**
     * 机器人详情
     *
     * @param id id
     * @return vo.plus.easydo.lowcode.bot.R<java.lang.Boolean>
     * @author laoyu
     * @date 2024/2/21
     */
    @Operation(summary = "机器人详情")
    @SaCheckPermission("platformBot")
    @PostMapping("/info/{id}")
    public R<BotInfo> infoBot(@PathVariable("id") Long id) {
        return DataResult.ok(botService.infoBot(id));
    }

    /**
     * 添加机器人配置
     *
     * @param botInfo daCdk
     * @return 分页对象
     */
    @Operation(summary = "添加机器人配置")
    @SaCheckPermission("platformBot.add")
    @PostMapping("/add")
    public R<Boolean> addBot(@RequestBody BotInfo botInfo) {
        return DataResult.ok(botService.addBot(botInfo));
    }

    /**
     * 添加机器人配置
     *
     * @param botInfo daCdk
     * @return 分页对象
     */
    @Operation(summary = "更新机器人配置")
    @SaCheckPermission("platformBot.update")
    @PostMapping("/update")
    public R<Boolean> updateBot(@RequestBody BotInfo botInfo) {
        return DataResult.ok(botService.updateBot(botInfo));
    }


    /**
     * 根据主键删除机器人
     *
     * @param ids 主键集合
     * @return {@code true} 删除成功，{@code false} 删除失败
     */
    @Operation(summary = "删除机器人")
    @SaCheckPermission("platformBot.remove")
    @PostMapping("/remove")
    public R<Boolean> removeBot(@RequestBody List<String> ids) {
        return DataResult.ok(botService.removeBot(ids));
    }

    /**
     * 获取机器人配置
     *
     * @param botNumber botNumber
     * @return vo.plus.easydo.lowcode.bot.R<plus.easydo.bot.entity.BotInfo>
     * @author laoyu
     * @date 2024-02-23
     */
    @Operation(summary = "获取机器人配置")
    @SaCheckPermission("platformBot")
    @GetMapping("/getBotConf/{botNumber}")
    public R<List<BotConf>> getBotConf(@PathVariable("botNumber") String botNumber) {
        return DataResult.ok(botService.getBotConf(botNumber));
    }

    @Operation(summary = "添加机器人配置")
    @SaCheckPermission("platformBot.update")
    @PostMapping("/addBotConf")
    public R<Boolean> addBotConf(@RequestBody BotConf botConf) {
        return DataResult.ok(botService.addBotConf(botConf));
    }

    @Operation(summary = "更新机器人配置")
    @SaCheckPermission("platformBot.update")
    @PostMapping("/updateBotConf")
    public R<Boolean> updateBotConf(@RequestBody BotConf botConf) {
        return DataResult.ok(botService.updateBotConf(botConf));
    }

    @Operation(summary = "删除机器人配置")
    @SaCheckPermission("platformBot.update")
    @GetMapping("/removeBotConf/{id}")
    public R<Boolean> removeBotConf(@PathVariable("id") Long id) {
        return DataResult.ok(botService.removeBotConf(id));
    }

    /**
     * 分页查询消息记录
     *
     * @param daBotMessageQo 分页对象
     * @return 分页对象
     */
    @Operation(summary = "分页查询消息记录")
    @SaCheckPermission("botMessage")
    @PostMapping("/pageBotMessage")
    public R<List<BotMessage>> pageBotMessage(@RequestBody DaBotMessageQo daBotMessageQo) {
        return DataResult.ok(botService.pageBotMessage(daBotMessageQo));
    }

    /**
     * 分页查询请求记录
     *
     * @param daBotRequestQo 分页对象
     * @return 分页对象
     */
    @Operation(summary = "分页查询请求记录")
    @SaCheckPermission("botRequest")
    @PostMapping("/pageBotRequest")
    public R<List<BotRequest>> pageBotRequest(@RequestBody DaBotRequestQo daBotRequestQo) {
        return DataResult.ok(botService.pageBotRequest(daBotRequestQo));
    }

    /**
     * 分页查询通知记录
     *
     * @param daBotNoticeQo 分页对象
     * @return 分页对象
     */
    @Operation(summary = "分页查询通知记录")
    @SaCheckPermission("botNotice")
    @PostMapping("/pageBotNotice")
    public R<List<BotNotice>> pageBotNotice(@RequestBody DaBotNoticeQo daBotNoticeQo) {
        return DataResult.ok(botService.pageBotNotice(daBotNoticeQo));
    }

    /**
     * 开启脚本
     * @param enableBotScriptDto
     * @return
     */
    @Operation(summary = "启用脚本")
    @SaCheckPermission("platformBot.update")
    @PostMapping("/enableBotScript")
    public R<Boolean> enableBotScript(@RequestBody EnableBotScriptDto enableBotScriptDto) {
        return DataResult.ok(botService.enableBotScript(enableBotScriptDto));
    }

    /**
     * 已开启脚本
     *
     * @param id id
     * @return vo.plus.easydo.lowcode.bot.R<java.util.List<java.lang.Long>>
     * @author laoyu
     * @date 2024/2/24
     */
    @Operation(summary = "已开启脚本")
    @SaCheckPermission("platformBot.update")
    @PostMapping("/getEnableBotScript/{id}")
    public R<List<Long>> getEnableBotScript(@PathVariable("id") Long id) {
        return DataResult.ok(botService.getEnableBotScript(id));
    }

}
