// @Configuration
// public class RedisConfig {

//     @Bean
//     public RedisConnectionFactory redisConnectionFactory() {
//         return new LettuceConnectionFactory();
//     }

//     @Bean
//     public RedisTemplate<String, Object> redisTemplate() {
//         RedisTemplate<String, Object> template = new RedisTemplate<>();
//         template.setConnectionFactory(redisConnectionFactory());
//         template.setKeySerializer(new StringRedisSerializer());
//         template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
//         return template;
//     }
// }
