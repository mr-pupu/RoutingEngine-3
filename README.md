## Routing Engine ##

**Implementasi Greendao ORM + ShortestPath**


**Repo Project include :**

 1. SchemaGenerator : untuk generate orm database schema (Entity + Dao) & generate data field (Node & Edge) 
 
    -> output :  src-gen & /data/schema/GraphDB-4 
 2. SchemaGeneratorCreator : untuk create android support database 
 
    -> output: data/data/id.ac.itats.skripsi.schemageneratorcreator/database/GraphDB-4 
 3. RoutingEngine : implementasi algoritma-algoritma shortestpath ( sementara masih cuma dijkstra)

**Dependencies:**

[https://github.com/skripsiandroid2013/greenDAO][1]

**Manual :**

 1. generate schema dulu pake project SchemaGenerator, 
 
    run id.ac.itats.skripsi.orm.schemagenerator.SchemaGenerator.java
 2. copy src-gen ke project SchemaGeneratorCreator, 
 
    run android project, copy GraphDB-4 ke SchemaGenerator/data/schema/
 3. isi data field graph pake project SchemaGenerator, 
 
    run id.ac.itats.skripsi.orm.dbgenerator.DBGenerator
 4. copy /data/schema/GraphDB-4 ke project RoutingEngine/asset , 
 
    run android project (hasil shortestpath masih di logcat duank, belum ke mapview)


----------


**suwon **


  [1]: https://github.com/skripsiandroid2013/greenDAO
