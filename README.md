
### simplemybatis v1.0

```sequence
title: mybatis1.0执行流程

client->mySqlsession:
mySqlsession->myMapperproxy:getmapper(PersionMapper.class)
myMapperproxy->mySqlsession:selectByPrimaryKey(1)
mySqlsession->Myexecutor:selectOne.query(1)
Myexecutor->DBUtil:getconn, getpstmt, getresult
DBUtil->Myexecutor:return
Myexecutor->mySqlsession:return
mySqlsession->myMapperproxy:return
myMapperproxy->client:
```
