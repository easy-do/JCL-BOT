package plus.easydo.bot.service.impl;


import com.mybatisflex.core.paginate.Page;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.spring.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import plus.easydo.bot.service.IDaGameConfigService;
import plus.easydo.bot.entity.DaGameConfig;
import plus.easydo.bot.manager.CacheManager;
import plus.easydo.bot.mapper.DaGameConfigMapper;
import plus.easydo.bot.qo.DaGameConfigQo;

import java.util.List;

import static plus.easydo.bot.entity.table.DaGameConfigTableDef.DA_GAME_CONFIG;


/**
 * 游戏配置 服务层实现。
 *
 * @author mybatis-flex-helper automatic generation
 * @since 1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DaGameConfigServiceImpl extends ServiceImpl<DaGameConfigMapper, DaGameConfig> implements IDaGameConfigService {



    @Override
    public Page<DaGameConfig> confPage(DaGameConfigQo gameConfigQo) {
        QueryWrapper query = query()
                .and(DA_GAME_CONFIG.CONF_NAME.like(gameConfigQo.getConfName())
                        .and(DA_GAME_CONFIG.CONF_KEY.like(gameConfigQo.getConfKey())));
        return page(new Page<>(gameConfigQo.getCurrent(), gameConfigQo.getPageSize()), query);
    }

    @Override
    public boolean saveConf(DaGameConfig daGameConfig) {
        boolean result = save(daGameConfig);
        if(result){
            cacheGameConf();
        }
        return result;
    }

    @Override
    public boolean updateConf(DaGameConfig daGameConfig) {
        boolean result = updateById(daGameConfig);
        if(result){
            cacheGameConf();
        }
        return result;
    }

    @Override
    public DaGameConfig getByConfKey(String confKey) {
        QueryWrapper query = query().and(DA_GAME_CONFIG.CONF_KEY.eq(confKey));
        return getOne(query);
    }


    @Override
    public void cacheGameConf() {
        log.info("初始化缓存游戏配置 start");
        List<DaGameConfig> confList  = list();
        CacheManager.GAME_CONF_LIST.clear();
        CacheManager.GAME_CONF_LIST.addAll(confList);
        confList.forEach(conf-> CacheManager.GAME_CONF_MAP.put(conf.getConfKey(),conf));
        log.info("初始化缓存游戏配置 end");
    }
}
