/* Name: Yue Liu
 * NetID: yliu165
 * Lab Session: TR 4:50pm - 6:05pm
 * I did not collaborate with anyone on this assignment.
 */
//VOLUMN WARNNING!!!BGM Included, please turn down the volumn.

*File Included: 
Edge.java
Graph.java
Node.java
StreetMap.java
Music.java
README.txt
Compass.jpg
Fendiman.wav
ur.txt
nys.txt
monroe.txt

*Class used:
There are only 4 classes: StreetMap extends JPanel, Edge, Node, and Graph.

*Method Used: 
* Haversine: 
Input: longitudes and latitudes of two points.
Output: the distance between two points in miles.
* getGraphInformation:
Input: document name.
Output: buffered reader to get graph information, create nodes edges, graph, and store appropriate things in map and map2.
* Dijkstra:
Input: Start intersection point name.
Output: a shorted path tree rooted at start intersection point.
* showGraph:
Input: document name.
Output: The basic map.
* paintComponent (the sub-method of showGraph):
Input: showGraph.
Output: the map graph.


*Obstacles: 
Initially, I used a adjacency matrix, it takes too much memory and only work on ur.txt. It is then decided
that a adjacency arrayList will be used. However, it does not improve by much, it eats up to 4 gigabytes of 
ram when running. It was then I realize that linkedList is the only way to go as it uses dynamic memory and 
will run just fine even under monroe.txt.

The running time is also a problem I encountered. The first time I run monroe it took more than half an hour.
So I listened to one of my fellow's advice to change all the for loops to enhanced for loops. It greatly
improved the run time.

*Implementation Choice: 
Used linkedList to tackle the memory problem I stated before.
Replaces all for loops with enhanced for loops, it is truely a lot faster.
Not using a large map because there is not enough space for all the heaps.
Not using a queue because I discovered that it is not efficient. As a priority queue spend a lot of time empty
and add back the element.
Note that typing --direction alone will only display the path, map will not be shown. 


*Runtime Analysis: 
(1)ur.txt
Find Path: 0.02 second.
Plot Graph: 0.85 second.
Total: 0.87 second.
(2)monroe.txt
Find Path: 0.8 seconds.
Plot Graph: 0.8 second.
Total: 1.60 seconds.
(3)nys.txt
Find Path: 4.82 seconds.
Plot Graph: 0.8 seconds.
Total: 5.62 seconds.
(Get Graph Information has Complexity O(|V|+|E|)
Dijkstra has Complexity O(|V|log(|E|+|V|))it searches all nodes with its neighbor edges, also relaxing
Paint Component has Complexity O(|E|) 
Other methods all have Complexity O(1) 
Therefore, the dominant term is Dijkastra O(|V|log|E|).



*Why I deserve extra credit:
1. Colorful display (I hope you find it not distracting)
2. There is a compass!
3. BGM Included, enjoy the music while you are waiting for the output.1
3. The map scales when you change size of the window. So as the Compass.

Haversine Formula
CREDIT: https://www.movable-type.co.uk/scripts/latlong.html
Music()
CREDIT: http://www.codejava.net/coding/how-to-play-back-audio-in-java-with-examples
