package plus.easydo.bot.websocket.handler;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.json.JSONObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plus.easydo.bot.constant.OneBotConstants;
import plus.easydo.bot.entity.BotNotice;
import plus.easydo.bot.manager.BotNoticeManager;
import plus.easydo.bot.util.OneBotUtils;

/**
 * @author laoyu
 * @version 1.0
 * @description OneBot上报通知处理
 * @date 2024/2/25
 */
@Slf4j
@Service("notice")
@RequiredArgsConstructor
public class OneBotPostNoticeHandler implements OneBotPostHandler {

    private final BotNoticeManager botNoticeManager;

    @Override
    public void handlerPost(JSONObject postData) {
        String noticeType = postData.getStr(OneBotConstants.NOTICE_TYPE);
        String subType = postData.getStr(OneBotConstants.SUB_TYPE);
        String selfId = postData.getStr(OneBotConstants.SELF_ID);
        Object userId = postData.get(OneBotConstants.USER_ID);
        long time = OneBotUtils.getPostTime(postData);
        BotNotice botNotice = BotNotice.builder()
                .noticeType(noticeType)
                .subType(subType)
                .selfUser(selfId)
                .userId(String.valueOf(userId))
                .selfTime(LocalDateTimeUtil.of(time))
                .build();
        botNoticeManager.save(botNotice);
    }
}
