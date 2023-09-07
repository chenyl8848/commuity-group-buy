package com.cyl.groupbuy.model.vo.product;

import com.cyl.groupbuy.model.entity.product.SkuAttrValue;
import com.cyl.groupbuy.model.entity.product.SkuImage;
import com.cyl.groupbuy.model.entity.product.SkuInfo;
import com.cyl.groupbuy.model.entity.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SkuInfoVo extends SkuInfo {

	@ApiModelProperty(value = "海报列表")
	private List<SkuPoster> skuPosterList;

	@ApiModelProperty(value = "属性值")
	private List<SkuAttrValue> skuAttrValueList;

	@ApiModelProperty(value = "图片")
	private List<SkuImage> skuImagesList;

}

