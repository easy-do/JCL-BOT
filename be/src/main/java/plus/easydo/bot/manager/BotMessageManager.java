package plus.easydo.bot.manager;


import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import org.springframework.stereotype.Component;
import plus.easydo.bot.entity.BotMessage;
import plus.easydo.bot.mapper.BotMessageMapper;
import plus.easydo.bot.qo.BotMessageQo;

import static plus.easydo.bot.entity.table.BotMessageTableDef.BOT_MESSAGE;

/**
 * 消息记录 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Component
public class BotMessageManager extends ServiceImpl<BotMessageMapper, BotMessage> {

    public boolean clean() {
        QueryWrapper query = query().where("1=1");
        return remove(query);
    }

    public Page<BotMessage> pageBotMessage(BotMessageQo botMessageQo) {
        QueryWrapper queryWrapper = query();
        queryWrapper.where(BOT_MESSAGE.MESSAGE_ID.eq(botMessageQo.getMessageId()));
        queryWrapper.where(BOT_MESSAGE.GROUP_ID.eq(botMessageQo.getGroupId()));
        queryWrapper.where(BOT_MESSAGE.SEND_USER.eq(botMessageQo.getSendUser()));
        queryWrapper.where(BOT_MESSAGE.SELF_USER.eq(botMessageQo.getSelfUser()));
        queryWrapper.where(BOT_MESSAGE.MESSAGE.like(botMessageQo.getMessage()));
        queryWrapper.where(BOT_MESSAGE.MESSAGE_FORMAT.eq(botMessageQo.getMessageFormat()));
        queryWrapper.orderBy(BOT_MESSAGE.SELF_TIME.desc());
        return page(new Page<>(botMessageQo.getCurrent(), botMessageQo.getPageSize()), queryWrapper);

    }
}
