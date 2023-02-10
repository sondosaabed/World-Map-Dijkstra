# World-Map-Dijkstra
This project was done as part of algorithm course BZU. </br>
<i>"Idea. The naive implementation of Dijkstra’s algorithm examines all V vertices in the 
graph. An obvious strategy to reduce the number of vertices examined is to stop the search 
as soon as you discover the shortest path to the destination. With this approach, you can 
make the running time per shortest path query proportional to E’ log V’ where E’ and V’ 
are the number of edges and vertices examined by Dijkstra’s algorithm. However, this 
requires some care because just re-initializing all of the distances to ∞ would take time 
proportional to V. Since you are doing repeated queries, you can speed things up 
dramatically by only re-initializing those values that changed in the previous query."</i>

# input file
<p>number of countries, number of adjacens
country1, x, y
....
country1, country2, weight (distance)
....</p>

![image](https://user-images.githubusercontent.com/65151701/218069787-2241ae67-1f7c-4af3-b7e7-77d131f14bdf.png)

<p>x and y for the countries are added to a transparent fridpane as follows:</p>

![map](https://user-images.githubusercontent.com/65151701/218070657-4536a51d-a27b-4ef2-81fc-0b93172a74e8.png)

# App Screenshots:
Browse file scene:

![image](https://user-images.githubusercontent.com/65151701/218068634-61688a7c-b9c3-4ff1-b13e-fd72ef9da91c.png)

Show the map scene:

![image](https://user-images.githubusercontent.com/65151701/218068775-06d3f75d-2c75-4680-abb2-97d57d575e82.png)

Show the shortest path scene:

![image](https://user-images.githubusercontent.com/65151701/218068874-776be9f0-a016-4246-b4b2-8050f347de1e.png)
