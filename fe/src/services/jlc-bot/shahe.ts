// @ts-ignore
/* eslint-disable */
import { request } from 'umi';

/** 发送沙盒消息 POST /api/sandbox/sendMessage */
export async function sendSandboxMessage(
  body: API.SandboxMessage,
  options?: { [key: string]: any },
) {
  return request<API.RListCmpStepResult>('/api/sandbox/sendMessage', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    data: body,
    ...(options || {}),
  });
}
