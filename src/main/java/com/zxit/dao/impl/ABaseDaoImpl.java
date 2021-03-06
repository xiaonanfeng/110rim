package com.zxit.dao.impl;


import com.zxit.dao.ABaseDao;
import org.hibernate.*;
import org.hibernate.hql.internal.ast.QueryTranslatorImpl;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.sql.Clob;
import java.util.*;

@Repository("aBaseDao")
public class ABaseDaoImpl implements ABaseDao {

    @Resource
    protected SessionFactory sessionFactory;



    @SuppressWarnings("unchecked")
    @Override
    public <T> T findById(Class<T> type, Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(type, id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findAll(Class<T> type) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from " + type.getSimpleName()).list();
    }

    @Override
    public Query findByHQL(String hql) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(hql);
    }


    @Override
    public int findTotalByHQL(String hql) {
        Number num = null;
        try {
            hql = "select count(1) " + hql;
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery(hql);
            num = (Number) query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
        }
        return num.intValue();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findWithPager(Class<T> type, String hql, int startNum, int pageTotal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query.setFirstResult(startNum);
        query.setMaxResults(pageTotal);
        return query.list();
    }

    @Override
    public <T> List<T> findWithSQLPager(Class<T> type, String sql, int startNum, int pageTotal) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery query = session.createSQLQuery(sql).addEntity(type);
        query.setFirstResult(startNum);
        query.setMaxResults(pageTotal);
        return query.list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> findWithPagerAndCollections(Class<T> type, String hql, Map<String, Object> map, int startNum, int pageTotal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        query = this.setParameter(query, map);//调用集合查询
        query.setFirstResult(startNum);
        query.setMaxResults(pageTotal);
        return query.list();
    }

    private Query setParameter(Query query, Map<String, Object> map) {
        if (map != null && map.size() != 0) {
            Set<String> keySet = map.keySet();
            for (String string : keySet) {
                Object obj = map.get(string);
                //考虑传入的参数是什么类型，不同类型使用的方法不同  
                if (obj instanceof Collection<?>) {
                    query.setParameterList(string, (Collection<?>) obj);
                } else if (obj instanceof Object[]) {
                    query.setParameterList(string, (Object[]) obj);
                } else {
                    query.setParameter(string, obj);
                }
            }
        }
        return query;
    }

    @Override
    public SQLQuery findBySQL(String sql) {
        Session session = sessionFactory.getCurrentSession();
        SQLQuery sqlQuery = session.createSQLQuery(sql);
        return sqlQuery;
    }

    @Override
    public int findTotalBySQL(String sql) {
        Session session = sessionFactory.getCurrentSession();
        String countSQL = "select count(1) from (" + sql + ")";
        SQLQuery query = session.createSQLQuery(countSQL);
        Number num = (Number) query.uniqueResult();
        return num.intValue();
    }

    @Override
    public void save(Object... entities) {
        int i = 1;
        for (Object entity : entities) {
            i++;
            Session session = sessionFactory.getCurrentSession();
            try {
                session.saveOrUpdate(entity);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
    }


    @Override
    public void merge(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.merge(entity);
    }

    @Override
    public void saveOrUpdate(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        //session.saveOrUpdate(entity);
        session.merge(entity);
    }

    @Override
    public void updateObjects(Object... entities) {
        try {
            int i = 1;
            Session session = sessionFactory.getCurrentSession();
            for (Object entity : entities) {
                i++;
                session.update(entity);
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void update(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
    }


    @Override
    public void refresh(Object... entities) {
        Session session = sessionFactory.getCurrentSession();
        session.refresh(entities);
    }

    @Override
    public void flush() {
        Session session = sessionFactory.getCurrentSession();
        session.flush();
    }

    @Override
    public void clear() {
        Session session = sessionFactory.getCurrentSession();
        session.clear();
    }

    @Override
    public Clob createClob(String str) {
        Session session = sessionFactory.getCurrentSession();
        LobHelper lobHelper = session.getLobHelper();
        Clob clob = lobHelper.createClob(str);
        return clob;
    }

    @Override
    public void delete(Object... entities) {
        int i = 1;
        Session session = sessionFactory.getCurrentSession();
        for (Object entity : entities) {
            i++;
            if (entity != null) {
                session.delete(entity);
                if (i % 20 == 0) {
                    session.flush();
                    session.clear();
                }
            }
        }
    }

    @Override
    public void deleteById(Class<?> type, Serializable id) {
        if (id == null) {
            return;
        }
        Object entity = findById(type, id);
        if (entity == null) {
            return;
        }
        delete(entity);
    }

    @Override
    public Criteria createCriteria(Class<?> type) {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(type);
    }

    @Override
    public String transHqlToSQL(String hql) {
        if (hql == null || "".equals(hql)) {
            return "";
        }
        SessionFactoryImpl sfi = (SessionFactoryImpl) sessionFactory;
        QueryTranslatorImpl queryTranslator = new QueryTranslatorImpl(hql, hql, Collections.EMPTY_MAP, sfi);
        queryTranslator.compile(Collections.EMPTY_MAP, false);
        String sql = queryTranslator.getSQLString();
        return sql;
    }

    @Override
    public List query(String hql, List condition) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        if(condition != null && condition.size() > 0) {
            for(int i = 0; i < condition.size(); i++) {
                query.setParameter(i,condition.get(i));
            }
        }
        return query.list();
    }

    /**
     * 根据表和字段获取中文注释
     * @param tableName
     * @param colName
     * @return
     */
    @Override
    public String findDBCreateSQL(String tableName, String colName) {
        String str = "";
        String sql = "";
        try {
            sql = "select comments from ( select replace(column_name,'_','') as colname ,comments,replace(Table_Name,'_','') as tablename from user_col_comments )"
                    + "where tablename = '"
                    + tableName.toUpperCase()
                    + "'  and colname = '" + colName.toUpperCase() + "' ";
            str = this.findBySQL(sql).uniqueResult().toString();
        } catch (Exception e) {
            System.out.println(sql);
            return "<font color='red' title='" + tableName + ":" + colName + "'>这可能是个错误！</red>";
        }
        return str;
    }

}
