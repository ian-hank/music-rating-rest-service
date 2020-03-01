# Music Rating Program

### Author: Ian C. Hank
### Version: v0.1-alpha
### Check out the current release!

##### More About The Project:

###### TLDR: Program to store and organize the rating you have given to entered songs within your personal database. 
This program will allow the user to enter specific songs they just listened to and rate them. Unlimited number of songs may be added
allowing the user to store and organize as many as they want. The user can manipulate and change their database as they need with easy quick text input. The program will also be able to display songs in orders of ratings and genres. The rating system will be slightly complex and out of 40 total points. The program uses an Object called a Tune. A tune contains all the parts of a song that matter.
This includes the song name, album/ep/single, author, genre, length, and Rating.

##### My Idea:
This was my first real project I had begun to work on. I just wanted a simple way to store all my personal ratings of specific songs. I
decided this was something I could do myself easily in Java and set out to do it. I decided to start with a console based design since this was the quickest way to manipulate the TuneArray(ArrayList implementation). Now that I am partially through the design I plan to make it user friendly in the future. For now though I want to focus on a good efficient console design. Through this program I hope to learn and recieve feedback on how it could be improved. Thanks, Ian.

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
