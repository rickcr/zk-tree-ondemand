zk-tree-ondemand
================

ZK Tree Load on Demand, Render on Demand following Bai Ben's approach http://ben-bai.blogspot.com/2013/01/zk-tree-rod-and-load-on-demand.html

RODTreeModel, RODTreeNode, and RODTreeNodeData are core classes that you can reuse across ZK projects (see link above.)

The main differences in this project are...

* It illustrated using a typical type of domain value object you might be working with (in this case a simple "Person" object.
Bai's project was great but might confuse some a bit since it's illustrating its usage with traversing a File system, versus a typical
type of crud call to just fetch your children from the DB.

* Uses a service class that you pass to the PersonRODTreeNodeData object. 
[ When setting up your own project feel free to instantiate the service class directly in PersonRODTreeNodeData and don't bother passing it 
via the constructor, but since 'in real life' I use Spring (not illustrated in
this project), I find it easier in this case to pass the service class directly vs having to look up the bean from Spring's app context 
and use Prototype scope.

## Building/Deploying

mvn clean install

move the target/zk-tree-ondemand.war file to your app server of choice and then http://localhost:8080/zk-tree-ondemand/


