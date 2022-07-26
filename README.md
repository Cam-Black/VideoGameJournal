# Video Game Journal

A simple journal app to allow users to track their progress in different video games and help users get back into a 
game after a break by providing easy to read summaries of their journal entries.

- [Planning](#planning)
- [Running Locally](#running-locally)

-------------------
## Planning

-------------------
## Running Locally
To get a local copy of the app up and running, you will need to have something capable of running a relational 
database.
For this project, I utilised MySQL and My SQL Workbench, which can be
[downloaded here](https://dev.mysql.com/downloads/windows/installer/8.0.html).

Once you have it downloaded, run the installer then click through until you reach this page:

![](https://i.imgur.com/oBVeGJp.png)

Then select the following options:

![](https://i.imgur.com/qbdQ7M3.png)

Click through, (it will be a mixture of next and execute buttons), until you reach the following page:

![](https://i.imgur.com/qLhP6Gm.png) 

You can use any password you want, just make sure to make a note of it so that you have it on hand and less likely 
to forget it.

Now that is all done, simply open up MySQL workbench, and it should look something like this:

![](https://imgur.com/XXc1YAs.png)

Double click on the Local Instance box and a login window should pop up:

![](https://i.imgur.com/HLAY0aX.png)

Simply enter the password that you created earlier.

Now we need to create the database to store our Journals in, let's do this by opening a new query tab like by 
navigating to File -> New Query Tab or by using the Shortcut `ctrl+T`:

![](https://i.imgur.com/5ikOGeF.png))

Now all we need to do is run the below command in the query terminal by pasting it into the empty page then hitting 
one of the lightning bolts in workbench: 
```
CREATE SCHEMA videogamejournal;
```
![](https://i.imgur.com/0NDAsRd.png)

The database is all set up and ready to go, now all that's left is to download and execute the jar file.


