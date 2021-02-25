package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.CategoryVo;
import org.apache.ibatis.annotations.Update;


public interface CategoryMapper extends BaseMapper<Category> {

    Page<CategoryVo> selCateList(Page<CategoryVo> page);

	@Update("update Category set creator = #{state} where id = #{id}")
	int pullScenery(Integer id, Integer state);
}
