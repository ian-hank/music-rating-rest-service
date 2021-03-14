# Music Rating Program

### Author: Ian C. Hank
### Version: v1.0-alpha
### Old Release is a local terminal based app!

##### More About The Project:

###### TLDR: Web App to store and organize the rating you have given to entered songs within your personal database. 
This web app is going to maintain, track, and organize the ratings given to certain songs, albums, and etc. Using Flutter and Dart to maintain the frontend, users will be able to easily see their own ratings and overall ratings. The fronend will be connected to a RESTFul Spring Boot Web API. Maven is housing all of the files and using MongoDB + Java to power the backend and maintain the database/rest service. I want the site to be fast, efficient, and data friendly.

##### My Idea:
This was my first real project I had begun to work on. I just wanted a simple way to store all my personal ratings of specific songs. I
decided this was something I could do myself easily in Java and set out to do it. I decided to start with a console based design since this was the quickest way to manipulate the TuneArray(ArrayList implementation). Since then I have finsihed that design and am working on a massive refactor to the app. Through this program I hope to learn and recieve feedback on how it could be improved. Thanks, Ian.

### Version History:
#### v0.1-alpha
First fully functional design of the program is working. When the program is run it will open the binary file containing all
your Tune objects importing them into a TuneArray(ArrayList implementation). Options for the users to manipulate their database were
added as well as full input validation. The program has a number menu based approach. Once the user is done changing things they can
save their database and exit where it will rewrite all objects to the file.
##### Options Added:
###### -Add/Remove Tunes
###### -Search for full details of a Tune
###### -Print All Tunes (Unsorted)
###### -Print All Tunes by Highest Rating First
###### -Clear All Tunes
###### -Exit and Save

#### v1.0-alpha
Beginning to refactor and set endpoints from the old Java code. The base skeleton of the backend is laid out and working properly. Using PostMan to test and try requests is working well with MongoDB and the RESTFul service. The database design still needs to be formalized and the forntend has yet to be started. A lot of the tricky steps are almost over and once the backend is done the frontend will go fast. 
