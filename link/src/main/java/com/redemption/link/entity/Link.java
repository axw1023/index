package com.redemption.link.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 链接
 * </p>
 *
 * @author axw
 * @since 2023-04-07
 */
@Getter
@Setter
@Schema(name = "Link", description = "链接")
public class Link implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    @TableId
    private Long id;

    @Schema(description = "名称")
    private String linkName;

    @Schema(description = "链接")
    private String linkUrl;

    @Schema(description = "说明")
    private String linkExplain;

    @Schema(description = "分组id")
    private Long fnSubjectId;

    @Schema(description = "点赞数")
    private String likeCount;
}
