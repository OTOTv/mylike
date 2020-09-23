package org.mylike.controller;

import org.mylike.entity.Goods;
import org.mylike.entity.User;
import org.mylike.service.GoodsService;
import org.mylike.until.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物品
 * Created by Administrator on 2020/9/22.
 */
@RestController
@RequestMapping("/api")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @PostMapping("/goods")
    public R insertOne(Goods goods){
        goods=this.goodsService.insert(goods);
        if (null==goods) return R.fail("添加失败");
        return  R.success(goods);
    }
    @GetMapping("goods")
    public R selectOne(Integer id){
        Goods goods=this.goodsService.queryById(id);
        if (null==goods)return R.fail("没有该对象");
        return R.success(goods);
    }
    @PutMapping("goods")
    public R updateOne(Goods goods){
        goods=this.goodsService.update(goods);
        if (goods==null) return R.fail("更新失败");
        return R.success(goods);
    }
    @DeleteMapping("goods")
    public R deleteOne(Integer id){
        boolean or=this.goodsService.deleteById(id);
        if (!or) return R.fail("删除失败");
        return R.success(null);
    }

    @GetMapping("goodslist")
    public R goodsList(Integer userId){
        List<Goods> lists=this.goodsService.findByUserId(userId);
        if (null==lists)return R.fail("没有该用户");
        return R.success(lists);
    }
    @PostMapping("goodslist")
    public R listType(Integer userId,String type){
        List<Goods> lists=this.goodsService.findByType(userId,type);
        if (null==lists)return R.fail("没有该用户");
        return R.success(lists);
    }


}
