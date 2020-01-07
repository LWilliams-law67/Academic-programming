# Lab 1

## Purpose
The purpose of this lab is to get hands-on experience with Github and create and submit a Hello World style application for my review.

## Github
Here is a cheatsheet of git commands that will be helpful in working with the git version control system. [Git cheatsheet](https://education.github.com/git-cheat-sheet-education.pdf)
If you haven't already created a directory on your PC for the work you'll do in this course, do so now.

* Now, go to [Lab-1]()
* Click "Accept this assignment". This will create a new private repository in Github for you to submit your work.
* Near the top right of your browser, you'll see a green "Clone or download" button.
	Click the button to copy the URL.
* Type the command `git clone URL_COPIED_ABOVE` into Git Bash (Windows) or the Terminal (Mac/Linux).
This will create a directory called lab-1-YOUR_NAME that will contain this README.md file along with a .gitignore file (whose purpose is to tell git not to commit certain files - such as executables - into the repository).

* If you haven't already configured git, do so by adding your name and email, at a minimum.
For example, type the following (substitute your details for mine):\
`git config --global user.name "Steven Bitner"`\
`git config --global user.email sbitner@uwf.edu`\
**Please use your UWF email account, not a personal one.**
**Also, please use the name that you used to register for the class.
This will allow me to properly attribute your work to you in the grade book in Canvas.**

This setup process should only have to be done once, not each time you make a repository.

_If you use git for work or other things and do not want your UWF email address (or personal name if contributing to open source under a pseudonym), then you can use the above command while inside the directory for your repository but remove the `--global` part of the command. This will set it up for that one repository only (so you'd need to remember to do it for every single lab and project)._

## Hello
[![funny hello video](https://img.youtube.com/vi/PUjvaMWKeBI/0.jpg)](https://www.youtube.com/watch?v=PUjvaMWKeBI)

Using a text editor of your choice, create a Hello World application that prints your Github handle, followed by a colon and your last name, first name in camel case.
On a new line, begin printing the numbers 1 through 100.
Each fifth number, add a new line.
Your output should look something like this:

```
sbitbot:BitnerSteven
1 2 3 4 5
6 7 8 9 10
...
96 97 98 99 100
```

**A Makefile is provided in this repository that will build an executable named `main` if your work is performed in a file called `main.cpp`.
To create the executable, type `make` at the command line.
Then, run the file named main, e.g. `./main`, or debug compiler errors if there were any.**

## "Saving" work
Once your program is working as expected, go back to your command line (or Git Bash).
Type `git status`. You should see your src directory listed as a new file.
Type `git add .`, to tell git to add your current directory to the stage.
The stage is basically a list of files (or blocks of code if using advanced features such as patches) that you intend to commit to the repository.
Now if you type `git status` again, you should see all of your individual files listed out.
Commit the files by typing `git commit`. This will open an editor window for you to add a commit message.
Commit messages should be short and should clearly state what the purpose of the commit is.

The "add, commit" process outlined above isn't something that you need to wait until your done with the whole project to do.
Much like any other aspect of programming, incremental is best.
If you add a new function and it compiles and tests successfully, go ahead and commit.
That way if you start making some changes and break your entire program, you can go back to your last "stable" code and start again, or compare via `git diff HEAD` with the last stable commit to help narrow down the bug.

## Submitting work
To post the work you've completed back to Github for me (or a TA) to review and grade, simply run `git push origin` (assuming you already committed the code locally).
For projects, which are graded against a rubric (labs will be a fairly simple check for completion), I will pull all of the repositories from Github sometime after the deadline.
If you push incomplete work to origin via `git push origin` you don't have to worry about it getting graded.
Commit and push to origin early and often each time you get a block of code working as desired.
When I pull down the code after the deadline, it will pull down the most recent version of the code not your partially completed version(s).
This is also useful if you are stuck and need my help, you can push your code to Github and I can pull it onto my machine to take a look at it.