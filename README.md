zk-tree-ondemand
================

ZK Tree Load on Demand, Render on Demand following Bai Ben's approach http://ben-bai.blogspot.com/2013/01/zk-tree-rod-and-load-on-demand.html

RODTreeModel, RODTreeNode, and RODTreeNodeData are core classes that you can reuse across ZK projects (see link above.)

The main differences in this project are...

* It illustrated using a typical type of domain value object you might be working with (in this case a simple "Person" object.
Bai's project was great but might confuse some a bit since it's illustrating its usage with traversing a File system, versus a typical
type of crud call to just fetch your children from the DB.

* Uses a service class that you pass to the PersonRODTreeNodeData object. You could set up your own project to not take this
approach and instead use the service class instantiated directly in PersonRODTreeNodeData, but I use Spring (not illustrated in
this example), I find it easier in this case to pass the service class since the PersonRODTreeNodeData objects are created
via "new" , so rather than pull the bean from Spring's app context and use Prototype scope, I just pass the service class in.


