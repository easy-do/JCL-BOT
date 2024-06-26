import React, { useRef } from 'react';
import { PageContainer } from '@ant-design/pro-layout';
import type { ProColumns, ActionType } from '@ant-design/pro-table';
import ProTable from '@ant-design/pro-table';
import { useAccess } from 'umi';
import { pageBotMessage } from '@/services/jlc-bot/jiqiren';

const botMessage: React.FC = () => {
  
  const actionRef = useRef<ActionType>();
  const access = useAccess();

  /** 国际化配置 */

  const columns: ProColumns<API.BotMessage>[] = [
    {
      title: '消息id',
      dataIndex: 'messageId',
    },
    {
      title: '群组',
      dataIndex: 'groupId',
    },
    {
      title: '发送人',
      dataIndex: 'sendUser',
    },
    {
      title: '接收bot',
      dataIndex: 'selfUser',
    },
    {
      title: '接收时间',
      search: false,
      dataIndex: 'selfTime',
    },
    {
      title: '消息格式',
      dataIndex: 'messageFormat',
      ellipsis: true,
    },
    {
      title: '消息',
      dataIndex: 'message',
      ellipsis: true,
    },
    {
      title: '操作',
      dataIndex: 'option',
      valueType: 'option',
      render: (_, record) => [
      ],
    },
  ];

  return (
    <PageContainer>
      <ProTable<API.BotMessage, API.RListBotMessage>
        headerTitle="历史消息"
        actionRef={actionRef}
        rowKey="id"
        search={{
          labelWidth: 120,
        }}
        pagination={{
          defaultPageSize: 10,
          showSizeChanger: true,
        }}
        request={pageBotMessage}
        columns={columns}
      />
    </PageContainer>
  );
};

export default botMessage;
