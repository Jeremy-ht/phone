package com.isoft.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.pojo.entity.Category;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.isoft.pojo.vo.CategoryVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;


public interface CategoryMapper extends BaseMapper<Category> {

	Page<CategoryVo> selCateList(Page<CategoryVo> page);

	@Update("update category set creator = #{state} where id = #{id}")
	int pullScenery(@Param("id") Integer id, @Param("state") Integer state);
}
