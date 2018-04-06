create or replace view v_query_jcjb_cjb as
select
b.guid,a.guid as j_guid,a.jjh,b.jjh as c_jjh,a.bjxs,a.bjdh,a.bjhm,a.tlx,a.jjth,a.zby,a.sjdh,a.sjzby,a.ssdwbh,a.bjsj,a.jjsj,a.gjsj,a.cjsj,a.ddsj,a.bjrxm,a.bjrxb,a.bjrlxdh,a.fadz,a.ssxq,a.ajlx,a.ajxz,a.xzfl,a.xzxl,a.ywlx,a.jjzy,a.cjbz,a.hjlsh,a.ajrz,a.hgrz,
b.dwbh,b.cjdw,b.sldw,b.qy,b.zt,b.pfsj,b.slr,b.slsj,b.cjr,b.ddxcsj,b.hgr,b.hgsj,b.cjjg,b.fasj,b.ajlx as c_ajlx,b.ajxz as c_ajxz,b.xzfl as c_xzfl,b.xzxl as c_xzxl,b.cfbj,b.gxdw,b.gxdwbh,b.gxbq
from jcjb a,cjb b
where a.jjh = b.jjh;