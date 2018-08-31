# [Welcome to 95hx kafka notebook](https://github.com/95hx/kafka-demo) 





### _**apis**_

![](z-resource/kafka-apis.png)

#### 特点

* producer:发布一个消息到多个topic
* consumer:消费一个或流式的消息
* connector:捕获每一个改变,从topic存取消息
* stream processors:流式处理多个topic的消息,更有效的输入输出流转换








### _**log_anatomy**_

![](z-resource/log_anatomy.png)

#### 特点

* 抽象的流record分类
* 硬盘的存取速度约等于内存
* 队列形式的消息持久化
* 便捷的横向扩展与主从备份







### _**consumer-groups**_

![](z-resource/consumer-groups.png)

#### 特点

* 同一partition的顺序保证
* 同一消费组对partition异步的读取
* 伸缩性的消费者集群
* 消费者死亡时的任务转移
* 广播或者组形式的消费
* 故障容忍最多可达N-1服务器
* 在一个使用者组中不能有比分区更多的使用者实例








### _**log_consumer**_

![](z-resource/log_consumer.png)

#### 特点

* 每个记录由一个键、一个值和一个时间戳组成
* 偏移量惟一地标识分区中的每个记录
* follower被动地复制了leader
* 支持生产者确认发送成功
* 不同磁盘结构相同出色的表现
* 低延时流水线式的多功能消息驱动






### _**zookeeper_register_center**_

![](z-resource/zookeeper-register-center.png)

#### 功能

 - 实现共享变量,同步配置等通信问题
* 最终一致性
* 可靠性
* 实时性
* 等待无关
* 原子性
* 顺序性


[便捷启动脚本](https://github.com/95hx/kafka-demo/tree/master/z-resource/script/windows)


