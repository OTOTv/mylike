package org.mylike.service.impl;

import org.mylike.dao.GoodsDao;
import org.mylike.dao.UserDao;
import org.mylike.entity.Goods;
import org.mylike.entity.User;
import org.mylike.service.GoodsService;
import org.mylike.until.Times;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * (Goods)表服务实现类
 *
 * @author makejava
 * @since 2020-09-22 22:09:17
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsDao goodsDao;
    @Autowired
    private UserDao userDao;

    /**
     * 通过类型来查询
     * @param userId 用户ID
     * @param type 类型
     * @return 同类型集合
     */
    @Override
    public List<Goods> findByType(Integer userId, String type) {
        User user=this.userDao.queryById(userId);
        if (null==user)return null;
        List<Goods> lists=this.goodsDao.queryByUserIdAndType(userId,type);
        return lists;
    }

    /**
     * 查询用户添加的所有集合
     * @param userId 用户Id
     * @return 用户所有添加集合
     */
    @Override
    public List<Goods> findByUserId(Integer userId) {
        List<Goods> list=this.goodsDao.queryByUserId(userId);
        if (null==list||list.size()==0)return null;
        return list;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Goods queryById(Integer id) {
        return this.goodsDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Goods> queryAllByLimit(int offset, int limit) {
        return this.goodsDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods insert(Goods goods) {
        User user=this.userDao.queryById(goods.getUserId());
        if (null==user)return null;
        goods.setCreatTime(Times.dateTosql(new Date()));
        this.goodsDao.insert(goods);
        return goods;
    }

    /**
     * 修改数据
     *
     * @param goods 实例对象
     * @return 实例对象
     */
    @Override
    public Goods update(Goods goods) {
        User user=this.userDao.queryById(goods.getUserId());
        if (null==user)return null;
        this.goodsDao.update(goods);
        return this.queryById(goods.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.goodsDao.deleteById(id) > 0;
    }
}