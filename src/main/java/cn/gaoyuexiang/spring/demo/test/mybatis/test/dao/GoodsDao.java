package cn.gaoyuexiang.spring.demo.test.mybatis.test.dao;

import cn.gaoyuexiang.spring.demo.test.mybatis.test.model.Goods;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {

	List<Goods> list();

}
