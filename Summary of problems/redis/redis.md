# Redis 基础问题总结

1.为什么使用 Redis?

项目中使用 Redis,主要是考虑性能和并发处理.如果仅仅是分布式锁,可以使用 Zookeeper 等替代方案.

**性能**

在大并发的情况下,所有的请求直接访问数据库,数据库会出现链接异常等情况,此时使用 Redis 作为一个缓存,让请求先访问到 Redis,而不是直接访问数据库.

2.使用 Redis 有什么缺点?

- 缓存和数据库双写一致性问题
- 缓存雪崩问题
- 缓存击穿问题
- 缓存的并发竞争问题

3.单线程的 Redis 为什么这么快?

- 纯内存操作
- 单线程操作,避免了频繁的上下文切换
- 采用了非阻塞 I/O多路复用机制.

4.Redis 的数据类型以及使用场景

- String一般做一些复杂技术功能的缓存（缓存json字符串）
- Hash：单点登录
- List：做简单的消息队列功能
- Set：全局去重复的功能
- SortedSet：做排行榜应用，取TopN操作；延时任务；范围查找等。

5.Redis过期策略和内存淘汰机制？

answer：Redis采用的是定期删除+惰性删除策略。

question：

> 为什么不用定时删除策略？
>
> 定期删除+惰性删除是如何工作的？
>
> 采用定期删除+惰性删除就没有其他问题了吗？

6.Redis和数据库双写一致性问题？

可以保证最终一直性，对数据有强一致性要求，不能放缓存。

7.如何应对缓存穿透和缓存雪崩问题？

**缓存穿透** ：为黑客故意去请求缓存中不存在的数据，导致所有的请求都到达数据库上，从而致使数据库连接异常。

**缓存雪崩**：为缓存在同一时间大面积的失效，这个时候来了大量的请求，结果就是都到达了数据库上，超出数据库承受力，从而导致数据库连接异常。

**思考**：如何解决这两个问题，通常有什么好的方案？