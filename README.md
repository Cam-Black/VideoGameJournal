# Video Game Journal
Have you picked up a game and really enjoyed it, but the fickleness of life got in the way, forcing you to put it 
down for a while so that you can take care of other business? Have you ever had more than one game on the go and gotten 
confused what happened in one of them? Have you ever played an MMO and gotten so lost with the story, you forget which
characters have done what and their significance to the story?

Well fear no more, for the Video Game Journal is here. This little web-app is designed to make creating journal
entries about your favourite games easy, and help you get back into your favourite games quickly.

- [Running Locally](#running-locally)
- [How to Use](#how-to-use)
- [Planning](#planning)

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

-------------------

## How to Use
You will firstly land at the homepage:
![](https://i.imgur.com/OI1KWqR.png)

From here, you can simply navigate to the create page to create your first entry. To confirm you have no previous
entries, you can check the view page, and you should see an empty page.

On the create page, all you simply need to do is fill in the form on the left with the relevant information for the
game you are playing, and once you hit submit, you will then see the empty card on the right populate with the
information that you just provided:

Before:
![Before](https://i.imgur.com/xWdUV9o.png)

After:
![After](https://i.imgur.com/eutcdZJ.png)

The clear button will also remove any data in the form and refocus the cursor back at Journal Name, and if there is
already previous data on the right hand side, will also remove that as well.

Now if you navigate to the View page, you will see a card with the entry you just created:
![](https://i.imgur.com/bp86OQi.png)

If the text becomes too long in the entry, it will be cut off with `...` at the end to denote there is more text
available to be read. This can be done simply by clicking the `View` Button.
The `View` Button will also take you to a new page and allow you to update the Journal. As you can see, there is
also a delete button here, which does what it says on the tin, but will provide a pop-up to confirm that you want to
delete the entry in the eventuality you mis-click the button.

After clikcing the `View` button, you will be redirected here:
![](https://i.imgur.com/k3Qy6pX.png)

All the text in the white boxes can be updated and allows you to view a single journal in its entirety and, as
mentioned before, also has the ability to allow you to delete the whole entry if you so wish, again with a popup to
ensure it was not a mis-click.

The save button becomes active whenever a change is made.

-------------------
## Planning