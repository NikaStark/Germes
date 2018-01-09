package com.germes.model.dao;

import com.germes.model.entities.Goods;

import java.util.UUID;

public interface GoodsDao<Context> extends GenericDao<Goods, UUID, Context> {
}
