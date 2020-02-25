# Music Rating Program

### Author: Ian C. Hank
### Version: v0.1-alpha
### Still Updating: Yes


##### What it is supposed to be:

###### TLDR: Simple program to store and organize the rating you have given to entered songs. 
This program will allow the user to enter specific songs they just listened to and rate them. The rating system will be different
depending on the genre. The songs can be organized and kept within a structure. The structure will be able to organize and show
lists of songs within different genres.  

##### My Idea:
This was my first real project I began working on. My first project that had purpose and was not an example program to make 
online. I just wanted a simple way to store all my personal ratings of specific songs. I originally was trying to make some
thing just text based and quick for me to use with one large data structure. I think I will start with a terminal based program
and then upgrade over time. After more thought I decided to go bigger with it and improve my skills in the meantime. I will 
continue to update the program until I feel I am happy with it. 

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
