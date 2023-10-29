package me.kbh.javastudy.redis.configuration;

// @RequiredArgsConstructor
// @Profile("local")
// @Configuration
public class EmbeddedRedisConfig {

  /*private final RedisProperties redisProperties;

  private RedisServer redisServer;

  @PostConstruct
  public void redisServer() {
      redisServer = new RedisServer(redisProperties.getPort());
      redisServer.start();
  }

  @PreDestroy
  public void stopRedis() {
      if (redisServer != null) {
          redisServer.stop();
      }
  }*/
}
