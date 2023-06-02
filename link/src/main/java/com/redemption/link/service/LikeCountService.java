package com.redemption.link.service;

import java.util.List;
import java.util.Map;

public interface LikeCountService {


    String addLikeCountByRedis(String id);

    Map<Long, String> getLikeCountsById(List<Long> ids);

}
