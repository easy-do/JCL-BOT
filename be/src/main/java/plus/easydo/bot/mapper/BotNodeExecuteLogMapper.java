package plus.easydo.bot.mapper;

import com.mybatisflex.core.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import plus.easydo.bot.entity.BotNodeExecuteLog;
import plus.easydo.bot.vo.NodePAVo;

import java.util.List;

/**
 * 节点执行日志 映射层。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Mapper
public interface BotNodeExecuteLogMapper extends BaseMapper<BotNodeExecuteLog> {


    List<NodePAVo> nodeExecutePa();

    List<NodePAVo> nodeExecuteTop();

    List<NodePAVo> nodeExecuteMax();
}
