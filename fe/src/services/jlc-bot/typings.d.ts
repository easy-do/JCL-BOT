declare namespace API {
  type BotConf = {
    id?: number;
    botNumber?: string;
    platform?: string;
    confKey?: string;
    confValue?: string;
    remark?: string;
  };

  type BotEventScript = {
    id?: number;
    scriptName?: string;
    eventType?: string;
    scriptType?: string;
    scriptContent?: string;
    remark?: string;
  };

  type BotEventScriptQo = {
    current?: number;
    pageSize?: number;
    scriptName?: string;
    eventType?: string;
    scriptType?: string;
    remark?: string;
  };

  type BotInfo = {
    id?: number;
    botNumber?: string;
    botSecret?: string;
    remark?: string;
    botUrl?: string;
    lastHeartbeatTime?: string;
    extData?: string;
  };

  type BotMessage = {
    id?: number;
    messageId?: string;
    groupId?: string;
    sendUser?: string;
    selfUser?: string;
    selfTime?: string;
    message?: string;
  };

  type BotMessageQo = {
    current?: number;
    pageSize?: number;
    messageId?: string;
    groupId?: string;
    sendUser?: string;
    selfUser?: string;
    selfTime?: string;
    message?: string;
  };

  type BotNodeDto = {
    id?: number;
    eventType?: string;
    confName?: string;
    nodes?: Record<string, any>;
    nodeConf?: Record<string, any>;
  };

  type BotNotice = {
    id?: number;
    noticeType?: string;
    subType?: string;
    selfUser?: string;
    groupId?: string;
    operatorId?: string;
    userId?: string;
    selfTime?: string;
    messageId?: string;
  };

  type BotNoticeQo = {
    current?: number;
    pageSize?: number;
    noticeType?: string;
    subType?: string;
    selfUser?: string;
    groupId?: string;
    operatorId?: string;
    userId?: string;
    selfTime?: string;
    messageId?: string;
  };

  type BotQo = {
    current?: number;
    pageSize?: number;
    botNumber?: string;
    remark?: string;
    botType?: string;
    botUrl?: string;
  };

  type BotRequest = {
    id?: number;
    requestType?: string;
    groupId?: string;
    sendUser?: string;
    selfUser?: string;
    selfTime?: string;
    comment?: string;
    flag?: string;
  };

  type BotRequestQo = {
    current?: number;
    pageSize?: number;
    requestType?: string;
    groupId?: string;
    sendUser?: string;
    selfUser?: string;
    selfTime?: string;
    comment?: string;
    flag?: string;
  };

  type CurrentUser = {
    userName?: string;
    menu?: Record<string, any>[];
    resource?: Record<string, any>[];
    mode?: string;
  };

  type DebugBotNodeDto = {
    id?: number;
    params?: Record<string, any>;
  };

  type EnableBotScriptDto = {
    botId?: number;
    scriptIds?: number[];
  };

  type getBotConfParams = {
    botNumber: string;
  };

  type getBotNodeParams = {
    id: number;
  };

  type getConfInfoParams = {
    id: Record<string, any>;
  };

  type getEnableBotScriptParams = {
    id: number;
  };

  type getNodeConfParams = {
    id: number;
  };

  type getSysNodeInfoParams = {
    id: Record<string, any>;
  };

  type infoBotParams = {
    id: number;
  };

  type infoBotScriptParams = {
    id: number;
  };

  type JSONConfig = {
    keyComparator?: Record<string, any>;
    ignoreError?: boolean;
    ignoreCase?: boolean;
    dateFormat?: string;
    ignoreNullValue?: boolean;
    transientSupport?: boolean;
    stripTrailingZeros?: boolean;
    checkDuplicate?: boolean;
    order?: boolean;
  };

  type LoginDto = {
    userName: string;
    password: string;
  };

  type LowCodeNodeConf = {
    id?: number;
    confData?: string;
    confName?: string;
    nodeData?: string;
    eventType?: string;
    createTime?: string;
    updateTime?: string;
    deleteFlag?: boolean;
  };

  type LowCodeSysNode = {
    id?: number;
    nodeName?: string;
    groupType?: string;
    nodeCode?: string;
    nodeColor?: string;
    nodeIcon?: string;
    nodePort?: string;
    maxSize?: number;
    formData?: string;
    remark?: string;
    deleteFlag?: boolean;
  };

  type NodeExecuteResult = {
    nodeId?: string;
    nodeName?: string;
    nodeCode?: string;
    data?: Record<string, any>;
    message?: string;
    status?: number;
    executeTime?: number;
    paramsJson?: { raw?: Record<string, any>; config?: JSONConfig; empty?: boolean };
  };

  type NodePAVo = {
    nodeName?: string;
    confName?: string;
    executeTime?: number;
  };

  type PageQo = {
    current?: number;
    pageSize?: number;
  };

  type RBoolean = {
    code?: number;
    data?: boolean;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RBotEventScript = {
    code?: number;
    data?: BotEventScript;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RBotInfo = {
    code?: number;
    data?: BotInfo;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RBotNodeDto = {
    code?: number;
    data?: BotNodeDto;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RCurrentUser = {
    code?: number;
    data?: CurrentUser;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type removeBotConfParams = {
    id: number;
  };

  type removeNodeConfParams = {
    id: number;
  };

  type removeSysNodeParams = {
    id: Record<string, any>;
  };

  type RListBotConf = {
    code?: number;
    data?: BotConf[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListBotEventScript = {
    code?: number;
    data?: BotEventScript[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListBotInfo = {
    code?: number;
    data?: BotInfo[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListBotMessage = {
    code?: number;
    data?: BotMessage[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListBotNotice = {
    code?: number;
    data?: BotNotice[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListBotRequest = {
    code?: number;
    data?: BotRequest[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListLong = {
    code?: number;
    data?: number[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListLowCodeNodeConf = {
    code?: number;
    data?: LowCodeNodeConf[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListLowCodeSysNode = {
    code?: number;
    data?: LowCodeSysNode[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListNodeExecuteResult = {
    code?: number;
    data?: NodeExecuteResult[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RListSystemConf = {
    code?: number;
    data?: SystemConf[];
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RLong = {
    code?: number;
    data?: number;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RLowCodeSysNode = {
    code?: number;
    data?: LowCodeSysNode;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RMapStringListLowCodeSysNode = {
    code?: number;
    data?: Record<string, any>;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RMapStringListNodePAVo = {
    code?: number;
    data?: Record<string, any>;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RObject = {
    code?: number;
    data?: Record<string, any>;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RString = {
    code?: number;
    data?: string;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type RSystemConf = {
    code?: number;
    data?: SystemConf;
    message?: string;
    errorMessage?: string;
    success?: boolean;
    total?: number;
  };

  type SetBotNodeDto = {
    botId?: number;
    confIdList?: number[];
  };

  type SystemConf = {
    id?: number;
    confName?: string;
    confType?: number;
    confData?: string;
    confKey?: string;
    remark?: string;
    isSystemConf?: boolean;
  };

  type SystemConfigQo = {
    current?: number;
    pageSize?: number;
    confName?: string;
    confType?: number;
    confKey?: string;
  };
}
