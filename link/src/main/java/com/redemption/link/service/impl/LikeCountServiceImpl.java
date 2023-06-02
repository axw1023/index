package com.redemption.link.service.impl;

import com.redemption.link.entity.Link;
import com.redemption.link.service.LikeCountService;
import com.redemption.link.service.LinkService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class LikeCountServiceImpl implements LikeCountService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    LinkService linkService;


    @Override
    public String addLikeCountByRedis(String id) {
        String likeCount = stringRedisTemplate.opsForValue().increment(id).toString();
        //异步持久化
        updateLinkLikeCount(id, likeCount);
        return likeCount;
    }

    @Async
    public void updateLinkLikeCount(String id, String likeCount) {
        Link linkUpdate = new Link();
        linkUpdate.setId(Long.valueOf(id));
        linkUpdate.setLikeCount(likeCount);
        linkService.updateById(linkUpdate);
    }

    @Override
    public Map<Long, String> getLikeCountsById(List<Long> ids) {
//        return stringRedisTemplate.opsForValue().get(id.toString());
        List<String> keys = ids.stream().map(Object::toString).collect(Collectors.toList());
        List<String> values = stringRedisTemplate.opsForValue().multiGet(keys);

        Map<Long, String> likeCounts = new HashMap<>();
        for (int i = 0; i < ids.size(); i++) {
            Long id = ids.get(i);
            String value = values.get(i);
            likeCounts.put(id, value != null ? value : "0");
        }

        return likeCounts;
    }
}
