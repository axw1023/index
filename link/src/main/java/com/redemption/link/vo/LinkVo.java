package com.redemption.link.vo;

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
@Schema(description = "链接Vo")
public class LinkVo implements Serializable {

    private String id;

    @Schema(description = "名称")
    private String linkName;

    @Schema(description = "链接")
    private String linkUrl;

    @Schema(description = "说明")
    private String linkExplain;

    @Schema(description = "点赞数")
    private String likeCount;
}
