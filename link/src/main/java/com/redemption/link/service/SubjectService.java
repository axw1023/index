package com.redemption.link.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.redemption.link.entity.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.redemption.link.vo.SubjectVo;
import java.util.Map;

/**
 * <p>
 * 分组 服务类
 * </p>
 *
 * @author axw
 * @since 2023-04-18
 */
public interface SubjectService extends IService<Subject> {

    IPage<SubjectVo> subjectVoPage(Page page);

}
