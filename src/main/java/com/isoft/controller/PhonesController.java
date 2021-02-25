package com.isoft.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.isoft.dao.CategoryMapper;
import com.isoft.dao.FlowersMapper;
import com.isoft.dao.PhonesMapper;
import com.isoft.pojo.entity.Category;
import com.isoft.pojo.entity.Flowers;
import com.isoft.pojo.entity.Phones;
import com.isoft.pojo.vo.FlowersVo;
import com.isoft.pojo.vo.PhonesVo;
import com.isoft.service.CategoryService;
import com.isoft.service.FlowersService;
import com.isoft.service.PhonesService;
import com.isoft.utils.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ${author}
 */
@Controller
@RequestMapping("/phones")
public class PhonesController {

	@Autowired
	private PhonesService phonesService;
	@Autowired
	private PhonesMapper phonesMapper;

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoryMapper categoryMapper;


	/**
	 * 添加
	 */
	@PostMapping("/addScenery")
	public ResponseData addScenery(@RequestBody Phones phones ) {
		return phonesService.save(phones) ? ResponseData.success().message("添加成功！")
				: ResponseData.error().message("添加失败!");
	}

	/**
	 * 删除0 下架3 上架1
	 */
	@GetMapping("/pullScenery/{id}/{state}")
	public ResponseData delScenery(@PathVariable("id") Integer id,
								   @PathVariable("state") Integer state) {

		if (id == null) {
			return ResponseData.error().message("参数不能为空");
		}

		return phonesMapper.pullScenery(id, state) == 1 ? ResponseData.success().message("成功！")
				: ResponseData.error().message("失败!");
	}

	/**
	 * @param pagenum    分页 + 分类 获取
	 * @param pagesize   分页 + 分类 获取
	 * @param categoryId 0-获取全部分类
	 */
	@GetMapping("/getSceneryList/{categoryId}")
	public ResponseData getSceneryList(@RequestParam(name = "pagenum", defaultValue = "1", required = false) long pagenum,
									   @RequestParam(name = "pagesize", defaultValue = "10", required = false) long pagesize,
									   @PathVariable("categoryId") Integer categoryId) {

		Page<PhonesVo> page = phonesService.getSceneryList(pagenum, pagesize, categoryId);
		if (page != null) {
			Map<String, Object> map = new HashMap<>();
			map.put("total", page.getTotal());
			map.put("data", page.getRecords());
			return ResponseData.success().message("获取成功！").data(map);
		}
		return ResponseData.error().message("获取失败！");
	}

	/**
	 * 首页四张图片获取
	 */
	@GetMapping("/getFourIcon")
	public ResponseData getFourIcon() {

		List<PhonesVo> li1 = phonesMapper.getFourIcon();
		return ResponseData.success().message("获取数据成功！").data("data", li1);
	}


	/**
	 * 首页三大分类获取
	 */
	@GetMapping("/getSceneryIndex")
	public ResponseData getSceneryIndex() {

		List<Category> list = categoryService.list(new QueryWrapper<Category>().eq("creator", 1)
				.eq("state", 1));

		Map<String, List<Phones>> map = new HashMap<>();

		for (Category category : list) {
			Integer id = category.getId();

			List<Phones> l = phonesService.list(new QueryWrapper<Phones>().eq("state", 1)
					.eq("categoryid", id).orderByDesc("creatime"));

			map.put(category.getCategoryname(), l);
		}

		return ResponseData.success().message("获取数据成功！").data("data", map);
	}


	/**
	 * 获取详情
	 */
	@GetMapping("/getSceneryInfo/{id}")
	public ResponseData getPhoneInfo(@PathVariable("id") Integer id) {
		return phonesService.getSceneryInfo(id);
	}


	/**
	 * 获取分类名称
	 */
	@GetMapping("/getSceneryListByCate/{id}")
	public ResponseData getSceneryListByCate(@PathVariable("id") Integer id) {
		String name = phonesMapper.getSceneryListByCate(id);
		return ResponseData.success().message("获取数据成功！").data("data", name);
	}


}

