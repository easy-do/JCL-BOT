package plus.easydo.bot.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yomahub.liteflow.context.ContextBean;
import org.springframework.stereotype.Service;
import plus.easydo.bot.constant.OneBotConstants;
import plus.easydo.bot.lowcode.context.ContextBeanDesc;
import plus.easydo.bot.lowcode.context.ContextBeanMethodDesc;
import plus.easydo.bot.service.OneBotApiService;
import plus.easydo.bot.util.OneBotWebSocketUtils;

import java.util.Objects;

/**
 * @author yuzhanfeng
 * @Date 2024-03-31
 * @Description oneBot协议scf-http请求api实现
 */
@Service("websocket_one_bot_api")
@ContextBean("botApi")
@ContextBeanDesc("机器人API")
public class OneBotApiWebSocketServiceImpl implements OneBotApiService {

    private static String sendSocketAwait(String botNumber, String action, JSONObject params) {
        JSONObject message = JSONUtil.createObj();
        String messageId = UUID.fastUUID().toString(true);
        message.set("echo", messageId);
        message.set("action", action);
        if (Objects.nonNull(params)) {
            message.set("params", params);
        }
        return OneBotWebSocketUtils.sendMessageAwaitRes(botNumber, messageId, message.toStringPretty());
    }

    private static void sendSocket(String botNumber, String action, JSONObject params) {
        JSONObject message = JSONUtil.createObj();
        String messageId = UUID.fastUUID().toString(true);
        message.set("echo", messageId);
        message.set("action", action);
        if (Objects.nonNull(params)) {
            message.set("params", params);
        }
        OneBotWebSocketUtils.sendMessage(botNumber, message.toStringPretty());
    }


    @Override
    @ContextBeanMethodDesc("获取登录信息")
    public String getLoginInfo(String botNumber) {
        return sendSocketAwait(botNumber, OneBotConstants.GET_LOGIN_INFO, null);
    }

    @Override
    @ContextBeanMethodDesc("获取群组列表")
    public String getGroupList(String botNumber) {
        JSONObject message = JSONUtil.createObj();
        String messageId = UUID.fastUUID().toString(true);
        message.set("echo", messageId);
        message.set("action", OneBotConstants.GET_GROUP_LIST);
        return OneBotWebSocketUtils.sendMessageAwaitRes(botNumber, messageId, message.toStringPretty());
    }

    @Override
    @ContextBeanMethodDesc("发送群消息")
    public void sendGroupMessage(String botNumber, String groupId, String message) {
        JSONObject body = JSONUtil.createObj();
        body.set("group_id", groupId);
        body.set("message", message);
        body.set("auto_escape", true);
        sendSocket(botNumber, OneBotConstants.SEND_GROUP_MSG, body);
    }

    @Override
    @ContextBeanMethodDesc("发送群文件")
    public void sendGroupFile(String botNumber, String groupId, String filePath) {
        sendGroupMessage(botNumber, groupId, "[CQ=file,url={" + filePath + "}]");
    }

    @Override
    @ContextBeanMethodDesc("撤回消息")
    public void deleteMsg(String botNumber, String messageId) {
        JSONObject body = JSONUtil.createObj();
        body.set("message_id", messageId);
        sendSocket(botNumber, OneBotConstants.DELETE_MSG, body);
    }

    @Override
    @ContextBeanMethodDesc("禁言群组指定成员 duration:时间(分钟) 0代表解除禁言")
    public void setGroupBan(String botNumber, String groupId, String userId, Long duration) {
        JSONObject body = JSONUtil.createObj();
        body.set("group_id", groupId);
        body.set("user_id", userId);
        body.set("duration", duration * 60);
        sendSocket(botNumber, OneBotConstants.SET_GROUP_BAN, body);
    }

    @Override
    @ContextBeanMethodDesc("设置群组全体禁言 duration:时间(分钟) 0代表解除禁言")
    public void setGroupWholeBan(String botNumber, String groupId, boolean enable) {
        JSONObject body = JSONUtil.createObj();
        body.set("group_id", groupId);
        body.set("enable", enable);
        sendSocket(botNumber, OneBotConstants.SET_GROUP_WHOLE_BAN, body);
    }

    @Override
    @ContextBeanMethodDesc("群组踢人 rejectAddRequest:是否加入黑名单")
    public void setGroupKick(String botNumber, String groupId, String userId, boolean rejectAddRequest) {
        JSONObject body = JSONUtil.createObj();
        body.set("group_id", groupId);
        body.set("user_id", userId);
        body.set("reject_add_request", rejectAddRequest);
        sendSocket(botNumber, OneBotConstants.SET_GROUP_KICK, body);
    }
}
