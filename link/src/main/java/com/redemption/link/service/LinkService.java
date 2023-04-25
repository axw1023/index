package com.redemption.link.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redemption.link.entity.Link;
import com.baomidou.mybatisplus.extension.service.IService;
import com.redemption.link.vo.LinkVo;
import java.util.Map;

/**
 * <p>
 * 链接 服务类
 * </p>
 *
 * @author axw
 * @since 2023-04-07
 */
public interface LinkService extends IService<Link> {

    IPage<LinkVo> linkVoPage(Page page, Map map);
}
