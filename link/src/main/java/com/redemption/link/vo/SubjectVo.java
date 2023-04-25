package com.redemption.link.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.redemption.link.entity.Link;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 分组
 * </p>
 *
 * @author axw
 * @since 2023-04-18
 */
@Getter
@Setter
@Schema(description = "分组Vo")
public class SubjectVo implements Serializable {

    private Long id;

    @Schema(description = "名称（限制4字）")
    @Size(min = 1, max = 8, message = "长度不超过4个字")
    private String subjectName;

    @Schema(description = "图片")
    private String subjectPicture;

    @Schema(description = "说明")
    private String subjectExplain;

    @Schema(description = "链接list")
    private IPage<LinkVo> linkIPage;
}
