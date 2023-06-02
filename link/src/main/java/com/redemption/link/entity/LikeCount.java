package com.redemption.link.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LikeCount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "id")
    private Long linkId;
    @Schema(description = "点赞数")
    private Integer likeCount;
}
