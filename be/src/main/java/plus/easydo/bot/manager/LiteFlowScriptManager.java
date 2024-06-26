package plus.easydo.bot.manager;


import cn.hutool.core.text.CharSequenceUtil;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import com.yomahub.liteflow.core.FlowExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import plus.easydo.bot.constant.LiteFlowConstants;
import plus.easydo.bot.constant.LowCodeConstants;
import plus.easydo.bot.entity.HighLevelDevelopConf;
import plus.easydo.bot.entity.LiteFlowScript;
import plus.easydo.bot.entity.LowCodeSysNode;
import plus.easydo.bot.entity.SimpleCmdDevelopConf;
import plus.easydo.bot.entity.WebhooksConf;
import plus.easydo.bot.exception.BaseException;
import plus.easydo.bot.mapper.LiteFlowScriptMapper;

import static plus.easydo.bot.entity.table.LiteFlowScriptTableDef.LITE_FLOW_SCRIPT;

/**
 * liteflow脚本节点 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Service
@RequiredArgsConstructor
public class LiteFlowScriptManager extends ServiceImpl<LiteFlowScriptMapper, LiteFlowScript> {

    @Value("${spring.application.name:jlc-bot}")
    private String applicationName;

    private final FlowExecutor flowExecutor;

    public void createData(LowCodeSysNode lowCodeSysNode) {
        LiteFlowScript entity = LiteFlowScript.builder()
                .id(lowCodeSysNode.getId())
                .applicationName(applicationName)
                .scriptId(lowCodeSysNode.getNodeCode())
                .scriptName(lowCodeSysNode.getNodeName())
                .scriptType("script")
                .scriptLanguage("java")
                .scriptData("")
                .enable(true)
                .build();
        buildScriptData(lowCodeSysNode, entity);
        boolean res = save(entity);
        if (res) {
            try {
                flowExecutor.reloadRule();
            }catch (Exception e) {
                removeById(entity.getId());
                throw e;
            }
        }
    }

    public LiteFlowScript createData(HighLevelDevelopConf highLevelDevelopConf) {
        LiteFlowScript entity = LiteFlowScript.builder()
                .applicationName(applicationName)
                .scriptId(LowCodeConstants.HIGH_LEVEL_DEVELOP+highLevelDevelopConf.getId())
                .scriptName(highLevelDevelopConf.getConfName())
                .scriptLanguage(highLevelDevelopConf.getScriptLanguage())
                .scriptType("script")
                .scriptData(LiteFlowConstants.SCRIPT_DATA_MAP.get(highLevelDevelopConf.getScriptLanguage()))
                .enable(true)
                .build();
        boolean res = save(entity);
        if (res) {
            try {
                flowExecutor.reloadRule();
                return entity;
            }catch (Exception e) {
                removeById(entity.getId());
                throw e;
            }
        }
        return null;
    }

    public LiteFlowScript createData(SimpleCmdDevelopConf simpleCmdDevelopConf) {
        LiteFlowScript entity = LiteFlowScript.builder()
                .applicationName(applicationName)
                .scriptId(LowCodeConstants.SIMPLE_CMD_DEVELOP + simpleCmdDevelopConf.getId())
                .scriptName(simpleCmdDevelopConf.getConfName())
                .scriptType("script")
                .scriptLanguage(simpleCmdDevelopConf.getScriptLanguage())
                .scriptData(LiteFlowConstants.SCRIPT_DATA_MAP.get(simpleCmdDevelopConf.getScriptLanguage()))
                .enable(true)
                .build();
        boolean res = save(entity);
        if (res) {
            try {
                flowExecutor.reloadRule();
                return entity;
            } catch (Exception e) {
                removeById(entity.getId());
                throw e;
            }
        }
        return null;
    }

    public LiteFlowScript createData(WebhooksConf webhooksConf) {
        LiteFlowScript entity = LiteFlowScript.builder()
                .applicationName(applicationName)
                .scriptId(LowCodeConstants.WEBHOOKS + webhooksConf.getId())
                .scriptName(webhooksConf.getConfName())
                .scriptType("script")
                .scriptLanguage(webhooksConf.getScriptLanguage())
                .scriptData(LiteFlowConstants.SCRIPT_DATA_MAP.get(webhooksConf.getScriptLanguage()))
                .enable(true)
                .build();
        boolean res = save(entity);
        if (res) {
            try {
                flowExecutor.reloadRule();
                return entity;
            }catch (Exception e) {
                removeById(entity.getId());
                throw e;
            }
        }
        return null;
    }

    private void buildScriptData(LowCodeSysNode lowCodeSysNode, LiteFlowScript liteFlowScript) {
        boolean nodeType = CharSequenceUtil.containsAny(lowCodeSysNode.getNodeCode(), "if", "If");
        liteFlowScript.setScriptType(nodeType ? LiteFlowConstants.IF_SCRIPT : LiteFlowConstants.SCRIPT);
        liteFlowScript.setScriptData(nodeType ? LiteFlowConstants.JAVA_IF_SCRIPT_DATA : LiteFlowConstants.JAVA_SCRIPT_DATA);
    }

    public boolean updateScriptData(LiteFlowScript liteFlowScript) {
        LiteFlowScript oldScript = getById(liteFlowScript.getId());
        boolean res = updateById(liteFlowScript);
        if (res) {
            try {
                flowExecutor.reloadRule();
            }catch (Exception e) {
                updateById(oldScript);
                throw new BaseException(e.getMessage());
            }
        }
        return res;
    }

    public void removeByScriptId(String id) {
        QueryWrapper query = query().where(LITE_FLOW_SCRIPT.SCRIPT_ID.eq(id));
        remove(query);
        flowExecutor.reloadRule();
    }

    public LiteFlowScript getByScriptId(String id) {
        QueryWrapper query = query().where(LITE_FLOW_SCRIPT.SCRIPT_ID.eq(id));
        return getOne(query);
    }

}


