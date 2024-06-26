// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 添加机器人 POST /api/bot/add */
export async function addBot(body: API.BotInfo, options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/add', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 添加机器人配置 POST /api/bot/addBotConf */
export async function addBotConf(body: API.BotConf, options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/addBotConf', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 清空消息记录 GET /api/bot/cleanBotMessage */
export async function cleanBotMessage(options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/cleanBotMessage', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 清空通知记录 GET /api/bot/cleanBotNotice */
export async function cleanBotNotice(options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/cleanBotNotice', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 清空请求记录 GET /api/bot/cleanBotRequest */
export async function cleanBotRequest(options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/cleanBotRequest', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 获取机器人配置 GET /api/bot/getBotConf/${param0} */
export async function getBotConf(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.getBotConfParams,
  options?: { [key: string]: any },
) {
  const { botNumber: param0, ...queryParams } = params;
  return request<API.RListBotConf>(`/api/bot/getBotConf/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 机器人详情 GET /api/bot/info/${param0} */
export async function infoBot(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.infoBotParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.RBotInfo>(`/api/bot/info/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 所有bot列表 GET /api/bot/list */
export async function listBot(options?: { [key: string]: any }) {
  return request<API.RListBotInfo>('/api/bot/list', {
    method: 'GET',
    ...(options || {}),
  });
}

/** 分页查询 POST /api/bot/page */
export async function pageBot(body: API.BotQo, options?: { [key: string]: any }) {
  return request<API.RListBotInfo>('/api/bot/page', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页查询消息记录 POST /api/bot/pageBotMessage */
export async function pageBotMessage(body: API.BotMessageQo, options?: { [key: string]: any }) {
  return request<API.RListBotMessage>('/api/bot/pageBotMessage', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页查询通知记录 POST /api/bot/pageBotNotice */
export async function pageBotNotice(body: API.BotNoticeQo, options?: { [key: string]: any }) {
  return request<API.RListBotNotice>('/api/bot/pageBotNotice', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 分页查询请求记录 POST /api/bot/pageBotRequest */
export async function pageBotRequest(body: API.BotRequestQo, options?: { [key: string]: any }) {
  return request<API.RListBotRequest>('/api/bot/pageBotRequest', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 删除机器人 POST /api/bot/remove */
export async function removeBot(body: string[], options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/remove', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 删除机器人配置 GET /api/bot/removeBotConf/${param0} */
export async function removeBotConf(
  // 叠加生成的Param类型 (非body参数swagger默认没有生成对象)
  params: API.removeBotConfParams,
  options?: { [key: string]: any },
) {
  const { id: param0, ...queryParams } = params;
  return request<API.RBoolean>(`/api/bot/removeBotConf/${param0}`, {
    method: 'GET',
    params: { ...queryParams },
    ...(options || {}),
  });
}

/** 更新机器人 POST /api/bot/update */
export async function updateBot(body: API.BotInfo, options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/update', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}

/** 更新机器人配置 POST /api/bot/updateBotConf */
export async function updateBotConf(body: API.BotConf, options?: { [key: string]: any }) {
  return request<API.RBoolean>('/api/bot/updateBotConf', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
