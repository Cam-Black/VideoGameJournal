# Video Game Journal
Have you picked up a game and really enjoyed it, but the fickleness of life got in the way, forcing you to put it 
down for a while so that you can take care of other business? Have you ever had more than one game on the go and gotten 
confused what happened in one of them? Have you ever played an MMO and gotten so lost with the story, you forget which
characters have done what and their significance to the story?

Well fear no more, for the Video Game Journal is here. This little web-app is designed to make creating journal
entries about your favourite games easy, and help you get back into your favourite games quickly.

- [Technologies Used](#technologies-used)
- [Running Locally](#running-locally)
- [How to Use](#how-to-use)
- [Planning](#planning)
- [Future Features](#future-features)
- [Author](#author)
- [License](#license)

-------------------
## Technologies Used
For this project I utilised the following technologies:
- Git and GitHub: Version Control,
- Jira: Agile Scrum Board,
- JUnit/Mockito: Testing,
- Java/Spring: Back-End,
- HTML and CSS: Building web pages with styling,
- JavaScript: Adding interactiveness to web-pages,
- Axios: API to send requests to Java/Spring Back-End

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

The database is all set up and ready to go, now all that's left is to download and execute the jar file, which can be found [here](./VideoGameJournal-0.0.1-SNAPSHOT.jar).

Once downloaded, simply navigate to the location you downloaded the file, then open a terminal in that location, (you can use cmd by adding `.cmd` to the end of the file path: `Drive_Letter\Download_Path.cmd` or use your own preferred terminal), then execute the following command:
```
java -jar VideoGameJournal-0.0.1-SNAPSHOT.jar
```
This will now run the backend for the project, now all you need to do is navigate to https://localhost:8080 and you will be greeted with the homepage, see below.

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
To tackle this project I first developed a [MoSCoW document](Documentation/MoSCoW.md) to help decide what features to focus 
my time on to 
ensure that I was able to deliver an MVP by the deadline. This then helped me design my Jira board with User Stories 
and tasks.
From there, I was then able to create an ERD and an initial UML diagram, which can be found 
[here](/Documentation/Diagrams).

After the diagrams were generated, this allowed me to have a visual on what classes I need to build which let me 
adopt Test Driven Development, as knowing what methods were needed, allowed me to write my tests first and then 
create the methods needed to pass the tests.

This allowed me to build a solid back-end, knowing that the code is doing exactly what I expect it to do, making it 
easier to develop the project in an effective manner.

After the back-end was developed, I then moved onto the front-end, starting with a wireframe to help me visualise 
how I wanted it to look. 

Once I had an idea of how I wanted the front-end to look, I focused on developing the functionality of 
communicating between the front and back-end utilising Axios to send API requests to Spring.
Initially, I was reusing a lot of code and was handling the creation of HTML elements inside JS for the `journal.
html` page. After looking at how ineffective utilising a large amount of JS that was identical to another script, I 
was able to break the page down, creating the HTML elements inside the HTML file itself, and then used JavaScript to 
populate the elements, instead of creating them.

This led to cleaner and easier to maintain code as it became easier to read, and allowed me to create other useful 
methods without clogging up the script file. The `view.html` does still create the card elements, but this is due to 
the nature of needing an unknown number of cards generated, so cannot hard code the right number of elements on the 
page.

After developing the core functionality, I moved onto styling the pages to make them look clean and user-friendly, 
utilising Bootstrap to help with the styling, while overriding some defaults with my own custom CSS to get 
the appearance I wanted.

While using Bootstrap, I then discovered Modals, and this is where I then developed the pop-up to prevent accidental 
deletion as all end-users, at some point in there life, will mis-click buttons, (I can't tell you the amount of 
times I've clicked in the wrong place).

When it all came together, I was left with a full-stack application, allowing users to create multiple journals for 
multiple games, allowing them to store a large amount of text in the entry field.

-------------------
## Future Features

Unfortunately, due to unforeseen circumstances, I was not able to try and tackle some other features/testing I would 
have liked to try my hand at, but I will definitely be looking at implementing these features and tests. 

Here is a quick list with a brief description on what the feature/test will bring:
- SonarQube: Would allow me to analyse my code, and improve the code even further,
- Selenium: Would allow me to create automated tests for the front-end to check the front-end is working as expected,
- Relational Database: I would create further entities that would be linked together, to improve the journal system 
  from the current multiple entries that are tied to one or more games, to allow users to select an individual game, 
  and create multiple entries under that one game to make it easier to track progress made in each game,
- Create User Logins: This would allow to move the project from being a local copy only to being accessible online, 
  and users login and see their individual entries.

-------------------
## Author
[Cameron Black](https://github.com/cam-black)

-------------------
## License
<a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/"><img alt="Creative Commons License" style="border-width:0" src="https://i.creativecommons.org/l/by-nc-nd/4.0/88x31.png" /></a><br />This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a>.
